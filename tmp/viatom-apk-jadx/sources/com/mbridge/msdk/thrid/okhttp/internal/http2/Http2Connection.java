package com.mbridge.msdk.thrid.okhttp.internal.http2;

import androidx.window.layout.c;
import com.mbridge.msdk.thrid.okhttp.Protocol;
import com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader;
import com.mbridge.msdk.thrid.okhttp.internal.platform.Platform;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSink;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import com.mbridge.msdk.thrid.okio.ByteString;
import com.mbridge.msdk.thrid.okio.Okio;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class Http2Connection implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int AWAIT_PING = 3;
    static final int DEGRADED_PING = 2;
    static final long DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    static final int INTERVAL_PING = 1;
    static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private static final ExecutorService listenerExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));
    long bytesLeftInWriteWindow;
    final boolean client;
    final Set<Integer> currentPushRequests;
    final String hostname;
    int lastGoodStreamId;
    final Listener listener;
    int nextStreamId;
    final Settings peerSettings;
    private final ExecutorService pushExecutor;
    final PushObserver pushObserver;
    final ReaderRunnable readerRunnable;
    private boolean shutdown;
    final Socket socket;
    final Http2Writer writer;
    private final ScheduledExecutorService writerExecutor;
    final Map<Integer, Http2Stream> streams = new LinkedHashMap();
    private long intervalPingsSent = 0;
    private long intervalPongsReceived = 0;
    private long degradedPingsSent = 0;
    private long degradedPongsReceived = 0;
    private long awaitPingsSent = 0;
    private long awaitPongsReceived = 0;
    private long degradedPongDeadlineNs = 0;
    long unacknowledgedBytesRead = 0;
    Settings okHttpSettings = new Settings();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class IntervalPingRunnable extends NamedRunnable {
        public IntervalPingRunnable() {
            super("OkHttp %s ping", Http2Connection.this.hostname);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
        public void execute() {
            boolean z9;
            synchronized (Http2Connection.this) {
                if (Http2Connection.this.intervalPongsReceived < Http2Connection.this.intervalPingsSent) {
                    z9 = true;
                } else {
                    Http2Connection.access$208(Http2Connection.this);
                    z9 = false;
                }
            }
            Http2Connection http2Connection = Http2Connection.this;
            if (z9) {
                http2Connection.failConnection();
            } else {
                http2Connection.writePing(false, 1, 0);
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class PingRunnable extends NamedRunnable {
        final int payload1;
        final int payload2;
        final boolean reply;

        public PingRunnable(boolean z9, int i10, int i11) {
            super("OkHttp %s ping %08x%08x", Http2Connection.this.hostname, Integer.valueOf(i10), Integer.valueOf(i11));
            this.reply = z9;
            this.payload1 = i10;
            this.payload2 = i11;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
        public void execute() {
            Http2Connection.this.writePing(this.reply, this.payload1, this.payload2);
        }
    }

    public Http2Connection(Builder builder) {
        Settings settings = new Settings();
        this.peerSettings = settings;
        this.currentPushRequests = new LinkedHashSet();
        this.pushObserver = builder.pushObserver;
        boolean z9 = builder.client;
        this.client = z9;
        this.listener = builder.listener;
        int i10 = z9 ? 1 : 2;
        this.nextStreamId = i10;
        if (z9) {
            this.nextStreamId = i10 + 2;
        }
        if (z9) {
            this.okHttpSettings.set(7, 16777216);
        }
        String str = builder.hostname;
        this.hostname = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", str), false));
        this.writerExecutor = scheduledThreadPoolExecutor;
        if (builder.pingIntervalMillis != 0) {
            IntervalPingRunnable intervalPingRunnable = new IntervalPingRunnable();
            int i11 = builder.pingIntervalMillis;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(intervalPingRunnable, i11, i11, TimeUnit.MILLISECONDS);
        }
        this.pushExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", str), true));
        settings.set(7, 65535);
        settings.set(5, 16384);
        this.bytesLeftInWriteWindow = settings.getInitialWindowSize();
        this.socket = builder.socket;
        this.writer = new Http2Writer(builder.sink, z9);
        this.readerRunnable = new ReaderRunnable(new Http2Reader(builder.source, z9));
    }

    public static /* synthetic */ long access$108(Http2Connection http2Connection) {
        long j10 = http2Connection.intervalPongsReceived;
        http2Connection.intervalPongsReceived = 1 + j10;
        return j10;
    }

    public static /* synthetic */ long access$208(Http2Connection http2Connection) {
        long j10 = http2Connection.intervalPingsSent;
        http2Connection.intervalPingsSent = 1 + j10;
        return j10;
    }

    public static /* synthetic */ long access$608(Http2Connection http2Connection) {
        long j10 = http2Connection.degradedPongsReceived;
        http2Connection.degradedPongsReceived = 1 + j10;
        return j10;
    }

    public static /* synthetic */ long access$708(Http2Connection http2Connection) {
        long j10 = http2Connection.awaitPongsReceived;
        http2Connection.awaitPongsReceived = 1 + j10;
        return j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failConnection() {
        try {
            ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
            close(errorCode, errorCode);
        } catch (IOException unused) {
        }
    }

    private Http2Stream newStream(int i10, List<Header> list, boolean z9) throws Throwable {
        Throwable th;
        boolean z10 = !z9;
        synchronized (this.writer) {
            try {
                try {
                    try {
                        synchronized (this) {
                            try {
                                if (this.nextStreamId > 1073741823) {
                                    try {
                                        shutdown(ErrorCode.REFUSED_STREAM);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        throw th;
                                    }
                                }
                                if (this.shutdown) {
                                    throw new ConnectionShutdownException();
                                }
                                int i11 = this.nextStreamId;
                                this.nextStreamId = i11 + 2;
                                Http2Stream http2Stream = new Http2Stream(i11, this, z10, false, null);
                                boolean z11 = !z9 || this.bytesLeftInWriteWindow == 0 || http2Stream.bytesLeftInWriteWindow == 0;
                                if (http2Stream.isOpen()) {
                                    this.streams.put(Integer.valueOf(i11), http2Stream);
                                }
                                if (i10 == 0) {
                                    this.writer.synStream(z10, i11, i10, list);
                                } else {
                                    if (this.client) {
                                        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                                    }
                                    this.writer.pushPromise(i10, i11, list);
                                }
                                if (z11) {
                                    this.writer.flush();
                                }
                                return http2Stream;
                            } catch (Throwable th3) {
                                th = th3;
                                th = th;
                                throw th;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    private synchronized void pushExecutorExecute(NamedRunnable namedRunnable) {
        if (!this.shutdown) {
            this.pushExecutor.execute(namedRunnable);
        }
    }

    public synchronized void awaitPong() throws InterruptedException {
        while (this.awaitPongsReceived < this.awaitPingsSent) {
            wait();
        }
    }

    public void close(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        Http2Stream[] http2StreamArr = null;
        try {
            shutdown(errorCode);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            try {
                if (!this.streams.isEmpty()) {
                    http2StreamArr = (Http2Stream[]) this.streams.values().toArray(new Http2Stream[this.streams.size()]);
                    this.streams.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.close(errorCode2);
                } catch (IOException e3) {
                    if (e != null) {
                        e = e3;
                    }
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException e7) {
            if (e == null) {
                e = e7;
            }
        }
        try {
            this.socket.close();
        } catch (IOException e10) {
            e = e10;
        }
        this.writerExecutor.shutdown();
        this.pushExecutor.shutdown();
        if (e != null) {
            throw e;
        }
    }

    public void flush() throws IOException {
        this.writer.flush();
    }

    public Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    public synchronized Http2Stream getStream(int i10) {
        return this.streams.get(Integer.valueOf(i10));
    }

    public synchronized boolean isHealthy(long j10) {
        if (this.shutdown) {
            return false;
        }
        if (this.degradedPongsReceived < this.degradedPingsSent) {
            if (j10 >= this.degradedPongDeadlineNs) {
                return false;
            }
        }
        return true;
    }

    public synchronized int maxConcurrentStreams() {
        return this.peerSettings.getMaxConcurrentStreams(Integer.MAX_VALUE);
    }

    public synchronized int openStreamCount() {
        return this.streams.size();
    }

    public void pushDataLater(final int i10, BufferedSource bufferedSource, final int i11, final boolean z9) throws IOException {
        final Buffer buffer = new Buffer();
        long j10 = i11;
        bufferedSource.require(j10);
        bufferedSource.read(buffer, j10);
        if (buffer.size() == j10) {
            pushExecutorExecute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.hostname, Integer.valueOf(i10)}) { // from class: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.6
                @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
                public void execute() {
                    try {
                        boolean zOnData = Http2Connection.this.pushObserver.onData(i10, buffer, i11, z9);
                        if (zOnData) {
                            Http2Connection.this.writer.rstStream(i10, ErrorCode.CANCEL);
                        }
                        if (zOnData || z9) {
                            synchronized (Http2Connection.this) {
                                Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i10));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(buffer.size() + " != " + i11);
    }

    public void pushHeadersLater(final int i10, final List<Header> list, final boolean z9) {
        try {
            try {
                pushExecutorExecute(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.hostname, Integer.valueOf(i10)}) { // from class: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.5
                    @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
                    public void execute() {
                        boolean zOnHeaders = Http2Connection.this.pushObserver.onHeaders(i10, list, z9);
                        if (zOnHeaders) {
                            try {
                                Http2Connection.this.writer.rstStream(i10, ErrorCode.CANCEL);
                            } catch (IOException unused) {
                                return;
                            }
                        }
                        if (zOnHeaders || z9) {
                            synchronized (Http2Connection.this) {
                                Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i10));
                            }
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        } catch (RejectedExecutionException unused2) {
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:23:0x0046
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public void pushRequestLater(final int r9, final java.util.List<com.mbridge.msdk.thrid.okhttp.internal.http2.Header> r10) throws java.lang.Throwable {
        /*
            r8 = this;
            monitor-enter(r8)
            java.util.Set<java.lang.Integer> r0 = r8.currentPushRequests     // Catch: java.lang.Throwable -> L41
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L41
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto L18
            com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode r10 = com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode.PROTOCOL_ERROR     // Catch: java.lang.Throwable -> L14
            r8.writeSynResetLater(r9, r10)     // Catch: java.lang.Throwable -> L14
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L14
            return
        L14:
            r0 = move-exception
            r9 = r0
            r3 = r8
            goto L44
        L18:
            java.util.Set<java.lang.Integer> r0 = r8.currentPushRequests     // Catch: java.lang.Throwable -> L41
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L41
            r0.add(r1)     // Catch: java.lang.Throwable -> L41
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L41
            com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection$4 r2 = new com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection$4     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            java.lang.String r4 = "OkHttp %s Push Request[%s]"
            java.lang.String r0 = r8.hostname     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            r3 = 2
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            r3 = 0
            r5[r3] = r0     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            r0 = 1
            r5[r0] = r1     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            r3 = r8
            r6 = r9
            r7 = r10
            r2.<init>(r4, r5)     // Catch: java.util.concurrent.RejectedExecutionException -> L40
            r8.pushExecutorExecute(r2)     // Catch: java.util.concurrent.RejectedExecutionException -> L40
            return
        L3f:
            r3 = r8
        L40:
            return
        L41:
            r0 = move-exception
            r3 = r8
        L43:
            r9 = r0
        L44:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L46
            throw r9
        L46:
            r0 = move-exception
            goto L43
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.pushRequestLater(int, java.util.List):void");
    }

    public void pushResetLater(final int i10, final ErrorCode errorCode) {
        pushExecutorExecute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.hostname, Integer.valueOf(i10)}) { // from class: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.7
            @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
            public void execute() {
                Http2Connection.this.pushObserver.onReset(i10, errorCode);
                synchronized (Http2Connection.this) {
                    Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i10));
                }
            }
        });
    }

    public Http2Stream pushStream(int i10, List<Header> list, boolean z9) throws IOException {
        if (!this.client) {
            return newStream(i10, list, z9);
        }
        c.g("Client cannot push requests.");
        return null;
    }

    public boolean pushedStream(int i10) {
        return i10 != 0 && (i10 & 1) == 0;
    }

    public synchronized Http2Stream removeStream(int i10) {
        Http2Stream http2StreamRemove;
        http2StreamRemove = this.streams.remove(Integer.valueOf(i10));
        notifyAll();
        return http2StreamRemove;
    }

    public void sendDegradedPingLater() {
        synchronized (this) {
            try {
                long j10 = this.degradedPongsReceived;
                long j11 = this.degradedPingsSent;
                if (j10 < j11) {
                    return;
                }
                this.degradedPingsSent = j11 + 1;
                this.degradedPongDeadlineNs = System.nanoTime() + 1000000000;
                try {
                    this.writerExecutor.execute(new NamedRunnable("OkHttp %s ping", this.hostname) { // from class: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.3
                        @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
                        public void execute() {
                            Http2Connection.this.writePing(false, 2, 0);
                        }
                    });
                } catch (RejectedExecutionException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setSettings(Settings settings) throws IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (this.shutdown) {
                    throw new ConnectionShutdownException();
                }
                this.okHttpSettings.merge(settings);
            }
            this.writer.settings(settings);
        }
    }

    public void shutdown(ErrorCode errorCode) throws IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (this.shutdown) {
                    return;
                }
                this.shutdown = true;
                this.writer.goAway(this.lastGoodStreamId, errorCode, Util.EMPTY_BYTE_ARRAY);
            }
        }
    }

    public void start(boolean z9) throws IOException {
        if (z9) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            if (this.okHttpSettings.getInitialWindowSize() != 65535) {
                this.writer.windowUpdate(0, r5 - 65535);
            }
        }
        new Thread(this.readerRunnable).start();
    }

    public synchronized void updateConnectionFlowControl(long j10) {
        long j11 = this.unacknowledgedBytesRead + j10;
        this.unacknowledgedBytesRead = j11;
        if (j11 >= this.okHttpSettings.getInitialWindowSize() / 2) {
            writeWindowUpdateLater(0, this.unacknowledgedBytesRead);
            this.unacknowledgedBytesRead = 0L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r4), r8.writer.maxDataLength());
        r6 = r2;
        r8.bytesLeftInWriteWindow -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void writeData(int r9, boolean r10, com.mbridge.msdk.thrid.okio.Buffer r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Writer r12 = r8.writer
            r12.data(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L67
            monitor-enter(r8)
        L12:
            long r4 = r8.bytesLeftInWriteWindow     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 > 0) goto L32
            java.util.Map<java.lang.Integer, com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream> r2 = r8.streams     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            if (r2 == 0) goto L2a
            r8.wait()     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            goto L12
        L28:
            r9 = move-exception
            goto L65
        L2a:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            throw r9     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
        L32:
            long r4 = java.lang.Math.min(r12, r4)     // Catch: java.lang.Throwable -> L28
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L28
            com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Writer r4 = r8.writer     // Catch: java.lang.Throwable -> L28
            int r4 = r4.maxDataLength()     // Catch: java.lang.Throwable -> L28
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L28
            long r4 = r8.bytesLeftInWriteWindow     // Catch: java.lang.Throwable -> L28
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L28
            long r4 = r4 - r6
            r8.bytesLeftInWriteWindow = r4     // Catch: java.lang.Throwable -> L28
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            long r12 = r12 - r6
            com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Writer r4 = r8.writer
            if (r10 == 0) goto L53
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L53
            r5 = 1
            goto L54
        L53:
            r5 = r3
        L54:
            r4.data(r5, r9, r11, r2)
            goto Ld
        L58:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L28
            r9.interrupt()     // Catch: java.lang.Throwable -> L28
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L28
            r9.<init>()     // Catch: java.lang.Throwable -> L28
            throw r9     // Catch: java.lang.Throwable -> L28
        L65:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            throw r9
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.writeData(int, boolean, com.mbridge.msdk.thrid.okio.Buffer, long):void");
    }

    public void writePing() {
        synchronized (this) {
            this.awaitPingsSent++;
        }
        writePing(false, 3, 1330343787);
    }

    public void writePingAndAwaitPong() throws InterruptedException {
        writePing();
        awaitPong();
    }

    public void writeSynReply(int i10, boolean z9, List<Header> list) throws IOException {
        this.writer.synReply(z9, i10, list);
    }

    public void writeSynReset(int i10, ErrorCode errorCode) throws IOException {
        this.writer.rstStream(i10, errorCode);
    }

    public void writeSynResetLater(final int i10, final ErrorCode errorCode) {
        try {
            this.writerExecutor.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.hostname, Integer.valueOf(i10)}) { // from class: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.1
                @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
                public void execute() {
                    try {
                        Http2Connection.this.writeSynReset(i10, errorCode);
                    } catch (IOException unused) {
                        Http2Connection.this.failConnection();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    public void writeWindowUpdateLater(final int i10, final long j10) {
        try {
            this.writerExecutor.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.hostname, Integer.valueOf(i10)}) { // from class: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.2
                @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
                public void execute() {
                    try {
                        Http2Connection.this.writer.windowUpdate(i10, j10);
                    } catch (IOException unused) {
                        Http2Connection.this.failConnection();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class ReaderRunnable extends NamedRunnable implements Http2Reader.Handler {
        final Http2Reader reader;

        public ReaderRunnable(Http2Reader http2Reader) {
            super("OkHttp %s", Http2Connection.this.hostname);
            this.reader = http2Reader;
        }

        public void applyAndAckSettings(boolean z9, Settings settings) {
            Http2Stream[] http2StreamArr;
            long j10;
            synchronized (Http2Connection.this.writer) {
                synchronized (Http2Connection.this) {
                    try {
                        int initialWindowSize = Http2Connection.this.peerSettings.getInitialWindowSize();
                        if (z9) {
                            Http2Connection.this.peerSettings.clear();
                        }
                        Http2Connection.this.peerSettings.merge(settings);
                        int initialWindowSize2 = Http2Connection.this.peerSettings.getInitialWindowSize();
                        http2StreamArr = null;
                        if (initialWindowSize2 == -1 || initialWindowSize2 == initialWindowSize) {
                            j10 = 0;
                        } else {
                            j10 = initialWindowSize2 - initialWindowSize;
                            if (!Http2Connection.this.streams.isEmpty()) {
                                http2StreamArr = (Http2Stream[]) Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
                            }
                        }
                    } finally {
                    }
                }
                try {
                    Http2Connection http2Connection = Http2Connection.this;
                    http2Connection.writer.applyAndAckSettings(http2Connection.peerSettings);
                } catch (IOException unused) {
                    Http2Connection.this.failConnection();
                }
            }
            if (http2StreamArr != null) {
                for (Http2Stream http2Stream : http2StreamArr) {
                    synchronized (http2Stream) {
                        http2Stream.addBytesToWriteWindow(j10);
                    }
                }
            }
            Http2Connection.listenerExecutor.execute(new NamedRunnable("OkHttp %s settings", Http2Connection.this.hostname) { // from class: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.ReaderRunnable.3
                @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
                public void execute() {
                    Http2Connection http2Connection2 = Http2Connection.this;
                    http2Connection2.listener.onSettings(http2Connection2);
                }
            });
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader.Handler
        public void data(boolean z9, int i10, BufferedSource bufferedSource, int i11) throws IOException {
            boolean zPushedStream = Http2Connection.this.pushedStream(i10);
            Http2Connection http2Connection = Http2Connection.this;
            if (zPushedStream) {
                http2Connection.pushDataLater(i10, bufferedSource, i11, z9);
                return;
            }
            Http2Stream stream = http2Connection.getStream(i10);
            if (stream == null) {
                Http2Connection.this.writeSynResetLater(i10, ErrorCode.PROTOCOL_ERROR);
                long j10 = i11;
                Http2Connection.this.updateConnectionFlowControl(j10);
                bufferedSource.skip(j10);
                return;
            }
            stream.receiveData(bufferedSource, i11);
            if (z9) {
                stream.receiveFin();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
        public void execute() throws Throwable {
            ErrorCode errorCode;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            try {
                try {
                    try {
                        this.reader.readConnectionPreface(this);
                        while (this.reader.nextFrame(false, this)) {
                        }
                        ErrorCode errorCode3 = ErrorCode.NO_ERROR;
                        try {
                            errorCode2 = ErrorCode.CANCEL;
                            Http2Connection.this.close(errorCode3, errorCode2);
                            errorCode = errorCode3;
                        } catch (IOException unused) {
                            errorCode2 = ErrorCode.PROTOCOL_ERROR;
                            Http2Connection http2Connection = Http2Connection.this;
                            http2Connection.close(errorCode2, errorCode2);
                            errorCode = http2Connection;
                            Util.closeQuietly(this.reader);
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            Http2Connection.this.close(errorCode, errorCode2);
                        } catch (IOException unused2) {
                        }
                        Util.closeQuietly(this.reader);
                        throw th;
                    }
                } catch (IOException unused3) {
                } catch (Throwable th2) {
                    th = th2;
                    errorCode = errorCode2;
                    Http2Connection.this.close(errorCode, errorCode2);
                    Util.closeQuietly(this.reader);
                    throw th;
                }
            } catch (IOException unused4) {
            }
            Util.closeQuietly(this.reader);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader.Handler
        public void goAway(int i10, ErrorCode errorCode, ByteString byteString) {
            Http2Stream[] http2StreamArr;
            byteString.size();
            synchronized (Http2Connection.this) {
                http2StreamArr = (Http2Stream[]) Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
                Http2Connection.this.shutdown = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i10 && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.removeStream(http2Stream.getId());
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader.Handler
        public void headers(boolean z9, int i10, int i11, List<Header> list) {
            boolean zPushedStream = Http2Connection.this.pushedStream(i10);
            Http2Connection http2Connection = Http2Connection.this;
            if (zPushedStream) {
                http2Connection.pushHeadersLater(i10, list, z9);
                return;
            }
            synchronized (http2Connection) {
                try {
                    Http2Stream stream = Http2Connection.this.getStream(i10);
                    if (stream != null) {
                        stream.receiveHeaders(list);
                        if (z9) {
                            stream.receiveFin();
                            return;
                        }
                        return;
                    }
                    if (Http2Connection.this.shutdown) {
                        return;
                    }
                    Http2Connection http2Connection2 = Http2Connection.this;
                    if (i10 <= http2Connection2.lastGoodStreamId) {
                        return;
                    }
                    if (i10 % 2 == http2Connection2.nextStreamId % 2) {
                        return;
                    }
                    final Http2Stream http2Stream = new Http2Stream(i10, Http2Connection.this, false, z9, Util.toHeaders(list));
                    Http2Connection http2Connection3 = Http2Connection.this;
                    http2Connection3.lastGoodStreamId = i10;
                    http2Connection3.streams.put(Integer.valueOf(i10), http2Stream);
                    Http2Connection.listenerExecutor.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{Http2Connection.this.hostname, Integer.valueOf(i10)}) { // from class: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.ReaderRunnable.1
                        @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
                        public void execute() {
                            try {
                                Http2Connection.this.listener.onStream(http2Stream);
                            } catch (IOException e) {
                                Platform.get().log(4, "Http2Connection.Listener failure for " + Http2Connection.this.hostname, e);
                                try {
                                    http2Stream.close(ErrorCode.PROTOCOL_ERROR);
                                } catch (IOException unused) {
                                }
                            }
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader.Handler
        public void ping(boolean z9, int i10, int i11) {
            Http2Connection http2Connection = Http2Connection.this;
            if (!z9) {
                try {
                    http2Connection.writerExecutor.execute(Http2Connection.this.new PingRunnable(true, i10, i11));
                    return;
                } catch (RejectedExecutionException unused) {
                    return;
                }
            }
            synchronized (http2Connection) {
                try {
                    if (i10 == 1) {
                        Http2Connection.access$108(Http2Connection.this);
                    } else if (i10 == 2) {
                        Http2Connection.access$608(Http2Connection.this);
                    } else if (i10 == 3) {
                        Http2Connection.access$708(Http2Connection.this);
                        Http2Connection.this.notifyAll();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader.Handler
        public void pushPromise(int i10, int i11, List<Header> list) throws Throwable {
            Http2Connection.this.pushRequestLater(i11, list);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader.Handler
        public void rstStream(int i10, ErrorCode errorCode) {
            boolean zPushedStream = Http2Connection.this.pushedStream(i10);
            Http2Connection http2Connection = Http2Connection.this;
            if (zPushedStream) {
                http2Connection.pushResetLater(i10, errorCode);
                return;
            }
            Http2Stream http2StreamRemoveStream = http2Connection.removeStream(i10);
            if (http2StreamRemoveStream != null) {
                http2StreamRemoveStream.receiveRstStream(errorCode);
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader.Handler
        public void settings(final boolean z9, final Settings settings) {
            try {
                Http2Connection.this.writerExecutor.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.hostname}) { // from class: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.ReaderRunnable.2
                    @Override // com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable
                    public void execute() {
                        ReaderRunnable.this.applyAndAckSettings(z9, settings);
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader.Handler
        public void windowUpdate(int i10, long j10) {
            Http2Connection http2Connection = Http2Connection.this;
            if (i10 == 0) {
                synchronized (http2Connection) {
                    Http2Connection http2Connection2 = Http2Connection.this;
                    http2Connection2.bytesLeftInWriteWindow += j10;
                    http2Connection2.notifyAll();
                }
                return;
            }
            Http2Stream stream = http2Connection.getStream(i10);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j10);
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader.Handler
        public void priority(int i10, int i11, int i12, boolean z9) {
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader.Handler
        public void alternateService(int i10, String str, ByteString byteString, String str2, int i11, long j10) {
        }
    }

    public void writePing(boolean z9, int i10, int i11) {
        try {
            this.writer.ping(z9, i10, i11);
        } catch (IOException unused) {
            failConnection();
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class Listener {
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() { // from class: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.Listener.1
            @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.Listener
            public void onStream(Http2Stream http2Stream) throws IOException {
                http2Stream.close(ErrorCode.REFUSED_STREAM);
            }
        };

        public abstract void onStream(Http2Stream http2Stream) throws IOException;

        public void onSettings(Http2Connection http2Connection) {
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Builder {
        boolean client;
        String hostname;
        int pingIntervalMillis;
        BufferedSink sink;
        Socket socket;
        BufferedSource source;
        Listener listener = Listener.REFUSE_INCOMING_STREAMS;
        PushObserver pushObserver = PushObserver.CANCEL;

        public Builder(boolean z9) {
            this.client = z9;
        }

        public Http2Connection build() {
            return new Http2Connection(this);
        }

        public Builder listener(Listener listener) {
            this.listener = listener;
            return this;
        }

        public Builder pingIntervalMillis(int i10) {
            this.pingIntervalMillis = i10;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver) {
            this.pushObserver = pushObserver;
            return this;
        }

        public Builder socket(Socket socket) throws IOException {
            return socket(socket, ((InetSocketAddress) socket.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(socket)), Okio.buffer(Okio.sink(socket)));
        }

        public Builder socket(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.socket = socket;
            this.hostname = str;
            this.source = bufferedSource;
            this.sink = bufferedSink;
            return this;
        }
    }

    public void start() throws IOException {
        start(true);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public Http2Stream newStream(List<Header> list, boolean z9) throws IOException {
        return newStream(0, list, z9);
    }
}

package com.mbridge.msdk.thrid.okhttp.internal.connection;

import com.mbridge.msdk.thrid.okhttp.Address;
import com.mbridge.msdk.thrid.okhttp.Call;
import com.mbridge.msdk.thrid.okhttp.ConnectionPool;
import com.mbridge.msdk.thrid.okhttp.EventListener;
import com.mbridge.msdk.thrid.okhttp.Interceptor;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import com.mbridge.msdk.thrid.okhttp.Route;
import com.mbridge.msdk.thrid.okhttp.internal.Internal;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.connection.RouteSelector;
import com.mbridge.msdk.thrid.okhttp.internal.http.HttpCodec;
import com.mbridge.msdk.thrid.okhttp.internal.http2.ConnectionShutdownException;
import com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode;
import com.mbridge.msdk.thrid.okhttp.internal.http2.StreamResetException;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class StreamAllocation {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final Address address;
    public final Call call;
    private final Object callStackTrace;
    private boolean canceled;
    private HttpCodec codec;
    private RealConnection connection;
    private final ConnectionPool connectionPool;
    public final EventListener eventListener;
    private int refusedStreamCount;
    private boolean released;
    private boolean reportedAcquired;
    private Route route;
    private RouteSelector.Selection routeSelection;
    private final RouteSelector routeSelector;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {
        public final Object callStackTrace;

        public StreamAllocationReference(StreamAllocation streamAllocation, Object obj) {
            super(streamAllocation);
            this.callStackTrace = obj;
        }
    }

    public StreamAllocation(ConnectionPool connectionPool, Address address, Call call, EventListener eventListener, Object obj) {
        this.connectionPool = connectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
        this.routeSelector = new RouteSelector(address, routeDatabase(), call, eventListener);
        this.callStackTrace = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.net.Socket deallocate(boolean r2, boolean r3, boolean r4) {
        /*
            r1 = this;
            r0 = 0
            if (r4 == 0) goto L5
            r1.codec = r0
        L5:
            r4 = 1
            if (r3 == 0) goto La
            r1.released = r4
        La:
            com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection r3 = r1.connection
            if (r3 == 0) goto L4a
            if (r2 == 0) goto L12
            r3.noNewStreams = r4
        L12:
            com.mbridge.msdk.thrid.okhttp.internal.http.HttpCodec r2 = r1.codec
            if (r2 != 0) goto L4a
            boolean r2 = r1.released
            if (r2 != 0) goto L1e
            boolean r2 = r3.noNewStreams
            if (r2 == 0) goto L4a
        L1e:
            r1.release(r3)
            com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection r2 = r1.connection
            java.util.List<java.lang.ref.Reference<com.mbridge.msdk.thrid.okhttp.internal.connection.StreamAllocation>> r2 = r2.allocations
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L46
            com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection r2 = r1.connection
            long r3 = java.lang.System.nanoTime()
            r2.idleAtNanos = r3
            com.mbridge.msdk.thrid.okhttp.internal.Internal r2 = com.mbridge.msdk.thrid.okhttp.internal.Internal.instance
            com.mbridge.msdk.thrid.okhttp.ConnectionPool r3 = r1.connectionPool
            com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection r4 = r1.connection
            boolean r2 = r2.connectionBecameIdle(r3, r4)
            if (r2 == 0) goto L46
            com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection r2 = r1.connection
            java.net.Socket r2 = r2.socket()
            goto L47
        L46:
            r2 = r0
        L47:
            r1.connection = r0
            return r2
        L4a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.connection.StreamAllocation.deallocate(boolean, boolean, boolean):java.net.Socket");
    }

    private RealConnection findConnection(int i10, int i11, int i12, int i13, boolean z9) throws Throwable {
        RealConnection realConnection;
        Socket socketReleaseIfNoNewStreams;
        RealConnection realConnection2;
        Socket socketDeduplicate;
        Route next;
        boolean z10;
        boolean z11;
        RealConnection realConnection3;
        RouteSelector.Selection selection;
        synchronized (this.connectionPool) {
            try {
                if (this.released) {
                    throw new IllegalStateException("released");
                }
                if (this.codec != null) {
                    throw new IllegalStateException("codec != null");
                }
                if (this.canceled) {
                    throw new IOException("Canceled");
                }
                realConnection = this.connection;
                socketReleaseIfNoNewStreams = releaseIfNoNewStreams();
                realConnection2 = this.connection;
                socketDeduplicate = null;
                if (realConnection2 != null) {
                    realConnection = null;
                } else {
                    realConnection2 = null;
                }
                if (!this.reportedAcquired) {
                    realConnection = null;
                }
                if (realConnection2 == null) {
                    Internal.instance.get(this.connectionPool, this.address, this, null);
                    RealConnection realConnection4 = this.connection;
                    if (realConnection4 != null) {
                        z10 = true;
                        realConnection2 = realConnection4;
                        next = null;
                    } else {
                        next = this.route;
                    }
                } else {
                    next = null;
                }
                z10 = false;
            } finally {
            }
        }
        Util.closeQuietly(socketReleaseIfNoNewStreams);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (z10) {
            this.eventListener.connectionAcquired(this.call, realConnection2);
        }
        if (realConnection2 != null) {
            this.route = this.connection.route();
            return realConnection2;
        }
        if (next != null || ((selection = this.routeSelection) != null && selection.hasNext())) {
            z11 = false;
        } else {
            this.routeSelection = this.routeSelector.next();
            z11 = true;
        }
        synchronized (this.connectionPool) {
            try {
                if (this.canceled) {
                    throw new IOException("Canceled");
                }
                if (z11) {
                    List<Route> all = this.routeSelection.getAll();
                    int size = all.size();
                    int i14 = 0;
                    while (true) {
                        if (i14 >= size) {
                            break;
                        }
                        Route route = all.get(i14);
                        Internal.instance.get(this.connectionPool, this.address, this, route);
                        RealConnection realConnection5 = this.connection;
                        if (realConnection5 != null) {
                            this.route = route;
                            z10 = true;
                            realConnection2 = realConnection5;
                            break;
                        }
                        i14++;
                    }
                }
                if (!z10) {
                    if (next == null) {
                        next = this.routeSelection.next();
                    }
                    this.route = next;
                    this.refusedStreamCount = 0;
                    realConnection2 = new RealConnection(this.connectionPool, next);
                    acquire(realConnection2, false);
                }
                realConnection3 = realConnection2;
            } finally {
            }
        }
        if (z10) {
            this.eventListener.connectionAcquired(this.call, realConnection3);
            return realConnection3;
        }
        realConnection3.connect(i10, i11, i12, i13, z9, this.call, this.eventListener);
        routeDatabase().connected(realConnection3.route());
        synchronized (this.connectionPool) {
            try {
                this.reportedAcquired = true;
                Internal.instance.put(this.connectionPool, realConnection3);
                if (realConnection3.isMultiplexed()) {
                    socketDeduplicate = Internal.instance.deduplicate(this.connectionPool, this.address, this);
                    realConnection3 = this.connection;
                }
            } finally {
            }
        }
        Util.closeQuietly(socketDeduplicate);
        this.eventListener.connectionAcquired(this.call, realConnection3);
        return realConnection3;
    }

    private RealConnection findHealthyConnection(int i10, int i11, int i12, int i13, boolean z9, boolean z10) throws Throwable {
        while (true) {
            RealConnection realConnectionFindConnection = findConnection(i10, i11, i12, i13, z9);
            boolean z11 = z9;
            int i14 = i13;
            int i15 = i12;
            int i16 = i11;
            int i17 = i10;
            synchronized (this.connectionPool) {
                try {
                    if (realConnectionFindConnection.successCount == 0 && !realConnectionFindConnection.isMultiplexed()) {
                        return realConnectionFindConnection;
                    }
                    if (realConnectionFindConnection.isHealthy(z10)) {
                        return realConnectionFindConnection;
                    }
                    noNewStreams();
                    i10 = i17;
                    i11 = i16;
                    i12 = i15;
                    i13 = i14;
                    z9 = z11;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private Socket releaseIfNoNewStreams() {
        RealConnection realConnection = this.connection;
        if (realConnection == null || !realConnection.noNewStreams) {
            return null;
        }
        return deallocate(false, false, true);
    }

    private RouteDatabase routeDatabase() {
        return Internal.instance.routeDatabase(this.connectionPool);
    }

    public void acquire(RealConnection realConnection, boolean z9) {
        if (this.connection != null) {
            u.e();
            return;
        }
        this.connection = realConnection;
        this.reportedAcquired = z9;
        realConnection.allocations.add(new StreamAllocationReference(this, this.callStackTrace));
    }

    public void cancel() throws IOException {
        HttpCodec httpCodec;
        RealConnection realConnection;
        synchronized (this.connectionPool) {
            this.canceled = true;
            httpCodec = this.codec;
            realConnection = this.connection;
        }
        if (httpCodec != null) {
            httpCodec.cancel();
        } else if (realConnection != null) {
            realConnection.cancel();
        }
    }

    public HttpCodec codec() {
        HttpCodec httpCodec;
        synchronized (this.connectionPool) {
            httpCodec = this.codec;
        }
        return httpCodec;
    }

    public synchronized RealConnection connection() {
        return this.connection;
    }

    public boolean hasMoreRoutes() {
        if (this.route != null) {
            return true;
        }
        RouteSelector.Selection selection = this.routeSelection;
        return (selection != null && selection.hasNext()) || this.routeSelector.hasNext();
    }

    public HttpCodec newStream(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z9) {
        try {
            HttpCodec httpCodecNewCodec = findHealthyConnection(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z9).newCodec(okHttpClient, chain, this);
            synchronized (this.connectionPool) {
                this.codec = httpCodecNewCodec;
            }
            return httpCodecNewCodec;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    public void noNewStreams() throws IOException {
        RealConnection realConnection;
        Socket socketDeallocate;
        synchronized (this.connectionPool) {
            realConnection = this.connection;
            socketDeallocate = deallocate(true, false, false);
            if (this.connection != null) {
                realConnection = null;
            }
        }
        Util.closeQuietly(socketDeallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
    }

    public void release() throws IOException {
        RealConnection realConnection;
        Socket socketDeallocate;
        synchronized (this.connectionPool) {
            realConnection = this.connection;
            socketDeallocate = deallocate(false, true, false);
            if (this.connection != null) {
                realConnection = null;
            }
        }
        Util.closeQuietly(socketDeallocate);
        if (realConnection != null) {
            Internal.instance.timeoutExit(this.call, null);
            this.eventListener.connectionReleased(this.call, realConnection);
            this.eventListener.callEnd(this.call);
        }
    }

    public Socket releaseAndAcquire(RealConnection realConnection) {
        if (this.codec != null || this.connection.allocations.size() != 1) {
            u.e();
            return null;
        }
        Reference<StreamAllocation> reference = this.connection.allocations.get(0);
        Socket socketDeallocate = deallocate(true, false, false);
        this.connection = realConnection;
        realConnection.allocations.add(reference);
        return socketDeallocate;
    }

    public Route route() {
        return this.route;
    }

    public void streamFailed(IOException iOException) throws IOException {
        RealConnection realConnection;
        boolean z9;
        Socket socketDeallocate;
        synchronized (this.connectionPool) {
            try {
                realConnection = null;
                if (iOException instanceof StreamResetException) {
                    ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                    if (errorCode == ErrorCode.REFUSED_STREAM) {
                        int i10 = this.refusedStreamCount + 1;
                        this.refusedStreamCount = i10;
                        if (i10 > 1) {
                            this.route = null;
                            z9 = true;
                        }
                        z9 = false;
                    } else {
                        if (errorCode != ErrorCode.CANCEL) {
                            this.route = null;
                            z9 = true;
                        }
                        z9 = false;
                    }
                } else {
                    RealConnection realConnection2 = this.connection;
                    if (realConnection2 != null && (!realConnection2.isMultiplexed() || (iOException instanceof ConnectionShutdownException))) {
                        if (this.connection.successCount == 0) {
                            Route route = this.route;
                            if (route != null && iOException != null) {
                                this.routeSelector.connectFailed(route, iOException);
                            }
                            this.route = null;
                        }
                        z9 = true;
                    }
                    z9 = false;
                }
                RealConnection realConnection3 = this.connection;
                socketDeallocate = deallocate(z9, false, true);
                if (this.connection == null && this.reportedAcquired) {
                    realConnection = realConnection3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Util.closeQuietly(socketDeallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
    }

    public void streamFinished(boolean z9, HttpCodec httpCodec, long j10, IOException iOException) {
        RealConnection realConnection;
        Socket socketDeallocate;
        boolean z10;
        this.eventListener.responseBodyEnd(this.call, j10);
        synchronized (this.connectionPool) {
            if (httpCodec != null) {
                try {
                    if (httpCodec == this.codec) {
                        if (!z9) {
                            this.connection.successCount++;
                        }
                        realConnection = this.connection;
                        socketDeallocate = deallocate(z9, false, true);
                        if (this.connection != null) {
                            realConnection = null;
                        }
                        z10 = this.released;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            throw new IllegalStateException("expected " + this.codec + " but was " + httpCodec);
        }
        Util.closeQuietly(socketDeallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (iOException != null) {
            this.eventListener.callFailed(this.call, Internal.instance.timeoutExit(this.call, iOException));
        } else if (z10) {
            Internal.instance.timeoutExit(this.call, null);
            this.eventListener.callEnd(this.call);
        }
    }

    public String toString() {
        RealConnection realConnectionConnection = connection();
        return realConnectionConnection != null ? realConnectionConnection.toString() : this.address.toString();
    }

    private void release(RealConnection realConnection) {
        int size = realConnection.allocations.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (realConnection.allocations.get(i10).get() == this) {
                realConnection.allocations.remove(i10);
                return;
            }
        }
        u.e();
    }
}

package com.mbridge.msdk.thrid.okhttp.internal.cache2;

import androidx.window.layout.c;
import com.google.gson.internal.a;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.ByteString;
import com.mbridge.msdk.thrid.okio.Source;
import com.mbridge.msdk.thrid.okio.Timeout;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    static final ByteString PREFIX_CLEAN = ByteString.encodeUtf8("OkHttp cache v1\n");
    static final ByteString PREFIX_DIRTY = ByteString.encodeUtf8("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    final long bufferMaxSize;
    boolean complete;
    RandomAccessFile file;
    private final ByteString metadata;
    int sourceCount;
    Source upstream;
    long upstreamPos;
    Thread upstreamReader;
    final Buffer upstreamBuffer = new Buffer();
    final Buffer buffer = new Buffer();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        private final Timeout timeout = new Timeout();

        public RelaySource() {
            this.fileOperator = new FileOperator(Relay.this.file.getChannel());
        }

        @Override // com.mbridge.msdk.thrid.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            synchronized (Relay.this) {
                try {
                    Relay relay = Relay.this;
                    int i10 = relay.sourceCount - 1;
                    relay.sourceCount = i10;
                    if (i10 == 0) {
                        RandomAccessFile randomAccessFile2 = relay.file;
                        relay.file = null;
                        randomAccessFile = randomAccessFile2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (randomAccessFile != null) {
                Util.closeQuietly(randomAccessFile);
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.Source
        public long read(Buffer buffer, long j10) throws IOException {
            Relay relay;
            if (this.fileOperator == null) {
                c.g("closed");
                return 0L;
            }
            synchronized (Relay.this) {
                while (true) {
                    try {
                        long j11 = this.sourcePos;
                        Relay relay2 = Relay.this;
                        long j12 = relay2.upstreamPos;
                        if (j11 != j12) {
                            long size = j12 - relay2.buffer.size();
                            long j13 = this.sourcePos;
                            if (j13 < size) {
                                long jMin = Math.min(j10, j12 - j13);
                                this.fileOperator.read(this.sourcePos + Relay.FILE_HEADER_SIZE, buffer, jMin);
                                this.sourcePos += jMin;
                                return jMin;
                            }
                            long jMin2 = Math.min(j10, j12 - j13);
                            Relay.this.buffer.copyTo(buffer, this.sourcePos - size, jMin2);
                            this.sourcePos += jMin2;
                            return jMin2;
                        }
                        if (relay2.complete) {
                            return -1L;
                        }
                        if (relay2.upstreamReader == null) {
                            relay2.upstreamReader = Thread.currentThread();
                            try {
                                Relay relay3 = Relay.this;
                                long j14 = relay3.upstream.read(relay3.upstreamBuffer, relay3.bufferMaxSize);
                                if (j14 == -1) {
                                    Relay.this.commit(j12);
                                    synchronized (Relay.this) {
                                        Relay relay4 = Relay.this;
                                        relay4.upstreamReader = null;
                                        relay4.notifyAll();
                                    }
                                    return -1L;
                                }
                                long jMin3 = Math.min(j14, j10);
                                Relay.this.upstreamBuffer.copyTo(buffer, 0L, jMin3);
                                this.sourcePos += jMin3;
                                this.fileOperator.write(j12 + Relay.FILE_HEADER_SIZE, Relay.this.upstreamBuffer.m236clone(), j14);
                                synchronized (Relay.this) {
                                    try {
                                        Relay relay5 = Relay.this;
                                        relay5.buffer.write(relay5.upstreamBuffer, j14);
                                        long size2 = Relay.this.buffer.size();
                                        Relay relay6 = Relay.this;
                                        if (size2 > relay6.bufferMaxSize) {
                                            Buffer buffer2 = relay6.buffer;
                                            buffer2.skip(buffer2.size() - Relay.this.bufferMaxSize);
                                        }
                                        relay = Relay.this;
                                        relay.upstreamPos += j14;
                                    } finally {
                                    }
                                }
                                synchronized (relay) {
                                    Relay relay7 = Relay.this;
                                    relay7.upstreamReader = null;
                                    relay7.notifyAll();
                                }
                                return jMin3;
                            } catch (Throwable th) {
                                synchronized (Relay.this) {
                                    Relay relay8 = Relay.this;
                                    relay8.upstreamReader = null;
                                    relay8.notifyAll();
                                    throw th;
                                }
                            }
                        }
                        this.timeout.waitUntilNotified(relay2);
                    } finally {
                    }
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.Source
        public Timeout timeout() {
            return this.timeout;
        }
    }

    private Relay(RandomAccessFile randomAccessFile, Source source, long j10, ByteString byteString, long j11) {
        this.file = randomAccessFile;
        this.upstream = source;
        this.complete = source == null;
        this.upstreamPos = j10;
        this.metadata = byteString;
        this.bufferMaxSize = j11;
    }

    public static Relay edit(File file, Source source, ByteString byteString, long j10) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        Relay relay = new Relay(randomAccessFile, source, 0L, byteString, j10);
        randomAccessFile.setLength(0L);
        relay.writeHeader(PREFIX_DIRTY, -1L, -1L);
        return relay;
    }

    public static Relay read(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        Buffer buffer = new Buffer();
        fileOperator.read(0L, buffer, FILE_HEADER_SIZE);
        if (!buffer.readByteString(r10.size()).equals(PREFIX_CLEAN)) {
            a.m("unreadable cache file");
            return null;
        }
        long j10 = buffer.readLong();
        long j11 = buffer.readLong();
        Buffer buffer2 = new Buffer();
        fileOperator.read(FILE_HEADER_SIZE + j10, buffer2, j11);
        return new Relay(randomAccessFile, null, j10, buffer2.readByteString(), 0L);
    }

    private void writeHeader(ByteString byteString, long j10, long j11) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(byteString);
        buffer.writeLong(j10);
        buffer.writeLong(j11);
        if (buffer.size() == FILE_HEADER_SIZE) {
            new FileOperator(this.file.getChannel()).write(0L, buffer, FILE_HEADER_SIZE);
        } else {
            f.a();
        }
    }

    private void writeMetadata(long j10) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(this.metadata);
        new FileOperator(this.file.getChannel()).write(FILE_HEADER_SIZE + j10, buffer, this.metadata.size());
    }

    public void commit(long j10) throws IOException {
        writeMetadata(j10);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j10, this.metadata.size());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        Util.closeQuietly(this.upstream);
        this.upstream = null;
    }

    public boolean isClosed() {
        return this.file == null;
    }

    public ByteString metadata() {
        return this.metadata;
    }

    public Source newSource() {
        synchronized (this) {
            try {
                if (this.file == null) {
                    return null;
                }
                this.sourceCount++;
                return new RelaySource();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

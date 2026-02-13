package com.mbridge.msdk.thrid.okio;

import com.google.gson.internal.a;
import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class Pipe {
    final long maxBufferSize;
    boolean sinkClosed;
    boolean sourceClosed;
    final Buffer buffer = new Buffer();
    private final Sink sink = new PipeSink();
    private final Source source = new PipeSource();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class PipeSink implements Sink {
        final Timeout timeout = new Timeout();

        public PipeSink() {
        }

        @Override // com.mbridge.msdk.thrid.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (Pipe.this.buffer) {
                try {
                    Pipe pipe = Pipe.this;
                    if (pipe.sinkClosed) {
                        return;
                    }
                    if (pipe.sourceClosed && pipe.buffer.size() > 0) {
                        throw new IOException("source is closed");
                    }
                    Pipe pipe2 = Pipe.this;
                    pipe2.sinkClosed = true;
                    pipe2.buffer.notifyAll();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            synchronized (Pipe.this.buffer) {
                try {
                    Pipe pipe = Pipe.this;
                    if (pipe.sinkClosed) {
                        throw new IllegalStateException("closed");
                    }
                    if (pipe.sourceClosed && pipe.buffer.size() > 0) {
                        throw new IOException("source is closed");
                    }
                } finally {
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.Sink
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // com.mbridge.msdk.thrid.okio.Sink
        public void write(Buffer buffer, long j10) throws IOException {
            synchronized (Pipe.this.buffer) {
                try {
                    if (Pipe.this.sinkClosed) {
                        throw new IllegalStateException("closed");
                    }
                    while (j10 > 0) {
                        Pipe pipe = Pipe.this;
                        if (pipe.sourceClosed) {
                            throw new IOException("source is closed");
                        }
                        long size = pipe.maxBufferSize - pipe.buffer.size();
                        if (size == 0) {
                            this.timeout.waitUntilNotified(Pipe.this.buffer);
                        } else {
                            long jMin = Math.min(size, j10);
                            Pipe.this.buffer.write(buffer, jMin);
                            j10 -= jMin;
                            Pipe.this.buffer.notifyAll();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class PipeSource implements Source {
        final Timeout timeout = new Timeout();

        public PipeSource() {
        }

        @Override // com.mbridge.msdk.thrid.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (Pipe.this.buffer) {
                Pipe pipe = Pipe.this;
                pipe.sourceClosed = true;
                pipe.buffer.notifyAll();
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.Source
        public long read(Buffer buffer, long j10) throws IOException {
            synchronized (Pipe.this.buffer) {
                try {
                    if (Pipe.this.sourceClosed) {
                        throw new IllegalStateException("closed");
                    }
                    while (true) {
                        long size = Pipe.this.buffer.size();
                        Pipe pipe = Pipe.this;
                        if (size != 0) {
                            long j11 = pipe.buffer.read(buffer, j10);
                            Pipe.this.buffer.notifyAll();
                            return j11;
                        }
                        if (pipe.sinkClosed) {
                            return -1L;
                        }
                        this.timeout.waitUntilNotified(pipe.buffer);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.Source
        public Timeout timeout() {
            return this.timeout;
        }
    }

    public Pipe(long j10) {
        if (j10 >= 1) {
            this.maxBufferSize = j10;
        } else {
            a.n(a3.a.h(j10, "maxBufferSize < 1: "));
            throw null;
        }
    }

    public final Sink sink() {
        return this.sink;
    }

    public final Source source() {
        return this.source;
    }
}

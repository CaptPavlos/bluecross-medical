package com.mbridge.msdk.thrid.okio;

import androidx.window.layout.c;
import com.google.gson.internal.a;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class RealBufferedSink implements BufferedSink {
    public final Buffer buffer = new Buffer();
    boolean closed;
    public final Sink sink;

    public RealBufferedSink(Sink sink) {
        if (sink != null) {
            this.sink = sink;
        } else {
            c.k("sink == null");
            throw null;
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public Buffer buffer() {
        return this.buffer;
    }

    @Override // com.mbridge.msdk.thrid.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.closed) {
            return;
        }
        try {
            Buffer buffer = this.buffer;
            long j10 = buffer.size;
            if (j10 > 0) {
                this.sink.write(buffer, j10);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.sink.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.closed = true;
        if (th != null) {
            Util.sneakyRethrow(th);
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink emit() throws IOException {
        if (this.closed) {
            c.g("closed");
            return null;
        }
        long size = this.buffer.size();
        if (size > 0) {
            this.sink.write(this.buffer, size);
        }
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink emitCompleteSegments() throws IOException {
        if (this.closed) {
            c.g("closed");
            return null;
        }
        long jCompleteSegmentByteCount = this.buffer.completeSegmentByteCount();
        if (jCompleteSegmentByteCount > 0) {
            this.sink.write(this.buffer, jCompleteSegmentByteCount);
        }
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink, com.mbridge.msdk.thrid.okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (this.closed) {
            c.g("closed");
            return;
        }
        Buffer buffer = this.buffer;
        long j10 = buffer.size;
        if (j10 > 0) {
            this.sink.write(buffer, j10);
        }
        this.sink.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: com.mbridge.msdk.thrid.okio.RealBufferedSink.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws Throwable {
                RealBufferedSink.this.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.closed) {
                    return;
                }
                realBufferedSink.flush();
            }

            public String toString() {
                return RealBufferedSink.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i10) throws IOException {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (realBufferedSink.closed) {
                    a.m("closed");
                } else {
                    realBufferedSink.buffer.writeByte((int) ((byte) i10));
                    RealBufferedSink.this.emitCompleteSegments();
                }
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i10, int i11) throws IOException {
                RealBufferedSink realBufferedSink = RealBufferedSink.this;
                if (!realBufferedSink.closed) {
                    realBufferedSink.buffer.write(bArr, i10, i11);
                    RealBufferedSink.this.emitCompleteSegments();
                } else {
                    a.m("closed");
                }
            }
        };
    }

    @Override // com.mbridge.msdk.thrid.okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "buffer(" + this.sink + ")";
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink write(Source source, long j10) throws IOException {
        while (j10 > 0) {
            long j11 = source.read(this.buffer, j10);
            if (j11 == -1) {
                u.q();
                return null;
            }
            j10 -= j11;
            emitCompleteSegments();
        }
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        if (source == null) {
            a.n("source == null");
            return 0L;
        }
        long j10 = 0;
        while (true) {
            long j11 = source.read(this.buffer, 8192L);
            if (j11 == -1) {
                return j10;
            }
            j10 += j11;
            emitCompleteSegments();
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeByte(int i10) throws IOException {
        if (this.closed) {
            c.g("closed");
            return null;
        }
        this.buffer.writeByte(i10);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeDecimalLong(long j10) throws IOException {
        if (this.closed) {
            c.g("closed");
            return null;
        }
        this.buffer.writeDecimalLong(j10);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeHexadecimalUnsignedLong(long j10) throws IOException {
        if (this.closed) {
            c.g("closed");
            return null;
        }
        this.buffer.writeHexadecimalUnsignedLong(j10);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeInt(int i10) throws IOException {
        if (this.closed) {
            c.g("closed");
            return null;
        }
        this.buffer.writeInt(i10);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeIntLe(int i10) throws IOException {
        if (this.closed) {
            c.g("closed");
            return null;
        }
        this.buffer.writeIntLe(i10);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeLong(long j10) throws IOException {
        if (this.closed) {
            c.g("closed");
            return null;
        }
        this.buffer.writeLong(j10);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeLongLe(long j10) throws IOException {
        if (this.closed) {
            c.g("closed");
            return null;
        }
        this.buffer.writeLongLe(j10);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeShort(int i10) throws IOException {
        if (this.closed) {
            c.g("closed");
            return null;
        }
        this.buffer.writeShort(i10);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeShortLe(int i10) throws IOException {
        if (this.closed) {
            c.g("closed");
            return null;
        }
        this.buffer.writeShortLe(i10);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeString(String str, Charset charset) throws IOException {
        if (this.closed) {
            c.g("closed");
            return null;
        }
        this.buffer.writeString(str, charset);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeUtf8(String str) throws IOException {
        if (this.closed) {
            c.g("closed");
            return null;
        }
        this.buffer.writeUtf8(str);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeUtf8CodePoint(int i10) throws IOException {
        if (this.closed) {
            c.g("closed");
            return null;
        }
        this.buffer.writeUtf8CodePoint(i10);
        return emitCompleteSegments();
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeString(String str, int i10, int i11, Charset charset) throws IOException {
        if (!this.closed) {
            this.buffer.writeString(str, i10, i11, charset);
            return emitCompleteSegments();
        }
        c.g("closed");
        return null;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink writeUtf8(String str, int i10, int i11) throws IOException {
        if (!this.closed) {
            this.buffer.writeUtf8(str, i10, i11);
            return emitCompleteSegments();
        }
        c.g("closed");
        return null;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink write(ByteString byteString) throws IOException {
        if (!this.closed) {
            this.buffer.write(byteString);
            return emitCompleteSegments();
        }
        c.g("closed");
        return null;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink write(byte[] bArr) throws IOException {
        if (!this.closed) {
            this.buffer.write(bArr);
            return emitCompleteSegments();
        }
        c.g("closed");
        return null;
    }

    @Override // com.mbridge.msdk.thrid.okio.BufferedSink
    public BufferedSink write(byte[] bArr, int i10, int i11) throws IOException {
        if (!this.closed) {
            this.buffer.write(bArr, i10, i11);
            return emitCompleteSegments();
        }
        c.g("closed");
        return null;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.closed) {
            int iWrite = this.buffer.write(byteBuffer);
            emitCompleteSegments();
            return iWrite;
        }
        c.g("closed");
        return 0;
    }

    @Override // com.mbridge.msdk.thrid.okio.Sink
    public void write(Buffer buffer, long j10) throws IOException {
        if (!this.closed) {
            this.buffer.write(buffer, j10);
            emitCompleteSegments();
        } else {
            c.g("closed");
        }
    }
}

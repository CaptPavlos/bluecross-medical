package com.mbridge.msdk.thrid.okio;

import com.google.gson.internal.a;
import java.io.IOException;
import java.util.zip.Deflater;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class DeflaterSink implements Sink {
    private boolean closed;
    private final Deflater deflater;
    private final BufferedSink sink;

    public DeflaterSink(BufferedSink bufferedSink, Deflater deflater) {
        if (bufferedSink == null) {
            a.n("source == null");
            throw null;
        }
        if (deflater == null) {
            a.n("inflater == null");
            throw null;
        }
        this.sink = bufferedSink;
        this.deflater = deflater;
    }

    private void deflate(boolean z9) throws IOException {
        Segment segmentWritableSegment;
        int iDeflate;
        Buffer buffer = this.sink.buffer();
        while (true) {
            segmentWritableSegment = buffer.writableSegment(1);
            Deflater deflater = this.deflater;
            if (z9) {
                byte[] bArr = segmentWritableSegment.data;
                int i10 = segmentWritableSegment.limit;
                iDeflate = deflater.deflate(bArr, i10, 8192 - i10, 2);
            } else {
                byte[] bArr2 = segmentWritableSegment.data;
                int i11 = segmentWritableSegment.limit;
                iDeflate = deflater.deflate(bArr2, i11, 8192 - i11);
            }
            if (iDeflate > 0) {
                segmentWritableSegment.limit += iDeflate;
                buffer.size += iDeflate;
                this.sink.emitCompleteSegments();
            } else if (this.deflater.needsInput()) {
                break;
            }
        }
        if (segmentWritableSegment.pos == segmentWritableSegment.limit) {
            buffer.head = segmentWritableSegment.pop();
            SegmentPool.recycle(segmentWritableSegment);
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.closed) {
            return;
        }
        try {
            finishDeflate();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.deflater.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.sink.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.closed = true;
        if (th != null) {
            Util.sneakyRethrow(th);
        }
    }

    public void finishDeflate() throws IOException {
        this.deflater.finish();
        deflate(false);
    }

    @Override // com.mbridge.msdk.thrid.okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        deflate(true);
        this.sink.flush();
    }

    @Override // com.mbridge.msdk.thrid.okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.sink + ")";
    }

    @Override // com.mbridge.msdk.thrid.okio.Sink
    public void write(Buffer buffer, long j10) throws IOException {
        Util.checkOffsetAndCount(buffer.size, 0L, j10);
        while (j10 > 0) {
            Segment segment = buffer.head;
            int iMin = (int) Math.min(j10, segment.limit - segment.pos);
            this.deflater.setInput(segment.data, segment.pos, iMin);
            deflate(false);
            long j11 = iMin;
            buffer.size -= j11;
            int i10 = segment.pos + iMin;
            segment.pos = i10;
            if (i10 == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            j10 -= j11;
        }
    }

    public DeflaterSink(Sink sink, Deflater deflater) {
        this(Okio.buffer(sink), deflater);
    }
}

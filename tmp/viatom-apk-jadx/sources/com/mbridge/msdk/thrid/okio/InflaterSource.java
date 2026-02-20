package com.mbridge.msdk.thrid.okio;

import androidx.window.layout.c;
import com.google.gson.internal.a;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class InflaterSource implements Source {
    private int bufferBytesHeldByInflater;
    private boolean closed;
    private final Inflater inflater;
    private final BufferedSource source;

    public InflaterSource(BufferedSource bufferedSource, Inflater inflater) {
        if (bufferedSource == null) {
            a.n("source == null");
            throw null;
        }
        if (inflater == null) {
            a.n("inflater == null");
            throw null;
        }
        this.source = bufferedSource;
        this.inflater = inflater;
    }

    private void releaseInflatedBytes() throws IOException {
        int i10 = this.bufferBytesHeldByInflater;
        if (i10 == 0) {
            return;
        }
        int remaining = i10 - this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= remaining;
        this.source.skip(remaining);
    }

    @Override // com.mbridge.msdk.thrid.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    @Override // com.mbridge.msdk.thrid.okio.Source
    public long read(Buffer buffer, long j10) throws DataFormatException, IOException {
        boolean zRefill;
        if (j10 < 0) {
            a.n(a3.a.h(j10, "byteCount < 0: "));
            return 0L;
        }
        if (this.closed) {
            c.g("closed");
            return 0L;
        }
        if (j10 == 0) {
            return 0L;
        }
        do {
            zRefill = refill();
            try {
                Segment segmentWritableSegment = buffer.writableSegment(1);
                int iInflate = this.inflater.inflate(segmentWritableSegment.data, segmentWritableSegment.limit, (int) Math.min(j10, 8192 - segmentWritableSegment.limit));
                if (iInflate > 0) {
                    segmentWritableSegment.limit += iInflate;
                    long j11 = iInflate;
                    buffer.size += j11;
                    return j11;
                }
                if (!this.inflater.finished() && !this.inflater.needsDictionary()) {
                }
                releaseInflatedBytes();
                if (segmentWritableSegment.pos != segmentWritableSegment.limit) {
                    return -1L;
                }
                buffer.head = segmentWritableSegment.pop();
                SegmentPool.recycle(segmentWritableSegment);
                return -1L;
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        } while (!zRefill);
        throw new EOFException("source exhausted prematurely");
    }

    public final boolean refill() throws IOException {
        if (!this.inflater.needsInput()) {
            return false;
        }
        releaseInflatedBytes();
        if (this.inflater.getRemaining() != 0) {
            c.g("?");
            return false;
        }
        if (this.source.exhausted()) {
            return true;
        }
        Segment segment = this.source.buffer().head;
        int i10 = segment.limit;
        int i11 = segment.pos;
        int i12 = i10 - i11;
        this.bufferBytesHeldByInflater = i12;
        this.inflater.setInput(segment.data, i11, i12);
        return false;
    }

    @Override // com.mbridge.msdk.thrid.okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }

    public InflaterSource(Source source, Inflater inflater) {
        this(Okio.buffer(source), inflater);
    }
}

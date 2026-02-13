package com.mbridge.msdk.thrid.okio;

import com.google.gson.internal.a;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class GzipSink implements Sink {
    private boolean closed;
    private final CRC32 crc = new CRC32();
    private final Deflater deflater;
    private final DeflaterSink deflaterSink;
    private final BufferedSink sink;

    public GzipSink(Sink sink) {
        if (sink == null) {
            a.n("sink == null");
            throw null;
        }
        Deflater deflater = new Deflater(-1, true);
        this.deflater = deflater;
        BufferedSink bufferedSinkBuffer = Okio.buffer(sink);
        this.sink = bufferedSinkBuffer;
        this.deflaterSink = new DeflaterSink(bufferedSinkBuffer, deflater);
        writeHeader();
    }

    private void updateCrc(Buffer buffer, long j10) {
        Segment segment = buffer.head;
        while (j10 > 0) {
            int iMin = (int) Math.min(j10, segment.limit - segment.pos);
            this.crc.update(segment.data, segment.pos, iMin);
            j10 -= iMin;
            segment = segment.next;
        }
    }

    private void writeFooter() throws IOException {
        this.sink.writeIntLe((int) this.crc.getValue());
        this.sink.writeIntLe((int) this.deflater.getBytesRead());
    }

    private void writeHeader() {
        Buffer buffer = this.sink.buffer();
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    @Override // com.mbridge.msdk.thrid.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.closed) {
            return;
        }
        try {
            this.deflaterSink.finishDeflate();
            writeFooter();
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

    public final Deflater deflater() {
        return this.deflater;
    }

    @Override // com.mbridge.msdk.thrid.okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.deflaterSink.flush();
    }

    @Override // com.mbridge.msdk.thrid.okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @Override // com.mbridge.msdk.thrid.okio.Sink
    public void write(Buffer buffer, long j10) throws IOException {
        if (j10 < 0) {
            a.n(a3.a.h(j10, "byteCount < 0: "));
        } else {
            if (j10 == 0) {
                return;
            }
            updateCrc(buffer, j10);
            this.deflaterSink.write(buffer, j10);
        }
    }
}

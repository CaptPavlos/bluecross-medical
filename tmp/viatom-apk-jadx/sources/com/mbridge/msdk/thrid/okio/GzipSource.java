package com.mbridge.msdk.thrid.okio;

import com.google.gson.internal.a;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class GzipSource implements Source {
    private static final byte FCOMMENT = 4;
    private static final byte FEXTRA = 2;
    private static final byte FHCRC = 1;
    private static final byte FNAME = 3;
    private static final byte SECTION_BODY = 1;
    private static final byte SECTION_DONE = 3;
    private static final byte SECTION_HEADER = 0;
    private static final byte SECTION_TRAILER = 2;
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private final BufferedSource source;
    private int section = 0;
    private final CRC32 crc = new CRC32();

    public GzipSource(Source source) {
        if (source == null) {
            a.n("source == null");
            throw null;
        }
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        BufferedSource bufferedSourceBuffer = Okio.buffer(source);
        this.source = bufferedSourceBuffer;
        this.inflaterSource = new InflaterSource(bufferedSourceBuffer, inflater);
    }

    private void checkEqual(String str, int i10, int i11) throws IOException {
        if (i11 != i10) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i11), Integer.valueOf(i10)));
        }
    }

    private void consumeHeader() throws IOException {
        this.source.require(10L);
        byte b10 = this.source.buffer().getByte(3L);
        boolean z9 = ((b10 >> 1) & 1) == 1;
        if (z9) {
            updateCrc(this.source.buffer(), 0L, 10L);
        }
        checkEqual("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8L);
        if (((b10 >> 2) & 1) == 1) {
            this.source.require(2L);
            if (z9) {
                updateCrc(this.source.buffer(), 0L, 2L);
            }
            long shortLe = this.source.buffer().readShortLe();
            this.source.require(shortLe);
            if (z9) {
                updateCrc(this.source.buffer(), 0L, shortLe);
            }
            this.source.skip(shortLe);
        }
        if (((b10 >> 3) & 1) == 1) {
            long jIndexOf = this.source.indexOf(SECTION_HEADER);
            if (jIndexOf == -1) {
                u.q();
                return;
            } else {
                if (z9) {
                    updateCrc(this.source.buffer(), 0L, jIndexOf + 1);
                }
                this.source.skip(jIndexOf + 1);
            }
        }
        if (((b10 >> FCOMMENT) & 1) == 1) {
            long jIndexOf2 = this.source.indexOf(SECTION_HEADER);
            if (jIndexOf2 == -1) {
                u.q();
                return;
            } else {
                if (z9) {
                    updateCrc(this.source.buffer(), 0L, jIndexOf2 + 1);
                }
                this.source.skip(jIndexOf2 + 1);
            }
        }
        if (z9) {
            checkEqual("FHCRC", this.source.readShortLe(), (short) this.crc.getValue());
            this.crc.reset();
        }
    }

    private void consumeTrailer() throws IOException {
        checkEqual("CRC", this.source.readIntLe(), (int) this.crc.getValue());
        checkEqual("ISIZE", this.source.readIntLe(), (int) this.inflater.getBytesWritten());
    }

    private void updateCrc(Buffer buffer, long j10, long j11) {
        Segment segment = buffer.head;
        while (true) {
            int i10 = segment.limit;
            int i11 = segment.pos;
            if (j10 < i10 - i11) {
                break;
            }
            j10 -= i10 - i11;
            segment = segment.next;
        }
        while (j11 > 0) {
            int iMin = (int) Math.min(segment.limit - r6, j11);
            this.crc.update(segment.data, (int) (segment.pos + j10), iMin);
            j11 -= iMin;
            segment = segment.next;
            j10 = 0;
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inflaterSource.close();
    }

    @Override // com.mbridge.msdk.thrid.okio.Source
    public long read(Buffer buffer, long j10) throws DataFormatException, IOException {
        GzipSource gzipSource;
        if (j10 < 0) {
            a.n(a3.a.h(j10, "byteCount < 0: "));
            return 0L;
        }
        if (j10 == 0) {
            return 0L;
        }
        if (this.section == 0) {
            consumeHeader();
            this.section = 1;
        }
        if (this.section == 1) {
            long j11 = buffer.size;
            long j12 = this.inflaterSource.read(buffer, j10);
            if (j12 != -1) {
                updateCrc(buffer, j11, j12);
                return j12;
            }
            gzipSource = this;
            gzipSource.section = 2;
        } else {
            gzipSource = this;
        }
        if (gzipSource.section == 2) {
            consumeTrailer();
            gzipSource.section = 3;
            if (!gzipSource.source.exhausted()) {
                a.m("gzip finished without exhausting source");
                return 0L;
            }
        }
        return -1L;
    }

    @Override // com.mbridge.msdk.thrid.okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }
}

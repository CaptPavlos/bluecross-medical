package z8;

import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t implements h0 {

    /* renamed from: a, reason: collision with root package name */
    public byte f14504a;

    /* renamed from: b, reason: collision with root package name */
    public final b0 f14505b;

    /* renamed from: c, reason: collision with root package name */
    public final Inflater f14506c;

    /* renamed from: d, reason: collision with root package name */
    public final u f14507d;
    public final CRC32 e;

    public t(h0 h0Var) {
        h0Var.getClass();
        b0 b0Var = new b0(h0Var);
        this.f14505b = b0Var;
        Inflater inflater = new Inflater(true);
        this.f14506c = inflater;
        this.f14507d = new u(b0Var, inflater);
        this.e = new CRC32();
    }

    public static void a(String str, int i10, int i11) throws IOException {
        if (i11 != i10) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i11), Integer.valueOf(i10)}, 3)));
        }
    }

    public final void b(i iVar, long j10, long j11) {
        c0 c0Var = iVar.f14478a;
        c0Var.getClass();
        while (true) {
            int i10 = c0Var.f14464c;
            int i11 = c0Var.f14463b;
            if (j10 < i10 - i11) {
                break;
            }
            j10 -= i10 - i11;
            c0Var = c0Var.f;
            c0Var.getClass();
        }
        while (j11 > 0) {
            int iMin = (int) Math.min(c0Var.f14464c - r6, j11);
            this.e.update(c0Var.f14462a, (int) (c0Var.f14463b + j10), iMin);
            j11 -= iMin;
            c0Var = c0Var.f;
            c0Var.getClass();
            j10 = 0;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f14507d.close();
    }

    @Override // z8.h0
    public final long g(i iVar, long j10) throws DataFormatException, IOException {
        t tVar = this;
        iVar.getClass();
        if (j10 < 0) {
            f.b(a3.a.h(j10, "byteCount < 0: "));
            return 0L;
        }
        if (j10 == 0) {
            return 0L;
        }
        byte b10 = tVar.f14504a;
        CRC32 crc32 = tVar.e;
        b0 b0Var = tVar.f14505b;
        if (b10 == 0) {
            b0Var.require(10L);
            i iVar2 = b0Var.f14457b;
            byte b11 = iVar2.b(3L);
            boolean z9 = ((b11 >> 1) & 1) == 1;
            if (z9) {
                tVar.b(iVar2, 0L, 10L);
            }
            a("ID1ID2", 8075, b0Var.readShort());
            b0Var.skip(8L);
            if (((b11 >> 2) & 1) == 1) {
                b0Var.require(2L);
                if (z9) {
                    b(iVar2, 0L, 2L);
                }
                long shortLe = iVar2.readShortLe() & 65535;
                b0Var.require(shortLe);
                if (z9) {
                    b(iVar2, 0L, shortLe);
                }
                b0Var.skip(shortLe);
            }
            if (((b11 >> 3) & 1) == 1) {
                long jIndexOf = b0Var.indexOf((byte) 0, 0L, Long.MAX_VALUE);
                if (jIndexOf == -1) {
                    p8.u.q();
                    return 0L;
                }
                if (z9) {
                    b(iVar2, 0L, jIndexOf + 1);
                }
                b0Var.skip(jIndexOf + 1);
            }
            if (((b11 >> 4) & 1) == 1) {
                long jIndexOf2 = b0Var.indexOf((byte) 0, 0L, Long.MAX_VALUE);
                if (jIndexOf2 == -1) {
                    p8.u.q();
                    return 0L;
                }
                if (z9) {
                    tVar = this;
                    tVar.b(iVar2, 0L, jIndexOf2 + 1);
                } else {
                    tVar = this;
                }
                b0Var.skip(jIndexOf2 + 1);
            } else {
                tVar = this;
            }
            if (z9) {
                a("FHCRC", b0Var.readShortLe(), (short) crc32.getValue());
                crc32.reset();
            }
            tVar.f14504a = (byte) 1;
        }
        if (tVar.f14504a == 1) {
            long j11 = iVar.f14479b;
            long jG = tVar.f14507d.g(iVar, j10);
            if (jG != -1) {
                tVar.b(iVar, j11, jG);
                return jG;
            }
            tVar.f14504a = (byte) 2;
        }
        if (tVar.f14504a == 2) {
            a("CRC", b0Var.readIntLe(), (int) crc32.getValue());
            a("ISIZE", b0Var.readIntLe(), (int) tVar.f14506c.getBytesWritten());
            tVar.f14504a = (byte) 3;
            if (!b0Var.exhausted()) {
                com.google.gson.internal.a.m("gzip finished without exhausting source");
                return 0L;
            }
        }
        return -1L;
    }

    @Override // z8.h0
    public final j0 timeout() {
        return this.f14505b.f14456a.timeout();
    }
}

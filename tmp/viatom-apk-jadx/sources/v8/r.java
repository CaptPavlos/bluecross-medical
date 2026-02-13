package v8;

import java.util.logging.Level;
import java.util.logging.Logger;
import z8.h0;
import z8.j0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r implements h0 {

    /* renamed from: a, reason: collision with root package name */
    public final z8.k f13263a;

    /* renamed from: b, reason: collision with root package name */
    public int f13264b;

    /* renamed from: c, reason: collision with root package name */
    public byte f13265c;

    /* renamed from: d, reason: collision with root package name */
    public int f13266d;
    public int e;
    public short f;

    public r(z8.k kVar) {
        this.f13263a = kVar;
    }

    @Override // z8.h0
    public final long g(z8.i iVar, long j10) {
        int i10;
        int i11;
        do {
            int i12 = this.e;
            z8.k kVar = this.f13263a;
            if (i12 == 0) {
                kVar.skip(this.f);
                this.f = (short) 0;
                if ((this.f13265c & 4) == 0) {
                    i10 = this.f13266d;
                    int iJ = s.j(kVar);
                    this.e = iJ;
                    this.f13264b = iJ;
                    byte b10 = (byte) (kVar.readByte() & 255);
                    this.f13265c = (byte) (kVar.readByte() & 255);
                    Logger logger = s.e;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine(e.a(true, this.f13266d, this.f13264b, b10, this.f13265c));
                    }
                    i11 = kVar.readInt() & Integer.MAX_VALUE;
                    this.f13266d = i11;
                    if (b10 != 9) {
                        e.c("%s != TYPE_CONTINUATION", Byte.valueOf(b10));
                        throw null;
                    }
                }
            } else {
                long jG = kVar.g(iVar, Math.min(j10, i12));
                if (jG != -1) {
                    this.e = (int) (this.e - jG);
                    return jG;
                }
            }
            return -1L;
        } while (i11 == i10);
        e.c("TYPE_CONTINUATION streamId changed", new Object[0]);
        throw null;
    }

    @Override // z8.h0
    public final j0 timeout() {
        return this.f13263a.timeout();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}

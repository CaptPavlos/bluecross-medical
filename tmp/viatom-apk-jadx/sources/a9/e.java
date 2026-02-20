package a9;

import java.io.IOException;
import z8.h0;
import z8.r;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends r {

    /* renamed from: b, reason: collision with root package name */
    public final long f337b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f338c;

    /* renamed from: d, reason: collision with root package name */
    public long f339d;

    public e(h0 h0Var, long j10, boolean z9) {
        super(h0Var);
        this.f337b = j10;
        this.f338c = z9;
    }

    @Override // z8.r, z8.h0
    public final long g(z8.i iVar, long j10) throws IOException {
        iVar.getClass();
        long j11 = this.f339d;
        long j12 = this.f337b;
        if (j11 > j12) {
            j10 = 0;
        } else if (this.f338c) {
            long j13 = j12 - j11;
            if (j13 == 0) {
                return -1L;
            }
            j10 = Math.min(j10, j13);
        }
        long jG = this.f14503a.g(iVar, j10);
        if (jG != -1) {
            this.f339d += jG;
        }
        long j14 = this.f339d;
        if ((j14 >= j12 || jG != -1) && j14 <= j12) {
            return jG;
        }
        if (jG > 0 && j14 > j12) {
            long j15 = iVar.f14479b - (j14 - j12);
            z8.i iVar2 = new z8.i();
            iVar2.j(iVar);
            iVar.c(iVar2, j15);
            iVar2.skip(iVar2.f14479b);
        }
        StringBuilder sbX = a3.a.x("expected ", " bytes but got ", j12);
        sbX.append(this.f339d);
        throw new IOException(sbX.toString());
    }
}

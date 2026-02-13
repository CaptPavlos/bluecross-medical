package u8;

import java.io.IOException;
import p8.u;
import z8.h0;
import z8.i;
import z8.j0;
import z8.s;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a implements h0 {

    /* renamed from: a, reason: collision with root package name */
    public final s f13075a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13076b;

    /* renamed from: c, reason: collision with root package name */
    public long f13077c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g f13078d;

    public a(g gVar) {
        this.f13078d = gVar;
        this.f13075a = new s(gVar.f13088c.timeout());
    }

    public final void a(boolean z9, IOException iOException) throws IOException {
        g gVar = this.f13078d;
        int i10 = gVar.e;
        if (i10 == 6) {
            return;
        }
        if (i10 != 5) {
            u.f(gVar.e, "state: ");
            return;
        }
        s sVar = this.f13075a;
        j0 j0Var = sVar.e;
        sVar.e = j0.f14480d;
        j0Var.a();
        j0Var.b();
        gVar.e = 6;
        s8.f fVar = gVar.f13087b;
        if (fVar != null) {
            fVar.h(!z9, gVar, iOException);
        }
    }

    @Override // z8.h0
    public long g(i iVar, long j10) throws IOException {
        try {
            long jG = this.f13078d.f13088c.g(iVar, j10);
            if (jG <= 0) {
                return jG;
            }
            this.f13077c += jG;
            return jG;
        } catch (IOException e) {
            a(false, e);
            throw e;
        }
    }

    @Override // z8.h0
    public final j0 timeout() {
        return this.f13075a;
    }
}

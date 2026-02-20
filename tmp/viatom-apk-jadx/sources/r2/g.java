package r2;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g implements i {

    /* renamed from: a, reason: collision with root package name */
    public final h1.i f12359a;

    public g(h1.i iVar) {
        this.f12359a = iVar;
    }

    @Override // r2.i
    public final boolean a(Exception exc) {
        return false;
    }

    @Override // r2.i
    public final boolean b(s2.b bVar) {
        int i10 = bVar.f12523b;
        if (i10 != 3 && i10 != 4 && i10 != 5) {
            return false;
        }
        this.f12359a.c(bVar.f12522a);
        return true;
    }
}

package u7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d0 implements k0, h, v7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k0 f12986a;

    public d0(c0 c0Var) {
        this.f12986a = c0Var;
    }

    @Override // v7.i
    public final h a(w6.h hVar, int i10, t7.a aVar) {
        return ((((i10 < 0 || i10 >= 2) && i10 != -2) || aVar != t7.a.f12814b) && !((i10 == 0 || i10 == -3) && aVar == t7.a.f12813a)) ? new d((Object) this, hVar, i10, aVar, 1) : this;
    }

    @Override // u7.h
    public final Object collect(i iVar, w6.c cVar) {
        return this.f12986a.collect(iVar, cVar);
    }

    @Override // u7.k0
    public final Object getValue() {
        return this.f12986a.getValue();
    }
}

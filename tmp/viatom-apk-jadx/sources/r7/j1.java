package r7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j1 extends o1 {

    /* renamed from: d, reason: collision with root package name */
    public final w6.c f12411d;

    public j1(w6.h hVar, g7.p pVar) {
        super(hVar, false);
        this.f12411d = r0.f.s(pVar, this, this);
    }

    @Override // r7.i1
    public final void V() {
        try {
            w7.a.h(s6.w.f12711a, r0.f.F(this.f12411d));
        } catch (Throwable th) {
            resumeWith(new s6.j(th));
            throw th;
        }
    }
}

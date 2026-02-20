package w7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class r extends r7.a implements y6.d {

    /* renamed from: d, reason: collision with root package name */
    public final w6.c f13553d;

    public r(w6.c cVar, w6.h hVar) {
        super(hVar, true);
        this.f13553d = cVar;
    }

    @Override // r7.i1
    public final boolean O() {
        return true;
    }

    @Override // y6.d
    public final y6.d getCallerFrame() {
        w6.c cVar = this.f13553d;
        if (cVar instanceof y6.d) {
            return (y6.d) cVar;
        }
        return null;
    }

    @Override // r7.i1
    public void t(Object obj) {
        a.h(r7.y.s(obj), r0.f.F(this.f13553d));
    }

    @Override // r7.i1
    public void u(Object obj) {
        this.f13553d.resumeWith(r7.y.s(obj));
    }
}

package v7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p implements w6.c, y6.d {

    /* renamed from: a, reason: collision with root package name */
    public final w6.c f13202a;

    /* renamed from: b, reason: collision with root package name */
    public final w6.h f13203b;

    public p(w6.c cVar, w6.h hVar) {
        this.f13202a = cVar;
        this.f13203b = hVar;
    }

    @Override // y6.d
    public final y6.d getCallerFrame() {
        w6.c cVar = this.f13202a;
        if (cVar instanceof y6.d) {
            return (y6.d) cVar;
        }
        return null;
    }

    @Override // w6.c
    public final w6.h getContext() {
        return this.f13203b;
    }

    @Override // w6.c
    public final void resumeWith(Object obj) {
        this.f13202a.resumeWith(obj);
    }
}

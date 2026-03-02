package u7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g implements h {

    /* renamed from: a, reason: collision with root package name */
    public final h f12998a;

    public g(h hVar) {
        this.f12998a = hVar;
    }

    @Override // u7.h
    public final Object collect(i iVar, w6.c cVar) {
        kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
        xVar.f10138a = v7.c.f13178b;
        Object objCollect = this.f12998a.collect(new f(this, xVar, iVar), cVar);
        return objCollect == x6.a.f13718a ? objCollect : s6.w.f12711a;
    }
}

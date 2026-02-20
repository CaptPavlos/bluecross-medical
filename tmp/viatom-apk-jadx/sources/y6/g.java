package y6;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class g extends a {
    public g(w6.c cVar) {
        super(cVar);
        if (cVar == null || cVar.getContext() == w6.i.f13523a) {
            return;
        }
        com.google.gson.internal.a.n("Coroutines with restricted suspension must have EmptyCoroutineContext");
        throw null;
    }

    @Override // w6.c
    public w6.h getContext() {
        return w6.i.f13523a;
    }
}

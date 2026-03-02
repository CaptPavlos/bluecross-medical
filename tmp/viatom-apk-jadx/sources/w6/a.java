package w6;

import g7.p;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a implements f {
    private final g key;

    public a(g gVar) {
        this.key = gVar;
    }

    @Override // w6.h
    public <R> R fold(R r6, p pVar) {
        return (R) t1.o(this, r6, pVar);
    }

    @Override // w6.h
    public f get(g gVar) {
        return t1.p(this, gVar);
    }

    @Override // w6.f
    public g getKey() {
        return this.key;
    }

    @Override // w6.h
    public h minusKey(g gVar) {
        return t1.K(this, gVar);
    }

    @Override // w6.h
    public h plus(h hVar) {
        return t1.M(this, hVar);
    }
}

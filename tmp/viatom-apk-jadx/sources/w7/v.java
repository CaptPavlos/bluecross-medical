package w7;

import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v implements w6.f {

    /* renamed from: a, reason: collision with root package name */
    public final Object f13558a;

    /* renamed from: b, reason: collision with root package name */
    public final ThreadLocal f13559b;

    /* renamed from: c, reason: collision with root package name */
    public final w f13560c;

    public v(ThreadLocal threadLocal, Object obj) {
        this.f13558a = obj;
        this.f13559b = threadLocal;
        this.f13560c = new w(threadLocal);
    }

    @Override // w6.h
    public final Object fold(Object obj, g7.p pVar) {
        return pVar.invoke(obj, this);
    }

    @Override // w6.h
    public final w6.f get(w6.g gVar) {
        if (this.f13560c.equals(gVar)) {
            return this;
        }
        return null;
    }

    @Override // w6.f
    public final w6.g getKey() {
        return this.f13560c;
    }

    @Override // w6.h
    public final w6.h minusKey(w6.g gVar) {
        return this.f13560c.equals(gVar) ? w6.i.f13523a : this;
    }

    @Override // w6.h
    public final w6.h plus(w6.h hVar) {
        return t1.M(this, hVar);
    }

    public final String toString() {
        return "ThreadLocal(value=" + this.f13558a + ", threadLocal = " + this.f13559b + ')';
    }
}

package s6;

import java.io.Serializable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m implements f, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public g7.a f12699a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f12700b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f12701c;

    public m(g7.a aVar) {
        aVar.getClass();
        this.f12699a = aVar;
        this.f12700b = t.f12708a;
        this.f12701c = this;
    }

    @Override // s6.f
    public final Object getValue() {
        Object objInvoke;
        Object obj = this.f12700b;
        t tVar = t.f12708a;
        if (obj != tVar) {
            return obj;
        }
        synchronized (this.f12701c) {
            objInvoke = this.f12700b;
            if (objInvoke == tVar) {
                g7.a aVar = this.f12699a;
                aVar.getClass();
                objInvoke = aVar.invoke();
                this.f12700b = objInvoke;
                this.f12699a = null;
            }
        }
        return objInvoke;
    }

    @Override // s6.f
    public final boolean isInitialized() {
        return this.f12700b != t.f12708a;
    }

    public final String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}

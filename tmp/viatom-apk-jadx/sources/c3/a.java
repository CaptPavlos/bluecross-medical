package c3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements c {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f1644c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile b f1645a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f1646b;

    public static c a(b bVar) {
        if (bVar instanceof a) {
            return bVar;
        }
        a aVar = new a();
        aVar.f1646b = f1644c;
        aVar.f1645a = bVar;
        return aVar;
    }

    @Override // p6.a
    public final Object get() {
        Object obj;
        Object obj2 = this.f1646b;
        Object obj3 = f1644c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f1646b;
                if (obj == obj3) {
                    obj = this.f1645a.get();
                    Object obj4 = this.f1646b;
                    if (obj4 != obj3 && obj4 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.f1646b = obj;
                    this.f1645a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}

package r;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class a implements p6.a {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f12293c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile b f12294a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f12295b;

    public static p6.a a(b bVar) {
        if (bVar instanceof a) {
            return bVar;
        }
        a aVar = new a();
        aVar.f12295b = f12293c;
        aVar.f12294a = bVar;
        return aVar;
    }

    @Override // p6.a
    public final Object get() {
        Object obj;
        Object obj2 = this.f12295b;
        Object obj3 = f12293c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f12295b;
                if (obj == obj3) {
                    obj = this.f12294a.get();
                    Object obj4 = this.f12295b;
                    if (obj4 != obj3 && obj4 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.f12295b = obj;
                    this.f12294a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}

package q1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m implements q2.b {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f12241c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f12242a = f12241c;

    /* renamed from: b, reason: collision with root package name */
    public volatile q2.b f12243b;

    public m(q2.b bVar) {
        this.f12243b = bVar;
    }

    @Override // q2.b
    public final Object get() {
        Object obj;
        Object obj2 = this.f12242a;
        Object obj3 = f12241c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f12242a;
                if (obj == obj3) {
                    obj = this.f12243b.get();
                    this.f12242a = obj;
                    this.f12243b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}

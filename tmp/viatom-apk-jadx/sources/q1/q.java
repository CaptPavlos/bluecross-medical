package q1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final Class f12250a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f12251b;

    public q(Class cls, Class cls2) {
        this.f12250a = cls;
        this.f12251b = cls2;
    }

    public static q a(Class cls) {
        return new q(p.class, cls);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        if (this.f12251b.equals(qVar.f12251b)) {
            return this.f12250a.equals(qVar.f12250a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f12250a.hashCode() + (this.f12251b.hashCode() * 31);
    }

    public final String toString() {
        Class cls = this.f12251b;
        Class cls2 = this.f12250a;
        if (cls2 == p.class) {
            return cls.getName();
        }
        return "@" + cls2.getName() + " " + cls.getName();
    }
}

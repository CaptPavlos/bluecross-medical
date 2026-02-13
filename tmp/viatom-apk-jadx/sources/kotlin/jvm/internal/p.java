package kotlin.jvm.internal;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p implements e {

    /* renamed from: a, reason: collision with root package name */
    public final Class f10134a;

    public p(Class cls) {
        cls.getClass();
        this.f10134a = cls;
    }

    @Override // kotlin.jvm.internal.e
    public final Class a() {
        return this.f10134a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof p) {
            return l.a(this.f10134a, ((p) obj).f10134a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f10134a.hashCode();
    }

    public final String toString() {
        return this.f10134a + " (Kotlin reflection is not available)";
    }
}

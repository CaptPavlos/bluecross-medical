package w7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w implements w6.g {

    /* renamed from: a, reason: collision with root package name */
    public final ThreadLocal f13561a;

    public w(ThreadLocal threadLocal) {
        this.f13561a = threadLocal;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof w) && kotlin.jvm.internal.l.a(this.f13561a, ((w) obj).f13561a);
    }

    public final int hashCode() {
        return this.f13561a.hashCode();
    }

    public final String toString() {
        return "ThreadLocalKey(threadLocal=" + this.f13561a + ')';
    }
}

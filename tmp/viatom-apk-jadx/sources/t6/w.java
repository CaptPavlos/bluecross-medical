package t6;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final int f12811a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f12812b;

    public w(int i10, Object obj) {
        this.f12811a = i10;
        this.f12812b = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f12811a == wVar.f12811a && kotlin.jvm.internal.l.a(this.f12812b, wVar.f12812b);
    }

    public final int hashCode() {
        int i10 = this.f12811a * 31;
        Object obj = this.f12812b;
        return i10 + (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        return "IndexedValue(index=" + this.f12811a + ", value=" + this.f12812b + ')';
    }
}

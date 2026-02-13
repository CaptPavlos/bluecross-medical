package s6;

import java.io.Serializable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f12693a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f12694b;

    public i(Object obj, Object obj2) {
        this.f12693a = obj;
        this.f12694b = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return kotlin.jvm.internal.l.a(this.f12693a, iVar.f12693a) && kotlin.jvm.internal.l.a(this.f12694b, iVar.f12694b);
    }

    public final int hashCode() {
        Object obj = this.f12693a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f12694b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f12693a + ", " + this.f12694b + ')';
    }
}

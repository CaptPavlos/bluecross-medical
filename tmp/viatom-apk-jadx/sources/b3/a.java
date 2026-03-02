package b3;

import a8.i;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final i f825a;

    /* renamed from: b, reason: collision with root package name */
    public w1.i f826b = null;

    public a(i iVar) {
        this.f825a = iVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f825a.equals(aVar.f825a) && l.a(this.f826b, aVar.f826b);
    }

    public final int hashCode() {
        int iHashCode = this.f825a.hashCode() * 31;
        w1.i iVar = this.f826b;
        return iHashCode + (iVar == null ? 0 : iVar.hashCode());
    }

    public final String toString() {
        return "Dependency(mutex=" + this.f825a + ", subscriber=" + this.f826b + ')';
    }
}

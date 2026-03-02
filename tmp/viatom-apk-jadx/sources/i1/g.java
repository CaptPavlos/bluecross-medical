package i1;

import java.io.Serializable;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g implements d, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f8968a;

    public g(Object obj) {
        this.f8968a = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        Object obj2 = ((g) obj).f8968a;
        Object obj3 = this.f8968a;
        return obj3 == obj2 || obj3.equals(obj2);
    }

    @Override // i1.d
    public final Object get() {
        return this.f8968a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8968a});
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f8968a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 22);
        sb.append("Suppliers.ofInstance(");
        sb.append(strValueOf);
        sb.append(")");
        return sb.toString();
    }
}

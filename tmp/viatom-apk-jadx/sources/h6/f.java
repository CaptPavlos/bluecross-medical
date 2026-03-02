package h6;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f8821a;

    public f(ArrayList arrayList) {
        this.f8821a = arrayList;
    }

    public final boolean equals(Object obj) {
        Object obj2 = 2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        Object obj3 = Boolean.TRUE;
        return obj3.equals(obj3) && obj2.equals(obj2) && this.f8821a.equals(fVar.f8821a);
    }

    public final int hashCode() {
        Integer num = 2;
        return this.f8821a.hashCode() + ((num.hashCode() + (Boolean.TRUE.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EncodingOptions(isForVendors=");
        sb.append(Boolean.TRUE);
        sb.append(", version=");
        sb.append((Object) 2);
        sb.append(", segments=");
        return a3.a.p(sb, this.f8821a, ')');
    }
}

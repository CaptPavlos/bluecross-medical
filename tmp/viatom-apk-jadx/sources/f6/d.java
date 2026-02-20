package f6;

import java.util.LinkedHashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public LinkedHashMap f8073a = new LinkedHashMap();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && kotlin.jvm.internal.l.a(this.f8073a, ((d) obj).f8073a);
    }

    public final int hashCode() {
        return this.f8073a.hashCode();
    }

    public final String toString() {
        return "GoogleVendorList(googleVendorsInfoList=" + this.f8073a + ')';
    }
}

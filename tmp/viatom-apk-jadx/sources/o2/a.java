package o2;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f11672a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f11673b;

    public a(String str, ArrayList arrayList) {
        if (str == null) {
            androidx.window.layout.c.k("Null userAgent");
            throw null;
        }
        this.f11672a = str;
        this.f11673b = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f11672a.equals(aVar.f11672a) && this.f11673b.equals(aVar.f11673b);
    }

    public final int hashCode() {
        return ((this.f11672a.hashCode() ^ 1000003) * 1000003) ^ this.f11673b.hashCode();
    }

    public final String toString() {
        return "HeartBeatResult{userAgent=" + this.f11672a + ", usedDates=" + this.f11673b + "}";
    }
}

package f6;

import java.util.LinkedHashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final Long f8077a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f8078b;

    public /* synthetic */ f() {
        this(null, new LinkedHashMap());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return kotlin.jvm.internal.l.a(this.f8077a, fVar.f8077a) && kotlin.jvm.internal.l.a(this.f8078b, fVar.f8078b);
    }

    public final int hashCode() {
        Long l10 = this.f8077a;
        return this.f8078b.hashCode() + ((l10 == null ? 0 : l10.hashCode()) * 31);
    }

    public final String toString() {
        return "IabApprovedCmpList(lastUpdated=" + this.f8077a + ", cmpInfoMap=" + this.f8078b + ')';
    }

    public f(Long l10, LinkedHashMap linkedHashMap) {
        this.f8077a = l10;
        this.f8078b = linkedHashMap;
    }
}

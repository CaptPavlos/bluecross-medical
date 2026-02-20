package o8;

import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final int f11801a;

    /* renamed from: b, reason: collision with root package name */
    public final GBCConsentValue f11802b;

    public e(int i10, GBCConsentValue gBCConsentValue) {
        gBCConsentValue.getClass();
        this.f11801a = i10;
        this.f11802b = gBCConsentValue;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f11801a == eVar.f11801a && this.f11802b == eVar.f11802b;
    }

    public final int hashCode() {
        return this.f11802b.hashCode() + (this.f11801a * 31);
    }

    public final String toString() {
        return "GBCApplicablePurpose(id=" + this.f11801a + ", defaultValue=" + this.f11802b + ')';
    }
}

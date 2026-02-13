package o8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Boolean f11798a;

    /* renamed from: b, reason: collision with root package name */
    public final Boolean f11799b;

    /* renamed from: c, reason: collision with root package name */
    public final Boolean f11800c;

    public d(Boolean bool, Boolean bool2, Boolean bool3) {
        this.f11798a = bool;
        this.f11799b = bool2;
        this.f11800c = bool3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f11798a.equals(dVar.f11798a) && this.f11799b.equals(dVar.f11799b) && this.f11800c.equals(dVar.f11800c);
    }

    public final int hashCode() {
        return this.f11800c.hashCode() + ((this.f11799b.hashCode() + (this.f11798a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "Features(visitEvents=" + this.f11798a + ", advancedCustomizations=" + this.f11799b + ", consentOrPay=" + this.f11800c + ')';
    }
}

package l4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class eb {

    /* renamed from: a, reason: collision with root package name */
    public final h5.h1 f10371a;

    public eb(h5.h1 h1Var) {
        this.f10371a = h1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof eb) && this.f10371a.equals(((eb) obj).f10371a);
    }

    public final int hashCode() {
        return this.f10371a.hashCode();
    }

    public final String toString() {
        return "UserDeviceData(userDevice=" + this.f10371a + ')';
    }
}

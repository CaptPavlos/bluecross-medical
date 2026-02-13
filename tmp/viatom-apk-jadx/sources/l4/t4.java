package l4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t4 {

    /* renamed from: a, reason: collision with root package name */
    public final h5.f1 f10843a;

    public t4(h5.f1 f1Var) {
        this.f10843a = f1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof t4) && this.f10843a.equals(((t4) obj).f10843a);
    }

    public final int hashCode() {
        return this.f10843a.hashCode();
    }

    public final String toString() {
        return "UserStatsData(userDataStats=" + this.f10843a + ')';
    }
}

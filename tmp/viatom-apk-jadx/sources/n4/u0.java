package n4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u0 {

    /* renamed from: a, reason: collision with root package name */
    public final h5.f f11493a;

    /* renamed from: b, reason: collision with root package name */
    public final h5.y0 f11494b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11495c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11496d = false;
    public boolean e = false;

    public u0(h5.f fVar, h5.y0 y0Var) {
        this.f11493a = fVar;
        this.f11494b = y0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u0)) {
            return false;
        }
        u0 u0Var = (u0) obj;
        return this.f11493a.equals(u0Var.f11493a) && this.f11494b.equals(u0Var.f11494b) && this.f11495c == u0Var.f11495c && this.f11496d == u0Var.f11496d && this.e == u0Var.e;
    }

    public final int hashCode() {
        return ((((((this.f11494b.hashCode() + (this.f11493a.hashCode() * 31)) * 31) + (this.f11495c ? 1231 : 1237)) * 31) + (this.f11496d ? 1231 : 1237)) * 31) + (this.e ? 1231 : 1237);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AppUpdateData(app=");
        sb.append(this.f11493a);
        sb.append(", update=");
        sb.append(this.f11494b);
        sb.append(", isStartAnimationRunning=");
        sb.append(this.f11495c);
        sb.append(", isIconAnimationAplied=");
        sb.append(this.f11496d);
        sb.append(", isEndAnimationRunning=");
        return androidx.constraintlayout.core.widgets.analyzer.a.z(sb, this.e, ')');
    }
}

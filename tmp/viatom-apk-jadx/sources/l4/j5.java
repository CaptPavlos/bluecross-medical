package l4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j5 {

    /* renamed from: a, reason: collision with root package name */
    public final h5.f f10521a;

    /* renamed from: b, reason: collision with root package name */
    public final h5.h f10522b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f10523c;

    public j5(h5.f fVar, h5.h hVar, boolean z9) {
        this.f10521a = fVar;
        this.f10522b = hVar;
        this.f10523c = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j5)) {
            return false;
        }
        j5 j5Var = (j5) obj;
        return kotlin.jvm.internal.l.a(this.f10521a, j5Var.f10521a) && this.f10522b.equals(j5Var.f10522b) && this.f10523c == j5Var.f10523c;
    }

    public final int hashCode() {
        h5.f fVar = this.f10521a;
        return ((this.f10522b.hashCode() + ((fVar == null ? 0 : fVar.hashCode()) * 31)) * 31) + (this.f10523c ? 1231 : 1237);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("OldVersionsData(app=");
        sb.append(this.f10521a);
        sb.append(", appInfo=");
        sb.append(this.f10522b);
        sb.append(", isOldVersionsAvailable=");
        return androidx.constraintlayout.core.widgets.analyzer.a.z(sb, this.f10523c, ')');
    }
}

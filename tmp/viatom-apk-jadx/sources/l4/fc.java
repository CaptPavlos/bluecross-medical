package l4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class fc {

    /* renamed from: a, reason: collision with root package name */
    public final h5.o0 f10411a;

    public fc(h5.o0 o0Var) {
        this.f10411a = o0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof fc) && kotlin.jvm.internal.l.a(this.f10411a, ((fc) obj).f10411a);
    }

    public final int hashCode() {
        h5.o0 o0Var = this.f10411a;
        if (o0Var == null) {
            return 0;
        }
        return o0Var.hashCode();
    }

    public final String toString() {
        return "VirusTotalReportData(reportVT=" + this.f10411a + ')';
    }
}

package a3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g0 {
    public static final f0 Companion = new f0();

    /* renamed from: a, reason: collision with root package name */
    public final int f71a;

    /* renamed from: b, reason: collision with root package name */
    public final String f72b;

    public /* synthetic */ g0(int i10, int i11, String str) {
        if (3 != (i10 & 3)) {
            g8.o0.e(e0.f56a.getDescriptor(), i10, 3);
            throw null;
        }
        this.f71a = i11;
        this.f72b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return this.f71a == g0Var.f71a && kotlin.jvm.internal.l.a(this.f72b, g0Var.f72b);
    }

    public final int hashCode() {
        return this.f72b.hashCode() + (this.f71a * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ProcessData(pid=");
        sb.append(this.f71a);
        sb.append(", uuid=");
        return a.m(sb, this.f72b, ')');
    }

    public g0(int i10, String str) {
        str.getClass();
        this.f71a = i10;
        this.f72b = str;
    }
}

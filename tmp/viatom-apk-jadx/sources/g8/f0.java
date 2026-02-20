package g8;

import com.google.android.gms.internal.measurement.a4;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class f0 implements e8.e {

    /* renamed from: a, reason: collision with root package name */
    public final e8.e f8261a;

    public f0(e8.e eVar) {
        this.f8261a = eVar;
    }

    @Override // e8.e
    public final boolean c() {
        return false;
    }

    @Override // e8.e
    public final int d(String str) {
        str.getClass();
        Integer numU = o7.t.U(str);
        if (numU != null) {
            return numU.intValue();
        }
        com.google.gson.internal.a.n(str.concat(" is not a valid list index"));
        return 0;
    }

    @Override // e8.e
    public final int e() {
        return 1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return kotlin.jvm.internal.l.a(this.f8261a, f0Var.f8261a) && kotlin.jvm.internal.l.a(a(), f0Var.a());
    }

    @Override // e8.e
    public final String f(int i10) {
        return String.valueOf(i10);
    }

    @Override // e8.e
    public final List g(int i10) {
        if (i10 >= 0) {
            return t6.t.f12808a;
        }
        StringBuilder sbR = a3.a.r(i10, "Illegal index ", ", ");
        sbR.append(a());
        sbR.append(" expects only non-negative indices");
        throw new IllegalArgumentException(sbR.toString().toString());
    }

    @Override // e8.e
    public final List getAnnotations() {
        return t6.t.f12808a;
    }

    @Override // e8.e
    public final a4 getKind() {
        return e8.i.f7974d;
    }

    @Override // e8.e
    public final e8.e h(int i10) {
        if (i10 >= 0) {
            return this.f8261a;
        }
        StringBuilder sbR = a3.a.r(i10, "Illegal index ", ", ");
        sbR.append(a());
        sbR.append(" expects only non-negative indices");
        throw new IllegalArgumentException(sbR.toString().toString());
    }

    public final int hashCode() {
        return a().hashCode() + (this.f8261a.hashCode() * 31);
    }

    @Override // e8.e
    public final boolean i(int i10) {
        if (i10 >= 0) {
            return false;
        }
        StringBuilder sbR = a3.a.r(i10, "Illegal index ", ", ");
        sbR.append(a());
        sbR.append(" expects only non-negative indices");
        throw new IllegalArgumentException(sbR.toString().toString());
    }

    @Override // e8.e
    public final boolean isInline() {
        return false;
    }

    public final String toString() {
        return a() + '(' + this.f8261a + ')';
    }
}

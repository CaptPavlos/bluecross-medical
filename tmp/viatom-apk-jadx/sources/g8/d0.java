package g8;

import com.google.android.gms.internal.measurement.a4;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d0 implements e8.e {

    /* renamed from: a, reason: collision with root package name */
    public final String f8249a;

    /* renamed from: b, reason: collision with root package name */
    public final e8.e f8250b;

    /* renamed from: c, reason: collision with root package name */
    public final e8.e f8251c;

    public d0(String str, e8.e eVar, e8.e eVar2) {
        this.f8249a = str;
        this.f8250b = eVar;
        this.f8251c = eVar2;
    }

    @Override // e8.e
    public final String a() {
        return this.f8249a;
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
        com.google.gson.internal.a.n(str.concat(" is not a valid map index"));
        return 0;
    }

    @Override // e8.e
    public final int e() {
        return 2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return this.f8249a.equals(d0Var.f8249a) && this.f8250b.equals(d0Var.f8250b) && this.f8251c.equals(d0Var.f8251c);
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
        z8.f.b(a3.a.o(a3.a.r(i10, "Illegal index ", ", "), this.f8249a, " expects only non-negative indices"));
        return null;
    }

    @Override // e8.e
    public final List getAnnotations() {
        return t6.t.f12808a;
    }

    @Override // e8.e
    public final a4 getKind() {
        return e8.i.e;
    }

    @Override // e8.e
    public final e8.e h(int i10) {
        if (i10 < 0) {
            z8.f.b(a3.a.o(a3.a.r(i10, "Illegal index ", ", "), this.f8249a, " expects only non-negative indices"));
            return null;
        }
        int i11 = i10 % 2;
        if (i11 == 0) {
            return this.f8250b;
        }
        if (i11 == 1) {
            return this.f8251c;
        }
        androidx.window.layout.c.g("Unreached");
        return null;
    }

    public final int hashCode() {
        return this.f8251c.hashCode() + ((this.f8250b.hashCode() + (this.f8249a.hashCode() * 31)) * 31);
    }

    @Override // e8.e
    public final boolean i(int i10) {
        if (i10 >= 0) {
            return false;
        }
        z8.f.b(a3.a.o(a3.a.r(i10, "Illegal index ", ", "), this.f8249a, " expects only non-negative indices"));
        return false;
    }

    @Override // e8.e
    public final boolean isInline() {
        return false;
    }

    public final String toString() {
        return this.f8249a + '(' + this.f8250b + ", " + this.f8251c + ')';
    }
}

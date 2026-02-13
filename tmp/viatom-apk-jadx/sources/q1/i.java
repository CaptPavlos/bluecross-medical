package q1;

import com.google.android.gms.internal.measurement.a4;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final q f12235a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12236b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12237c;

    public i(q qVar, int i10, int i11) {
        a4.i(qVar, "Null dependency anInterface.");
        this.f12235a = qVar;
        this.f12236b = i10;
        this.f12237c = i11;
    }

    public static i a(Class cls) {
        return new i(1, 0, cls);
    }

    public static i b(q qVar) {
        return new i(qVar, 1, 0);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f12235a.equals(iVar.f12235a) && this.f12236b == iVar.f12236b && this.f12237c == iVar.f12237c;
    }

    public final int hashCode() {
        return ((((this.f12235a.hashCode() ^ 1000003) * 1000003) ^ this.f12236b) * 1000003) ^ this.f12237c;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f12235a);
        sb.append(", type=");
        int i10 = this.f12236b;
        sb.append(i10 == 1 ? "required" : i10 == 0 ? "optional" : "set");
        sb.append(", injection=");
        int i11 = this.f12237c;
        if (i11 == 0) {
            str = "direct";
        } else if (i11 == 1) {
            str = "provider";
        } else {
            if (i11 != 2) {
                u.h(a3.a.f(i11, "Unsupported injection: "));
                return null;
            }
            str = "deferred";
        }
        return a3.a.o(sb, str, "}");
    }

    public i(int i10, int i11, Class cls) {
        this(q.a(cls), i10, i11);
    }
}

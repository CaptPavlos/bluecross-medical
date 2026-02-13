package a3;

import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o0 {
    public static final n0 Companion = new n0();

    /* renamed from: d, reason: collision with root package name */
    public static final c8.b[] f144d = {null, null, new g8.e0(g8.b1.f8241a, e0.f56a)};

    /* renamed from: a, reason: collision with root package name */
    public final t0 f145a;

    /* renamed from: b, reason: collision with root package name */
    public final n1 f146b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f147c;

    public /* synthetic */ o0(int i10, t0 t0Var, n1 n1Var, Map map) {
        if (1 != (i10 & 1)) {
            g8.o0.e(m0.f133a.getDescriptor(), i10, 1);
            throw null;
        }
        this.f145a = t0Var;
        if ((i10 & 2) == 0) {
            this.f146b = null;
        } else {
            this.f146b = n1Var;
        }
        if ((i10 & 4) == 0) {
            this.f147c = null;
        } else {
            this.f147c = map;
        }
    }

    public static o0 a(o0 o0Var, t0 t0Var, n1 n1Var, Map map, int i10) {
        if ((i10 & 1) != 0) {
            t0Var = o0Var.f145a;
        }
        if ((i10 & 2) != 0) {
            n1Var = o0Var.f146b;
        }
        if ((i10 & 4) != 0) {
            map = o0Var.f147c;
        }
        o0Var.getClass();
        t0Var.getClass();
        return new o0(t0Var, n1Var, map);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        return kotlin.jvm.internal.l.a(this.f145a, o0Var.f145a) && kotlin.jvm.internal.l.a(this.f146b, o0Var.f146b) && kotlin.jvm.internal.l.a(this.f147c, o0Var.f147c);
    }

    public final int hashCode() {
        int iHashCode = this.f145a.hashCode() * 31;
        n1 n1Var = this.f146b;
        int iHashCode2 = (iHashCode + (n1Var == null ? 0 : n1Var.hashCode())) * 31;
        Map map = this.f147c;
        return iHashCode2 + (map != null ? map.hashCode() : 0);
    }

    public final String toString() {
        return "SessionData(sessionDetails=" + this.f145a + ", backgroundTime=" + this.f146b + ", processDataMap=" + this.f147c + ')';
    }

    public o0(t0 t0Var, n1 n1Var, Map map) {
        t0Var.getClass();
        this.f145a = t0Var;
        this.f146b = n1Var;
        this.f147c = map;
    }
}

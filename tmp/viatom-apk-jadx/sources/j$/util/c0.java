package j$.util;

/* loaded from: classes2.dex */
public final class c0 {

    /* renamed from: c, reason: collision with root package name */
    public static final c0 f9351c = new c0();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f9352a;

    /* renamed from: b, reason: collision with root package name */
    public final double f9353b;

    public c0() {
        this.f9352a = false;
        this.f9353b = Double.NaN;
    }

    public c0(double d8) {
        this.f9352a = true;
        this.f9353b = d8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        boolean z9 = c0Var.f9352a;
        boolean z10 = this.f9352a;
        return (z10 && z9) ? Double.compare(this.f9353b, c0Var.f9353b) == 0 : z10 == z9;
    }

    public final int hashCode() {
        if (!this.f9352a) {
            return 0;
        }
        long jDoubleToLongBits = Double.doubleToLongBits(this.f9353b);
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public final String toString() {
        if (this.f9352a) {
            return "OptionalDouble[" + this.f9353b + "]";
        }
        return "OptionalDouble.empty";
    }
}

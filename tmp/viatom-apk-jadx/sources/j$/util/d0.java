package j$.util;

/* loaded from: classes2.dex */
public final class d0 {

    /* renamed from: c, reason: collision with root package name */
    public static final d0 f9412c = new d0();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f9413a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9414b;

    public d0() {
        this.f9413a = false;
        this.f9414b = 0;
    }

    public d0(int i10) {
        this.f9413a = true;
        this.f9414b = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        boolean z9 = d0Var.f9413a;
        boolean z10 = this.f9413a;
        return (z10 && z9) ? this.f9414b == d0Var.f9414b : z10 == z9;
    }

    public final int hashCode() {
        if (this.f9413a) {
            return this.f9414b;
        }
        return 0;
    }

    public final String toString() {
        if (this.f9413a) {
            return "OptionalInt[" + this.f9414b + "]";
        }
        return "OptionalInt.empty";
    }
}

package j$.util;

/* loaded from: classes2.dex */
public final class e0 {

    /* renamed from: c, reason: collision with root package name */
    public static final e0 f9419c = new e0();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f9420a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9421b;

    public e0() {
        this.f9420a = false;
        this.f9421b = 0L;
    }

    public e0(long j10) {
        this.f9420a = true;
        this.f9421b = j10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        boolean z9 = e0Var.f9420a;
        boolean z10 = this.f9420a;
        return (z10 && z9) ? this.f9421b == e0Var.f9421b : z10 == z9;
    }

    public final int hashCode() {
        if (!this.f9420a) {
            return 0;
        }
        long j10 = this.f9421b;
        return (int) (j10 ^ (j10 >>> 32));
    }

    public final String toString() {
        if (this.f9420a) {
            return "OptionalLong[" + this.f9421b + "]";
        }
        return "OptionalLong.empty";
    }
}

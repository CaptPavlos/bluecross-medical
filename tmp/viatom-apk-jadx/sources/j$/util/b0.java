package j$.util;

/* loaded from: classes2.dex */
public final class b0 {

    /* renamed from: b, reason: collision with root package name */
    public static final b0 f9349b = new b0();

    /* renamed from: a, reason: collision with root package name */
    public final Object f9350a;

    public b0() {
        this.f9350a = null;
    }

    public b0(Object obj) {
        this.f9350a = Objects.requireNonNull(obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b0) {
            return Objects.equals(this.f9350a, ((b0) obj).f9350a);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f9350a);
    }

    public final String toString() {
        Object obj = this.f9350a;
        return obj != null ? String.format("Optional[%s]", obj) : "Optional.empty";
    }
}

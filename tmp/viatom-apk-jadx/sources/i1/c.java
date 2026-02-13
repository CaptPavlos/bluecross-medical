package i1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends b {

    /* renamed from: a, reason: collision with root package name */
    public final Object f8961a;

    public c(Object obj) {
        this.f8961a = obj;
    }

    @Override // i1.b
    public final Object a() {
        return this.f8961a;
    }

    @Override // i1.b
    public final boolean b() {
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f8961a.equals(((c) obj).f8961a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f8961a.hashCode() + 1502476572;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f8961a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 13);
        sb.append("Optional.of(");
        sb.append(strValueOf);
        sb.append(")");
        return sb.toString();
    }
}

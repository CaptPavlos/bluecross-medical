package c1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u4 {

    /* renamed from: a, reason: collision with root package name */
    public final v4 f1502a;

    /* renamed from: b, reason: collision with root package name */
    public int f1503b = 1;

    /* renamed from: c, reason: collision with root package name */
    public long f1504c = a();

    public u4(v4 v4Var) {
        this.f1502a = v4Var;
    }

    public final long a() {
        v4 v4Var = this.f1502a;
        i0.y.g(v4Var);
        long jLongValue = ((Long) f0.f1201v.a(null)).longValue();
        long jLongValue2 = ((Long) f0.f1203w.a(null)).longValue();
        for (int i10 = 1; i10 < this.f1503b; i10++) {
            jLongValue += jLongValue;
            if (jLongValue >= jLongValue2) {
                break;
            }
        }
        v4Var.f().getClass();
        return Math.min(jLongValue, jLongValue2) + System.currentTimeMillis();
    }
}

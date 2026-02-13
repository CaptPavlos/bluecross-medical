package u7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f0 implements r7.k0 {

    /* renamed from: a, reason: collision with root package name */
    public final h0 f12994a;

    /* renamed from: b, reason: collision with root package name */
    public final long f12995b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f12996c;

    /* renamed from: d, reason: collision with root package name */
    public final r7.g f12997d;

    public f0(h0 h0Var, long j10, Object obj, r7.g gVar) {
        this.f12994a = h0Var;
        this.f12995b = j10;
        this.f12996c = obj;
        this.f12997d = gVar;
    }

    @Override // r7.k0
    public final void dispose() {
        h0 h0Var = this.f12994a;
        synchronized (h0Var) {
            if (this.f12995b < h0Var.l()) {
                return;
            }
            Object[] objArr = h0Var.e;
            objArr.getClass();
            long j10 = this.f12995b;
            if (objArr[((int) j10) & (objArr.length - 1)] != this) {
                return;
            }
            i0.c(objArr, j10, i0.f13005a);
            h0Var.g();
        }
    }
}

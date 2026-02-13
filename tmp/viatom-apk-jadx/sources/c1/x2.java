package c1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1567a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k2 f1568b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f1569c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f1570d;
    public final /* synthetic */ c3 e;

    public /* synthetic */ x2(c3 c3Var, k2 k2Var, long j10, boolean z9, int i10) {
        this.f1567a = i10;
        this.f1568b = k2Var;
        this.f1569c = j10;
        this.f1570d = z9;
        this.e = c3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1567a) {
            case 0:
                c3 c3Var = this.e;
                k2 k2Var = this.f1568b;
                c3Var.k(k2Var);
                c3Var.w(k2Var, this.f1569c, this.f1570d);
                break;
            default:
                c3 c3Var2 = this.e;
                k2 k2Var2 = this.f1568b;
                c3Var2.k(k2Var2);
                c3Var2.w(k2Var2, this.f1569c, this.f1570d);
                break;
        }
    }
}

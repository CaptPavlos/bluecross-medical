package p4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class l0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11988a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m0 f11989b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f11990c;

    public /* synthetic */ l0(m0 m0Var, String str, int i10) {
        this.f11988a = i10;
        this.f11989b = m0Var;
        this.f11990c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f11988a) {
            case 0:
                m0 m0Var = this.f11989b;
                m0Var.G();
                m0Var.j(this.f11990c);
                break;
            default:
                m0 m0Var2 = this.f11989b;
                m0Var2.G();
                m0Var2.j(this.f11990c);
                break;
        }
    }
}

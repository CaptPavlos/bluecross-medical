package c1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l3 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k3 f1324a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k3 f1325b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f1326c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f1327d;
    public final /* synthetic */ n3 e;

    public l3(n3 n3Var, k3 k3Var, k3 k3Var2, long j10, boolean z9) {
        this.f1324a = k3Var;
        this.f1325b = k3Var2;
        this.f1326c = j10;
        this.f1327d = z9;
        this.e = n3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.e.q(this.f1324a, this.f1325b, this.f1326c, this.f1327d, null);
    }
}

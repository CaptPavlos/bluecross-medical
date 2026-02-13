package androidx.work;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements g7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f674a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Worker f675b;

    public /* synthetic */ e(Worker worker, int i10) {
        this.f674a = i10;
        this.f675b = worker;
    }

    @Override // g7.a
    public final Object invoke() {
        switch (this.f674a) {
            case 0:
                return this.f675b.doWork();
            default:
                return this.f675b.getForegroundInfo();
        }
    }
}

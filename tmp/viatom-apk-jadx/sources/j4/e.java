package j4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9933a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i0 f9934b;

    public /* synthetic */ e(i0 i0Var, int i10) {
        this.f9933a = i10;
        this.f9934b = i0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9933a) {
            case 0:
                throw new IllegalStateException("Transformation " + this.f9934b.key() + " returned input Bitmap but recycled it.");
            default:
                throw new IllegalStateException("Transformation " + this.f9934b.key() + " mutated input Bitmap but failed to recycle the original.");
        }
    }
}

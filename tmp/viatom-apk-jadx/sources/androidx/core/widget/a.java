package androidx.core.widget;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f535a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ContentLoadingProgressBar f536b;

    public /* synthetic */ a(ContentLoadingProgressBar contentLoadingProgressBar, int i10) {
        this.f535a = i10;
        this.f536b = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f535a) {
            case 0:
                this.f536b.lambda$new$0();
                break;
            case 1:
                this.f536b.lambda$new$1();
                break;
            case 2:
                this.f536b.showOnUiThread();
                break;
            default:
                this.f536b.hideOnUiThread();
                break;
        }
    }
}

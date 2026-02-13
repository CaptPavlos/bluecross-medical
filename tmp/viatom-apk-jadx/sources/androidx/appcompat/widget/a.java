package androidx.appcompat.widget;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f438a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Toolbar f439b;

    public /* synthetic */ a(Toolbar toolbar, int i10) {
        this.f438a = i10;
        this.f439b = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f438a) {
            case 0:
                this.f439b.collapseActionView();
                break;
            default:
                this.f439b.invalidateMenu();
                break;
        }
    }
}

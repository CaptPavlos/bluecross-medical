package androidx.activity;

import androidx.activity.ComponentActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f423a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f424b;

    public /* synthetic */ d(Object obj, int i10) {
        this.f423a = i10;
        this.f424b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f423a) {
            case 0:
                ((ComponentActivity.ReportFullyDrawnExecutorApi16Impl) this.f424b).lambda$execute$0();
                break;
            case 1:
                ((ComponentActivity) this.f424b).invalidateMenu();
                break;
            case 2:
                ComponentDialog.onBackPressedDispatcher$lambda$1((ComponentDialog) this.f424b);
                break;
            default:
                FullyDrawnReporter.reportRunnable$lambda$2((FullyDrawnReporter) this.f424b);
                break;
        }
    }
}

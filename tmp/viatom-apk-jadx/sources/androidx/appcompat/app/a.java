package androidx.appcompat.app;

import android.content.Context;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f432a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f433b;

    public /* synthetic */ a(Context context, int i10) {
        this.f432a = i10;
        this.f433b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f432a) {
            case 0:
                AppCompatDelegate.lambda$syncRequestedAndStoredLocales$1(this.f433b);
                break;
            default:
                AppCompatDelegate.syncRequestedAndStoredLocales(this.f433b);
                break;
        }
    }
}

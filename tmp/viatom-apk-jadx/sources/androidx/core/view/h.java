package androidx.core.view;

import android.view.View;
import androidx.core.view.SoftwareKeyboardControllerCompat;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f523a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f524b;

    public /* synthetic */ h(Object obj, int i10) {
        this.f523a = i10;
        this.f524b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f523a) {
            case 0:
                SoftwareKeyboardControllerCompat.Impl20.lambda$show$0((View) this.f524b);
                break;
            default:
                ((g7.a) this.f524b).invoke();
                break;
        }
    }
}

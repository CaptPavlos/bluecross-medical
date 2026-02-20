package l4;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements ActivityResultCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10203a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppDetailActivity f10204b;

    public /* synthetic */ a(AppDetailActivity appDetailActivity, int i10) {
        this.f10203a = i10;
        this.f10204b = appDetailActivity;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        int i10 = this.f10203a;
        AppDetailActivity appDetailActivity = this.f10204b;
        ActivityResult activityResult = (ActivityResult) obj;
        switch (i10) {
            case 0:
                int i11 = AppDetailActivity.N;
                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(appDetailActivity);
                y7.e eVar = r7.i0.f12407a;
                r7.y.q(lifecycleScope, y7.d.f14116a, null, new a6.c(appDetailActivity, null, 12), 2);
                break;
            default:
                int i12 = AppDetailActivity.N;
                if (activityResult.getResultCode() == -1) {
                    float f = UptodownApp.E;
                    k4.c.E(appDetailActivity);
                    break;
                }
                break;
        }
    }
}

package e5;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7805a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j0 f7806b;

    public /* synthetic */ l(j0 j0Var, int i10) {
        this.f7805a = i10;
        this.f7806b = j0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7805a) {
            case 0:
                j0 j0Var = this.f7806b;
                if (j0Var.getContext() != null) {
                    Context contextRequireContext = j0Var.requireContext();
                    contextRequireContext.getClass();
                    boolean z9 = false;
                    try {
                        SharedPreferences sharedPreferences = contextRequireContext.getSharedPreferences("SettingsPreferences", 0);
                        if (sharedPreferences.contains("is_device_tracking_registered")) {
                            z9 = sharedPreferences.getBoolean("is_device_tracking_registered", false);
                        }
                    } catch (Exception unused) {
                    }
                    if (!z9) {
                        j0Var.a0();
                        break;
                    } else {
                        d5.b bVar = j0Var.f7785b;
                        bVar.getClass();
                        if (bVar.f6870d.getChildCount() > 0) {
                            d5.b bVar2 = j0Var.f7785b;
                            bVar2.getClass();
                            bVar2.f6870d.removeAllViews();
                            break;
                        }
                    }
                }
                break;
            default:
                j0 j0Var2 = this.f7806b;
                u7.m0 m0Var = j0Var2.G().Q;
                d5.b bVar3 = j0Var2.f7785b;
                bVar3.getClass();
                Integer numValueOf = Integer.valueOf(((View) bVar3.t.f7087k).getMeasuredWidth());
                m0Var.getClass();
                m0Var.g(null, numValueOf);
                if (((Boolean) j0Var2.G().N.getValue()).booleanValue()) {
                    j0Var2.w0();
                    break;
                }
                break;
        }
    }
}

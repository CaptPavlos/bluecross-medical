package com.mbridge.msdk.out;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.splash.d.c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBSplashHandler implements BaseExtraInterfaceForHandler {
    private static final String TAG = "MBSplashHandler";
    private static boolean canSkip = true;
    private static int defCountDownS = 5;
    private static int logoSizeH = 0;
    private static int logoSizeW = 0;
    private static int orientation = 1;
    private c splashProvider;
    private String unitId;

    public MBSplashHandler(String str, String str2, boolean z9, int i10, int i11, int i12, int i13) {
        String strE = ak.e(str2);
        if (!TextUtils.isEmpty(strE)) {
            ak.b(str2, strE);
        }
        this.unitId = str2;
        c cVar = new c((Activity) null, str, str2);
        this.splashProvider = cVar;
        cVar.b(z9);
        this.splashProvider.b(i10);
        this.splashProvider.a(i11);
        this.splashProvider.a(i12, i13);
    }

    public void allowClickSplash(boolean z9) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.d(z9);
        }
    }

    public ViewGroup createZoomOutByType(ZoomOutTypeEnum zoomOutTypeEnum) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            return cVar.a(zoomOutTypeEnum);
        }
        return null;
    }

    public String getCreativeIdWithUnitId() {
        c cVar = this.splashProvider;
        return cVar != null ? cVar.f() : "";
    }

    public String getRequestId() {
        c cVar = this.splashProvider;
        return cVar != null ? cVar.e() : "";
    }

    public boolean isReady(String str) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            return cVar.c(str);
        }
        return false;
    }

    public void loadAndShow(ViewGroup viewGroup) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.b("", viewGroup);
        }
    }

    public void loadAndShowByToken(String str, ViewGroup viewGroup) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(str, viewGroup);
        }
    }

    public void onDestroy() {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.k();
        }
    }

    public void onPause() {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.j();
        }
    }

    public void onResume() {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.i();
        }
    }

    public void preLoad() {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.b("");
        }
    }

    public void preLoadByToken(String str) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public void setDevCloseView(ViewGroup viewGroup) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(viewGroup);
        }
    }

    @Override // com.mbridge.msdk.out.BaseExtraInterfaceForHandler
    public void setExtraInfo(JSONObject jSONObject) throws JSONException {
        com.mbridge.msdk.foundation.controller.c.m().a(this.unitId, jSONObject);
    }

    public void setLoadTimeOut(long j10) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(j10);
        }
    }

    public void setLogoView(View view, int i10, int i11) {
        if (this.splashProvider != null) {
            this.splashProvider.a(view, new RelativeLayout.LayoutParams(i10, i11));
        }
    }

    public void setNotchScreenParameter(int i10, int i11, int i12, int i13) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(i10, i12, i11, i13);
        }
    }

    public void setOrientation(int i10) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(i10);
        }
    }

    public void setSplashLoadListener(MBSplashLoadListener mBSplashLoadListener) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(mBSplashLoadListener);
        }
    }

    public void setSplashShowListener(MBSplashShowListener mBSplashShowListener) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(mBSplashShowListener);
        }
    }

    public void setSupportZoomOut(boolean z9) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.c(z9);
        }
    }

    public void show(ViewGroup viewGroup) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.d("", viewGroup);
        }
    }

    public void zoomOutAttacked() {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.g();
        }
    }

    public void zoomOutPlayFinish() {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.h();
        }
    }

    public void loadAndShowByToken(String str, Activity activity) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(str, activity);
        }
    }

    public void loadAndShow(Activity activity) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.b("", activity);
        }
    }

    public void show(ViewGroup viewGroup, String str) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.c(str, viewGroup);
        }
    }

    public boolean isReady() {
        return isReady("");
    }

    public void show(Activity activity) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.d("", activity);
        }
    }

    public void show(Activity activity, String str) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.c(str, activity);
        }
    }

    public MBSplashHandler(Activity activity, String str, String str2) {
        this(activity, str, str2, canSkip, defCountDownS);
    }

    public MBSplashHandler(String str, String str2, boolean z9, int i10) {
        this(str, str2, z9, i10, orientation, logoSizeH, logoSizeW);
    }

    public MBSplashHandler(Activity activity, String str, String str2, boolean z9, int i10) {
        this(activity, str, str2, z9, i10, orientation, logoSizeH, logoSizeW);
    }

    public MBSplashHandler(String str, String str2) {
        this(str, str2, canSkip, defCountDownS);
    }

    public MBSplashHandler(Activity activity, String str, String str2, boolean z9, int i10, int i11, int i12, int i13) {
        String strE = ak.e(str2);
        if (!TextUtils.isEmpty(strE)) {
            ak.b(str2, strE);
        }
        c cVar = new c(activity, str, str2);
        this.splashProvider = cVar;
        cVar.b(z9);
        this.splashProvider.b(i10);
        this.splashProvider.a(i11);
        this.splashProvider.a(i12, i13);
    }
}

package com.mbridge.msdk.out;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.c.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbbanner.a.a;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBBannerView extends RelativeLayout implements BaseExtraInterfaceForHandler {
    private String bidToken;
    private a controller;
    private boolean hadAttached;
    private boolean isVisible;
    private BannerAdListener mBannerAdListener;
    private MBridgeIds mBridgeIds;
    private String unitId;

    public MBBannerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.hadAttached = false;
        this.isVisible = false;
        c.m().a(context);
    }

    private void callbackAndReportFail(com.mbridge.msdk.foundation.same.report.d.c cVar, b bVar) {
        String strB = "";
        if (bVar != null) {
            try {
                strB = bVar.b();
            } catch (Throwable th) {
                af.b("BannerView", th.getMessage());
            }
        }
        cVar.a(bVar);
        cVar.c(true);
        com.mbridge.msdk.mbbanner.common.d.a.a("2000047", cVar, null);
        BannerAdListener bannerAdListener = this.mBannerAdListener;
        if (bannerAdListener != null) {
            bannerAdListener.onLoadFailed(this.mBridgeIds, strB);
        }
    }

    private void delayedNotify() {
        postDelayed(new Runnable() { // from class: com.mbridge.msdk.out.MBBannerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (MBBannerView.this.controller == null || com.mbridge.msdk.foundation.d.b.f3437c) {
                    return;
                }
                MBBannerView.this.controller.c(true);
            }
        }, 200L);
    }

    private void updateAttachedState(boolean z9) {
        this.hadAttached = z9;
        a aVar = this.controller;
        if (aVar != null) {
            aVar.b(z9);
        }
    }

    public String getCreativeIdWithUnitId() {
        a aVar = this.controller;
        return aVar != null ? aVar.b() : "";
    }

    public String getRequestId() {
        a aVar = this.controller;
        return aVar != null ? aVar.a() : "";
    }

    public void init(BannerSize bannerSize, String str, String str2) {
        this.unitId = str2;
        this.mBridgeIds = new MBridgeIds(TextUtils.isEmpty(str) ? "" : str, str2);
        String strE = ak.e(str2);
        if (!TextUtils.isEmpty(strE)) {
            ak.b(str2, strE);
        }
        a aVar = new a(this, bannerSize, str, str2);
        this.controller = aVar;
        aVar.c(this.isVisible);
        this.controller.b(this.hadAttached);
    }

    public void load() {
        String strA = com.mbridge.msdk.mbbanner.common.d.a.a(this.bidToken);
        com.mbridge.msdk.foundation.same.report.d.c cVarA = com.mbridge.msdk.mbbanner.common.d.a.a(this.unitId, strA);
        cVarA.i("0");
        a aVar = this.controller;
        if (aVar != null) {
            aVar.b(this.hadAttached);
            this.controller.a("", strA);
        } else {
            b bVar = new b(880042);
            bVar.b(strA);
            callbackAndReportFail(cVarA, bVar);
        }
    }

    public void loadFromBid(String str) {
        this.bidToken = str;
        String strA = com.mbridge.msdk.mbbanner.common.d.a.a(str);
        com.mbridge.msdk.foundation.same.report.d.c cVarA = com.mbridge.msdk.mbbanner.common.d.a.a(this.unitId, strA);
        cVarA.i("1");
        if (this.controller == null) {
            b bVar = new b(880042);
            bVar.b(strA);
            callbackAndReportFail(cVarA, bVar);
        } else if (TextUtils.isEmpty(str)) {
            b bVar2 = new b(880035);
            bVar2.b(strA);
            callbackAndReportFail(cVarA, bVar2);
        } else {
            this.controller.b(this.hadAttached);
            this.controller.a(0);
            this.controller.a(str, strA);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateAttachedState(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        updateAttachedState(false);
    }

    public void onPause() {
        if (this.controller == null || !TextUtils.isEmpty(this.bidToken)) {
            return;
        }
        this.controller.e();
    }

    public void onResume() {
        if (this.controller == null || !TextUtils.isEmpty(this.bidToken) || com.mbridge.msdk.foundation.d.b.f3437c) {
            return;
        }
        this.controller.f();
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(i10, i11, i12, i13);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        this.isVisible = i10 == 0;
        a aVar = this.controller;
        if (aVar != null) {
            if (i10 == 0) {
                delayedNotify();
            } else {
                aVar.c(false);
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.isVisible = i10 == 0;
        if (this.controller != null) {
            if (i10 == 0) {
                delayedNotify();
            } else {
                if (com.mbridge.msdk.foundation.d.b.f3437c) {
                    return;
                }
                this.controller.c(false);
            }
        }
    }

    public void release() {
        if (this.mBannerAdListener != null) {
            this.mBannerAdListener = null;
        }
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a((BannerAdListener) null);
            this.controller.c();
        }
        removeAllViews();
    }

    public void setAllowShowCloseBtn(boolean z9) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(z9);
        }
    }

    public void setBannerAdListener(BannerAdListener bannerAdListener) {
        this.mBannerAdListener = bannerAdListener;
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(bannerAdListener);
        }
    }

    @Override // com.mbridge.msdk.out.BaseExtraInterfaceForHandler
    public void setExtraInfo(JSONObject jSONObject) throws JSONException {
        c.m().a(this.unitId, jSONObject);
    }

    public void setRefreshTime(int i10) {
        a aVar = this.controller;
        if (aVar == null || i10 < 0) {
            return;
        }
        aVar.a(i10);
    }

    public void updateBannerSize(BannerSize bannerSize) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(bannerSize);
        }
    }

    public MBBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBBannerView(Context context) {
        this(context, null);
    }
}

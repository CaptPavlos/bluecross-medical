package com.mbridge.msdk.video.module;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.video.signal.factory.b;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeClickMiniCardView extends MBridgeH5EndCardView {

    /* renamed from: w, reason: collision with root package name */
    private boolean f5922w;

    public MBridgeClickMiniCardView(Context context) {
        super(context);
        this.f5922w = false;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    public final String a() {
        CampaignEx campaignEx = this.f5901b;
        if (campaignEx != null) {
            CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
            strC = rewardTemplateMode != null ? rewardTemplateMode.c() : null;
            if (!TextUtils.isEmpty(strC) && strC.contains(".zip")) {
                String h5ResAddress = H5DownLoadManager.getInstance().getH5ResAddress(strC);
                if (!TextUtils.isEmpty(h5ResAddress)) {
                    return h5ResAddress;
                }
            }
        }
        return strC;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    public final RelativeLayout.LayoutParams b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        return layoutParams;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    @RequiresApi(api = 11)
    public final void e() {
        super.e();
        if (this.e) {
            setBackgroundResource(findColor("mbridge_reward_minicard_bg"));
            a(this.f5942m);
            setClickable(true);
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView, com.mbridge.msdk.video.module.MBridgeBaseView
    @RequiresApi(api = 11)
    public void onSelfConfigurationChanged(Configuration configuration) throws JSONException {
        if (this.e) {
            a(this.f5942m);
        }
        super.onSelfConfigurationChanged(configuration);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    public void preLoadData(b bVar) {
        super.preLoadData(bVar);
        setCloseVisible(0);
    }

    public void resizeMiniCard(int i10, int i11) {
        View viewFindViewById = ((Activity) this.f5900a).getWindow().findViewById(R.id.content);
        int width = viewFindViewById.getWidth();
        int height = viewFindViewById.getHeight();
        if (i10 <= 0 || i11 <= 0 || i10 > width || i11 > height) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f5942m.getLayoutParams();
        layoutParams.width = i10;
        layoutParams.height = i11;
        this.f5942m.setLayoutParams(layoutParams);
    }

    public void setMBridgeClickMiniCardViewClickable(boolean z9) {
        setClickable(z9);
    }

    public void setMBridgeClickMiniCardViewTransparent() {
        setBackgroundColor(0);
    }

    public void setMiniCardLocation(int i10, int i11, int i12, int i13) {
        this.f5922w = true;
        resizeMiniCard(i12, i13);
    }

    public void setRadius(int i10) {
        if (i10 > 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(ak.a(getContext(), i10));
            gradientDrawable.setColor(-1);
            this.f5945p.setBackground(gradientDrawable);
            this.f5945p.setClipToOutline(true);
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    public void webviewshow() {
        WindVaneWebView windVaneWebView = this.f5945p;
        if (windVaneWebView != null) {
            windVaneWebView.post(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeClickMiniCardView.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        af.a(MBridgeBaseView.TAG, "webviewshow");
                        String string = "";
                        try {
                            int[] iArr = new int[2];
                            MBridgeClickMiniCardView.this.f5945p.getLocationOnScreen(iArr);
                            af.b(MBridgeBaseView.TAG, "coordinate:" + iArr[0] + "--" + iArr[1]);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("startX", ak.b(c.m().c(), (float) iArr[0]));
                            jSONObject.put("startY", ak.b(c.m().c(), (float) iArr[1]));
                            string = jSONObject.toString();
                        } catch (Throwable th) {
                            af.b(MBridgeBaseView.TAG, th.getMessage(), th);
                        }
                        g.a().a((WebView) MBridgeClickMiniCardView.this.f5945p, "webviewshow", Base64.encodeToString(string.toString().getBytes(), 2));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            e eVar = new e();
            eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 3);
            d.a().a("2000133", this.f5901b, eVar);
        }
    }

    public MBridgeClickMiniCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5922w = false;
    }

    @RequiresApi(api = 11)
    private void a(View view) {
        int iF = ak.f(this.f5900a);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) ((iF * 0.7f) + 0.5f);
        layoutParams.height = (int) ((ak.e(this.f5900a) * 0.7f) + 0.5f);
        view.setLayoutParams(layoutParams);
    }
}

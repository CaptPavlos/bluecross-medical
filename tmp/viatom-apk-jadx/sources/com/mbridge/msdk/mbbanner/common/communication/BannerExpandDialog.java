package com.mbridge.msdk.mbbanner.common.communication;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbsignalcommon.mraid.b;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.mbridge.msdk.widget.MBAdChoice;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class BannerExpandDialog extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private final String f4260a;

    /* renamed from: b, reason: collision with root package name */
    private String f4261b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4262c;

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f4263d;
    private WindVaneWebView e;
    private TextView f;
    private String g;
    private List<CampaignEx> h;

    /* renamed from: i, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.b.a f4264i;

    /* renamed from: j, reason: collision with root package name */
    private b f4265j;

    public BannerExpandDialog(Context context, Bundle bundle, com.mbridge.msdk.mbbanner.common.b.a aVar) {
        super(context);
        this.f4260a = "BannerExpandDialog";
        this.f4265j = new b() { // from class: com.mbridge.msdk.mbbanner.common.communication.BannerExpandDialog.5
            @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
            public final void close() {
                BannerExpandDialog.this.dismiss();
            }

            @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
            public final CampaignEx getMraidCampaign() {
                return null;
            }

            @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
            public final void open(String str) {
                try {
                    if (BannerExpandDialog.this.e == null || System.currentTimeMillis() - BannerExpandDialog.this.e.lastTouchTime <= com.mbridge.msdk.click.b.a.f2793c || !com.mbridge.msdk.click.b.a.a((CampaignEx) BannerExpandDialog.this.h.get(0), BannerExpandDialog.this.e.getUrl(), com.mbridge.msdk.click.b.a.f2791a)) {
                        af.b("BannerExpandDialog", str);
                        if (BannerExpandDialog.this.h.size() > 1) {
                            c.m().c().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            str = null;
                        }
                        if (BannerExpandDialog.this.f4264i != null) {
                            BannerExpandDialog.this.f4264i.a(true, str);
                        }
                    }
                } catch (Throwable th) {
                    af.b("BannerExpandDialog", "open", th);
                }
            }

            @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
            public final void unload() {
                close();
            }

            @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
            public final void useCustomClose(boolean z9) {
                try {
                    BannerExpandDialog.this.f.setVisibility(z9 ? 4 : 0);
                } catch (Throwable th) {
                    af.b("BannerExpandDialog", "useCustomClose", th);
                }
            }

            @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
            public final void expand(String str, boolean z9) {
            }
        };
        if (bundle != null) {
            this.f4261b = bundle.getString("url");
            this.f4262c = bundle.getBoolean("shouldUseCustomClose");
        }
        this.f4264i = aVar;
    }

    public static /* synthetic */ void a(BannerExpandDialog bannerExpandDialog) {
        try {
            int i10 = c.m().c().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", i10 == 2 ? "landscape" : i10 == 1 ? "portrait" : "undefined");
            jSONObject.put("locked", "true");
            float fJ = ab.j(c.m().c());
            float fH = ab.h(c.m().c());
            HashMap mapI = ab.i(c.m().c());
            int iIntValue = ((Integer) mapI.get("width")).intValue();
            int iIntValue2 = ((Integer) mapI.get("height")).intValue();
            HashMap map = new HashMap();
            map.put(MRAIDCommunicatorUtil.KEY_PLACEMENTTYPE, MRAIDCommunicatorUtil.PLACEMENT_INTERSTITIAL);
            map.put(MRAIDCommunicatorUtil.KEY_STATE, MRAIDCommunicatorUtil.STATES_EXPANDED);
            map.put(MRAIDCommunicatorUtil.KEY_VIEWABLE, "true");
            map.put(MRAIDCommunicatorUtil.KEY_CURRENTORIENTATION, jSONObject);
            bannerExpandDialog.e.getLocationInWindow(new int[2]);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(bannerExpandDialog.e, r1[0], r1[1], r11.getWidth(), bannerExpandDialog.e.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(bannerExpandDialog.e, r1[0], r1[1], r5.getWidth(), bannerExpandDialog.e.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(bannerExpandDialog.e, fJ, fH);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(bannerExpandDialog.e, iIntValue, iIntValue2);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(bannerExpandDialog.e, map);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(bannerExpandDialog.e);
        } catch (Throwable th) {
            af.b("BannerExpandDialog", "notifyMraid", th);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        CampaignEx campaignEx;
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f4263d = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        WindVaneWebView windVaneWebView = new WindVaneWebView(getContext().getApplicationContext());
        this.e = windVaneWebView;
        windVaneWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f4263d.addView(this.e);
        TextView textView = new TextView(getContext());
        this.f = textView;
        textView.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = 8388661;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f.setLayoutParams(layoutParams);
        this.f.setVisibility(this.f4262c ? 4 : 0);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.mbbanner.common.communication.BannerExpandDialog.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BannerExpandDialog.this.dismiss();
            }
        });
        BitmapDrawable bitmapDrawableA = c.m().a(this.g, 296);
        if (bitmapDrawableA != null) {
            ImageView imageView = new ImageView(c.m().c());
            ak.a(imageView, bitmapDrawableA, this.f4263d.getResources().getDisplayMetrics());
            this.f4263d.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        }
        this.f4263d.addView(this.f);
        setContentView(this.f4263d);
        a();
        this.e.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() { // from class: com.mbridge.msdk.mbbanner.common.communication.BannerExpandDialog.2
            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, String str) {
                super.a(webView, str);
                webView.evaluateJavascript("javascript:" + com.mbridge.msdk.c.b.a.a().b(), new ValueCallback<String>() { // from class: com.mbridge.msdk.mbbanner.common.communication.BannerExpandDialog.2.1
                    @Override // android.webkit.ValueCallback
                    public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                    }
                });
                BannerExpandDialog.a(BannerExpandDialog.this);
            }
        });
        this.e.setObject(this.f4265j);
        this.e.loadUrl(this.f4261b);
        List<CampaignEx> list = this.h;
        if (list != null && list.size() > 0 && (campaignEx = this.h.get(0)) != null && campaignEx.getPrivacyButtonTemplateVisibility() != 0) {
            MBAdChoice mBAdChoice = new MBAdChoice(c.m().c());
            mBAdChoice.setCampaign(campaignEx);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.mbridge.msdk.dycreator.baseview.a.e(12.0f), com.mbridge.msdk.dycreator.baseview.a.e(12.0f));
            layoutParams2.gravity = 85;
            layoutParams2.bottomMargin = layoutParams.topMargin;
            layoutParams2.rightMargin = layoutParams.rightMargin;
            mBAdChoice.setFeedbackDialogEventListener(new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.mbbanner.common.communication.BannerExpandDialog.3
                @Override // com.mbridge.msdk.foundation.d.a
                public final void close() {
                    BannerExpandDialog.this.a();
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void summit(String str) {
                    BannerExpandDialog.this.a();
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void showed() {
                }
            });
            this.f4263d.addView(mBAdChoice, layoutParams2);
        }
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.mbridge.msdk.mbbanner.common.communication.BannerExpandDialog.4
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                if (BannerExpandDialog.this.f4264i != null) {
                    BannerExpandDialog.this.f4264i.a(false);
                }
                BannerExpandDialog.this.e.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
                BannerExpandDialog.this.f4263d.removeView(BannerExpandDialog.this.e);
                BannerExpandDialog.this.e.release();
                BannerExpandDialog.this.e = null;
                BannerExpandDialog.this.f4264i = null;
            }
        });
    }

    public void setCampaignList(String str, List<CampaignEx> list) {
        this.g = str;
        this.h = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            getWindow().setAttributes(attributes);
            getWindow().getDecorView().setSystemUiVisibility(4615);
        }
    }
}

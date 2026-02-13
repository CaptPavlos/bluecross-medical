package com.mbridge.msdk.newreward.player.view.ectemplate;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.at;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.function.command.retention.BridgeParameter;
import com.mbridge.msdk.newreward.player.iview.IBaseWebView;
import com.mbridge.msdk.newreward.player.presenter.ECWebPresenter;
import com.mbridge.msdk.newreward.player.view.floatview.FloatWebTemplateView;
import com.mbridge.msdk.newreward.player.view.hybrid.MBWebView;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MBCommunicatorUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class WebViewEC extends FrameLayout implements View.OnClickListener, IBaseWebView {
    private final String TAG;
    private boolean hasWebViewShow;
    private boolean isWebViewAttached;
    private ImageView mCloseImageView;
    private FloatWebTemplateView mExpandView;
    private ImageView mLinkImageView;
    private ECWebPresenter mWebECPresenter;
    private MBWebView mWebView;
    private final Runnable webViewShowRunnable;

    public WebViewEC(@NonNull Context context) {
        super(context);
        this.TAG = "WebViewEC";
        this.isWebViewAttached = false;
        this.hasWebViewShow = false;
        this.webViewShowRunnable = new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.ectemplate.WebViewEC.3
            @Override // java.lang.Runnable
            public void run() {
                WebViewEC.this.webViewShow();
                WebViewEC.this.setNotch();
            }
        };
        initPresenter();
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView, com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public ImageView getPrivacyButton() {
        return this.mLinkImageView;
    }

    public int getRenderStatus() {
        return this.mWebECPresenter.getRenderStatus();
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public MBWebView getWebView() {
        return this.mWebView;
    }

    public void initPresenter() {
        ECWebPresenter eCWebPresenter = new ECWebPresenter(this);
        this.mWebECPresenter = eCWebPresenter;
        eCWebPresenter.getView();
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public boolean initViews(boolean z9) {
        MBWebView mBWebView = new MBWebView(new MutableContextWrapper(c.m().c()));
        this.mWebView = mBWebView;
        mBWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mCloseImageView = new ImageView(getContext());
        int iA = ak.a(getContext(), 48.0f);
        int iA2 = ak.a(getContext(), 5.0f);
        int iA3 = ak.a(getContext(), 15.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
        layoutParams.topMargin = iA3;
        layoutParams.rightMargin = iA3;
        layoutParams.gravity = 8388661;
        this.mCloseImageView.setLayoutParams(layoutParams);
        this.mCloseImageView.setPadding(iA2, iA2, iA2, iA2);
        this.mCloseImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.mCloseImageView.setImageResource(x.a(getContext(), "mbridge_reward_close", "drawable"));
        this.mCloseImageView.setOnClickListener(this);
        this.mCloseImageView.setVisibility(4);
        this.mLinkImageView = new ImageView(getContext());
        int iA4 = ak.a(getContext(), 35.0f);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iA4, iA4);
        layoutParams2.topMargin = iA3;
        layoutParams2.leftMargin = iA3;
        layoutParams2.gravity = 8388659;
        this.mLinkImageView.setLayoutParams(layoutParams2);
        this.mLinkImageView.setImageResource(x.a(getContext(), "mbridge_reward_notice", "drawable"));
        this.mLinkImageView.setId(at.a());
        this.mLinkImageView.setOnClickListener(this);
        this.mLinkImageView.setVisibility(4);
        this.mWebView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.mbridge.msdk.newreward.player.view.ectemplate.WebViewEC.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                WebViewEC.this.isWebViewAttached = true;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                WebViewEC.this.isWebViewAttached = false;
            }
        });
        addView(this.mWebView);
        addView(this.mCloseImageView);
        return true;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public void onActivityLifeCycleCallback(String str) {
        ECWebPresenter eCWebPresenter = this.mWebECPresenter;
        if (eCWebPresenter != null) {
            eCWebPresenter.onActivityLifeCycleCallback(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mWebECPresenter.onAttachedToWindow();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ECWebPresenter eCWebPresenter = this.mWebECPresenter;
        if (eCWebPresenter != null) {
            eCWebPresenter.click(view);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public void onCloseViewClick(@BridgeParameter(key = ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY) int i10) {
        ECWebPresenter eCWebPresenter = this.mWebECPresenter;
        if (eCWebPresenter != null) {
            eCWebPresenter.click(null);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) throws JSONException {
        super.onConfigurationChanged(configuration);
        try {
            JSONObject jSONObject = new JSONObject();
            if (configuration.orientation == 2) {
                jSONObject.put("orientation", "landscape");
            } else {
                jSONObject.put("orientation", "portrait");
            }
            MBCommunicatorUtil.fireEvent(this.mWebView, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            af.b("WebViewEC", e.getMessage());
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public void onDestroyWebContent(@BridgeParameter(key = ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY) int i10) {
        MBWebView mBWebView = this.mWebView;
        if (mBWebView != null) {
            mBWebView.destroy();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.webViewShowRunnable);
        this.mWebECPresenter.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ECWebPresenter eCWebPresenter = this.mWebECPresenter;
        if (eCWebPresenter != null && motionEvent != null) {
            eCWebPresenter.handleInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public boolean onWebViewShow(@BridgeParameter(key = ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY) int i10) {
        if (this.mWebView.isAttachedToWindow()) {
            Rect rect = new Rect();
            this.mWebView.getHitRect(rect);
            if (this.mWebView.getLocalVisibleRect(rect)) {
                this.mWebView.post(this.webViewShowRunnable);
            }
        }
        if (this.hasWebViewShow) {
            return true;
        }
        this.hasWebViewShow = true;
        return false;
    }

    public void preloadWebContent(String str) {
        if (this.mWebView != null) {
            this.mWebECPresenter.addECModel();
            if (TextUtils.isEmpty(str)) {
                this.mWebECPresenter.setRenderError();
            } else {
                this.mWebView.loadUrl(str);
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public void removeTempleFromSuperView(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public void setNativeCloseButtonVisibility(int i10) {
        ECWebPresenter eCWebPresenter;
        ImageView imageView = this.mCloseImageView;
        if (imageView != null) {
            imageView.setVisibility(i10);
        }
        if (i10 != 0 || (eCWebPresenter = this.mWebECPresenter) == null) {
            return;
        }
        eCWebPresenter.setCanResponseBack(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setNotch() {
        /*
            r7 = this;
            android.view.WindowInsets r0 = r7.getRootWindowInsets()     // Catch: java.lang.Throwable -> L8c
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L8c
            r2 = 28
            if (r1 < r2) goto L8e
            android.view.DisplayCutout r0 = r0.getDisplayCutout()     // Catch: java.lang.Throwable -> L8c
            if (r0 == 0) goto L8e
            int r1 = r0.getSafeInsetLeft()     // Catch: java.lang.Throwable -> L8c
            int r2 = r0.getSafeInsetTop()     // Catch: java.lang.Throwable -> L8c
            int r3 = r0.getSafeInsetRight()     // Catch: java.lang.Throwable -> L8c
            int r0 = r0.getSafeInsetBottom()     // Catch: java.lang.Throwable -> L8c
            android.view.Display r4 = r7.getDisplay()     // Catch: java.lang.Throwable -> L8c
            int r4 = r4.getRotation()     // Catch: java.lang.Throwable -> L8c
            if (r4 != 0) goto L2b
            goto L3d
        L2b:
            r5 = 1
            if (r4 != r5) goto L31
            r4 = 90
            goto L3e
        L31:
            r5 = 2
            if (r4 != r5) goto L37
            r4 = 180(0xb4, float:2.52E-43)
            goto L3e
        L37:
            r5 = 3
            if (r4 != r5) goto L3d
            r4 = 270(0x10e, float:3.78E-43)
            goto L3e
        L3d:
            r4 = 0
        L3e:
            com.mbridge.msdk.newreward.player.presenter.ECWebPresenter r5 = r7.mWebECPresenter     // Catch: java.lang.Throwable -> L8c
            java.lang.String r4 = com.mbridge.msdk.foundation.tools.s.a(r4, r1, r3, r2, r0)     // Catch: java.lang.Throwable -> L8c
            r5.setNotchData(r4)     // Catch: java.lang.Throwable -> L8c
            android.content.Context r4 = r7.getContext()     // Catch: java.lang.Throwable -> L8c
            r5 = 1097859072(0x41700000, float:15.0)
            int r4 = com.mbridge.msdk.foundation.tools.ak.a(r4, r5)     // Catch: java.lang.Throwable -> L8c
            android.widget.ImageView r5 = r7.mCloseImageView     // Catch: java.lang.Throwable -> L8c
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()     // Catch: java.lang.Throwable -> L8c
            android.widget.FrameLayout$LayoutParams r5 = (android.widget.FrameLayout.LayoutParams) r5     // Catch: java.lang.Throwable -> L8c
            if (r2 != 0) goto L5d
            r6 = r4
            goto L5e
        L5d:
            r6 = r2
        L5e:
            r5.topMargin = r6     // Catch: java.lang.Throwable -> L8c
            r5.leftMargin = r1     // Catch: java.lang.Throwable -> L8c
            if (r3 != 0) goto L66
            r6 = r4
            goto L67
        L66:
            r6 = r3
        L67:
            r5.rightMargin = r6     // Catch: java.lang.Throwable -> L8c
            r5.bottomMargin = r0     // Catch: java.lang.Throwable -> L8c
            android.widget.ImageView r6 = r7.mCloseImageView     // Catch: java.lang.Throwable -> L8c
            r6.setLayoutParams(r5)     // Catch: java.lang.Throwable -> L8c
            android.widget.ImageView r5 = r7.mLinkImageView     // Catch: java.lang.Throwable -> L8c
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()     // Catch: java.lang.Throwable -> L8c
            android.widget.FrameLayout$LayoutParams r5 = (android.widget.FrameLayout.LayoutParams) r5     // Catch: java.lang.Throwable -> L8c
            if (r2 != 0) goto L7b
            r2 = r4
        L7b:
            r5.topMargin = r2     // Catch: java.lang.Throwable -> L8c
            if (r1 != 0) goto L80
            r1 = r4
        L80:
            r5.leftMargin = r1     // Catch: java.lang.Throwable -> L8c
            r5.rightMargin = r3     // Catch: java.lang.Throwable -> L8c
            r5.bottomMargin = r0     // Catch: java.lang.Throwable -> L8c
            android.widget.ImageView r0 = r7.mLinkImageView     // Catch: java.lang.Throwable -> L8c
            r0.setLayoutParams(r5)     // Catch: java.lang.Throwable -> L8c
            return
        L8c:
            r0 = move-exception
            goto L8f
        L8e:
            return
        L8f:
            java.lang.String r1 = "WebViewEC"
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.player.view.ectemplate.WebViewEC.setNotch():void");
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public void show(ViewGroup viewGroup) {
        if (getParent() != null) {
            viewGroup.bringToFront();
        } else if (viewGroup != null) {
            viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
        }
        this.mWebECPresenter.onShown();
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public void showMRAIDExpandView(String str, int i10) {
        if (this.mExpandView == null) {
            this.mExpandView = new FloatWebTemplateView(getContext());
        }
        this.mExpandView.setRenderUrl(str);
        this.mExpandView.setFloatViewType(FloatWebTemplateView.FLOAT_EXPAND_VIEW);
        this.mExpandView.addShowReqListener(new b() { // from class: com.mbridge.msdk.newreward.player.view.ectemplate.WebViewEC.2
            @Override // com.mbridge.msdk.newreward.a.b.b
            public void reqSuccessful(Object obj) {
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str2.equals("show") && str2.equals("remove")) {
                        WebViewEC webViewEC = WebViewEC.this;
                        webViewEC.removeView(webViewEC.mExpandView);
                    }
                }
            }

            @Override // com.mbridge.msdk.newreward.a.b.b
            public void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            }
        });
        this.mExpandView.show(this);
    }

    public void webViewShow() {
        try {
            if (this.mWebECPresenter.getRenderStatus() >= 2) {
                int i10 = getResources().getConfiguration().orientation;
                String str = "undefined";
                if (i10 != 0) {
                    if (i10 == 1) {
                        str = "portrait";
                    } else if (i10 == 2) {
                        str = "landscape";
                    }
                }
                MBCommunicatorUtil.notifyShowDataInfo(this.mWebView, i10, this.mWebECPresenter.getCampaignOrientation());
                MBCommunicatorUtil.notifyWebViewShowed(this.mWebView, str, this.mWebECPresenter.getWebViewShowExtraData());
            }
        } catch (Throwable th) {
            af.b("WebViewEC", th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public void hideCTAView() {
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public void showMiniCard() {
    }

    public WebViewEC(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "WebViewEC";
        this.isWebViewAttached = false;
        this.hasWebViewShow = false;
        this.webViewShowRunnable = new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.ectemplate.WebViewEC.3
            @Override // java.lang.Runnable
            public void run() {
                WebViewEC.this.webViewShow();
                WebViewEC.this.setNotch();
            }
        };
        initPresenter();
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public void addViewToCurrentViewGroup(View view) {
    }

    public WebViewEC(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.TAG = "WebViewEC";
        this.isWebViewAttached = false;
        this.hasWebViewShow = false;
        this.webViewShowRunnable = new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.ectemplate.WebViewEC.3
            @Override // java.lang.Runnable
            public void run() {
                WebViewEC.this.webViewShow();
                WebViewEC.this.setNotch();
            }
        };
        initPresenter();
    }

    @RequiresApi(api = 21)
    public WebViewEC(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.TAG = "WebViewEC";
        this.isWebViewAttached = false;
        this.hasWebViewShow = false;
        this.webViewShowRunnable = new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.ectemplate.WebViewEC.3
            @Override // java.lang.Runnable
            public void run() {
                WebViewEC.this.webViewShow();
                WebViewEC.this.setNotch();
            }
        };
        initPresenter();
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public void showCTAView(String str, CampaignEx campaignEx) {
    }
}

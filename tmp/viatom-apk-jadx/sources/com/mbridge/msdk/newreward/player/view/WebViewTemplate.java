package com.mbridge.msdk.newreward.player.view;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeSegmentsProgressBar;
import com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.at;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.function.command.retention.BridgeParameter;
import com.mbridge.msdk.newreward.player.iview.IWebTemplateView;
import com.mbridge.msdk.newreward.player.model.WebTemplateModel;
import com.mbridge.msdk.newreward.player.presenter.PlayWebPresenter;
import com.mbridge.msdk.newreward.player.view.floatview.AlertTempleView;
import com.mbridge.msdk.newreward.player.view.floatview.FloatWebTemplateView;
import com.mbridge.msdk.newreward.player.view.hybrid.MBWebView;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MBCommunicatorUtil;
import com.mbridge.msdk.playercommon.PlayerView;
import com.mbridge.msdk.video.module.MBridgeClickCTAView;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class WebViewTemplate extends FrameLayout implements View.OnClickListener, IWebTemplateView {
    final int CLOSE_BUILD_TYPE;
    private final String TAG;
    private final Runnable getNotchDataRunnable;
    private boolean hasWebViewShow;
    private final Runnable hideCTAViewRunnable;
    boolean isWebViewAttached;
    boolean isWebViewShowed;
    AlertTempleView mAlertTempleView;
    MBridgeClickCTAView mCTAView;
    ImageView mCloseImageView;
    TextView mCountDownTextView;
    ImageView mLinkImageView;
    FrameLayout mPlayerLayout;
    PlayerView mPlayerView;
    MBridgeSegmentsProgressBar mSegmentsProgressBar;
    SoundImageView mSoundImageView;
    RelativeLayout mTopControllerView;
    PlayWebPresenter mWebTemplatePresenter;
    MBWebView mWebView;
    FloatWebTemplateView miniCardView;
    private final Runnable webViewShowRunnable;

    public WebViewTemplate(@NonNull Context context) {
        super(context);
        this.TAG = "WebViewTemplate";
        this.CLOSE_BUILD_TYPE = 2;
        this.hasWebViewShow = false;
        this.getNotchDataRunnable = new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.WebViewTemplate.6
            /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0067  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0069  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x006e  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x006f  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    r8 = this;
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r0 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    android.view.WindowInsets r0 = r0.getRootWindowInsets()     // Catch: java.lang.Throwable -> L85
                    int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L85
                    r2 = 28
                    if (r1 < r2) goto L87
                    android.view.DisplayCutout r0 = r0.getDisplayCutout()     // Catch: java.lang.Throwable -> L85
                    if (r0 == 0) goto L87
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r1 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    android.widget.RelativeLayout r1 = r1.mTopControllerView     // Catch: java.lang.Throwable -> L85
                    if (r1 == 0) goto L87
                    int r1 = r0.getSafeInsetLeft()     // Catch: java.lang.Throwable -> L85
                    int r2 = r0.getSafeInsetTop()     // Catch: java.lang.Throwable -> L85
                    int r3 = r0.getSafeInsetRight()     // Catch: java.lang.Throwable -> L85
                    int r0 = r0.getSafeInsetBottom()     // Catch: java.lang.Throwable -> L85
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r4 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    android.view.Display r4 = r4.getDisplay()     // Catch: java.lang.Throwable -> L85
                    int r4 = r4.getRotation()     // Catch: java.lang.Throwable -> L85
                    if (r4 != 0) goto L35
                    goto L47
                L35:
                    r5 = 1
                    if (r4 != r5) goto L3b
                    r4 = 90
                    goto L48
                L3b:
                    r5 = 2
                    if (r4 != r5) goto L41
                    r4 = 180(0xb4, float:2.52E-43)
                    goto L48
                L41:
                    r5 = 3
                    if (r4 != r5) goto L47
                    r4 = 270(0x10e, float:3.78E-43)
                    goto L48
                L47:
                    r4 = 0
                L48:
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r5 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    android.widget.RelativeLayout r5 = r5.mTopControllerView     // Catch: java.lang.Throwable -> L85
                    android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()     // Catch: java.lang.Throwable -> L85
                    android.widget.FrameLayout$LayoutParams r5 = (android.widget.FrameLayout.LayoutParams) r5     // Catch: java.lang.Throwable -> L85
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r6 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    android.content.Context r6 = r6.getContext()     // Catch: java.lang.Throwable -> L85
                    r7 = 1092616192(0x41200000, float:10.0)
                    int r6 = com.mbridge.msdk.foundation.tools.ak.a(r6, r7)     // Catch: java.lang.Throwable -> L85
                    if (r1 != 0) goto L62
                    r7 = r6
                    goto L63
                L62:
                    r7 = r1
                L63:
                    r5.leftMargin = r7     // Catch: java.lang.Throwable -> L85
                    if (r2 != 0) goto L69
                    r7 = r6
                    goto L6a
                L69:
                    r7 = r2
                L6a:
                    r5.topMargin = r7     // Catch: java.lang.Throwable -> L85
                    if (r3 != 0) goto L6f
                    goto L70
                L6f:
                    r6 = r3
                L70:
                    r5.rightMargin = r6     // Catch: java.lang.Throwable -> L85
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r6 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    android.widget.RelativeLayout r6 = r6.mTopControllerView     // Catch: java.lang.Throwable -> L85
                    r6.setLayoutParams(r5)     // Catch: java.lang.Throwable -> L85
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r5 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    com.mbridge.msdk.newreward.player.presenter.PlayWebPresenter r5 = r5.mWebTemplatePresenter     // Catch: java.lang.Throwable -> L85
                    java.lang.String r0 = com.mbridge.msdk.foundation.tools.s.a(r4, r1, r3, r2, r0)     // Catch: java.lang.Throwable -> L85
                    r5.setNotchData(r0)     // Catch: java.lang.Throwable -> L85
                    return
                L85:
                    r0 = move-exception
                    goto L88
                L87:
                    return
                L88:
                    java.lang.String r1 = "WebViewTemplate"
                    java.lang.String r0 = r0.getMessage()
                    com.mbridge.msdk.foundation.tools.af.b(r1, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.player.view.WebViewTemplate.AnonymousClass6.run():void");
            }
        };
        this.hideCTAViewRunnable = new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.WebViewTemplate.7
            @Override // java.lang.Runnable
            public void run() {
                WebViewTemplate webViewTemplate = WebViewTemplate.this;
                webViewTemplate.removeView(webViewTemplate.mCTAView);
                WebViewTemplate.this.mSoundImageView.setVisibility(0);
            }
        };
        this.webViewShowRunnable = new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.WebViewTemplate.8
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                WebViewTemplate.this.webViewShow();
            }
        };
        initPresenter();
    }

    private RelativeLayout getTopControllerView() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        int iA = ak.a(getContext(), 10.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        layoutParams.leftMargin = iA;
        layoutParams.rightMargin = iA;
        layoutParams.topMargin = iA;
        relativeLayout.setLayoutParams(layoutParams);
        this.mLinkImageView = new ImageView(getContext());
        int iA2 = ak.a(getContext(), 35.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA2, iA2);
        layoutParams2.addRule(9);
        this.mLinkImageView.setLayoutParams(layoutParams2);
        this.mLinkImageView.setImageResource(x.a(getContext(), "mbridge_reward_notice", "drawable"));
        this.mLinkImageView.setId(at.a());
        this.mLinkImageView.setOnClickListener(this);
        this.mCountDownTextView = new TextView(getContext());
        int iA3 = ak.a(getContext(), 30.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iA3, iA3);
        layoutParams3.addRule(1, this.mLinkImageView.getId());
        layoutParams3.addRule(15);
        this.mCountDownTextView.setLayoutParams(layoutParams3);
        this.mCountDownTextView.setId(at.a());
        this.mCountDownTextView.setGravity(17);
        this.mCountDownTextView.setTextColor(-1);
        this.mCountDownTextView.setTextSize(11.0f);
        this.mCountDownTextView.setBackgroundResource(x.a(getContext(), "mbridge_reward_video_time_count_num_bg", "drawable"));
        this.mCloseImageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iA2, iA2);
        layoutParams4.addRule(11);
        this.mCloseImageView.setLayoutParams(layoutParams4);
        this.mCloseImageView.setImageResource(x.a(getContext(), "mbridge_reward_close", "drawable"));
        this.mCloseImageView.setVisibility(4);
        this.mCloseImageView.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.newreward.player.view.WebViewTemplate.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WebViewTemplate.this.onCloseViewClick(2);
            }
        });
        relativeLayout.addView(this.mLinkImageView);
        relativeLayout.addView(this.mCountDownTextView);
        relativeLayout.addView(this.mCloseImageView);
        return relativeLayout;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public void addViewToCurrentViewGroup(View view) {
        if (view != null) {
            addView(view);
        }
    }

    public void addWebView(MBWebView mBWebView, int i10) {
        if (mBWebView != null) {
            this.mWebView = mBWebView;
            mBWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.mWebView.getHybridCommunicator() instanceof WebTemplateModel) {
                this.mWebTemplatePresenter.setTemplateModel((WebTemplateModel) this.mWebView.getHybridCommunicator());
            }
            this.mWebView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.mbridge.msdk.newreward.player.view.WebViewTemplate.3
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    WebViewTemplate webViewTemplate = WebViewTemplate.this;
                    webViewTemplate.isWebViewAttached = true;
                    webViewTemplate.mWebTemplatePresenter.onWebViewShow();
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    WebViewTemplate.this.isWebViewAttached = false;
                }
            });
            addView(this.mWebView, i10);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void alertDismiss() {
        if (this.mAlertTempleView != null) {
            PlayerView playerView = this.mPlayerView;
            if (playerView != null) {
                playerView.resumeStart();
            }
            removeView(this.mAlertTempleView);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void alertShow() {
        if (this.mAlertTempleView != null) {
            PlayerView playerView = this.mPlayerView;
            if (playerView != null) {
                playerView.pause();
            }
            addView(this.mAlertTempleView);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IWebTemplateView
    public void changeVideoViewPosition(JSONObject jSONObject) {
        if (this.mPlayerView == null || jSONObject == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("margin_top", 0);
        int iOptInt2 = jSONObject.optInt("margin_left", 0);
        int iOptInt3 = jSONObject.optInt("view_width", 0);
        int iOptInt4 = jSONObject.optInt("view_height", 0);
        int iOptInt5 = jSONObject.optInt("radius", 0);
        if (iOptInt3 < 0 || iOptInt4 < 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPlayerLayout.getLayoutParams();
        layoutParams.width = iOptInt3;
        layoutParams.height = iOptInt4;
        layoutParams.topMargin = iOptInt;
        layoutParams.leftMargin = iOptInt2;
        if (iOptInt5 > 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(ak.a(getContext(), iOptInt5));
            gradientDrawable.setColor(-1);
            gradientDrawable.setStroke(1, 0);
            setBackground(gradientDrawable);
            this.mPlayerView.setBackground(gradientDrawable);
            setClipToOutline(true);
            this.mPlayerView.setClipToOutline(true);
        }
        this.mPlayerLayout.setLayoutParams(layoutParams);
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public View getBaitClickView() {
        return null;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public View getCountDownView() {
        return this.mCountDownTextView;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public boolean getMuteState() {
        SoundImageView soundImageView = this.mSoundImageView;
        if (soundImageView != null) {
            return soundImageView.getStatus();
        }
        return false;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView, com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public ImageView getPrivacyButton() {
        return this.mLinkImageView;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public MBridgeSegmentsProgressBar getSegmentsProgressBar() {
        return this.mSegmentsProgressBar;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public MBWebView getWebView() {
        return this.mWebView;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public void hideCTAView() {
        post(this.hideCTAViewRunnable);
    }

    public void initPresenter() {
        PlayWebPresenter playWebPresenter = new PlayWebPresenter(this);
        this.mWebTemplatePresenter = playWebPresenter;
        playWebPresenter.getView();
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public boolean initViews(boolean z9) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mPlayerLayout = new FrameLayout(getContext());
        PlayerView playerView = new PlayerView(getContext());
        this.mPlayerView = playerView;
        playerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mAlertTempleView = new AlertTempleView(getContext(), this.mWebTemplatePresenter);
        this.mSoundImageView = new SoundImageView(getContext());
        int iA = ak.a(getContext(), 35.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
        int iA2 = ak.a(getContext(), 10.0f);
        layoutParams.leftMargin = iA2;
        layoutParams.bottomMargin = iA2;
        layoutParams.gravity = 8388691;
        this.mSoundImageView.setLayoutParams(layoutParams);
        this.mSoundImageView.setOnClickListener(this);
        this.mSegmentsProgressBar = new MBridgeSegmentsProgressBar(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.mSegmentsProgressBar.setLayoutParams(layoutParams2);
        this.mPlayerLayout.addView(this.mPlayerView);
        this.mPlayerLayout.addView(this.mSoundImageView);
        this.mPlayerLayout.addView(this.mSegmentsProgressBar);
        this.mTopControllerView = getTopControllerView();
        addView(this.mPlayerLayout);
        addView(this.mTopControllerView);
        this.mPlayerView.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.newreward.player.view.WebViewTemplate.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WebViewTemplate.this.mWebTemplatePresenter.onClick(1);
            }
        });
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public void onActivityLifeCycleCallback(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.getClass();
        switch (str) {
            case "onDestroy":
                PlayWebPresenter playWebPresenter = this.mWebTemplatePresenter;
                if (playWebPresenter != null) {
                    playWebPresenter.onDestroy();
                }
                str2 = "onSystemDestory";
                break;
            case "onPause":
                PlayerView playerView = this.mPlayerView;
                if (playerView != null) {
                    playerView.pause();
                }
                PlayWebPresenter playWebPresenter2 = this.mWebTemplatePresenter;
                if (playWebPresenter2 != null) {
                    playWebPresenter2.onPause();
                }
                str2 = "onSystemPause";
                break;
            case "onBackPressed":
                PlayWebPresenter playWebPresenter3 = this.mWebTemplatePresenter;
                if (playWebPresenter3 != null) {
                    playWebPresenter3.onBackPressed();
                }
                str2 = "onSystemBackPressed";
                break;
            case "onStop":
                PlayerView playerView2 = this.mPlayerView;
                if (playerView2 != null) {
                    playerView2.stop();
                }
                str2 = "";
                break;
            case "onResume":
                PlayerView playerView3 = this.mPlayerView;
                if (playerView3 != null) {
                    playerView3.onResume();
                }
                PlayWebPresenter playWebPresenter4 = this.mWebTemplatePresenter;
                if (playWebPresenter4 != null) {
                    playWebPresenter4.onResume();
                }
                str2 = "onSystemResume";
                break;
            default:
                str2 = "";
                break;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        MBCommunicatorUtil.fireEvent(this.mWebView, str2, "");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mLinkImageView) {
            this.mWebTemplatePresenter.onClick(9);
        } else if (view == this.mSoundImageView) {
            this.mWebTemplatePresenter.onClick(5);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public void onCloseViewClick(@BridgeParameter(key = ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY) int i10) {
        PlayWebPresenter playWebPresenter = this.mWebTemplatePresenter;
        if (playWebPresenter != null) {
            playWebPresenter.onClick(2);
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
            af.b("WebViewTemplate", e.getMessage());
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
        removeCallbacks(this.getNotchDataRunnable);
        removeCallbacks(this.hideCTAViewRunnable);
        removeCallbacks(this.webViewShowRunnable);
        this.mWebTemplatePresenter.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        PlayWebPresenter playWebPresenter = this.mWebTemplatePresenter;
        if (playWebPresenter != null && motionEvent != null) {
            playWebPresenter.handleInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public boolean onWebViewShow(@BridgeParameter(key = ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY) int i10) {
        if (this.mWebView.isAttachedToWindow()) {
            this.mWebView.post(this.webViewShowRunnable);
        }
        if (this.hasWebViewShow) {
            return true;
        }
        this.hasWebViewShow = true;
        return false;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void pause() {
        PlayerView playerView = this.mPlayerView;
        if (playerView == null) {
            return;
        }
        playerView.pause();
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void play(String str, int i10) {
        this.mPlayerView.initBufferIngParam(i10);
        this.mPlayerView.initVFPData(str, str, this.mWebTemplatePresenter);
        this.mPlayerView.playVideo();
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IWebTemplateView
    public void playOrPauseVideo(int i10) {
        PlayerView playerView;
        if (i10 == -999) {
            return;
        }
        if (i10 == 1) {
            resume();
            return;
        }
        if (i10 == 2) {
            pause();
            return;
        }
        if (i10 == 3) {
            this.mPlayerView.stop();
        } else if (i10 == 6 && (playerView = this.mPlayerView) != null) {
            playerView.release();
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void release() {
        PlayerView playerView = this.mPlayerView;
        if (playerView != null) {
            playerView.release();
            this.mPlayerView = null;
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public void removeTempleFromSuperView(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void resume() {
        PlayerView playerView = this.mPlayerView;
        if (playerView == null) {
            return;
        }
        playerView.onResume();
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IWebTemplateView
    public void seekToPlay(int i10) {
        PlayerView playerView = this.mPlayerView;
        if (playerView == null || i10 == -1) {
            return;
        }
        playerView.seekTo(i10);
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void setAlertViewType(String str, int i10, int i11) {
        AlertTempleView alertTempleView = this.mAlertTempleView;
        if (alertTempleView != null) {
            alertTempleView.setAlertType(i10, str, i11);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void setCountDown(String str, int i10, int i11, ViewGroup.LayoutParams layoutParams) {
        TextView textView = this.mCountDownTextView;
        if (textView == null || textView.getVisibility() == 4) {
            return;
        }
        this.mCountDownTextView.setText(str);
        if (i10 != 0) {
            this.mCountDownTextView.setPadding(i10, 0, i10, 0);
        }
        if (layoutParams != null) {
            this.mCountDownTextView.setLayoutParams(layoutParams);
        }
        if (i11 != 0) {
            this.mCountDownTextView.setBackgroundResource(i11);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IWebTemplateView
    public void setMuteState(int i10, int i11) {
        SoundImageView soundImageView = this.mSoundImageView;
        if (soundImageView != null) {
            soundImageView.setVisibility(i11 == 1 ? 4 : 0);
            if (i10 == 1) {
                this.mSoundImageView.setSoundStatus(true);
            }
            if (i10 == 2) {
                this.mSoundImageView.setSoundStatus(false);
            }
        }
        PlayerView playerView = this.mPlayerView;
        if (playerView != null) {
            if (i10 == 1) {
                playerView.closeSound();
            }
            if (i10 == 2) {
                this.mPlayerView.openSound();
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public void setNativeCloseButtonVisibility(int i10) {
        PlayWebPresenter playWebPresenter;
        ImageView imageView = this.mCloseImageView;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(i10);
        if (i10 != 0 || (playWebPresenter = this.mWebTemplatePresenter) == null) {
            return;
        }
        playWebPresenter.setCanResponseBack(true);
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void setSegmentsProgressBar(int i10) {
        MBridgeSegmentsProgressBar mBridgeSegmentsProgressBar = this.mSegmentsProgressBar;
        if (mBridgeSegmentsProgressBar != null) {
            mBridgeSegmentsProgressBar.init(1, 3);
            this.mSegmentsProgressBar.setVisibility(i10);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public void show(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.addView(this);
        }
        postDelayed(this.getNotchDataRunnable, 500L);
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public void showCTAView(String str, CampaignEx campaignEx) {
        if (this.mCTAView == null) {
            MBridgeClickCTAView mBridgeClickCTAView = new MBridgeClickCTAView(getContext());
            this.mCTAView = mBridgeClickCTAView;
            mBridgeClickCTAView.setCampaign(campaignEx);
            this.mCTAView.setUnitId(str);
            this.mCTAView.preLoadData(null);
            this.mCTAView.setCtaClickCallBack(new MBridgeClickCTAView.a() { // from class: com.mbridge.msdk.newreward.player.view.WebViewTemplate.4
                @Override // com.mbridge.msdk.video.module.MBridgeClickCTAView.a
                public void ctaClick() {
                    WebViewTemplate.this.mWebTemplatePresenter.onClick(3);
                }
            });
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        addView(this.mCTAView, layoutParams);
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public void showMiniCard() {
        if (this.miniCardView == null) {
            FloatWebTemplateView floatWebTemplateView = new FloatWebTemplateView(getContext());
            this.miniCardView = floatWebTemplateView;
            floatWebTemplateView.setFloatViewType(FloatWebTemplateView.FLOAT_MINI_CARD);
        }
        this.miniCardView.addShowReqListener(new b() { // from class: com.mbridge.msdk.newreward.player.view.WebViewTemplate.5
            @Override // com.mbridge.msdk.newreward.a.b.b
            public void reqSuccessful(Object obj) {
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.equals("show")) {
                        WebViewTemplate.this.pause();
                    } else if (str.equals("remove")) {
                        WebViewTemplate.this.resume();
                    }
                }
            }

            @Override // com.mbridge.msdk.newreward.a.b.b
            public void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            }
        });
        this.miniCardView.show(this);
    }

    public void webViewShow() throws JSONException {
        if (this.isWebViewShowed) {
            return;
        }
        int i10 = getResources().getConfiguration().orientation;
        String str = "undefined";
        if (i10 != 0) {
            if (i10 == 1) {
                str = "portrait";
            } else if (i10 == 2) {
                str = "landscape";
            }
        }
        MBCommunicatorUtil.notifyShowDataInfo(this.mWebView, i10, this.mWebTemplatePresenter.getCampaignOrientation());
        MBCommunicatorUtil.notifyWebViewShowed(this.mWebView, str, this.mWebTemplatePresenter.getWebViewShowExtraData());
        this.isWebViewShowed = true;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void setAdCloseVisibility(boolean z9) {
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void setBackGroundImage(Bitmap bitmap) {
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void setTemplateWidthAndHeight(int i10) {
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void viewReport(Object obj) {
    }

    public WebViewTemplate(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "WebViewTemplate";
        this.CLOSE_BUILD_TYPE = 2;
        this.hasWebViewShow = false;
        this.getNotchDataRunnable = new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.WebViewTemplate.6
            @Override // java.lang.Runnable
            public void run() {
                /*
                    this = this;
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r0 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    android.view.WindowInsets r0 = r0.getRootWindowInsets()     // Catch: java.lang.Throwable -> L85
                    int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L85
                    r2 = 28
                    if (r1 < r2) goto L87
                    android.view.DisplayCutout r0 = r0.getDisplayCutout()     // Catch: java.lang.Throwable -> L85
                    if (r0 == 0) goto L87
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r1 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    android.widget.RelativeLayout r1 = r1.mTopControllerView     // Catch: java.lang.Throwable -> L85
                    if (r1 == 0) goto L87
                    int r1 = r0.getSafeInsetLeft()     // Catch: java.lang.Throwable -> L85
                    int r2 = r0.getSafeInsetTop()     // Catch: java.lang.Throwable -> L85
                    int r3 = r0.getSafeInsetRight()     // Catch: java.lang.Throwable -> L85
                    int r0 = r0.getSafeInsetBottom()     // Catch: java.lang.Throwable -> L85
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r4 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    android.view.Display r4 = r4.getDisplay()     // Catch: java.lang.Throwable -> L85
                    int r4 = r4.getRotation()     // Catch: java.lang.Throwable -> L85
                    if (r4 != 0) goto L35
                    goto L47
                L35:
                    r5 = 1
                    if (r4 != r5) goto L3b
                    r4 = 90
                    goto L48
                L3b:
                    r5 = 2
                    if (r4 != r5) goto L41
                    r4 = 180(0xb4, float:2.52E-43)
                    goto L48
                L41:
                    r5 = 3
                    if (r4 != r5) goto L47
                    r4 = 270(0x10e, float:3.78E-43)
                    goto L48
                L47:
                    r4 = 0
                L48:
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r5 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    android.widget.RelativeLayout r5 = r5.mTopControllerView     // Catch: java.lang.Throwable -> L85
                    android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()     // Catch: java.lang.Throwable -> L85
                    android.widget.FrameLayout$LayoutParams r5 = (android.widget.FrameLayout.LayoutParams) r5     // Catch: java.lang.Throwable -> L85
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r6 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    android.content.Context r6 = r6.getContext()     // Catch: java.lang.Throwable -> L85
                    r7 = 1092616192(0x41200000, float:10.0)
                    int r6 = com.mbridge.msdk.foundation.tools.ak.a(r6, r7)     // Catch: java.lang.Throwable -> L85
                    if (r1 != 0) goto L62
                    r7 = r6
                    goto L63
                L62:
                    r7 = r1
                L63:
                    r5.leftMargin = r7     // Catch: java.lang.Throwable -> L85
                    if (r2 != 0) goto L69
                    r7 = r6
                    goto L6a
                L69:
                    r7 = r2
                L6a:
                    r5.topMargin = r7     // Catch: java.lang.Throwable -> L85
                    if (r3 != 0) goto L6f
                    goto L70
                L6f:
                    r6 = r3
                L70:
                    r5.rightMargin = r6     // Catch: java.lang.Throwable -> L85
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r6 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    android.widget.RelativeLayout r6 = r6.mTopControllerView     // Catch: java.lang.Throwable -> L85
                    r6.setLayoutParams(r5)     // Catch: java.lang.Throwable -> L85
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r5 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    com.mbridge.msdk.newreward.player.presenter.PlayWebPresenter r5 = r5.mWebTemplatePresenter     // Catch: java.lang.Throwable -> L85
                    java.lang.String r0 = com.mbridge.msdk.foundation.tools.s.a(r4, r1, r3, r2, r0)     // Catch: java.lang.Throwable -> L85
                    r5.setNotchData(r0)     // Catch: java.lang.Throwable -> L85
                    return
                L85:
                    r0 = move-exception
                    goto L88
                L87:
                    return
                L88:
                    java.lang.String r1 = "WebViewTemplate"
                    java.lang.String r0 = r0.getMessage()
                    com.mbridge.msdk.foundation.tools.af.b(r1, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.player.view.WebViewTemplate.AnonymousClass6.run():void");
            }
        };
        this.hideCTAViewRunnable = new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.WebViewTemplate.7
            @Override // java.lang.Runnable
            public void run() {
                WebViewTemplate webViewTemplate = WebViewTemplate.this;
                webViewTemplate.removeView(webViewTemplate.mCTAView);
                WebViewTemplate.this.mSoundImageView.setVisibility(0);
            }
        };
        this.webViewShowRunnable = new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.WebViewTemplate.8
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                WebViewTemplate.this.webViewShow();
            }
        };
        initPresenter();
    }

    public WebViewTemplate(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.TAG = "WebViewTemplate";
        this.CLOSE_BUILD_TYPE = 2;
        this.hasWebViewShow = false;
        this.getNotchDataRunnable = new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.WebViewTemplate.6
            @Override // java.lang.Runnable
            public void run() {
                /*
                    this = this;
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r0 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    android.view.WindowInsets r0 = r0.getRootWindowInsets()     // Catch: java.lang.Throwable -> L85
                    int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L85
                    r2 = 28
                    if (r1 < r2) goto L87
                    android.view.DisplayCutout r0 = r0.getDisplayCutout()     // Catch: java.lang.Throwable -> L85
                    if (r0 == 0) goto L87
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r1 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    android.widget.RelativeLayout r1 = r1.mTopControllerView     // Catch: java.lang.Throwable -> L85
                    if (r1 == 0) goto L87
                    int r1 = r0.getSafeInsetLeft()     // Catch: java.lang.Throwable -> L85
                    int r2 = r0.getSafeInsetTop()     // Catch: java.lang.Throwable -> L85
                    int r3 = r0.getSafeInsetRight()     // Catch: java.lang.Throwable -> L85
                    int r0 = r0.getSafeInsetBottom()     // Catch: java.lang.Throwable -> L85
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r4 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    android.view.Display r4 = r4.getDisplay()     // Catch: java.lang.Throwable -> L85
                    int r4 = r4.getRotation()     // Catch: java.lang.Throwable -> L85
                    if (r4 != 0) goto L35
                    goto L47
                L35:
                    r5 = 1
                    if (r4 != r5) goto L3b
                    r4 = 90
                    goto L48
                L3b:
                    r5 = 2
                    if (r4 != r5) goto L41
                    r4 = 180(0xb4, float:2.52E-43)
                    goto L48
                L41:
                    r5 = 3
                    if (r4 != r5) goto L47
                    r4 = 270(0x10e, float:3.78E-43)
                    goto L48
                L47:
                    r4 = 0
                L48:
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r5 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    android.widget.RelativeLayout r5 = r5.mTopControllerView     // Catch: java.lang.Throwable -> L85
                    android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()     // Catch: java.lang.Throwable -> L85
                    android.widget.FrameLayout$LayoutParams r5 = (android.widget.FrameLayout.LayoutParams) r5     // Catch: java.lang.Throwable -> L85
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r6 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    android.content.Context r6 = r6.getContext()     // Catch: java.lang.Throwable -> L85
                    r7 = 1092616192(0x41200000, float:10.0)
                    int r6 = com.mbridge.msdk.foundation.tools.ak.a(r6, r7)     // Catch: java.lang.Throwable -> L85
                    if (r1 != 0) goto L62
                    r7 = r6
                    goto L63
                L62:
                    r7 = r1
                L63:
                    r5.leftMargin = r7     // Catch: java.lang.Throwable -> L85
                    if (r2 != 0) goto L69
                    r7 = r6
                    goto L6a
                L69:
                    r7 = r2
                L6a:
                    r5.topMargin = r7     // Catch: java.lang.Throwable -> L85
                    if (r3 != 0) goto L6f
                    goto L70
                L6f:
                    r6 = r3
                L70:
                    r5.rightMargin = r6     // Catch: java.lang.Throwable -> L85
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r6 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    android.widget.RelativeLayout r6 = r6.mTopControllerView     // Catch: java.lang.Throwable -> L85
                    r6.setLayoutParams(r5)     // Catch: java.lang.Throwable -> L85
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r5 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    com.mbridge.msdk.newreward.player.presenter.PlayWebPresenter r5 = r5.mWebTemplatePresenter     // Catch: java.lang.Throwable -> L85
                    java.lang.String r0 = com.mbridge.msdk.foundation.tools.s.a(r4, r1, r3, r2, r0)     // Catch: java.lang.Throwable -> L85
                    r5.setNotchData(r0)     // Catch: java.lang.Throwable -> L85
                    return
                L85:
                    r0 = move-exception
                    goto L88
                L87:
                    return
                L88:
                    java.lang.String r1 = "WebViewTemplate"
                    java.lang.String r0 = r0.getMessage()
                    com.mbridge.msdk.foundation.tools.af.b(r1, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.player.view.WebViewTemplate.AnonymousClass6.run():void");
            }
        };
        this.hideCTAViewRunnable = new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.WebViewTemplate.7
            @Override // java.lang.Runnable
            public void run() {
                WebViewTemplate webViewTemplate = WebViewTemplate.this;
                webViewTemplate.removeView(webViewTemplate.mCTAView);
                WebViewTemplate.this.mSoundImageView.setVisibility(0);
            }
        };
        this.webViewShowRunnable = new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.WebViewTemplate.8
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                WebViewTemplate.this.webViewShow();
            }
        };
        initPresenter();
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void setMuteState(boolean z9) {
        SoundImageView soundImageView = this.mSoundImageView;
        if (soundImageView != null) {
            soundImageView.setSoundStatus(z9);
        }
        PlayerView playerView = this.mPlayerView;
        if (playerView != null) {
            if (z9) {
                playerView.openSound();
            } else {
                playerView.closeSound();
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public void showMRAIDExpandView(String str, int i10) {
    }

    @RequiresApi(api = 21)
    public WebViewTemplate(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.TAG = "WebViewTemplate";
        this.CLOSE_BUILD_TYPE = 2;
        this.hasWebViewShow = false;
        this.getNotchDataRunnable = new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.WebViewTemplate.6
            @Override // java.lang.Runnable
            public void run() {
                /*
                    this = this;
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r0 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    android.view.WindowInsets r0 = r0.getRootWindowInsets()     // Catch: java.lang.Throwable -> L85
                    int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L85
                    r2 = 28
                    if (r1 < r2) goto L87
                    android.view.DisplayCutout r0 = r0.getDisplayCutout()     // Catch: java.lang.Throwable -> L85
                    if (r0 == 0) goto L87
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r1 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    android.widget.RelativeLayout r1 = r1.mTopControllerView     // Catch: java.lang.Throwable -> L85
                    if (r1 == 0) goto L87
                    int r1 = r0.getSafeInsetLeft()     // Catch: java.lang.Throwable -> L85
                    int r2 = r0.getSafeInsetTop()     // Catch: java.lang.Throwable -> L85
                    int r3 = r0.getSafeInsetRight()     // Catch: java.lang.Throwable -> L85
                    int r0 = r0.getSafeInsetBottom()     // Catch: java.lang.Throwable -> L85
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r4 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    android.view.Display r4 = r4.getDisplay()     // Catch: java.lang.Throwable -> L85
                    int r4 = r4.getRotation()     // Catch: java.lang.Throwable -> L85
                    if (r4 != 0) goto L35
                    goto L47
                L35:
                    r5 = 1
                    if (r4 != r5) goto L3b
                    r4 = 90
                    goto L48
                L3b:
                    r5 = 2
                    if (r4 != r5) goto L41
                    r4 = 180(0xb4, float:2.52E-43)
                    goto L48
                L41:
                    r5 = 3
                    if (r4 != r5) goto L47
                    r4 = 270(0x10e, float:3.78E-43)
                    goto L48
                L47:
                    r4 = 0
                L48:
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r5 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    android.widget.RelativeLayout r5 = r5.mTopControllerView     // Catch: java.lang.Throwable -> L85
                    android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()     // Catch: java.lang.Throwable -> L85
                    android.widget.FrameLayout$LayoutParams r5 = (android.widget.FrameLayout.LayoutParams) r5     // Catch: java.lang.Throwable -> L85
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r6 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    android.content.Context r6 = r6.getContext()     // Catch: java.lang.Throwable -> L85
                    r7 = 1092616192(0x41200000, float:10.0)
                    int r6 = com.mbridge.msdk.foundation.tools.ak.a(r6, r7)     // Catch: java.lang.Throwable -> L85
                    if (r1 != 0) goto L62
                    r7 = r6
                    goto L63
                L62:
                    r7 = r1
                L63:
                    r5.leftMargin = r7     // Catch: java.lang.Throwable -> L85
                    if (r2 != 0) goto L69
                    r7 = r6
                    goto L6a
                L69:
                    r7 = r2
                L6a:
                    r5.topMargin = r7     // Catch: java.lang.Throwable -> L85
                    if (r3 != 0) goto L6f
                    goto L70
                L6f:
                    r6 = r3
                L70:
                    r5.rightMargin = r6     // Catch: java.lang.Throwable -> L85
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r6 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    android.widget.RelativeLayout r6 = r6.mTopControllerView     // Catch: java.lang.Throwable -> L85
                    r6.setLayoutParams(r5)     // Catch: java.lang.Throwable -> L85
                    com.mbridge.msdk.newreward.player.view.WebViewTemplate r5 = com.mbridge.msdk.newreward.player.view.WebViewTemplate.this     // Catch: java.lang.Throwable -> L85
                    com.mbridge.msdk.newreward.player.presenter.PlayWebPresenter r5 = r5.mWebTemplatePresenter     // Catch: java.lang.Throwable -> L85
                    java.lang.String r0 = com.mbridge.msdk.foundation.tools.s.a(r4, r1, r3, r2, r0)     // Catch: java.lang.Throwable -> L85
                    r5.setNotchData(r0)     // Catch: java.lang.Throwable -> L85
                    return
                L85:
                    r0 = move-exception
                    goto L88
                L87:
                    return
                L88:
                    java.lang.String r1 = "WebViewTemplate"
                    java.lang.String r0 = r0.getMessage()
                    com.mbridge.msdk.foundation.tools.af.b(r1, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.player.view.WebViewTemplate.AnonymousClass6.run():void");
            }
        };
        this.hideCTAViewRunnable = new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.WebViewTemplate.7
            @Override // java.lang.Runnable
            public void run() {
                WebViewTemplate webViewTemplate = WebViewTemplate.this;
                webViewTemplate.removeView(webViewTemplate.mCTAView);
                WebViewTemplate.this.mSoundImageView.setVisibility(0);
            }
        };
        this.webViewShowRunnable = new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.WebViewTemplate.8
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                WebViewTemplate.this.webViewShow();
            }
        };
        initPresenter();
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void setPlayerSize(int i10, int i11, int i12) {
    }
}

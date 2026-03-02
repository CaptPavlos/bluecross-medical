package com.mbridge.msdk.newreward.player.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AttributeSet;
import android.view.DisplayCutout;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeSegmentsProgressBar;
import com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView;
import com.mbridge.msdk.newreward.player.iview.IPlayTempleView;
import com.mbridge.msdk.newreward.player.presenter.PlayTemplePresenter;
import com.mbridge.msdk.newreward.player.view.floatview.AlertTempleView;
import com.mbridge.msdk.playercommon.PlayerView;
import com.mbridge.msdk.widget.FeedBackButton;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class BaseTemplate extends RelativeLayout implements View.OnClickListener, IPlayTempleView {
    private static final String TAG = "BaseTemplate";
    protected AlertTempleView alertTempleView;
    protected ImageView bgImageView;
    protected CollapsibleWebView collapsibleWebVew;
    protected RelativeLayout collapsibleWebVewHeader;
    protected RelativeLayout collapsibleWebVewLayout;
    protected FeedBackButton feedBackButton;
    private final Runnable getCutoutRunnable;
    protected MBridgeBaitClickView mBaitClickView;
    protected FrameLayout mCtaLayout;
    protected boolean mDyXmlSuccess;
    protected PlayerView mPlayerView;
    protected MBridgeSegmentsProgressBar mSegmentsProgressBar;
    protected SoundImageView mSoundImageView;
    protected RelativeLayout mTopControllerView;
    protected TextView mTvCountDown;
    protected View mViewPlayingClose;
    protected PlayTemplePresenter presenter;
    protected ImageView privacyButton;
    protected ProgressBar videoProgressBar;

    public BaseTemplate(@NonNull Context context) {
        super(context);
        this.mDyXmlSuccess = false;
        this.getCutoutRunnable = new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.BaseTemplate.1
            @Override // java.lang.Runnable
            public void run() {
                DisplayCutout displayCutout;
                try {
                    PlayTemplePresenter playTemplePresenter = BaseTemplate.this.presenter;
                    if (playTemplePresenter == null || !playTemplePresenter.isHalfScreenOffer()) {
                        WindowInsets rootWindowInsets = BaseTemplate.this.getRootWindowInsets();
                        if (Build.VERSION.SDK_INT < 28 || rootWindowInsets == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null || BaseTemplate.this.mTopControllerView == null) {
                            return;
                        }
                        int safeInsetLeft = displayCutout.getSafeInsetLeft();
                        int safeInsetTop = displayCutout.getSafeInsetTop();
                        int safeInsetRight = displayCutout.getSafeInsetRight();
                        displayCutout.getSafeInsetBottom();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) BaseTemplate.this.mTopControllerView.getLayoutParams();
                        int iA = ak.a(BaseTemplate.this.getContext(), 9.0f);
                        if (safeInsetLeft == 0) {
                            safeInsetLeft = iA;
                        }
                        layoutParams.leftMargin = safeInsetLeft;
                        if (safeInsetTop == 0) {
                            safeInsetTop = iA;
                        }
                        layoutParams.topMargin = safeInsetTop;
                        if (safeInsetRight == 0) {
                            safeInsetRight = iA;
                        }
                        layoutParams.rightMargin = safeInsetRight;
                        BaseTemplate.this.mTopControllerView.setLayoutParams(layoutParams);
                    }
                } catch (Throwable th) {
                    af.b(BaseTemplate.TAG, th.getMessage());
                }
            }
        };
    }

    public void addClickEvent() {
        View view = this.mViewPlayingClose;
        if (view != null) {
            view.setOnClickListener(this);
        }
        SoundImageView soundImageView = this.mSoundImageView;
        if (soundImageView != null) {
            soundImageView.setOnClickListener(this);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public void addViewToCurrentViewGroup(View view) {
        addView(view);
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void alertDismiss() {
        if (this.alertTempleView != null) {
            PlayTemplePresenter playTemplePresenter = this.presenter;
            if (playTemplePresenter != null) {
                playTemplePresenter.onResume();
            }
            removeView(this.alertTempleView);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void alertShow() {
        if (this.alertTempleView != null) {
            PlayTemplePresenter playTemplePresenter = this.presenter;
            if (playTemplePresenter != null) {
                playTemplePresenter.onPause();
            }
            addView(this.alertTempleView);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public View getBaitClickView() {
        MBridgeBaitClickView mBridgeBaitClickView = this.mBaitClickView;
        if (mBridgeBaitClickView == null) {
            return null;
        }
        return mBridgeBaitClickView;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public View getCountDownView() {
        return this.mTvCountDown;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public boolean getMuteState() {
        PlayerView playerView = this.mPlayerView;
        if (playerView == null) {
            return true;
        }
        return playerView.isSilent();
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public ImageView getPrivacyButton() {
        return this.privacyButton;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public MBridgeSegmentsProgressBar getSegmentsProgressBar() {
        return this.mSegmentsProgressBar;
    }

    public PlayerView getmPlayerView() {
        return this.mPlayerView;
    }

    public SoundImageView getmSoundImageView() {
        return this.mSoundImageView;
    }

    public TextView getmTvCountDown() {
        return this.mTvCountDown;
    }

    public View getmViewPlayingClose() {
        return this.mViewPlayingClose;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public boolean initViews(boolean z9) {
        this.mDyXmlSuccess = z9;
        try {
            this.alertTempleView = new AlertTempleView(getContext(), this.presenter);
            this.mPlayerView = (PlayerView) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_vfpv"));
            this.mSoundImageView = (SoundImageView) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_sound_switch"));
            this.mTvCountDown = (TextView) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_tv_count"));
            View viewFindViewById = findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_rl_playing_close"));
            this.mViewPlayingClose = viewFindViewById;
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(4);
            }
            this.mTopControllerView = (RelativeLayout) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_top_control"));
            this.bgImageView = (ImageView) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_videoview_bg"));
            this.videoProgressBar = (ProgressBar) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_video_progress_bar"));
            this.feedBackButton = (FeedBackButton) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_native_endcard_feed_btn"));
            this.privacyButton = (ImageView) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_iv_link"));
            this.collapsibleWebVewLayout = (RelativeLayout) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_reward_scale_webview_layout"));
            this.collapsibleWebVewHeader = (RelativeLayout) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_reward_header_layout"));
            if (this.collapsibleWebVewLayout != null) {
                CollapsibleWebView collapsibleWebView = new CollapsibleWebView(getContext());
                this.collapsibleWebVew = collapsibleWebView;
                this.collapsibleWebVewLayout.addView(collapsibleWebView, new RelativeLayout.LayoutParams(-1, -1));
            }
            this.mSegmentsProgressBar = (MBridgeSegmentsProgressBar) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_reward_segment_progressbar"));
            this.mCtaLayout = (FrameLayout) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_reward_cta_layout"));
            this.mBaitClickView = (MBridgeBaitClickView) findViewById(this.presenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_animation_click_view"));
            addClickEvent();
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
        return this.presenter.isNotNULL(this.mPlayerView, this.mSoundImageView, this.mTvCountDown, this.mViewPlayingClose, this.mTopControllerView);
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public void onActivityLifeCycleCallback(String str) {
        str.getClass();
        switch (str) {
            case "onDestroy":
                PlayTemplePresenter playTemplePresenter = this.presenter;
                if (playTemplePresenter != null) {
                    playTemplePresenter.onDestroy();
                    break;
                }
                break;
            case "onPause":
                PlayTemplePresenter playTemplePresenter2 = this.presenter;
                if (playTemplePresenter2 != null) {
                    playTemplePresenter2.onPause();
                    break;
                }
                break;
            case "onBackPressed":
                PlayTemplePresenter playTemplePresenter3 = this.presenter;
                if (playTemplePresenter3 != null) {
                    playTemplePresenter3.onBackPressed();
                    break;
                }
                break;
            case "onResume":
                PlayTemplePresenter playTemplePresenter4 = this.presenter;
                if (playTemplePresenter4 != null) {
                    playTemplePresenter4.onResume();
                    break;
                }
                break;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.presenter.addBaitClickView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PlayTemplePresenter playTemplePresenter = this.presenter;
        if (playTemplePresenter == null) {
            return;
        }
        playTemplePresenter.click(view);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        PlayTemplePresenter playTemplePresenter = this.presenter;
        if (playTemplePresenter != null && motionEvent != null) {
            playTemplePresenter.handleInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z9) {
        super.onWindowFocusChanged(z9);
        PlayTemplePresenter playTemplePresenter = this.presenter;
        if (playTemplePresenter == null) {
            return;
        }
        playTemplePresenter.windowFocusChanged();
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
        PlayerView playerView = this.mPlayerView;
        if (playerView == null) {
            return;
        }
        playerView.initBufferIngParam(i10);
        this.mPlayerView.initVFPData(str, str, this.presenter);
        this.mPlayerView.playVideo();
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
        removeCallbacks(this.getCutoutRunnable);
        viewGroup.removeView(this);
        PlayTemplePresenter playTemplePresenter = this.presenter;
        if (playTemplePresenter != null) {
            playTemplePresenter.removeCurrPlayTemplateMoreOfferView(viewGroup);
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

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void setAdCloseVisibility(boolean z9) {
        View view = this.mViewPlayingClose;
        if (view == null) {
            return;
        }
        if (z9) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void setAlertViewType(String str, int i10, int i11) {
        AlertTempleView alertTempleView = this.alertTempleView;
        if (alertTempleView != null) {
            alertTempleView.setAlertType(i10, str, i11);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void setCountDown(String str, int i10, int i11, ViewGroup.LayoutParams layoutParams) {
        TextView textView = this.mTvCountDown;
        if (textView == null) {
            return;
        }
        textView.setText(str);
        if (this.mTvCountDown.getVisibility() != 0) {
            this.mTvCountDown.setVisibility(0);
        }
        if (i10 != 0) {
            this.mTvCountDown.setPadding(i10, 0, i10, 0);
        }
        if (layoutParams != null) {
            this.mTvCountDown.setLayoutParams(layoutParams);
        }
        if (i11 != 0) {
            this.mTvCountDown.setBackgroundResource(i11);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void setMuteState(boolean z9) {
        PlayerView playerView = this.mPlayerView;
        if (playerView != null) {
            if (z9) {
                playerView.closeSound();
            } else {
                playerView.openSound();
            }
        }
        SoundImageView soundImageView = this.mSoundImageView;
        if (soundImageView != null) {
            soundImageView.setSoundStatus(!z9);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void setPlayerSize(int i10, int i11, int i12) {
        PlayerView playerView = this.mPlayerView;
        if (playerView == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) playerView.getLayoutParams();
        layoutParams.width = i11;
        layoutParams.height = i12;
        if (i10 != 0) {
            layoutParams.gravity = i10;
        }
        this.mPlayerView.setLayoutParams(layoutParams);
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void setSegmentsProgressBar(int i10) {
        MBridgeSegmentsProgressBar mBridgeSegmentsProgressBar = this.mSegmentsProgressBar;
        if (mBridgeSegmentsProgressBar != null) {
            mBridgeSegmentsProgressBar.init(1, 3);
            this.mSegmentsProgressBar.setVisibility(i10);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void setTemplateWidthAndHeight(final int i10) {
        post(new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.BaseTemplate.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) BaseTemplate.this.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.setMargins(0, 0, 0, i10);
                        BaseTemplate.this.setLayoutParams(layoutParams);
                    }
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void setmPlayerView(PlayerView playerView) {
        this.mPlayerView = playerView;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public void show(ViewGroup viewGroup) {
        PlayTemplePresenter playTemplePresenter = this.presenter;
        if (playTemplePresenter == null || !playTemplePresenter.playTemplateRanderSuccess) {
            return;
        }
        viewGroup.addView(this);
        postDelayed(this.getCutoutRunnable, 1000L);
        this.presenter.addMoreOfferView(this);
    }

    public BaseTemplate(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDyXmlSuccess = false;
        this.getCutoutRunnable = new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.BaseTemplate.1
            @Override // java.lang.Runnable
            public void run() {
                DisplayCutout displayCutout;
                try {
                    PlayTemplePresenter playTemplePresenter = BaseTemplate.this.presenter;
                    if (playTemplePresenter == null || !playTemplePresenter.isHalfScreenOffer()) {
                        WindowInsets rootWindowInsets = BaseTemplate.this.getRootWindowInsets();
                        if (Build.VERSION.SDK_INT < 28 || rootWindowInsets == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null || BaseTemplate.this.mTopControllerView == null) {
                            return;
                        }
                        int safeInsetLeft = displayCutout.getSafeInsetLeft();
                        int safeInsetTop = displayCutout.getSafeInsetTop();
                        int safeInsetRight = displayCutout.getSafeInsetRight();
                        displayCutout.getSafeInsetBottom();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) BaseTemplate.this.mTopControllerView.getLayoutParams();
                        int iA = ak.a(BaseTemplate.this.getContext(), 9.0f);
                        if (safeInsetLeft == 0) {
                            safeInsetLeft = iA;
                        }
                        layoutParams.leftMargin = safeInsetLeft;
                        if (safeInsetTop == 0) {
                            safeInsetTop = iA;
                        }
                        layoutParams.topMargin = safeInsetTop;
                        if (safeInsetRight == 0) {
                            safeInsetRight = iA;
                        }
                        layoutParams.rightMargin = safeInsetRight;
                        BaseTemplate.this.mTopControllerView.setLayoutParams(layoutParams);
                    }
                } catch (Throwable th) {
                    af.b(BaseTemplate.TAG, th.getMessage());
                }
            }
        };
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void setBackGroundImage(Bitmap bitmap) {
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void viewReport(Object obj) {
    }
}

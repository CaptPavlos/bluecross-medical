package com.mbridge.msdk.newreward.player.view.floatview;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Build;
import android.util.AttributeSet;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.player.iview.IBaseWebView;
import com.mbridge.msdk.newreward.player.presenter.FloatWebViewPresenter;
import com.mbridge.msdk.newreward.player.view.hybrid.MBWebView;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MBCommunicatorUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class FloatWebTemplateView extends FrameLayout implements View.OnClickListener, IBaseWebView {
    public static final int FLOAT_EXPAND_VIEW = 546;
    public static final int FLOAT_MINI_CARD = 273;
    private static final String TAG = "FloatTemplateView";
    boolean hasWebViewShow;
    boolean isWebViewAttached;
    boolean isWebViewShowed;
    ImageView mCloseImageView;
    FloatWebViewPresenter mFloatPresenter;
    String mUrl;
    int mViewType;
    MBWebView mWebView;
    b reqCallBack;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FloatViewType {
    }

    public FloatWebTemplateView(@NonNull Context context) {
        super(context);
        this.isWebViewAttached = false;
        this.isWebViewShowed = false;
    }

    private void initPresenter() {
        FloatWebViewPresenter floatWebViewPresenter = new FloatWebViewPresenter(this, this.mViewType);
        this.mFloatPresenter = floatWebViewPresenter;
        floatWebViewPresenter.getView();
    }

    public void addShowReqListener(b bVar) {
        this.reqCallBack = bVar;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView, com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public ImageView getPrivacyButton() {
        return null;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public MBWebView getWebView() {
        return this.mWebView;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public boolean initViews(boolean z9) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setBackgroundColor(2130706432);
        int iF = ak.f(getContext());
        int iE = ak.e(getContext());
        this.mWebView = new MBWebView(new MutableContextWrapper(c.m().c()));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (this.mViewType == 273) {
            layoutParams.width = (int) ((iF * 0.7d) + 0.5d);
            layoutParams.height = (int) ((iE * 0.7d) + 0.5d);
            layoutParams.gravity = 17;
        }
        this.mWebView.setLayoutParams(layoutParams);
        this.mCloseImageView = new ImageView(getContext());
        int iA = this.mViewType == 273 ? ak.a(getContext(), 48.0f) : 96;
        int iA2 = ak.a(getContext(), 5.0f);
        int i10 = (int) ((iF * 0.15d) + 0.5d);
        int i11 = (int) ((iE * 0.15d) + 0.5d);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iA, iA);
        int i12 = this.mViewType;
        if (i12 != 273) {
            i11 = 30;
        }
        layoutParams2.topMargin = i11;
        if (i12 != 273) {
            i10 = 30;
        }
        layoutParams2.rightMargin = i10;
        layoutParams2.gravity = 8388661;
        this.mCloseImageView.setLayoutParams(layoutParams2);
        this.mCloseImageView.setPadding(iA2, iA2, iA2, iA2);
        this.mCloseImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.mCloseImageView.setImageResource(x.a(getContext(), "mbridge_reward_close_ec", "drawable"));
        this.mCloseImageView.setOnClickListener(this);
        this.mCloseImageView.setVisibility(4);
        this.mWebView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.mbridge.msdk.newreward.player.view.floatview.FloatWebTemplateView.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                FloatWebTemplateView.this.isWebViewAttached = true;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                FloatWebTemplateView.this.isWebViewAttached = false;
            }
        });
        addView(this.mWebView);
        addView(this.mCloseImageView);
        FloatWebViewPresenter floatWebViewPresenter = this.mFloatPresenter;
        if (floatWebViewPresenter == null) {
            return true;
        }
        if (this.mViewType == 273) {
            floatWebViewPresenter.renderPauseUrl();
        }
        if (this.mViewType != 546) {
            return true;
        }
        this.mFloatPresenter.renderMRAID(this.mUrl);
        return true;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public void onActivityLifeCycleCallback(String str) {
        FloatWebViewPresenter floatWebViewPresenter = this.mFloatPresenter;
        if (floatWebViewPresenter != null) {
            floatWebViewPresenter.onActivityLifeCycleCallback(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.mFloatPresenter.click(view);
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public void onCloseViewClick(int i10) {
        FloatWebViewPresenter floatWebViewPresenter = this.mFloatPresenter;
        if (floatWebViewPresenter != null) {
            floatWebViewPresenter.click(null);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public void onDestroyWebContent(int i10) {
        MBWebView mBWebView = this.mWebView;
        if (mBWebView != null) {
            mBWebView.destroy();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FloatWebViewPresenter floatWebViewPresenter = this.mFloatPresenter;
        if (floatWebViewPresenter != null) {
            floatWebViewPresenter.onDetachedFromWindow();
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public boolean onWebViewShow(int i10) {
        this.mWebView.post(new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.floatview.FloatWebTemplateView.1
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                FloatWebTemplateView.this.mFloatPresenter.changeNativeCloseButton();
                FloatWebTemplateView.this.webViewShow();
                FloatWebTemplateView.this.setNotch();
            }
        });
        if (this.hasWebViewShow) {
            return true;
        }
        this.hasWebViewShow = true;
        return false;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public void removeTempleFromSuperView(ViewGroup viewGroup) {
        if (getParent() != null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).removeView(this);
        }
        b bVar = this.reqCallBack;
        if (bVar != null) {
            bVar.reqSuccessful("remove");
        }
    }

    public void setFloatViewType(int i10) {
        this.mViewType = i10;
        initPresenter();
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public void setNativeCloseButtonVisibility(int i10) {
        ImageView imageView = this.mCloseImageView;
        if (imageView != null) {
            imageView.setVisibility(i10);
        }
    }

    public void setNotch() {
        DisplayCutout displayCutout;
        int i10;
        try {
            WindowInsets rootWindowInsets = getRootWindowInsets();
            if (Build.VERSION.SDK_INT < 28 || (displayCutout = rootWindowInsets.getDisplayCutout()) == null) {
                return;
            }
            int safeInsetLeft = displayCutout.getSafeInsetLeft();
            int safeInsetTop = displayCutout.getSafeInsetTop();
            int safeInsetRight = displayCutout.getSafeInsetRight();
            int safeInsetBottom = displayCutout.getSafeInsetBottom();
            int rotation = getDisplay().getRotation();
            if (rotation != 0) {
                if (rotation == 1) {
                    i10 = 90;
                } else if (rotation == 2) {
                    i10 = SubsamplingScaleImageView.ORIENTATION_180;
                } else if (rotation == 3) {
                    i10 = SubsamplingScaleImageView.ORIENTATION_270;
                }
                this.mFloatPresenter.setNotchData(s.a(i10, safeInsetLeft, safeInsetRight, safeInsetTop, safeInsetBottom));
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mCloseImageView.getLayoutParams();
                layoutParams.topMargin = safeInsetTop;
                layoutParams.leftMargin = safeInsetLeft;
                layoutParams.rightMargin = safeInsetRight;
                layoutParams.bottomMargin = safeInsetBottom;
            }
            i10 = 0;
            this.mFloatPresenter.setNotchData(s.a(i10, safeInsetLeft, safeInsetRight, safeInsetTop, safeInsetBottom));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mCloseImageView.getLayoutParams();
            layoutParams2.topMargin = safeInsetTop;
            layoutParams2.leftMargin = safeInsetLeft;
            layoutParams2.rightMargin = safeInsetRight;
            layoutParams2.bottomMargin = safeInsetBottom;
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }

    public void setRenderUrl(String str) {
        this.mUrl = str;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public void show(ViewGroup viewGroup) {
        if (getParent() != null) {
            viewGroup.bringToFront();
        } else if (viewGroup != null) {
            viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
        }
        this.mFloatPresenter.onShown();
        b bVar = this.reqCallBack;
        if (bVar != null) {
            bVar.reqSuccessful("show");
        }
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
        MBCommunicatorUtil.notifyShowDataInfo(this.mWebView, i10, this.mFloatPresenter.getCampaignOrientation());
        MBCommunicatorUtil.notifyWebViewShowed(this.mWebView, str, this.mFloatPresenter.getWebViewShowExtraData());
        this.isWebViewShowed = true;
    }

    public FloatWebTemplateView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isWebViewAttached = false;
        this.isWebViewShowed = false;
    }

    public FloatWebTemplateView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.isWebViewAttached = false;
        this.isWebViewShowed = false;
    }

    @RequiresApi(api = 21)
    public FloatWebTemplateView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.isWebViewAttached = false;
        this.isWebViewShowed = false;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public void hideCTAView() {
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public void showMiniCard() {
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public void addViewToCurrentViewGroup(View view) {
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public void showCTAView(String str, CampaignEx campaignEx) {
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseWebView
    public void showMRAIDExpandView(String str, int i10) {
    }
}

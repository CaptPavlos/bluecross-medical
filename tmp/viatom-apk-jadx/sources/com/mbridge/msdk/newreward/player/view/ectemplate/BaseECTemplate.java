package com.mbridge.msdk.newreward.player.view.ectemplate;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.DisplayCutout;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.player.iview.IECTempleView;
import com.mbridge.msdk.newreward.player.presenter.ECTemplePresenter;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import com.mbridge.msdk.widget.FeedBackButton;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class BaseECTemplate extends RelativeLayout implements View.OnClickListener, IECTempleView {
    private final String TAG;
    protected ImageView appIconIv;
    protected ImageView bannerIv;
    private ImageView bannerIvBg;
    protected View closeView;
    protected View ctaView;
    protected TextView descTv;
    ECTemplePresenter ecPresenter;
    protected FeedBackButton feedBackButton;
    protected ImageView flagIV;
    protected TextView flagTV;
    protected LinearLayout levelSlv;
    protected ImageView logoView;
    protected MBridgeBaitClickView mBaitClickView;
    protected boolean mDyXmlSuccess;
    protected LinearLayout mLevelHeatCount;
    protected RelativeLayout nativeECLayout;
    protected ImageView noticeIV;
    protected TextView numberTv;
    protected TextView titleTv;
    private RelativeLayout topControllerLayout;

    public BaseECTemplate(@NonNull Context context) {
        super(context);
        this.TAG = "BaseECTemple";
        this.mDyXmlSuccess = false;
    }

    private void setViewInitState() {
        View view = this.closeView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void addClickEvent() {
        View view = this.closeView;
        if (view != null) {
            view.setOnClickListener(this);
        }
        RelativeLayout relativeLayout = this.nativeECLayout;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(this);
        }
        View view2 = this.ctaView;
        if (view2 != null) {
            view2.setOnClickListener(this);
        }
        ImageView imageView = this.appIconIv;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        ImageView imageView2 = this.bannerIv;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public void addViewToCurrentViewGroup(View view) {
        addView(view);
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IECTempleView
    public View getBaitClickView() {
        return this.mBaitClickView;
    }

    public View getCloseView() {
        return this.closeView;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IECTempleView
    public ImageView getNoticeIV() {
        return this.noticeIV;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public boolean initViews(boolean z9) {
        boolean z10;
        try {
            this.mDyXmlSuccess = z9;
            this.nativeECLayout = (RelativeLayout) findViewById(this.ecPresenter.filterFindViewId(z9, "mbridge_native_ec_layout"));
            this.bannerIv = (ImageView) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_iv_adbanner"));
            this.appIconIv = (ImageView) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_iv_icon"));
            this.flagIV = (ImageView) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_iv_flag"));
            this.flagTV = (TextView) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_tv_flag"));
            this.logoView = (ImageView) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_iv_logo"));
            this.noticeIV = (ImageView) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_iv_link"));
            this.titleTv = (TextView) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_tv_apptitle"));
            this.levelSlv = (LinearLayout) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_sv_starlevel"));
            this.mLevelHeatCount = (LinearLayout) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_sv_heat_count_level"));
            this.closeView = findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_iv_close"));
            this.ctaView = findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_tv_cta"));
            this.feedBackButton = (FeedBackButton) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_native_endcard_feed_btn"));
            this.topControllerLayout = (RelativeLayout) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_native_ec_controller"));
            this.bannerIvBg = (ImageView) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_iv_adbanner_bg"));
            this.mBaitClickView = (MBridgeBaitClickView) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_animation_click_view"));
            this.descTv = (TextView) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_tv_appdesc"));
            addClickEvent();
            if (z9) {
                ImageView imageView = this.bannerIv;
                if (imageView != null && (imageView instanceof RoundImageView)) {
                    ((RoundImageView) imageView).setBorderRadius(10);
                }
                ImageView imageView2 = this.appIconIv;
                if (imageView2 != null && (imageView2 instanceof RoundImageView)) {
                    ((RoundImageView) imageView2).setBorderRadius(10);
                }
                return this.ecPresenter.isNotNULL(this.bannerIv, this.appIconIv, this.titleTv, this.levelSlv, this.closeView, this.ctaView);
            }
            TextView textView = (TextView) findViewById(this.ecPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_tv_number"));
            this.numberTv = textView;
            z10 = false;
            try {
                return this.ecPresenter.isNotNULL(this.bannerIv, this.appIconIv, this.titleTv, this.descTv, textView, this.levelSlv, this.closeView, this.ctaView);
            } catch (Throwable th) {
                th = th;
                af.b("BaseECTemple", th.getMessage());
                return z10;
            }
        } catch (Throwable th2) {
            th = th2;
            z10 = false;
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public void onActivityLifeCycleCallback(String str) {
        ECTemplePresenter eCTemplePresenter;
        str.getClass();
        if (str.equals("onDestroy")) {
            ECTemplePresenter eCTemplePresenter2 = this.ecPresenter;
            if (eCTemplePresenter2 != null) {
                eCTemplePresenter2.onDestroy();
                return;
            }
            return;
        }
        if (str.equals("onBackPressed") && (eCTemplePresenter = this.ecPresenter) != null) {
            eCTemplePresenter.onBackPressed();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ECTemplePresenter eCTemplePresenter = this.ecPresenter;
        if (eCTemplePresenter == null) {
            return;
        }
        eCTemplePresenter.setAutoRedirect();
        this.ecPresenter.addShakeView();
        this.ecPresenter.addBaitClickView();
        this.ecPresenter.setCloseViewShow();
        setNotch();
        this.ecPresenter.showStoreMiniCard();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ecPresenter.click(view);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ECTemplePresenter eCTemplePresenter = this.ecPresenter;
        if (eCTemplePresenter != null && motionEvent != null) {
            eCTemplePresenter.handleInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public void removeTempleFromSuperView(ViewGroup viewGroup) {
        viewGroup.removeView(this);
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IECTempleView
    public void setBlurBackGround(final Bitmap bitmap) {
        ImageView imageView = this.bannerIvBg;
        if (imageView != null) {
            imageView.post(new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.ectemplate.BaseECTemplate.1
                @Override // java.lang.Runnable
                public void run() {
                    BaseECTemplate.this.bannerIvBg.setImageBitmap(bitmap);
                }
            });
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IECTempleView
    public void setCTAText(String str) {
        View view = this.ctaView;
        if (view instanceof TextView) {
            ((TextView) view).setText(str);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IECTempleView
    public void setCloseViewBtnDelayShow(int i10) {
        View view = this.closeView;
        if (view == null) {
            return;
        }
        view.postDelayed(new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.ectemplate.BaseECTemplate.2
            @Override // java.lang.Runnable
            public void run() {
                View view2 = BaseECTemplate.this.closeView;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
            }
        }, i10);
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IECTempleView
    public void setHeatCount(int i10) throws Resources.NotFoundException {
        LinearLayout linearLayout = this.mLevelHeatCount;
        if (linearLayout instanceof MBHeatLevelLayoutView) {
            ((MBHeatLevelLayoutView) linearLayout).setHeatCount(i10);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IECTempleView
    public void setImageBitMap(int i10, Bitmap bitmap) {
        ((ImageView) findViewById(i10)).setImageBitmap(bitmap);
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IECTempleView
    public void setNLogo(int i10, String str, Drawable drawable) {
        ImageView imageView = this.flagIV;
        if (i10 != 0) {
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
                return;
            }
            return;
        }
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        ImageView imageView2 = this.logoView;
        if (imageView2 != null) {
            imageView2.setVisibility(4);
        }
        TextView textView = this.flagTV;
        if (textView != null) {
            textView.setVisibility(0);
            this.flagTV.setText(str);
        }
    }

    public void setNotch() {
        DisplayCutout displayCutout;
        try {
            if (this.ecPresenter.isHalfScreenOffer()) {
                return;
            }
            WindowInsets rootWindowInsets = getRootWindowInsets();
            if (Build.VERSION.SDK_INT < 28 || (displayCutout = rootWindowInsets.getDisplayCutout()) == null) {
                return;
            }
            int safeInsetLeft = displayCutout.getSafeInsetLeft();
            int safeInsetTop = displayCutout.getSafeInsetTop();
            int safeInsetRight = displayCutout.getSafeInsetRight();
            displayCutout.getSafeInsetBottom();
            if (this.topControllerLayout.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.topControllerLayout.getLayoutParams();
                int iA = ak.a(getContext(), 9.0f);
                layoutParams.leftMargin = safeInsetLeft == 0 ? iA : safeInsetLeft;
                layoutParams.topMargin = safeInsetTop == 0 ? iA : safeInsetTop;
                if (safeInsetRight != 0) {
                    iA = safeInsetRight;
                }
                layoutParams.rightMargin = iA;
                this.topControllerLayout.setLayoutParams(layoutParams);
            }
            if (this.topControllerLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.topControllerLayout.getLayoutParams();
                int iA2 = ak.a(getContext(), 9.0f);
                if (safeInsetLeft == 0) {
                    safeInsetLeft = iA2;
                }
                layoutParams2.leftMargin = safeInsetLeft;
                if (safeInsetTop == 0) {
                    safeInsetTop = iA2;
                }
                layoutParams2.topMargin = safeInsetTop;
                if (safeInsetRight == 0) {
                    safeInsetRight = iA2;
                }
                layoutParams2.rightMargin = safeInsetRight;
                this.topControllerLayout.setLayoutParams(layoutParams2);
            }
        } catch (Throwable th) {
            af.b("BaseECTemple", th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IECTempleView
    public void setRatingAndUser(double d8, int i10) {
        try {
            LinearLayout linearLayout = this.levelSlv;
            if (linearLayout instanceof MBridgeLevelLayoutView) {
                linearLayout.removeAllViews();
                this.levelSlv.setVisibility(0);
                ((MBridgeLevelLayoutView) this.levelSlv).setRatingAndUser(d8, i10);
            }
            LinearLayout linearLayout2 = this.levelSlv;
            if (linearLayout2 instanceof MBStarLevelLayoutView) {
                linearLayout2.removeAllViews();
                this.levelSlv.setVisibility(0);
                ((MBStarLevelLayoutView) this.levelSlv).setRating((int) d8);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IECTempleView
    public void setTextByID(int i10, String str) {
        TextView textView = (TextView) findViewById(i10);
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public void show(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.addView(this);
        setViewInitState();
        ECTemplePresenter eCTemplePresenter = this.ecPresenter;
        if (eCTemplePresenter != null) {
            eCTemplePresenter.onEndCardShow();
        }
    }

    public BaseECTemplate(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "BaseECTemple";
        this.mDyXmlSuccess = false;
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IECTempleView
    public IECTempleView getParentObject() {
        return this;
    }
}

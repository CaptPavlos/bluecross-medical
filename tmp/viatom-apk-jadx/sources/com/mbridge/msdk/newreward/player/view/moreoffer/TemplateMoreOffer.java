package com.mbridge.msdk.newreward.player.view.moreoffer;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.player.iview.IMoreOfferTemplateView;
import com.mbridge.msdk.newreward.player.presenter.MoreOfferPresenter;
import com.mbridge.msdk.video.dynview.widget.ObservableScrollView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class TemplateMoreOffer extends BaseMoreOfferTemplate implements View.OnClickListener, IMoreOfferTemplateView {
    LinearLayout linearLayout;
    Context mContext;
    private Handler mHandler;
    int moreOfferType;
    private Runnable runnable;

    public TemplateMoreOffer(Context context, b bVar, int i10) {
        super(context);
        this.mHandler = new Handler();
        this.runnable = new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.moreoffer.TemplateMoreOffer.1
            @Override // java.lang.Runnable
            public void run() {
                TemplateMoreOffer templateMoreOffer = TemplateMoreOffer.this;
                MoreOfferPresenter moreOfferPresenter = templateMoreOffer.moreOfferPresenter;
                if (moreOfferPresenter != null) {
                    moreOfferPresenter.onTouch(templateMoreOffer.mObservableScrollView);
                }
            }
        };
        this.mContext = context;
        setVisibility(8);
        this.moreOfferType = i10;
        MoreOfferPresenter moreOfferPresenter = new MoreOfferPresenter(this);
        this.moreOfferPresenter = moreOfferPresenter;
        moreOfferPresenter.setIReqCallBack(bVar);
        this.moreOfferPresenter.getView();
        this.moreOfferPresenter.syncLoad(i10);
    }

    @Override // com.mbridge.msdk.newreward.player.view.moreoffer.BaseMoreOfferTemplate
    public void addClickEvent() {
        TextView textView = this.likeTv;
        if (textView == null) {
            return;
        }
        textView.setOnClickListener(this);
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IMoreOfferTemplateView
    public void addMoreOfferLikeText(final String str, final int i10) {
        if (this.likeTv == null) {
            return;
        }
        post(new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.moreoffer.TemplateMoreOffer.4
            @Override // java.lang.Runnable
            public void run() {
                TextView textView = TemplateMoreOffer.this.likeTv;
                if (textView == null) {
                    return;
                }
                textView.setVisibility(0);
                TemplateMoreOffer.this.likeTv.setTextColor(Color.parseColor("#FF000000"));
                TemplateMoreOffer.this.likeTv.setTextSize(10.0f);
                TemplateMoreOffer.this.likeTv.setEms(1);
                if (i10 != 0) {
                    TemplateMoreOffer.this.likeTv.getLayoutParams().width = i10;
                }
                TemplateMoreOffer.this.likeTv.setText(str);
            }
        });
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public void addViewToCurrentViewGroup(View view) {
        if (view != null) {
            try {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                }
                layoutParams.addRule(12, -1);
                view.setLayoutParams(layoutParams);
                view.setVisibility(0);
                addView(view);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, ak.a(c.m().c(), 100.0f));
        layoutParams2.gravity = 80;
        setLayoutParams(layoutParams2);
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IMoreOfferTemplateView
    public void addViewToObservableScrollView(final View view) {
        if (view instanceof LinearLayout) {
            this.linearLayout = (LinearLayout) view;
        }
        if (this.mObservableScrollView != null) {
            post(new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.moreoffer.TemplateMoreOffer.2
                @Override // java.lang.Runnable
                public void run() {
                    TemplateMoreOffer templateMoreOffer;
                    ObservableScrollView observableScrollView;
                    if (view == null || (observableScrollView = (templateMoreOffer = TemplateMoreOffer.this).mObservableScrollView) == null) {
                        return;
                    }
                    observableScrollView.addView(templateMoreOffer.linearLayout);
                }
            });
            this.mObservableScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.mbridge.msdk.newreward.player.view.moreoffer.TemplateMoreOffer.3
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    if (TemplateMoreOffer.this.mHandler != null) {
                        TemplateMoreOffer.this.mHandler.removeCallbacks(TemplateMoreOffer.this.runnable);
                        TemplateMoreOffer.this.mHandler.postDelayed(TemplateMoreOffer.this.runnable, 100L);
                    }
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MoreOfferPresenter moreOfferPresenter = this.moreOfferPresenter;
        if (moreOfferPresenter == null) {
            return;
        }
        moreOfferPresenter.click(view);
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IMoreOfferTemplateView
    public void setObservableScrollViewVisible() {
        ObservableScrollView observableScrollView = this.mObservableScrollView;
        if (observableScrollView == null) {
            return;
        }
        int visibility = observableScrollView.getVisibility();
        ObservableScrollView observableScrollView2 = this.mObservableScrollView;
        if (visibility == 0) {
            observableScrollView2.setVisibility(8);
        } else {
            observableScrollView2.setVisibility(0);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public void show(ViewGroup viewGroup) {
        if (viewGroup.getParent() != null) {
            ((ViewGroup) viewGroup.getParent()).addView(this);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public void onActivityLifeCycleCallback(String str) {
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IBaseView
    public void removeTempleFromSuperView(ViewGroup viewGroup) {
    }
}

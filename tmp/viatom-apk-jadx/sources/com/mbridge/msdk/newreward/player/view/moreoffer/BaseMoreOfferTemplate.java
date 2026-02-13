package com.mbridge.msdk.newreward.player.view.moreoffer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.presenter.MoreOfferPresenter;
import com.mbridge.msdk.video.dynview.widget.ObservableScrollView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class BaseMoreOfferTemplate extends RelativeLayout {
    TextView likeTv;
    protected boolean mDyXmlSuccess;
    ObservableScrollView mObservableScrollView;
    MoreOfferPresenter moreOfferPresenter;

    public BaseMoreOfferTemplate(@NonNull Context context) {
        super(context);
        this.mDyXmlSuccess = false;
    }

    public abstract void addClickEvent();

    public boolean initViews(boolean z9) {
        MoreOfferPresenter moreOfferPresenter = this.moreOfferPresenter;
        if (moreOfferPresenter == null) {
            return false;
        }
        try {
            this.mObservableScrollView = (ObservableScrollView) findViewById(moreOfferPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_moreoffer_hls"));
            this.likeTv = (TextView) findViewById(this.moreOfferPresenter.filterFindViewId(this.mDyXmlSuccess, "mbridge_reward_end_card_like_tv"));
            addClickEvent();
            return true;
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public BaseMoreOfferTemplate(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDyXmlSuccess = false;
    }
}

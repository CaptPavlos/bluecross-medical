package com.mbridge.msdk.newreward.player.view.ectemplate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.iview.ICusECTemplateView;
import com.mbridge.msdk.newreward.player.presenter.ECPresenter404;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class TemplateEC404 extends BaseECTemplate implements ICusECTemplateView {
    public TemplateEC404(@NonNull Context context) {
        super(context);
        ECPresenter404 eCPresenter404 = new ECPresenter404(this);
        this.ecPresenter = eCPresenter404;
        eCPresenter404.getView();
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IECTempleView
    public void addShakeView(View view) {
        if (view != null) {
            View view2 = this.ctaView;
            if (view2 != null) {
                view2.setVisibility(4);
            }
            RelativeLayout relativeLayout = this.nativeECLayout;
            if (relativeLayout != null) {
                relativeLayout.addView(view);
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.ICusECTemplateView
    public void reSetEndCardWidthAndHeight(final int i10) {
        post(new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.ectemplate.TemplateEC404.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) TemplateEC404.this.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.setMargins(0, 0, 0, i10);
                        TemplateEC404.this.setLayoutParams(layoutParams);
                    }
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.mbridge.msdk.newreward.player.view.ectemplate.BaseECTemplate, com.mbridge.msdk.newreward.player.iview.IBaseView
    public void show(ViewGroup viewGroup) {
        super.show(viewGroup);
        ((ECPresenter404) this.ecPresenter).addMoreOfferView(this);
    }

    public TemplateEC404(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

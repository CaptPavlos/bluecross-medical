package com.mbridge.msdk.newreward.player.view.ectemplate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.newreward.player.iview.IECTempleView;
import com.mbridge.msdk.newreward.player.presenter.ECHalfPresenter;
import com.mbridge.msdk.newreward.player.presenter.ECTemplePresenter;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class TemplateHalfEC extends BaseECTemplate {
    public TemplateHalfEC(@NonNull Context context) {
        super(context);
        ECHalfPresenter eCHalfPresenter = new ECHalfPresenter(this);
        this.ecPresenter = eCHalfPresenter;
        eCHalfPresenter.getView();
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

    @Override // com.mbridge.msdk.newreward.player.view.ectemplate.BaseECTemplate, com.mbridge.msdk.newreward.player.iview.IECTempleView
    public IECTempleView getParentObject() {
        return super.getParentObject();
    }

    @Override // com.mbridge.msdk.newreward.player.view.ectemplate.BaseECTemplate, com.mbridge.msdk.newreward.player.iview.IBaseView
    public void show(ViewGroup viewGroup) {
        super.show(viewGroup);
        ECTemplePresenter eCTemplePresenter = this.ecPresenter;
        if (eCTemplePresenter instanceof ECHalfPresenter) {
            ((ECHalfPresenter) eCTemplePresenter).setHalfWH();
        }
    }

    public TemplateHalfEC(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

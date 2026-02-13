package com.mbridge.msdk.video.module;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class MBridgeNativeEndCardViewDiff extends MBridgeBaseView {
    public TextView ctaView;

    public MBridgeNativeEndCardViewDiff(Context context) {
        super(context);
    }

    public boolean checkChinaShakeState() {
        return false;
    }

    public boolean checkProgressBarIntercepted() {
        return false;
    }

    public boolean ctaViewCanGet(View view, boolean z9) {
        try {
            View viewFindViewById = view.findViewById(filterFindViewId(z9, "mbridge_tv_cta"));
            if (viewFindViewById instanceof TextView) {
                this.ctaView = (TextView) viewFindViewById;
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return this.ctaView != null;
    }

    public MBridgeNativeEndCardViewDiff(Context context, AttributeSet attributeSet, boolean z9, int i10, boolean z10, int i11, int i12) {
        super(context, attributeSet, z9, i10, z10, i11, i12);
    }

    public MBridgeNativeEndCardViewDiff(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

package com.mbridge.msdk.newreward.player.iview;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface IECTempleView extends IBaseView {
    void addShakeView(View view);

    View getBaitClickView();

    ImageView getNoticeIV();

    IECTempleView getParentObject();

    void setBlurBackGround(Bitmap bitmap);

    void setCTAText(String str);

    void setCloseViewBtnDelayShow(int i10);

    void setHeatCount(int i10);

    void setImageBitMap(int i10, Bitmap bitmap);

    void setNLogo(int i10, String str, Drawable drawable);

    void setRatingAndUser(double d8, int i10);

    void setTextByID(int i10, String str);
}

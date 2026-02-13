package com.mbridge.msdk.newreward.player.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.iview.ICusTemplateView;
import com.mbridge.msdk.newreward.player.presenter.PlayPresenter202;
import com.mbridge.msdk.playercommon.PlayerView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class Template202 extends BaseTemplate implements ICusTemplateView {
    public Template202(@NonNull Context context) {
        super(context);
        PlayPresenter202 playPresenter202 = new PlayPresenter202(this);
        this.presenter = playPresenter202;
        playPresenter202.getView();
    }

    @Override // com.mbridge.msdk.newreward.player.iview.ICusTemplateView
    public void addCTAViewToLayout(View view, int i10) {
        FrameLayout frameLayout = this.mCtaLayout;
        if (frameLayout == null) {
            return;
        }
        if (i10 == 8) {
            frameLayout.setVisibility(i10);
            return;
        }
        try {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.mCtaLayout.addView(view);
            this.mCtaLayout.setVisibility(i10);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.BaseTemplate
    public void addClickEvent() {
        super.addClickEvent();
        PlayerView playerView = this.mPlayerView;
        if (playerView != null) {
            playerView.setOnClickListener(this);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.ICusTemplateView
    public int getCTAViewState() {
        FrameLayout frameLayout = this.mCtaLayout;
        if (frameLayout != null) {
            return frameLayout.getVisibility();
        }
        return -1;
    }

    @Override // com.mbridge.msdk.newreward.player.view.BaseTemplate, com.mbridge.msdk.newreward.player.iview.IPlayTempleView
    public void setBackGroundImage(final Bitmap bitmap) {
        post(new Runnable() { // from class: com.mbridge.msdk.newreward.player.view.Template202.1
            @Override // java.lang.Runnable
            public void run() {
                ImageView imageView = Template202.this.bgImageView;
                if (imageView == null) {
                    return;
                }
                imageView.setVisibility(0);
                Template202.this.bgImageView.setImageBitmap(bitmap);
            }
        });
    }

    @Override // com.mbridge.msdk.newreward.player.view.BaseTemplate, com.mbridge.msdk.newreward.player.iview.IBaseView
    public void show(ViewGroup viewGroup) {
        super.show(viewGroup);
        this.presenter.setBackGrandImage();
    }

    public Template202(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

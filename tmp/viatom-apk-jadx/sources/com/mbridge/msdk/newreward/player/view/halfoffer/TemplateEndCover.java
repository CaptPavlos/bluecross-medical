package com.mbridge.msdk.newreward.player.view.halfoffer;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.player.iview.IECoverTemplateView;
import com.mbridge.msdk.newreward.player.presenter.PlayPresenterEndCover;
import com.mbridge.msdk.newreward.player.view.BaseTemplate;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class TemplateEndCover extends BaseTemplate implements IECoverTemplateView {
    private ImageView closeImageView;
    private TextView ctaButton;
    private TextView descTextView;
    private ImageView iconImageView;
    private View rootView;
    private TextView titleTextView;

    public TemplateEndCover(@NonNull Context context) {
        super(context);
        PlayPresenterEndCover playPresenterEndCover = new PlayPresenterEndCover(this);
        this.presenter = playPresenterEndCover;
        playPresenterEndCover.getView();
    }

    @Override // com.mbridge.msdk.newreward.player.view.BaseTemplate
    public void addClickEvent() {
        ImageView imageView = this.closeImageView;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        TextView textView = this.ctaButton;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.BaseTemplate, com.mbridge.msdk.newreward.player.iview.IBaseView
    public boolean initViews(boolean z9) {
        try {
            int iA = x.a(getContext(), "mbridge_reward_videoend_cover", TtmlNode.TAG_LAYOUT);
            if (iA >= 0) {
                View viewInflate = LayoutInflater.from(getContext()).inflate(iA, (ViewGroup) null);
                this.rootView = viewInflate;
                if (viewInflate != null) {
                    this.iconImageView = (ImageView) viewInflate.findViewById(this.presenter.filterFindViewId(false, "mbridge_vec_iv_icon"));
                    this.closeImageView = (ImageView) this.rootView.findViewById(this.presenter.filterFindViewId(false, "mbridge_vec_iv_close"));
                    this.titleTextView = (TextView) this.rootView.findViewById(this.presenter.filterFindViewId(false, "mbridge_vec_tv_title"));
                    this.descTextView = (TextView) this.rootView.findViewById(this.presenter.filterFindViewId(false, "mbridge_vec_tv_desc"));
                    this.ctaButton = (TextView) this.rootView.findViewById(this.presenter.filterFindViewId(false, "mbridge_vec_btn"));
                    addView(this.rootView, -1, -1);
                }
            }
            addClickEvent();
            return true;
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IECoverTemplateView
    public void setCtaBtn(String str) {
        TextView textView = this.ctaButton;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IECoverTemplateView
    public void setDesc(String str) {
        TextView textView = this.descTextView;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IECoverTemplateView
    public void setIconImageView(Bitmap bitmap) {
        ImageView imageView = this.iconImageView;
        if (imageView == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
    }

    @Override // com.mbridge.msdk.newreward.player.iview.IECoverTemplateView
    public void setTitle(String str) {
        TextView textView = this.titleTextView;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }
}

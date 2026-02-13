package com.mbridge.msdk.video.module;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.video.dynview.e.h;
import com.mbridge.msdk.video.module.a.a.e;
import com.mbridge.msdk.video.signal.factory.b;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeClickCTAView extends MBridgeClickCTAViewDiff {
    public a ctaClickCallBack;

    /* renamed from: m, reason: collision with root package name */
    private ViewGroup f5908m;

    /* renamed from: n, reason: collision with root package name */
    private ImageView f5909n;

    /* renamed from: o, reason: collision with root package name */
    private TextView f5910o;

    /* renamed from: p, reason: collision with root package name */
    private TextView f5911p;

    /* renamed from: q, reason: collision with root package name */
    private String f5912q;

    /* renamed from: r, reason: collision with root package name */
    private float f5913r;

    /* renamed from: s, reason: collision with root package name */
    private float f5914s;
    private int t;

    /* renamed from: u, reason: collision with root package name */
    private ObjectAnimator f5915u;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface a {
        void ctaClick();
    }

    public MBridgeClickCTAView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ImageView imageView = this.f5909n;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public static /* synthetic */ void b(MBridgeClickCTAView mBridgeClickCTAView) throws JSONException {
        JSONObject jSONObject;
        CampaignEx campaignEx = mBridgeClickCTAView.f5901b;
        if (campaignEx != null && campaignEx.isDynamicView()) {
            try {
                CampaignEx.c rewardTemplateMode = mBridgeClickCTAView.f5901b.getRewardTemplateMode();
                String str = "";
                if (rewardTemplateMode != null) {
                    str = rewardTemplateMode.f() + "";
                }
                i.a(c.m().c(), "cta_click", mBridgeClickCTAView.f5901b.getCampaignUnitId(), mBridgeClickCTAView.f5901b.isBidCampaign(), mBridgeClickCTAView.f5901b.getRequestId(), mBridgeClickCTAView.f5901b.getRequestIdNotice(), mBridgeClickCTAView.f5901b.getId(), str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(com.mbridge.msdk.foundation.same.a.f3606j, mBridgeClickCTAView.a(0));
            } catch (JSONException e3) {
                e = e3;
                jSONObject2 = jSONObject;
                e.printStackTrace();
                jSONObject = jSONObject2;
                mBridgeClickCTAView.f5901b.setTriggerClickSource(1);
                mBridgeClickCTAView.f5901b.setClickTempSource(1);
                mBridgeClickCTAView.notifyListener.a(105, jSONObject);
            }
        } catch (JSONException e7) {
            e = e7;
        }
        mBridgeClickCTAView.f5901b.setTriggerClickSource(1);
        mBridgeClickCTAView.f5901b.setClickTempSource(1);
        mBridgeClickCTAView.notifyListener.a(105, jSONObject);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public final void c() {
        super.c();
        if (this.e) {
            CampaignEx campaignEx = this.f5901b;
            if (campaignEx != null && campaignEx.isDynamicView()) {
                setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.video.module.MBridgeClickCTAView.2
                    @Override // com.mbridge.msdk.widget.a
                    public final void onNoDoubleClick(View view) throws JSONException {
                        MBridgeClickCTAView mBridgeClickCTAView = MBridgeClickCTAView.this;
                        a aVar = mBridgeClickCTAView.ctaClickCallBack;
                        if (aVar != null) {
                            aVar.ctaClick();
                        } else {
                            MBridgeClickCTAView.b(mBridgeClickCTAView);
                        }
                    }
                });
            }
            this.ctaTv.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.video.module.MBridgeClickCTAView.3
                @Override // com.mbridge.msdk.widget.a
                public final void onNoDoubleClick(View view) throws JSONException {
                    MBridgeClickCTAView mBridgeClickCTAView = MBridgeClickCTAView.this;
                    a aVar = mBridgeClickCTAView.ctaClickCallBack;
                    if (aVar != null) {
                        aVar.ctaClick();
                    } else {
                        MBridgeClickCTAView.b(mBridgeClickCTAView);
                    }
                }
            });
            ImageView imageView = this.f5909n;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeClickCTAView.4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                    }
                });
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ObjectAnimator objectAnimator = this.f5915u;
        if (objectAnimator != null) {
            try {
                objectAnimator.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.f5915u;
        if (objectAnimator != null) {
            try {
                objectAnimator.cancel();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f5913r = motionEvent.getRawX();
        this.f5914s = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.t = configuration.orientation;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeClickCTAViewDiff
    public void preLoadData(b bVar) {
        CampaignEx campaignEx = this.f5901b;
        if (campaignEx != null) {
            if (campaignEx.isDynamicView()) {
                com.mbridge.msdk.video.dynview.b.a().a(new com.mbridge.msdk.video.dynview.j.c().b(this, this.f5901b), new h() { // from class: com.mbridge.msdk.video.module.MBridgeClickCTAView.1
                    @Override // com.mbridge.msdk.video.dynview.e.h
                    public final void viewInflaterFail(com.mbridge.msdk.video.dynview.c.a aVar) {
                        af.b(MBridgeBaseView.TAG, "errorMsg:" + aVar.b());
                    }

                    @Override // com.mbridge.msdk.video.dynview.e.h
                    public final void viewInflaterSuccess(com.mbridge.msdk.video.dynview.a aVar) {
                        if (aVar != null) {
                            this.addView(aVar.a());
                            MBridgeClickCTAView mBridgeClickCTAView = MBridgeClickCTAView.this;
                            mBridgeClickCTAView.e = mBridgeClickCTAView.b();
                            MBridgeClickCTAView mBridgeClickCTAView2 = MBridgeClickCTAView.this;
                            mBridgeClickCTAView2.f5911p = (TextView) mBridgeClickCTAView2.findViewById(mBridgeClickCTAView2.findID("mbridge_tv_desc"));
                            MBridgeClickCTAView.this.c();
                        }
                    }
                });
            } else {
                int iFindLayout = findLayout("mbridge_reward_clickable_cta");
                if (iFindLayout >= 0) {
                    this.f5902c.inflate(iFindLayout, this);
                    this.e = b();
                    c();
                    setWrapContent();
                }
            }
            if (this.e) {
                if (com.mbridge.msdk.e.b.a()) {
                    setChinaCTAData();
                }
                this.ctaTv.setText(this.f5901b.getAdCall());
                if (TextUtils.isEmpty(this.f5901b.getIconUrl())) {
                    a();
                } else {
                    com.mbridge.msdk.foundation.same.c.b.a(this.f5900a.getApplicationContext()).a(this.f5901b.getIconUrl(), new e(this.f5909n, this.f5901b, this.f5912q) { // from class: com.mbridge.msdk.video.module.MBridgeClickCTAView.5
                        @Override // com.mbridge.msdk.video.module.a.a.e, com.mbridge.msdk.foundation.same.c.c
                        public final void onFailedLoad(String str, String str2) {
                            super.onFailedLoad(str, str2);
                            MBridgeClickCTAView.this.a();
                        }
                    });
                }
                if (this.f5910o != null && !TextUtils.isEmpty(this.f5901b.getAppName())) {
                    this.f5910o.setText(this.f5901b.getAppName());
                }
                if (this.f5911p == null || TextUtils.isEmpty(this.f5901b.getAppDesc())) {
                    return;
                }
                this.f5911p.setText(this.f5901b.getAppDesc());
            }
        }
    }

    public void setCtaClickCallBack(a aVar) {
        this.ctaClickCallBack = aVar;
    }

    public void setObjectAnimator(ObjectAnimator objectAnimator) {
        this.f5915u = objectAnimator;
    }

    public void setUnitId(String str) {
        this.f5912q = str;
    }

    public MBridgeClickCTAView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeClickCTAViewDiff, com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        this.f5908m = (ViewGroup) findViewById(findID("mbridge_viewgroup_ctaroot"));
        this.f5909n = (ImageView) findViewById(findID("mbridge_iv_appicon"));
        this.f5910o = (TextView) findViewById(findID("mbridge_tv_title"));
        TextView textView = (TextView) findViewById(findID("mbridge_tv_install"));
        this.ctaTv = textView;
        return isNotNULL(this.f5908m, this.f5909n, this.f5910o, textView);
    }
}

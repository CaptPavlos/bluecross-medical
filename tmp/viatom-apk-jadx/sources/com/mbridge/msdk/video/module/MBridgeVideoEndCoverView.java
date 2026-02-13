package com.mbridge.msdk.video.module;

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
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.video.module.a.a.j;
import com.mbridge.msdk.video.signal.factory.b;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeVideoEndCoverView extends MBridgeBaseView {

    /* renamed from: m, reason: collision with root package name */
    private final String f6008m;

    /* renamed from: n, reason: collision with root package name */
    private View f6009n;

    /* renamed from: o, reason: collision with root package name */
    private ImageView f6010o;

    /* renamed from: p, reason: collision with root package name */
    private ImageView f6011p;

    /* renamed from: q, reason: collision with root package name */
    private TextView f6012q;

    /* renamed from: r, reason: collision with root package name */
    private TextView f6013r;

    /* renamed from: s, reason: collision with root package name */
    private TextView f6014s;
    private b t;

    public MBridgeVideoEndCoverView(Context context) {
        super(context);
        this.f6008m = "MBridgeVideoEndCoverView";
    }

    public final void a() throws JSONException {
        JSONObject jSONObject;
        JSONException e;
        JSONObject jSONObject2;
        JSONException e3;
        try {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(a.h, ak.b(c.m().c(), this.f));
                    jSONObject2.put(a.f3605i, ak.b(c.m().c(), this.g));
                    jSONObject2.put(a.f3609m, 0);
                    try {
                        this.f5903d = getContext().getResources().getConfiguration().orientation;
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                    jSONObject2.put(a.f3607k, this.f5903d);
                    jSONObject2.put(a.f3608l, ak.d(getContext()));
                } catch (JSONException e10) {
                    e3 = e10;
                    af.b("MBridgeVideoEndCoverView", e3.getMessage());
                    jSONObject = new JSONObject();
                    jSONObject.put(a.f3606j, jSONObject2);
                    this.notifyListener.a(105, jSONObject);
                }
            } catch (JSONException e11) {
                jSONObject2 = jSONObject3;
                e3 = e11;
            }
            jSONObject = new JSONObject();
            try {
                jSONObject.put(a.f3606j, jSONObject2);
            } catch (JSONException e12) {
                e = e12;
                e.printStackTrace();
                this.notifyListener.a(105, jSONObject);
            }
        } catch (JSONException e13) {
            jSONObject = null;
            e = e13;
        }
        this.notifyListener.a(105, jSONObject);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public final void c() {
        super.c();
        this.f6011p.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoEndCoverView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MBridgeVideoEndCoverView.this.notifyListener.a(104, "");
            }
        });
        this.f6010o.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoEndCoverView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws JSONException {
                MBridgeVideoEndCoverView.this.a();
            }
        });
        this.f6014s.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoEndCoverView.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws JSONException {
                MBridgeVideoEndCoverView.this.a();
            }
        });
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
        int iFindLayout = findLayout("mbridge_reward_videoend_cover");
        if (iFindLayout >= 0) {
            View viewInflate = this.f5902c.inflate(iFindLayout, (ViewGroup) null);
            this.f6009n = viewInflate;
            if (viewInflate != null) {
                this.e = a(viewInflate);
                addView(this.f6009n, -1, -1);
                c();
            }
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f = motionEvent.getRawX();
        this.g = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.f5903d = configuration.orientation;
        removeView(this.f6009n);
        View view = this.f6009n;
        if (view == null) {
            init(this.f5900a);
            preLoadData(this.t);
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f6009n.getParent()).removeView(this.f6009n);
        }
        addView(this.f6009n);
        a(this.f6009n);
        c();
    }

    public void preLoadData(b bVar) {
        ImageView imageView;
        this.t = bVar;
        try {
            CampaignEx campaignEx = this.f5901b;
            if (campaignEx == null || !this.e || campaignEx == null) {
                return;
            }
            if (!TextUtils.isEmpty(campaignEx.getIconUrl()) && (imageView = this.f6010o) != null) {
                com.mbridge.msdk.foundation.same.c.b.a(this.f5900a.getApplicationContext()).a(this.f5901b.getIconUrl(), new j(imageView, ak.a(c.m().c(), 8.0f)));
            }
            TextView textView = this.f6012q;
            if (textView != null) {
                textView.setText(this.f5901b.getAppName());
            }
            TextView textView2 = this.f6014s;
            if (textView2 != null) {
                textView2.setText(this.f5901b.getAdCall());
            }
            TextView textView3 = this.f6013r;
            if (textView3 != null) {
                textView3.setText(this.f5901b.getAppDesc());
            }
        } catch (Throwable th) {
            af.a("MBridgeVideoEndCoverView", th.getMessage());
        }
    }

    public MBridgeVideoEndCoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6008m = "MBridgeVideoEndCoverView";
    }

    private boolean a(View view) {
        if (view == null) {
            return true;
        }
        try {
            this.f6010o = (ImageView) view.findViewById(findID("mbridge_vec_iv_icon"));
            this.f6011p = (ImageView) view.findViewById(findID("mbridge_vec_iv_close"));
            this.f6012q = (TextView) view.findViewById(findID("mbridge_vec_tv_title"));
            this.f6013r = (TextView) view.findViewById(findID("mbridge_vec_tv_desc"));
            this.f6014s = (TextView) view.findViewById(findID("mbridge_vec_btn"));
            return true;
        } catch (Throwable th) {
            af.b("MBridgeVideoEndCoverView", th.getMessage());
            return false;
        }
    }
}

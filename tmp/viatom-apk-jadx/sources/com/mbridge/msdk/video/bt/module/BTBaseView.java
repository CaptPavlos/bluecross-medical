package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.bt.a.d;
import com.mbridge.msdk.videocommon.d.c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class BTBaseView extends FrameLayout {
    public static final String TAG = "BTBaseView";

    /* renamed from: n, reason: collision with root package name */
    protected static int f5565n = 0;

    /* renamed from: o, reason: collision with root package name */
    protected static int f5566o = 1;

    /* renamed from: a, reason: collision with root package name */
    protected Context f5567a;

    /* renamed from: b, reason: collision with root package name */
    protected CampaignEx f5568b;

    /* renamed from: c, reason: collision with root package name */
    protected String f5569c;

    /* renamed from: d, reason: collision with root package name */
    protected String f5570d;
    protected c e;
    protected LayoutInflater f;
    protected int g;
    protected boolean h;

    /* renamed from: i, reason: collision with root package name */
    protected float f5571i;

    /* renamed from: j, reason: collision with root package name */
    protected float f5572j;

    /* renamed from: k, reason: collision with root package name */
    protected Rect f5573k;

    /* renamed from: l, reason: collision with root package name */
    protected int f5574l;

    /* renamed from: m, reason: collision with root package name */
    protected int f5575m;

    public BTBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5570d = "";
        this.g = 1;
        this.h = false;
        this.f5567a = context;
        this.f = LayoutInflater.from(context);
        init(context);
    }

    public final JSONObject a(int i10) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e) {
            e = e;
        }
        try {
            jSONObject.put(a.h, ak.b(com.mbridge.msdk.foundation.controller.c.m().c(), this.f5571i));
            jSONObject.put(a.f3605i, ak.b(com.mbridge.msdk.foundation.controller.c.m().c(), this.f5572j));
            jSONObject.put(a.f3609m, i10);
            try {
                this.g = getContext().getResources().getConfiguration().orientation;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            jSONObject.put(a.f3607k, this.g);
            jSONObject.put(a.f3608l, ak.d(getContext()));
            return jSONObject;
        } catch (JSONException e7) {
            e = e7;
            jSONObject2 = jSONObject;
            e.printStackTrace();
            return jSONObject2;
        }
    }

    public void defaultShow() {
        af.a(TAG, "defaultShow");
    }

    public int findColor(String str) {
        return x.a(this.f5567a.getApplicationContext(), str, "color");
    }

    public int findDrawable(String str) {
        return x.a(this.f5567a.getApplicationContext(), str, "drawable");
    }

    public int findID(String str) {
        return x.a(this.f5567a.getApplicationContext(), str, "id");
    }

    public int findLayout(String str) {
        return x.a(this.f5567a.getApplicationContext(), str, TtmlNode.TAG_LAYOUT);
    }

    public CampaignEx getCampaign() {
        return this.f5568b;
    }

    public String getInstanceId() {
        return this.f5570d;
    }

    public FrameLayout.LayoutParams getParentFrameLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return (FrameLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public LinearLayout.LayoutParams getParentLinearLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public RelativeLayout.LayoutParams getParentRelativeLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            return (RelativeLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public Rect getRect() {
        return this.f5573k;
    }

    public String getUnitId() {
        return this.f5569c;
    }

    public int getViewHeight() {
        return this.f5575m;
    }

    public int getViewWidth() {
        return this.f5574l;
    }

    public abstract void init(Context context);

    public boolean isLandscape() {
        return this.f5567a.getResources().getConfiguration().orientation == 2;
    }

    public boolean isNotNULL(View... viewArr) {
        if (viewArr == null) {
            return false;
        }
        int length = viewArr.length;
        int i10 = 0;
        boolean z9 = false;
        while (i10 < length) {
            if (viewArr[i10] == null) {
                return false;
            }
            i10++;
            z9 = true;
        }
        return z9;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        this.g = configuration.orientation;
        super.onConfigurationChanged(configuration);
    }

    public abstract void onDestory();

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f5571i = motionEvent.getRawX();
        this.f5572j = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        this.g = configuration.orientation;
    }

    public void setCampaign(CampaignEx campaignEx) {
        this.f5568b = campaignEx;
    }

    public void setInstanceId(String str) {
        this.f5570d = str;
    }

    public void setLayout(int i10, int i11) {
        this.f5574l = i10;
        this.f5575m = i11;
    }

    public void setLayoutCenter(int i10, int i11) {
        FrameLayout.LayoutParams parentFrameLayoutParams = getParentFrameLayoutParams();
        RelativeLayout.LayoutParams parentRelativeLayoutParams = getParentRelativeLayoutParams();
        LinearLayout.LayoutParams parentLinearLayoutParams = getParentLinearLayoutParams();
        if (parentRelativeLayoutParams != null) {
            parentRelativeLayoutParams.addRule(13);
            if (i10 != -999) {
                parentRelativeLayoutParams.width = i10;
            }
            if (i11 != -999) {
                parentRelativeLayoutParams.height = i11;
            }
            setLayoutParams(parentRelativeLayoutParams);
            return;
        }
        if (parentLinearLayoutParams != null) {
            parentLinearLayoutParams.gravity = 17;
            if (i10 != -999) {
                parentLinearLayoutParams.width = i10;
            }
            if (i11 != -999) {
                parentLinearLayoutParams.height = i11;
            }
            setLayoutParams(parentLinearLayoutParams);
            return;
        }
        if (parentFrameLayoutParams != null) {
            parentFrameLayoutParams.gravity = 17;
            if (i10 != -999) {
                parentFrameLayoutParams.width = i10;
            }
            if (i11 != -999) {
                parentFrameLayoutParams.height = i11;
            }
            setLayoutParams(parentFrameLayoutParams);
        }
    }

    public void setLayoutParam(int i10, int i11, int i12, int i13) {
        FrameLayout.LayoutParams parentFrameLayoutParams = getParentFrameLayoutParams();
        RelativeLayout.LayoutParams parentRelativeLayoutParams = getParentRelativeLayoutParams();
        LinearLayout.LayoutParams parentLinearLayoutParams = getParentLinearLayoutParams();
        if (parentRelativeLayoutParams != null) {
            parentRelativeLayoutParams.topMargin = i11;
            parentRelativeLayoutParams.leftMargin = i10;
            if (i12 != -999) {
                parentRelativeLayoutParams.width = i12;
            }
            if (i13 != -999) {
                parentRelativeLayoutParams.height = i13;
            }
            setLayoutParams(parentRelativeLayoutParams);
            return;
        }
        if (parentLinearLayoutParams != null) {
            parentLinearLayoutParams.topMargin = i11;
            parentLinearLayoutParams.leftMargin = i10;
            if (i12 != -999) {
                parentLinearLayoutParams.width = i12;
            }
            if (i13 != -999) {
                parentLinearLayoutParams.height = i13;
            }
            setLayoutParams(parentLinearLayoutParams);
            return;
        }
        if (parentFrameLayoutParams != null) {
            parentFrameLayoutParams.topMargin = i11;
            parentFrameLayoutParams.leftMargin = i10;
            if (i12 != -999) {
                parentFrameLayoutParams.width = i12;
            }
            if (i13 != -999) {
                parentFrameLayoutParams.height = i13;
            }
            setLayoutParams(parentFrameLayoutParams);
        }
    }

    public void setMatchParent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
    }

    public void setRect(Rect rect) {
        this.f5573k = rect;
    }

    public void setRewardUnitSetting(c cVar) {
        this.e = cVar;
    }

    public void setUnitId(String str) {
        this.f5569c = str;
    }

    public void setWrapContent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        } else {
            layoutParams.height = -2;
            layoutParams.width = -2;
        }
    }

    public BTBaseView(Context context) {
        this(context, null);
    }

    public void a() {
    }

    public static void a(WebView webView, String str, String str2) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f5565n);
            jSONObject.put("id", str2);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
            g.a().a(webView, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            d.c().a(webView, e.getMessage());
            af.a(TAG, e.getMessage());
        }
    }
}

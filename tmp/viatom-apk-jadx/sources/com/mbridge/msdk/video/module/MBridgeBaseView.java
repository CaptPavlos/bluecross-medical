package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.video.module.a.a;
import com.mbridge.msdk.video.module.a.a.f;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class MBridgeBaseView extends RelativeLayout {
    public static final String TAG = "MBridgeBaseView";

    /* renamed from: a, reason: collision with root package name */
    protected Context f5900a;

    /* renamed from: b, reason: collision with root package name */
    protected CampaignEx f5901b;

    /* renamed from: c, reason: collision with root package name */
    protected LayoutInflater f5902c;

    /* renamed from: d, reason: collision with root package name */
    protected int f5903d;
    protected boolean e;
    protected float f;
    protected float g;
    protected boolean h;

    /* renamed from: i, reason: collision with root package name */
    protected int f5904i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f5905j;

    /* renamed from: k, reason: collision with root package name */
    protected int f5906k;

    /* renamed from: l, reason: collision with root package name */
    protected int f5907l;
    public a notifyListener;

    public MBridgeBaseView(Context context, AttributeSet attributeSet, boolean z9, int i10, boolean z10, int i11, int i12) {
        super(context, attributeSet);
        this.f5903d = 1;
        this.notifyListener = new f();
        this.e = false;
        this.f5906k = 1;
        this.f5907l = 0;
        this.f5900a = context;
        this.f5902c = LayoutInflater.from(context);
        this.h = z9;
        this.f5904i = i10;
        this.f5905j = z10;
        this.f5906k = i11;
        this.f5907l = i12;
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
            jSONObject.put(com.mbridge.msdk.foundation.same.a.h, ak.b(c.m().c(), this.f));
            jSONObject.put(com.mbridge.msdk.foundation.same.a.f3605i, ak.b(c.m().c(), this.g));
            jSONObject.put(com.mbridge.msdk.foundation.same.a.f3609m, i10);
            try {
                this.f5903d = getContext().getResources().getConfiguration().orientation;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            jSONObject.put(com.mbridge.msdk.foundation.same.a.f3607k, this.f5903d);
            jSONObject.put(com.mbridge.msdk.foundation.same.a.f3608l, ak.d(getContext()));
            return jSONObject;
        } catch (JSONException e7) {
            e = e7;
            jSONObject2 = jSONObject;
            e.printStackTrace();
            return jSONObject2;
        }
    }

    public final String d() {
        return a(0).toString();
    }

    public void defaultShow() {
        af.a(TAG, "defaultShow");
    }

    public int filterFindViewId(boolean z9, String str) {
        return z9 ? findDyID(str) : findID(str);
    }

    public int findColor(String str) {
        return x.a(this.f5900a.getApplicationContext(), str, "color");
    }

    public int findDrawable(String str) {
        return x.a(this.f5900a.getApplicationContext(), str, "drawable");
    }

    public int findDyID(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return str.hashCode();
    }

    public int findID(String str) {
        return x.a(this.f5900a.getApplicationContext(), str, "id");
    }

    public int findLayout(String str) {
        return x.a(this.f5900a.getApplicationContext(), str, TtmlNode.TAG_LAYOUT);
    }

    public CampaignEx getCampaign() {
        return this.f5901b;
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

    public abstract void init(Context context);

    public boolean isLandscape() {
        return this.f5900a.getResources().getConfiguration().orientation == 2;
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
        this.f5903d = configuration.orientation;
        super.onConfigurationChanged(configuration);
        Log.d(TAG, "onConfigurationChanged:" + configuration.orientation);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f = motionEvent.getRawX();
        this.g = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        this.f5903d = configuration.orientation;
        Log.d(TAG, "onSelfConfigurationChanged:" + configuration.orientation);
    }

    public void setCampaign(CampaignEx campaignEx) {
        this.f5901b = campaignEx;
    }

    public void setLayoutCenter(int i10, int i11) {
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
        }
    }

    public void setLayoutParam(int i10, int i11, int i12, int i13) {
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

    public void setNotifyListener(a aVar) {
        this.notifyListener = aVar;
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

    public void c() {
    }

    public MBridgeBaseView(Context context) {
        this(context, null);
    }

    public MBridgeBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5903d = 1;
        this.notifyListener = new f();
        this.e = false;
        this.f5906k = 1;
        this.f5907l = 0;
        this.f5900a = context;
        this.f5902c = LayoutInflater.from(context);
        init(context);
    }
}

package com.mbridge.msdk.foundation.d;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.d.a.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.dialog.MBFeedBackDialog;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import org.json.JSONArray;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static int f3435a = -2;

    /* renamed from: b, reason: collision with root package name */
    public static int f3436b = -2;

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f3437c = false;

    /* renamed from: d, reason: collision with root package name */
    private final RelativeLayout.LayoutParams f3438d;
    private final ConcurrentHashMap<String, com.mbridge.msdk.foundation.d.a.a> e;
    private g f;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f3439a = new b();
    }

    private b() {
        this.f3438d = new RelativeLayout.LayoutParams(f3436b, f3435a);
        this.e = new ConcurrentHashMap<>();
    }

    private com.mbridge.msdk.foundation.d.a.a d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = c.m().k();
        }
        if (this.e.containsKey(str)) {
            return this.e.get(str);
        }
        return null;
    }

    public final void a(String str, int i10, int i11, String str2, String str3) {
        com.mbridge.msdk.foundation.d.a.a aVarD = d(a3.a.C(str, "_1"));
        if (aVarD == null) {
            aVarD = d(a3.a.C(str, "_2"));
            if (aVarD == null && (aVarD = d(a3.a.C(str, "_3"))) == null && (aVarD = d(a3.a.C(str, "_4"))) == null) {
                aVarD = a(str);
            } else {
                aVarD.b(0);
            }
        }
        if (aVarD != null) {
            CampaignEx campaignExC = aVarD.c();
            i.a(campaignExC, campaignExC != null ? campaignExC.getCampaignUnitId() : "", aVarD.g(), aVarD.f(), !TextUtils.isEmpty(str2) ? str2 : "", i10, campaignExC != null ? campaignExC.getAdType() : 0, i11, str3);
        }
    }

    public final boolean b() {
        g gVarS = androidx.constraintlayout.core.widgets.analyzer.a.s(h.a());
        this.f = gVarS;
        if (gVarS != null) {
            return false;
        }
        h.a();
        this.f = com.mbridge.msdk.c.i.a();
        return false;
    }

    public final void c(String str) {
        try {
            com.mbridge.msdk.foundation.d.a.a aVarD = d(str);
            if (aVarD != null) {
                aVarD.a();
            }
            this.e.remove(str);
            f3437c = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final FeedBackButton b(String str) {
        return a(str).d();
    }

    public final void b(String str, int i10) {
        a(str).b(i10);
    }

    public final void a(String str, Context context, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, com.mbridge.msdk.foundation.d.a aVar) {
        if (b()) {
            com.mbridge.msdk.foundation.d.a.a aVarA = a(str);
            if (aVar != null) {
                aVarA.a(new a.C0027a(str, aVar));
            }
            FeedBackButton feedBackButtonD = aVarA.d();
            if (feedBackButtonD != null) {
                if (layoutParams == null) {
                    int iE = com.mbridge.msdk.dycreator.baseview.a.e(10.0f);
                    this.f3438d.setMargins(iE, iE, iE, iE);
                    layoutParams = this.f3438d;
                }
                ViewGroup viewGroup2 = (ViewGroup) feedBackButtonD.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(feedBackButtonD);
                }
                Activity activityA = a(context);
                if (activityA != null && viewGroup == null) {
                    viewGroup = (ViewGroup) activityA.findViewById(R.id.content);
                }
                if (viewGroup != null) {
                    viewGroup.removeView(feedBackButtonD);
                    viewGroup.addView(feedBackButtonD, layoutParams);
                }
            }
        }
    }

    public final com.mbridge.msdk.foundation.d.a.a a(String str) {
        com.mbridge.msdk.foundation.d.a.a aVar;
        if (TextUtils.isEmpty(str)) {
            str = c.m().k();
        }
        if (!this.e.containsKey(str)) {
            aVar = new com.mbridge.msdk.foundation.d.a.a(str);
            this.e.put(str, aVar);
        } else {
            aVar = this.e.get(str);
        }
        if (aVar != null) {
            return aVar;
        }
        com.mbridge.msdk.foundation.d.a.a aVar2 = new com.mbridge.msdk.foundation.d.a.a(str);
        this.e.put(str, aVar2);
        return aVar2;
    }

    public final Activity a(Context context) {
        Activity activity;
        Activity activity2;
        Context contextE = c.m().e();
        Activity activity3 = null;
        try {
            activity = contextE instanceof Activity ? (Activity) contextE : null;
        } catch (Exception e) {
            e = e;
        }
        try {
            if ((context instanceof Activity) && !((Activity) context).isDestroyed()) {
                activity = (Activity) context;
            }
            WeakReference<Activity> weakReferenceA = c.m().a();
            if (weakReferenceA != null && (activity2 = weakReferenceA.get()) != null && !activity2.isFinishing() && !activity2.isDestroyed()) {
                activity = activity2;
            }
            if (activity != null && !activity.isFinishing()) {
                if (!activity.isDestroyed()) {
                    return activity;
                }
            }
            return null;
        } catch (Exception e3) {
            e = e3;
            activity3 = activity;
            e.printStackTrace();
            return activity3;
        }
    }

    public final void a(String str, int i10, ViewGroup viewGroup) {
        com.mbridge.msdk.foundation.d.a.a aVarA = a(str);
        if (aVarA.d() != null) {
            aVarA.c(i10);
            if (i10 == 0) {
                a(str, c.m().c(), viewGroup, (ViewGroup.LayoutParams) null, (com.mbridge.msdk.foundation.d.a) null);
            }
        }
    }

    public final void a(String str, int i10, int i11, int i12, float f, float f10, float f11, String str2, String str3, float f12, JSONArray jSONArray) {
        com.mbridge.msdk.foundation.d.a.a aVarA = a(str);
        Context contextC = c.m().c();
        aVarA.a(ak.a(contextC, f), ak.a(contextC, f10), ak.a(contextC, i10), ak.a(contextC, i11), ak.a(contextC, i12), f11, str2, str3, f12, jSONArray);
    }

    public final void a(String str, int i10, com.mbridge.msdk.foundation.d.a aVar) {
        com.mbridge.msdk.foundation.d.a.a aVarA = a(str);
        aVarA.a(new a.C0027a(str, aVar));
        if (i10 == 1) {
            aVarA.b();
        } else {
            aVarA.e();
        }
    }

    public static b a() {
        return a.f3439a;
    }

    public final void a(String str, CampaignEx campaignEx) {
        a(str).a(campaignEx);
    }

    public final void a(String str, String str2) {
        a(str).a(str2);
    }

    public final void a(String str, FeedBackButton feedBackButton) {
        a(str).a(feedBackButton);
    }

    public final void a(String str, com.mbridge.msdk.foundation.d.a aVar) {
        com.mbridge.msdk.foundation.d.a.a aVarA = a(str);
        if (aVar != null) {
            aVarA.a(new a.C0027a(str, aVar));
        }
    }

    public final void a(String str, int i10) {
        a(str).a(i10);
    }

    public final boolean a(String str, Context context, MBFeedBackDialog mBFeedBackDialog) {
        if (mBFeedBackDialog == null) {
            af.c("", "mbAlertDialog  is null");
            return false;
        }
        return a(context, mBFeedBackDialog);
    }

    private boolean a(Context context, MBFeedBackDialog mBFeedBackDialog) {
        Activity activityA = a(context);
        if (activityA == null || mBFeedBackDialog == null || activityA.isDestroyed()) {
            return false;
        }
        try {
            if (!mBFeedBackDialog.isShowing() && !activityA.isFinishing()) {
                mBFeedBackDialog.show();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

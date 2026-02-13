package com.mbridge.msdk.video.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.mbridge.msdk.out.Campaign;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeH5EndCardView extends MBridgeH5EndCardViewDiff {
    private boolean A;
    private boolean B;
    private int C;
    private long D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private String M;
    private boolean N;
    private boolean O;

    /* renamed from: m, reason: collision with root package name */
    protected View f5942m;

    /* renamed from: n, reason: collision with root package name */
    protected RelativeLayout f5943n;

    /* renamed from: o, reason: collision with root package name */
    protected ImageView f5944o;

    /* renamed from: p, reason: collision with root package name */
    protected WindVaneWebView f5945p;

    /* renamed from: q, reason: collision with root package name */
    protected Handler f5946q;

    /* renamed from: r, reason: collision with root package name */
    protected String f5947r;

    /* renamed from: s, reason: collision with root package name */
    protected boolean f5948s;
    protected boolean t;

    /* renamed from: u, reason: collision with root package name */
    Handler f5949u;

    /* renamed from: v, reason: collision with root package name */
    boolean f5950v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f5951w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f5952x;
    private int y;

    /* renamed from: z, reason: collision with root package name */
    private int f5953z;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private MBridgeH5EndCardView f5961b;

        public a(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f5961b = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() throws InterruptedException {
            Handler handler;
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e) {
                af.b("CloseRunnable", e.getMessage());
            }
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f5961b;
            if (mBridgeH5EndCardView == null || (handler = mBridgeH5EndCardView.f5949u) == null) {
                return;
            }
            handler.sendEmptyMessage(100);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private MBridgeH5EndCardView f5963b;

        public b(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f5963b = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f5963b;
            if (mBridgeH5EndCardView == null || mBridgeH5EndCardView.B) {
                return;
            }
            this.f5963b.B = true;
            this.f5963b.f5948s = false;
            MBridgeH5EndCardView.this.reportRenderResult("timeout", 5);
            this.f5963b.notifyListener.a(127, "");
            af.a(MBridgeBaseView.TAG, "notify TYPE_NOTIFY_SHOW_NATIVE_ENDCARD");
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private MBridgeH5EndCardView f5964a;

        /* renamed from: b, reason: collision with root package name */
        private int f5965b;

        public c(MBridgeH5EndCardView mBridgeH5EndCardView, int i10) {
            this.f5964a = mBridgeH5EndCardView;
            this.f5965b = i10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f5964a;
            if (mBridgeH5EndCardView == null || mBridgeH5EndCardView.f5901b == null) {
                return;
            }
            try {
                if (mBridgeH5EndCardView.A) {
                    af.c(MBridgeBaseView.TAG, "insertEndCardReadyState hasInsertLoadEndCardReport true return");
                    return;
                }
                this.f5964a.A = true;
                n nVar = new n("m_download_end", 12, (this.f5965b * 1000) + "", this.f5964a.f5901b.getendcard_url(), this.f5964a.f5901b.getId(), this.f5964a.unitId, "ready timeout", (ap.b(this.f5964a.f5901b.getendcard_url()) && this.f5964a.f5901b.getendcard_url().contains(".zip")) ? "1" : "2");
                try {
                    if (this.f5964a.f5901b.getAdType() == 287) {
                        nVar.d(ExifInterface.GPS_MEASUREMENT_3D);
                    } else if (this.f5964a.f5901b.getAdType() == 94) {
                        nVar.d("1");
                    } else if (this.f5964a.f5901b.getAdType() == 42) {
                        nVar.d("2");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                nVar.f(this.f5964a.f5901b.getRequestId());
                nVar.s(this.f5964a.f5901b.getCurrentLocalRid());
                nVar.g(this.f5964a.f5901b.getRequestIdNotice());
                nVar.c(this.f5964a.f5901b.getAdSpaceT());
                this.f5964a.isLoadSuccess();
            } catch (Throwable th) {
                af.b(MBridgeBaseView.TAG, th.getMessage(), th);
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class d implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private MBridgeH5EndCardView f5967b;

        public d(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f5967b = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f5967b;
            if (mBridgeH5EndCardView != null) {
                mBridgeH5EndCardView.I = true;
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class e implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private MBridgeH5EndCardView f5969b;

        public e(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f5969b = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f5969b;
            if (mBridgeH5EndCardView != null) {
                mBridgeH5EndCardView.J = true;
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class f implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private MBridgeH5EndCardView f5971b;

        public f(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f5971b = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f5971b;
            if (mBridgeH5EndCardView != null) {
                if (!mBridgeH5EndCardView.K) {
                    MBridgeH5EndCardView.this.setCloseVisible(0);
                }
                this.f5971b.F = true;
            }
        }
    }

    public MBridgeH5EndCardView(Context context) {
        super(context);
        this.f5951w = false;
        this.f5946q = new Handler();
        this.f5948s = false;
        this.t = false;
        this.f5952x = false;
        this.y = 1;
        this.f5953z = 1;
        this.A = false;
        this.B = false;
        this.C = 1;
        this.D = 0L;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = "";
        this.f5949u = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.video.module.MBridgeH5EndCardView.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 100) {
                    return;
                }
                if (MBridgeH5EndCardView.this.E) {
                    MBridgeH5EndCardView.this.notifyListener.a(R.styleable.ConstraintSet_transitionPathRotate, "");
                }
                MBridgeH5EndCardView.this.notifyListener.a(103, "");
            }
        };
        this.N = false;
        this.O = false;
        this.f5950v = false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:6|7|(1:14)(1:11)|15|(1:17)(2:20|(1:22)(15:23|19|24|65|25|(1:27)(2:30|(1:32)(2:33|(1:35)))|64|38|60|39|(1:41)|44|(1:46)|49|(1:69)(4:52|(1:54)(1:55)|56|70)))|18|19|24|65|25|(0)(0)|64|38|60|39|(0)|44|(0)|49|(1:69)(1:68)) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0088, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a6, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ed, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0101, code lost:
    
        com.mbridge.msdk.foundation.tools.af.b(com.mbridge.msdk.video.module.MBridgeBaseView.TAG, r0.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0082 A[Catch: all -> 0x002d, NullPointerException -> 0x0088, TryCatch #2 {NullPointerException -> 0x0088, blocks: (B:25:0x0078, B:27:0x0082, B:30:0x008a, B:32:0x0094, B:33:0x0098, B:35:0x00a2), top: B:65:0x0078, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008a A[Catch: all -> 0x002d, NullPointerException -> 0x0088, TryCatch #2 {NullPointerException -> 0x0088, blocks: (B:25:0x0078, B:27:0x0082, B:30:0x008a, B:32:0x0094, B:33:0x0098, B:35:0x00a2), top: B:65:0x0078, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e5 A[Catch: all -> 0x002d, Exception -> 0x00ed, TryCatch #0 {Exception -> 0x00ed, blocks: (B:39:0x00cf, B:41:0x00e5, B:44:0x00ef, B:46:0x00f9), top: B:60:0x00cf, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f9 A[Catch: all -> 0x002d, Exception -> 0x00ed, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ed, blocks: (B:39:0x00cf, B:41:0x00e5, B:44:0x00ef, B:46:0x00f9), top: B:60:0x00cf, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(com.mbridge.msdk.video.module.MBridgeH5EndCardView r16, long r17, boolean r19) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeH5EndCardView.a(com.mbridge.msdk.video.module.MBridgeH5EndCardView, long, boolean):void");
    }

    public static /* synthetic */ void d(MBridgeH5EndCardView mBridgeH5EndCardView) throws JSONException {
        CampaignEx campaignEx = mBridgeH5EndCardView.f5901b;
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        int i10 = mBridgeH5EndCardView.getResources().getConfiguration().orientation;
        String str = "undefined";
        if (i10 != 0) {
            if (i10 == 1) {
                str = "portrait";
            } else if (i10 == 2) {
                str = "landscape";
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("orientation", str);
            jSONObject.put("locked", "true");
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        HashMap map = new HashMap();
        map.put(MRAIDCommunicatorUtil.KEY_PLACEMENTTYPE, MRAIDCommunicatorUtil.PLACEMENT_INTERSTITIAL);
        map.put(MRAIDCommunicatorUtil.KEY_STATE, MRAIDCommunicatorUtil.STATES_DEFAULT);
        map.put(MRAIDCommunicatorUtil.KEY_VIEWABLE, "true");
        map.put(MRAIDCommunicatorUtil.KEY_CURRENTORIENTATION, jSONObject);
        if (mBridgeH5EndCardView.getContext() instanceof Activity) {
            float fJ = ab.j(mBridgeH5EndCardView.getContext());
            float fH = ab.h(mBridgeH5EndCardView.getContext());
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) mBridgeH5EndCardView.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            float f10 = displayMetrics.widthPixels;
            float f11 = displayMetrics.heightPixels;
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(mBridgeH5EndCardView.f5945p, fJ, fH);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(mBridgeH5EndCardView.f5945p, f10, f11);
        }
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBridgeH5EndCardView.f5945p, r7.getLeft(), mBridgeH5EndCardView.f5945p.getTop(), mBridgeH5EndCardView.f5945p.getWidth(), mBridgeH5EndCardView.f5945p.getHeight());
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(mBridgeH5EndCardView.f5945p, r13.getLeft(), mBridgeH5EndCardView.f5945p.getTop(), mBridgeH5EndCardView.f5945p.getWidth(), mBridgeH5EndCardView.f5945p.getHeight());
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBridgeH5EndCardView.f5945p, map);
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBridgeH5EndCardView.f5945p, com.mbridge.msdk.mbsignalcommon.mraid.d.f4382a);
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBridgeH5EndCardView.f5945p);
    }

    public static /* synthetic */ void f(MBridgeH5EndCardView mBridgeH5EndCardView) {
        try {
            CampaignEx campaignEx = mBridgeH5EndCardView.f5901b;
            if (campaignEx != null) {
                campaignEx.setCampaignUnitId(mBridgeH5EndCardView.unitId);
                com.mbridge.msdk.foundation.d.b.a().c(mBridgeH5EndCardView.unitId + "_1");
                com.mbridge.msdk.foundation.d.b.a().a(mBridgeH5EndCardView.unitId + "_2", mBridgeH5EndCardView.f5901b);
            }
            CampaignEx campaignEx2 = mBridgeH5EndCardView.f5901b;
            if (campaignEx2 == null || !campaignEx2.isMraid()) {
                return;
            }
            ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().c());
            imageView.setBackgroundResource(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_notice", "drawable"));
            ImageView imageView2 = mBridgeH5EndCardView.f5944o;
            RelativeLayout.LayoutParams layoutParams = imageView2 != null ? (RelativeLayout.LayoutParams) imageView2.getLayoutParams() : null;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 12.0f), ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 12.0f));
            layoutParams2.addRule(9);
            layoutParams2.addRule(10);
            if (layoutParams != null) {
                layoutParams2.leftMargin = layoutParams.rightMargin;
                layoutParams2.topMargin = layoutParams.topMargin;
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = layoutParams.height;
            } else {
                layoutParams2.leftMargin = ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 12.0f);
                layoutParams2.topMargin = ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 12.0f);
            }
            mBridgeH5EndCardView.addView(imageView, layoutParams2);
            ak.a(4, imageView, mBridgeH5EndCardView.f5901b, com.mbridge.msdk.foundation.controller.c.m().c(), false, new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.video.module.MBridgeH5EndCardView.5
                @Override // com.mbridge.msdk.foundation.d.a
                public final void close() {
                    String string;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th) {
                        af.b(MBridgeBaseView.TAG, th.getMessage(), th);
                        string = "";
                    }
                    g.a().a((WebView) MBridgeH5EndCardView.this.f5945p, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void showed() {
                    String string;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th) {
                        af.b(MBridgeBaseView.TAG, th.getMessage(), th);
                        string = "";
                    }
                    g.a().a((WebView) MBridgeH5EndCardView.this.f5945p, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void summit(String str) {
                    String string;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th) {
                        af.b(MBridgeBaseView.TAG, th.getMessage(), th);
                        string = "";
                    }
                    g.a().a((WebView) MBridgeH5EndCardView.this.f5945p, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }
            });
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public RelativeLayout.LayoutParams b() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public final void c() {
        super.c();
        if (this.e) {
            this.f5944o.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeH5EndCardView.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MBridgeH5EndCardView.this.onCloseViewClick();
                }
            });
        }
    }

    public boolean canBackPress() {
        ImageView imageView = this.f5944o;
        return imageView != null && imageView.getVisibility() == 0;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void close() {
        try {
            onCloseViewClick();
        } catch (Exception e3) {
            af.b(MBridgeBaseView.TAG, e3.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void defaultShow() {
        super.defaultShow();
    }

    public void e() {
        if (this.e) {
            setMatchParent();
        }
    }

    public void excuteEndCardShowTask(int i10) {
        this.f5946q.postDelayed(new c(this, i10), i10 * 1000);
    }

    public void excuteTask() {
        if (this.f5952x || this.y <= -1) {
            return;
        }
        this.f5946q.postDelayed(new f(this), this.y * 1000);
    }

    public void executeEndCardShow(int i10) {
        this.f5946q.postDelayed(new b(this), i10 * 1000);
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public CampaignEx getMraidCampaign() {
        return this.f5901b;
    }

    public void handlerPlayableException(String str) {
        if (this.t) {
            return;
        }
        this.t = true;
        this.f5948s = false;
        if (this.f5901b != null) {
            n nVar = new n();
            nVar.f(this.f5901b.getRequestId());
            nVar.g(this.f5901b.getRequestIdNotice());
            nVar.e(this.f5901b.getId());
            nVar.h(str);
            com.mbridge.msdk.foundation.same.report.g.a(nVar, this.f5900a.getApplicationContext(), this.unitId);
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
        int iFindLayout = findLayout("mbridge_reward_endcard_h5");
        if (iFindLayout >= 0) {
            View viewInflate = this.f5902c.inflate(iFindLayout, (ViewGroup) null);
            this.f5942m = viewInflate;
            try {
                this.f5944o = (ImageView) viewInflate.findViewById(findID("mbridge_windwv_close"));
                this.f5943n = (RelativeLayout) viewInflate.findViewById(findID("mbridge_windwv_content_rl"));
                WindVaneWebView windVaneWebView = new WindVaneWebView(getContext());
                this.f5945p = windVaneWebView;
                CampaignEx campaignEx = this.f5901b;
                if (campaignEx != null) {
                    windVaneWebView.setLocalRequestId(campaignEx.getCurrentLocalRid());
                }
                this.f5945p.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                this.f5943n.addView(this.f5945p);
                this.e = isNotNULL(this.f5944o, this.f5945p);
            } catch (Exception unused) {
                this.e = false;
            }
            addView(this.f5942m, b());
            c();
            e();
        }
    }

    public boolean isLoadSuccess() {
        return this.f5948s;
    }

    public boolean isPlayable() {
        return this.f5952x;
    }

    @Override // com.mbridge.msdk.video.signal.h
    public void notifyCloseBtn(int i10) {
        if (i10 == 0) {
            this.G = true;
        } else {
            if (i10 != 1) {
                return;
            }
            this.H = true;
        }
    }

    public void onBackPress() {
        boolean z9;
        if (this.F || (((z9 = this.G) && this.H) || (!(z9 || !this.I || this.f5950v) || (!z9 && this.J && this.f5950v)))) {
            onCloseViewClick();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.mbridge.msdk.foundation.same.report.d.d] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.mbridge.msdk.foundation.entity.CampaignEx] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0032 -> B:18:0x0057). Please report as a decompilation issue!!! */
    public void onCloseViewClick() {
        Object objA = "";
        int i10 = 119;
        int i11 = 103;
        try {
            if (this.f5945p != null) {
                g.a().a((WebView) this.f5945p, "onSystemDestory", "");
                new Thread(new a(this)).start();
            } else {
                this.notifyListener.a(103, "");
                this.notifyListener.a(R.styleable.ConstraintSet_quantizeMotionSteps, "webview is null when closing webview");
            }
        } catch (Exception e3) {
            this.notifyListener.a(i11, objA);
            this.notifyListener.a(i10, "close webview exception" + e3.getMessage());
            af.a(MBridgeBaseView.TAG, e3.getMessage());
        }
        try {
            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
            eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
            com.mbridge.msdk.foundation.same.report.d.d.a().a("2000152", eVar);
            objA = com.mbridge.msdk.foundation.same.report.d.d.a();
            i10 = "2000134";
            i11 = this.f5901b;
            objA.a("2000134", i11);
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.out.BaseTrackingListener
    public void onFinishRedirection(Campaign campaign, String str) {
        if (campaign == null) {
            return;
        }
        aj.a(campaign, this);
    }

    @Override // com.mbridge.msdk.out.BaseTrackingListener
    public void onRedirectionFailed(Campaign campaign, String str) {
        if (campaign == null) {
            return;
        }
        aj.a(campaign, this);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void onSelfConfigurationChanged(Configuration configuration) throws JSONException {
        super.onSelfConfigurationChanged(configuration);
        orientation(configuration);
    }

    @Override // com.mbridge.msdk.out.BaseTrackingListener
    public void onStartRedirection(Campaign campaign, String str) {
        aj.b(campaign, this);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (i10 != 0 || this.L) {
            return;
        }
        this.L = true;
        setFocusableInTouchMode(true);
        requestFocus();
        requestFocusFromTouch();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z9) {
        super.onWindowFocusChanged(z9);
        CampaignEx campaignEx = this.f5901b;
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        if (z9) {
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.f5945p, "true");
        } else {
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.f5945p, "false");
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff, com.mbridge.msdk.mbsignalcommon.mraid.b
    public void open(String str) {
        super.open(str);
    }

    public void orientation(Configuration configuration) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            if (configuration.orientation == 2) {
                jSONObject.put("orientation", "landscape");
            } else {
                jSONObject.put("orientation", "portrait");
            }
            g.a().a((WebView) this.f5945p, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014e A[Catch: all -> 0x00f9, TryCatch #0 {all -> 0x00f9, blocks: (B:35:0x00c2, B:37:0x00e4, B:39:0x00ea, B:42:0x00f2, B:47:0x00fc, B:49:0x0104, B:51:0x010c, B:53:0x010f, B:55:0x0113, B:57:0x011b, B:59:0x0123, B:61:0x0129, B:63:0x0130, B:71:0x014e, B:72:0x0152, B:64:0x013b, B:66:0x0140, B:68:0x0146), top: B:83:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0152 A[Catch: all -> 0x00f9, TRY_LEAVE, TryCatch #0 {all -> 0x00f9, blocks: (B:35:0x00c2, B:37:0x00e4, B:39:0x00ea, B:42:0x00f2, B:47:0x00fc, B:49:0x0104, B:51:0x010c, B:53:0x010f, B:55:0x0113, B:57:0x011b, B:59:0x0123, B:61:0x0129, B:63:0x0130, B:71:0x014e, B:72:0x0152, B:64:0x013b, B:66:0x0140, B:68:0x0146), top: B:83:0x00c2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void preLoadData(com.mbridge.msdk.video.signal.factory.b r15) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeH5EndCardView.preLoadData(com.mbridge.msdk.video.signal.factory.b):void");
    }

    public void release() {
        Handler handler = this.f5946q;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f5946q = null;
        }
        Handler handler2 = this.f5949u;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.f5949u = null;
        }
        this.f5943n.removeAllViews();
        this.f5945p.release();
        this.f5945p = null;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff
    public void reportOpen(String str) {
        CampaignEx mraidCampaign = getMraidCampaign();
        if (mraidCampaign != null) {
            new h(getContext()).a(mraidCampaign.getRequestId(), mraidCampaign.getRequestIdNotice(), mraidCampaign.getId(), this.unitId, str, this.f5901b.isBidCampaign());
        }
    }

    public void reportRenderResult(String str, int i10) {
        if (this.f5901b == null || this.t) {
            return;
        }
        n nVar = new n();
        nVar.f(this.f5901b.getRequestId());
        nVar.g(this.f5901b.getRequestIdNotice());
        nVar.e(this.f5901b.getId());
        nVar.b(i10);
        nVar.l(String.valueOf(System.currentTimeMillis() - this.D));
        nVar.h(str);
        String str2 = "2";
        if (this.f5901b.getAdType() == 287) {
            nVar.d(ExifInterface.GPS_MEASUREMENT_3D);
        } else if (this.f5901b.getAdType() == 94) {
            nVar.d("1");
        } else if (this.f5901b.getAdType() == 42) {
            nVar.d("2");
        }
        if (this.f5901b.isMraid()) {
            nVar.d(n.f3580a);
        } else {
            nVar.n(this.f5901b.getendcard_url());
            if (ap.b(this.f5901b.getendcard_url()) && this.f5901b.getendcard_url().contains(".zip")) {
                str2 = "1";
            }
            nVar.o(str2);
            nVar.d(n.f3581b);
        }
        com.mbridge.msdk.foundation.same.report.g.b(nVar, this.unitId, this.f5901b);
    }

    public void setCloseDelayShowTime(int i10) {
        this.y = i10;
    }

    public void setCloseVisible(int i10) {
        if (this.e) {
            this.f5944o.setVisibility(i10);
        }
    }

    public void setCloseVisibleForMraid(int i10) {
        if (this.e) {
            this.K = true;
            ImageView imageView = this.f5944o;
            if (i10 == 4) {
                imageView.setImageDrawable(new ColorDrawable(16711680));
            } else {
                imageView.setImageResource(findDrawable("mbridge_reward_close"));
            }
            this.f5944o.setVisibility(0);
        }
    }

    public void setError(boolean z9) {
        this.t = z9;
    }

    public void setHtmlSource(String str) {
        this.f5947r = str;
    }

    public void setLoadPlayable(boolean z9) {
        this.f5950v = z9;
    }

    public void setNotchValue(String str, int i10, int i11, int i12, int i13) {
        this.M = str;
        CampaignEx campaignEx = this.f5901b;
        if (campaignEx == null || campaignEx.getAdSpaceT() == 2) {
            return;
        }
        af.b(MBridgeBaseView.TAG, "NOTCH H5ENDCARD ".concat(String.format("%1s-%2s-%3s-%4s", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13))));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f5944o.getLayoutParams();
        int iA = ak.a(getContext(), 20.0f);
        layoutParams.setMargins(i10 + iA, i12 + iA, i11 + iA, i13 + iA);
        this.f5944o.setLayoutParams(layoutParams);
    }

    public void setPlayCloseBtnTm(int i10) {
        this.f5953z = i10;
    }

    public void setUnitId(String str) {
        this.unitId = str;
    }

    public void startCounterEndCardShowTimer() {
        try {
            String str = this.f5901b.getendcard_url();
            if (ap.b(str) && str.contains("wfl=1")) {
                String[] strArrSplit = str.split("&");
                int iA = 15;
                if (strArrSplit != null && strArrSplit.length > 0) {
                    for (String str2 : strArrSplit) {
                        if (ap.b(str2) && str2.contains("timeout") && str2.split("=") != null && str2.split("=").length > 0) {
                            iA = ak.a((Object) str2.split("=")[1]);
                        }
                    }
                }
                executeEndCardShow(iA);
            }
        } catch (Throwable th) {
            af.a(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.h
    public void toggleCloseBtn(int i10) {
        int visibility = this.f5944o.getVisibility();
        if (i10 == 1) {
            this.F = true;
            visibility = 0;
        } else if (i10 == 2) {
            this.F = false;
            if (this.f5950v) {
                if (!this.O && !this.G) {
                    this.O = true;
                    int i11 = this.f5953z;
                    if (i11 == 0) {
                        this.J = true;
                    } else {
                        this.J = false;
                        if (i11 > -1) {
                            this.f5946q.postDelayed(new e(this), this.f5953z * 1000);
                        }
                    }
                }
            } else if (!this.N && !this.G) {
                this.N = true;
                int i12 = this.y;
                if (i12 == 0) {
                    this.I = true;
                } else {
                    this.I = false;
                    if (i12 > -1) {
                        this.f5946q.postDelayed(new d(this), this.y * 1000);
                    }
                }
            }
            visibility = 8;
        }
        setCloseVisible(visibility);
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void unload() {
        close();
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void useCustomClose(boolean z9) {
        try {
            setCloseVisibleForMraid(z9 ? 4 : 0);
        } catch (Exception e3) {
            af.b(MBridgeBaseView.TAG, e3.getMessage());
        }
    }

    public void volumeChange(double d8) {
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.f5945p, d8);
    }

    public void webviewshow() {
        WindVaneWebView windVaneWebView = this.f5945p;
        if (windVaneWebView != null) {
            windVaneWebView.post(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeH5EndCardView.4
                @Override // java.lang.Runnable
                public final void run() {
                    String string;
                    try {
                        af.a(MBridgeBaseView.TAG, "webviewshow");
                        try {
                            int[] iArr = new int[2];
                            MBridgeH5EndCardView.this.f5945p.getLocationOnScreen(iArr);
                            af.b(MBridgeBaseView.TAG, "coordinate:" + iArr[0] + "--" + iArr[1]);
                            JSONObject jSONObject = new JSONObject();
                            Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                            if (contextC != null) {
                                jSONObject.put("startX", ak.b(contextC, iArr[0]));
                                jSONObject.put("startY", ak.b(contextC, iArr[1]));
                                jSONObject.put(com.mbridge.msdk.foundation.same.a.f3608l, ak.d(contextC));
                            }
                            string = jSONObject.toString();
                        } catch (Throwable th) {
                            af.b(MBridgeBaseView.TAG, th.getMessage(), th);
                            string = "";
                        }
                        g.a().a((WebView) MBridgeH5EndCardView.this.f5945p, "webviewshow", Base64.encodeToString(string.toString().getBytes(), 2));
                        MBridgeH5EndCardView.this.notifyListener.a(109, "");
                        MBridgeH5EndCardView.d(MBridgeH5EndCardView.this);
                        MBridgeH5EndCardView.this.startCounterEndCardShowTimer();
                        g gVarA = g.a();
                        MBridgeH5EndCardView mBridgeH5EndCardView = MBridgeH5EndCardView.this;
                        gVarA.a((WebView) mBridgeH5EndCardView.f5945p, "oncutoutfetched", Base64.encodeToString(mBridgeH5EndCardView.M.getBytes(), 0));
                        MBridgeH5EndCardView.f(MBridgeH5EndCardView.this);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            });
        }
    }

    public void install(CampaignEx campaignEx) {
    }

    public void readyStatus(int i10) {
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void expand(String str, boolean z9) {
    }

    public MBridgeH5EndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5951w = false;
        this.f5946q = new Handler();
        this.f5948s = false;
        this.t = false;
        this.f5952x = false;
        this.y = 1;
        this.f5953z = 1;
        this.A = false;
        this.B = false;
        this.C = 1;
        this.D = 0L;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = "";
        this.f5949u = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.video.module.MBridgeH5EndCardView.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 100) {
                    return;
                }
                if (MBridgeH5EndCardView.this.E) {
                    MBridgeH5EndCardView.this.notifyListener.a(R.styleable.ConstraintSet_transitionPathRotate, "");
                }
                MBridgeH5EndCardView.this.notifyListener.a(103, "");
            }
        };
        this.N = false;
        this.O = false;
        this.f5950v = false;
    }

    public String a() {
        String endScreenUrl;
        CampaignEx campaignEx = this.f5901b;
        if (campaignEx != null) {
            this.E = true;
            if (campaignEx.isMraid()) {
                this.f5952x = false;
                String mraid = this.f5901b.getMraid();
                if (!TextUtils.isEmpty(mraid)) {
                    File file = new File(mraid);
                    try {
                        if (file.exists() && file.isFile() && file.canRead()) {
                            endScreenUrl = "file:////" + mraid;
                        } else {
                            endScreenUrl = this.f5901b.getEndScreenUrl();
                        }
                        return endScreenUrl;
                    } catch (Throwable th) {
                        if (!MBridgeConstans.DEBUG) {
                            return mraid;
                        }
                        th.printStackTrace();
                        return mraid;
                    }
                }
                return this.f5901b.getEndScreenUrl();
            }
            String str = this.f5901b.getendcard_url();
            if (!ap.a(str)) {
                this.f5952x = true;
                String h5ResAddress = H5DownLoadManager.getInstance().getH5ResAddress(str);
                if (TextUtils.isEmpty(h5ResAddress)) {
                    try {
                        String path = Uri.parse(str).getPath();
                        if (!TextUtils.isEmpty(path) && path.toLowerCase().endsWith(".zip")) {
                            String endScreenUrl2 = this.f5901b.getEndScreenUrl();
                            if (TextUtils.isEmpty(endScreenUrl2)) {
                                return null;
                            }
                            this.f5952x = false;
                            excuteTask();
                            return endScreenUrl2;
                        }
                    } catch (Throwable th2) {
                        af.b(MBridgeBaseView.TAG, th2.getMessage());
                    }
                    StringBuilder sbW = a3.a.w(str, "&native_adtype=");
                    sbW.append(this.f5901b.getAdType());
                    return sbW.toString();
                }
                StringBuilder sbW2 = a3.a.w(h5ResAddress, "&native_adtype=");
                sbW2.append(this.f5901b.getAdType());
                return sbW2.toString();
            }
            this.f5952x = false;
            return this.f5901b.getEndScreenUrl();
        }
        this.E = false;
        return null;
    }
}

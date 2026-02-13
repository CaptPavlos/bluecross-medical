package com.mbridge.msdk.video.signal.a;

import android.app.Activity;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.video.signal.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a implements com.mbridge.msdk.video.signal.d {

    /* renamed from: j, reason: collision with root package name */
    protected String f6137j;

    /* renamed from: k, reason: collision with root package name */
    protected com.mbridge.msdk.videocommon.d.c f6138k;

    /* renamed from: l, reason: collision with root package name */
    protected com.mbridge.msdk.click.a f6139l;

    /* renamed from: a, reason: collision with root package name */
    protected boolean f6132a = false;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f6133b = false;

    /* renamed from: c, reason: collision with root package name */
    protected int f6134c = 0;

    /* renamed from: d, reason: collision with root package name */
    protected int f6135d = 0;
    protected int e = 0;
    protected int f = 0;
    protected int g = 0;
    protected int h = 1;

    /* renamed from: i, reason: collision with root package name */
    protected int f6136i = -1;

    /* renamed from: m, reason: collision with root package name */
    public a.InterfaceC0069a f6140m = new C0070a();

    /* renamed from: n, reason: collision with root package name */
    protected int f6141n = 2;

    /* renamed from: o, reason: collision with root package name */
    private t3.b f6142o = null;

    /* renamed from: p, reason: collision with root package name */
    private u3.b f6143p = null;

    /* renamed from: q, reason: collision with root package name */
    private t3.a f6144q = null;

    @Override // com.mbridge.msdk.video.signal.a
    public void a(int i10, String str) {
        af.a("DefaultJSCommon", "statistics,type:" + i10 + ",json:" + str);
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void b(String str) {
        af.a("DefaultJSCommon", "setNotchArea");
    }

    @Override // com.mbridge.msdk.video.signal.a
    public String c() {
        af.a("DefaultJSCommon", "init");
        return "{}";
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void click(int i10, String str) {
        af.a("DefaultJSCommon", "click:type" + i10 + ",pt:" + str);
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void d() {
        af.a("DefaultJSCommon", "finish");
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void e() {
        af.a("DefaultJSCommon", "release");
        com.mbridge.msdk.click.a aVar = this.f6139l;
        if (aVar != null) {
            aVar.a(false);
            this.f6139l.a((NativeListener.NativeTrackingListener) null);
            this.f6139l.a();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void f(int i10) {
        this.f6136i = i10;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public String g(int i10) {
        af.a("DefaultJSCommon", "getSDKInfo");
        return "{}";
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final int h() {
        af.a("DefaultJSCommon", "getAlertDialogRole " + this.h);
        return this.h;
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void handlerH5Exception(int i10, String str) {
        af.a("DefaultJSCommon", "handlerH5Exception,code=" + i10 + ",msg:" + str);
    }

    @Override // com.mbridge.msdk.video.signal.a
    public String i() {
        af.a("DefaultJSCommon", "getNotchArea");
        return null;
    }

    public final t3.b j() {
        return this.f6142o;
    }

    public final u3.b k() {
        return this.f6143p;
    }

    public final t3.a l() {
        return this.f6144q;
    }

    public final int m() {
        if (this.f6134c == 0 && this.f6133b) {
            this.f6134c = 1;
        }
        return this.f6134c;
    }

    public final int n() {
        if (this.f6135d == 0 && this.f6133b) {
            this.f6135d = 1;
        }
        return this.f6135d;
    }

    public final int o() {
        if (this.e == 0 && this.f6133b) {
            this.e = 1;
        }
        return this.e;
    }

    public final boolean p() {
        return this.f6133b;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void f() {
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class b implements a.InterfaceC0069a {

        /* renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.video.signal.d f6145a;

        /* renamed from: b, reason: collision with root package name */
        private a.InterfaceC0069a f6146b;

        public b(com.mbridge.msdk.video.signal.d dVar, a.InterfaceC0069a interfaceC0069a) {
            this.f6145a = dVar;
            this.f6146b = interfaceC0069a;
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0069a
        public final void a() {
            a.InterfaceC0069a interfaceC0069a = this.f6146b;
            if (interfaceC0069a != null) {
                interfaceC0069a.a();
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0069a
        public final void b() {
            a.InterfaceC0069a interfaceC0069a = this.f6146b;
            if (interfaceC0069a != null) {
                interfaceC0069a.b();
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public final void onDismissLoading(Campaign campaign) {
            a.InterfaceC0069a interfaceC0069a = this.f6146b;
            if (interfaceC0069a != null) {
                interfaceC0069a.onDismissLoading(campaign);
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public final void onDownloadFinish(Campaign campaign) {
            a.InterfaceC0069a interfaceC0069a = this.f6146b;
            if (interfaceC0069a != null) {
                interfaceC0069a.onDownloadFinish(campaign);
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public final void onDownloadProgress(int i10) {
            a.InterfaceC0069a interfaceC0069a = this.f6146b;
            if (interfaceC0069a != null) {
                interfaceC0069a.onDownloadProgress(i10);
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public final void onDownloadStart(Campaign campaign) {
            a.InterfaceC0069a interfaceC0069a = this.f6146b;
            if (interfaceC0069a != null) {
                interfaceC0069a.onDownloadStart(campaign);
            }
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public final void onFinishRedirection(Campaign campaign, String str) {
            a.InterfaceC0069a interfaceC0069a = this.f6146b;
            if (interfaceC0069a != null) {
                interfaceC0069a.onFinishRedirection(campaign, str);
            }
            com.mbridge.msdk.video.signal.d dVar = this.f6145a;
            if (dVar != null) {
                dVar.d();
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public final boolean onInterceptDefaultLoadingDialog() {
            a.InterfaceC0069a interfaceC0069a = this.f6146b;
            return interfaceC0069a != null && interfaceC0069a.onInterceptDefaultLoadingDialog();
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public final void onRedirectionFailed(Campaign campaign, String str) {
            a.InterfaceC0069a interfaceC0069a = this.f6146b;
            if (interfaceC0069a != null) {
                interfaceC0069a.onRedirectionFailed(campaign, str);
            }
            com.mbridge.msdk.video.signal.d dVar = this.f6145a;
            if (dVar != null) {
                dVar.d();
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public final void onShowLoading(Campaign campaign) {
            a.InterfaceC0069a interfaceC0069a = this.f6146b;
            if (interfaceC0069a != null) {
                interfaceC0069a.onShowLoading(campaign);
            }
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public final void onStartRedirection(Campaign campaign, String str) {
            a.InterfaceC0069a interfaceC0069a = this.f6146b;
            if (interfaceC0069a != null) {
                interfaceC0069a.onStartRedirection(campaign, str);
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0069a
        public final void a(boolean z9) {
            a.InterfaceC0069a interfaceC0069a = this.f6146b;
            if (interfaceC0069a != null) {
                interfaceC0069a.a(z9);
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0069a
        public final void a(int i10, String str) {
            a.InterfaceC0069a interfaceC0069a = this.f6146b;
            if (interfaceC0069a != null) {
                interfaceC0069a.a(i10, str);
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final boolean b() {
        return this.f6132a;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void d(int i10) {
        this.e = i10;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void b(boolean z9) {
        this.f6132a = z9;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void b(int i10) {
        this.f6135d = i10;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void c(int i10) {
        this.f6134c = i10;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final int g() {
        return this.f6136i;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void h(int i10) {
        com.mbridge.msdk.dycreator.baseview.a.m(i10, "setAlertDialogRole ", "DefaultJSCommon");
        this.h = i10;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.video.signal.a.a$a, reason: collision with other inner class name */
    public static class C0070a implements a.InterfaceC0069a {
        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0069a
        public void a(int i10, String str) {
            af.a("DefaultJSCommon", "onH5Error,code:" + i10 + "，msg:" + str);
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0069a
        public void b() {
            af.a("DefaultJSCommon", "videoLocationReady");
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDismissLoading(Campaign campaign) {
            af.a("DefaultJSCommon", "onDismissLoading,campaign:" + campaign);
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadFinish(Campaign campaign) {
            af.a("DefaultJSCommon", "onDownloadFinish,campaign:" + campaign);
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadProgress(int i10) {
            com.mbridge.msdk.dycreator.baseview.a.m(i10, "onDownloadProgress,progress:", "DefaultJSCommon");
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadStart(Campaign campaign) {
            af.a("DefaultJSCommon", "onDownloadStart,campaign:" + campaign);
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onFinishRedirection(Campaign campaign, String str) {
            af.a("DefaultJSCommon", "onFinishRedirection,campaign:" + campaign + ",url:" + str);
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public boolean onInterceptDefaultLoadingDialog() {
            af.a("DefaultJSCommon", "onInterceptDefaultLoadingDialog");
            return false;
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onRedirectionFailed(Campaign campaign, String str) {
            af.a("DefaultJSCommon", "onFinishRedirection,campaign:" + campaign + ",url:" + str);
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onShowLoading(Campaign campaign) {
            af.a("DefaultJSCommon", "onShowLoading,campaign:" + campaign);
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onStartRedirection(Campaign campaign, String str) {
            af.a("DefaultJSCommon", "onStartRedirection,campaign:" + campaign + ",url:" + str);
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0069a
        public void a(boolean z9) {
            af.a("DefaultJSCommon", "onStartInstall");
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0069a
        public void a() {
            af.a("DefaultJSCommon", "onInitSuccess");
        }
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void e(int i10) {
        this.g = i10;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void a(u3.b bVar) {
        this.f6143p = bVar;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void a(t3.a aVar) {
        this.f6144q = aVar;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void a(int i10) {
        this.f6141n = i10;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final int a() {
        return this.g;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void a(boolean z9) {
        af.a("DefaultJSCommon", "setIsShowingTransparent:" + z9);
        this.f6133b = z9;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void a(String str) {
        androidx.constraintlayout.core.widgets.analyzer.a.E("setUnitId:", str, "DefaultJSCommon");
        this.f6137j = str;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void a(a.InterfaceC0069a interfaceC0069a) {
        af.a("DefaultJSCommon", "setTrackingListener:" + interfaceC0069a);
        this.f6140m = interfaceC0069a;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void a(com.mbridge.msdk.videocommon.d.c cVar) {
        af.a("DefaultJSCommon", "setSetting:" + cVar);
        this.f6138k = cVar;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void a(t3.b bVar) {
        this.f6142o = bVar;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void a(Activity activity) {
        af.a("DefaultJSCommon", "setActivity ");
    }
}

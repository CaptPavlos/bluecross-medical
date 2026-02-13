package com.mbridge.msdk.click;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.LoadingActivity;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.scheme.applet.AppletSchemeCallBack;
import com.mbridge.msdk.scheme.applet.AppletsModel;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f2737a = false;

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, Long> f2738b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static Set<String> f2739c = new HashSet();

    /* renamed from: d, reason: collision with root package name */
    private String f2740d;
    private long e;
    private com.mbridge.msdk.foundation.db.g f;
    private Context g;
    private d h;

    /* renamed from: j, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.report.h f2742j;

    /* renamed from: k, reason: collision with root package name */
    private com.mbridge.msdk.c.g f2743k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f2744l;

    /* renamed from: o, reason: collision with root package name */
    private boolean f2747o;

    /* renamed from: p, reason: collision with root package name */
    private i f2748p;

    /* renamed from: i, reason: collision with root package name */
    private NativeListener.NativeTrackingListener f2741i = null;

    /* renamed from: m, reason: collision with root package name */
    private boolean f2745m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f2746n = true;

    public a(Context context, String str) {
        this.f = null;
        this.g = null;
        com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(str);
        this.f2743k = gVarB;
        if (gVarB == null) {
            com.mbridge.msdk.c.h.a();
            this.f2743k = com.mbridge.msdk.c.i.a();
        }
        this.f2744l = this.f2743k.aK();
        Context applicationContext = context.getApplicationContext();
        this.g = applicationContext;
        this.f2740d = str;
        if (this.f == null) {
            this.f = com.mbridge.msdk.foundation.db.g.a(applicationContext);
        }
        this.f2742j = new com.mbridge.msdk.foundation.same.report.h(this.g);
    }

    private boolean b(CampaignEx campaignEx) {
        Long l10;
        if (campaignEx == null) {
            return true;
        }
        try {
            if (2 != campaignEx.getLinkType() && 3 != campaignEx.getLinkType()) {
                return true;
            }
            String id = campaignEx.getId();
            Map<String, Long> map = f2738b;
            if (map == null) {
                return true;
            }
            if (map.containsKey(id) && (l10 = f2738b.get(id)) != null) {
                if (l10.longValue() > System.currentTimeMillis() || f2739c.contains(campaignEx.getId())) {
                    return false;
                }
            }
            f2738b.put(campaignEx.getId(), Long.valueOf(System.currentTimeMillis() + (campaignEx.getClickTimeOutInterval() * 1000)));
            return true;
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return true;
            }
            e.printStackTrace();
            return true;
        }
    }

    public static /* synthetic */ void f(a aVar) {
        try {
            Intent intent = new Intent();
            intent.setAction("ExitApp");
            aVar.g.sendBroadcast(intent);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("CommonClickControl", "Exception", e);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:216:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:230:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.mbridge.msdk.foundation.entity.CampaignEx r19) {
        /*
            Method dump skipped, instructions count: 931
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.entity.CampaignEx):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i10) {
        if (i10 == 1) {
            return "2000136";
        }
        if (i10 == 2) {
            return "2000137";
        }
        if (i10 == 3) {
            return "2000139";
        }
        if (i10 != 4) {
            return "";
        }
        return "2000138";
    }

    private int b() {
        try {
            com.mbridge.msdk.c.g gVar = this.f2743k;
            if (gVar != null) {
                return gVar.Y();
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, boolean z9, boolean z10) {
        if (context == null) {
            return;
        }
        new d(context.getApplicationContext()).a(str, campaignEx, null, str2, z9, z10, com.mbridge.msdk.click.a.a.f);
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String[] strArr, boolean z9, boolean z10) {
        if (context == null || campaignEx == null || TextUtils.isEmpty(str) || strArr == null) {
            return;
        }
        d dVar = new d(context.getApplicationContext());
        for (String str2 : strArr) {
            dVar.a(str, campaignEx, new f() { // from class: com.mbridge.msdk.click.a.2
                @Override // com.mbridge.msdk.click.f
                public final void a(Object obj, String str3) {
                }

                @Override // com.mbridge.msdk.click.f
                public final void a(Object obj) {
                }

                @Override // com.mbridge.msdk.click.f
                public final void b(Object obj) {
                }
            }, str2, z9, z10, com.mbridge.msdk.click.a.a.f);
        }
    }

    public final void a(String str) {
        this.f2740d = str;
    }

    public final void a(NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.f2741i = nativeTrackingListener;
    }

    public final void a(i iVar) {
        this.f2748p = iVar;
    }

    public final void a(boolean z9) {
        this.f2746n = z9;
    }

    public final void a() {
        try {
            this.f2741i = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(CampaignEx campaignEx, NativeListener.NativeAdListener nativeAdListener) {
        if (nativeAdListener != null && campaignEx != null) {
            nativeAdListener.onAdClick(campaignEx);
        }
        a(campaignEx);
    }

    private AppletSchemeCallBack a(NativeListener.NativeTrackingListener nativeTrackingListener, CampaignEx campaignEx, AppletsModel appletsModel, a aVar) {
        return new g(nativeTrackingListener, campaignEx, appletsModel, aVar);
    }

    private void a(Context context, CampaignEx campaignEx, List<String> list) {
        if (context == null) {
            com.mbridge.msdk.foundation.same.report.i.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, 2, "context is null", this.f2740d);
            return;
        }
        boolean z9 = ab.z() == 1;
        boolean z10 = ab.v(context) == 1;
        if (z9 && z10) {
            String ghId = campaignEx.getGhId();
            String ghPath = campaignEx.getGhPath();
            String bindId = campaignEx.getBindId();
            String strH = com.mbridge.msdk.foundation.controller.c.m().h();
            if (!TextUtils.isEmpty(ghId)) {
                try {
                    if (!TextUtils.isEmpty(strH)) {
                        bindId = strH;
                    }
                    Object objB = ab.b(bindId);
                    Class<?> cls = Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
                    Object objNewInstance = cls.newInstance();
                    cls.getField("userName").set(objNewInstance, ghId);
                    cls.getField(MBridgeConstans.DYNAMIC_VIEW_WX_PATH).set(objNewInstance, ghPath);
                    cls.getField("miniprogramType").set(objNewInstance, cls.getField("MINIPTOGRAM_TYPE_RELEASE").get(null));
                    Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI").getMethod("sendReq", Class.forName("com.tencent.mm.opensdk.modelbase.BaseReq")).invoke(objB, objNewInstance);
                    com.mbridge.msdk.foundation.same.report.i.a(context, campaignEx, 1, "", this.f2740d);
                    return;
                } catch (Throwable th) {
                    com.mbridge.msdk.foundation.same.report.i.a(context, campaignEx, 2, th.getMessage(), this.f2740d);
                    a(campaignEx, list);
                    return;
                }
            }
            a(campaignEx, list);
            com.mbridge.msdk.foundation.same.report.i.a(context, campaignEx, 2, "ghid is empty", this.f2740d);
            return;
        }
        com.mbridge.msdk.foundation.same.report.i.a(context, campaignEx, 2, "integrated:" + z9 + "-hasWx:" + z10, this.f2740d);
        a(campaignEx, list);
    }

    private void a(CampaignEx campaignEx, List<String> list) {
        int iB = b();
        Context context = this.g;
        if (iB == 2) {
            aj.a(context, campaignEx.getClickURL(), campaignEx, this.f2741i, list);
        } else {
            aj.a(context, campaignEx.getClickURL(), this.f2741i, campaignEx, list);
        }
    }

    private void a(final CampaignEx campaignEx, final boolean z9, final Boolean bool, final List<String> list) {
        final boolean z10;
        final boolean z11;
        try {
            this.e = System.currentTimeMillis();
            NativeListener.NativeTrackingListener nativeTrackingListener = this.f2741i;
            if (nativeTrackingListener == null || z9) {
                z10 = true;
            } else {
                nativeTrackingListener.onStartRedirection(campaignEx, campaignEx.getClickURL());
                z10 = !this.f2741i.onInterceptDefaultLoadingDialog();
            }
            this.f2747o = false;
            boolean z12 = true;
            if (campaignEx.getJumpResult() != null) {
                if (!z9) {
                    a(campaignEx, campaignEx.getJumpResult(), true, this.f2745m, bool, list);
                }
                this.f2747o = true;
                this.f2745m = false;
                z12 = false;
            }
            if (!com.mbridge.msdk.foundation.db.d.a(this.f).a(campaignEx.getId(), this.f2740d) || campaignEx.getJumpResult() == null) {
                com.mbridge.msdk.foundation.db.d dVarA = com.mbridge.msdk.foundation.db.d.a(this.f);
                dVarA.a();
                JumpLoaderResult jumpLoaderResultB = dVarA.b(campaignEx.getId(), this.f2740d);
                if (jumpLoaderResultB != null && !z9) {
                    campaignEx.setJumpResult(jumpLoaderResultB);
                    if (z12) {
                        a(campaignEx, jumpLoaderResultB, z12, this.f2745m, bool, list);
                        this.f2747o = true;
                        this.f2745m = false;
                        z11 = false;
                    }
                    z11 = z12;
                } else {
                    if (campaignEx.getClick_mode().equals("6") && !campaignEx.getPackageName().isEmpty() && campaignEx.getLinkType() == 2 && !z9) {
                        boolean zA = aj.a.a(this.g, "market://details?id=" + campaignEx.getPackageName(), this.f2741i);
                        if (list != null) {
                            list.add("google_play");
                        }
                        if (zA) {
                            a(campaignEx, 1, 1, list);
                        }
                        NativeListener.NativeTrackingListener nativeTrackingListener2 = this.f2741i;
                        if (nativeTrackingListener2 != null && z12) {
                            nativeTrackingListener2.onDismissLoading(campaignEx);
                            this.f2741i.onFinishRedirection(campaignEx, null);
                        }
                        this.f2747o = true;
                        z12 = false;
                    }
                    if (z9) {
                        this.f2747o = true;
                        this.f2745m = false;
                        z11 = false;
                    }
                    z11 = z12;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.mbridge.msdk.click.a.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (z10 && !a.f2737a && !a.this.f2747o && MBridgeConstans.NATIVE_SHOW_LOADINGPAGER && !z9) {
                            a.a(a.this, campaignEx);
                        }
                        if (z10 || a.this.f2741i == null || a.f2737a || a.this.f2747o || !MBridgeConstans.NATIVE_SHOW_LOADINGPAGER) {
                            return;
                        }
                        a.this.f2741i.onShowLoading(campaignEx);
                    }
                });
                d dVar = this.h;
                if (dVar != null) {
                    dVar.a();
                }
                Set<String> set = f2739c;
                if (set != null && set.contains(campaignEx.getId())) {
                    NativeListener.NativeTrackingListener nativeTrackingListener3 = this.f2741i;
                    if (nativeTrackingListener3 != null) {
                        nativeTrackingListener3.onDismissLoading(campaignEx);
                        this.f2741i.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                        return;
                    }
                    return;
                }
                Set<String> set2 = f2739c;
                if (set2 != null) {
                    set2.add(campaignEx.getId());
                }
                d dVar2 = new d(this.g);
                this.h = dVar2;
                final boolean z13 = z10;
                dVar2.a(this.f2740d, campaignEx, new f() { // from class: com.mbridge.msdk.click.a.4
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:24:0x0052 A[Catch: all -> 0x0063, TryCatch #0 {all -> 0x0063, blocks: (B:22:0x004e, B:24:0x0052, B:26:0x005c, B:30:0x0066, B:32:0x007d, B:33:0x008a), top: B:39:0x004e }] */
                    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
                    /* JADX WARN: Removed duplicated region for block: B:32:0x007d A[Catch: all -> 0x0063, TryCatch #0 {all -> 0x0063, blocks: (B:22:0x004e, B:24:0x0052, B:26:0x005c, B:30:0x0066, B:32:0x007d, B:33:0x008a), top: B:39:0x004e }] */
                    /* JADX WARN: Type inference failed for: r6v10, types: [int] */
                    /* JADX WARN: Type inference failed for: r6v21 */
                    /* JADX WARN: Type inference failed for: r6v9 */
                    @Override // com.mbridge.msdk.click.f
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final void a(java.lang.Object r6, java.lang.String r7) {
                        /*
                            r5 = this;
                            java.util.Set<java.lang.String> r0 = com.mbridge.msdk.click.a.f2739c
                            if (r0 == 0) goto Ld
                            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r2
                            java.lang.String r1 = r1.getId()
                            r0.remove(r1)
                        Ld:
                            java.lang.String r0 = "CommonClickControl"
                            r1 = 0
                            if (r6 == 0) goto L2a
                            boolean r2 = r6 instanceof com.mbridge.msdk.click.entity.JumpLoaderResult     // Catch: java.lang.Throwable -> L28
                            if (r2 == 0) goto L2a
                            r2 = r6
                            com.mbridge.msdk.click.entity.JumpLoaderResult r2 = (com.mbridge.msdk.click.entity.JumpLoaderResult) r2     // Catch: java.lang.Throwable -> L28
                            com.mbridge.msdk.click.a r1 = com.mbridge.msdk.click.a.this     // Catch: java.lang.Throwable -> L25
                            com.mbridge.msdk.click.entity.JumpLoaderResult r6 = (com.mbridge.msdk.click.entity.JumpLoaderResult) r6     // Catch: java.lang.Throwable -> L25
                            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r2     // Catch: java.lang.Throwable -> L25
                            r4 = 1
                            com.mbridge.msdk.click.a.a(r1, r6, r3, r4)     // Catch: java.lang.Throwable -> L25
                            r1 = r2
                            goto L2a
                        L25:
                            r6 = move-exception
                            r1 = r2
                            goto L47
                        L28:
                            r6 = move-exception
                            goto L47
                        L2a:
                            com.mbridge.msdk.click.a r6 = com.mbridge.msdk.click.a.this     // Catch: java.lang.Throwable -> L28
                            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r6 = com.mbridge.msdk.click.a.b(r6)     // Catch: java.lang.Throwable -> L28
                            if (r6 == 0) goto L3d
                            com.mbridge.msdk.click.a r6 = com.mbridge.msdk.click.a.this     // Catch: java.lang.Throwable -> L28
                            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r6 = com.mbridge.msdk.click.a.b(r6)     // Catch: java.lang.Throwable -> L28
                            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2     // Catch: java.lang.Throwable -> L28
                            r6.onRedirectionFailed(r2, r7)     // Catch: java.lang.Throwable -> L28
                        L3d:
                            com.mbridge.msdk.click.a r6 = com.mbridge.msdk.click.a.this     // Catch: java.lang.Throwable -> L28
                            boolean r7 = r6     // Catch: java.lang.Throwable -> L28
                            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2     // Catch: java.lang.Throwable -> L28
                            com.mbridge.msdk.click.a.a(r6, r7, r2)     // Catch: java.lang.Throwable -> L28
                            goto L4e
                        L47:
                            java.lang.String r6 = r6.getMessage()
                            com.mbridge.msdk.foundation.tools.af.b(r0, r6)
                        L4e:
                            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r2     // Catch: java.lang.Throwable -> L63
                            if (r6 == 0) goto L65
                            java.lang.String r6 = r6.getClickURL()     // Catch: java.lang.Throwable -> L63
                            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L63
                            if (r7 != 0) goto L65
                            java.lang.String r7 = "tcp"
                            boolean r6 = r6.startsWith(r7)     // Catch: java.lang.Throwable -> L63
                            goto L66
                        L63:
                            r6 = move-exception
                            goto L96
                        L65:
                            r6 = -1
                        L66:
                            com.mbridge.msdk.foundation.same.report.d.e r7 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch: java.lang.Throwable -> L63
                            r7.<init>()     // Catch: java.lang.Throwable -> L63
                            java.lang.String r2 = "result"
                            java.lang.String r3 = "2"
                            r7.a(r2, r3)     // Catch: java.lang.Throwable -> L63
                            java.lang.String r2 = "net_ty"
                            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L63
                            r7.a(r2, r6)     // Catch: java.lang.Throwable -> L63
                            if (r1 == 0) goto L8a
                            java.lang.String r6 = "status_code"
                            int r1 = r1.getStatusCode()     // Catch: java.lang.Throwable -> L63
                            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L63
                            r7.a(r6, r1)     // Catch: java.lang.Throwable -> L63
                        L8a:
                            com.mbridge.msdk.foundation.same.report.d.d r6 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch: java.lang.Throwable -> L63
                            java.lang.String r1 = "2000138"
                            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2     // Catch: java.lang.Throwable -> L63
                            r6.a(r1, r2, r7)     // Catch: java.lang.Throwable -> L63
                            goto La1
                        L96:
                            boolean r7 = com.mbridge.msdk.MBridgeConstans.DEBUG
                            if (r7 == 0) goto La1
                            java.lang.String r6 = r6.getMessage()
                            com.mbridge.msdk.foundation.tools.af.b(r0, r6)
                        La1:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.a.AnonymousClass4.a(java.lang.Object, java.lang.String):void");
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:22:0x0067 A[Catch: all -> 0x0078, TryCatch #0 {all -> 0x0078, blocks: (B:20:0x0063, B:22:0x0067, B:24:0x0071, B:28:0x007c, B:30:0x008a, B:31:0x0097), top: B:37:0x0063 }] */
                    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
                    /* JADX WARN: Removed duplicated region for block: B:30:0x008a A[Catch: all -> 0x0078, TryCatch #0 {all -> 0x0078, blocks: (B:20:0x0063, B:22:0x0067, B:24:0x0071, B:28:0x007c, B:30:0x008a, B:31:0x0097), top: B:37:0x0063 }] */
                    /* JADX WARN: Type inference failed for: r11v14 */
                    /* JADX WARN: Type inference failed for: r11v15, types: [int] */
                    /* JADX WARN: Type inference failed for: r11v20 */
                    @Override // com.mbridge.msdk.click.f
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final void b(java.lang.Object r11) {
                        /*
                            r10 = this;
                            java.util.Set<java.lang.String> r0 = com.mbridge.msdk.click.a.f2739c
                            if (r0 == 0) goto Ld
                            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r2
                            java.lang.String r1 = r1.getId()
                            r0.remove(r1)
                        Ld:
                            java.lang.String r1 = "CommonClickControl"
                            r2 = 0
                            if (r11 == 0) goto L63
                            boolean r0 = r11 instanceof com.mbridge.msdk.click.entity.JumpLoaderResult     // Catch: java.lang.Throwable -> L5a
                            if (r0 == 0) goto L63
                            r5 = r11
                            com.mbridge.msdk.click.entity.JumpLoaderResult r5 = (com.mbridge.msdk.click.entity.JumpLoaderResult) r5     // Catch: java.lang.Throwable -> L5a
                            com.mbridge.msdk.foundation.entity.CampaignEx r11 = r2     // Catch: java.lang.Throwable -> L4b
                            r11.setJumpResult(r5)     // Catch: java.lang.Throwable -> L4b
                            com.mbridge.msdk.click.a r3 = com.mbridge.msdk.click.a.this     // Catch: java.lang.Throwable -> L4b
                            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r2     // Catch: java.lang.Throwable -> L4b
                            boolean r6 = r3     // Catch: java.lang.Throwable -> L4b
                            boolean r7 = com.mbridge.msdk.click.a.c(r3)     // Catch: java.lang.Throwable -> L4b
                            java.lang.Boolean r8 = r4     // Catch: java.lang.Throwable -> L4b
                            java.util.List r9 = r5     // Catch: java.lang.Throwable -> L4b
                            com.mbridge.msdk.click.a.a(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L4b
                            boolean r11 = r5.isjumpDone()     // Catch: java.lang.Throwable -> L4b
                            if (r11 == 0) goto L4f
                            com.mbridge.msdk.click.a r11 = com.mbridge.msdk.click.a.this     // Catch: java.lang.Throwable -> L4b
                            com.mbridge.msdk.foundation.db.g r11 = com.mbridge.msdk.click.a.d(r11)     // Catch: java.lang.Throwable -> L4b
                            com.mbridge.msdk.foundation.db.d r11 = com.mbridge.msdk.foundation.db.d.a(r11)     // Catch: java.lang.Throwable -> L4b
                            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r2     // Catch: java.lang.Throwable -> L4b
                            com.mbridge.msdk.click.a r2 = com.mbridge.msdk.click.a.this     // Catch: java.lang.Throwable -> L4b
                            java.lang.String r2 = com.mbridge.msdk.click.a.e(r2)     // Catch: java.lang.Throwable -> L4b
                            r11.a(r0, r2)     // Catch: java.lang.Throwable -> L4b
                            goto L4f
                        L4b:
                            r0 = move-exception
                            r11 = r0
                            r2 = r5
                            goto L5c
                        L4f:
                            com.mbridge.msdk.click.a r11 = com.mbridge.msdk.click.a.this     // Catch: java.lang.Throwable -> L4b
                            boolean r0 = r6     // Catch: java.lang.Throwable -> L4b
                            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2     // Catch: java.lang.Throwable -> L4b
                            com.mbridge.msdk.click.a.a(r11, r0, r2)     // Catch: java.lang.Throwable -> L4b
                            r2 = r5
                            goto L63
                        L5a:
                            r0 = move-exception
                            r11 = r0
                        L5c:
                            java.lang.String r11 = r11.getMessage()
                            com.mbridge.msdk.foundation.tools.af.b(r1, r11)
                        L63:
                            com.mbridge.msdk.foundation.entity.CampaignEx r11 = r2     // Catch: java.lang.Throwable -> L78
                            if (r11 == 0) goto L7b
                            java.lang.String r11 = r11.getClickURL()     // Catch: java.lang.Throwable -> L78
                            boolean r0 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L78
                            if (r0 != 0) goto L7b
                            java.lang.String r0 = "tcp"
                            boolean r11 = r11.startsWith(r0)     // Catch: java.lang.Throwable -> L78
                            goto L7c
                        L78:
                            r0 = move-exception
                            r11 = r0
                            goto Lac
                        L7b:
                            r11 = -1
                        L7c:
                            com.mbridge.msdk.foundation.same.report.d.e r0 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch: java.lang.Throwable -> L78
                            r0.<init>()     // Catch: java.lang.Throwable -> L78
                            java.lang.String r3 = "result"
                            java.lang.String r4 = "1"
                            r0.a(r3, r4)     // Catch: java.lang.Throwable -> L78
                            if (r2 == 0) goto L97
                            java.lang.String r3 = "status_code"
                            int r2 = r2.getStatusCode()     // Catch: java.lang.Throwable -> L78
                            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L78
                            r0.a(r3, r2)     // Catch: java.lang.Throwable -> L78
                        L97:
                            java.lang.String r2 = "net_ty"
                            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch: java.lang.Throwable -> L78
                            r0.a(r2, r11)     // Catch: java.lang.Throwable -> L78
                            com.mbridge.msdk.foundation.same.report.d.d r11 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch: java.lang.Throwable -> L78
                            java.lang.String r2 = "2000138"
                            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r2     // Catch: java.lang.Throwable -> L78
                            r11.a(r2, r3, r0)     // Catch: java.lang.Throwable -> L78
                            goto Lb7
                        Lac:
                            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
                            if (r0 == 0) goto Lb7
                            java.lang.String r11 = r11.getMessage()
                            com.mbridge.msdk.foundation.tools.af.b(r1, r11)
                        Lb7:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.a.AnonymousClass4.b(java.lang.Object):void");
                    }

                    @Override // com.mbridge.msdk.click.f
                    public final void a(Object obj) {
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(JumpLoaderResult jumpLoaderResult, CampaignEx campaignEx, int i10, boolean z9) {
        if (campaignEx == null || jumpLoaderResult == null) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.e;
            com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e();
            int iM = ab.m(this.g);
            eVar.a(iM);
            eVar.c(ab.a(this.g, iM));
            eVar.b(campaignEx.getRequestId());
            eVar.k(campaignEx.getRequestIdNotice());
            eVar.b(i10);
            eVar.i(jCurrentTimeMillis + "");
            eVar.j(campaignEx.getId());
            eVar.c(jumpLoaderResult.getType());
            if (!TextUtils.isEmpty(jumpLoaderResult.getUrl())) {
                eVar.h(URLEncoder.encode(jumpLoaderResult.getUrl(), "utf-8"));
            }
            eVar.e((this.e / 1000) + "");
            eVar.d(Integer.parseInt(campaignEx.getLandingType()));
            eVar.e(campaignEx.getLinkType());
            eVar.a(this.f2740d);
            eVar.c(jumpLoaderResult.getType());
            if (!TextUtils.isEmpty(jumpLoaderResult.getUrl())) {
                eVar.h(URLEncoder.encode(jumpLoaderResult.getUrl(), "utf-8"));
            }
            if (this.f2744l) {
                eVar.f(jumpLoaderResult.getStatusCode());
                if (!TextUtils.isEmpty(jumpLoaderResult.getHeader())) {
                    eVar.f(URLEncoder.encode(jumpLoaderResult.getHeader(), "utf-8"));
                }
                if (!TextUtils.isEmpty(jumpLoaderResult.getContent())) {
                    eVar.g(URLEncoder.encode(jumpLoaderResult.getContent(), C.UTF8_NAME));
                }
                if (!TextUtils.isEmpty(jumpLoaderResult.getExceptionMsg())) {
                    eVar.d(URLEncoder.encode(jumpLoaderResult.getExceptionMsg(), "utf-8"));
                }
            }
            if (z9) {
                JSONObject jSONObjectA = com.mbridge.msdk.foundation.entity.e.a(eVar);
                if (jSONObjectA != null) {
                    com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObjectA);
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(eVar);
            ArrayList<JSONObject> arrayListA = com.mbridge.msdk.foundation.entity.e.a(arrayList);
            if (arrayListA == null || arrayListA.isEmpty()) {
                return;
            }
            int size = arrayListA.size();
            int i11 = 0;
            while (i11 < size) {
                JSONObject jSONObject = arrayListA.get(i11);
                i11++;
                com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
            }
        } catch (Throwable th) {
            af.b("CommonClickControl", th.getMessage());
        }
    }

    public final void a(Campaign campaign, String str) {
        try {
            if (!TextUtils.isEmpty(str) && campaign != null) {
                CampaignEx campaignEx = campaign instanceof CampaignEx ? (CampaignEx) campaign : null;
                if (!str.startsWith("market://") && !str.startsWith("https://play.google.com/")) {
                    return;
                }
                if (aj.a.a(this.g, str, this.f2741i) || campaignEx == null) {
                    return;
                }
                if (!TextUtils.isEmpty(campaignEx.getPackageName())) {
                    aj.a.a(this.g, "market://details?id=" + campaignEx.getPackageName(), this.f2741i);
                    return;
                }
                int iB = b();
                Context context = this.g;
                if (iB == 2) {
                    aj.a(context, campaignEx.getClickURL(), campaignEx, this.f2741i, new ArrayList());
                } else {
                    aj.a(context, campaignEx.getClickURL(), this.f2741i, campaignEx, new ArrayList());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JumpLoaderResult jumpLoaderResult, CampaignEx campaignEx, boolean z9) {
        a(jumpLoaderResult, campaignEx, 1, z9);
    }

    private void a(int i10, String str, CampaignEx campaignEx, NativeListener.NativeTrackingListener nativeTrackingListener, List<String> list) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Context context = this.g;
            if (i10 == 2) {
                aj.a(context, str, campaignEx, nativeTrackingListener, list);
            } else {
                aj.a(context, str, nativeTrackingListener, campaignEx, list);
            }
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                af.b("CommonClickControl", th.getMessage(), th);
            }
        }
    }

    private boolean a(CampaignEx campaignEx, JumpLoaderResult jumpLoaderResult, boolean z9, int i10, List<String> list) {
        boolean z10 = true;
        boolean z11 = false;
        if (z9) {
            try {
                int i11 = Integer.parseInt(campaignEx.getLandingType());
                if (i11 == 1) {
                    aj.a(this.g, jumpLoaderResult.getUrl(), this.f2741i, campaignEx, list);
                } else if (i11 == 2) {
                    aj.a(this.g, jumpLoaderResult.getUrl(), campaignEx, this.f2741i, list);
                } else if (campaignEx.getPackageName() != null) {
                    if (aj.a.a(this.g, "market://details?id=" + campaignEx.getPackageName(), this.f2741i)) {
                        if (list != null) {
                            try {
                                list.add("google_play");
                            } catch (Throwable th) {
                                th = th;
                                if (MBridgeConstans.DEBUG) {
                                    af.b("CommonClickControl", th.getMessage(), th);
                                }
                                return z10;
                            }
                        }
                        a(campaignEx, 1, 1, list);
                    } else {
                        a(i10, jumpLoaderResult.getUrl(), campaignEx, this.f2741i, list);
                    }
                } else {
                    a(i10, jumpLoaderResult.getUrl(), campaignEx, this.f2741i, list);
                }
                z11 = true;
            } catch (Throwable th2) {
                th = th2;
                z10 = false;
            }
        }
        if (z11) {
            a(jumpLoaderResult, campaignEx, true);
            NativeListener.NativeTrackingListener nativeTrackingListener = this.f2741i;
            if (nativeTrackingListener != null) {
                nativeTrackingListener.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                return z11;
            }
        } else {
            a(jumpLoaderResult, campaignEx, true);
            NativeListener.NativeTrackingListener nativeTrackingListener2 = this.f2741i;
            if (nativeTrackingListener2 != null && z9) {
                nativeTrackingListener2.onRedirectionFailed(campaignEx, jumpLoaderResult.getUrl());
            }
        }
        return z11;
    }

    private boolean a(CampaignEx campaignEx, JumpLoaderResult jumpLoaderResult, boolean z9, List<String> list) {
        boolean z10 = false;
        if (z9) {
            try {
                if (com.mbridge.msdk.e.b.a()) {
                    b.a(this.g, this.f2740d, campaignEx, campaignEx.getNoticeUrl(), com.mbridge.msdk.foundation.same.a.M);
                }
                aj.a(this.g, campaignEx.getClickURL(), this.f2741i, campaignEx, list);
                z10 = true;
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    af.b("CommonClickControl", th.getMessage(), th);
                }
                return false;
            }
        }
        a(jumpLoaderResult, campaignEx, true);
        if (z10) {
            NativeListener.NativeTrackingListener nativeTrackingListener = this.f2741i;
            if (nativeTrackingListener != null) {
                nativeTrackingListener.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                return z10;
            }
        } else {
            if (com.mbridge.msdk.e.b.a()) {
                a(jumpLoaderResult, campaignEx, true);
            }
            NativeListener.NativeTrackingListener nativeTrackingListener2 = this.f2741i;
            if (nativeTrackingListener2 != null) {
                nativeTrackingListener2.onRedirectionFailed(campaignEx, jumpLoaderResult.getUrl());
            }
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c1 A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:3:0x0002, B:10:0x000f, B:12:0x0019, B:17:0x0023, B:20:0x0031, B:22:0x0037, B:26:0x0047, B:28:0x004b, B:30:0x005d, B:34:0x0068, B:36:0x0072, B:38:0x007c, B:41:0x008c, B:49:0x00c1, B:50:0x00cd, B:53:0x00d3, B:74:0x0131, B:76:0x013f, B:78:0x0147, B:82:0x014f, B:77:0x0144, B:45:0x009d, B:47:0x00a7, B:56:0x00df, B:57:0x00ec, B:60:0x00f2, B:63:0x00fd, B:65:0x0103, B:67:0x0107, B:69:0x010d, B:71:0x011a, B:73:0x012a, B:85:0x0159, B:87:0x0160), top: B:91:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.mbridge.msdk.foundation.entity.CampaignEx r10, com.mbridge.msdk.click.entity.JumpLoaderResult r11, boolean r12, boolean r13, java.lang.Boolean r14, java.util.List<java.lang.String> r15) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.entity.CampaignEx, com.mbridge.msdk.click.entity.JumpLoaderResult, boolean, boolean, java.lang.Boolean, java.util.List):void");
    }

    private boolean a(int i10, String str) {
        try {
            if (i10 == 2) {
                if (aj.a.b(str)) {
                    return true;
                }
            } else if (!TextUtils.isEmpty(str)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void a(CampaignEx campaignEx, int i10, int i11, List<String> list) {
        try {
            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
            eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(i10));
            eVar.a("result", Integer.valueOf(i11));
            if (list != null) {
                eVar.a("click_path", list.toString());
            }
            com.mbridge.msdk.foundation.same.report.d.d.a().a("2000150", campaignEx, eVar);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("CommonClickControl", e.getMessage());
            }
        }
    }

    public static void a(Context context, final CampaignEx campaignEx, String str, final String str2, boolean z9, boolean z10, final int i10) {
        if (context == null) {
            return;
        }
        if (campaignEx != null) {
            try {
                String strB = b(i10);
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a("result", 3);
                com.mbridge.msdk.foundation.same.report.d.d.a().a(strB, campaignEx, eVar);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        final int i11 = TextUtils.isEmpty(str2) ? -1 : str2.startsWith("tcp") ? 1 : 0;
        new d(context.getApplicationContext()).a(str, campaignEx, new f() { // from class: com.mbridge.msdk.click.a.1
            @Override // com.mbridge.msdk.click.f
            public final void a(Object obj, String str3) {
                try {
                    String strB2 = a.b(i10);
                    com.mbridge.msdk.foundation.same.report.d.e eVar2 = new com.mbridge.msdk.foundation.same.report.d.e();
                    eVar2.a("result", 2);
                    if (obj instanceof JumpLoaderResult) {
                        JumpLoaderResult jumpLoaderResult = (JumpLoaderResult) obj;
                        String exceptionMsg = jumpLoaderResult.getExceptionMsg();
                        if (!TextUtils.isEmpty(exceptionMsg)) {
                            str3 = exceptionMsg;
                        }
                        eVar2.a("reason", str3);
                        eVar2.a("status_code", Integer.valueOf(jumpLoaderResult.getStatusCode()));
                    }
                    eVar2.a("code", "");
                    eVar2.a("failingURL", aq.d(str2));
                    eVar2.a("net_ty", String.valueOf(i11));
                    if (campaignEx != null) {
                        com.mbridge.msdk.foundation.same.report.d.d.a().a(strB2, campaignEx, eVar2);
                    }
                } catch (Exception e3) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("CommonClickControl", e3.getMessage());
                    }
                }
            }

            @Override // com.mbridge.msdk.click.f
            public final void b(Object obj) {
                try {
                    com.mbridge.msdk.foundation.same.report.d.e eVar2 = new com.mbridge.msdk.foundation.same.report.d.e();
                    eVar2.a("result", 2);
                    eVar2.a("net_ty", String.valueOf(i11));
                    if (obj != null && (obj instanceof JumpLoaderResult)) {
                        JumpLoaderResult jumpLoaderResult = (JumpLoaderResult) obj;
                        String str3 = jumpLoaderResult.getStatusCode() + "";
                        eVar2.a("status_code", str3);
                        if (str3.startsWith("2")) {
                            eVar2.a("result", 1);
                        } else {
                            String exceptionMsg = jumpLoaderResult.getExceptionMsg();
                            if (TextUtils.isEmpty(exceptionMsg)) {
                                exceptionMsg = "UNKNOWN EXCEPTION and Status Code is : ".concat(str3);
                            }
                            eVar2.a("failingURL", aq.d(str2));
                            eVar2.a("reason", exceptionMsg);
                        }
                    }
                    String strB2 = a.b(i10);
                    if (campaignEx != null) {
                        com.mbridge.msdk.foundation.same.report.d.d.a().a(strB2, campaignEx, eVar2);
                    }
                } catch (Exception e3) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("CommonClickControl", e3.getMessage());
                    }
                }
            }

            @Override // com.mbridge.msdk.click.f
            public final void a(Object obj) {
            }
        }, str2, z9, z10, i10);
    }

    public static /* synthetic */ void a(a aVar, CampaignEx campaignEx) {
        try {
            Intent intent = new Intent(aVar.g, (Class<?>) LoadingActivity.class);
            intent.setFlags(268435456);
            intent.putExtra(CampaignEx.JSON_KEY_ICON_URL, campaignEx.getIconUrl());
            aVar.g.startActivity(intent);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("CommonClickControl", "Exception", e);
            }
        }
    }

    public static /* synthetic */ void a(a aVar, final boolean z9, final Campaign campaign) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.mbridge.msdk.click.a.5
            @Override // java.lang.Runnable
            public final void run() {
                if (z9 && !a.f2737a && MBridgeConstans.NATIVE_SHOW_LOADINGPAGER) {
                    a.f(a.this);
                }
                if (a.this.f2741i == null || a.f2737a || !MBridgeConstans.NATIVE_SHOW_LOADINGPAGER) {
                    return;
                }
                a.this.f2741i.onDismissLoading(campaign);
            }
        });
    }
}

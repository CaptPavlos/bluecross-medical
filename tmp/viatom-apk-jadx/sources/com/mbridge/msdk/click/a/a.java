package com.mbridge.msdk.click.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.f;
import com.mbridge.msdk.foundation.tools.aq;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import org.json.JSONException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f2764a = "mtg_retry_report=1";

    /* renamed from: b, reason: collision with root package name */
    public static int f2765b = 10000;

    /* renamed from: c, reason: collision with root package name */
    public static int f2766c = 3;

    /* renamed from: d, reason: collision with root package name */
    public static int f2767d = 50;
    public static int e = 600000;
    public static int f = 0;
    public static int g = 1;
    public static int h = 2;

    /* renamed from: i, reason: collision with root package name */
    public static int f2768i = 3;

    /* renamed from: j, reason: collision with root package name */
    public static int f2769j = 4;

    /* renamed from: k, reason: collision with root package name */
    public static int f2770k = 5;

    /* renamed from: l, reason: collision with root package name */
    private static String f2771l = "RetryReportControl";

    /* renamed from: o, reason: collision with root package name */
    private static int f2772o;

    /* renamed from: p, reason: collision with root package name */
    private static int f2773p;

    /* renamed from: m, reason: collision with root package name */
    private ConcurrentHashMap<String, com.mbridge.msdk.click.a.b> f2774m;

    /* renamed from: n, reason: collision with root package name */
    private c f2775n;

    /* renamed from: q, reason: collision with root package name */
    private BroadcastReceiver f2776q;

    /* renamed from: r, reason: collision with root package name */
    private final Handler f2777r;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.click.a.a$a, reason: collision with other inner class name */
    public static class C0020a {

        /* renamed from: a, reason: collision with root package name */
        private static a f2779a = new a();
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 != 2) {
                    return;
                }
                a.a(a.a());
            } else {
                Object obj = message.obj;
                if (obj instanceof String) {
                    a.a().a((String) obj, com.mbridge.msdk.click.a.b.f2780a);
                }
            }
        }
    }

    private a() {
        this.f2774m = new ConcurrentHashMap<>();
        this.f2775n = new c(f2767d);
        this.f2777r = new b(Looper.getMainLooper());
        g gVarA = h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
        f2766c = gVarA.ag();
        f2765b = gVarA.ai() * 1000;
        e = gVarA.aj() * 1000;
        f2772o = gVarA.af();
        f2773p = gVarA.ah();
        try {
            if (this.f2776q == null) {
                this.f2776q = new BroadcastReceiver() { // from class: com.mbridge.msdk.click.a.a.1
                    @Override // android.content.BroadcastReceiver
                    public final void onReceive(Context context, Intent intent) {
                        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                            a.this.f2777r.sendEmptyMessage(2);
                        }
                    }
                };
                Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                if (contextC != null) {
                    contextC.registerReceiver(this.f2776q, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private boolean b(int i10) {
        return i10 == g || i10 == h;
    }

    public final void a(String str, String str2, CampaignEx campaignEx, String str3, boolean z9, boolean z10, int i10) {
        if ((a(i10) || b(i10) || i10 == f2770k) && !TextUtils.isEmpty(str)) {
            String strReplace = str.replace("?" + f2764a, "").replace("&" + f2764a, "");
            if (this.f2774m == null) {
                this.f2774m = new ConcurrentHashMap<>();
            }
            com.mbridge.msdk.click.a.b bVarRemove = this.f2774m.remove(strReplace);
            if (bVarRemove == null) {
                bVarRemove = new com.mbridge.msdk.click.a.b(str, str2);
                bVarRemove.b(i10);
                bVarRemove.a(z9);
                bVarRemove.b(z10);
                bVarRemove.a(campaignEx);
                bVarRemove.a(str3);
            } else if (bVarRemove.c() != com.mbridge.msdk.click.a.b.f2781b) {
                bVarRemove.b(str2);
            }
            if ((!a(i10) || f2772o == 0) && ((!b(i10) || f2773p == 0) && i10 != f2770k)) {
                a(bVarRemove);
                return;
            }
            if (System.currentTimeMillis() >= bVarRemove.j() + e) {
                if (bVarRemove.c() == com.mbridge.msdk.click.a.b.f2780a) {
                    a(bVarRemove);
                    return;
                }
                return;
            }
            if (this.f2775n == null) {
                this.f2775n = new c(f2767d);
            }
            this.f2775n.a(strReplace, bVarRemove);
            if (bVarRemove.c() == com.mbridge.msdk.click.a.b.f2780a) {
                if (bVarRemove.h() <= f2766c) {
                    a(strReplace);
                } else {
                    a(bVarRemove);
                }
            }
        }
    }

    public static a a() {
        return C0020a.f2779a;
    }

    private void a(com.mbridge.msdk.click.a.b bVar) {
        String str;
        String requestIdNotice;
        try {
            CampaignEx campaignExF = bVar.f();
            if (campaignExF != null) {
                String requestId = campaignExF.getRequestId();
                requestIdNotice = campaignExF.getRequestIdNotice();
                str = requestId;
            } else {
                str = "";
                requestIdNotice = str;
            }
            a(com.mbridge.msdk.foundation.controller.c.m().c(), bVar.i().toString(), bVar.g(), str, requestIdNotice, bVar.d());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private static void a(Context context, String str, String str2, String str3, String str4, int i10) throws JSONException {
        f.a().a(context, str, str2, str3, str4, i10);
    }

    private void a(String str) {
        Message messageObtainMessage = this.f2777r.obtainMessage();
        messageObtainMessage.what = 1;
        messageObtainMessage.obj = str;
        this.f2777r.sendMessageDelayed(messageObtainMessage, f2765b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i10) {
        String string;
        c cVar = this.f2775n;
        if (cVar != null) {
            com.mbridge.msdk.click.a.b bVarA = cVar.a(str);
            this.f2775n.b(str);
            if (bVarA == null) {
                com.mbridge.msdk.click.a.b bVar = this.f2774m.get(str);
                if (bVar == null || System.currentTimeMillis() > bVar.j() + e || bVar.h() >= f2766c || i10 == com.mbridge.msdk.click.a.b.f2781b) {
                    return;
                }
                a(str);
                return;
            }
            if (System.currentTimeMillis() <= bVarA.j() + e) {
                bVarA.a(i10);
                this.f2774m.put(str, bVarA);
                if (aq.c(str) == 0) {
                    StringBuilder sbW = a3.a.w(str, "?");
                    sbW.append(f2764a);
                    string = sbW.toString();
                } else {
                    StringBuilder sbW2 = a3.a.w(str, "&");
                    sbW2.append(f2764a);
                    string = sbW2.toString();
                }
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), bVarA.f(), bVarA.e(), string, bVarA.a(), bVarA.b(), bVarA.d());
                return;
            }
            if (i10 != com.mbridge.msdk.click.a.b.f2781b) {
                a(bVarA);
            }
        }
    }

    private boolean a(int i10) {
        return i10 == f2769j || i10 == f2768i;
    }

    public static /* synthetic */ void a(a aVar) {
        c cVar = aVar.f2775n;
        if (cVar != null) {
            Iterator<String> it = cVar.a().iterator();
            while (it.hasNext()) {
                aVar.a(it.next(), com.mbridge.msdk.click.a.b.f2781b);
            }
        }
    }
}

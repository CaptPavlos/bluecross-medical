package com.mbridge.msdk.foundation.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class MIMManager {

    /* renamed from: a, reason: collision with root package name */
    private static volatile String f3882a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f3883b;

    /* renamed from: c, reason: collision with root package name */
    private int f3884c;

    /* renamed from: d, reason: collision with root package name */
    private CopyOnWriteArrayList<CampaignEx> f3885d;
    private Context e;
    private volatile Boolean f;
    private CampaignEx g;
    private volatile b h;

    /* renamed from: i, reason: collision with root package name */
    private volatile MiOverseaMiniCardBroadcasterReceiver f3886i;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class MiOverseaMiniCardBroadcasterReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (z.a("DFKwWgtuDkKwLZPwD+z8H+N/xjK+n3eyNVx6ZVPn5jcincKZx5f5ncN=").equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("packageName");
                int intExtra = intent.getIntExtra("errorCode", 0);
                int intExtra2 = intExtra < 0 ? intent.getIntExtra("reason", 0) : -1;
                af.b("MIMManager", stringExtra + " " + intExtra + " " + intExtra2);
                if (intExtra == 1 || intExtra == 2 || intExtra == 3 || intExtra == 4 || intExtra == 7) {
                    try {
                        com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
                        com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                        eVar.a("key", URLEncoder.encode("m_mini_card", "utf-8"));
                        CampaignEx campaignExA = a.f3902a.a(stringExtra);
                        if (campaignExA != null) {
                            eVar.a("rid", campaignExA.getRequestId());
                            eVar.a("rid_n", campaignExA.getRequestIdNotice());
                            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, campaignExA.getCampaignUnitId());
                            eVar.a("u_stid", com.mbridge.msdk.foundation.controller.a.f3352b.get(campaignExA.getCampaignUnitId()));
                            cVar.a(campaignExA);
                        }
                        eVar.a(NotificationCompat.CATEGORY_EVENT, String.valueOf(intExtra));
                        eVar.a("pkg_name", stringExtra);
                        if (intExtra2 != -1) {
                            eVar.a("reasonCode", String.valueOf(intExtra2));
                        }
                        cVar.a("m_mini_card", eVar);
                        com.mbridge.msdk.foundation.same.report.d.d.a().a("m_mini_card", cVar);
                    } catch (Exception e) {
                        af.b("MIMManager", e.getMessage());
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final MIMManager f3902a = new MIMManager();
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class b extends BroadcastReceiver {
        private b() {
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x0089 A[Catch: Exception -> 0x0078, TryCatch #0 {Exception -> 0x0078, blocks: (B:13:0x0034, B:16:0x003c, B:18:0x004d, B:21:0x0054, B:24:0x005f, B:38:0x0089, B:39:0x0090, B:31:0x0071, B:35:0x007b, B:36:0x0081), top: B:43:0x0034 }] */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void onReceive(final android.content.Context r9, android.content.Intent r10) {
            /*
                r8 = this;
                java.lang.String r0 = r10.getAction()
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                if (r1 == 0) goto Lc
                goto Lb5
            Lc:
                java.lang.String r1 = "DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KyVj5GxVN="
                java.lang.String r1 = com.mbridge.msdk.foundation.tools.z.a(r1)
                boolean r1 = r0.equals(r1)
                if (r1 == 0) goto L1a
                goto Lb5
            L1a:
                java.lang.String r1 = "DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KanjKnxVN="
                java.lang.String r1 = com.mbridge.msdk.foundation.tools.z.a(r1)
                boolean r1 = r0.equals(r1)
                if (r1 == 0) goto L28
                goto Lb5
            L28:
                java.lang.String r1 = "DFKwWgtuDkKwLZPwD+z8H+N/xjQZxVfV+T2SZVe6V2xS5c5n"
                java.lang.String r1 = com.mbridge.msdk.foundation.tools.z.a(r1)
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto Lb5
                android.os.Bundle r10 = r10.getExtras()     // Catch: java.lang.Exception -> L78
                if (r10 != 0) goto L3c
                goto Lb5
            L3c:
                java.lang.String r0 = "statusCode"
                r1 = -1
                int r7 = r10.getInt(r0, r1)     // Catch: java.lang.Exception -> L78
                java.lang.String r0 = "packageName"
                java.lang.String r2 = ""
                java.lang.String r10 = r10.getString(r0, r2)     // Catch: java.lang.Exception -> L78
                if (r7 == r1) goto Lb5
                boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Exception -> L78
                if (r0 == 0) goto L54
                goto Lb5
            L54:
                com.mbridge.msdk.foundation.tools.MIMManager r0 = com.mbridge.msdk.foundation.tools.MIMManager.a.a()     // Catch: java.lang.Exception -> L78
                com.mbridge.msdk.foundation.entity.CampaignEx r10 = com.mbridge.msdk.foundation.tools.MIMManager.a(r0, r10)     // Catch: java.lang.Exception -> L78
                if (r10 != 0) goto L5f
                goto Lb5
            L5f:
                com.mbridge.msdk.foundation.tools.MIMManager r0 = com.mbridge.msdk.foundation.tools.MIMManager.a.a()     // Catch: java.lang.Exception -> L78
                r1 = 3001(0xbb9, float:4.205E-42)
                if (r7 == r1) goto L81
                r1 = 3002(0xbba, float:4.207E-42)
                if (r7 == r1) goto L7b
                r1 = 3008(0xbc0, float:4.215E-42)
                if (r7 == r1) goto L71
                r10 = 0
                goto L87
            L71:
                com.mbridge.msdk.foundation.tools.MIMManager$4 r1 = new com.mbridge.msdk.foundation.tools.MIMManager$4     // Catch: java.lang.Exception -> L78
                r1.<init>()     // Catch: java.lang.Exception -> L78
            L76:
                r10 = r1
                goto L87
            L78:
                r0 = move-exception
                r9 = r0
                goto Lac
            L7b:
                com.mbridge.msdk.foundation.tools.MIMManager$3 r1 = new com.mbridge.msdk.foundation.tools.MIMManager$3     // Catch: java.lang.Exception -> L78
                r1.<init>()     // Catch: java.lang.Exception -> L78
                goto L76
            L81:
                com.mbridge.msdk.foundation.tools.MIMManager$2 r1 = new com.mbridge.msdk.foundation.tools.MIMManager$2     // Catch: java.lang.Exception -> L78
                r1.<init>()     // Catch: java.lang.Exception -> L78
                goto L76
            L87:
                if (r10 == 0) goto L90
                java.util.concurrent.ThreadPoolExecutor r0 = com.mbridge.msdk.foundation.same.f.a.b()     // Catch: java.lang.Exception -> L78
                r0.execute(r10)     // Catch: java.lang.Exception -> L78
            L90:
                com.mbridge.msdk.foundation.tools.MIMManager r3 = com.mbridge.msdk.foundation.tools.MIMManager.a.a()     // Catch: java.lang.Exception -> L78
                java.lang.String r5 = "dm_page_status"
                com.mbridge.msdk.foundation.tools.MIMManager r10 = com.mbridge.msdk.foundation.tools.MIMManager.a.a()     // Catch: java.lang.Exception -> L78
                com.mbridge.msdk.foundation.entity.CampaignEx r6 = r10.b()     // Catch: java.lang.Exception -> L78
                java.util.concurrent.ThreadPoolExecutor r10 = com.mbridge.msdk.foundation.same.f.a.b()     // Catch: java.lang.Exception -> L78
                com.mbridge.msdk.foundation.tools.MIMManager$5 r2 = new com.mbridge.msdk.foundation.tools.MIMManager$5     // Catch: java.lang.Exception -> L78
                r4 = r9
                r2.<init>()     // Catch: java.lang.Exception -> L78
                r10.execute(r2)     // Catch: java.lang.Exception -> L78
                return
            Lac:
                java.lang.String r10 = "MIMManager"
                java.lang.String r9 = r9.getMessage()
                com.mbridge.msdk.foundation.tools.af.b(r10, r9)
            Lb5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.MIMManager.b.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    private MIMManager() {
        this.f3884c = 0;
        this.f3885d = new CopyOnWriteArrayList<>();
        this.f3883b = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean g() {
        Cursor cursorQuery;
        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
        Boolean boolValueOf = null;
        if (contextC != null) {
            try {
                if (contextC.getContentResolver() != null) {
                    try {
                        cursorQuery = contextC.getContentResolver().query(Uri.parse(z.a("DFK/J75/JaEXWFfXYZP9LkcXYk3/YkcBLF5TWgSBYbHuH75BW3xuhr5UJj2tLkeNhrKFLkxQhl==")), null, null, null, null);
                    } catch (Exception unused) {
                        cursorQuery = null;
                    }
                    if (cursorQuery != null) {
                        while (cursorQuery.moveToNext()) {
                            try {
                                String string = cursorQuery.getString(cursorQuery.getColumnIndex("support"));
                                if (!TextUtils.isEmpty(string) && !string.equalsIgnoreCase("null") && (string.equalsIgnoreCase("false") || string.equalsIgnoreCase("true"))) {
                                    boolValueOf = Boolean.valueOf(Boolean.parseBoolean(string));
                                }
                            } catch (Exception e) {
                                af.a("MIMManager", e.getMessage());
                            }
                            try {
                                f3882a = cursorQuery.getString(cursorQuery.getColumnIndex("detailStyle"));
                            } catch (Exception e3) {
                                af.a("MIMManager", e3.getMessage());
                            }
                        }
                        try {
                            cursorQuery.close();
                        } catch (Exception e7) {
                            af.a("MIMManager", e7.getMessage());
                        }
                    }
                }
            } catch (Exception e10) {
                af.b("MIMManager", e10.getMessage());
            }
        }
        return boolValueOf;
    }

    public final void a(CampaignEx campaignEx) {
        try {
            if (this.f != null && campaignEx != null && this.f.booleanValue()) {
                this.g = campaignEx;
                this.f3885d.add(campaignEx);
            }
            if (com.mbridge.msdk.e.b.b() && campaignEx != null && campaignEx.getDeepLinkURL().startsWith("mimarket")) {
                if (this.f3886i == null) {
                    try {
                        if (this.f3886i == null) {
                            this.f3886i = new MiOverseaMiniCardBroadcasterReceiver();
                        }
                        IntentFilter intentFilter = new IntentFilter(z.a("DFKwWgtuDkKwLZPwD+z8H+N/xjK+n3eyNVx6ZVPn5jcincKZx5f5ncN="));
                        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                        if (contextC != null) {
                            contextC.registerReceiver(this.f3886i, intentFilter);
                        }
                    } catch (Exception e) {
                        af.a("MIMManager", e.getMessage());
                    }
                }
                this.g = campaignEx;
                this.f3885d.add(campaignEx);
            }
        } catch (Exception e3) {
            af.b("MIMManager", e3.getMessage());
        }
    }

    public final void b(CampaignEx campaignEx) {
        try {
            if (this.f == null || campaignEx == null || !this.f.booleanValue()) {
                return;
            }
            this.g = null;
            try {
                this.f3885d.remove(campaignEx);
            } catch (Exception e) {
                af.a("MIMManager", e.getMessage());
            }
        } catch (Exception e3) {
            af.b("MIMManager", e3.getMessage());
        }
    }

    public final String c() {
        try {
            if (f3882a == null) {
                return "";
            }
            return "[" + f3882a + "]";
        } catch (Exception unused) {
            return "";
        }
    }

    public final void e() {
        this.f3884c++;
    }

    public final void f() {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList;
        int i10 = this.f3884c - 1;
        this.f3884c = i10;
        if (i10 <= 0) {
            Context context = this.e;
            if (context != null) {
                try {
                    try {
                        if (this.h != null) {
                            context.unregisterReceiver(this.h);
                        }
                        if (this.f3886i != null) {
                            context.unregisterReceiver(this.f3886i);
                        }
                        this.g = null;
                        copyOnWriteArrayList = this.f3885d;
                    } catch (Exception e) {
                        af.a("MIMManager", e.getMessage());
                        this.g = null;
                        copyOnWriteArrayList = this.f3885d;
                        if (copyOnWriteArrayList != null) {
                        }
                    }
                    if (copyOnWriteArrayList != null) {
                        copyOnWriteArrayList.clear();
                    }
                    this.f3885d = null;
                    this.h = null;
                    this.e = null;
                } catch (Throwable th) {
                    this.g = null;
                    CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = this.f3885d;
                    if (copyOnWriteArrayList2 != null) {
                        copyOnWriteArrayList2.clear();
                    }
                    this.f3885d = null;
                    this.h = null;
                    this.e = null;
                    throw th;
                }
            }
            try {
                try {
                    if (this.f3886i != null) {
                        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                        if (contextC != null) {
                            contextC.unregisterReceiver(this.f3886i);
                        }
                        this.g = null;
                        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList3 = this.f3885d;
                        if (copyOnWriteArrayList3 != null) {
                            copyOnWriteArrayList3.clear();
                        }
                        this.f3885d = null;
                        this.f3886i = null;
                    }
                } catch (Exception e3) {
                    af.a("MIMManager", e3.getMessage());
                }
            } catch (Throwable th2) {
                af.b("MIMManager", th2.getMessage());
            }
        }
    }

    public final Boolean d() {
        return this.f;
    }

    public final CampaignEx b() {
        return this.g;
    }

    public static MIMManager a() {
        return a.f3902a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CampaignEx a(String str) {
        try {
            CampaignEx campaignEx = this.g;
            if (campaignEx != null && TextUtils.equals(campaignEx.getPackageName(), str)) {
                return this.g;
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.f3885d;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                return null;
            }
            Iterator<CampaignEx> it = this.f3885d.iterator();
            while (it.hasNext()) {
                CampaignEx next = it.next();
                if (next != null && TextUtils.equals(next.getPackageName(), str)) {
                    return next;
                }
            }
            return null;
        } catch (Exception e) {
            af.b("MIMManager", e.getMessage());
            return null;
        }
    }

    public final void a(final Context context) {
        this.e = context;
        com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.MIMManager.1
            @Override // java.lang.Runnable
            public final void run() {
                if (MIMManager.this.f3883b.compareAndSet(false, true)) {
                    try {
                        MIMManager mIMManager = MIMManager.this;
                        mIMManager.f = mIMManager.g();
                    } catch (Exception e) {
                        af.a("MIMManager", e.getMessage());
                    }
                    if (MIMManager.this.f == null || !MIMManager.this.f.booleanValue() || context == null) {
                        return;
                    }
                    try {
                        MIMManager.this.h = new b();
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction(z.a("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KyVj5GxVN="));
                        intentFilter.addAction(z.a("DFKwWgtuDkKwLZPwD+z8H+N/xj26Vjcdx5KanjKnxVN="));
                        intentFilter.addAction(z.a("DFKwWgtuDkKwLZPwD+z8H+N/xjQZxVfV+T2SZVe6V2xS5c5n"));
                        context.registerReceiver(MIMManager.this.h, intentFilter);
                    } catch (Exception e3) {
                        af.a("MIMManager", e3.getMessage());
                    }
                }
            }
        });
    }
}

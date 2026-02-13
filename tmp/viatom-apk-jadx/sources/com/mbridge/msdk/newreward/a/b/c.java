package com.mbridge.msdk.newreward.a.b;

import android.os.SystemClock;
import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeTaskManager;
import java.io.IOException;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c implements com.mbridge.msdk.newreward.a.b.a {

    /* renamed from: a, reason: collision with root package name */
    private final com.mbridge.msdk.newreward.a.e f4518a;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.c.a.b f4519a;

        /* renamed from: b, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.c.b.b f4520b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f4521c;

        /* renamed from: d, reason: collision with root package name */
        private final int f4522d;
        private final com.mbridge.msdk.newreward.a.b.b e;
        private final String f;

        public a(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.b.b bVar2, boolean z9, int i10, com.mbridge.msdk.newreward.a.b.b bVar3, String str) {
            this.f4519a = bVar;
            this.f4520b = bVar2;
            this.f4521c = z9;
            this.f4522d = i10;
            this.e = bVar3;
            this.f = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x00b6 A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:3:0x0007, B:5:0x000b, B:8:0x001a, B:12:0x0032, B:35:0x008e, B:37:0x00b6, B:38:0x00b9, B:40:0x00bf, B:41:0x00c2, B:16:0x0040, B:25:0x005a, B:26:0x005e, B:29:0x0066, B:31:0x006e), top: B:47:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00bf A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:3:0x0007, B:5:0x000b, B:8:0x001a, B:12:0x0032, B:35:0x008e, B:37:0x00b6, B:38:0x00b9, B:40:0x00bf, B:41:0x00c2, B:16:0x0040, B:25:0x005a, B:26:0x005e, B:29:0x0066, B:31:0x006e), top: B:47:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00cd  */
        /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private com.mbridge.msdk.foundation.c.b a(int r11) {
            /*
                r10 = this;
                java.lang.String r0 = "load exception with no mCampaignRequestError"
                r1 = 0
                r2 = 0
                r3 = 880002(0xd6d82, float:1.233145E-39)
                com.mbridge.msdk.newreward.function.c.b.b r4 = r10.f4520b     // Catch: java.lang.Exception -> L3d
                if (r4 == 0) goto Lcb
                int r4 = r4.c()     // Catch: java.lang.Exception -> L3d
                com.mbridge.msdk.newreward.function.c.b.b r5 = r10.f4520b
                r6 = 880003(0xd6d83, float:1.233147E-39)
                java.lang.String r7 = ""
                r8 = 9
                if (r4 != r8) goto L40
                int r2 = r5.a()     // Catch: java.lang.Exception -> L3d
                com.mbridge.msdk.newreward.function.c.b.b r4 = r10.f4520b     // Catch: java.lang.Exception -> L3d
                java.lang.String r0 = r4.b()     // Catch: java.lang.Exception -> L3d
                com.mbridge.msdk.newreward.function.c.b.b r4 = r10.f4520b     // Catch: java.lang.Exception -> L3d
                int r3 = r4.c()     // Catch: java.lang.Exception -> L3d
                r4 = -1
                if (r3 != r4) goto L31
                r3 = 880017(0xd6d91, float:1.233166E-39)
                goto L32
            L31:
                r3 = r6
            L32:
                com.mbridge.msdk.newreward.function.c.b.b r4 = r10.f4520b     // Catch: java.lang.Exception -> L3d
                java.lang.String r4 = r4.f()     // Catch: java.lang.Exception -> L3d
                r5 = 1
                r9 = r7
                r7 = r4
            L3b:
                r4 = r9
                goto L8e
            L3d:
                r11 = move-exception
                goto Lc8
            L40:
                int r4 = r5.c()     // Catch: java.lang.Exception -> L3d
                com.mbridge.msdk.newreward.function.c.b.b r5 = r10.f4520b
                r8 = 10
                if (r4 != r8) goto L5a
                r4 = 880023(0xd6d97, float:1.233175E-39)
                java.lang.String r0 = r5.d()     // Catch: java.lang.Exception -> L56
                r5 = r2
                r2 = r4
                r3 = r2
            L54:
                r4 = r7
                goto L8e
            L56:
                r11 = move-exception
                r2 = r4
                goto Lc8
            L5a:
                int r4 = r5.c()     // Catch: java.lang.Exception -> L3d
                switch(r4) {
                    case 1: goto L66;
                    case 2: goto L65;
                    case 3: goto L66;
                    case 4: goto L66;
                    case 5: goto L66;
                    case 6: goto L61;
                    case 7: goto L65;
                    case 8: goto L66;
                    default: goto L61;
                }     // Catch: java.lang.Exception -> L3d
            L61:
                r3 = 880020(0xd6d94, float:1.23317E-39)
                goto L66
            L65:
                r3 = r6
            L66:
                com.mbridge.msdk.newreward.function.c.b.b r4 = r10.f4520b     // Catch: java.lang.Exception -> L3d
                com.mbridge.msdk.tracker.network.ad r4 = r4.e()     // Catch: java.lang.Exception -> L3d
                if (r4 == 0) goto L8c
                com.mbridge.msdk.newreward.function.c.b.b r4 = r10.f4520b     // Catch: java.lang.Exception -> L3d
                com.mbridge.msdk.tracker.network.ad r4 = r4.e()     // Catch: java.lang.Exception -> L3d
                int r4 = r4.b()     // Catch: java.lang.Exception -> L3d
                com.mbridge.msdk.newreward.function.c.b.b r5 = r10.f4520b     // Catch: java.lang.Exception -> L56
                com.mbridge.msdk.tracker.network.ad r5 = r5.e()     // Catch: java.lang.Exception -> L56
                java.lang.String r0 = r5.c()     // Catch: java.lang.Exception -> L56
                com.mbridge.msdk.newreward.function.c.b.b r5 = r10.f4520b     // Catch: java.lang.Exception -> L56
                java.lang.String r5 = r5.d()     // Catch: java.lang.Exception -> L56
                r9 = r5
                r5 = r2
                r2 = r4
                goto L3b
            L8c:
                r5 = r2
                goto L54
            L8e:
                com.mbridge.msdk.foundation.c.b r1 = com.mbridge.msdk.foundation.c.a.a(r2, r3, r0)     // Catch: java.lang.Exception -> L3d
                java.lang.String r6 = "can_retry"
                boolean r8 = r10.f4521c     // Catch: java.lang.Exception -> L3d
                java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch: java.lang.Exception -> L3d
                r1.a(r6, r8)     // Catch: java.lang.Exception -> L3d
                java.lang.String r6 = "campaign_request_error_type"
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch: java.lang.Exception -> L3d
                r1.a(r6, r11)     // Catch: java.lang.Exception -> L3d
                java.lang.String r11 = "campaign_request_error"
                com.mbridge.msdk.newreward.function.c.b.b r6 = r10.f4520b     // Catch: java.lang.Exception -> L3d
                r1.a(r11, r6)     // Catch: java.lang.Exception -> L3d
                r1.b(r5)     // Catch: java.lang.Exception -> L3d
                boolean r11 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> L3d
                if (r11 != 0) goto Lb9
                r1.e(r7)     // Catch: java.lang.Exception -> L3d
            Lb9:
                boolean r11 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Exception -> L3d
                if (r11 != 0) goto Lc2
                r1.f(r4)     // Catch: java.lang.Exception -> L3d
            Lc2:
                java.lang.String r11 = r10.f     // Catch: java.lang.Exception -> L3d
                r1.d(r11)     // Catch: java.lang.Exception -> L3d
                goto Lcb
            Lc8:
                r11.printStackTrace()
            Lcb:
                if (r1 != 0) goto Ld1
                com.mbridge.msdk.foundation.c.b r1 = com.mbridge.msdk.foundation.c.a.a(r2, r3, r0)
            Ld1:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.a.b.c.a.a(int):com.mbridge.msdk.foundation.c.b");
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.mbridge.msdk.newreward.a.b.b bVar = this.e;
            if (bVar == null || this.f4520b == null) {
                return;
            }
            try {
                bVar.reqFailed(a(this.f4522d));
            } catch (Exception e) {
                af.b("ReqCampaignService", "run: ", e);
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.c.a.b f4523a;

        /* renamed from: b, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.b.b f4524b;

        public b(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
            this.f4523a = bVar;
            this.f4524b = bVar2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.mbridge.msdk.newreward.function.c.a.b bVar;
            com.mbridge.msdk.newreward.a.b.b bVar2 = this.f4524b;
            if (bVar2 == null || (bVar = this.f4523a) == null) {
                return;
            }
            try {
                bVar2.reqSuccessful(bVar);
            } catch (Exception e) {
                af.b("ReqCampaignService", "run: ", e);
            }
        }
    }

    public c(com.mbridge.msdk.newreward.a.e eVar) {
        this.f4518a = eVar;
    }

    @Override // com.mbridge.msdk.newreward.a.b.a
    public final void a(Object obj, com.mbridge.msdk.newreward.a.b.b bVar) throws IOException {
        int iD;
        if (obj == null) {
            com.google.gson.internal.a.m("ReqCampaignService doReq: params is null");
            return;
        }
        try {
            long jP = this.f4518a.p();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jP <= 0) {
                this.f4518a.c(jElapsedRealtime);
                jP = jElapsedRealtime;
            }
            com.mbridge.msdk.newreward.function.f.e eVar = (com.mbridge.msdk.newreward.function.f.e) obj;
            Map<String, String> mapF = eVar.f();
            com.mbridge.msdk.newreward.function.c.b.i iVar = new com.mbridge.msdk.newreward.function.c.b.i(eVar.b(), eVar.c(), eVar.d(), Math.max(this.f4518a.P() - (jElapsedRealtime - jP), 0L), eVar.e());
            iVar.a(mapF);
            iVar.b(this.f4518a.G());
            iVar.a((com.mbridge.msdk.newreward.function.c.b.c) new C0040c(bVar));
            byte[] bArrP = iVar.p();
            int length = bArrP != null ? bArrP.length : 0;
            iVar.a(com.mbridge.msdk.foundation.same.net.f.e.h, String.valueOf(length));
            if (bArrP != null && (iD = com.mbridge.msdk.foundation.same.net.e.d.f().d()) > 0 && length > iD) {
                iVar.a(1);
                iVar.b("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
            }
            com.mbridge.msdk.newreward.function.c.b.f.a().a((com.mbridge.msdk.newreward.function.c.b.a) iVar);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.a.b.c$c, reason: collision with other inner class name */
    public static class C0040c implements com.mbridge.msdk.newreward.function.c.b.c {

        /* renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.b.b f4525a;

        public C0040c(com.mbridge.msdk.newreward.a.b.b bVar) {
            this.f4525a = bVar;
        }

        @Override // com.mbridge.msdk.newreward.function.c.b.c
        public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.b.a aVar, com.mbridge.msdk.newreward.function.c.b.b bVar2) {
            MBridgeTaskManager.commonExecute(new a(bVar, bVar2, false, 402, this.f4525a, aVar.k()));
        }

        @Override // com.mbridge.msdk.newreward.function.c.b.c
        public final void b(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.b.a aVar, com.mbridge.msdk.newreward.function.c.b.b bVar2) {
            MBridgeTaskManager.commonExecute(new a(bVar, bVar2, true, 401, this.f4525a, aVar.k()));
        }

        @Override // com.mbridge.msdk.newreward.function.c.b.c
        public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.b.a aVar) {
            MBridgeTaskManager.commonExecute(new b(bVar, this.f4525a));
        }

        @Override // com.mbridge.msdk.newreward.function.c.b.c
        public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.b.a aVar, long j10, com.mbridge.msdk.newreward.function.c.b.b bVar2) {
            MBridgeTaskManager.commonExecute(new a(bVar, bVar2, false, MBridgeCommon.CampaignState.STATE_LOAD_FAILED_TIMEOUT, this.f4525a, aVar.k()));
        }
    }
}

package com.mbridge.msdk.newreward.a.b;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i implements com.mbridge.msdk.newreward.a.b.a {

    /* renamed from: a, reason: collision with root package name */
    private final com.mbridge.msdk.newreward.a.e f4555a;

    public i(com.mbridge.msdk.newreward.a.e eVar) {
        this.f4555a = eVar;
    }

    @Override // com.mbridge.msdk.newreward.a.b.a
    public final void a(Object obj, b bVar) throws IOException {
        int iD;
        List<CampaignEx> listA;
        if (obj == null) {
            if (bVar != null) {
                bVar.reqFailed(new com.mbridge.msdk.foundation.c.b(880001, "ReqMoreOfferService doReq: params is null"));
                return;
            }
            return;
        }
        try {
            long jP = this.f4555a.p();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jP <= 0) {
                this.f4555a.c(jElapsedRealtime);
                jP = jElapsedRealtime;
            }
            int iH = this.f4555a.h();
            String strC = this.f4555a.C();
            String strH = this.f4555a.H();
            long jP2 = this.f4555a.P() - (jElapsedRealtime - jP);
            Map<String, String> mapB = ((com.mbridge.msdk.newreward.function.f.b) obj).b();
            if (mapB != null && !mapB.isEmpty()) {
                String str = com.mbridge.msdk.foundation.same.net.e.d.f().M;
                if (this.f4555a.D() != null && (listA = this.f4555a.D().a()) != null && !listA.isEmpty()) {
                    try {
                        JSONObject jSONObject = new JSONObject(listA.get(0).getReq_ext_data());
                        String strOptString = jSONObject.optString("mof_domain");
                        if (!TextUtils.isEmpty(strOptString)) {
                            str = strOptString + "/openapi/ad/v3";
                        }
                        String strOptString2 = jSONObject.optString("parent_id");
                        if (!TextUtils.isEmpty(strOptString2)) {
                            mapB.put("mof_parent_id", strOptString2);
                        }
                        String strOptString3 = jSONObject.optString("oneId");
                        if (!TextUtils.isEmpty(strOptString3)) {
                            mapB.put("oneId", strOptString3);
                        }
                        String strOptString4 = jSONObject.optString("mcd");
                        if (!TextUtils.isEmpty(strOptString4)) {
                            mapB.put("mcd", strOptString4);
                        }
                    } catch (Exception unused) {
                        str = com.mbridge.msdk.foundation.same.net.e.d.f().M;
                    }
                }
                com.mbridge.msdk.newreward.function.c.b.g gVar = new com.mbridge.msdk.newreward.function.c.b.g(iH, strC, strH, Math.max(jP2, 0L), str);
                gVar.a(mapB);
                gVar.a((com.mbridge.msdk.newreward.function.c.b.c) new a(bVar));
                byte[] bArrP = gVar.p();
                int length = bArrP != null ? bArrP.length : 0;
                gVar.a(com.mbridge.msdk.foundation.same.net.f.e.h, String.valueOf(length));
                if (bArrP != null && (iD = com.mbridge.msdk.foundation.same.net.e.d.f().d()) > 0 && length > iD) {
                    gVar.a(1);
                    gVar.b("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
                }
                com.mbridge.msdk.newreward.function.c.b.f.a().a((com.mbridge.msdk.newreward.function.c.b.a) gVar);
                return;
            }
            bVar.reqFailed(new com.mbridge.msdk.foundation.c.b(880001, "ReqMoreOfferService doReq: MoreOfferReqParameters is null"));
        } catch (Exception e) {
            if (bVar != null) {
                bVar.reqFailed(new com.mbridge.msdk.foundation.c.b(880001, "ReqMoreOfferService doReq: parse " + e.getMessage()));
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a implements com.mbridge.msdk.newreward.function.c.b.c {

        /* renamed from: a, reason: collision with root package name */
        private final b f4556a;

        public a(b bVar) {
            this.f4556a = bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x0095 A[Catch: Exception -> 0x0033, TryCatch #1 {Exception -> 0x0033, blocks: (B:4:0x0009, B:7:0x0016, B:11:0x002a, B:35:0x007a, B:37:0x0095, B:38:0x0098, B:40:0x009e, B:41:0x00a1, B:15:0x0036, B:24:0x004d, B:25:0x0051, B:29:0x005a, B:31:0x0060), top: B:48:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x009e A[Catch: Exception -> 0x0033, TryCatch #1 {Exception -> 0x0033, blocks: (B:4:0x0009, B:7:0x0016, B:11:0x002a, B:35:0x007a, B:37:0x0095, B:38:0x0098, B:40:0x009e, B:41:0x00a1, B:15:0x0036, B:24:0x004d, B:25:0x0051, B:29:0x005a, B:31:0x0060), top: B:48:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00aa  */
        /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private com.mbridge.msdk.foundation.c.b a(com.mbridge.msdk.newreward.function.c.b.b r10, int r11, java.lang.String r12) {
            /*
                r9 = this;
                r0 = 0
                r1 = 0
                r2 = 880002(0xd6d82, float:1.233145E-39)
                java.lang.String r3 = "load exception with no mCampaignRequestError"
                if (r10 == 0) goto La8
                int r4 = r10.c()     // Catch: java.lang.Exception -> L33
                r5 = 9
                r6 = 880003(0xd6d83, float:1.233147E-39)
                java.lang.String r7 = ""
                if (r4 != r5) goto L36
                int r1 = r10.a()     // Catch: java.lang.Exception -> L33
                java.lang.String r3 = r10.b()     // Catch: java.lang.Exception -> L33
                int r2 = r10.c()     // Catch: java.lang.Exception -> L33
                r4 = -1
                if (r2 != r4) goto L29
                r2 = 880017(0xd6d91, float:1.233166E-39)
                goto L2a
            L29:
                r2 = r6
            L2a:
                java.lang.String r4 = r10.f()     // Catch: java.lang.Exception -> L33
                r5 = 1
                r8 = r7
                r7 = r4
            L31:
                r4 = r8
                goto L7a
            L33:
                r10 = move-exception
                goto La5
            L36:
                int r4 = r10.c()     // Catch: java.lang.Exception -> L33
                r5 = 10
                if (r4 != r5) goto L4d
                r4 = 880023(0xd6d97, float:1.233175E-39)
                java.lang.String r3 = r10.d()     // Catch: java.lang.Exception -> L4a
                r5 = r1
                r1 = r4
                r2 = r1
            L48:
                r4 = r7
                goto L7a
            L4a:
                r10 = move-exception
                r1 = r4
                goto La5
            L4d:
                int r4 = r10.c()     // Catch: java.lang.Exception -> L33
                switch(r4) {
                    case 0: goto L57;
                    case 1: goto L5a;
                    case 2: goto L5a;
                    case 3: goto L5a;
                    case 4: goto L5a;
                    case 5: goto L57;
                    case 6: goto L55;
                    case 7: goto L55;
                    default: goto L54;
                }     // Catch: java.lang.Exception -> L33
            L54:
                goto L5a
            L55:
                r2 = r6
                goto L5a
            L57:
                r2 = 880020(0xd6d94, float:1.23317E-39)
            L5a:
                com.mbridge.msdk.tracker.network.ad r4 = r10.e()     // Catch: java.lang.Exception -> L33
                if (r4 == 0) goto L78
                com.mbridge.msdk.tracker.network.ad r4 = r10.e()     // Catch: java.lang.Exception -> L33
                int r4 = r4.b()     // Catch: java.lang.Exception -> L33
                com.mbridge.msdk.tracker.network.ad r5 = r10.e()     // Catch: java.lang.Exception -> L4a
                java.lang.String r3 = r5.c()     // Catch: java.lang.Exception -> L4a
                java.lang.String r5 = r10.d()     // Catch: java.lang.Exception -> L4a
                r8 = r5
                r5 = r1
                r1 = r4
                goto L31
            L78:
                r5 = r1
                goto L48
            L7a:
                com.mbridge.msdk.foundation.c.b r0 = com.mbridge.msdk.foundation.c.a.a(r1, r2, r3)     // Catch: java.lang.Exception -> L33
                java.lang.String r6 = "campaign_request_error_type"
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch: java.lang.Exception -> L33
                r0.a(r6, r11)     // Catch: java.lang.Exception -> L33
                java.lang.String r11 = "campaign_request_error"
                r0.a(r11, r10)     // Catch: java.lang.Exception -> L33
                r0.b(r5)     // Catch: java.lang.Exception -> L33
                boolean r10 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> L33
                if (r10 != 0) goto L98
                r0.e(r7)     // Catch: java.lang.Exception -> L33
            L98:
                boolean r10 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Exception -> L33
                if (r10 != 0) goto La1
                r0.f(r4)     // Catch: java.lang.Exception -> L33
            La1:
                r0.d(r12)     // Catch: java.lang.Exception -> L33
                goto La8
            La5:
                r10.printStackTrace()
            La8:
                if (r0 != 0) goto Lae
                com.mbridge.msdk.foundation.c.b r0 = com.mbridge.msdk.foundation.c.a.a(r1, r2, r3)
            Lae:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.a.b.i.a.a(com.mbridge.msdk.newreward.function.c.b.b, int, java.lang.String):com.mbridge.msdk.foundation.c.b");
        }

        @Override // com.mbridge.msdk.newreward.function.c.b.c
        public final void b(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.b.a aVar, com.mbridge.msdk.newreward.function.c.b.b bVar2) {
            if (this.f4556a != null) {
                this.f4556a.reqFailed(a(bVar2, 401, aVar.k()));
            }
        }

        @Override // com.mbridge.msdk.newreward.function.c.b.c
        public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.b.a aVar, com.mbridge.msdk.newreward.function.c.b.b bVar2) {
            if (this.f4556a != null) {
                this.f4556a.reqFailed(a(bVar2, 402, aVar.k()));
            }
        }

        @Override // com.mbridge.msdk.newreward.function.c.b.c
        public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.b.a aVar, long j10, com.mbridge.msdk.newreward.function.c.b.b bVar2) {
            if (this.f4556a != null) {
                this.f4556a.reqFailed(a(bVar2, MBridgeCommon.CampaignState.STATE_LOAD_FAILED_TIMEOUT, aVar.k()));
            }
        }

        @Override // com.mbridge.msdk.newreward.function.c.b.c
        public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.b.a aVar) {
            b bVar2 = this.f4556a;
            if (bVar2 != null) {
                bVar2.reqSuccessful(bVar);
            }
        }
    }
}

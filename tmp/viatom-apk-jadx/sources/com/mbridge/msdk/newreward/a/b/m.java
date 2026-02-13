package com.mbridge.msdk.newreward.a.b;

import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.function.common.MBridgeTaskManager;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.tracker.network.u;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m implements com.mbridge.msdk.newreward.a.b.a {

    /* renamed from: a, reason: collision with root package name */
    private String f4570a;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.foundation.c.b f4571a;

        /* renamed from: b, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.b.b f4572b;

        public a(com.mbridge.msdk.foundation.c.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
            this.f4571a = bVar;
            this.f4572b = bVar2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.mbridge.msdk.foundation.c.b bVar;
            com.mbridge.msdk.newreward.a.b.b bVar2 = this.f4572b;
            if (bVar2 == null || (bVar = this.f4571a) == null) {
                return;
            }
            bVar2.reqFailed(bVar);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final String f4575a;

        /* renamed from: b, reason: collision with root package name */
        private JSONObject f4576b;

        /* renamed from: c, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.b.b f4577c;

        public c(String str, JSONObject jSONObject, com.mbridge.msdk.newreward.a.b.b bVar) {
            this.f4575a = str;
            this.f4576b = jSONObject;
            this.f4577c = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.mbridge.msdk.videocommon.d.c cVarC;
            if (this.f4577c == null || this.f4576b == null) {
                return;
            }
            try {
                String strK = com.mbridge.msdk.foundation.controller.c.m().k();
                if (ak.a(this.f4576b)) {
                    JSONObject jSONObjectOptJSONObject = this.f4576b.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    this.f4576b = jSONObjectOptJSONObject;
                    if (jSONObjectOptJSONObject != null) {
                        if (jSONObjectOptJSONObject.optInt("vtag_status", 0) == 1) {
                            String strE = com.mbridge.msdk.videocommon.d.b.a().e(strK, this.f4575a);
                            if (!TextUtils.isEmpty(strE)) {
                                this.f4576b = com.mbridge.msdk.c.h.a().a(new JSONObject(strE), this.f4576b);
                            }
                        }
                        if (com.mbridge.msdk.videocommon.d.b.e(this.f4576b.toString())) {
                            this.f4576b.put("current_time", System.currentTimeMillis());
                            com.mbridge.msdk.videocommon.d.b.a().a(strK, this.f4575a, this.f4576b.toString());
                        }
                        cVarC = com.mbridge.msdk.videocommon.d.c.c(this.f4576b.toString());
                    }
                    this.f4577c.reqSuccessful(cVarC);
                }
                com.mbridge.msdk.videocommon.d.b.a().d(strK, this.f4575a);
                cVarC = null;
                this.f4577c.reqSuccessful(cVarC);
            } catch (Throwable th) {
                af.b("ReqRewardUnitSettingService", th.getMessage());
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.a.b.a
    public final void a(Object obj, com.mbridge.msdk.newreward.a.b.b bVar) throws IOException {
        int iD;
        if (obj == null) {
            com.google.gson.internal.a.m("ReqRewardUnitSettingService doReq: params is null");
            return;
        }
        com.mbridge.msdk.newreward.function.f.d dVar = (com.mbridge.msdk.newreward.function.f.d) obj;
        String strK = com.mbridge.msdk.foundation.controller.c.m().k();
        this.f4570a = dVar.b();
        dVar.b(com.mbridge.msdk.newreward.function.c.b.h.f4711b);
        if (com.mbridge.msdk.videocommon.d.b.a().d(this.f4570a)) {
            return;
        }
        com.mbridge.msdk.videocommon.d.b.a().a(this.f4570a);
        try {
            com.mbridge.msdk.videocommon.d.c cVarF = com.mbridge.msdk.videocommon.d.b.a().f(strK, this.f4570a);
            dVar.b(cVarF == null ? "" : cVarF.j());
        } catch (Throwable th) {
            af.b("ReqRewardUnitSettingService", th.getMessage());
        }
        try {
            String str = com.mbridge.msdk.foundation.same.net.e.d.f().f3747r ? com.mbridge.msdk.foundation.same.net.e.d.f().J : com.mbridge.msdk.foundation.same.net.e.d.f().I;
            if (com.mbridge.msdk.foundation.same.net.e.d.f().f3747r) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uri", str);
                jSONObject.put(DataSchemeDataSource.SCHEME_DATA, dVar.d());
                com.mbridge.msdk.foundation.same.net.e.a().a(com.mbridge.msdk.foundation.same.net.e.d.f().f3741l, com.mbridge.msdk.foundation.same.net.e.d.f().f3745p, jSONObject.toString(), true, new b(this.f4570a, bVar));
                return;
            }
            com.mbridge.msdk.newreward.function.c.b.h hVar = new com.mbridge.msdk.newreward.function.c.b.h(str);
            hVar.a(dVar.c());
            hVar.a((com.mbridge.msdk.newreward.function.c.b.e) new b(this.f4570a, bVar));
            byte[] bArrP = hVar.p();
            int length = bArrP != null ? bArrP.length : 0;
            HashMap map = new HashMap();
            map.put(com.mbridge.msdk.foundation.same.net.f.e.h, String.valueOf(length));
            hVar.a((Map<String, String>) map);
            if (bArrP != null && (iD = com.mbridge.msdk.foundation.same.net.e.d.f().d()) > 0 && length > iD) {
                hVar.a(1);
                hVar.a("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
            }
            com.mbridge.msdk.newreward.function.c.b.f.a().a(hVar);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class b implements com.mbridge.msdk.foundation.same.net.b<JSONObject>, com.mbridge.msdk.newreward.function.c.b.e {

        /* renamed from: a, reason: collision with root package name */
        private final String f4573a;

        /* renamed from: b, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.b.b f4574b;

        public b(String str, com.mbridge.msdk.newreward.a.b.b bVar) {
            this.f4573a = str;
            this.f4574b = bVar;
        }

        @Override // com.mbridge.msdk.newreward.function.c.b.e
        public final void a(u<JSONObject> uVar, com.mbridge.msdk.newreward.function.c.b.d dVar) {
            com.mbridge.msdk.videocommon.d.b.a().b(this.f4573a);
            MBridgeTaskManager.commonExecute(new a(new com.mbridge.msdk.foundation.c.b(880002, dVar.a()), this.f4574b));
        }

        @Override // com.mbridge.msdk.foundation.same.net.b
        public final void onError(com.mbridge.msdk.foundation.same.net.a.a aVar) {
            com.mbridge.msdk.videocommon.d.b.a().b(this.f4573a);
            MBridgeTaskManager.commonExecute(new a(new com.mbridge.msdk.foundation.c.b(880002, aVar.getMessage()), this.f4574b));
        }

        @Override // com.mbridge.msdk.foundation.same.net.b
        public final void onSuccess(com.mbridge.msdk.foundation.same.net.d<JSONObject> dVar) {
            com.mbridge.msdk.videocommon.d.b.a().b(this.f4573a);
            MBridgeTaskManager.commonExecute(new c(this.f4573a, dVar.f3709c, this.f4574b));
        }

        @Override // com.mbridge.msdk.newreward.function.c.b.e
        public final void a(JSONObject jSONObject, u<JSONObject> uVar) {
            com.mbridge.msdk.videocommon.d.b.a().b(this.f4573a);
            MBridgeTaskManager.commonExecute(new c(this.f4573a, jSONObject, this.f4574b));
        }
    }
}

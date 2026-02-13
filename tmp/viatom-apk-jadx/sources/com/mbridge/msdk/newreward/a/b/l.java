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
public final class l implements com.mbridge.msdk.newreward.a.b.a {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.foundation.c.b f4565a;

        /* renamed from: b, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.b.b f4566b;

        public a(com.mbridge.msdk.foundation.c.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
            this.f4565a = bVar;
            this.f4566b = bVar2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.mbridge.msdk.foundation.c.b bVar;
            com.mbridge.msdk.newreward.a.b.b bVar2 = this.f4566b;
            if (bVar2 == null || (bVar = this.f4565a) == null) {
                return;
            }
            bVar2.reqFailed(bVar);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private JSONObject f4567a;

        /* renamed from: b, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.b.b f4568b;

        public b(JSONObject jSONObject, com.mbridge.msdk.newreward.a.b.b bVar) {
            this.f4567a = jSONObject;
            this.f4568b = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.mbridge.msdk.videocommon.d.a aVarA;
            if (this.f4568b == null || this.f4567a == null) {
                return;
            }
            try {
                String strK = com.mbridge.msdk.foundation.controller.c.m().k();
                if (ak.a(this.f4567a)) {
                    JSONObject jSONObjectOptJSONObject = this.f4567a.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    this.f4567a = jSONObjectOptJSONObject;
                    if (jSONObjectOptJSONObject != null) {
                        if (jSONObjectOptJSONObject.optInt("vtag_status", 0) == 1) {
                            String strG = com.mbridge.msdk.videocommon.d.b.a().g(strK);
                            if (!TextUtils.isEmpty(strG)) {
                                this.f4567a = com.mbridge.msdk.c.h.a().a(new JSONObject(strG), this.f4567a);
                            }
                        }
                        this.f4567a.put("current_time", System.currentTimeMillis());
                        com.mbridge.msdk.videocommon.d.b.a().c(strK, this.f4567a.toString());
                        aVarA = com.mbridge.msdk.videocommon.d.a.a(this.f4567a.toString());
                    }
                    this.f4568b.reqSuccessful(aVarA);
                }
                com.mbridge.msdk.videocommon.d.b.a().f(strK);
                aVarA = null;
                this.f4568b.reqSuccessful(aVarA);
            } catch (Throwable th) {
                af.b("ReqRewardSettingService", th.getMessage());
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.a.b.a
    public final void a(Object obj, com.mbridge.msdk.newreward.a.b.b bVar) throws IOException {
        int iD;
        if (obj == null) {
            com.google.gson.internal.a.m("ReqRewardSettingService doReq: params is null");
            return;
        }
        com.mbridge.msdk.newreward.function.f.d dVar = (com.mbridge.msdk.newreward.function.f.d) obj;
        dVar.b(com.mbridge.msdk.newreward.function.c.b.h.f4710a);
        if (com.mbridge.msdk.videocommon.d.b.a().d()) {
            return;
        }
        com.mbridge.msdk.videocommon.d.b.a().a(true);
        try {
            com.mbridge.msdk.videocommon.d.a aVarE = com.mbridge.msdk.videocommon.d.b.a().e();
            dVar.b(aVarE == null ? "" : aVarE.a());
        } catch (Throwable th) {
            af.b("ReqRewardSettingService", th.getMessage());
        }
        try {
            String str = com.mbridge.msdk.foundation.same.net.e.d.f().f3747r ? com.mbridge.msdk.foundation.same.net.e.d.f().J : com.mbridge.msdk.foundation.same.net.e.d.f().I;
            if (com.mbridge.msdk.foundation.same.net.e.d.f().f3747r) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uri", str);
                jSONObject.put(DataSchemeDataSource.SCHEME_DATA, dVar.d());
                com.mbridge.msdk.foundation.same.net.e.a().a(com.mbridge.msdk.foundation.same.net.e.d.f().f3741l, com.mbridge.msdk.foundation.same.net.e.d.f().f3745p, jSONObject.toString(), true, new c(bVar));
                return;
            }
            com.mbridge.msdk.newreward.function.c.b.h hVar = new com.mbridge.msdk.newreward.function.c.b.h(str);
            hVar.a(dVar.c());
            hVar.a((com.mbridge.msdk.newreward.function.c.b.e) new c(bVar));
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
    public static final class c implements com.mbridge.msdk.foundation.same.net.b<JSONObject>, com.mbridge.msdk.newreward.function.c.b.e {

        /* renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.b.b f4569a;

        public c(com.mbridge.msdk.newreward.a.b.b bVar) {
            this.f4569a = bVar;
        }

        @Override // com.mbridge.msdk.newreward.function.c.b.e
        public final void a(u<JSONObject> uVar, com.mbridge.msdk.newreward.function.c.b.d dVar) {
            com.mbridge.msdk.videocommon.d.b.a().a(false);
            MBridgeTaskManager.commonExecute(new a(new com.mbridge.msdk.foundation.c.b(880002, dVar.a()), this.f4569a));
        }

        @Override // com.mbridge.msdk.foundation.same.net.b
        public final void onError(com.mbridge.msdk.foundation.same.net.a.a aVar) {
            com.mbridge.msdk.videocommon.d.b.a().a(false);
            MBridgeTaskManager.commonExecute(new a(new com.mbridge.msdk.foundation.c.b(880002, aVar.getMessage()), this.f4569a));
        }

        @Override // com.mbridge.msdk.foundation.same.net.b
        public final void onSuccess(com.mbridge.msdk.foundation.same.net.d<JSONObject> dVar) {
            com.mbridge.msdk.videocommon.d.b.a().a(false);
            MBridgeTaskManager.commonExecute(new b(dVar.f3709c, this.f4569a));
        }

        @Override // com.mbridge.msdk.newreward.function.c.b.e
        public final void a(JSONObject jSONObject, u<JSONObject> uVar) {
            com.mbridge.msdk.videocommon.d.b.a().a(false);
            MBridgeTaskManager.commonExecute(new b(jSONObject, this.f4569a));
        }
    }
}

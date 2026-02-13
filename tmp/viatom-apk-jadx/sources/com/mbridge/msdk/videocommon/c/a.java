package com.mbridge.msdk.videocommon.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.same.net.f.d;
import com.mbridge.msdk.foundation.same.net.f.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6493a = "com.mbridge.msdk.videocommon.c.a";

    public final void a(Context context, final String str, String str2, String str3, final c cVar) {
        e eVar = new e();
        eVar.a(MBridgeConstans.APP_ID, str);
        eVar.a("sign", SameMD5.getMD5(str + str2));
        eVar.a("unit_ids", "[" + str3 + "]");
        try {
            com.mbridge.msdk.videocommon.d.c cVarF = com.mbridge.msdk.videocommon.d.b.a().f(str, str3);
            if (cVarF == null) {
                eVar.a("vtag", "");
            } else {
                String strJ = cVarF.j();
                if (TextUtils.isEmpty(strJ)) {
                    strJ = "";
                }
                eVar.a("vtag", strJ);
            }
        } catch (Throwable th) {
            af.b(f6493a, th.getMessage());
        }
        d dVar = new d() { // from class: com.mbridge.msdk.videocommon.c.a.2
            @Override // com.mbridge.msdk.foundation.same.net.f.d
            public final void a(final JSONObject jSONObject) {
                try {
                    try {
                        com.mbridge.msdk.videocommon.d.b.a().b(this.unitId);
                    } catch (Exception e) {
                        af.b(a.f6493a, e.getMessage());
                    }
                    if (ak.a(jSONObject)) {
                        if (jSONObject.optInt("vtag_status", 0) == 1) {
                            String strE = com.mbridge.msdk.videocommon.d.b.a().e(str, this.unitId);
                            if (!TextUtils.isEmpty(strE)) {
                                try {
                                    jSONObject = h.a().a(new JSONObject(strE), jSONObject);
                                } catch (Exception e3) {
                                    af.b(a.f6493a, e3.getMessage());
                                }
                            }
                        }
                        if (com.mbridge.msdk.videocommon.d.b.e(jSONObject.toString())) {
                            jSONObject.put("current_time", System.currentTimeMillis());
                            Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.videocommon.c.a.2.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    com.mbridge.msdk.videocommon.d.b bVarA = com.mbridge.msdk.videocommon.d.b.a();
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    bVarA.a(str, anonymousClass2.unitId, jSONObject.toString());
                                }
                            };
                            com.mbridge.msdk.foundation.controller.d.a();
                            com.mbridge.msdk.foundation.same.f.a.b().execute(runnable);
                            c cVar2 = cVar;
                            if (cVar2 != null) {
                                cVar2.a("request success");
                            }
                        } else {
                            c cVar3 = cVar;
                            if (cVar3 != null) {
                                cVar3.b("data error");
                            }
                        }
                    } else {
                        com.mbridge.msdk.videocommon.d.b.a().d(str, this.unitId);
                    }
                    a.this.a(1, 3, "");
                } catch (Throwable th2) {
                    af.b(a.f6493a, th2.getMessage());
                }
            }

            @Override // com.mbridge.msdk.foundation.same.net.f.d
            public final void a(String str4) {
                try {
                    com.mbridge.msdk.videocommon.d.b.a().b(this.unitId);
                } catch (Exception e) {
                    af.b(a.f6493a, e.getMessage());
                }
                boolean zIsEmpty = TextUtils.isEmpty(str4);
                c cVar2 = cVar;
                if (zIsEmpty) {
                    if (cVar2 != null) {
                        cVar2.b("request error");
                    }
                } else if (cVar2 != null) {
                    cVar2.b(str4);
                }
                a.this.a(2, 3, str4);
            }
        };
        dVar.setUnitId(str3);
        new b(context).get(1, com.mbridge.msdk.foundation.same.net.e.d.f().I, eVar, dVar, "setting", ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
        a(3, 3, "");
    }

    public final void a(Context context, final String str, String str2) {
        e eVar = new e();
        eVar.a(MBridgeConstans.APP_ID, str);
        eVar.a("sign", SameMD5.getMD5(str + str2));
        try {
            com.mbridge.msdk.videocommon.d.a aVarE = com.mbridge.msdk.videocommon.d.b.a().e();
            if (aVarE == null) {
                eVar.a("vtag", "");
            } else {
                String strA = aVarE.a();
                if (TextUtils.isEmpty(strA)) {
                    strA = "";
                }
                eVar.a("vtag", strA);
            }
        } catch (Throwable th) {
            af.b(f6493a, th.getMessage());
        }
        new b(context).get(1, com.mbridge.msdk.foundation.same.net.e.d.f().I, eVar, new d() { // from class: com.mbridge.msdk.videocommon.c.a.1
            @Override // com.mbridge.msdk.foundation.same.net.f.d
            public final void a(JSONObject jSONObject) {
                try {
                    if (ak.a(jSONObject)) {
                        com.mbridge.msdk.videocommon.d.b.a().a(false);
                        if (jSONObject.optInt("vtag_status", 0) == 1) {
                            String strG = com.mbridge.msdk.videocommon.d.b.a().g(str);
                            if (!TextUtils.isEmpty(strG)) {
                                try {
                                    jSONObject = h.a().a(new JSONObject(strG), jSONObject);
                                } catch (Exception e) {
                                    af.b(a.f6493a, e.getMessage());
                                }
                            }
                        }
                        try {
                            jSONObject.put("current_time", System.currentTimeMillis());
                            com.mbridge.msdk.videocommon.d.b.a().c(str, jSONObject.toString());
                        } catch (JSONException e3) {
                            af.b(a.f6493a, e3.getMessage());
                        }
                    } else {
                        com.mbridge.msdk.videocommon.d.b.a().f(str);
                    }
                    a.this.a(1, 2, "");
                } catch (Throwable th2) {
                    af.b(a.f6493a, th2.getMessage());
                }
            }

            @Override // com.mbridge.msdk.foundation.same.net.f.d
            public final void a(String str3) {
                com.mbridge.msdk.videocommon.d.b.a().a(false);
                af.b(a.f6493a, str3);
                a.this.a(2, 2, str3);
            }
        }, "setting", ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
        a(3, 2, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10, int i11, String str) {
        try {
            com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
            eVar.a("key", "2000112");
            eVar.a("st_net", Integer.valueOf(com.mbridge.msdk.foundation.same.net.e.d.f().f3748s));
            eVar.a("result", Integer.valueOf(i10));
            eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(i11));
            eVar.a("url", com.mbridge.msdk.foundation.same.net.e.d.f().f3747r ? com.mbridge.msdk.foundation.same.net.e.d.f().J : com.mbridge.msdk.foundation.same.net.e.d.f().I);
            eVar.a("reason", str);
            cVar.a("2000112", eVar);
            com.mbridge.msdk.foundation.same.report.d.d.a().a("2000112", cVar);
        } catch (Throwable th) {
            af.b(f6493a, th.getMessage());
        }
    }
}

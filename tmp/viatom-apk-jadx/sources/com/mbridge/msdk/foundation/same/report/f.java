package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.tools.af;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static volatile f f3861a;

    /* renamed from: b, reason: collision with root package name */
    private volatile com.mbridge.msdk.tracker.m f3862b;

    public final void a(Context context, String str, String str2, String str3, String str4, int i10) throws JSONException {
        com.mbridge.msdk.tracker.m mVarD = a().d();
        if (mVarD == null) {
            return;
        }
        if (!mVarD.a("2000105")) {
            af.a("MetricsReportUtil", "reportClickImpException can not track");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (TextUtils.isEmpty(str2)) {
                jSONObject.put("url", "");
            } else {
                jSONObject.put("url", URLEncoder.encode(str2, "utf-8"));
            }
            jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, i10);
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("rid", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("rid_n", str4);
            }
            try {
                long[] jArrH = mVarD.h();
                jSONObject.put("track_time", jArrH[0]);
                jSONObject.put("track_count", jArrH[1]);
                jSONObject.put("session_id", mVarD.b());
            } catch (Exception unused) {
            }
            jSONObject.put("reason", URLEncoder.encode(str, "utf-8"));
            com.mbridge.msdk.tracker.e eVar = new com.mbridge.msdk.tracker.e("2000105");
            eVar.a(jSONObject);
            eVar.b(0);
            eVar.a(0);
            eVar.a(c.c());
            mVarD.a(eVar);
        } catch (Exception e) {
            af.b("MetricsReportUtil", e.getMessage());
        }
    }

    public final void b() {
        if (this.f3862b != null) {
            this.f3862b.f();
        }
    }

    public final void c() {
        d().f();
    }

    public final com.mbridge.msdk.tracker.m d() {
        if (this.f3862b == null) {
            this.f3862b = com.mbridge.msdk.foundation.same.report.d.d.a().c();
        }
        return this.f3862b;
    }

    public static f a() {
        if (f3861a == null) {
            synchronized (f.class) {
                try {
                    if (f3861a == null) {
                        f3861a = new f();
                    }
                } finally {
                }
            }
        }
        return f3861a;
    }
}

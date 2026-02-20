package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.af;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f3873a;

    /* renamed from: b, reason: collision with root package name */
    private final String f3874b;

    private k(a aVar) {
        this.f3874b = aVar.f3876b;
        this.f3873a = aVar.f3875a;
    }

    private void a(Map<String, String> map, JSONObject jSONObject) throws JSONException {
        if (map == null || map.isEmpty() || jSONObject == null) {
            return;
        }
        try {
            for (String str : map.keySet()) {
                jSONObject.put(str, b(map.get(str)));
            }
        } catch (Exception e) {
            af.b("SameCommonReporter", e.getMessage());
        }
    }

    private String b(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception unused) {
            return str;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Map<String, String> f3875a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        private final String f3876b;

        public a(String str) {
            this.f3876b = str;
        }

        public final k a() {
            return new k(this);
        }
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(this.f3874b)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", this.f3874b);
            a(this.f3873a, jSONObject);
            com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
        } catch (Throwable th) {
            af.b("SameCommonReporter", th.getMessage());
        }
    }
}

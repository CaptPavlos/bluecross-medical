package com.mbridge.msdk.foundation.db.a;

import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.k;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.a.a f3444a;

    /* renamed from: b, reason: collision with root package name */
    private k f3445b;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static b f3449a = new b();
    }

    private b() {
        this.f3444a = new com.mbridge.msdk.foundation.same.a.a(1000);
        try {
            k kVarA = k.a(g.a(c.m().c()));
            this.f3445b = kVarA;
            a(kVarA.a(), false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(JSONObject jSONObject, final boolean z9) {
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            final com.mbridge.msdk.foundation.same.a.a aVar = new com.mbridge.msdk.foundation.same.a.a(100);
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                this.f3444a.a(next, jSONObjectOptJSONObject);
                aVar.a(next, jSONObjectOptJSONObject);
            }
            com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.db.a.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (!z9 || b.this.f3445b == null) {
                        return;
                    }
                    for (String str : aVar.a()) {
                        b.this.f3445b.a(str, b.this.f3444a.a(str));
                    }
                }
            });
        }
    }

    public final JSONArray b() {
        return new JSONArray((Collection) this.f3444a.a());
    }

    public static b a() {
        return a.f3449a;
    }

    public final JSONObject a(String str) {
        k kVar;
        JSONObject jSONObjectA = this.f3444a.a(str);
        if (jSONObjectA != null || (kVar = this.f3445b) == null) {
            return jSONObjectA;
        }
        JSONObject jSONObjectA2 = kVar.a(str);
        if (jSONObjectA2 != null) {
            this.f3444a.a(str, jSONObjectA2);
        }
        return jSONObjectA2;
    }
}

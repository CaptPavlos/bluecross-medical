package com.mbridge.msdk.mbsignalcommon.a;

import android.content.Context;
import android.util.Base64;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.af;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static final String f4308c = "a";

    /* renamed from: a, reason: collision with root package name */
    int f4309a = 0;

    /* renamed from: b, reason: collision with root package name */
    int f4310b = 1;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.mbsignalcommon.a.a$a, reason: collision with other inner class name */
    public static final class C0036a {

        /* renamed from: a, reason: collision with root package name */
        private static a f4311a = new a();
    }

    public final void a(Object obj, String str, JSONArray jSONArray, int i10) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3;
        JSONObject jSONObjectOptJSONObject4;
        JSONObject jSONObjectOptJSONObject5;
        JSONObject jSONObjectOptJSONObject6;
        JSONObject jSONObjectOptJSONObject7;
        JSONObject jSONObjectOptJSONObject8;
        JSONObject jSONObjectOptJSONObject9;
        JSONObject jSONObjectOptJSONObject10;
        JSONObject jSONObjectOptJSONObject11;
        int i11;
        try {
            if (jSONArray == null) {
                a(this.f4310b, "called reporter failed, params empty", obj);
                return;
            }
            int length = jSONArray.length();
            if (length == 0) {
                a(this.f4310b, "called reporter failed, params empty", obj);
                return;
            }
            int i12 = 0;
            if ("reportMessageR".equalsIgnoreCase(str)) {
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    i11 = length - 1;
                    if (i12 >= i11) {
                        break;
                    }
                    JSONObject jSONObjectOptJSONObject12 = jSONArray.optJSONObject(i12);
                    if (jSONObjectOptJSONObject12 != null) {
                        stringBuffer.append(jSONObjectOptJSONObject12.optString("key"));
                        stringBuffer.append("=");
                        stringBuffer.append(jSONObjectOptJSONObject12.opt("value"));
                        stringBuffer.append("&");
                    }
                    i12++;
                }
                JSONObject jSONObjectOptJSONObject13 = jSONArray.optJSONObject(i11);
                if (jSONObjectOptJSONObject13 != null) {
                    stringBuffer.append(jSONObjectOptJSONObject13.optString("key"));
                    stringBuffer.append("=");
                    stringBuffer.append(jSONObjectOptJSONObject13.opt("value"));
                }
                d.a().c(stringBuffer.toString());
            } else if ("reportMessageD".equalsIgnoreCase(str)) {
                String string = (length <= 0 || (jSONObjectOptJSONObject11 = jSONArray.optJSONObject(0)) == null) ? "" : jSONObjectOptJSONObject11.getString("value");
                int i13 = (length <= 1 || (jSONObjectOptJSONObject10 = jSONArray.optJSONObject(1)) == null) ? -1 : jSONObjectOptJSONObject10.getInt("value");
                int i14 = (length <= 2 || (jSONObjectOptJSONObject9 = jSONArray.optJSONObject(2)) == null) ? -1 : jSONObjectOptJSONObject9.getInt("value");
                int i15 = (length <= 3 || (jSONObjectOptJSONObject8 = jSONArray.optJSONObject(3)) == null) ? -1 : jSONObjectOptJSONObject8.getInt("value");
                int i16 = (length <= 4 || (jSONObjectOptJSONObject7 = jSONArray.optJSONObject(4)) == null) ? -1 : jSONObjectOptJSONObject7.getInt("value");
                String string2 = (length <= 5 || (jSONObjectOptJSONObject6 = jSONArray.optJSONObject(5)) == null) ? "" : jSONObjectOptJSONObject6.getString("value");
                String string3 = (length <= 6 || (jSONObjectOptJSONObject5 = jSONArray.optJSONObject(6)) == null) ? "" : jSONObjectOptJSONObject5.getString("value");
                int i17 = (length <= 7 || (jSONObjectOptJSONObject4 = jSONArray.optJSONObject(7)) == null) ? -1 : jSONObjectOptJSONObject4.getInt("value");
                String string4 = (length <= 8 || (jSONObjectOptJSONObject3 = jSONArray.optJSONObject(8)) == null) ? "" : jSONObjectOptJSONObject3.getString("value");
                int i18 = (length <= 9 || (jSONObjectOptJSONObject2 = jSONArray.optJSONObject(9)) == null) ? -1 : jSONObjectOptJSONObject2.getInt("value");
                String string5 = (length <= 10 || (jSONObjectOptJSONObject = jSONArray.optJSONObject(10)) == null) ? "" : jSONObjectOptJSONObject.getString("value");
                try {
                    Context contextC = c.m().c();
                    if (contextC != null) {
                        o.a(g.a(contextC)).a(new n(string, i13, i14, i15, i16, string2, string3, i17, string4, i18, string5));
                    }
                } catch (Throwable th) {
                    af.a(f4308c, th.getMessage());
                }
            }
            a(this.f4309a, "called reporter success", obj);
        } catch (Throwable th2) {
            af.a(f4308c, th2.getMessage());
            a(this.f4310b, "exception: " + th2.getMessage(), obj);
        }
    }

    public static a a() {
        return C0036a.f4311a;
    }

    private void a(int i10, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i10);
            jSONObject.put("message", str);
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e) {
            af.a(f4308c, e.getMessage());
        } catch (Throwable th) {
            af.a(f4308c, th.getMessage());
        }
    }
}

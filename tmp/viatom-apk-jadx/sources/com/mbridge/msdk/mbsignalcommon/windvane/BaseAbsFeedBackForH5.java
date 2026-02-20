package com.mbridge.msdk.mbsignalcommon.windvane;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class BaseAbsFeedBackForH5 extends h {
    private static int e = 0;
    private static int f = 1;

    /* renamed from: a, reason: collision with root package name */
    private String f4391a = "AbsFeedBackForH5";

    public void callbackExcep(Object obj, String str) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f);
            jSONObject.put("message", str);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e3) {
            af.a(this.f4391a, e3.getMessage());
        }
    }

    public void callbackSuccess(Object obj) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", e);
            jSONObject.put("message", "");
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e3) {
            callbackExcep(obj, e3.getMessage());
            af.a(this.f4391a, e3.getMessage());
        }
    }

    public void callbackSuccessWithData(Object obj, JSONObject jSONObject) throws JSONException {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", e);
            jSONObject2.put("message", "");
            jSONObject2.put(DataSchemeDataSource.SCHEME_DATA, jSONObject);
            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Exception e3) {
            callbackExcep(obj, e3.getMessage());
            af.a(this.f4391a, e3.getMessage());
        }
    }

    public void feedbackLayoutOperate(Object obj, String str) throws JSONException {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("width", -1);
                int iOptInt2 = jSONObject.optInt("height", -1);
                int iOptInt3 = jSONObject.optInt(TtmlNode.LEFT, -1);
                int iOptInt4 = jSONObject.optInt("top", -1);
                double dOptDouble = jSONObject.optDouble("opacity", 1.0d);
                int iOptInt5 = jSONObject.optInt("radius", 20);
                String strOptString = jSONObject.optString("fontColor", "");
                String strOptString2 = jSONObject.optString("bgColor", "");
                com.mbridge.msdk.foundation.d.b.a().a(jSONObject.optString("key", ""), iOptInt, iOptInt2, iOptInt5, iOptInt3, iOptInt4, (float) dOptDouble, strOptString, strOptString2, (float) jSONObject.optDouble(TtmlNode.ATTR_TTS_FONT_SIZE, -1.0d), jSONObject.optJSONArray("padding"));
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void feedbackOperate(Object obj, String str) throws JSONException {
        try {
            if (!TextUtils.isEmpty(str)) {
                a aVar = (a) obj;
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("view_visible", 1);
                com.mbridge.msdk.foundation.d.b.a().a(jSONObject.optString("key", ""), iOptInt == 1 ? 8 : 0, aVar.f4406b);
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void feedbackPopupOperate(Object obj, String str) throws JSONException {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("view_visible", 1);
                String strOptString = jSONObject.optString("key", "");
                final WindVaneWebView windVaneWebView = ((a) obj).f4406b;
                com.mbridge.msdk.foundation.d.b.a().a(strOptString, iOptInt, new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.mbsignalcommon.windvane.BaseAbsFeedBackForH5.1
                    @Override // com.mbridge.msdk.foundation.d.a
                    public final void close() {
                        String string;
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                                jSONObject2.put(NotificationCompat.CATEGORY_STATUS, 2);
                            }
                            string = jSONObject2.toString();
                        } catch (Throwable th) {
                            af.b(BaseAbsFeedBackForH5.this.f4391a, th.getMessage(), th);
                            string = "";
                        }
                        g.a().a((WebView) windVaneWebView, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                    }

                    @Override // com.mbridge.msdk.foundation.d.a
                    public final void showed() {
                        String string;
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                                jSONObject2.put(NotificationCompat.CATEGORY_STATUS, 1);
                            }
                            string = jSONObject2.toString();
                        } catch (Throwable th) {
                            af.b(BaseAbsFeedBackForH5.this.f4391a, th.getMessage(), th);
                            string = "";
                        }
                        g.a().a((WebView) windVaneWebView, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                    }

                    @Override // com.mbridge.msdk.foundation.d.a
                    public final void summit(String str2) {
                        String string;
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                                jSONObject2.put(NotificationCompat.CATEGORY_STATUS, 2);
                            }
                            string = jSONObject2.toString();
                        } catch (Throwable th) {
                            af.b(BaseAbsFeedBackForH5.this.f4391a, th.getMessage(), th);
                            string = "";
                        }
                        g.a().a((WebView) windVaneWebView, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                    }
                });
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }
}

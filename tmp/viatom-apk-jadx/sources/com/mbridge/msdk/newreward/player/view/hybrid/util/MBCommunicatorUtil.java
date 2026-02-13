package com.mbridge.msdk.newreward.player.view.hybrid.util;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.analyzer.a;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.player.view.hybrid.MBWebView;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBCommunicatorUtil {
    public static final String TAG = "MBCommunicatorUtil";

    public static void callException(WebView webView, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 1);
            jSONObject.put("message", str2);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
            callSuccess(webView, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }

    public static void callFailure(WebView webView, String str, String str2) {
        String strX;
        if (TextUtils.isEmpty(str2)) {
            strX = a.x("javascript:window.WindVane.onFailure(", str, ",'');");
        } else {
            strX = "javascript:window.WindVane.onFailure(" + str + ",'" + MBHybridUtil.convert2Unicode(str2) + "');";
        }
        if (webView != null) {
            evaluateJavascript(webView, strX);
        }
    }

    public static void callSuccess(WebView webView, String str, String str2) {
        String strX;
        if (TextUtils.isEmpty(str2)) {
            strX = a.x("javascript:window.WindVane.onSuccess(", str, ",'');");
        } else {
            strX = "javascript:window.WindVane.onSuccess(" + str + ",'" + MBHybridUtil.convert2Unicode(str2) + "');";
        }
        if (webView != null) {
            evaluateJavascript(webView, strX);
        }
    }

    public static void evaluateJavascript(WebView webView, String str) {
        if (webView == null) {
            return;
        }
        try {
            if ((webView instanceof MBWebView) && ((MBWebView) webView).isDestroyed()) {
                return;
            }
            webView.evaluateJavascript(str, new ValueCallback<String>() { // from class: com.mbridge.msdk.newreward.player.view.hybrid.util.MBCommunicatorUtil.1
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(String str2) {
                }
            });
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }

    public static void fireEvent(WebView webView, String str, String str2) {
        String strX;
        if (TextUtils.isEmpty(str2)) {
            strX = a.x("javascript:window.WindVane.fireEvent('", str, "', '');");
        } else {
            strX = "javascript:window.WindVane.fireEvent('" + str + "','" + MBHybridUtil.convert2Unicode(str2) + "');";
        }
        if (webView != null) {
            evaluateJavascript(webView, strX);
        }
    }

    public static void notifyClick(WebView webView, int i10, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, i10);
            jSONObject.put("pt", str);
            fireEvent(webView, "onJSClick", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }

    public static void notifyNotchData(WebView webView, String str) {
        try {
            if (TextUtils.isEmpty(str) || webView == null) {
                return;
            }
            fireEvent(webView, "oncutoutfetched", Base64.encodeToString(str.getBytes(), 2));
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }

    public static void notifyShowDataInfo(WebView webView, int i10, int i11) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            str = "landscape";
            if (i10 == 2) {
                jSONObject2.put("orientation", i11 == 1 ? "portrait" : "landscape");
            } else {
                if (i11 != 2) {
                    str = "portrait";
                }
                jSONObject2.put("orientation", str);
            }
            jSONObject2.put("screen_width", ak.j(webView.getContext()));
            jSONObject2.put("screen_height", ak.i(webView.getContext()));
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
            fireEvent(webView, "showDataInfo", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }

    public static void notifyVideoProgress(WebView webView, int i10, int i11) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("progress", (int) (i10 / i11));
            jSONObject.put("time", String.valueOf(i10));
            jSONObject.put(TypedValues.TransitionType.S_DURATION, String.valueOf(i11));
            fireEvent(webView, "onVideoProgressNotify", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }

    public static void notifyVideoStatus(WebView webView, int i10) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, i10);
            fireEvent(webView, "onVideoStatusNotify", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }

    public static void notifyWebViewShowed(WebView webView, String str, String str2) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", str);
            fireEvent(webView, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
        try {
            webView.getLocationOnScreen(new int[2]);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("startX", ak.b(webView.getContext(), r1[0]));
            jSONObject2.put("startY", ak.b(webView.getContext(), r1[1]));
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f3608l, ak.d(webView.getContext()));
            if (TextUtils.isEmpty(str2)) {
                JSONObject jSONObject3 = new JSONObject(str2);
                if (jSONObject3.length() > 0) {
                    Iterator<String> itKeys = jSONObject3.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject2.put(next, jSONObject3.get(next));
                    }
                }
            }
            fireEvent(webView, "webviewshow", Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
        MRAIDCommunicatorUtil.notifyMRAIDEnvironmentChange(webView, str);
    }
}

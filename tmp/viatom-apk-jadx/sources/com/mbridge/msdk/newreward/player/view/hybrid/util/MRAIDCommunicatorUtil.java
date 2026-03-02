package com.mbridge.msdk.newreward.player.view.hybrid.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.constraintlayout.core.widgets.analyzer.a;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MRAIDCommunicatorUtil {
    public static final String KEY_CURRENTORIENTATION = "currentAppOrientation";
    public static final String KEY_PLACEMENTTYPE = "placementType";
    public static final String KEY_STATE = "state";
    public static final String KEY_VIEWABLE = "viewable";
    public static final String PLACEMENT_INLINE = "inline";
    public static final String PLACEMENT_INTERSTITIAL = "Interstitial";
    public static final String STATES_DEFAULT = "default";
    public static final String STATES_EXPANDED = "expanded";
    public static final String STATES_HIDDEN = "hidden";
    public static final String STATES_LOADING = "loading";
    public static final String STATES_RESIZED = "resized";
    private static final String TAG = "MRAIDCommunicatorUtil";

    private static void call(WebView webView, String str) {
        if (webView != null) {
            try {
                webView.evaluateJavascript(str, new ValueCallback<String>() { // from class: com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil.1
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(String str2) {
                    }
                });
            } catch (Throwable th) {
                af.b(TAG, th.getMessage());
            }
        }
    }

    public static void fireAudioVolumeChange(WebView webView, double d8) {
        Locale locale = Locale.CHINA;
        call(webView, "javascript:window.mraidbridge.audioVolumeChange(" + d8 + ");");
    }

    public static void fireChangeEventForProperties(WebView webView, Map<String, Object> map) throws JSONException {
        if (map == null || map.size() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (Exception e) {
                af.b(TAG, e.getMessage());
            }
        }
        call(webView, a.x("javascript:window.mraidbridge.fireChangeEvent(", jSONObject.toString(), ");"));
    }

    public static void fireErrorEvent(WebView webView, String str, String str2) {
        call(webView, String.format("javascript:window.mraidbridge.fireErrorEvent('%1s', '%2s');", str2, str));
    }

    public static void fireNativeMethodCompleteEvent(WebView webView, String str) {
        call(webView, a.x("javascript:window.mraidbridge.nativeCallComplete('", str, "');"));
    }

    public static void fireReadyEvent(WebView webView) {
        call(webView, "javascript:window.mraidbridge.fireReadyEvent();");
    }

    public static void fireSetCurrentPosition(WebView webView, float f, float f10, float f11, float f12) {
        call(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setCurrentPosition(%.1f, %.1f, %.1f, %.1f);", Float.valueOf(f), Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(f12)));
    }

    public static void fireSetDefaultPosition(WebView webView, float f, float f10, float f11, float f12) {
        call(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setDefaultPosition(%.1f, %.1f, %.1f, %.1f);", Float.valueOf(f), Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(f12)));
    }

    public static void fireSetIsViewable(WebView webView, String str) {
        call(webView, a.x("javascript:window.mraidbridge.setIsViewable(", str, ");"));
    }

    public static void fireSetMaxSize(WebView webView, float f, float f10) {
        call(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setMaxSize(%.1f, %.1f);", Float.valueOf(f), Float.valueOf(f10)));
    }

    public static void fireSetPlacementType(WebView webView, String str) {
        call(webView, a.x("javascript:window.mraidbridge.setPlacementType(", str, ");"));
    }

    public static void fireSetScreenSize(WebView webView, float f, float f10) {
        call(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setScreenSize(%.1f, %.1f);", Float.valueOf(f), Float.valueOf(f10)));
    }

    public static void fireSizeChangeEvent(WebView webView, float f, float f10) {
        call(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.notifySizeChangeEvent(%.1f, %.1f);", Float.valueOf(f), Float.valueOf(f10)));
    }

    public static void notifyMRAIDEnvironmentChange(WebView webView, String str) {
        if (webView == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", str);
            jSONObject.put("locked", "true");
            HashMap map = new HashMap();
            map.put(KEY_PLACEMENTTYPE, PLACEMENT_INTERSTITIAL);
            map.put(KEY_STATE, STATES_DEFAULT);
            map.put(KEY_VIEWABLE, "true");
            map.put(KEY_CURRENTORIENTATION, jSONObject);
            Context context = webView.getContext();
            if (context instanceof Activity) {
                float fJ = ab.j(context);
                float fH = ab.h(context);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                float f = displayMetrics.widthPixels;
                float f10 = displayMetrics.heightPixels;
                fireSetScreenSize(webView, fJ, fH);
                fireSetMaxSize(webView, f, f10);
            }
            fireSetDefaultPosition(webView, webView.getLeft(), webView.getTop(), webView.getWidth(), webView.getHeight());
            fireSetCurrentPosition(webView, webView.getLeft(), webView.getTop(), webView.getWidth(), webView.getHeight());
            fireChangeEventForProperties(webView, map);
            fireAudioVolumeChange(webView, MBHybridUtil.getCurrentVolume(context));
            fireReadyEvent(webView);
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }
}

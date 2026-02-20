package com.mbridge.msdk.mbsignalcommon.mraid;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.mraid.a;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MraidSignalCommunication extends BaseMraidSignalCommunication {

    /* renamed from: a, reason: collision with root package name */
    private b f4378a;

    public void close(Object obj, String str) throws UnsupportedEncodingException {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.C0039a.f4379a.a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b, CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
        }
        try {
            af.b("MraidSignalCommunication", "MRAID close");
            b bVar = this.f4378a;
            if (bVar != null) {
                bVar.close();
            }
        } catch (Throwable th) {
            af.b("MraidSignalCommunication", "MRAID close", th);
        }
    }

    public void expand(Object obj, String str) throws UnsupportedEncodingException {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.C0039a.f4379a.a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b, "expand");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("url");
            String strOptString2 = jSONObject.optString("shouldUseCustomClose");
            af.b("MraidSignalCommunication", "MRAID expand " + strOptString + " " + strOptString2);
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || this.f4378a == null) {
                return;
            }
            this.f4378a.expand(strOptString, strOptString2.toLowerCase().equals("true"));
        } catch (Throwable th) {
            af.b("MraidSignalCommunication", "MRAID expand", th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.mbridge.msdk.mbsignalcommon.windvane.h
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (context instanceof b) {
                this.f4378a = (b) context;
                return;
            }
            if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof b)) {
                this.f4378a = (b) windVaneWebView.getObject();
            }
            if (windVaneWebView.getMraidObject() == null || !(windVaneWebView.getMraidObject() instanceof b)) {
                return;
            }
            this.f4378a = (b) windVaneWebView.getMraidObject();
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void open(Object obj, String str) throws UnsupportedEncodingException {
        WindVaneWebView windVaneWebView;
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
            windVaneWebView = aVar.f4406b;
            a.C0039a.f4379a.a(aVar.f4406b, "open");
        } else {
            windVaneWebView = null;
        }
        try {
            String strOptString = new JSONObject(str).optString("url");
            af.b("MraidSignalCommunication", "MRAID Open " + strOptString);
            if (this.f4378a == null || TextUtils.isEmpty(strOptString)) {
                return;
            }
            if (windVaneWebView == null || System.currentTimeMillis() - windVaneWebView.lastTouchTime <= com.mbridge.msdk.click.b.a.f2793c || !com.mbridge.msdk.click.b.a.a(this.f4378a.getMraidCampaign(), windVaneWebView.getUrl(), com.mbridge.msdk.click.b.a.f2791a)) {
                this.f4378a.open(strOptString);
            }
        } catch (Throwable th) {
            af.b("MraidSignalCommunication", "MRAID Open", th);
        }
    }

    public void setOrientationProperties(Object obj, String str) throws UnsupportedEncodingException {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.C0039a.f4379a.a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b, "setOrientationProperties");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("allowOrientationChange");
            String strOptString2 = jSONObject.optString("forceOrientation");
            af.b("MraidSignalCommunication", "MRAID setOrientationProperties");
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || this.f4378a == null) {
                return;
            }
            strOptString.toLowerCase().equals("true");
            String lowerCase = strOptString2.toLowerCase();
            int iHashCode = lowerCase.hashCode();
            if (iHashCode == 729267099) {
                lowerCase.equals("portrait");
            } else {
                if (iHashCode != 1430647483) {
                    return;
                }
                lowerCase.equals("landscape");
            }
        } catch (Throwable th) {
            af.b("MraidSignalCommunication", "MRAID setOrientationProperties", th);
        }
    }

    public void unload(Object obj, String str) throws UnsupportedEncodingException {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.C0039a.f4379a.a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b, "unload");
        }
        try {
            af.b("MraidSignalCommunication", "MRAID unload");
            b bVar = this.f4378a;
            if (bVar != null) {
                bVar.unload();
            }
        } catch (Throwable th) {
            af.b("MraidSignalCommunication", "MRAID unload", th);
        }
    }

    public void useCustomClose(Object obj, String str) throws UnsupportedEncodingException {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.C0039a.f4379a.a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b, "useCustomClose");
        }
        try {
            String strOptString = new JSONObject(str).optString("shouldUseCustomClose");
            af.b("MraidSignalCommunication", "MRAID useCustomClose " + strOptString);
            if (TextUtils.isEmpty(strOptString) || this.f4378a == null) {
                return;
            }
            this.f4378a.useCustomClose(strOptString.toLowerCase().equals("true"));
        } catch (Throwable th) {
            af.b("MraidSignalCommunication", "MRAID useCustomClose", th);
        }
    }
}

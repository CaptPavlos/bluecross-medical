package com.mbridge.msdk.video.signal.communication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbsignalcommon.communication.d;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class BaseRewardSignalH5 extends a {

    /* renamed from: a, reason: collision with root package name */
    protected IJSFactory f6172a;

    private String a(int i10) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i10);
            String string = jSONObject.toString();
            return !TextUtils.isEmpty(string) ? Base64.encodeToString(string.getBytes(), 2) : "";
        } catch (Throwable unused) {
            af.b("JS-Reward-Communication", "code to string is error");
            return "";
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void cai(Object obj, String str) throws JSONException {
        af.a("JS-Reward-Communication", "cai:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                String strOptString = new JSONObject(str).optString("packageName");
                if (TextUtils.isEmpty(strOptString)) {
                    d.a(obj, "packageName is empty");
                }
                int i10 = ak.c(c.m().c(), strOptString) ? 1 : 2;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", d.f4375b);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", i10);
                    jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                    g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e) {
                    d.a(obj, e.getMessage());
                    af.a("JS-Reward-Communication", e.getMessage());
                }
            } catch (Throwable th) {
                d.a(obj, "exception: " + th.getLocalizedMessage());
                af.b("JS-Reward-Communication", "cai", th);
            }
        } catch (JSONException e3) {
            d.a(obj, "exception: " + e3.getLocalizedMessage());
            af.b("JS-Reward-Communication", "cai", e3);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void getEndScreenInfo(Object obj, String str) {
        String strEncodeToString;
        try {
            IJSFactory iJSFactory = this.f6172a;
            if (iJSFactory != null) {
                String strA = iJSFactory.getIJSRewardVideoV1().a();
                if (TextUtils.isEmpty(strA)) {
                    strEncodeToString = "";
                    af.a("JS-Reward-Communication", "getEndScreenInfo failed");
                } else {
                    strEncodeToString = Base64.encodeToString(strA.getBytes(), 2);
                    af.a("JS-Reward-Communication", "getEndScreenInfo success");
                }
                g.a().a(obj, strEncodeToString);
            }
        } catch (Throwable th) {
            af.b("JS-Reward-Communication", "getEndScreenInfo", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void handlerPlayableException(Object obj, String str) {
        try {
            if (this.f6172a == null || TextUtils.isEmpty(str)) {
                return;
            }
            String strOptString = new JSONObject(str).optString(NotificationCompat.CATEGORY_MESSAGE);
            af.a("JS-Reward-Communication", "handlerPlayableException,msg:" + str);
            this.f6172a.getIJSRewardVideoV1().c(strOptString);
        } catch (Throwable th) {
            af.b("JS-Reward-Communication", "setOrientation", th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        if (context instanceof IJSFactory) {
            this.f6172a = (IJSFactory) context;
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void install(Object obj, String str) {
        try {
            if (this.f6172a != null) {
                af.a("JS-Reward-Communication", "install:" + str);
                boolean zEndCardShowing = this.f6172a.getJSContainerModule().endCardShowing();
                IJSFactory iJSFactory = this.f6172a;
                if (zEndCardShowing) {
                    iJSFactory.getJSCommon().click(3, str);
                } else {
                    iJSFactory.getJSCommon().click(1, str);
                }
            }
        } catch (Throwable th) {
            af.b("JS-Reward-Communication", "install", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.f6172a == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt(MRAIDCommunicatorUtil.KEY_STATE);
            af.a("JS-Reward-Communication", "notifyCloseBtn,state:" + str);
            this.f6172a.getIJSRewardVideoV1().notifyCloseBtn(iOptInt);
        } catch (Throwable th) {
            af.b("JS-Reward-Communication", "notifyCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void openURL(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        af.b("JS-Reward-Communication", "openURL:" + str);
        Context contextC = c.m().c();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (contextC == null) {
            try {
                if ((obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                    contextC = windVaneWebView.getContext();
                }
            } catch (Exception e) {
                af.b("JS-Reward-Communication", e.getMessage());
            }
        }
        if (contextC == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("url");
            int iOptInt = jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            if (iOptInt == 1) {
                com.mbridge.msdk.click.c.d(contextC, strOptString);
            } else if (iOptInt == 2) {
                com.mbridge.msdk.click.c.f(contextC, strOptString);
            }
        } catch (JSONException e3) {
            af.b("JS-Reward-Communication", e3.getMessage());
        } catch (Throwable th) {
            af.b("JS-Reward-Communication", th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void setOrientation(Object obj, String str) {
        try {
            if (this.f6172a == null || TextUtils.isEmpty(str)) {
                return;
            }
            String strOptString = new JSONObject(str).optString(MRAIDCommunicatorUtil.KEY_STATE);
            af.a("JS-Reward-Communication", "setOrientation,state:" + str);
            this.f6172a.getIJSRewardVideoV1().b(strOptString);
        } catch (Throwable th) {
            af.b("JS-Reward-Communication", "setOrientation", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.f6172a == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt(MRAIDCommunicatorUtil.KEY_STATE);
            af.a("JS-Reward-Communication", "toggleCloseBtn,state:" + str);
            this.f6172a.getIJSRewardVideoV1().toggleCloseBtn(iOptInt);
        } catch (Throwable th) {
            af.b("JS-Reward-Communication", "toggleCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void triggerCloseBtn(Object obj, String str) {
        try {
            if (this.f6172a == null || TextUtils.isEmpty(str)) {
                return;
            }
            g.a().a(obj, a(0));
            this.f6172a.getIJSRewardVideoV1().a(new JSONObject(str).optString(MRAIDCommunicatorUtil.KEY_STATE));
            af.a("JS-Reward-Communication", "triggerCloseBtn,state:" + str);
        } catch (Throwable th) {
            af.b("JS-Reward-Communication", "triggerCloseBtn", th);
            g.a().a(obj, a(-1));
        }
    }

    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        if (obj instanceof IJSFactory) {
            this.f6172a = (IJSFactory) obj;
        }
    }
}

package com.mbridge.msdk.video.signal.communication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbsignalcommon.communication.d;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class BaseRewardSignal extends BaseRewardSignalDiff {

    /* renamed from: a, reason: collision with root package name */
    protected BaseIRewardCommunication f6171a;

    private String a(int i10) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i10);
            String string = jSONObject.toString();
            return !TextUtils.isEmpty(string) ? Base64.encodeToString(string.getBytes(), 2) : "";
        } catch (Throwable unused) {
            af.b("JS-Reward-Brigde", "code to string is error");
            return "";
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void cai(Object obj, String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is null");
            return;
        }
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
                    af.a("JS-Reward-Brigde", e.getMessage());
                }
            } catch (JSONException e3) {
                d.a(obj, "exception: " + e3.getLocalizedMessage());
                af.b("JS-Reward-Brigde", "cai", e3);
            }
        } catch (Throwable th) {
            d.a(obj, "exception: " + th.getLocalizedMessage());
            af.b("JS-Reward-Brigde", "cai", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void getEndScreenInfo(Object obj, String str) {
        try {
            BaseIRewardCommunication baseIRewardCommunication = this.f6171a;
            if (baseIRewardCommunication != null) {
                baseIRewardCommunication.getEndScreenInfo(obj, str);
                af.b("JS-Reward-Brigde", "getEndScreenInfo factory is true");
                return;
            }
            af.b("JS-Reward-Brigde", "getEndScreenInfo factory is null");
            if (obj != null) {
                WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b;
                if (!(windVaneWebView != null) || windVaneWebView.getWebViewListener() == null) {
                    return;
                }
                ((com.mbridge.msdk.mbsignalcommon.b.a) windVaneWebView.getWebViewListener()).a(obj);
            }
        } catch (Throwable th) {
            af.b("JS-Reward-Brigde", "getEndScreenInfo", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void handlerPlayableException(Object obj, String str) {
        try {
            if (this.f6171a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f6171a.handlerPlayableException(obj, str);
        } catch (Throwable th) {
            af.b("JS-Reward-Brigde", "handlerPlayableException", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.h
    public void initialize(Context context, WindVaneWebView windVaneWebView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean zIsInstance;
        super.initialize(context, windVaneWebView);
        try {
            zIsInstance = IJSFactory.class.isInstance(context);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            zIsInstance = false;
        }
        try {
            if (zIsInstance) {
                this.f6171a = (BaseIRewardCommunication) BaseRewardSignalH5.class.newInstance();
                BaseRewardSignalH5.class.getMethod("initialize", Context.class, WindVaneWebView.class).invoke(this.f6171a, context, windVaneWebView);
            } else if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof BaseIRewardCommunication)) {
                this.f6171a = (BaseIRewardCommunication) windVaneWebView.getObject();
            }
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                e3.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void install(Object obj, String str) {
        try {
            BaseIRewardCommunication baseIRewardCommunication = this.f6171a;
            if (baseIRewardCommunication != null) {
                baseIRewardCommunication.install(obj, str);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (obj != null) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.f4406b.getObject() instanceof k) {
                    ((k) aVar.f4406b.getObject()).click(1, str);
                    af.b("JS-Reward-Brigde", "JSCommon install jump success");
                }
            }
            af.b("JS-Reward-Brigde", "JSCommon install failed");
        } catch (Throwable th) {
            af.b("JS-Reward-Brigde", "install", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.f6171a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f6171a.notifyCloseBtn(obj, str);
        } catch (Throwable th) {
            af.b("JS-Reward-Brigde", "notifyCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void openURL(Object obj, String str) throws JSONException {
        af.b("JS-Reward-Brigde", "openURL:" + str);
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("url");
            int iOptInt = jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            if (iOptInt == 1) {
                com.mbridge.msdk.click.c.d(this.f4422b, strOptString);
            } else if (iOptInt == 2) {
                com.mbridge.msdk.click.c.f(this.f4422b, strOptString);
            }
        } catch (JSONException e) {
            af.b("JS-Reward-Brigde", e.getMessage());
        } catch (Throwable th) {
            af.b("JS-Reward-Brigde", th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void setOrientation(Object obj, String str) {
        try {
            if (this.f6171a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f6171a.setOrientation(obj, str);
        } catch (Throwable th) {
            af.b("JS-Reward-Brigde", "setOrientation", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.f6171a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f6171a.toggleCloseBtn(obj, str);
        } catch (Throwable th) {
            af.b("JS-Reward-Brigde", "toggleCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void triggerCloseBtn(Object obj, String str) {
        try {
            if (this.f6171a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f6171a.triggerCloseBtn(obj, str);
        } catch (Throwable th) {
            af.b("JS-Reward-Brigde", "triggerCloseBtn", th);
            g.a().a(obj, a(-1));
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.h
    public void initialize(Object obj, WindVaneWebView windVaneWebView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean zIsInstance;
        super.initialize(obj, windVaneWebView);
        try {
            zIsInstance = IJSFactory.class.isInstance(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            zIsInstance = false;
        }
        try {
            if (zIsInstance) {
                this.f6171a = (BaseIRewardCommunication) BaseRewardSignalH5.class.newInstance();
                BaseRewardSignalH5.class.getMethod("initialize", Object.class, WindVaneWebView.class).invoke(this.f6171a, obj, windVaneWebView);
            } else if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof BaseIRewardCommunication)) {
                this.f6171a = (BaseIRewardCommunication) windVaneWebView.getObject();
            }
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                e3.printStackTrace();
            }
        }
    }
}

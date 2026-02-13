package com.mbridge.msdk.mbsignalcommon.communication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a implements e {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4373a = "a";

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void f(Object obj, String str) {
        try {
            if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
                g.a().a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b);
            }
        } catch (Throwable th) {
            af.b(f4373a, "onSignalCommunication", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public final void l(Object obj, String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is null");
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                d.a(obj, new JSONObject(str));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public final void n(Object obj, String str) throws JSONException {
        WindVaneWebView windVaneWebView;
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is null");
            return;
        }
        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (contextC == null) {
            try {
                if ((obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                    contextC = windVaneWebView.getContext();
                }
            } catch (Exception unused) {
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
        } catch (Throwable unused2) {
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public final void o(Object obj, String str) throws JSONException {
        WindVaneWebView windVaneWebView;
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is null");
            return;
        }
        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (contextC == null) {
            try {
                if ((obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f4406b) != null) {
                    contextC = windVaneWebView.getContext();
                }
            } catch (Exception unused) {
            }
        }
        if (contextC == null) {
            g.a().a(obj, d.a(1));
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("netstat", ab.m(contextC));
            String string = jSONObject.toString();
            if (!TextUtils.isEmpty(string)) {
                string = Base64.encodeToString(string.getBytes(), 2);
            }
            g.a().a(obj, string);
        } catch (Throwable unused2) {
            g.a().a(obj, d.a(1));
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void a(Object obj, String str) {
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void b(Object obj, String str) {
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void c(Object obj, String str) {
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void d(Object obj, String str) {
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void e(Object obj, String str) {
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void g(Object obj, String str) {
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void h(Object obj, String str) {
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void i(Object obj, String str) {
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void j(Object obj, String str) {
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void k(Object obj, String str) {
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public final void m(Object obj, String str) {
    }
}

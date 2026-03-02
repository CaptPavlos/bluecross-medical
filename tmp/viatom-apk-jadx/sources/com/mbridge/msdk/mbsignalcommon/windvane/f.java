package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;
import com.mbridge.msdk.mbsignalcommon.communication.BannerSignalPlugin;
import com.mbridge.msdk.mbsignalcommon.mraid.MraidSignalCommunication;
import com.mbridge.msdk.mbsignalcommon.webEnvCheck.WebGLCheckSignal;
import com.mbridge.msdk.video.signal.communication.RewardSignal;
import com.mbridge.msdk.video.signal.communication.VideoCommunication;
import java.util.HashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Class> f4417a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private Context f4418b;

    /* renamed from: c, reason: collision with root package name */
    private Object f4419c;

    /* renamed from: d, reason: collision with root package name */
    private WindVaneWebView f4420d;

    public f(Context context, WindVaneWebView windVaneWebView) throws ClassNotFoundException {
        this.f4418b = context;
        this.f4420d = windVaneWebView;
        try {
            a(com.mbridge.msdk.mbsignalcommon.base.e.f4320a, Class.forName("com.mbridge.msdk.interstitial.signalcommon.interstitial"));
        } catch (ClassNotFoundException unused) {
        }
        try {
            a(com.mbridge.msdk.mbsignalcommon.base.e.f4321b, RewardSignal.class);
        } catch (ClassNotFoundException unused2) {
        }
        try {
            a(com.mbridge.msdk.mbsignalcommon.base.e.f4322c, VideoCommunication.class);
        } catch (ClassNotFoundException unused3) {
        }
        try {
            a(com.mbridge.msdk.mbsignalcommon.base.e.e, MraidSignalCommunication.class);
        } catch (ClassNotFoundException unused4) {
        }
        try {
            a(com.mbridge.msdk.mbsignalcommon.base.e.f, BannerSignalPlugin.class);
        } catch (ClassNotFoundException unused5) {
        }
        try {
            a(com.mbridge.msdk.mbsignalcommon.base.e.g, Class.forName("com.mbridge.msdk.splash.signal.SplashSignal"));
        } catch (ClassNotFoundException unused6) {
        }
        try {
            a(com.mbridge.msdk.mbsignalcommon.base.e.h, WebGLCheckSignal.class);
        } catch (ClassNotFoundException unused7) {
        }
        try {
            if (com.mbridge.msdk.e.b.a()) {
                Class<?> cls = Class.forName("com.mbridge.msdk.mbsignalcommon.confirmation.bridge.ConfirmationJsBridgePlugin");
                a(cls.getSimpleName(), cls);
            }
        } catch (Exception unused8) {
        }
    }

    private Object a(String str, WindVaneWebView windVaneWebView, Context context) {
        Class cls = f4417a.get(str);
        if (cls == null) {
            return null;
        }
        try {
            if (!h.class.isAssignableFrom(cls)) {
                return null;
            }
            h hVar = (h) cls.newInstance();
            hVar.initialize(context, windVaneWebView);
            hVar.initialize(this.f4419c, windVaneWebView);
            return hVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void a(Object obj) {
        this.f4419c = obj;
    }

    public final void a(Context context) {
        this.f4418b = context;
    }

    public final void a(String str, Class cls) {
        if (f4417a == null) {
            f4417a = new HashMap<>();
        }
        f4417a.put(str, cls);
    }

    public final Object a(String str) {
        if (f4417a == null) {
            f4417a = new HashMap<>();
        }
        return a(str, this.f4420d, this.f4418b);
    }
}

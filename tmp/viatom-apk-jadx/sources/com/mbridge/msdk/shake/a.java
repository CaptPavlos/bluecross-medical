package com.mbridge.msdk.shake;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.af;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private SensorManager f5322a;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.shake.a$a, reason: collision with other inner class name */
    public static class C0060a {

        /* renamed from: a, reason: collision with root package name */
        static a f5323a = new a();
    }

    public final void a(SensorEventListener sensorEventListener) {
        Context contextC = c.m().c();
        if (contextC != null) {
            try {
                if (this.f5322a == null) {
                    this.f5322a = (SensorManager) contextC.getSystemService("sensor");
                }
                this.f5322a.registerListener(sensorEventListener, this.f5322a.getDefaultSensor(1), 2);
            } catch (Exception e) {
                e.printStackTrace();
                String message = e.getMessage();
                try {
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", "2000106");
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.V)) {
                        jSONObject.put(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.V);
                    }
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.g)) {
                        jSONObject.put("c", com.mbridge.msdk.foundation.same.a.g);
                    }
                    jSONObject.put("reason", message);
                    d.a().a(jSONObject);
                } catch (Throwable th) {
                    af.b("NativeShakeManager", th.getMessage());
                }
            }
        }
    }

    public final void b(SensorEventListener sensorEventListener) {
        SensorManager sensorManager = this.f5322a;
        if (sensorManager != null) {
            try {
                sensorManager.unregisterListener(sensorEventListener);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private a() {
    }

    public static a a() {
        return C0060a.f5323a;
    }
}

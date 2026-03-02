package com.mbridge.msdk.c;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {
    private String e;
    private String f;
    private int g;

    /* renamed from: a, reason: collision with root package name */
    private int f2638a = 1;

    /* renamed from: b, reason: collision with root package name */
    private int f2639b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f2640c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f2641d = 0;
    private int h = 0;

    public static a a(String str) {
        Exception e;
        a aVar;
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
            aVar = new a();
        } catch (Exception e3) {
            e = e3;
            aVar = null;
        }
        try {
            aVar.e = jSONObject.optString("http_domain", com.mbridge.msdk.foundation.same.net.e.d.f().g);
            aVar.f = jSONObject.optString("tcp_domain", com.mbridge.msdk.foundation.same.net.e.d.f().f3740k);
            aVar.g = jSONObject.optInt("tcp_port", com.mbridge.msdk.foundation.same.net.e.d.f().f3744o);
            aVar.h = jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 0);
            int i10 = 1;
            int iOptInt = jSONObject.optInt("batch_size", 1);
            if (iOptInt >= 1) {
                i10 = iOptInt;
            }
            aVar.f2638a = i10;
            aVar.f2640c = jSONObject.optInt(TypedValues.TransitionType.S_DURATION, 0);
            aVar.f2639b = jSONObject.optInt("disable", 0);
            aVar.f2641d = jSONObject.optInt("e_t_l", 0);
            return aVar;
        } catch (Exception e7) {
            e = e7;
            e.printStackTrace();
            return aVar;
        }
    }

    public final int b() {
        return this.f2639b;
    }

    public final int c() {
        return this.f2640c;
    }

    public final int d() {
        return this.f2641d;
    }

    public final String e() {
        return this.e;
    }

    public final String f() {
        return this.f;
    }

    public final int g() {
        return this.g;
    }

    public final int h() {
        return this.h;
    }

    public final int a() {
        return this.f2638a;
    }
}

package com.mbridge.msdk.c;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d {
    private String f;
    private String g;
    private int h;

    /* renamed from: a, reason: collision with root package name */
    private int f2708a = 1;

    /* renamed from: b, reason: collision with root package name */
    private int f2709b = 1;

    /* renamed from: c, reason: collision with root package name */
    private int f2710c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f2711d = 30;
    private int e = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f2712i = 0;

    public static d a(String str) {
        Exception e;
        d dVar;
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
            dVar = new d();
        } catch (Exception e3) {
            e = e3;
            dVar = null;
        }
        try {
            dVar.f = jSONObject.optString("h_d", com.mbridge.msdk.foundation.same.net.e.d.f().e);
            dVar.g = jSONObject.optString("t_d", com.mbridge.msdk.foundation.same.net.e.d.f().f3739j);
            dVar.h = jSONObject.optInt("t_p", com.mbridge.msdk.foundation.same.net.e.d.f().f3743n);
            dVar.f2712i = jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1);
            dVar.f2711d = jSONObject.optInt("d_t", 30);
            dVar.f2710c = jSONObject.optInt("d_a", 0);
            return dVar;
        } catch (Exception e7) {
            e = e7;
            e.printStackTrace();
            return dVar;
        }
    }

    public final int b() {
        return this.f2711d;
    }

    public final String c() {
        return this.f;
    }

    public final String d() {
        return this.g;
    }

    public final int e() {
        return this.h;
    }

    public final int a() {
        return this.f2710c;
    }
}

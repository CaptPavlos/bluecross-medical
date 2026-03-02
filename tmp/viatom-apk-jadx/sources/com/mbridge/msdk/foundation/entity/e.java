package com.mbridge.msdk.foundation.entity;

import android.text.TextUtils;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private String f3523a;

    /* renamed from: b, reason: collision with root package name */
    private String f3524b;

    /* renamed from: c, reason: collision with root package name */
    private String f3525c;

    /* renamed from: d, reason: collision with root package name */
    private int f3526d;
    private int e;
    private String f;
    private String g;
    private String h;

    /* renamed from: i, reason: collision with root package name */
    private int f3527i;

    /* renamed from: j, reason: collision with root package name */
    private String f3528j;

    /* renamed from: k, reason: collision with root package name */
    private int f3529k;

    /* renamed from: l, reason: collision with root package name */
    private String f3530l;

    /* renamed from: m, reason: collision with root package name */
    private int f3531m;

    /* renamed from: n, reason: collision with root package name */
    private String f3532n;

    /* renamed from: o, reason: collision with root package name */
    private String f3533o;

    /* renamed from: p, reason: collision with root package name */
    private int f3534p;

    /* renamed from: q, reason: collision with root package name */
    private String f3535q;

    public static ArrayList<JSONObject> a(List<e> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList<JSONObject> arrayList = new ArrayList<>();
        for (e eVar : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("rid", eVar.f3532n);
                jSONObject.put("rid_n", eVar.f3533o);
                jSONObject.put("cid", eVar.f3523a);
                jSONObject.put("click_type", eVar.f3526d);
                jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, eVar.f3534p);
                jSONObject.put("click_duration", eVar.f3524b);
                jSONObject.put("key", "2000013");
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, eVar.f3535q);
                jSONObject.put("last_url", eVar.f3528j);
                jSONObject.put("content", eVar.f);
                jSONObject.put("code", eVar.e);
                jSONObject.put("exception", eVar.g);
                jSONObject.put("header", eVar.h);
                jSONObject.put(CampaignEx.JSON_KEY_LANDING_TYPE, eVar.f3527i);
                jSONObject.put(CampaignEx.JSON_KEY_LINK_TYPE, eVar.f3529k);
                jSONObject.put("click_time", eVar.f3525c);
                if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    jSONObject.put("network_type", eVar.f3531m);
                    jSONObject.put("network_str", eVar.f3530l);
                }
                String str = eVar.f3535q;
                if (!TextUtils.isEmpty(str)) {
                    String str2 = com.mbridge.msdk.foundation.controller.a.f3352b.get(str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put("u_stid", str2);
                }
                arrayList.add(jSONObject);
            } catch (Throwable th) {
                af.b("ClickTime", th.getMessage());
            }
        }
        return arrayList;
    }

    public final void b(String str) {
        this.f3532n = str;
    }

    public final void c(String str) {
        this.f3530l = str;
    }

    public final void d(String str) {
        this.g = str;
    }

    public final void e(int i10) {
        this.f3529k = i10;
    }

    public final void f(String str) {
        this.h = str;
    }

    public final void g(String str) {
        this.f = str;
    }

    public final void h(String str) {
        this.f3528j = str;
    }

    public final void i(String str) {
        this.f3524b = str;
    }

    public final void j(String str) {
        this.f3523a = str;
    }

    public final void k(String str) {
        this.f3533o = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ClickTime [campaignId=");
        sb.append(this.f3523a);
        sb.append(", click_duration=");
        sb.append(this.f3524b);
        sb.append(", lastUrl=");
        sb.append(this.f3528j);
        sb.append(", code=");
        sb.append(this.e);
        sb.append(", excepiton=");
        sb.append(this.g);
        sb.append(", header=");
        sb.append(this.h);
        sb.append(", content=");
        sb.append(this.f);
        sb.append(", type=");
        sb.append(this.f3534p);
        sb.append(", click_type=");
        return a3.a.n(sb, "]", this.f3526d);
    }

    public final void b(int i10) {
        this.f3526d = i10;
    }

    public final void c(int i10) {
        this.f3534p = i10;
    }

    public final void d(int i10) {
        this.f3527i = i10;
    }

    public final void e(String str) {
        this.f3525c = str;
    }

    public final void f(int i10) {
        this.e = i10;
    }

    public final void a(int i10) {
        this.f3531m = i10;
    }

    public final void a(String str) {
        this.f3535q = str;
    }

    public static JSONObject a(e eVar) {
        if (eVar == null) {
            return null;
        }
        String str = eVar.f3528j;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("rid", eVar.f3532n);
            jSONObject.put("rid_n", eVar.f3533o);
            jSONObject.put("click_type", eVar.f3526d);
            jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, eVar.f3534p);
            jSONObject.put("cid", eVar.f3523a);
            jSONObject.put("click_duration", eVar.f3524b);
            jSONObject.put("key", "2000012");
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, eVar.f3535q);
            jSONObject.put("last_url", str);
            jSONObject.put("code", eVar.e);
            jSONObject.put("exception", eVar.g);
            jSONObject.put(CampaignEx.JSON_KEY_LANDING_TYPE, eVar.f3527i);
            jSONObject.put(CampaignEx.JSON_KEY_LINK_TYPE, eVar.f3529k);
            jSONObject.put("click_time", eVar.f3525c);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put("network_type", eVar.f3531m);
                jSONObject.put("network_str", eVar.f3530l);
            }
            return jSONObject;
        } catch (Throwable th) {
            af.b("ClickTime", th.getMessage());
            return null;
        }
    }
}

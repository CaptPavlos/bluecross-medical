package com.mbridge.msdk.newreward.function.f;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.same.net.f.f;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.c.b.h;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.net.URLEncoder;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends a {

    /* renamed from: a, reason: collision with root package name */
    private String f4996a;

    /* renamed from: b, reason: collision with root package name */
    private int f4997b;

    /* renamed from: c, reason: collision with root package name */
    private String f4998c;

    /* renamed from: d, reason: collision with root package name */
    private int f4999d;

    public final void a(String str) {
        this.f4996a = str;
    }

    public final String b() {
        return this.f4996a;
    }

    public final Map<String, String> c() {
        com.mbridge.msdk.foundation.same.net.f.e eVar = new com.mbridge.msdk.foundation.same.net.f.e(a());
        if (this.f4999d == h.f4711b && !TextUtils.isEmpty(this.f4996a)) {
            eVar.a("unit_ids", "[" + this.f4996a + "]");
        }
        eVar.a("vtag", TextUtils.isEmpty(this.f4998c) ? "" : this.f4998c);
        if (com.mbridge.msdk.e.b.a()) {
            String strB = Aa.b();
            if (!TextUtils.isEmpty(strB)) {
                eVar.a("keyword", strB);
            }
        }
        com.mbridge.msdk.c.a.d.a(com.mbridge.msdk.foundation.controller.c.m().c(), eVar);
        f.d(eVar);
        f.f(eVar);
        return eVar.a();
    }

    public final String d() {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : c().entrySet()) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode(entry.getKey(), C.UTF8_NAME));
                sb.append("=");
                sb.append(URLEncoder.encode(entry.getValue(), C.UTF8_NAME));
            }
        } catch (Throwable th) {
            af.b("RewardSettingReqParameters", th.getMessage());
        }
        return sb.toString();
    }

    public final void a(int i10) {
        this.f4997b = i10;
    }

    public final void b(String str) {
        this.f4998c = str;
    }

    public final void b(int i10) {
        this.f4999d = i10;
    }
}

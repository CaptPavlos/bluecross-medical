package com.mbridge.msdk.d;

import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.d.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class b {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        static b f2888a = new b();
    }

    public static b getInstance() {
        return a.f2888a;
    }

    public void addInterstitialList(String str, String str2) {
        try {
            a.C0021a.f2887a.b(str, str2);
        } catch (Exception e) {
            androidx.constraintlayout.core.widgets.analyzer.a.D(e, new StringBuilder("addInterstitialList error:"), "TimerController");
        }
    }

    public void addRewardList(String str, String str2) {
        try {
            a.C0021a.f2887a.a(str, str2);
        } catch (Exception e) {
            androidx.constraintlayout.core.widgets.analyzer.a.D(e, new StringBuilder("addRewardList error:"), "TimerController");
        }
    }

    public void start() {
        g gVarS = androidx.constraintlayout.core.widgets.analyzer.a.s(h.a());
        if (gVarS == null) {
            h.a();
            gVarS = i.a();
        }
        if (gVarS.o() > 0) {
            a.C0021a.f2887a.a(r0 * 1000);
        }
    }

    private b() {
    }
}

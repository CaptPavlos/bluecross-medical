package c0;

import android.content.Context;
import android.content.Intent;
import c1.d0;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import d0.g;
import d0.h;
import h0.i;
import h0.j;
import h0.q;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends g0.d {

    /* renamed from: k, reason: collision with root package name */
    public static int f969k = 1;

    public final Intent b() {
        int iD = d();
        int i10 = iD - 1;
        if (iD == 0) {
            throw null;
        }
        g0.a aVar = this.f8190d;
        Context context = this.f8187a;
        if (i10 == 2) {
            h.f6778a.b("getFallbackSignInIntent()", new Object[0]);
            Intent intentA = h.a(context, (GoogleSignInOptions) aVar);
            intentA.setAction("com.google.android.gms.auth.APPAUTH_SIGN_IN");
            return intentA;
        }
        if (i10 == 3) {
            return h.a(context, (GoogleSignInOptions) aVar);
        }
        h.f6778a.b("getNoImplementationSignInIntent()", new Object[0]);
        Intent intentA2 = h.a(context, (GoogleSignInOptions) aVar);
        intentA2.setAction("com.google.android.gms.auth.NO_IMPL");
        return intentA2;
    }

    public final void c() {
        BasePendingResult basePendingResult;
        boolean z9 = d() == 3;
        h.f6778a.b("Signing out", new Object[0]);
        h.b(this.f8187a);
        q qVar = this.h;
        if (z9) {
            BasePendingResult iVar = new i(qVar);
            iVar.e(Status.e);
            basePendingResult = iVar;
        } else {
            g gVar = new g(qVar, 0);
            qVar.b(gVar);
            basePendingResult = gVar;
        }
        basePendingResult.a(new j(basePendingResult, new h1.i(), new d0(17)));
    }

    public final synchronized int d() {
        int i10;
        try {
            i10 = f969k;
            if (i10 == 1) {
                Context context = this.f8187a;
                f0.e eVar = f0.e.f8001d;
                int iB = eVar.b(context, 12451000);
                if (iB == 0) {
                    i10 = 4;
                    f969k = 4;
                } else if (eVar.a(context, iB, null) != null || r0.e.a(context, "com.google.android.gms.auth.api.fallback") == 0) {
                    i10 = 2;
                    f969k = 2;
                } else {
                    i10 = 3;
                    f969k = 3;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return i10;
    }
}

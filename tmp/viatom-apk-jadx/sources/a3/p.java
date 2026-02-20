package a3;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final l1.g f149a;

    /* renamed from: b, reason: collision with root package name */
    public final d3.j f150b;

    public p(l1.g gVar, d3.j jVar, w6.h hVar, d1 d1Var) {
        gVar.getClass();
        jVar.getClass();
        hVar.getClass();
        d1Var.getClass();
        this.f149a = gVar;
        this.f150b = jVar;
        Log.d("FirebaseSessions", "Initializing Firebase Sessions 3.0.3.");
        gVar.a();
        Context applicationContext = gVar.f10177a.getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(d1Var);
            r7.y.q(r7.y.a(hVar), null, null, new o(this, d1Var, (w6.c) null, 0), 3);
        } else {
            Log.e("FirebaseSessions", "Failed to register lifecycle callbacks, unexpected context " + applicationContext.getClass() + '.');
        }
    }
}

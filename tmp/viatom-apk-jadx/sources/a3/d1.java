package a3;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d1 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final k1 f51a;

    public d1(k1 k1Var) {
        k1Var.getClass();
        this.f51a = k1Var;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        activity.getClass();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        activity.getClass();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        activity.getClass();
        this.f51a.b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        activity.getClass();
        k1 k1Var = this.f51a;
        k1Var.f126i = true;
        o0 o0Var = k1Var.h;
        if (o0Var == null) {
            Log.d("FirebaseSessions", "App foregrounded, but local SessionData not initialized");
            return;
        }
        w6.c cVar = null;
        if (o0Var == null) {
            kotlin.jvm.internal.l.i("localSessionData");
            throw null;
        }
        Log.d("FirebaseSessions", "App foregrounded on " + k1Var.f.a());
        if (k1Var.d(o0Var) || k1Var.c(o0Var)) {
            r7.y.q(r7.y.a(k1Var.g), null, null, new o(k1Var, o0Var, cVar, 1), 3);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        activity.getClass();
        bundle.getClass();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        activity.getClass();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        activity.getClass();
    }
}

package com.google.android.gms.internal.measurement;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l1 {
    public static volatile l1 g;

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f2070a;

    /* renamed from: b, reason: collision with root package name */
    public final d0.i f2071b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f2072c;

    /* renamed from: d, reason: collision with root package name */
    public int f2073d;
    public boolean e;
    public volatile l0 f;

    public l1(Context context, Bundle bundle) throws ClassNotFoundException {
        g1 g1Var = new g1(this);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), g1Var);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f2070a = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.f2071b = new d0.i(this, 3);
        this.f2072c = new ArrayList();
        int i10 = 0;
        try {
            if (c1.l2.b(context, c1.l2.a(context)) != null) {
                try {
                    Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, l1.class.getClassLoader());
                } catch (ClassNotFoundException unused) {
                    this.e = true;
                    Log.w("FA", "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Add Google Analytics for Firebase to resume data collection.");
                    return;
                }
            }
        } catch (IllegalStateException unused2) {
        }
        a(new a1(this, context, bundle, i10));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w("FA", "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new k1(this));
        }
    }

    public static l1 c(Context context, Bundle bundle) {
        i0.y.g(context);
        if (g == null) {
            synchronized (l1.class) {
                try {
                    if (g == null) {
                        g = new l1(context, bundle);
                    }
                } finally {
                }
            }
        }
        return g;
    }

    public final void a(h1 h1Var) {
        this.f2070a.execute(h1Var);
    }

    public final void b(Exception exc, boolean z9, boolean z10) {
        this.e |= z9;
        if (z9) {
            Log.w("FA", "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z10) {
            a(new y0(this, exc));
        }
        Log.w("FA", "Error with data collection. Data lost.", exc);
    }
}

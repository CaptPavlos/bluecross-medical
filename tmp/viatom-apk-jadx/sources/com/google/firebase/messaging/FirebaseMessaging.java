package com.google.firebase.messaging;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import c1.g1;
import c1.y2;
import c5.t;
import com.google.firebase.messaging.FirebaseMessaging;
import d5.j;
import e0.h;
import e0.n;
import h1.p;
import h5.q0;
import i0.y;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import l1.g;
import l4.x4;
import n2.c;
import o0.a;
import q1.e;
import q2.b;
import r0.f;
import r2.d;
import w2.l;
import w2.o;
import w2.s;
import w2.z;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class FirebaseMessaging {

    /* renamed from: j, reason: collision with root package name */
    public static x4 f2430j;

    /* renamed from: k, reason: collision with root package name */
    public static b f2431k = new e(1);

    /* renamed from: l, reason: collision with root package name */
    public static ScheduledThreadPoolExecutor f2432l;

    /* renamed from: a, reason: collision with root package name */
    public final g f2433a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f2434b;

    /* renamed from: c, reason: collision with root package name */
    public final j f2435c;

    /* renamed from: d, reason: collision with root package name */
    public final w2.j f2436d;
    public final g1 e;
    public final ScheduledThreadPoolExecutor f;
    public final ThreadPoolExecutor g;
    public final t h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2437i;

    public FirebaseMessaging(g gVar, b bVar, b bVar2, d dVar, b bVar3, c cVar) {
        gVar.a();
        Context context = gVar.f10177a;
        final t tVar = new t(context);
        final j jVar = new j(gVar, tVar, bVar, bVar2, dVar);
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new a("Firebase-Messaging-Task"));
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new a("Firebase-Messaging-Init"));
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("Firebase-Messaging-File-Io"));
        this.f2437i = false;
        f2431k = bVar3;
        this.f2433a = gVar;
        this.e = new g1(this, cVar);
        gVar.a();
        final Context context2 = gVar.f10177a;
        this.f2434b = context2;
        y2 y2Var = new y2();
        this.h = tVar;
        this.f2435c = jVar;
        this.f2436d = new w2.j(executorServiceNewSingleThreadExecutor);
        this.f = scheduledThreadPoolExecutor;
        this.g = threadPoolExecutor;
        gVar.a();
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(y2Var);
        } else {
            Log.w("FirebaseMessaging", "Context " + context + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        final int i10 = 0;
        scheduledThreadPoolExecutor.execute(new Runnable(this) { // from class: w2.k

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FirebaseMessaging f13449b;

            {
                this.f13449b = this;
            }

            private final void a() {
                FirebaseMessaging firebaseMessaging = this.f13449b;
                if (firebaseMessaging.e.i() && firebaseMessaging.i(firebaseMessaging.d())) {
                    synchronized (firebaseMessaging) {
                        if (!firebaseMessaging.f2437i) {
                            firebaseMessaging.h(0L);
                        }
                    }
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                h1.p pVarW;
                int i11;
                switch (i10) {
                    case 0:
                        a();
                        return;
                    default:
                        FirebaseMessaging firebaseMessaging = this.f13449b;
                        final Context context3 = firebaseMessaging.f2434b;
                        o.a(context3);
                        d5.j jVar2 = firebaseMessaging.f2435c;
                        final boolean zG = firebaseMessaging.g();
                        if (Build.VERSION.SDK_INT >= 29) {
                            SharedPreferences sharedPreferencesE = z.e(context3);
                            if (!sharedPreferencesE.contains("proxy_retention") || sharedPreferencesE.getBoolean("proxy_retention", false) != zG) {
                                e0.b bVar4 = (e0.b) jVar2.f7136d;
                                if (bVar4.f7593c.a() >= 241100000) {
                                    Bundle bundle = new Bundle();
                                    bundle.putBoolean("proxy_retention", zG);
                                    e0.n nVarA = e0.n.a(bVar4.f7592b);
                                    synchronized (nVarA) {
                                        i11 = nVarA.f7617b;
                                        nVarA.f7617b = i11 + 1;
                                    }
                                    pVarW = nVarA.b(new e0.l(i11, 4, bundle, 0));
                                } else {
                                    pVarW = r0.f.w(new IOException("SERVICE_NOT_AVAILABLE"));
                                }
                                pVarW.c(new androidx.arch.core.executor.a(2), new h1.f() { // from class: w2.p
                                    @Override // h1.f
                                    public final void h(Object obj) {
                                        SharedPreferences.Editor editorEdit = z.e(context3).edit();
                                        editorEdit.putBoolean("proxy_retention", zG);
                                        editorEdit.apply();
                                    }
                                });
                            }
                        }
                        if (firebaseMessaging.g()) {
                            firebaseMessaging.e();
                            return;
                        }
                        return;
                }
            }
        });
        final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2 = new ScheduledThreadPoolExecutor(1, new a("Firebase-Messaging-Topics-Io"));
        f.m(scheduledThreadPoolExecutor2, new Callable() { // from class: w2.v
            @Override // java.util.concurrent.Callable
            public final Object call() {
                u uVar;
                Context context3 = context2;
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor3 = scheduledThreadPoolExecutor2;
                FirebaseMessaging firebaseMessaging = this;
                c5.t tVar2 = tVar;
                d5.j jVar2 = jVar;
                synchronized (u.class) {
                    try {
                        WeakReference weakReference = u.f13473d;
                        uVar = weakReference != null ? (u) weakReference.get() : null;
                        if (uVar == null) {
                            u uVar2 = new u(context3.getSharedPreferences("com.google.android.gms.appid", 0), scheduledThreadPoolExecutor3);
                            uVar2.b();
                            u.f13473d = new WeakReference(uVar2);
                            uVar = uVar2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return new w(firebaseMessaging, tVar2, uVar, jVar2, context3, scheduledThreadPoolExecutor3);
            }
        }).c(scheduledThreadPoolExecutor, new l(this, 0));
        final int i11 = 1;
        scheduledThreadPoolExecutor.execute(new Runnable(this) { // from class: w2.k

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FirebaseMessaging f13449b;

            {
                this.f13449b = this;
            }

            private final void a() {
                FirebaseMessaging firebaseMessaging = this.f13449b;
                if (firebaseMessaging.e.i() && firebaseMessaging.i(firebaseMessaging.d())) {
                    synchronized (firebaseMessaging) {
                        if (!firebaseMessaging.f2437i) {
                            firebaseMessaging.h(0L);
                        }
                    }
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                h1.p pVarW;
                int i112;
                switch (i11) {
                    case 0:
                        a();
                        return;
                    default:
                        FirebaseMessaging firebaseMessaging = this.f13449b;
                        final Context context3 = firebaseMessaging.f2434b;
                        o.a(context3);
                        d5.j jVar2 = firebaseMessaging.f2435c;
                        final boolean zG = firebaseMessaging.g();
                        if (Build.VERSION.SDK_INT >= 29) {
                            SharedPreferences sharedPreferencesE = z.e(context3);
                            if (!sharedPreferencesE.contains("proxy_retention") || sharedPreferencesE.getBoolean("proxy_retention", false) != zG) {
                                e0.b bVar4 = (e0.b) jVar2.f7136d;
                                if (bVar4.f7593c.a() >= 241100000) {
                                    Bundle bundle = new Bundle();
                                    bundle.putBoolean("proxy_retention", zG);
                                    e0.n nVarA = e0.n.a(bVar4.f7592b);
                                    synchronized (nVarA) {
                                        i112 = nVarA.f7617b;
                                        nVarA.f7617b = i112 + 1;
                                    }
                                    pVarW = nVarA.b(new e0.l(i112, 4, bundle, 0));
                                } else {
                                    pVarW = r0.f.w(new IOException("SERVICE_NOT_AVAILABLE"));
                                }
                                pVarW.c(new androidx.arch.core.executor.a(2), new h1.f() { // from class: w2.p
                                    @Override // h1.f
                                    public final void h(Object obj) {
                                        SharedPreferences.Editor editorEdit = z.e(context3).edit();
                                        editorEdit.putBoolean("proxy_retention", zG);
                                        editorEdit.apply();
                                    }
                                });
                            }
                        }
                        if (firebaseMessaging.g()) {
                            firebaseMessaging.e();
                            return;
                        }
                        return;
                }
            }
        });
    }

    public static void b(Runnable runnable, long j10) {
        synchronized (FirebaseMessaging.class) {
            try {
                if (f2432l == null) {
                    f2432l = new ScheduledThreadPoolExecutor(1, new a("TAG"));
                }
                f2432l.schedule(runnable, j10, TimeUnit.SECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized x4 c(Context context) {
        try {
            if (f2430j == null) {
                f2430j = new x4(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f2430j;
    }

    @NonNull
    @Keep
    public static synchronized FirebaseMessaging getInstance(@NonNull g gVar) {
        FirebaseMessaging firebaseMessaging;
        firebaseMessaging = (FirebaseMessaging) gVar.b(FirebaseMessaging.class);
        y.h(firebaseMessaging, "Firebase Messaging component is not present");
        return firebaseMessaging;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String a() {
        p pVarE;
        q0 q0VarD = d();
        if (!i(q0VarD)) {
            return q0VarD.f8717a;
        }
        String strD = t.d(this.f2433a);
        w2.j jVar = this.f2436d;
        synchronized (jVar) {
            pVarE = (p) ((ArrayMap) jVar.f13447b).get(strD);
            if (pVarE == null) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Making new request for: " + strD);
                }
                j jVar2 = this.f2435c;
                pVarE = jVar2.d(jVar2.o(t.d((g) jVar2.f7134b), "*", new Bundle())).j(this.g, new androidx.transition.a(this, strD, q0VarD, 7)).e((Executor) jVar.f13446a, new androidx.privacysandbox.ads.adservices.java.internal.a(9, jVar, strD));
                ((ArrayMap) jVar.f13447b).put(strD, pVarE);
            } else if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Joining ongoing request for: " + strD);
            }
        }
        try {
            return (String) f.i(pVarE);
        } catch (InterruptedException | ExecutionException e) {
            throw new IOException(e);
        }
    }

    public final q0 d() {
        q0 q0VarD;
        x4 x4VarC = c(this.f2434b);
        g gVar = this.f2433a;
        gVar.a();
        String strD = "[DEFAULT]".equals(gVar.f10178b) ? "" : gVar.d();
        String strD2 = t.d(this.f2433a);
        synchronized (x4VarC) {
            q0VarD = q0.d(((SharedPreferences) x4VarC.f10987b).getString(strD + "|T|" + strD2 + "|*", null));
        }
        return q0VarD;
    }

    public final void e() {
        p pVarW;
        int i10;
        e0.b bVar = (e0.b) this.f2435c.f7136d;
        if (bVar.f7593c.a() >= 241100000) {
            n nVarA = n.a(bVar.f7592b);
            Bundle bundle = Bundle.EMPTY;
            synchronized (nVarA) {
                i10 = nVarA.f7617b;
                nVarA.f7617b = i10 + 1;
            }
            pVarW = nVarA.b(new e0.l(i10, 5, bundle, 1)).d(h.f7603c, e0.d.f7597c);
        } else {
            pVarW = f.w(new IOException("SERVICE_NOT_AVAILABLE"));
        }
        pVarW.c(this.f, new l(this, 1));
    }

    public final synchronized void f(boolean z9) {
        this.f2437i = z9;
    }

    public final boolean g() {
        Context context = this.f2434b;
        o.a(context);
        if (!o.b(context)) {
            return false;
        }
        if (this.f2433a.b(n1.a.class) != null) {
            return true;
        }
        return z.d() && f2431k != null;
    }

    public final synchronized void h(long j10) {
        b(new s(this, Math.min(Math.max(30L, 2 * j10), 28800L)), j10);
        this.f2437i = true;
    }

    public final boolean i(q0 q0Var) {
        if (q0Var != null) {
            return System.currentTimeMillis() > q0Var.f8719c + 604800000 || !this.h.b().equals(q0Var.f8718b);
        }
        return true;
    }
}

package w1;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import l4.n5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13372a;

    /* renamed from: b, reason: collision with root package name */
    public final s f13373b;

    /* renamed from: c, reason: collision with root package name */
    public final t1.c f13374c;

    /* renamed from: d, reason: collision with root package name */
    public final long f13375d;
    public t1.c e;
    public t1.c f;
    public l g;
    public final w h;

    /* renamed from: i, reason: collision with root package name */
    public final c2.d f13376i;

    /* renamed from: j, reason: collision with root package name */
    public final s1.a f13377j;

    /* renamed from: k, reason: collision with root package name */
    public final s1.a f13378k;

    /* renamed from: l, reason: collision with root package name */
    public final i f13379l;

    /* renamed from: m, reason: collision with root package name */
    public final t1.b f13380m;

    /* renamed from: n, reason: collision with root package name */
    public final n5 f13381n;

    /* renamed from: o, reason: collision with root package name */
    public final x1.e f13382o;

    public p(l1.g gVar, w wVar, t1.b bVar, s sVar, s1.a aVar, s1.a aVar2, c2.d dVar, i iVar, n5 n5Var, x1.e eVar) {
        this.f13373b = sVar;
        gVar.a();
        this.f13372a = gVar.f10177a;
        this.h = wVar;
        this.f13380m = bVar;
        this.f13377j = aVar;
        this.f13378k = aVar2;
        this.f13376i = dVar;
        this.f13379l = iVar;
        this.f13381n = n5Var;
        this.f13382o = eVar;
        this.f13375d = System.currentTimeMillis();
        this.f13374c = new t1.c(9);
    }

    public final void a(d5.n nVar) {
        x1.e.a();
        x1.e.a();
        this.e.c();
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "Initialization marker file was created.", null);
        }
        try {
            try {
                this.f13377j.q(new n(this));
                this.g.g();
                if (!nVar.k().f7632b.f7627a) {
                    if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                        Log.d("FirebaseCrashlytics", "Collection of crash reports disabled in Crashlytics settings.", null);
                    }
                    throw new RuntimeException("Collection of crash reports disabled in Crashlytics settings.");
                }
                if (!this.g.d(nVar)) {
                    Log.w("FirebaseCrashlytics", "Previous sessions could not be finalized.", null);
                }
                this.g.h(((h1.i) ((AtomicReference) nVar.f7244j).get()).f8418a);
                c();
            } catch (Exception e) {
                Log.e("FirebaseCrashlytics", "Crashlytics encountered a problem during asynchronous initialization.", e);
                c();
            }
        } catch (Throwable th) {
            c();
            throw th;
        }
    }

    public final void b(d5.n nVar) {
        Future<?> futureSubmit = this.f13382o.f13576a.f13571a.submit(new m(this, nVar, 1));
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.", null);
        }
        try {
            futureSubmit.get(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Log.e("FirebaseCrashlytics", "Crashlytics was interrupted during initialization.", e);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e3) {
            Log.e("FirebaseCrashlytics", "Crashlytics encountered a problem during initialization.", e3);
        } catch (TimeoutException e7) {
            Log.e("FirebaseCrashlytics", "Crashlytics timed out during initialization.", e7);
        }
    }

    public final void c() {
        x1.e.a();
        try {
            t1.c cVar = this.e;
            c2.d dVar = (c2.d) cVar.f12752c;
            String str = (String) cVar.f12751b;
            dVar.getClass();
            if (new File((File) dVar.f1643d, str).delete()) {
                return;
            }
            Log.w("FirebaseCrashlytics", "Initialization marker file was not properly removed.", null);
        } catch (Exception e) {
            Log.e("FirebaseCrashlytics", "Problem encountered deleting Crashlytics initialization marker.", e);
        }
    }
}

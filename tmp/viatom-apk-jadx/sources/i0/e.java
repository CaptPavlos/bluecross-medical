package i0;

import android.accounts.Account;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class e {

    /* renamed from: x, reason: collision with root package name */
    public static final f0.d[] f8864x = new f0.d[0];

    /* renamed from: b, reason: collision with root package name */
    public a0.a f8866b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f8867c;

    /* renamed from: d, reason: collision with root package name */
    public final j0 f8868d;
    public final f0.f e;
    public final a0 f;

    /* renamed from: i, reason: collision with root package name */
    public u f8869i;

    /* renamed from: j, reason: collision with root package name */
    public d f8870j;

    /* renamed from: k, reason: collision with root package name */
    public IInterface f8871k;

    /* renamed from: m, reason: collision with root package name */
    public c0 f8873m;

    /* renamed from: o, reason: collision with root package name */
    public final b f8875o;

    /* renamed from: p, reason: collision with root package name */
    public final c f8876p;

    /* renamed from: q, reason: collision with root package name */
    public final int f8877q;

    /* renamed from: r, reason: collision with root package name */
    public final String f8878r;

    /* renamed from: s, reason: collision with root package name */
    public volatile String f8879s;

    /* renamed from: a, reason: collision with root package name */
    public volatile String f8865a = null;
    public final Object g = new Object();
    public final Object h = new Object();

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f8872l = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    public int f8874n = 1;
    public f0.b t = null;

    /* renamed from: u, reason: collision with root package name */
    public boolean f8880u = false;

    /* renamed from: v, reason: collision with root package name */
    public volatile f0 f8881v = null;

    /* renamed from: w, reason: collision with root package name */
    public final AtomicInteger f8882w = new AtomicInteger(0);

    public e(Context context, Looper looper, j0 j0Var, f0.f fVar, int i10, b bVar, c cVar, String str) {
        y.h(context, "Context must not be null");
        this.f8867c = context;
        y.h(looper, "Looper must not be null");
        y.h(j0Var, "Supervisor must not be null");
        this.f8868d = j0Var;
        y.h(fVar, "API availability must not be null");
        this.e = fVar;
        this.f = new a0(this, looper);
        this.f8877q = i10;
        this.f8875o = bVar;
        this.f8876p = cVar;
        this.f8878r = str;
    }

    public static /* bridge */ /* synthetic */ void x(e eVar) {
        int i10;
        int i11;
        synchronized (eVar.g) {
            i10 = eVar.f8874n;
        }
        if (i10 == 3) {
            eVar.f8880u = true;
            i11 = 5;
        } else {
            i11 = 4;
        }
        a0 a0Var = eVar.f;
        a0Var.sendMessage(a0Var.obtainMessage(i11, eVar.f8882w.get(), 16));
    }

    public static /* bridge */ /* synthetic */ boolean y(e eVar, int i10, int i11, IInterface iInterface) {
        synchronized (eVar.g) {
            try {
                if (eVar.f8874n != i10) {
                    return false;
                }
                eVar.z(iInterface, i11);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(d dVar) {
        this.f8870j = dVar;
        z(null, 2);
    }

    public final void c(String str) {
        this.f8865a = str;
        o();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(i iVar, Set set) {
        Bundle bundleR = r();
        String str = this.f8879s;
        int i10 = this.f8877q;
        int i11 = f0.f.f8002a;
        Scope[] scopeArr = g.f8891o;
        Bundle bundle = new Bundle();
        f0.d[] dVarArr = g.f8892p;
        g gVar = new g(6, i10, i11, null, null, scopeArr, bundle, null, dVarArr, dVarArr, true, 0, false, str);
        gVar.f8896d = this.f8867c.getPackageName();
        gVar.g = bundleR;
        if (set != null) {
            gVar.f = (Scope[]) set.toArray(new Scope[0]);
        }
        if (l()) {
            Account accountP = p();
            if (accountP == null) {
                accountP = new Account("<<default account>>", "com.google");
            }
            gVar.h = accountP;
            if (iVar != 0) {
                gVar.e = ((com.google.android.gms.internal.measurement.x) iVar).f2252b;
            }
        }
        gVar.f8897i = f8864x;
        gVar.f8898j = q();
        if (this instanceof t0.a) {
            gVar.f8901m = true;
        }
        try {
            synchronized (this.h) {
                try {
                    u uVar = this.f8869i;
                    if (uVar != null) {
                        uVar.a(new b0(this, this.f8882w.get()), gVar);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } finally {
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i12 = this.f8882w.get();
            a0 a0Var = this.f;
            a0Var.sendMessage(a0Var.obtainMessage(6, i12, 3));
        } catch (RemoteException e3) {
            e = e3;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i13 = this.f8882w.get();
            d0 d0Var = new d0(this, 8, null, null);
            a0 a0Var2 = this.f;
            a0Var2.sendMessage(a0Var2.obtainMessage(1, i13, -1, d0Var));
        } catch (SecurityException e7) {
            throw e7;
        } catch (RuntimeException e10) {
            e = e10;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i132 = this.f8882w.get();
            d0 d0Var2 = new d0(this, 8, null, null);
            a0 a0Var22 = this.f;
            a0Var22.sendMessage(a0Var22.obtainMessage(1, i132, -1, d0Var2));
        }
    }

    public final boolean e() {
        boolean z9;
        synchronized (this.g) {
            int i10 = this.f8874n;
            z9 = true;
            if (i10 != 2 && i10 != 3) {
                z9 = false;
            }
        }
        return z9;
    }

    public final void f() {
        if (!h() || this.f8866b == null) {
            a2.a.j("Failed to connect when checking package");
        }
    }

    public final void g(d0.i iVar) {
        ((h0.n) iVar.f6781b).t.f8371m.post(new a4.a(iVar, 11));
    }

    public final boolean h() {
        boolean z9;
        synchronized (this.g) {
            z9 = this.f8874n == 4;
        }
        return z9;
    }

    public abstract int i();

    public final f0.d[] j() {
        f0 f0Var = this.f8881v;
        if (f0Var == null) {
            return null;
        }
        return f0Var.f8888b;
    }

    public final String k() {
        return this.f8865a;
    }

    public boolean l() {
        return false;
    }

    public final void m() throws PackageManager.NameNotFoundException {
        int iB = this.e.b(this.f8867c, i());
        if (iB == 0) {
            a(new l(this));
            return;
        }
        z(null, 1);
        this.f8870j = new l(this);
        int i10 = this.f8882w.get();
        a0 a0Var = this.f;
        a0Var.sendMessage(a0Var.obtainMessage(3, i10, iB, null));
    }

    public abstract IInterface n(IBinder iBinder);

    public final void o() {
        this.f8882w.incrementAndGet();
        synchronized (this.f8872l) {
            try {
                int size = this.f8872l.size();
                int i10 = 0;
                while (true) {
                    ArrayList arrayList = this.f8872l;
                    if (i10 < size) {
                        ((t) arrayList.get(i10)).c();
                        i10++;
                    } else {
                        arrayList.clear();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.h) {
            this.f8869i = null;
        }
        z(null, 1);
    }

    public Account p() {
        return null;
    }

    public f0.d[] q() {
        return f8864x;
    }

    public Bundle r() {
        return new Bundle();
    }

    public Set s() {
        return Collections.EMPTY_SET;
    }

    public final IInterface t() {
        IInterface iInterface;
        synchronized (this.g) {
            try {
                if (this.f8874n == 5) {
                    throw new DeadObjectException();
                }
                if (!h()) {
                    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
                }
                iInterface = this.f8871k;
                y.h(iInterface, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    public abstract String u();

    public abstract String v();

    public boolean w() {
        return i() >= 211700000;
    }

    public final void z(IInterface iInterface, int i10) {
        a0.a aVar;
        y.b((i10 == 4) == (iInterface != null));
        synchronized (this.g) {
            try {
                this.f8874n = i10;
                this.f8871k = iInterface;
                Bundle bundle = null;
                if (i10 == 1) {
                    c0 c0Var = this.f8873m;
                    if (c0Var != null) {
                        j0 j0Var = this.f8868d;
                        String str = this.f8866b.f5b;
                        y.g(str);
                        this.f8866b.getClass();
                        if (this.f8878r == null) {
                            this.f8867c.getClass();
                        }
                        j0Var.d(str, c0Var, this.f8866b.f6c);
                        this.f8873m = null;
                    }
                } else if (i10 == 2 || i10 == 3) {
                    c0 c0Var2 = this.f8873m;
                    if (c0Var2 != null && (aVar = this.f8866b) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + aVar.f5b + " on com.google.android.gms");
                        j0 j0Var2 = this.f8868d;
                        String str2 = this.f8866b.f5b;
                        y.g(str2);
                        this.f8866b.getClass();
                        if (this.f8878r == null) {
                            this.f8867c.getClass();
                        }
                        j0Var2.d(str2, c0Var2, this.f8866b.f6c);
                        this.f8882w.incrementAndGet();
                    }
                    c0 c0Var3 = new c0(this, this.f8882w.get());
                    this.f8873m = c0Var3;
                    String strV = v();
                    boolean zW = w();
                    this.f8866b = new a0.a(1, strV, zW);
                    if (zW && i() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.f8866b.f5b)));
                    }
                    j0 j0Var3 = this.f8868d;
                    String str3 = this.f8866b.f5b;
                    y.g(str3);
                    this.f8866b.getClass();
                    String name = this.f8878r;
                    if (name == null) {
                        name = this.f8867c.getClass().getName();
                    }
                    f0.b bVarC = j0Var3.c(new g0(str3, this.f8866b.f6c), c0Var3, name, null);
                    if (!(bVarC.f7991b == 0)) {
                        Log.w("GmsClient", "unable to connect to service: " + this.f8866b.f5b + " on com.google.android.gms");
                        int i11 = bVarC.f7991b;
                        if (i11 == -1) {
                            i11 = 16;
                        }
                        if (bVarC.f7992c != null) {
                            bundle = new Bundle();
                            bundle.putParcelable("pendingIntent", bVarC.f7992c);
                        }
                        int i12 = this.f8882w.get();
                        e0 e0Var = new e0(this, i11, bundle);
                        a0 a0Var = this.f;
                        a0Var.sendMessage(a0Var.obtainMessage(7, i12, -1, e0Var));
                    }
                } else if (i10 == 4) {
                    y.g(iInterface);
                    System.currentTimeMillis();
                }
            } finally {
            }
        }
    }
}

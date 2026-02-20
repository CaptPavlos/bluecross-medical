package h0;

import android.content.Context;
import android.content.res.Resources;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.measurement.h0;
import com.google.android.gms.internal.measurement.l5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n implements g0.e, g0.f {

    /* renamed from: b, reason: collision with root package name */
    public final g0.b f8381b;

    /* renamed from: k, reason: collision with root package name */
    public final a f8382k;

    /* renamed from: l, reason: collision with root package name */
    public final a4.f f8383l;

    /* renamed from: o, reason: collision with root package name */
    public final int f8386o;

    /* renamed from: p, reason: collision with root package name */
    public final v f8387p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f8388q;
    public final /* synthetic */ e t;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList f8380a = new LinkedList();

    /* renamed from: m, reason: collision with root package name */
    public final HashSet f8384m = new HashSet();

    /* renamed from: n, reason: collision with root package name */
    public final HashMap f8385n = new HashMap();

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f8389r = new ArrayList();

    /* renamed from: s, reason: collision with root package name */
    public f0.b f8390s = null;

    /* JADX WARN: Multi-variable type inference failed */
    public n(e eVar, g0.d dVar) {
        this.t = eVar;
        Looper looper = eVar.f8371m.getLooper();
        a3.x xVarA = dVar.a();
        d5.j jVar = new d5.j((String) xVarA.f182c, (ArraySet) xVarA.f181b, (String) xVarA.f183d);
        l5 l5Var = (l5) dVar.f8189c.f218b;
        i0.y.g(l5Var);
        g0.b bVarH = l5Var.h(dVar.f8187a, looper, jVar, dVar.f8190d, this, this);
        String str = dVar.f8188b;
        if (str != null && (bVarH instanceof i0.e)) {
            ((i0.e) bVarH).f8879s = str;
        }
        if (str != null && (bVarH instanceof h)) {
            com.mbridge.msdk.dycreator.baseview.a.s(bVarH);
            throw null;
        }
        this.f8381b = bVarH;
        this.f8382k = dVar.e;
        this.f8383l = new a4.f();
        this.f8386o = dVar.g;
        if (!bVarH.l()) {
            this.f8387p = null;
            return;
        }
        Context context = eVar.e;
        h0 h0Var = eVar.f8371m;
        a3.x xVarA2 = dVar.a();
        this.f8387p = new v(context, h0Var, new d5.j((String) xVarA2.f182c, (ArraySet) xVarA2.f181b, (String) xVarA2.f183d));
    }

    @Override // g0.f
    public final void a(f0.b bVar) {
        o(bVar, null);
    }

    public final void b(f0.b bVar) {
        HashSet hashSet = this.f8384m;
        Iterator it = hashSet.iterator();
        if (!it.hasNext()) {
            hashSet.clear();
        } else if (it.next() != null) {
            com.google.gson.internal.a.k();
        } else {
            if (i0.y.j(bVar, f0.b.e)) {
                this.f8381b.f();
            }
            throw null;
        }
    }

    @Override // g0.e
    public final void c(int i10) {
        Looper looperMyLooper = Looper.myLooper();
        h0 h0Var = this.t.f8371m;
        if (looperMyLooper == h0Var.getLooper()) {
            i(i10);
        } else {
            h0Var.post(new m(this, i10, 0));
        }
    }

    @Override // g0.e
    public final void d() {
        Looper looperMyLooper = Looper.myLooper();
        h0 h0Var = this.t.f8371m;
        if (looperMyLooper == h0Var.getLooper()) {
            h();
        } else {
            h0Var.post(new a4.a(this, 10));
        }
    }

    public final void e(Status status) {
        i0.y.c(this.t.f8371m);
        f(status, null, false);
    }

    public final void f(Status status, Exception exc, boolean z9) {
        i0.y.c(this.t.f8371m);
        if ((status == null) == (exc == null)) {
            com.google.gson.internal.a.n("Status XOR exception should be null");
            return;
        }
        Iterator it = this.f8380a.iterator();
        while (it.hasNext()) {
            z zVar = (z) it.next();
            if (!z9 || zVar.f8417a == 2) {
                if (status != null) {
                    zVar.a(status);
                } else {
                    zVar.b(exc);
                }
                it.remove();
            }
        }
    }

    public final void g() {
        LinkedList linkedList = this.f8380a;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            z zVar = (z) arrayList.get(i10);
            if (!this.f8381b.h()) {
                return;
            }
            if (k(zVar)) {
                linkedList.remove(zVar);
            }
        }
    }

    public final void h() {
        e eVar = this.t;
        i0.y.c(eVar.f8371m);
        this.f8390s = null;
        b(f0.b.e);
        h0 h0Var = eVar.f8371m;
        if (this.f8388q) {
            a aVar = this.f8382k;
            h0Var.removeMessages(11, aVar);
            h0Var.removeMessages(9, aVar);
            this.f8388q = false;
        }
        Iterator it = this.f8385n.values().iterator();
        if (it.hasNext()) {
            it.next().getClass();
            com.google.gson.internal.a.k();
        } else {
            g();
            j();
        }
    }

    public final void i(int i10) {
        e eVar = this.t;
        h0 h0Var = eVar.f8371m;
        i0.y.c(eVar.f8371m);
        this.f8390s = null;
        this.f8388q = true;
        String strK = this.f8381b.k();
        a4.f fVar = this.f8383l;
        fVar.getClass();
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i10 == 1) {
            sb.append(" due to service disconnection.");
        } else if (i10 == 3) {
            sb.append(" due to dead object exception.");
        }
        if (strK != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(strK);
        }
        fVar.n(true, new Status(20, sb.toString(), null, null));
        a aVar = this.f8382k;
        h0Var.sendMessageDelayed(Message.obtain(h0Var, 9, aVar), 5000L);
        h0Var.sendMessageDelayed(Message.obtain(h0Var, 11, aVar), 120000L);
        ((SparseIntArray) eVar.g.f8923b).clear();
        Iterator it = this.f8385n.values().iterator();
        if (it.hasNext()) {
            it.next().getClass();
            com.google.gson.internal.a.k();
        }
    }

    public final void j() {
        e eVar = this.t;
        h0 h0Var = eVar.f8371m;
        a aVar = this.f8382k;
        h0Var.removeMessages(12, aVar);
        h0Var.sendMessageDelayed(h0Var.obtainMessage(12, aVar), eVar.f8363a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean k(z zVar) throws Resources.NotFoundException {
        f0.d dVar;
        if (!(zVar instanceof s)) {
            a4.f fVar = this.f8383l;
            g0.b bVar = this.f8381b;
            zVar.d(fVar, bVar.l());
            try {
                zVar.c(this);
                return true;
            } catch (DeadObjectException unused) {
                c(1);
                bVar.c("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
        s sVar = (s) zVar;
        f0.d[] dVarArrG = sVar.g(this);
        if (dVarArrG == null || dVarArrG.length == 0) {
            dVar = null;
        } else {
            f0.d[] dVarArrJ = this.f8381b.j();
            if (dVarArrJ == null) {
                dVarArrJ = new f0.d[0];
            }
            ArrayMap arrayMap = new ArrayMap(dVarArrJ.length);
            for (f0.d dVar2 : dVarArrJ) {
                arrayMap.put(dVar2.f7997a, Long.valueOf(dVar2.b()));
            }
            int length = dVarArrG.length;
            for (int i10 = 0; i10 < length; i10++) {
                dVar = dVarArrG[i10];
                Long l10 = (Long) arrayMap.get(dVar.f7997a);
                if (l10 == null || l10.longValue() < dVar.b()) {
                    break;
                }
            }
            dVar = null;
        }
        if (dVar == null) {
            a4.f fVar2 = this.f8383l;
            g0.b bVar2 = this.f8381b;
            zVar.d(fVar2, bVar2.l());
            try {
                zVar.c(this);
                return true;
            } catch (DeadObjectException unused2) {
                c(1);
                bVar2.c("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
        Log.w("GoogleApiManager", this.f8381b.getClass().getName() + " could not execute call because it requires feature (" + dVar.f7997a + ", " + dVar.b() + ").");
        if (!this.t.f8372n || !sVar.f(this)) {
            sVar.b(new g0.j(dVar));
            return true;
        }
        o oVar = new o(this.f8382k, dVar);
        int iIndexOf = this.f8389r.indexOf(oVar);
        ArrayList arrayList = this.f8389r;
        if (iIndexOf >= 0) {
            o oVar2 = (o) arrayList.get(iIndexOf);
            this.t.f8371m.removeMessages(15, oVar2);
            h0 h0Var = this.t.f8371m;
            h0Var.sendMessageDelayed(Message.obtain(h0Var, 15, oVar2), 5000L);
        } else {
            arrayList.add(oVar);
            h0 h0Var2 = this.t.f8371m;
            h0Var2.sendMessageDelayed(Message.obtain(h0Var2, 15, oVar), 5000L);
            h0 h0Var3 = this.t.f8371m;
            h0Var3.sendMessageDelayed(Message.obtain(h0Var3, 16, oVar), 120000L);
            f0.b bVar3 = new f0.b(2, null);
            if (!l(bVar3)) {
                this.t.a(bVar3, this.f8386o);
            }
        }
        return false;
    }

    public final boolean l(f0.b bVar) {
        synchronized (e.f8361q) {
        }
        return false;
    }

    public final void m() {
        e eVar = this.t;
        i0.y.c(eVar.f8371m);
        g0.b bVar = this.f8381b;
        if (bVar.h() || bVar.e()) {
            return;
        }
        try {
            i0.k kVar = eVar.g;
            Context context = eVar.e;
            SparseIntArray sparseIntArray = (SparseIntArray) kVar.f8923b;
            i0.y.g(context);
            int i10 = bVar.i();
            int iB = ((SparseIntArray) kVar.f8923b).get(i10, -1);
            if (iB == -1) {
                iB = 0;
                int i11 = 0;
                while (true) {
                    if (i11 >= sparseIntArray.size()) {
                        iB = -1;
                        break;
                    }
                    int iKeyAt = sparseIntArray.keyAt(i11);
                    if (iKeyAt > i10 && sparseIntArray.get(iKeyAt) == 0) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (iB == -1) {
                    iB = ((f0.e) kVar.f8924c).b(context, i10);
                }
                sparseIntArray.put(i10, iB);
            }
            if (iB != 0) {
                f0.b bVar2 = new f0.b(iB, null);
                Log.w("GoogleApiManager", "The service for " + bVar.getClass().getName() + " is not available: " + bVar2.toString());
                o(bVar2, null);
                return;
            }
            p pVar = new p();
            pVar.f = eVar;
            pVar.f8396d = null;
            pVar.e = null;
            pVar.f8393a = false;
            pVar.f8394b = bVar;
            pVar.f8395c = this.f8382k;
            if (bVar.l()) {
                v vVar = this.f8387p;
                i0.y.g(vVar);
                Handler handler = vVar.f8406k;
                d5.j jVar = vVar.f8409n;
                f1.a aVar = vVar.f8410o;
                if (aVar != null) {
                    aVar.o();
                }
                jVar.g = Integer.valueOf(System.identityHashCode(vVar));
                vVar.f8410o = (f1.a) vVar.f8407l.h(vVar.f8405b, handler.getLooper(), jVar, (e1.a) jVar.f, vVar, vVar);
                vVar.f8411p = pVar;
                Set set = vVar.f8408m;
                if (set == null || set.isEmpty()) {
                    handler.post(new a4.a(vVar, 12));
                } else {
                    f1.a aVar2 = vVar.f8410o;
                    aVar2.getClass();
                    aVar2.a(new i0.l(aVar2));
                }
            }
            try {
                bVar.a(pVar);
            } catch (SecurityException e) {
                o(new f0.b(10), e);
            }
        } catch (IllegalStateException e3) {
            o(new f0.b(10), e3);
        }
    }

    public final void n(z zVar) {
        i0.y.c(this.t.f8371m);
        boolean zH = this.f8381b.h();
        LinkedList linkedList = this.f8380a;
        if (zH) {
            if (k(zVar)) {
                j();
                return;
            } else {
                linkedList.add(zVar);
                return;
            }
        }
        linkedList.add(zVar);
        f0.b bVar = this.f8390s;
        if (bVar == null || bVar.f7991b == 0 || bVar.f7992c == null) {
            m();
        } else {
            o(bVar, null);
        }
    }

    public final void o(f0.b bVar, RuntimeException runtimeException) {
        f1.a aVar;
        i0.y.c(this.t.f8371m);
        v vVar = this.f8387p;
        if (vVar != null && (aVar = vVar.f8410o) != null) {
            aVar.o();
        }
        i0.y.c(this.t.f8371m);
        this.f8390s = null;
        ((SparseIntArray) this.t.g.f8923b).clear();
        b(bVar);
        if ((this.f8381b instanceof k0.c) && bVar.f7991b != 24) {
            e eVar = this.t;
            eVar.f8364b = true;
            h0 h0Var = eVar.f8371m;
            h0Var.sendMessageDelayed(h0Var.obtainMessage(19), PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
        }
        if (bVar.f7991b == 4) {
            e(e.f8360p);
            return;
        }
        if (this.f8380a.isEmpty()) {
            this.f8390s = bVar;
            return;
        }
        e eVar2 = this.t;
        if (runtimeException != null) {
            i0.y.c(eVar2.f8371m);
            f(null, runtimeException, false);
            return;
        }
        boolean z9 = eVar2.f8372n;
        a aVar2 = this.f8382k;
        if (!z9) {
            e(e.b(aVar2, bVar));
            return;
        }
        f(e.b(aVar2, bVar), null, true);
        if (this.f8380a.isEmpty() || l(bVar) || this.t.a(bVar, this.f8386o)) {
            return;
        }
        if (bVar.f7991b == 18) {
            this.f8388q = true;
        }
        if (!this.f8388q) {
            e(e.b(this.f8382k, bVar));
            return;
        }
        e eVar3 = this.t;
        a aVar3 = this.f8382k;
        h0 h0Var2 = eVar3.f8371m;
        h0Var2.sendMessageDelayed(Message.obtain(h0Var2, 9, aVar3), 5000L);
    }

    public final void p(f0.b bVar) {
        i0.y.c(this.t.f8371m);
        g0.b bVar2 = this.f8381b;
        bVar2.c("onSignInFailed for " + bVar2.getClass().getName() + " with " + String.valueOf(bVar));
        o(bVar, null);
    }

    public final void q() {
        i0.y.c(this.t.f8371m);
        Status status = e.f8359o;
        e(status);
        this.f8383l.n(false, status);
        for (g gVar : (g[]) this.f8385n.keySet().toArray(new g[0])) {
            n(new y(new h1.i()));
        }
        b(new f0.b(4));
        g0.b bVar = this.f8381b;
        if (bVar.h()) {
            bVar.g(new d0.i(this, 14));
        }
    }
}

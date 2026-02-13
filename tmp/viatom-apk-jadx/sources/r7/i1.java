package r7;

import com.google.android.gms.internal.measurement.u6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class i1 implements a1 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f12408a = AtomicReferenceFieldUpdater.newUpdater(i1.class, Object.class, "_state$volatile");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f12409b = AtomicReferenceFieldUpdater.newUpdater(i1.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    public i1(boolean z9) {
        this._state$volatile = z9 ? y.f12454j : y.f12453i;
    }

    public static k S(w7.j jVar) {
        while (jVar.g()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = w7.j.f13540b;
            w7.j jVarD = jVar.d();
            if (jVarD == null) {
                Object obj = atomicReferenceFieldUpdater.get(jVar);
                while (true) {
                    jVar = (w7.j) obj;
                    if (!jVar.g()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(jVar);
                }
            } else {
                jVar = jVarD;
            }
        }
        while (true) {
            jVar = jVar.f();
            if (!jVar.g()) {
                if (jVar instanceof k) {
                    return (k) jVar;
                }
                if (jVar instanceof k1) {
                    return null;
                }
            }
        }
    }

    public static String Z(Object obj) {
        if (!(obj instanceof h1)) {
            return obj instanceof x0 ? ((x0) obj).isActive() ? "Active" : "New" : obj instanceof p ? "Cancelled" : "Completed";
        }
        h1 h1Var = (h1) obj;
        return h1Var.d() ? "Cancelling" : h1.f12403b.get(h1Var) != 0 ? "Completing" : "Active";
    }

    public boolean A(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return w(th) && G();
    }

    public final void B(x0 x0Var, Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12409b;
        j jVar = (j) atomicReferenceFieldUpdater.get(this);
        if (jVar != null) {
            jVar.dispose();
            atomicReferenceFieldUpdater.set(this, m1.f12414a);
        }
        u6 u6Var = null;
        p pVar = obj instanceof p ? (p) obj : null;
        Throwable th = pVar != null ? pVar.f12426a : null;
        if (x0Var instanceof e1) {
            try {
                ((e1) x0Var).j(th);
                return;
            } catch (Throwable th2) {
                K(new u6("Exception in completion handler " + x0Var + " for " + this, th2));
                return;
            }
        }
        k1 k1VarB = x0Var.b();
        if (k1VarB != null) {
            k1VarB.c(new w7.h(1), 1);
            Object obj2 = w7.j.f13539a.get(k1VarB);
            obj2.getClass();
            for (w7.j jVarF = (w7.j) obj2; !jVarF.equals(k1VarB); jVarF = jVarF.f()) {
                if (jVarF instanceof e1) {
                    try {
                        ((e1) jVarF).j(th);
                    } catch (Throwable th3) {
                        if (u6Var != null) {
                            s6.a.a(u6Var, th3);
                        } else {
                            u6Var = new u6("Exception in completion handler " + jVarF + " for " + this, th3);
                        }
                    }
                }
            }
            if (u6Var != null) {
                K(u6Var);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Throwable] */
    public final Throwable C(Object obj) {
        CancellationException cancellationExceptionC;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        i1 i1Var = (i1) obj;
        Object obj2 = f12408a.get(i1Var);
        if (obj2 instanceof h1) {
            cancellationExceptionC = ((h1) obj2).c();
        } else if (obj2 instanceof p) {
            cancellationExceptionC = ((p) obj2).f12426a;
        } else {
            if (obj2 instanceof x0) {
                p8.u.i(obj2, "Cannot be cancelling child in this state: ");
                return null;
            }
            cancellationExceptionC = null;
        }
        CancellationException cancellationException = cancellationExceptionC instanceof CancellationException ? cancellationExceptionC : null;
        return cancellationException == null ? new b1("Parent job is ".concat(Z(obj2)), cancellationExceptionC, i1Var) : cancellationException;
    }

    public final Object D(h1 h1Var, Object obj) {
        Throwable thF;
        p pVar = obj instanceof p ? (p) obj : null;
        Throwable th = pVar != null ? pVar.f12426a : null;
        synchronized (h1Var) {
            h1Var.d();
            ArrayList arrayListE = h1Var.e(th);
            thF = F(h1Var, arrayListE);
            if (thF != null && arrayListE.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListE.size()));
                int size = arrayListE.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj2 = arrayListE.get(i10);
                    i10++;
                    Throwable th2 = (Throwable) obj2;
                    if (th2 != thF && th2 != thF && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        s6.a.a(thF, th2);
                    }
                }
            }
        }
        if (thF != null && thF != th) {
            obj = new p(false, thF);
        }
        if (thF != null && (y(thF) || J(thF))) {
            obj.getClass();
            p.f12425b.compareAndSet((p) obj, 0, 1);
        }
        U(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12408a;
        Object y0Var = obj instanceof x0 ? new y0((x0) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, h1Var, y0Var) && atomicReferenceFieldUpdater.get(this) == h1Var) {
        }
        B(h1Var, obj);
        return obj;
    }

    public final Object E() throws Throwable {
        Object obj = f12408a.get(this);
        if (obj instanceof x0) {
            androidx.window.layout.c.g("This job has not completed yet");
            return null;
        }
        if (obj instanceof p) {
            throw ((p) obj).f12426a;
        }
        return y.x(obj);
    }

    public final Throwable F(h1 h1Var, ArrayList arrayList) {
        Object obj;
        Object obj2 = null;
        if (arrayList.isEmpty()) {
            if (h1Var.d()) {
                return new b1(z(), null, this);
            }
            return null;
        }
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i11);
            i11++;
            if (!(((Throwable) obj) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = (Throwable) arrayList.get(0);
        if (th2 instanceof s1) {
            int size2 = arrayList.size();
            while (true) {
                if (i10 >= size2) {
                    break;
                }
                Object obj3 = arrayList.get(i10);
                i10++;
                Throwable th3 = (Throwable) obj3;
                if (th3 != th2 && (th3 instanceof s1)) {
                    obj2 = obj3;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    public boolean G() {
        return true;
    }

    public boolean H() {
        return this instanceof m;
    }

    public final k1 I(x0 x0Var) {
        k1 k1VarB = x0Var.b();
        if (k1VarB != null) {
            return k1VarB;
        }
        if (x0Var instanceof m0) {
            return new k1();
        }
        if (x0Var instanceof e1) {
            X((e1) x0Var);
            return null;
        }
        p8.u.i(x0Var, "State should have list: ");
        return null;
    }

    public boolean J(Throwable th) {
        return false;
    }

    public final void L(a1 a1Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12409b;
        m1 m1Var = m1.f12414a;
        if (a1Var == null) {
            atomicReferenceFieldUpdater.set(this, m1Var);
            return;
        }
        a1Var.start();
        j jVarJ = a1Var.j(this);
        atomicReferenceFieldUpdater.set(this, jVarJ);
        if (N()) {
            jVarJ.dispose();
            atomicReferenceFieldUpdater.set(this, m1Var);
        }
    }

    public final k0 M(boolean z9, e1 e1Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        m1 m1Var;
        boolean z10;
        boolean zC;
        e1Var.f12397d = this;
        loop0: while (true) {
            atomicReferenceFieldUpdater = f12408a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            boolean z11 = obj instanceof m0;
            m1Var = m1.f12414a;
            z10 = true;
            if (!z11) {
                if (!(obj instanceof x0)) {
                    z10 = false;
                    break;
                }
                x0 x0Var = (x0) obj;
                k1 k1VarB = x0Var.b();
                if (k1VarB == null) {
                    X((e1) obj);
                } else {
                    if (e1Var.i()) {
                        h1 h1Var = x0Var instanceof h1 ? (h1) x0Var : null;
                        Throwable thC = h1Var != null ? h1Var.c() : null;
                        if (thC == null) {
                            zC = k1VarB.c(e1Var, 5);
                        } else if (z9) {
                            e1Var.j(thC);
                            return m1Var;
                        }
                    } else {
                        zC = k1VarB.c(e1Var, 1);
                    }
                    if (zC) {
                        break;
                    }
                }
            } else {
                m0 m0Var = (m0) obj;
                if (m0Var.f12413a) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, e1Var)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    break loop0;
                }
                W(m0Var);
            }
        }
        if (z10) {
            return e1Var;
        }
        if (z9) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            p pVar = obj2 instanceof p ? (p) obj2 : null;
            e1Var.j(pVar != null ? pVar.f12426a : null);
        }
        return m1Var;
    }

    public final boolean N() {
        return !(f12408a.get(this) instanceof x0);
    }

    public boolean O() {
        return this instanceof c;
    }

    public final boolean P(Object obj) {
        Object objA0;
        do {
            objA0 = a0(f12408a.get(this), obj);
            if (objA0 == y.f12452d) {
                return false;
            }
            if (objA0 == y.e) {
                return true;
            }
        } while (objA0 == y.f);
        t(objA0);
        return true;
    }

    public final Object Q(Object obj) {
        Object objA0;
        do {
            objA0 = a0(f12408a.get(this), obj);
            if (objA0 == y.f12452d) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                p pVar = obj instanceof p ? (p) obj : null;
                throw new IllegalStateException(str, pVar != null ? pVar.f12426a : null);
            }
        } while (objA0 == y.f);
        return objA0;
    }

    public String R() {
        return getClass().getSimpleName();
    }

    public final void T(k1 k1Var, Throwable th) {
        k1Var.c(new w7.h(4), 4);
        Object obj = w7.j.f13539a.get(k1Var);
        obj.getClass();
        u6 u6Var = null;
        for (w7.j jVarF = (w7.j) obj; !jVarF.equals(k1Var); jVarF = jVarF.f()) {
            if ((jVarF instanceof e1) && ((e1) jVarF).i()) {
                try {
                    ((e1) jVarF).j(th);
                } catch (Throwable th2) {
                    if (u6Var != null) {
                        s6.a.a(u6Var, th2);
                    } else {
                        u6Var = new u6("Exception in completion handler " + jVarF + " for " + this, th2);
                    }
                }
            }
        }
        if (u6Var != null) {
            K(u6Var);
        }
        y(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [r7.w0] */
    public final void W(m0 m0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        k1 k1Var = new k1();
        if (!m0Var.f12413a) {
            k1Var = new w0(k1Var);
        }
        do {
            atomicReferenceFieldUpdater = f12408a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, m0Var, k1Var)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == m0Var);
    }

    public final void X(e1 e1Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        k1 k1Var = new k1();
        e1Var.getClass();
        w7.j.f13540b.set(k1Var, e1Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = w7.j.f13539a;
        atomicReferenceFieldUpdater2.set(k1Var, e1Var);
        loop0: while (true) {
            if (atomicReferenceFieldUpdater2.get(e1Var) == e1Var) {
                while (!atomicReferenceFieldUpdater2.compareAndSet(e1Var, e1Var, k1Var)) {
                    if (atomicReferenceFieldUpdater2.get(e1Var) != e1Var) {
                        break;
                    }
                }
                k1Var.e(e1Var);
                break loop0;
            }
            break;
        }
        w7.j jVarF = e1Var.f();
        do {
            atomicReferenceFieldUpdater = f12408a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, e1Var, jVarF)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == e1Var);
    }

    public final int Y(Object obj) {
        boolean z9 = obj instanceof m0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12408a;
        if (z9) {
            if (((m0) obj).f12413a) {
                return 0;
            }
            m0 m0Var = y.f12454j;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, m0Var)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    return -1;
                }
            }
            V();
            return 1;
        }
        if (!(obj instanceof w0)) {
            return 0;
        }
        k1 k1Var = ((w0) obj).f12443a;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, k1Var)) {
            if (atomicReferenceFieldUpdater.get(this) != obj) {
                return -1;
            }
        }
        V();
        return 1;
    }

    @Override // r7.a1
    public void a(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new b1(z(), null, this);
        }
        x(cancellationException);
    }

    public final Object a0(Object obj, Object obj2) {
        if (!(obj instanceof x0)) {
            return y.f12452d;
        }
        if (((obj instanceof m0) || (obj instanceof e1)) && !(obj instanceof k) && !(obj2 instanceof p)) {
            x0 x0Var = (x0) obj;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12408a;
            Object y0Var = obj2 instanceof x0 ? new y0((x0) obj2) : obj2;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, x0Var, y0Var)) {
                if (atomicReferenceFieldUpdater.get(this) != x0Var) {
                    return y.f;
                }
            }
            U(obj2);
            B(x0Var, obj2);
            return obj2;
        }
        x0 x0Var2 = (x0) obj;
        k1 k1VarI = I(x0Var2);
        if (k1VarI == null) {
            return y.f;
        }
        h1 h1Var = x0Var2 instanceof h1 ? (h1) x0Var2 : null;
        if (h1Var == null) {
            h1Var = new h1(k1VarI, null);
        }
        synchronized (h1Var) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = h1.f12403b;
            if (atomicIntegerFieldUpdater.get(h1Var) != 0) {
                return y.f12452d;
            }
            atomicIntegerFieldUpdater.set(h1Var, 1);
            if (h1Var != x0Var2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f12408a;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, x0Var2, h1Var)) {
                    if (atomicReferenceFieldUpdater2.get(this) != x0Var2) {
                        return y.f;
                    }
                }
            }
            boolean zD = h1Var.d();
            p pVar = obj2 instanceof p ? (p) obj2 : null;
            if (pVar != null) {
                h1Var.a(pVar.f12426a);
            }
            Throwable thC = zD ? null : h1Var.c();
            if (thC != null) {
                T(k1VarI, thC);
            }
            k kVarS = S(k1VarI);
            if (kVarS != null && b0(h1Var, kVarS, obj2)) {
                return y.e;
            }
            k1VarI.c(new w7.h(2), 2);
            k kVarS2 = S(k1VarI);
            return (kVarS2 == null || !b0(h1Var, kVarS2, obj2)) ? D(h1Var, obj2) : y.e;
        }
    }

    public Object b() {
        return E();
    }

    public final boolean b0(h1 h1Var, k kVar, Object obj) {
        while (y.p(kVar.e, false, new g1(this, h1Var, kVar, obj)) == m1.f12414a) {
            kVar = S(kVar);
            if (kVar == null) {
                return false;
            }
        }
        return true;
    }

    @Override // r7.a1
    public final Object d(w6.c cVar) {
        Object obj;
        s6.w wVar;
        do {
            obj = f12408a.get(this);
            boolean z9 = obj instanceof x0;
            wVar = s6.w.f12711a;
            if (!z9) {
                y.i(cVar.getContext());
                return wVar;
            }
        } while (Y(obj) < 0);
        g gVar = new g(1, r0.f.F(cVar));
        gVar.s();
        gVar.v(new e(y.p(this, true, new i(gVar, 1)), 2));
        Object objQ = gVar.q();
        x6.a aVar = x6.a.f13718a;
        if (objQ != aVar) {
            objQ = wVar;
        }
        return objQ == aVar ? objQ : wVar;
    }

    @Override // r7.a1
    public final CancellationException e() {
        CancellationException cancellationException;
        Object obj = f12408a.get(this);
        if (obj instanceof h1) {
            Throwable thC = ((h1) obj).c();
            if (thC == null) {
                p8.u.i(this, "Job is still new or active: ");
                return null;
            }
            String strConcat = getClass().getSimpleName().concat(" is cancelling");
            cancellationException = thC instanceof CancellationException ? (CancellationException) thC : null;
            return cancellationException == null ? new b1(strConcat, thC, this) : cancellationException;
        }
        if (obj instanceof x0) {
            p8.u.i(this, "Job is still new or active: ");
            return null;
        }
        if (!(obj instanceof p)) {
            return new b1(getClass().getSimpleName().concat(" has completed normally"), null, this);
        }
        Throwable th = ((p) obj).f12426a;
        cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        return cancellationException == null ? new b1(z(), th, this) : cancellationException;
    }

    @Override // w6.h
    public final Object fold(Object obj, g7.p pVar) {
        return pVar.invoke(obj, this);
    }

    @Override // w6.h
    public final w6.f get(w6.g gVar) {
        return z1.t1.p(this, gVar);
    }

    @Override // w6.f
    public final w6.g getKey() {
        return t.f12437b;
    }

    public Object i(w6.c cVar) {
        return v(cVar);
    }

    @Override // r7.a1
    public boolean isActive() {
        Object obj = f12408a.get(this);
        return (obj instanceof x0) && ((x0) obj).isActive();
    }

    @Override // r7.a1
    public final boolean isCancelled() {
        Object obj = f12408a.get(this);
        if (obj instanceof p) {
            return true;
        }
        return (obj instanceof h1) && ((h1) obj).d();
    }

    @Override // r7.a1
    public final j j(i1 i1Var) {
        k kVar = new k(i1Var);
        kVar.f12397d = this;
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12408a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof m0) {
                m0 m0Var = (m0) obj;
                if (m0Var.f12413a) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, kVar)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    break loop0;
                }
                W(m0Var);
            } else {
                boolean z9 = obj instanceof x0;
                m1 m1Var = m1.f12414a;
                if (!z9) {
                    Object obj2 = atomicReferenceFieldUpdater.get(this);
                    p pVar = obj2 instanceof p ? (p) obj2 : null;
                    kVar.j(pVar != null ? pVar.f12426a : null);
                    return m1Var;
                }
                k1 k1VarB = ((x0) obj).b();
                if (k1VarB == null) {
                    X((e1) obj);
                } else if (!k1VarB.c(kVar, 7)) {
                    boolean zC = k1VarB.c(kVar, 3);
                    Object obj3 = atomicReferenceFieldUpdater.get(this);
                    if (obj3 instanceof h1) {
                        thC = ((h1) obj3).c();
                    } else {
                        p pVar2 = obj3 instanceof p ? (p) obj3 : null;
                        if (pVar2 != null) {
                            thC = pVar2.f12426a;
                        }
                    }
                    kVar.j(thC);
                    if (zC) {
                        break loop0;
                    }
                    return m1Var;
                }
            }
        }
        return kVar;
    }

    @Override // r7.a1
    public final k0 m(boolean z9, boolean z10, d1 d1Var) {
        return M(z10, z9 ? new z0(d1Var) : new l0(d1Var, 1));
    }

    @Override // w6.h
    public final w6.h minusKey(w6.g gVar) {
        return z1.t1.K(this, gVar);
    }

    @Override // w6.h
    public final w6.h plus(w6.h hVar) {
        return z1.t1.M(this, hVar);
    }

    @Override // r7.a1
    public final k0 s(g7.l lVar) {
        return M(true, new l0(lVar, 1));
    }

    @Override // r7.a1
    public final boolean start() {
        int iY;
        do {
            iY = Y(f12408a.get(this));
            if (iY == 0) {
                return false;
            }
        } while (iY != 1);
        return true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(R() + '{' + Z(f12408a.get(this)) + '}');
        sb.append('@');
        sb.append(y.m(this));
        return sb.toString();
    }

    public void u(Object obj) {
        t(obj);
    }

    public final Object v(w6.c cVar) throws Throwable {
        Object obj;
        do {
            obj = f12408a.get(this);
            if (!(obj instanceof x0)) {
                if (obj instanceof p) {
                    throw ((p) obj).f12426a;
                }
                return y.x(obj);
            }
        } while (Y(obj) < 0);
        f1 f1Var = new f1(r0.f.F(cVar), this);
        f1Var.s();
        f1Var.v(new e(y.p(this, true, new l0(f1Var, 2)), 2));
        return f1Var.q();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
    
        r0 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[PHI: r0
      0x003e: PHI (r0v1 java.lang.Object) = (r0v0 java.lang.Object), (r0v10 java.lang.Object) binds: [B:3:0x0008, B:16:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean w(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r7.i1.w(java.lang.Object):boolean");
    }

    public void x(CancellationException cancellationException) {
        w(cancellationException);
    }

    public final boolean y(Throwable th) {
        if (O()) {
            return true;
        }
        boolean z9 = th instanceof CancellationException;
        j jVar = (j) f12409b.get(this);
        return (jVar == null || jVar == m1.f12414a) ? z9 : jVar.a(th) || z9;
    }

    public String z() {
        return "Job was cancelled";
    }

    public void V() {
    }

    public void K(u6 u6Var) {
        throw u6Var;
    }

    public void U(Object obj) {
    }

    public void t(Object obj) {
    }
}

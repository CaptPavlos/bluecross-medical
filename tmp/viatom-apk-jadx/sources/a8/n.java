package a8;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p8.u;
import r7.x1;
import s6.w;
import w7.s;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class n {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f321c = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "head$volatile");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f322d = AtomicLongFieldUpdater.newUpdater(n.class, "deqIdx$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "tail$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(n.class, "enqIdx$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(n.class, "_availablePermits$volatile");
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f323a;

    /* renamed from: b, reason: collision with root package name */
    public final b f324b;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    public n(int i10, int i11) {
        this.f323a = i10;
        if (i10 <= 0) {
            z8.f.b(a3.a.f(i10, "Semaphore should have at least 1 permit, but had "));
            throw null;
        }
        if (i11 < 0 || i11 > i10) {
            z8.f.b(a3.a.f(i10, "The number of acquired permits should be in 0.."));
            throw null;
        }
        q qVar = new q(0L, null, 2);
        this.head$volatile = qVar;
        this.tail$volatile = qVar;
        this._availablePermits$volatile = i10 - i11;
        this.f324b = new b(this, 1);
    }

    public final boolean a(x1 x1Var) {
        Object objB;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
        q qVar = (q) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f.getAndIncrement(this);
        l lVar = l.f319a;
        long j10 = andIncrement / p.f;
        loop0: while (true) {
            objB = w7.a.b(qVar, j10, lVar);
            if (!w7.a.e(objB)) {
                s sVarC = w7.a.c(objB);
                while (true) {
                    s sVar = (s) atomicReferenceFieldUpdater.get(this);
                    if (sVar.f13555c >= sVarC.f13555c) {
                        break loop0;
                    }
                    if (!sVarC.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, sVar, sVarC)) {
                        if (atomicReferenceFieldUpdater.get(this) != sVar) {
                            if (sVarC.e()) {
                                sVarC.d();
                            }
                        }
                    }
                    if (sVar.e()) {
                        sVar.d();
                    }
                }
            } else {
                break;
            }
        }
        q qVar2 = (q) w7.a.c(objB);
        AtomicReferenceArray atomicReferenceArray = qVar2.e;
        int i10 = (int) (andIncrement % p.f);
        while (!atomicReferenceArray.compareAndSet(i10, null, x1Var)) {
            if (atomicReferenceArray.get(i10) != null) {
                e2.a aVar = p.f326b;
                e2.a aVar2 = p.f327c;
                while (!atomicReferenceArray.compareAndSet(i10, aVar, aVar2)) {
                    if (atomicReferenceArray.get(i10) != aVar) {
                        return false;
                    }
                }
                boolean z9 = x1Var instanceof r7.f;
                w wVar = w.f12711a;
                if (z9) {
                    ((r7.f) x1Var).c(wVar, this.f324b);
                    return true;
                }
                if (x1Var instanceof f) {
                    ((f) x1Var).b(wVar);
                    return true;
                }
                u.i(x1Var, "unexpected: ");
                return false;
            }
        }
        x1Var.a(qVar2, i10);
        return true;
    }

    public final void b() {
        int i10;
        Object objB;
        boolean zC;
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g;
            int andIncrement = atomicIntegerFieldUpdater.getAndIncrement(this);
            int i11 = this.f323a;
            if (andIncrement >= i11) {
                do {
                    i10 = atomicIntegerFieldUpdater.get(this);
                    if (i10 <= i11) {
                        break;
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, i11));
                a2.a.g(i11, "The number of released permits cannot be greater than ");
                return;
            }
            if (andIncrement >= 0) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f321c;
            q qVar = (q) atomicReferenceFieldUpdater.get(this);
            long andIncrement2 = f322d.getAndIncrement(this);
            long j10 = andIncrement2 / p.f;
            m mVar = m.f320a;
            while (true) {
                objB = w7.a.b(qVar, j10, mVar);
                if (w7.a.e(objB)) {
                    break;
                }
                s sVarC = w7.a.c(objB);
                while (true) {
                    s sVar = (s) atomicReferenceFieldUpdater.get(this);
                    if (sVar.f13555c >= sVarC.f13555c) {
                        break;
                    }
                    if (!sVarC.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, sVar, sVarC)) {
                        if (atomicReferenceFieldUpdater.get(this) != sVar) {
                            if (sVarC.e()) {
                                sVarC.d();
                            }
                        }
                    }
                    if (sVar.e()) {
                        sVar.d();
                    }
                }
            }
            q qVar2 = (q) w7.a.c(objB);
            AtomicReferenceArray atomicReferenceArray = qVar2.e;
            qVar2.a();
            zC = false;
            if (qVar2.f13555c <= j10) {
                int i12 = (int) (andIncrement2 % p.f);
                Object andSet = atomicReferenceArray.getAndSet(i12, p.f326b);
                if (andSet == null) {
                    int i13 = p.f325a;
                    for (int i14 = 0; i14 < i13; i14++) {
                        if (atomicReferenceArray.get(i12) == p.f327c) {
                            zC = true;
                            break;
                        }
                    }
                    e2.a aVar = p.f326b;
                    e2.a aVar2 = p.f328d;
                    while (true) {
                        if (!atomicReferenceArray.compareAndSet(i12, aVar, aVar2)) {
                            if (atomicReferenceArray.get(i12) != aVar) {
                                break;
                            }
                        } else {
                            zC = true;
                            break;
                        }
                    }
                    zC = !zC;
                } else if (andSet != p.e) {
                    boolean z9 = andSet instanceof r7.f;
                    w wVar = w.f12711a;
                    if (z9) {
                        r7.f fVar = (r7.f) andSet;
                        e2.a aVarF = fVar.f(wVar, this.f324b);
                        if (aVarF != null) {
                            fVar.r(aVarF);
                            zC = true;
                            break;
                            break;
                        }
                    } else {
                        if (!(andSet instanceof f)) {
                            u.i(andSet, "unexpected: ");
                            return;
                        }
                        zC = ((f) andSet).c(this, wVar);
                    }
                }
            }
        } while (!zC);
    }
}

package r7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class e1 extends w7.j implements k0, x0 {

    /* renamed from: d, reason: collision with root package name */
    public i1 f12397d;

    @Override // r7.x0
    public final k1 b() {
        return null;
    }

    @Override // r7.k0
    public final void dispose() {
        i1 i1VarH = h();
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i1.f12408a;
            Object obj = atomicReferenceFieldUpdater.get(i1VarH);
            if (obj instanceof e1) {
                if (obj != this) {
                    return;
                }
                m0 m0Var = y.f12454j;
                while (!atomicReferenceFieldUpdater.compareAndSet(i1VarH, obj, m0Var)) {
                    if (atomicReferenceFieldUpdater.get(i1VarH) != obj) {
                        break;
                    }
                }
                return;
            }
            if (!(obj instanceof x0) || ((x0) obj).b() == null) {
                return;
            }
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = w7.j.f13539a;
                Object obj2 = atomicReferenceFieldUpdater2.get(this);
                if (obj2 instanceof w7.p) {
                    return;
                }
                if (obj2 == this) {
                    return;
                }
                obj2.getClass();
                w7.j jVar = (w7.j) obj2;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = w7.j.f13541c;
                w7.p pVar = (w7.p) atomicReferenceFieldUpdater3.get(jVar);
                if (pVar == null) {
                    pVar = new w7.p(jVar);
                    atomicReferenceFieldUpdater3.set(jVar, pVar);
                }
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj2, pVar)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj2) {
                        break;
                    }
                }
                jVar.d();
                return;
            }
        }
    }

    public a1 getParent() {
        return h();
    }

    public final i1 h() {
        i1 i1Var = this.f12397d;
        if (i1Var != null) {
            return i1Var;
        }
        kotlin.jvm.internal.l.i("job");
        throw null;
    }

    public abstract boolean i();

    @Override // r7.x0
    public final boolean isActive() {
        return true;
    }

    public abstract void j(Throwable th);

    @Override // w7.j
    public final String toString() {
        return getClass().getSimpleName() + '@' + y.m(this) + "[job@" + y.m(h()) + ']';
    }
}

package t7;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import r7.b1;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r extends r7.a implements s, i {

    /* renamed from: d, reason: collision with root package name */
    public final e f12859d;

    public r(w6.h hVar, e eVar) {
        super(hVar, true);
        this.f12859d = eVar;
    }

    @Override // r7.i1, r7.a1
    public final void a(CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new b1(z(), null, this);
        }
        x(cancellationException);
    }

    @Override // r7.a
    public final void c0(boolean z9, Throwable th) {
        if (this.f12859d.f(false, th) || z9) {
            return;
        }
        y.o(th, this.f12387c);
    }

    @Override // r7.a
    public final void d0(Object obj) {
        this.f12859d.k(null);
    }

    public final void f0(q qVar) {
        e eVar = this.f12859d;
        eVar.getClass();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e.f12830j;
        while (!atomicReferenceFieldUpdater.compareAndSet(eVar, null, qVar)) {
            if (atomicReferenceFieldUpdater.get(eVar) != null) {
                while (true) {
                    Object obj = atomicReferenceFieldUpdater.get(eVar);
                    e2.a aVar = g.f12845q;
                    if (obj != aVar) {
                        if (obj == g.f12846r) {
                            androidx.window.layout.c.g("Another handler was already registered and successfully invoked");
                            return;
                        } else {
                            p8.u.i(obj, "Another handler is already registered: ");
                            return;
                        }
                    }
                    e2.a aVar2 = g.f12846r;
                    while (!atomicReferenceFieldUpdater.compareAndSet(eVar, aVar, aVar2)) {
                        if (atomicReferenceFieldUpdater.get(eVar) != aVar) {
                            break;
                        }
                    }
                    qVar.invoke(eVar.n());
                    return;
                }
            }
        }
    }

    @Override // t7.i
    public final Object g() {
        return this.f12859d.g();
    }

    @Override // t7.i
    public final b iterator() {
        e eVar = this.f12859d;
        eVar.getClass();
        return new b(eVar);
    }

    @Override // t7.u
    public final boolean k(Throwable th) {
        return this.f12859d.f(false, th);
    }

    @Override // t7.u
    public final Object l(Object obj, w6.c cVar) {
        return this.f12859d.l(obj, cVar);
    }

    @Override // t7.i
    public final Object o(v7.g gVar) {
        e eVar = this.f12859d;
        eVar.getClass();
        return e.C(eVar, gVar);
    }

    @Override // t7.i
    public final Object p(w6.c cVar) {
        return this.f12859d.p(cVar);
    }

    @Override // t7.u
    public final Object q(Object obj) {
        return this.f12859d.q(obj);
    }

    @Override // r7.i1
    public final void x(CancellationException cancellationException) {
        this.f12859d.f(true, cancellationException);
        w(cancellationException);
    }
}

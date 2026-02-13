package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class l0 extends b {

    /* renamed from: j, reason: collision with root package name */
    public final f0 f9652j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f9653k;

    public l0(f0 f0Var, boolean z9, a aVar, Spliterator spliterator) {
        super(aVar, spliterator);
        this.f9653k = z9;
        this.f9652j = f0Var;
    }

    public l0(l0 l0Var, Spliterator spliterator) {
        super(l0Var, spliterator);
        this.f9653k = l0Var.f9653k;
        this.f9652j = l0Var.f9652j;
    }

    @Override // j$.util.stream.d
    public final d c(Spliterator spliterator) {
        return new l0(this, spliterator);
    }

    @Override // j$.util.stream.b
    public final Object h() {
        return this.f9652j.f9569b;
    }

    @Override // j$.util.stream.d
    public final Object a() {
        a aVar = this.f9549a;
        g8 g8Var = (g8) this.f9652j.f9571d.get();
        aVar.Q(this.f9550b, g8Var);
        Object obj = g8Var.get();
        if (this.f9653k) {
            if (obj != null) {
                d dVar = this;
                while (dVar != null) {
                    d dVar2 = (d) dVar.getCompleter();
                    if (dVar2 != null && dVar2.f9552d != dVar) {
                        g();
                        return obj;
                    }
                    dVar = dVar2;
                }
                AtomicReference atomicReference = this.h;
                while (!atomicReference.compareAndSet(null, obj) && atomicReference.get() == null) {
                }
                return obj;
            }
        } else if (obj != null) {
            AtomicReference atomicReference2 = this.h;
            while (!atomicReference2.compareAndSet(null, obj) && atomicReference2.get() == null) {
            }
        }
        return null;
    }

    @Override // j$.util.stream.d, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        if (this.f9653k) {
            l0 l0Var = (l0) this.f9552d;
            l0 l0Var2 = null;
            while (true) {
                if (l0Var != l0Var2) {
                    Object objI = l0Var.i();
                    if (objI != null && this.f9652j.f9570c.test(objI)) {
                        d(objI);
                        d dVar = this;
                        while (true) {
                            if (dVar != null) {
                                d dVar2 = (d) dVar.getCompleter();
                                if (dVar2 != null && dVar2.f9552d != dVar) {
                                    g();
                                    break;
                                }
                                dVar = dVar2;
                            } else {
                                AtomicReference atomicReference = this.h;
                                while (!atomicReference.compareAndSet(null, objI) && atomicReference.get() == null) {
                                }
                            }
                        }
                    } else {
                        l0Var2 = l0Var;
                        l0Var = (l0) this.e;
                    }
                } else {
                    break;
                }
            }
        }
        super.onCompletion(countedCompleter);
    }
}

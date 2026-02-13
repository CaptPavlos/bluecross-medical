package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public final class v1 extends b {

    /* renamed from: j, reason: collision with root package name */
    public final j$.util.concurrent.t f9776j;

    public v1(j$.util.concurrent.t tVar, a aVar, Spliterator spliterator) {
        super(aVar, spliterator);
        this.f9776j = tVar;
    }

    public v1(v1 v1Var, Spliterator spliterator) {
        super(v1Var, spliterator);
        this.f9776j = v1Var.f9776j;
    }

    @Override // j$.util.stream.d
    public final d c(Spliterator spliterator) {
        return new v1(this, spliterator);
    }

    @Override // j$.util.stream.d
    public final Object a() {
        a aVar = this.f9549a;
        t1 t1Var = (t1) ((Supplier) this.f9776j.f9397c).get();
        aVar.Q(this.f9550b, t1Var);
        boolean z9 = t1Var.f9745b;
        if (z9 == ((u1) this.f9776j.f9396b).f9762b) {
            Boolean boolValueOf = Boolean.valueOf(z9);
            AtomicReference atomicReference = this.h;
            while (!atomicReference.compareAndSet(null, boolValueOf) && atomicReference.get() == null) {
            }
        }
        return null;
    }

    @Override // j$.util.stream.b
    public final Object h() {
        return Boolean.valueOf(!((u1) this.f9776j.f9396b).f9762b);
    }
}

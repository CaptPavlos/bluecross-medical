package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* loaded from: classes2.dex */
public final class w2 extends a3 implements b2 {
    @Override // j$.util.stream.h2
    public final /* synthetic */ void forEach(Consumer consumer) {
        w3.q(this, consumer);
    }

    @Override // j$.util.stream.a3, j$.util.stream.h2
    public final /* synthetic */ h2 j(long j10, long j11, IntFunction intFunction) {
        return w3.t(this, j10, j11);
    }

    @Override // j$.util.stream.a3, j$.util.stream.h2
    public final /* bridge */ /* synthetic */ h2 a(int i10) {
        a(i10);
        throw null;
    }

    @Override // j$.util.stream.a3, j$.util.stream.h2
    public final g2 a(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ void k(Object[] objArr, int i10) {
        w3.n(this, (Double[]) objArr, i10);
    }

    @Override // j$.util.stream.g2
    public final /* bridge */ /* synthetic */ Object b() {
        return w3.g;
    }

    @Override // j$.util.stream.h2
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return j$.util.t1.f9842d;
    }

    @Override // j$.util.stream.h2
    public final /* bridge */ /* synthetic */ j$.util.e1 spliterator() {
        return j$.util.t1.f9842d;
    }
}

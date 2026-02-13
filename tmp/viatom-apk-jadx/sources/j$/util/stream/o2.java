package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* loaded from: classes2.dex */
public final class o2 extends r2 implements b2 {
    @Override // j$.util.stream.h2
    public final /* synthetic */ void forEach(Consumer consumer) {
        w3.q(this, consumer);
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ h2 j(long j10, long j11, IntFunction intFunction) {
        return w3.t(this, j10, j11);
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ void k(Object[] objArr, int i10) {
        w3.n(this, (Double[]) objArr, i10);
    }

    @Override // j$.util.stream.g2
    public final Object newArray(int i10) {
        return new double[i10];
    }

    @Override // j$.util.stream.h2
    public final Spliterator spliterator() {
        return new f3(this);
    }

    @Override // j$.util.stream.h2
    public final j$.util.e1 spliterator() {
        return new f3(this);
    }
}

package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.LongConsumer;

/* loaded from: classes2.dex */
public final class h1 extends k1 {
    @Override // j$.util.stream.a, j$.util.stream.g
    public final n1 sequential() {
        this.f9503a.f9509k = false;
        return this;
    }

    @Override // j$.util.stream.a, j$.util.stream.g
    public final n1 parallel() {
        this.f9503a.f9509k = true;
        return this;
    }

    @Override // j$.util.stream.k1, j$.util.stream.n1
    public final void forEach(LongConsumer longConsumer) {
        if (this.f9503a.f9509k) {
            super.forEach(longConsumer);
        } else {
            k1.T(O()).forEachRemaining(longConsumer);
        }
    }

    @Override // j$.util.stream.k1, j$.util.stream.n1
    public final void forEachOrdered(LongConsumer longConsumer) {
        if (this.f9503a.f9509k) {
            super.forEachOrdered(longConsumer);
        } else {
            k1.T(O()).forEachRemaining(longConsumer);
        }
    }

    @Override // j$.util.stream.g
    public final g unordered() {
        return !z6.ORDERED.j(this.f) ? this : new v(this, z6.f9828r, 4);
    }

    @Override // j$.util.stream.a, j$.util.stream.g
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    @Override // j$.util.stream.a
    public final boolean L() {
        throw new UnsupportedOperationException();
    }

    @Override // j$.util.stream.a
    public final m5 M(int i10, m5 m5Var) {
        throw new UnsupportedOperationException();
    }
}

package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.DoubleConsumer;

/* loaded from: classes2.dex */
public final class y extends b0 {
    @Override // j$.util.stream.a, j$.util.stream.g
    public final e0 sequential() {
        this.f9503a.f9509k = false;
        return this;
    }

    @Override // j$.util.stream.a, j$.util.stream.g
    public final e0 parallel() {
        this.f9503a.f9509k = true;
        return this;
    }

    @Override // j$.util.stream.b0, j$.util.stream.e0
    public final void forEach(DoubleConsumer doubleConsumer) {
        if (this.f9503a.f9509k) {
            super.forEach(doubleConsumer);
        } else {
            b0.T(O()).forEachRemaining(doubleConsumer);
        }
    }

    @Override // j$.util.stream.b0, j$.util.stream.e0
    public final void forEachOrdered(DoubleConsumer doubleConsumer) {
        if (this.f9503a.f9509k) {
            super.forEachOrdered(doubleConsumer);
        } else {
            b0.T(O()).forEachRemaining(doubleConsumer);
        }
    }

    @Override // j$.util.stream.g
    public final g unordered() {
        return !z6.ORDERED.j(this.f) ? this : new t(this, z6.f9828r, 1);
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

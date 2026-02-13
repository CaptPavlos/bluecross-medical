package j$.util.stream;

import j$.util.Spliterator;

/* loaded from: classes2.dex */
public abstract class a1 extends b1 {
    @Override // j$.util.stream.a
    public final boolean L() {
        return false;
    }

    @Override // j$.util.stream.a, j$.util.stream.g
    public final IntStream sequential() {
        this.f9503a.f9509k = false;
        return this;
    }

    @Override // j$.util.stream.a, j$.util.stream.g
    public final IntStream parallel() {
        this.f9503a.f9509k = true;
        return this;
    }

    @Override // j$.util.stream.g
    public final g unordered() {
        return !z6.ORDERED.j(this.f) ? this : new u(this, z6.f9828r, 2);
    }

    @Override // j$.util.stream.a, j$.util.stream.g
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}

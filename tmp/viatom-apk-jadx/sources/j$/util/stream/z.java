package j$.util.stream;

import j$.util.Spliterator;

/* loaded from: classes2.dex */
public abstract class z extends b0 {
    @Override // j$.util.stream.a
    public final boolean L() {
        return true;
    }

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

    @Override // j$.util.stream.g
    public final g unordered() {
        return !z6.ORDERED.j(this.f) ? this : new t(this, z6.f9828r, 1);
    }

    @Override // j$.util.stream.a, j$.util.stream.g
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}

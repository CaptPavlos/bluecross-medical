package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* loaded from: classes2.dex */
public final class s2 extends j2 {
    @Override // j$.util.stream.h2
    public final h2 j(long j10, long j11, IntFunction intFunction) {
        if (j10 == 0 && j11 == this.f9620c) {
            return this;
        }
        long jCount = this.f9618a.count();
        if (j10 >= jCount) {
            return this.f9619b.j(j10 - jCount, j11 - jCount, intFunction);
        }
        h2 h2Var = this.f9618a;
        if (j11 > jCount) {
            return w3.F(a7.REFERENCE, h2Var.j(j10, jCount, intFunction), this.f9619b.j(0L, j11 - jCount, intFunction));
        }
        return h2Var.j(j10, j11, intFunction);
    }

    @Override // j$.util.stream.h2
    public final Spliterator spliterator() {
        return new j3(this);
    }

    @Override // j$.util.stream.h2
    public final void k(Object[] objArr, int i10) {
        Objects.requireNonNull(objArr);
        h2 h2Var = this.f9618a;
        h2Var.k(objArr, i10);
        this.f9619b.k(objArr, i10 + ((int) h2Var.count()));
    }

    @Override // j$.util.stream.h2
    public final Object[] m(IntFunction intFunction) {
        long j10 = this.f9620c;
        if (j10 >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return null;
        }
        Object[] objArr = (Object[]) intFunction.apply((int) j10);
        k(objArr, 0);
        return objArr;
    }

    @Override // j$.util.stream.h2
    public final void forEach(Consumer consumer) {
        this.f9618a.forEach(consumer);
        this.f9619b.forEach(consumer);
    }

    public final String toString() {
        long j10 = this.f9620c;
        return j10 < 32 ? String.format("ConcNode[%s.%s]", this.f9618a, this.f9619b) : String.format("ConcNode[size=%d]", Long.valueOf(j10));
    }
}

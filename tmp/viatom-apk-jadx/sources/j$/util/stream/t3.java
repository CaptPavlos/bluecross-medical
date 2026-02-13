package j$.util.stream;

import java.util.function.IntFunction;

/* loaded from: classes2.dex */
public final class t3 extends w6 implements h2, z1 {
    @Override // j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d8) {
        w3.c();
        throw null;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void accept(int i10) {
        w3.k();
        throw null;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void accept(long j10) {
        w3.l();
        throw null;
    }

    @Override // j$.util.stream.z1
    public final h2 build() {
        return this;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // j$.util.stream.m5
    public final void end() {
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ h2 j(long j10, long j11, IntFunction intFunction) {
        return w3.w(this, j10, j11, intFunction);
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ int o() {
        return 0;
    }

    @Override // j$.util.stream.h2
    public final h2 a(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.h2
    public final void k(Object[] objArr, int i10) {
        long j10 = i10;
        long jCount = count() + j10;
        if (jCount > objArr.length || jCount < j10) {
            throw new IndexOutOfBoundsException("does not fit");
        }
        if (this.f9534c == 0) {
            System.arraycopy(this.e, 0, objArr, i10, this.f9533b);
            return;
        }
        for (int i11 = 0; i11 < this.f9534c; i11++) {
            Object[] objArr2 = this.f[i11];
            System.arraycopy(objArr2, 0, objArr, i10, objArr2.length);
            i10 += this.f[i11].length;
        }
        int i12 = this.f9533b;
        if (i12 > 0) {
            System.arraycopy(this.e, 0, objArr, i10, i12);
        }
    }

    @Override // j$.util.stream.h2
    public final Object[] m(IntFunction intFunction) {
        long jCount = count();
        if (jCount >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return null;
        }
        Object[] objArr = (Object[]) intFunction.apply((int) jCount);
        k(objArr, 0);
        return objArr;
    }

    @Override // j$.util.stream.m5
    public final void c(long j10) {
        clear();
        p(j10);
    }
}

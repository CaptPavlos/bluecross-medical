package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;

/* loaded from: classes2.dex */
public class c3 implements d2 {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f9540a;

    /* renamed from: b, reason: collision with root package name */
    public int f9541b;

    @Override // j$.util.stream.h2
    public final /* synthetic */ void forEach(Consumer consumer) {
        w3.r(this, consumer);
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ h2 j(long j10, long j11, IntFunction intFunction) {
        return w3.u(this, j10, j11);
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ Object[] m(IntFunction intFunction) {
        return w3.m(this, intFunction);
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ int o() {
        return 0;
    }

    @Override // j$.util.stream.h2
    public final /* bridge */ /* synthetic */ h2 a(int i10) {
        a(i10);
        throw null;
    }

    @Override // j$.util.stream.g2, j$.util.stream.h2
    public final g2 a(int i10) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ void k(Object[] objArr, int i10) {
        w3.o(this, (Integer[]) objArr, i10);
    }

    @Override // j$.util.stream.g2
    public final void f(int i10, Object obj) {
        int i11 = this.f9541b;
        System.arraycopy(this.f9540a, 0, (int[]) obj, i10, i11);
    }

    @Override // j$.util.stream.g2
    public final void g(Object obj) {
        IntConsumer intConsumer = (IntConsumer) obj;
        for (int i10 = 0; i10 < this.f9541b; i10++) {
            intConsumer.accept(this.f9540a[i10]);
        }
    }

    public c3(long j10) {
        if (j10 >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            throw null;
        }
        this.f9540a = new int[(int) j10];
        this.f9541b = 0;
    }

    public c3(int[] iArr) {
        this.f9540a = iArr;
        this.f9541b = iArr.length;
    }

    @Override // j$.util.stream.h2
    public final Spliterator spliterator() {
        int i10 = this.f9541b;
        int[] iArr = this.f9540a;
        j$.util.t1.a(((int[]) Objects.requireNonNull(iArr)).length, 0, i10);
        return new j$.util.q1(iArr, 0, i10, 1040);
    }

    @Override // j$.util.stream.g2, j$.util.stream.h2
    public final j$.util.e1 spliterator() {
        int i10 = this.f9541b;
        int[] iArr = this.f9540a;
        j$.util.t1.a(((int[]) Objects.requireNonNull(iArr)).length, 0, i10);
        return new j$.util.q1(iArr, 0, i10, 1040);
    }

    @Override // j$.util.stream.g2
    public final Object b() {
        int[] iArr = this.f9540a;
        int length = iArr.length;
        int i10 = this.f9541b;
        return length == i10 ? iArr : Arrays.copyOf(iArr, i10);
    }

    @Override // j$.util.stream.h2
    public final long count() {
        return this.f9541b;
    }

    public String toString() {
        int[] iArr = this.f9540a;
        return String.format("IntArrayNode[%d][%s]", Integer.valueOf(iArr.length - this.f9541b), Arrays.toString(iArr));
    }
}

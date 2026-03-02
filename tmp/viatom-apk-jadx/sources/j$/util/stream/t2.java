package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntFunction;

/* loaded from: classes2.dex */
public class t2 implements b2 {

    /* renamed from: a, reason: collision with root package name */
    public final double[] f9746a;

    /* renamed from: b, reason: collision with root package name */
    public int f9747b;

    @Override // j$.util.stream.h2
    public final /* synthetic */ void forEach(Consumer consumer) {
        w3.q(this, consumer);
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ h2 j(long j10, long j11, IntFunction intFunction) {
        return w3.t(this, j10, j11);
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
        w3.n(this, (Double[]) objArr, i10);
    }

    @Override // j$.util.stream.g2
    public final void f(int i10, Object obj) {
        int i11 = this.f9747b;
        System.arraycopy(this.f9746a, 0, (double[]) obj, i10, i11);
    }

    @Override // j$.util.stream.g2
    public final void g(Object obj) {
        DoubleConsumer doubleConsumer = (DoubleConsumer) obj;
        for (int i10 = 0; i10 < this.f9747b; i10++) {
            doubleConsumer.accept(this.f9746a[i10]);
        }
    }

    public t2(long j10) {
        if (j10 >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            throw null;
        }
        this.f9746a = new double[(int) j10];
        this.f9747b = 0;
    }

    public t2(double[] dArr) {
        this.f9746a = dArr;
        this.f9747b = dArr.length;
    }

    @Override // j$.util.stream.h2
    public final Spliterator spliterator() {
        int i10 = this.f9747b;
        double[] dArr = this.f9746a;
        j$.util.t1.a(((double[]) Objects.requireNonNull(dArr)).length, 0, i10);
        return new j$.util.l1(dArr, 0, i10, 1040);
    }

    @Override // j$.util.stream.g2, j$.util.stream.h2
    public final j$.util.e1 spliterator() {
        int i10 = this.f9747b;
        double[] dArr = this.f9746a;
        j$.util.t1.a(((double[]) Objects.requireNonNull(dArr)).length, 0, i10);
        return new j$.util.l1(dArr, 0, i10, 1040);
    }

    @Override // j$.util.stream.g2
    public final Object b() {
        double[] dArr = this.f9746a;
        int length = dArr.length;
        int i10 = this.f9747b;
        return length == i10 ? dArr : Arrays.copyOf(dArr, i10);
    }

    @Override // j$.util.stream.h2
    public final long count() {
        return this.f9747b;
    }

    public String toString() {
        double[] dArr = this.f9746a;
        return String.format("DoubleArrayNode[%d][%s]", Integer.valueOf(dArr.length - this.f9747b), Arrays.toString(dArr));
    }
}

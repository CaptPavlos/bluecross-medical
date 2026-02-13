package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;

/* loaded from: classes2.dex */
public class l3 implements f2 {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f9656a;

    /* renamed from: b, reason: collision with root package name */
    public int f9657b;

    @Override // j$.util.stream.h2
    public final /* synthetic */ void forEach(Consumer consumer) {
        w3.s(this, consumer);
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ h2 j(long j10, long j11, IntFunction intFunction) {
        return w3.v(this, j10, j11);
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
        w3.p(this, (Long[]) objArr, i10);
    }

    @Override // j$.util.stream.g2
    public final void f(int i10, Object obj) {
        int i11 = this.f9657b;
        System.arraycopy(this.f9656a, 0, (long[]) obj, i10, i11);
    }

    @Override // j$.util.stream.g2
    public final void g(Object obj) {
        LongConsumer longConsumer = (LongConsumer) obj;
        for (int i10 = 0; i10 < this.f9657b; i10++) {
            longConsumer.accept(this.f9656a[i10]);
        }
    }

    public l3(long j10) {
        if (j10 >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            throw null;
        }
        this.f9656a = new long[(int) j10];
        this.f9657b = 0;
    }

    public l3(long[] jArr) {
        this.f9656a = jArr;
        this.f9657b = jArr.length;
    }

    @Override // j$.util.stream.h2
    public final Spliterator spliterator() {
        int i10 = this.f9657b;
        long[] jArr = this.f9656a;
        j$.util.t1.a(((long[]) Objects.requireNonNull(jArr)).length, 0, i10);
        return new j$.util.s1(jArr, 0, i10, 1040);
    }

    @Override // j$.util.stream.g2, j$.util.stream.h2
    public final j$.util.e1 spliterator() {
        int i10 = this.f9657b;
        long[] jArr = this.f9656a;
        j$.util.t1.a(((long[]) Objects.requireNonNull(jArr)).length, 0, i10);
        return new j$.util.s1(jArr, 0, i10, 1040);
    }

    @Override // j$.util.stream.g2
    public final Object b() {
        long[] jArr = this.f9656a;
        int length = jArr.length;
        int i10 = this.f9657b;
        return length == i10 ? jArr : Arrays.copyOf(jArr, i10);
    }

    @Override // j$.util.stream.h2
    public final long count() {
        return this.f9657b;
    }

    public String toString() {
        long[] jArr = this.f9656a;
        return String.format("LongArrayNode[%d][%s]", Integer.valueOf(jArr.length - this.f9657b), Arrays.toString(jArr));
    }
}

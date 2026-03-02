package j$.util.stream;

import j$.util.Spliterator;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* loaded from: classes2.dex */
public class k2 implements h2 {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f9637a;

    /* renamed from: b, reason: collision with root package name */
    public int f9638b;

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

    public k2(long j10, IntFunction intFunction) {
        if (j10 >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            throw null;
        }
        this.f9637a = (Object[]) intFunction.apply((int) j10);
        this.f9638b = 0;
    }

    public k2(Object[] objArr) {
        this.f9637a = objArr;
        this.f9638b = objArr.length;
    }

    @Override // j$.util.stream.h2
    public final Spliterator spliterator() {
        return j$.util.c.v(this.f9637a, 0, this.f9638b);
    }

    @Override // j$.util.stream.h2
    public final void k(Object[] objArr, int i10) {
        System.arraycopy(this.f9637a, 0, objArr, i10, this.f9638b);
    }

    @Override // j$.util.stream.h2
    public final Object[] m(IntFunction intFunction) {
        Object[] objArr = this.f9637a;
        if (objArr.length == this.f9638b) {
            return objArr;
        }
        throw new IllegalStateException();
    }

    @Override // j$.util.stream.h2
    public final long count() {
        return this.f9638b;
    }

    @Override // j$.util.stream.h2
    public final void forEach(Consumer consumer) {
        for (int i10 = 0; i10 < this.f9638b; i10++) {
            consumer.n(this.f9637a[i10]);
        }
    }

    public String toString() {
        Object[] objArr = this.f9637a;
        return String.format("ArrayNode[%d][%s]", Integer.valueOf(objArr.length - this.f9638b), Arrays.toString(objArr));
    }
}

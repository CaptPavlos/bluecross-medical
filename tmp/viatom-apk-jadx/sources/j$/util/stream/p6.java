package j$.util.stream;

import j$.util.Objects;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* loaded from: classes2.dex */
public class p6 extends v6 implements DoubleConsumer {
    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.com.android.tools.r8.a.d(this, doubleConsumer);
    }

    @Override // j$.util.stream.v6
    public final void p(Object obj, int i10, int i11, Object obj2) {
        double[] dArr = (double[]) obj;
        DoubleConsumer doubleConsumer = (DoubleConsumer) obj2;
        while (i10 < i11) {
            doubleConsumer.accept(dArr[i10]);
            i10++;
        }
    }

    @Override // j$.util.stream.v6
    public final int q(Object obj) {
        return ((double[]) obj).length;
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            g((DoubleConsumer) consumer);
        } else {
            if (h8.f9599a) {
                h8.a(getClass(), "{0} calling SpinedBuffer.OfDouble.forEach(Consumer)");
                throw null;
            }
            j$.util.c.a((o6) spliterator(), consumer);
        }
    }

    @Override // j$.util.stream.v6
    public final Object[] t() {
        return new double[8][];
    }

    @Override // j$.util.stream.v6
    public final Object newArray(int i10) {
        return new double[i10];
    }

    @Override // java.util.function.DoubleConsumer
    public void accept(double d8) {
        u();
        double[] dArr = (double[]) this.e;
        int i10 = this.f9533b;
        this.f9533b = i10 + 1;
        dArr[i10] = d8;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        j$.util.v0 v0VarSpliterator = spliterator();
        Objects.requireNonNull(v0VarSpliterator);
        return new j$.util.j1(v0VarSpliterator);
    }

    @Override // j$.util.stream.v6, java.lang.Iterable, j$.util.stream.h2
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public j$.util.v0 spliterator() {
        return new o6(this, 0, this.f9534c, 0, this.f9533b);
    }

    public final String toString() {
        double[] dArr = (double[]) b();
        if (dArr.length < 200) {
            return String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.f9534c), Arrays.toString(dArr));
        }
        return String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.f9534c), Arrays.toString(Arrays.copyOf(dArr, 200)));
    }
}

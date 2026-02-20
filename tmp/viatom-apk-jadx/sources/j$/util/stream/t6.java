package j$.util.stream;

import j$.util.Objects;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: classes2.dex */
public class t6 extends v6 implements LongConsumer {
    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.com.android.tools.r8.a.f(this, longConsumer);
    }

    @Override // j$.util.stream.v6
    public final void p(Object obj, int i10, int i11, Object obj2) {
        long[] jArr = (long[]) obj;
        LongConsumer longConsumer = (LongConsumer) obj2;
        while (i10 < i11) {
            longConsumer.accept(jArr[i10]);
            i10++;
        }
    }

    @Override // j$.util.stream.v6
    public final int q(Object obj) {
        return ((long[]) obj).length;
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            g((LongConsumer) consumer);
        } else {
            if (h8.f9599a) {
                h8.a(getClass(), "{0} calling SpinedBuffer.OfLong.forEach(Consumer)");
                throw null;
            }
            j$.util.c.c((s6) spliterator(), consumer);
        }
    }

    @Override // j$.util.stream.v6
    public final Object[] t() {
        return new long[8][];
    }

    @Override // j$.util.stream.v6
    public final Object newArray(int i10) {
        return new long[i10];
    }

    @Override // java.util.function.LongConsumer
    public void accept(long j10) {
        u();
        long[] jArr = (long[]) this.e;
        int i10 = this.f9533b;
        this.f9533b = i10 + 1;
        jArr[i10] = j10;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        j$.util.b1 b1VarSpliterator = spliterator();
        Objects.requireNonNull(b1VarSpliterator);
        return new j$.util.i1(b1VarSpliterator);
    }

    @Override // j$.util.stream.v6, java.lang.Iterable, j$.util.stream.h2
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public j$.util.b1 spliterator() {
        return new s6(this, 0, this.f9534c, 0, this.f9533b);
    }

    public final String toString() {
        long[] jArr = (long[]) b();
        if (jArr.length < 200) {
            return String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.f9534c), Arrays.toString(jArr));
        }
        return String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.f9534c), Arrays.toString(Arrays.copyOf(jArr, 200)));
    }
}

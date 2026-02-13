package j$.util.stream;

import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

/* loaded from: classes2.dex */
public final class q1 extends t1 implements k5 {
    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        d((Integer) obj);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return j$.com.android.tools.r8.a.e(this, intConsumer);
    }

    @Override // j$.util.stream.k5
    public final /* synthetic */ void d(Integer num) {
        w3.g(this, num);
    }

    @Override // j$.util.stream.t1, j$.util.stream.m5
    public final void accept(int i10) {
        if (this.f9744a) {
            return;
        }
        IntPredicate intPredicate = null;
        intPredicate.test(i10);
        throw null;
    }
}

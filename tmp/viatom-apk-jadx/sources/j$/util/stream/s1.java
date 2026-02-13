package j$.util.stream;

import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;

/* loaded from: classes2.dex */
public final class s1 extends t1 implements j5 {
    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        n((Double) obj);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.com.android.tools.r8.a.d(this, doubleConsumer);
    }

    @Override // j$.util.stream.j5
    public final /* synthetic */ void n(Double d8) {
        w3.d(this, d8);
    }

    @Override // j$.util.stream.t1, j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public final void accept(double d8) {
        if (this.f9744a) {
            return;
        }
        DoublePredicate doublePredicate = null;
        doublePredicate.test(d8);
        throw null;
    }
}

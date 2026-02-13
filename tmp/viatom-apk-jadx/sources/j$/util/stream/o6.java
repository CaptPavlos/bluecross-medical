package j$.util.stream;

import j$.util.Objects;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* loaded from: classes2.dex */
public final class o6 extends u6 implements j$.util.v0 {
    public final /* synthetic */ p6 g;

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.c.a(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.c.f(this, consumer);
    }

    @Override // j$.util.stream.u6
    public final void a(int i10, Object obj, Object obj2) {
        ((DoubleConsumer) obj2).accept(((double[]) obj)[i10]);
    }

    @Override // j$.util.stream.u6
    public final j$.util.e1 b(Object obj, int i10, int i11) {
        double[] dArr = (double[]) obj;
        int i12 = i11 + i10;
        j$.util.t1.a(((double[]) Objects.requireNonNull(dArr)).length, i10, i12);
        return new j$.util.l1(dArr, i10, i12, 1040);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o6(p6 p6Var, int i10, int i11, int i12, int i13) {
        super(p6Var, i10, i11, i12, i13);
        this.g = p6Var;
    }

    @Override // j$.util.stream.u6
    public final j$.util.e1 c(int i10, int i11, int i12, int i13) {
        return new o6(this.g, i10, i11, i12, i13);
    }
}

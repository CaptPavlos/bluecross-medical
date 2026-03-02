package j$.util.stream;

import j$.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: classes2.dex */
public final class q6 extends u6 implements j$.util.y0 {
    public final /* synthetic */ r6 g;

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.c.b(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.c.g(this, consumer);
    }

    @Override // j$.util.stream.u6
    public final void a(int i10, Object obj, Object obj2) {
        ((IntConsumer) obj2).accept(((int[]) obj)[i10]);
    }

    @Override // j$.util.stream.u6
    public final j$.util.e1 b(Object obj, int i10, int i11) {
        int[] iArr = (int[]) obj;
        int i12 = i11 + i10;
        j$.util.t1.a(((int[]) Objects.requireNonNull(iArr)).length, i10, i12);
        return new j$.util.q1(iArr, i10, i12, 1040);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q6(r6 r6Var, int i10, int i11, int i12, int i13) {
        super(r6Var, i10, i11, i12, i13);
        this.g = r6Var;
    }

    @Override // j$.util.stream.u6
    public final j$.util.e1 c(int i10, int i11, int i12, int i13) {
        return new q6(this.g, i10, i11, i12, i13);
    }
}

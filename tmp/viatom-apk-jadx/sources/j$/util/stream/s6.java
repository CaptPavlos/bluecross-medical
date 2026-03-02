package j$.util.stream;

import j$.util.Objects;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: classes2.dex */
public final class s6 extends u6 implements j$.util.b1 {
    public final /* synthetic */ t6 g;

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.c.c(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.c.h(this, consumer);
    }

    @Override // j$.util.stream.u6
    public final void a(int i10, Object obj, Object obj2) {
        ((LongConsumer) obj2).accept(((long[]) obj)[i10]);
    }

    @Override // j$.util.stream.u6
    public final j$.util.e1 b(Object obj, int i10, int i11) {
        long[] jArr = (long[]) obj;
        int i12 = i11 + i10;
        j$.util.t1.a(((long[]) Objects.requireNonNull(jArr)).length, i10, i12);
        return new j$.util.s1(jArr, i10, i12, 1040);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s6(t6 t6Var, int i10, int i11, int i12, int i13) {
        super(t6Var, i10, i11, i12, i13);
        this.g = t6Var;
    }

    @Override // j$.util.stream.u6
    public final j$.util.e1 c(int i10, int i11, int i12, int i13) {
        return new s6(this.g, i10, i11, i12, i13);
    }
}

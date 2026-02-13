package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final class q7 extends s7 implements j$.util.y0 {
    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.c.b(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.c.g(this, consumer);
    }

    @Override // j$.util.stream.u7
    public final Spliterator a(Spliterator spliterator, long j10, long j11, long j12, long j13) {
        return new q7((j$.util.y0) spliterator, j10, j11, j12, j13);
    }

    @Override // j$.util.stream.s7
    public final Object b() {
        return new c2(1);
    }
}

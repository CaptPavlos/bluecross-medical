package j$.util;

import java.util.function.LongConsumer;

/* loaded from: classes2.dex */
public interface b1 extends e1 {
    void forEachRemaining(LongConsumer longConsumer);

    boolean tryAdvance(LongConsumer longConsumer);

    @Override // j$.util.e1, j$.util.Spliterator
    b1 trySplit();
}

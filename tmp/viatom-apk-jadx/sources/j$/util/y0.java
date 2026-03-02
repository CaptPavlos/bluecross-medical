package j$.util;

import java.util.function.IntConsumer;

/* loaded from: classes2.dex */
public interface y0 extends e1 {
    void forEachRemaining(IntConsumer intConsumer);

    boolean tryAdvance(IntConsumer intConsumer);

    @Override // j$.util.e1, j$.util.Spliterator
    y0 trySplit();
}

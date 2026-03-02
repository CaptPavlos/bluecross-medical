package j$.util;

import java.util.function.DoubleConsumer;

/* loaded from: classes2.dex */
public interface v0 extends e1 {
    void forEachRemaining(DoubleConsumer doubleConsumer);

    boolean tryAdvance(DoubleConsumer doubleConsumer);

    @Override // j$.util.e1, j$.util.Spliterator
    v0 trySplit();
}

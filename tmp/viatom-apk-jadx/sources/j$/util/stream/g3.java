package j$.util.stream;

import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final class g3 extends i3 implements j$.util.y0 {
    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.c.b(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.c.g(this, consumer);
    }
}

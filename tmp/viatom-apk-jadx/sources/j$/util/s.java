package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final class s implements Spliterator {

    /* renamed from: a, reason: collision with root package name */
    public final Spliterator f9493a;

    public s(Spliterator spliterator) {
        this.f9493a = spliterator;
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return this.f9493a.tryAdvance(new q(0, consumer));
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        this.f9493a.forEachRemaining(new q(0, consumer));
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        Spliterator spliteratorTrySplit = this.f9493a.trySplit();
        if (spliteratorTrySplit == null) {
            return null;
        }
        return new s(spliteratorTrySplit);
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f9493a.estimateSize();
    }

    @Override // j$.util.Spliterator
    public final long getExactSizeIfKnown() {
        return this.f9493a.getExactSizeIfKnown();
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return this.f9493a.characteristics();
    }

    @Override // j$.util.Spliterator
    public final boolean hasCharacteristics(int i10) {
        return this.f9493a.hasCharacteristics(i10);
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        return this.f9493a.getComparator();
    }
}

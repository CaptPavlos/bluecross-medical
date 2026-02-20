package j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class t0 implements v0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Spliterator.OfDouble f9838a;

    public /* synthetic */ t0(Spliterator.OfDouble ofDouble) {
        this.f9838a = ofDouble;
    }

    public static /* synthetic */ v0 a(Spliterator.OfDouble ofDouble) {
        if (ofDouble == null) {
            return null;
        }
        return ofDouble instanceof u0 ? ((u0) ofDouble).f9847a : new t0(ofDouble);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f9838a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Spliterator.OfDouble ofDouble = this.f9838a;
        if (obj instanceof t0) {
            obj = ((t0) obj).f9838a;
        }
        return ofDouble.equals(obj);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f9838a.estimateSize();
    }

    @Override // j$.util.e1
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f9838a.forEachRemaining((Spliterator.OfDouble) obj);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f9838a.forEachRemaining((Consumer<? super Double>) consumer);
    }

    @Override // j$.util.v0
    public final /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        this.f9838a.forEachRemaining(doubleConsumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ Comparator getComparator() {
        return this.f9838a.getComparator();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f9838a.getExactSizeIfKnown();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i10) {
        return this.f9838a.hasCharacteristics(i10);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9838a.hashCode();
    }

    @Override // j$.util.e1
    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f9838a.tryAdvance((Spliterator.OfDouble) obj);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f9838a.tryAdvance((Consumer<? super Double>) consumer);
    }

    @Override // j$.util.v0
    public final /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return this.f9838a.tryAdvance(doubleConsumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ Spliterator trySplit() {
        return f1.a(this.f9838a.trySplit());
    }

    @Override // j$.util.e1, j$.util.Spliterator
    public final /* synthetic */ e1 trySplit() {
        return c1.a(this.f9838a.trySplit());
    }

    @Override // j$.util.v0, j$.util.e1, j$.util.Spliterator
    public final /* synthetic */ v0 trySplit() {
        return a(this.f9838a.trySplit());
    }
}

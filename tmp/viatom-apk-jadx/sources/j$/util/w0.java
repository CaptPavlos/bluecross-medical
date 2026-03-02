package j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class w0 implements y0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Spliterator.OfInt f9853a;

    public /* synthetic */ w0(Spliterator.OfInt ofInt) {
        this.f9853a = ofInt;
    }

    public static /* synthetic */ y0 a(Spliterator.OfInt ofInt) {
        if (ofInt == null) {
            return null;
        }
        return ofInt instanceof x0 ? ((x0) ofInt).f9857a : new w0(ofInt);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f9853a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Spliterator.OfInt ofInt = this.f9853a;
        if (obj instanceof w0) {
            obj = ((w0) obj).f9853a;
        }
        return ofInt.equals(obj);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f9853a.estimateSize();
    }

    @Override // j$.util.e1
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f9853a.forEachRemaining((Spliterator.OfInt) obj);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f9853a.forEachRemaining((Consumer<? super Integer>) consumer);
    }

    @Override // j$.util.y0
    public final /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.f9853a.forEachRemaining(intConsumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ Comparator getComparator() {
        return this.f9853a.getComparator();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f9853a.getExactSizeIfKnown();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i10) {
        return this.f9853a.hasCharacteristics(i10);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9853a.hashCode();
    }

    @Override // j$.util.e1
    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f9853a.tryAdvance((Spliterator.OfInt) obj);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f9853a.tryAdvance((Consumer<? super Integer>) consumer);
    }

    @Override // j$.util.y0
    public final /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return this.f9853a.tryAdvance(intConsumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ Spliterator trySplit() {
        return f1.a(this.f9853a.trySplit());
    }

    @Override // j$.util.e1, j$.util.Spliterator
    public final /* synthetic */ e1 trySplit() {
        return c1.a(this.f9853a.trySplit());
    }

    @Override // j$.util.y0, j$.util.e1, j$.util.Spliterator
    public final /* synthetic */ y0 trySplit() {
        return a(this.f9853a.trySplit());
    }
}

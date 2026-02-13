package j$.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class g0 implements i0, z {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PrimitiveIterator.OfDouble f9440a;

    public /* synthetic */ g0(PrimitiveIterator.OfDouble ofDouble) {
        this.f9440a = ofDouble;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        PrimitiveIterator.OfDouble ofDouble = this.f9440a;
        if (obj instanceof g0) {
            obj = ((g0) obj).f9440a;
        }
        return ofDouble.equals(obj);
    }

    @Override // j$.util.r0
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f9440a.forEachRemaining((PrimitiveIterator.OfDouble) obj);
    }

    @Override // j$.util.i0, java.util.Iterator, j$.util.z
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f9440a.forEachRemaining((Consumer<? super Double>) consumer);
    }

    @Override // j$.util.i0
    public final /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        this.f9440a.forEachRemaining(doubleConsumer);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ boolean hasNext() {
        return this.f9440a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f9440a.hashCode();
    }

    @Override // j$.util.i0, java.util.Iterator
    public final /* synthetic */ Double next() {
        return this.f9440a.next();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f9440a.next();
    }

    @Override // j$.util.i0
    public final /* synthetic */ double nextDouble() {
        return this.f9440a.nextDouble();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void remove() {
        this.f9440a.remove();
    }
}

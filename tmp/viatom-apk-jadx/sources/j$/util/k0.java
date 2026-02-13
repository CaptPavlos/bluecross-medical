package j$.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class k0 implements m0, z {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PrimitiveIterator.OfInt f9463a;

    public /* synthetic */ k0(PrimitiveIterator.OfInt ofInt) {
        this.f9463a = ofInt;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        PrimitiveIterator.OfInt ofInt = this.f9463a;
        if (obj instanceof k0) {
            obj = ((k0) obj).f9463a;
        }
        return ofInt.equals(obj);
    }

    @Override // j$.util.r0
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f9463a.forEachRemaining((PrimitiveIterator.OfInt) obj);
    }

    @Override // j$.util.m0, java.util.Iterator, j$.util.z
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f9463a.forEachRemaining((Consumer<? super Integer>) consumer);
    }

    @Override // j$.util.m0
    public final /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.f9463a.forEachRemaining(intConsumer);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ boolean hasNext() {
        return this.f9463a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f9463a.hashCode();
    }

    @Override // j$.util.m0, java.util.Iterator
    public final /* synthetic */ Integer next() {
        return this.f9463a.next();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f9463a.next();
    }

    @Override // j$.util.m0
    public final /* synthetic */ int nextInt() {
        return this.f9463a.nextInt();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void remove() {
        this.f9463a.remove();
    }
}

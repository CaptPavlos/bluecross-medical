package j$.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class o0 implements q0, z {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PrimitiveIterator.OfLong f9479a;

    public /* synthetic */ o0(PrimitiveIterator.OfLong ofLong) {
        this.f9479a = ofLong;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        PrimitiveIterator.OfLong ofLong = this.f9479a;
        if (obj instanceof o0) {
            obj = ((o0) obj).f9479a;
        }
        return ofLong.equals(obj);
    }

    @Override // j$.util.r0
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f9479a.forEachRemaining((PrimitiveIterator.OfLong) obj);
    }

    @Override // j$.util.q0, java.util.Iterator, j$.util.z
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f9479a.forEachRemaining((Consumer<? super Long>) consumer);
    }

    @Override // j$.util.q0
    public final /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        this.f9479a.forEachRemaining(longConsumer);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ boolean hasNext() {
        return this.f9479a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f9479a.hashCode();
    }

    @Override // j$.util.q0, java.util.Iterator
    public final /* synthetic */ Long next() {
        return this.f9479a.next();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f9479a.next();
    }

    @Override // j$.util.q0
    public final /* synthetic */ long nextLong() {
        return this.f9479a.nextLong();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void remove() {
        this.f9479a.remove();
    }
}

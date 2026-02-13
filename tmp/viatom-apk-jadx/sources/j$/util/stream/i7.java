package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Consumer$CC;
import java.util.Comparator;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final class i7 implements Spliterator, Consumer {

    /* renamed from: d, reason: collision with root package name */
    public static final Object f9609d = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Spliterator f9610a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f9611b;

    /* renamed from: c, reason: collision with root package name */
    public Object f9612c;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return j$.util.c.d(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i10) {
        return j$.util.c.e(this, i10);
    }

    public i7(Spliterator spliterator, ConcurrentHashMap concurrentHashMap) {
        this.f9610a = spliterator;
        this.f9611b = concurrentHashMap;
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final void n(Object obj) {
        this.f9612c = obj;
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        while (this.f9610a.tryAdvance(this)) {
            Object obj = this.f9612c;
            if (obj == null) {
                obj = f9609d;
            }
            if (this.f9611b.putIfAbsent(obj, Boolean.TRUE) == null) {
                consumer.n(this.f9612c);
                this.f9612c = null;
                return true;
            }
        }
        return false;
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        this.f9610a.forEachRemaining(new j$.util.concurrent.t(8, this, consumer));
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        Spliterator spliteratorTrySplit = this.f9610a.trySplit();
        if (spliteratorTrySplit != null) {
            return new i7(spliteratorTrySplit, this.f9611b);
        }
        return null;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f9610a.estimateSize();
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return (this.f9610a.characteristics() & (-16469)) | 1;
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        return this.f9610a.getComparator();
    }
}

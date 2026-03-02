package j$.util.stream;

import j$.util.Spliterator;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public abstract class y8 implements Spliterator {

    /* renamed from: a, reason: collision with root package name */
    public final Spliterator f9810a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f9811b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9812c;

    /* renamed from: d, reason: collision with root package name */
    public int f9813d;

    public abstract Spliterator b(Spliterator spliterator);

    @Override // j$.util.Spliterator
    public final long getExactSizeIfKnown() {
        return -1L;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i10) {
        return j$.util.c.e(this, i10);
    }

    @Override // j$.util.Spliterator
    public void forEachRemaining(Consumer consumer) {
        while (tryAdvance(consumer)) {
        }
    }

    public y8(Spliterator spliterator) {
        this.f9812c = true;
        this.f9810a = spliterator;
        this.f9811b = new AtomicBoolean();
    }

    public y8(Spliterator spliterator, y8 y8Var) {
        this.f9812c = true;
        this.f9810a = spliterator;
        y8Var.getClass();
        this.f9811b = y8Var.f9811b;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f9810a.estimateSize();
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return this.f9810a.characteristics() & (-16449);
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        return this.f9810a.getComparator();
    }

    @Override // j$.util.Spliterator
    public Spliterator trySplit() {
        Spliterator spliteratorTrySplit = this.f9810a.trySplit();
        if (spliteratorTrySplit != null) {
            return b(spliteratorTrySplit);
        }
        return null;
    }

    public final boolean a() {
        return (this.f9813d == 0 && this.f9811b.get()) ? false : true;
    }

    @Override // j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.y0 trySplit() {
        return (j$.util.y0) trySplit();
    }

    @Override // j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.b1 trySplit() {
        return (j$.util.b1) trySplit();
    }

    @Override // j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.e1 trySplit() {
        return (j$.util.e1) trySplit();
    }

    @Override // j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.v0 trySplit() {
        return (j$.util.v0) trySplit();
    }
}

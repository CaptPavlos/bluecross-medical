package j$.util.concurrent;

import j$.util.Spliterator;
import java.util.Comparator;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final class f extends p implements Spliterator {

    /* renamed from: i, reason: collision with root package name */
    public final ConcurrentHashMap f9373i;

    /* renamed from: j, reason: collision with root package name */
    public long f9374j;

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return 4353;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return j$.util.c.d(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i10) {
        return j$.util.c.e(this, i10);
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public f(l[] lVarArr, int i10, int i11, int i12, long j10, ConcurrentHashMap concurrentHashMap) {
        super(lVarArr, i10, i11, i12);
        this.f9373i = concurrentHashMap;
        this.f9374j = j10;
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        int i10 = this.f;
        int i11 = this.g;
        int i12 = (i10 + i11) >>> 1;
        if (i12 <= i10) {
            return null;
        }
        l[] lVarArr = this.f9389a;
        this.g = i12;
        long j10 = this.f9374j >>> 1;
        this.f9374j = j10;
        return new f(lVarArr, this.h, i12, i11, j10, this.f9373i);
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        consumer.getClass();
        while (true) {
            l lVarA = a();
            if (lVarA == null) {
                return;
            } else {
                consumer.n(new k(lVarA.f9382b, lVarA.f9383c, this.f9373i));
            }
        }
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        l lVarA = a();
        if (lVarA == null) {
            return false;
        }
        consumer.n(new k(lVarA.f9382b, lVarA.f9383c, this.f9373i));
        return true;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f9374j;
    }
}

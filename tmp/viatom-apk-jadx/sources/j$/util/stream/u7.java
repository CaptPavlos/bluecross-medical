package j$.util.stream;

import j$.util.Spliterator;

/* loaded from: classes2.dex */
public abstract class u7 {

    /* renamed from: a, reason: collision with root package name */
    public final long f9769a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9770b;

    /* renamed from: c, reason: collision with root package name */
    public Spliterator f9771c;

    /* renamed from: d, reason: collision with root package name */
    public long f9772d;
    public long e;

    public abstract Spliterator a(Spliterator spliterator, long j10, long j11, long j12, long j13);

    public u7(Spliterator spliterator, long j10, long j11, long j12, long j13) {
        this.f9771c = spliterator;
        this.f9769a = j10;
        this.f9770b = j11;
        this.f9772d = j12;
        this.e = j13;
    }

    public final Spliterator trySplit() {
        long j10 = this.e;
        if (this.f9769a >= j10 || this.f9772d >= j10) {
            return null;
        }
        while (true) {
            Spliterator spliteratorTrySplit = this.f9771c.trySplit();
            if (spliteratorTrySplit == null) {
                return null;
            }
            long jEstimateSize = spliteratorTrySplit.estimateSize() + this.f9772d;
            long jMin = Math.min(jEstimateSize, this.f9770b);
            long j11 = this.f9769a;
            if (j11 >= jMin) {
                this.f9772d = jMin;
            } else {
                long j12 = this.f9770b;
                if (jMin >= j12) {
                    this.f9771c = spliteratorTrySplit;
                    this.e = jMin;
                } else {
                    long j13 = this.f9772d;
                    if (j13 >= j11 && jEstimateSize <= j12) {
                        this.f9772d = jMin;
                        return spliteratorTrySplit;
                    }
                    this.f9772d = jMin;
                    return a(spliteratorTrySplit, j11, j12, j13, jMin);
                }
            }
        }
    }

    public final long estimateSize() {
        long j10 = this.e;
        long j11 = this.f9769a;
        if (j11 < j10) {
            return j10 - Math.max(j11, this.f9772d);
        }
        return 0L;
    }

    public final int characteristics() {
        return this.f9771c.characteristics();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ j$.util.e1 m243trySplit() {
        return (j$.util.e1) trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ j$.util.y0 m245trySplit() {
        return (j$.util.y0) trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ j$.util.b1 m242trySplit() {
        return (j$.util.b1) trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ j$.util.v0 m244trySplit() {
        return (j$.util.v0) trySplit();
    }
}

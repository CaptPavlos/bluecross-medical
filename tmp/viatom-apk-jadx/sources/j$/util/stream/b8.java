package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public abstract class b8 {

    /* renamed from: a, reason: collision with root package name */
    public final Spliterator f9528a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f9529b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9530c;

    /* renamed from: d, reason: collision with root package name */
    public final long f9531d;
    public final AtomicLong e;

    public abstract Spliterator b(Spliterator spliterator);

    public b8(Spliterator spliterator, long j10, long j11) {
        this.f9528a = spliterator;
        this.f9529b = j11 < 0;
        this.f9531d = j11 >= 0 ? j11 : 0L;
        this.f9530c = 128;
        this.e = new AtomicLong(j11 >= 0 ? j10 + j11 : j10);
    }

    public b8(Spliterator spliterator, b8 b8Var) {
        this.f9528a = spliterator;
        this.f9529b = b8Var.f9529b;
        this.e = b8Var.e;
        this.f9531d = b8Var.f9531d;
        this.f9530c = b8Var.f9530c;
    }

    public final long a(long j10) {
        long j11;
        boolean z9;
        long jMin;
        do {
            j11 = this.e.get();
            z9 = this.f9529b;
            if (j11 != 0) {
                jMin = Math.min(j11, j10);
                if (jMin <= 0) {
                    break;
                }
            } else {
                if (z9) {
                    return j10;
                }
                return 0L;
            }
        } while (!this.e.compareAndSet(j11, j11 - jMin));
        if (z9) {
            return Math.max(j10 - jMin, 0L);
        }
        long j12 = this.f9531d;
        return j11 > j12 ? Math.max(jMin - (j11 - j12), 0L) : jMin;
    }

    public final a8 f() {
        if (this.e.get() > 0) {
            return a8.MAYBE_MORE;
        }
        return this.f9529b ? a8.UNLIMITED : a8.NO_MORE;
    }

    public final Spliterator trySplit() {
        Spliterator spliteratorTrySplit;
        if (this.e.get() == 0 || (spliteratorTrySplit = this.f9528a.trySplit()) == null) {
            return null;
        }
        return b(spliteratorTrySplit);
    }

    public final long estimateSize() {
        return this.f9528a.estimateSize();
    }

    public final int characteristics() {
        return this.f9528a.characteristics() & (-16465);
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ j$.util.e1 m239trySplit() {
        return (j$.util.e1) trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ j$.util.y0 m241trySplit() {
        return (j$.util.y0) trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ j$.util.b1 m238trySplit() {
        return (j$.util.b1) trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ j$.util.v0 m240trySplit() {
        return (j$.util.v0) trySplit();
    }
}

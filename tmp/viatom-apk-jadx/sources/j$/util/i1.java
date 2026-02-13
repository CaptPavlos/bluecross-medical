package j$.util;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: classes2.dex */
public final class i1 implements q0, LongConsumer, z {

    /* renamed from: a, reason: collision with root package name */
    public boolean f9451a = false;

    /* renamed from: b, reason: collision with root package name */
    public long f9452b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b1 f9453c;

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.com.android.tools.r8.a.f(this, longConsumer);
    }

    @Override // j$.util.r0
    public final void forEachRemaining(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        while (hasNext()) {
            longConsumer.accept(nextLong());
        }
    }

    @Override // java.util.Iterator
    public final Long next() {
        if (w1.f9854a) {
            w1.a(i1.class, "{0} calling PrimitiveIterator.OfLong.nextLong()");
            throw null;
        }
        return Long.valueOf(nextLong());
    }

    @Override // j$.util.q0, java.util.Iterator, j$.util.z
    public final void forEachRemaining(Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            forEachRemaining((LongConsumer) consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        if (w1.f9854a) {
            w1.a(i1.class, "{0} calling PrimitiveIterator.OfLong.forEachRemainingLong(action::accept)");
            throw null;
        }
        Objects.requireNonNull(consumer);
        forEachRemaining((LongConsumer) new n0(consumer, 0));
    }

    public i1(b1 b1Var) {
        this.f9453c = b1Var;
    }

    @Override // java.util.function.LongConsumer
    public final void accept(long j10) {
        this.f9451a = true;
        this.f9452b = j10;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!this.f9451a) {
            this.f9453c.tryAdvance((LongConsumer) this);
        }
        return this.f9451a;
    }

    @Override // j$.util.q0
    public final long nextLong() {
        if (!this.f9451a && !hasNext()) {
            throw new NoSuchElementException();
        }
        this.f9451a = false;
        return this.f9452b;
    }
}

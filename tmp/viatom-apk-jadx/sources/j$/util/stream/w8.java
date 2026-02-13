package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;

/* loaded from: classes2.dex */
public final class w8 extends y8 implements LongConsumer, j$.util.b1 {
    public long e;
    public final /* synthetic */ int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w8(Spliterator spliterator, int i10) {
        super(spliterator);
        this.f = i10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w8(Spliterator spliterator, y8 y8Var, int i10) {
        super(spliterator, y8Var);
        this.f = i10;
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.com.android.tools.r8.a.f(this, longConsumer);
    }

    @Override // j$.util.stream.y8, j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.c.c(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.c.h(this, consumer);
    }

    @Override // j$.util.e1
    public final void forEachRemaining(LongConsumer longConsumer) {
        while (tryAdvance(longConsumer)) {
        }
    }

    @Override // java.util.function.LongConsumer
    public final void accept(long j10) {
        this.f9813d = (this.f9813d + 1) & 63;
        this.e = j10;
    }

    @Override // j$.util.stream.y8
    public final Spliterator b(Spliterator spliterator) {
        switch (this.f) {
            case 0:
                return new w8((j$.util.b1) spliterator, this, 0);
            default:
                return new w8((j$.util.b1) spliterator, this, 1);
        }
    }

    @Override // j$.util.stream.y8, j$.util.Spliterator
    public /* bridge */ /* synthetic */ Spliterator trySplit() {
        switch (this.f) {
            case 1:
                return trySplit();
            default:
                return super.trySplit();
        }
    }

    @Override // j$.util.stream.y8, j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.e1 trySplit() {
        switch (this.f) {
            case 1:
                return trySplit();
            default:
                return super.trySplit();
        }
    }

    @Override // j$.util.b1
    public final boolean tryAdvance(LongConsumer longConsumer) {
        switch (this.f) {
            case 0:
                boolean z9 = this.f9812c;
                Spliterator spliterator = this.f9810a;
                if (z9) {
                    this.f9812c = false;
                    boolean zTryAdvance = ((j$.util.b1) spliterator).tryAdvance((LongConsumer) this);
                    if (zTryAdvance && a()) {
                        LongPredicate longPredicate = null;
                        longPredicate.test(this.e);
                        throw null;
                    }
                    if (!zTryAdvance) {
                        return zTryAdvance;
                    }
                    longConsumer.accept(this.e);
                    return zTryAdvance;
                }
                return ((j$.util.b1) spliterator).tryAdvance(longConsumer);
            default:
                if (this.f9812c && a() && ((j$.util.b1) this.f9810a).tryAdvance((LongConsumer) this)) {
                    LongPredicate longPredicate2 = null;
                    longPredicate2.test(this.e);
                    throw null;
                }
                this.f9812c = false;
                return false;
        }
    }

    @Override // j$.util.stream.y8, j$.util.Spliterator
    public j$.util.b1 trySplit() {
        switch (this.f) {
            case 1:
                if (this.f9811b.get()) {
                    return null;
                }
                return (j$.util.b1) super.trySplit();
            default:
                return super.trySplit();
        }
    }

    @Override // j$.util.e1
    public /* bridge */ /* synthetic */ boolean tryAdvance(Object obj) {
        switch (this.f) {
            case 1:
                tryAdvance((LongConsumer) obj);
                return false;
            default:
                return tryAdvance((LongConsumer) obj);
        }
    }
}

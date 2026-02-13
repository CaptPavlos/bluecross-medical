package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* loaded from: classes2.dex */
public final class x8 extends y8 implements Consumer {
    public final Predicate e;
    public Object f;
    public final /* synthetic */ int g;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x8(Spliterator spliterator, Predicate predicate, int i10) {
        super(spliterator);
        this.g = i10;
        this.e = predicate;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x8(Spliterator spliterator, x8 x8Var, int i10) {
        super(spliterator, x8Var);
        this.g = i10;
        this.e = x8Var.e;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f9813d = (this.f9813d + 1) & 63;
        this.f = obj;
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        boolean zTryAdvance;
        boolean zTest;
        switch (this.g) {
            case 0:
                boolean z9 = this.f9812c;
                Spliterator spliterator = this.f9810a;
                if (z9) {
                    boolean z10 = false;
                    this.f9812c = false;
                    while (true) {
                        zTryAdvance = spliterator.tryAdvance(this);
                        if (zTryAdvance && a() && this.e.test(this.f)) {
                            z10 = true;
                        }
                    }
                    if (!zTryAdvance) {
                        return zTryAdvance;
                    }
                    if (z10) {
                        this.f9811b.set(true);
                    }
                    consumer.accept(this.f);
                    return zTryAdvance;
                }
                return spliterator.tryAdvance(consumer);
            default:
                if (this.f9812c && a() && this.f9810a.tryAdvance(this)) {
                    zTest = this.e.test(this.f);
                    if (zTest) {
                        consumer.accept(this.f);
                        return true;
                    }
                } else {
                    zTest = true;
                }
                this.f9812c = false;
                if (!zTest) {
                    this.f9811b.set(true);
                }
                return false;
        }
    }

    @Override // j$.util.stream.y8, j$.util.Spliterator
    public Spliterator trySplit() {
        switch (this.g) {
            case 1:
                if (!this.f9811b.get()) {
                    break;
                }
                break;
        }
        return super.trySplit();
    }

    @Override // j$.util.stream.y8
    public final Spliterator b(Spliterator spliterator) {
        switch (this.g) {
            case 0:
                return new x8(spliterator, this, 0);
            default:
                return new x8(spliterator, this, 1);
        }
    }
}

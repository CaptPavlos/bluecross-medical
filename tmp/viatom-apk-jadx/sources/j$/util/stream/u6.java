package j$.util.stream;

import j$.util.Objects;
import java.util.Comparator;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/* loaded from: classes2.dex */
public abstract class u6 implements j$.util.e1 {

    /* renamed from: a, reason: collision with root package name */
    public int f9765a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9766b;

    /* renamed from: c, reason: collision with root package name */
    public int f9767c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9768d;
    public Object e;
    public final /* synthetic */ v6 f;

    public abstract void a(int i10, Object obj, Object obj2);

    public abstract j$.util.e1 b(Object obj, int i10, int i11);

    public abstract j$.util.e1 c(int i10, int i11, int i12, int i13);

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return 16464;
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

    public u6(v6 v6Var, int i10, int i11, int i12, int i13) {
        this.f = v6Var;
        this.f9765a = i10;
        this.f9766b = i11;
        this.f9767c = i12;
        this.f9768d = i13;
        Object[] objArr = v6Var.f;
        this.e = objArr == null ? v6Var.e : objArr[i10];
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        int i10 = this.f9765a;
        int i11 = this.f9768d;
        int i12 = this.f9766b;
        if (i10 == i12) {
            return i11 - this.f9767c;
        }
        long[] jArr = this.f.f9535d;
        return ((jArr[i12] + i11) - jArr[i10]) - this.f9767c;
    }

    @Override // j$.util.e1
    public final boolean tryAdvance(Object obj) {
        Objects.requireNonNull(obj);
        int i10 = this.f9765a;
        int i11 = this.f9766b;
        if (i10 >= i11 && (i10 != i11 || this.f9767c >= this.f9768d)) {
            return false;
        }
        Object obj2 = this.e;
        int i12 = this.f9767c;
        this.f9767c = i12 + 1;
        a(i12, obj2, obj);
        int i13 = this.f9767c;
        Object obj3 = this.e;
        v6 v6Var = this.f;
        if (i13 == v6Var.q(obj3)) {
            this.f9767c = 0;
            int i14 = this.f9765a + 1;
            this.f9765a = i14;
            Object[] objArr = v6Var.f;
            if (objArr != null && i14 <= i11) {
                this.e = objArr[i14];
            }
        }
        return true;
    }

    @Override // j$.util.e1
    public final void forEachRemaining(Object obj) {
        v6 v6Var;
        Objects.requireNonNull(obj);
        int i10 = this.f9765a;
        int i11 = this.f9768d;
        int i12 = this.f9766b;
        if (i10 < i12 || (i10 == i12 && this.f9767c < i11)) {
            int i13 = this.f9767c;
            while (true) {
                v6Var = this.f;
                if (i10 >= i12) {
                    break;
                }
                Object obj2 = v6Var.f[i10];
                v6Var.p(obj2, i13, v6Var.q(obj2), obj);
                i10++;
                i13 = 0;
            }
            v6Var.p(this.f9765a == i12 ? this.e : v6Var.f[i12], i13, i11, obj);
            this.f9765a = i12;
            this.f9767c = i11;
        }
    }

    @Override // j$.util.Spliterator
    public final j$.util.e1 trySplit() {
        int i10 = this.f9765a;
        int i11 = this.f9766b;
        if (i10 < i11) {
            int i12 = i11 - 1;
            int i13 = this.f9767c;
            v6 v6Var = this.f;
            j$.util.e1 e1VarC = c(i10, i12, i13, v6Var.q(v6Var.f[i12]));
            this.f9765a = i11;
            this.f9767c = 0;
            this.e = v6Var.f[i11];
            return e1VarC;
        }
        if (i10 != i11) {
            return null;
        }
        int i14 = this.f9767c;
        int i15 = (this.f9768d - i14) / 2;
        if (i15 == 0) {
            return null;
        }
        j$.util.e1 e1VarB = b(this.e, i14, i15);
        this.f9767c += i15;
        return e1VarB;
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        forEachRemaining((Object) intConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return tryAdvance((Object) intConsumer);
    }

    @Override // j$.util.e1, j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.y0 trySplit() {
        return (j$.util.y0) trySplit();
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        forEachRemaining((Object) longConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return tryAdvance((Object) longConsumer);
    }

    @Override // j$.util.e1, j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.b1 trySplit() {
        return (j$.util.b1) trySplit();
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        forEachRemaining((Object) doubleConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return tryAdvance((Object) doubleConsumer);
    }

    @Override // j$.util.e1, j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.v0 trySplit() {
        return (j$.util.v0) trySplit();
    }
}

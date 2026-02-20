package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.Comparator;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final class n6 implements Spliterator {

    /* renamed from: a, reason: collision with root package name */
    public int f9682a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9683b;

    /* renamed from: c, reason: collision with root package name */
    public int f9684c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9685d;
    public Object[] e;
    public final /* synthetic */ w6 f;

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

    public n6(w6 w6Var, int i10, int i11, int i12, int i13) {
        this.f = w6Var;
        this.f9682a = i10;
        this.f9683b = i11;
        this.f9684c = i12;
        this.f9685d = i13;
        Object[][] objArr = w6Var.f;
        this.e = objArr == null ? w6Var.e : objArr[i10];
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        int i10 = this.f9682a;
        int i11 = this.f9685d;
        int i12 = this.f9683b;
        if (i10 == i12) {
            return i11 - this.f9684c;
        }
        long[] jArr = this.f.f9535d;
        return ((jArr[i12] + i11) - jArr[i10]) - this.f9684c;
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        Objects.requireNonNull(consumer);
        int i10 = this.f9682a;
        int i11 = this.f9683b;
        if (i10 >= i11 && (i10 != i11 || this.f9684c >= this.f9685d)) {
            return false;
        }
        Object[] objArr = this.e;
        int i12 = this.f9684c;
        this.f9684c = i12 + 1;
        consumer.n(objArr[i12]);
        if (this.f9684c == this.e.length) {
            this.f9684c = 0;
            int i13 = this.f9682a + 1;
            this.f9682a = i13;
            Object[][] objArr2 = this.f.f;
            if (objArr2 != null && i13 <= i11) {
                this.e = objArr2[i13];
            }
        }
        return true;
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        w6 w6Var;
        Objects.requireNonNull(consumer);
        int i10 = this.f9682a;
        int i11 = this.f9685d;
        int i12 = this.f9683b;
        if (i10 < i12 || (i10 == i12 && this.f9684c < i11)) {
            int i13 = this.f9684c;
            while (true) {
                w6Var = this.f;
                if (i10 >= i12) {
                    break;
                }
                Object[] objArr = w6Var.f[i10];
                while (i13 < objArr.length) {
                    consumer.n(objArr[i13]);
                    i13++;
                }
                i10++;
                i13 = 0;
            }
            Object[] objArr2 = this.f9682a == i12 ? this.e : w6Var.f[i12];
            while (i13 < i11) {
                consumer.n(objArr2[i13]);
                i13++;
            }
            this.f9682a = i12;
            this.f9684c = i11;
        }
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        int i10 = this.f9682a;
        int i11 = this.f9683b;
        if (i10 < i11) {
            int i12 = i11 - 1;
            int i13 = this.f9684c;
            w6 w6Var = this.f;
            n6 n6Var = new n6(w6Var, i10, i12, i13, w6Var.f[i12].length);
            this.f9682a = i11;
            this.f9684c = 0;
            this.e = w6Var.f[i11];
            return n6Var;
        }
        if (i10 != i11) {
            return null;
        }
        int i14 = this.f9684c;
        int i15 = (this.f9685d - i14) / 2;
        if (i15 == 0) {
            return null;
        }
        j$.util.k1 k1VarV = j$.util.c.v(this.e, i14, i14 + i15);
        this.f9684c += i15;
        return k1VarV;
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }
}

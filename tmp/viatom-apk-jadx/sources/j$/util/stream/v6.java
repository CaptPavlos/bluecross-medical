package j$.util.stream;

import j$.util.Spliterator;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class v6 extends c implements Iterable {
    public Object e;
    public Object[] f;

    public abstract Object newArray(int i10);

    public abstract void p(Object obj, int i10, int i11, Object obj2);

    public abstract int q(Object obj);

    public abstract Spliterator spliterator();

    @Override // java.lang.Iterable
    public final /* synthetic */ java.util.Spliterator spliterator() {
        return Spliterator.Wrapper.convert(spliterator());
    }

    public abstract Object[] t();

    public v6(int i10) {
        super(i10);
        this.e = newArray(1 << this.f9532a);
    }

    public v6() {
        this.e = newArray(16);
    }

    public final void s(long j10) {
        long jQ;
        int i10 = this.f9534c;
        if (i10 == 0) {
            jQ = q(this.e);
        } else {
            jQ = q(this.f[i10]) + this.f9535d[i10];
        }
        if (j10 > jQ) {
            if (this.f == null) {
                Object[] objArrT = t();
                this.f = objArrT;
                this.f9535d = new long[8];
                objArrT[0] = this.e;
            }
            int i11 = this.f9534c + 1;
            while (j10 > jQ) {
                Object[] objArr = this.f;
                if (i11 >= objArr.length) {
                    int length = objArr.length * 2;
                    this.f = Arrays.copyOf(objArr, length);
                    this.f9535d = Arrays.copyOf(this.f9535d, length);
                }
                int iMin = this.f9532a;
                if (i11 != 0 && i11 != 1) {
                    iMin = Math.min((iMin + i11) - 1, 30);
                }
                int i12 = 1 << iMin;
                this.f[i11] = newArray(i12);
                long[] jArr = this.f9535d;
                jArr[i11] = jArr[i11 - 1] + q(this.f[r6]);
                jQ += i12;
                i11++;
            }
        }
    }

    public final int r(long j10) {
        if (this.f9534c == 0) {
            if (j10 < this.f9533b) {
                return 0;
            }
            throw new IndexOutOfBoundsException(Long.toString(j10));
        }
        if (j10 >= count()) {
            throw new IndexOutOfBoundsException(Long.toString(j10));
        }
        for (int i10 = 0; i10 <= this.f9534c; i10++) {
            if (j10 < this.f9535d[i10] + q(this.f[i10])) {
                return i10;
            }
        }
        throw new IndexOutOfBoundsException(Long.toString(j10));
    }

    public void f(int i10, Object obj) {
        long j10 = i10;
        long jCount = count() + j10;
        if (jCount > q(obj) || jCount < j10) {
            throw new IndexOutOfBoundsException("does not fit");
        }
        if (this.f9534c == 0) {
            System.arraycopy(this.e, 0, obj, i10, this.f9533b);
            return;
        }
        for (int i11 = 0; i11 < this.f9534c; i11++) {
            Object obj2 = this.f[i11];
            System.arraycopy(obj2, 0, obj, i10, q(obj2));
            i10 += q(this.f[i11]);
        }
        int i12 = this.f9533b;
        if (i12 > 0) {
            System.arraycopy(this.e, 0, obj, i10, i12);
        }
    }

    public Object b() {
        long jCount = count();
        if (jCount >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return null;
        }
        Object objNewArray = newArray((int) jCount);
        f(0, objNewArray);
        return objNewArray;
    }

    public final void u() {
        long jQ;
        if (this.f9533b == q(this.e)) {
            if (this.f == null) {
                Object[] objArrT = t();
                this.f = objArrT;
                this.f9535d = new long[8];
                objArrT[0] = this.e;
            }
            int i10 = this.f9534c;
            int i11 = i10 + 1;
            Object[] objArr = this.f;
            if (i11 >= objArr.length || objArr[i11] == null) {
                if (i10 == 0) {
                    jQ = q(this.e);
                } else {
                    jQ = q(objArr[i10]) + this.f9535d[i10];
                }
                s(jQ + 1);
            }
            this.f9533b = 0;
            int i12 = this.f9534c + 1;
            this.f9534c = i12;
            this.e = this.f[i12];
        }
    }

    @Override // j$.util.stream.c
    public final void clear() {
        Object[] objArr = this.f;
        if (objArr != null) {
            this.e = objArr[0];
            this.f = null;
            this.f9535d = null;
        }
        this.f9533b = 0;
        this.f9534c = 0;
    }

    public void g(Object obj) {
        for (int i10 = 0; i10 < this.f9534c; i10++) {
            Object obj2 = this.f[i10];
            p(obj2, 0, q(obj2), obj);
        }
        p(this.e, 0, this.f9533b, obj);
    }
}

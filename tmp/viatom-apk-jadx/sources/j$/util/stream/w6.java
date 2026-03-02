package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public class w6 extends c implements Consumer, Iterable {
    public Object[] e = new Object[1 << 4];
    public Object[][] f;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return Spliterator.Wrapper.convert(spliterator());
    }

    public final void p(long j10) {
        long length;
        int i10 = this.f9534c;
        if (i10 == 0) {
            length = this.e.length;
        } else {
            length = this.f9535d[i10] + this.f[i10].length;
        }
        if (j10 > length) {
            if (this.f == null) {
                Object[][] objArr = new Object[8][];
                this.f = objArr;
                this.f9535d = new long[8];
                objArr[0] = this.e;
            }
            int i11 = i10 + 1;
            while (j10 > length) {
                Object[][] objArr2 = this.f;
                if (i11 >= objArr2.length) {
                    int length2 = objArr2.length * 2;
                    this.f = (Object[][]) Arrays.copyOf(objArr2, length2);
                    this.f9535d = Arrays.copyOf(this.f9535d, length2);
                }
                int iMin = this.f9532a;
                if (i11 != 0 && i11 != 1) {
                    iMin = Math.min((iMin + i11) - 1, 30);
                }
                int i12 = 1 << iMin;
                this.f[i11] = new Object[i12];
                long[] jArr = this.f9535d;
                jArr[i11] = jArr[i11 - 1] + r5[r7].length;
                length += i12;
                i11++;
            }
        }
    }

    @Override // j$.util.stream.c
    public final void clear() {
        Object[][] objArr = this.f;
        if (objArr != null) {
            this.e = objArr[0];
            int i10 = 0;
            while (true) {
                Object[] objArr2 = this.e;
                if (i10 >= objArr2.length) {
                    break;
                }
                objArr2[i10] = null;
                i10++;
            }
            this.f = null;
            this.f9535d = null;
        } else {
            for (int i11 = 0; i11 < this.f9533b; i11++) {
                this.e[i11] = null;
            }
        }
        this.f9533b = 0;
        this.f9534c = 0;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        j$.util.Spliterator spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new j$.util.g1(spliterator);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer consumer) {
        for (int i10 = 0; i10 < this.f9534c; i10++) {
            for (Object obj : this.f[i10]) {
                consumer.n(obj);
            }
        }
        for (int i11 = 0; i11 < this.f9533b; i11++) {
            consumer.n(this.e[i11]);
        }
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public void n(Object obj) {
        long length;
        int i10 = this.f9533b;
        Object[] objArr = this.e;
        if (i10 == objArr.length) {
            if (this.f == null) {
                Object[][] objArr2 = new Object[8][];
                this.f = objArr2;
                this.f9535d = new long[8];
                objArr2[0] = objArr;
            }
            int i11 = this.f9534c;
            int i12 = i11 + 1;
            Object[][] objArr3 = this.f;
            if (i12 >= objArr3.length || objArr3[i12] == null) {
                if (i11 == 0) {
                    length = objArr.length;
                } else {
                    length = objArr3[i11].length + this.f9535d[i11];
                }
                p(length + 1);
            }
            this.f9533b = 0;
            int i13 = this.f9534c + 1;
            this.f9534c = i13;
            this.e = this.f[i13];
        }
        Object[] objArr4 = this.e;
        int i14 = this.f9533b;
        this.f9533b = i14 + 1;
        objArr4[i14] = obj;
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        Objects.requireNonNull(arrayList);
        forEach(new j$.util.q(9, arrayList));
        return "SpinedBuffer:" + arrayList.toString();
    }

    @Override // java.lang.Iterable
    public j$.util.Spliterator spliterator() {
        return new n6(this, 0, this.f9534c, 0, this.f9533b);
    }
}

package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b6 extends v4 implements RandomAccess, s5, l6 {

    /* renamed from: d, reason: collision with root package name */
    public static final long[] f1890d;
    public static final b6 e;

    /* renamed from: b, reason: collision with root package name */
    public long[] f1891b;

    /* renamed from: c, reason: collision with root package name */
    public int f1892c;

    static {
        long[] jArr = new long[0];
        f1890d = jArr;
        e = new b6(jArr, 0, false);
    }

    public b6(long[] jArr, int i10, boolean z9) {
        super(z9);
        this.f1891b = jArr;
        this.f1892c = i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, Object obj) {
        int i11;
        long jLongValue = ((Long) obj).longValue();
        b();
        if (i10 < 0 || i10 > (i11 = this.f1892c)) {
            p8.u.k(x4.a(this.f1892c, i10, (byte) 13, "Index:", ", Size:"));
            return;
        }
        int i12 = i10 + 1;
        long[] jArr = this.f1891b;
        int length = jArr.length;
        if (i11 < length) {
            System.arraycopy(jArr, i10, jArr, i12, i11 - i10);
        } else {
            long[] jArr2 = new long[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f1891b, 0, jArr2, 0, i10);
            System.arraycopy(this.f1891b, i10, jArr2, i12, this.f1892c - i10);
            this.f1891b = jArr2;
        }
        this.f1891b[i10] = jLongValue;
        this.f1892c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = u5.f2192a;
        collection.getClass();
        if (!(collection instanceof b6)) {
            return super.addAll(collection);
        }
        b6 b6Var = (b6) collection;
        int i10 = b6Var.f1892c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f1892c;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        long[] jArr = this.f1891b;
        if (i12 > jArr.length) {
            this.f1891b = Arrays.copyOf(jArr, i12);
        }
        System.arraycopy(b6Var.f1891b, 0, this.f1891b, this.f1892c, b6Var.f1892c);
        this.f1892c = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final long c(int i10) {
        g(i10);
        return this.f1891b[i10];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.measurement.t5
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final b6 k(int i10) {
        if (i10 >= this.f1892c) {
            return new b6(i10 == 0 ? f1890d : Arrays.copyOf(this.f1891b, i10), this.f1892c, true);
        }
        z8.f.a();
        return null;
    }

    public final void e(long j10) {
        b();
        int i10 = this.f1892c;
        int length = this.f1891b.length;
        if (i10 == length) {
            long[] jArr = new long[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f1891b, 0, jArr, 0, this.f1892c);
            this.f1891b = jArr;
        }
        long[] jArr2 = this.f1891b;
        int i11 = this.f1892c;
        this.f1892c = i11 + 1;
        jArr2[i11] = j10;
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b6)) {
            return super.equals(obj);
        }
        b6 b6Var = (b6) obj;
        if (this.f1892c != b6Var.f1892c) {
            return false;
        }
        long[] jArr = b6Var.f1891b;
        for (int i10 = 0; i10 < this.f1892c; i10++) {
            if (this.f1891b[i10] != jArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final void g(int i10) {
        if (i10 < 0 || i10 >= this.f1892c) {
            p8.u.k(x4.a(this.f1892c, i10, (byte) 13, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        g(i10);
        return Long.valueOf(this.f1891b[i10]);
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f1892c; i11++) {
            long j10 = this.f1891b[i11];
            Charset charset = u5.f2192a;
            i10 = (i10 * 31) + ((int) (j10 ^ (j10 >>> 32)));
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i10 = this.f1892c;
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.f1891b[i11] == jLongValue) {
                return i11;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i10) {
        b();
        g(i10);
        long[] jArr = this.f1891b;
        long j10 = jArr[i10];
        if (i10 < this.f1892c - 1) {
            System.arraycopy(jArr, i10 + 1, jArr, i10, (r3 - i10) - 1);
        }
        this.f1892c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j10);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i10, int i11) {
        b();
        if (i11 < i10) {
            p8.u.k("toIndex < fromIndex");
            return;
        }
        long[] jArr = this.f1891b;
        System.arraycopy(jArr, i11, jArr, i10, this.f1892c - i11);
        this.f1892c -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i10, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        b();
        g(i10);
        long[] jArr = this.f1891b;
        long j10 = jArr[i10];
        jArr[i10] = jLongValue;
        return Long.valueOf(j10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1892c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        e(((Long) obj).longValue());
        return true;
    }
}

package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p5 extends v4 implements RandomAccess, r5, l6 {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f2130d;
    public static final p5 e;

    /* renamed from: b, reason: collision with root package name */
    public int[] f2131b;

    /* renamed from: c, reason: collision with root package name */
    public int f2132c;

    static {
        int[] iArr = new int[0];
        f2130d = iArr;
        e = new p5(iArr, 0, false);
    }

    public p5(int[] iArr, int i10, boolean z9) {
        super(z9);
        this.f2131b = iArr;
        this.f2132c = i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, Object obj) {
        int i11;
        int iIntValue = ((Integer) obj).intValue();
        b();
        if (i10 < 0 || i10 > (i11 = this.f2132c)) {
            p8.u.k(x4.a(this.f2132c, i10, (byte) 13, "Index:", ", Size:"));
            return;
        }
        int i12 = i10 + 1;
        int[] iArr = this.f2131b;
        int length = iArr.length;
        if (i11 < length) {
            System.arraycopy(iArr, i10, iArr, i12, i11 - i10);
        } else {
            int[] iArr2 = new int[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f2131b, 0, iArr2, 0, i10);
            System.arraycopy(this.f2131b, i10, iArr2, i12, this.f2132c - i10);
            this.f2131b = iArr2;
        }
        this.f2131b[i10] = iIntValue;
        this.f2132c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        b();
        Charset charset = u5.f2192a;
        collection.getClass();
        if (!(collection instanceof p5)) {
            return super.addAll(collection);
        }
        p5 p5Var = (p5) collection;
        int i10 = p5Var.f2132c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f2132c;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        int[] iArr = this.f2131b;
        if (i12 > iArr.length) {
            this.f2131b = Arrays.copyOf(iArr, i12);
        }
        System.arraycopy(p5Var.f2131b, 0, this.f2131b, this.f2132c, p5Var.f2132c);
        this.f2132c = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.t5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final p5 k(int i10) {
        if (i10 >= this.f2132c) {
            return new p5(i10 == 0 ? f2130d : Arrays.copyOf(this.f2131b, i10), this.f2132c, true);
        }
        z8.f.a();
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final int d(int i10) {
        g(i10);
        return this.f2131b[i10];
    }

    public final void e(int i10) {
        b();
        int i11 = this.f2132c;
        int length = this.f2131b.length;
        if (i11 == length) {
            int[] iArr = new int[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f2131b, 0, iArr, 0, this.f2132c);
            this.f2131b = iArr;
        }
        int[] iArr2 = this.f2131b;
        int i12 = this.f2132c;
        this.f2132c = i12 + 1;
        iArr2[i12] = i10;
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p5)) {
            return super.equals(obj);
        }
        p5 p5Var = (p5) obj;
        if (this.f2132c != p5Var.f2132c) {
            return false;
        }
        int[] iArr = p5Var.f2131b;
        for (int i10 = 0; i10 < this.f2132c; i10++) {
            if (this.f2131b[i10] != iArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final void g(int i10) {
        if (i10 < 0 || i10 >= this.f2132c) {
            p8.u.k(x4.a(this.f2132c, i10, (byte) 13, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        g(i10);
        return Integer.valueOf(this.f2131b[i10]);
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f2132c; i11++) {
            i10 = (i10 * 31) + this.f2131b[i11];
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i10 = this.f2132c;
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.f2131b[i11] == iIntValue) {
                return i11;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i10) {
        b();
        g(i10);
        int[] iArr = this.f2131b;
        int i11 = iArr[i10];
        if (i10 < this.f2132c - 1) {
            System.arraycopy(iArr, i10 + 1, iArr, i10, (r2 - i10) - 1);
        }
        this.f2132c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i10, int i11) {
        b();
        if (i11 < i10) {
            p8.u.k("toIndex < fromIndex");
            return;
        }
        int[] iArr = this.f2131b;
        System.arraycopy(iArr, i11, iArr, i10, this.f2132c - i11);
        this.f2132c -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i10, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        b();
        g(i10);
        int[] iArr = this.f2131b;
        int i11 = iArr[i10];
        iArr[i10] = iIntValue;
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2132c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        e(((Integer) obj).intValue());
        return true;
    }
}

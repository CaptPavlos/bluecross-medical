package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n6 extends v4 implements RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    public static final Object[] f2103d;
    public static final n6 e;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f2104b;

    /* renamed from: c, reason: collision with root package name */
    public int f2105c;

    static {
        Object[] objArr = new Object[0];
        f2103d = objArr;
        e = new n6(objArr, 0, false);
    }

    public n6(Object[] objArr, int i10, boolean z9) {
        super(z9);
        this.f2104b = objArr;
        this.f2105c = i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, Object obj) {
        int i11;
        b();
        if (i10 < 0 || i10 > (i11 = this.f2105c)) {
            p8.u.k(x4.a(this.f2105c, i10, (byte) 13, "Index:", ", Size:"));
            return;
        }
        int i12 = i10 + 1;
        Object[] objArr = this.f2104b;
        int length = objArr.length;
        if (i11 < length) {
            System.arraycopy(objArr, i10, objArr, i12, i11 - i10);
        } else {
            Object[] objArr2 = new Object[Math.max(((length * 3) / 2) + 1, 10)];
            System.arraycopy(this.f2104b, 0, objArr2, 0, i10);
            System.arraycopy(this.f2104b, i10, objArr2, i12, this.f2105c - i10);
            this.f2104b = objArr2;
        }
        this.f2104b[i10] = obj;
        this.f2105c++;
        ((AbstractList) this).modCount++;
    }

    public final void c(int i10) {
        if (i10 < 0 || i10 >= this.f2105c) {
            p8.u.k(x4.a(this.f2105c, i10, (byte) 13, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i10) {
        c(i10);
        return this.f2104b[i10];
    }

    @Override // com.google.android.gms.internal.measurement.t5
    public final /* bridge */ /* synthetic */ t5 k(int i10) {
        if (i10 >= this.f2105c) {
            return new n6(i10 == 0 ? f2103d : Arrays.copyOf(this.f2104b, i10), this.f2105c, true);
        }
        z8.f.a();
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.v4, java.util.AbstractList, java.util.List
    public final Object remove(int i10) {
        b();
        c(i10);
        Object[] objArr = this.f2104b;
        Object obj = objArr[i10];
        if (i10 < this.f2105c - 1) {
            System.arraycopy(objArr, i10 + 1, objArr, i10, (r2 - i10) - 1);
        }
        this.f2105c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i10, Object obj) {
        b();
        c(i10);
        Object[] objArr = this.f2104b;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2105c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        b();
        int i10 = this.f2105c;
        int length = this.f2104b.length;
        if (i10 == length) {
            this.f2104b = Arrays.copyOf(this.f2104b, Math.max(((length * 3) / 2) + 1, 10));
        }
        Object[] objArr = this.f2104b;
        int i11 = this.f2105c;
        this.f2105c = i11 + 1;
        objArr[i11] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}

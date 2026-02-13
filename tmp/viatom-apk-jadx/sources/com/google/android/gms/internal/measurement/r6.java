package com.google.android.gms.internal.measurement;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r6 extends AbstractMap {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f2144a;

    /* renamed from: b, reason: collision with root package name */
    public int f2145b;

    /* renamed from: c, reason: collision with root package name */
    public Map f2146c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2147d;
    public volatile com.google.gson.internal.j e;
    public Map f;

    public r6() {
        Map map = Collections.EMPTY_MAP;
        this.f2146c = map;
        this.f = map;
    }

    public final s6 a(int i10) {
        if (i10 < this.f2145b) {
            return (s6) this.f2144a[i10];
        }
        throw new ArrayIndexOutOfBoundsException(i10);
    }

    public final Set c() {
        return this.f2146c.isEmpty() ? Collections.EMPTY_SET : this.f2146c.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        g();
        if (this.f2145b != 0) {
            this.f2144a = null;
            this.f2145b = 0;
        }
        if (this.f2146c.isEmpty()) {
            return;
        }
        this.f2146c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return f(comparable) >= 0 || this.f2146c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        g();
        int iF = f(comparable);
        if (iF >= 0) {
            return ((s6) this.f2144a[iF]).setValue(obj);
        }
        g();
        if (this.f2144a == null) {
            this.f2144a = new Object[16];
        }
        int i10 = -(iF + 1);
        if (i10 >= 16) {
            return h().put(comparable, obj);
        }
        if (this.f2145b == 16) {
            s6 s6Var = (s6) this.f2144a[15];
            this.f2145b = 15;
            h().put(s6Var.f2160a, s6Var.f2161b);
        }
        Object[] objArr = this.f2144a;
        int length = objArr.length;
        System.arraycopy(objArr, i10, objArr, i10 + 1, 15 - i10);
        this.f2144a[i10] = new s6(this, comparable, obj);
        this.f2145b++;
        return null;
    }

    public final Object e(int i10) {
        g();
        Object[] objArr = this.f2144a;
        Object obj = ((s6) objArr[i10]).f2161b;
        System.arraycopy(objArr, i10 + 1, objArr, i10, (this.f2145b - i10) - 1);
        this.f2145b--;
        if (!this.f2146c.isEmpty()) {
            Iterator it = h().entrySet().iterator();
            Object[] objArr2 = this.f2144a;
            int i11 = this.f2145b;
            Map.Entry entry = (Map.Entry) it.next();
            objArr2[i11] = new s6(this, (Comparable) entry.getKey(), entry.getValue());
            this.f2145b++;
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.e == null) {
            this.e = new com.google.gson.internal.j(this, 2);
        }
        return this.e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r6)) {
            return super.equals(obj);
        }
        r6 r6Var = (r6) obj;
        int size = size();
        if (size == r6Var.size()) {
            int i10 = this.f2145b;
            if (i10 != r6Var.f2145b) {
                return entrySet().equals(r6Var.entrySet());
            }
            for (int i11 = 0; i11 < i10; i11++) {
                if (a(i11).equals(r6Var.a(i11))) {
                }
            }
            if (i10 != size) {
                return this.f2146c.equals(r6Var.f2146c);
            }
            return true;
        }
        return false;
    }

    public final int f(Comparable comparable) {
        int i10 = this.f2145b;
        int i11 = i10 - 1;
        int i12 = 0;
        if (i11 >= 0) {
            int iCompareTo = comparable.compareTo(((s6) this.f2144a[i11]).f2160a);
            if (iCompareTo > 0) {
                return -(i10 + 1);
            }
            if (iCompareTo == 0) {
                return i11;
            }
        }
        while (i12 <= i11) {
            int i13 = (i12 + i11) / 2;
            int iCompareTo2 = comparable.compareTo(((s6) this.f2144a[i13]).f2160a);
            if (iCompareTo2 < 0) {
                i11 = i13 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i13;
                }
                i12 = i13 + 1;
            }
        }
        return -(i12 + 1);
    }

    public final void g() {
        if (this.f2147d) {
            p8.u.p();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iF = f(comparable);
        return iF >= 0 ? ((s6) this.f2144a[iF]).f2161b : this.f2146c.get(comparable);
    }

    public final SortedMap h() {
        g();
        if (this.f2146c.isEmpty() && !(this.f2146c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f2146c = treeMap;
            this.f = treeMap.descendingMap();
        }
        return (SortedMap) this.f2146c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i10 = this.f2145b;
        int iHashCode = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            iHashCode += this.f2144a[i11].hashCode();
        }
        return this.f2146c.size() > 0 ? this.f2146c.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        g();
        Comparable comparable = (Comparable) obj;
        int iF = f(comparable);
        if (iF >= 0) {
            return e(iF);
        }
        if (this.f2146c.isEmpty()) {
            return null;
        }
        return this.f2146c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f2146c.size() + this.f2145b;
    }
}

package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l extends AbstractMap implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    public static final a9.i f2574i = new a9.i(2);

    /* renamed from: b, reason: collision with root package name */
    public final boolean f2576b;

    /* renamed from: c, reason: collision with root package name */
    public k f2577c;
    public final k f;
    public j g;
    public j h;

    /* renamed from: d, reason: collision with root package name */
    public int f2578d = 0;
    public int e = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Comparator f2575a = f2574i;

    public l(boolean z9) {
        this.f2576b = z9;
        this.f = new k(z9);
    }

    public final k a(Object obj, boolean z9) {
        int iCompareTo;
        k kVar;
        k kVar2 = this.f2577c;
        a9.i iVar = f2574i;
        Comparator comparator = this.f2575a;
        if (kVar2 != null) {
            Comparable comparable = comparator == iVar ? (Comparable) obj : null;
            while (true) {
                Object obj2 = kVar2.f;
                iCompareTo = comparable != null ? comparable.compareTo(obj2) : comparator.compare(obj, obj2);
                if (iCompareTo == 0) {
                    return kVar2;
                }
                k kVar3 = iCompareTo < 0 ? kVar2.f2570b : kVar2.f2571c;
                if (kVar3 == null) {
                    break;
                }
                kVar2 = kVar3;
            }
        } else {
            iCompareTo = 0;
        }
        k kVar4 = kVar2;
        if (!z9) {
            return null;
        }
        k kVar5 = this.f;
        if (kVar4 != null) {
            kVar = new k(this.f2576b, kVar4, obj, kVar5, kVar5.e);
            if (iCompareTo < 0) {
                kVar4.f2570b = kVar;
            } else {
                kVar4.f2571c = kVar;
            }
            c(kVar4, true);
        } else {
            if (comparator == iVar && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            kVar = new k(this.f2576b, kVar4, obj, kVar5, kVar5.e);
            this.f2577c = kVar;
        }
        this.f2578d++;
        this.e++;
        return kVar;
    }

    public final void c(k kVar, boolean z9) {
        while (kVar != null) {
            k kVar2 = kVar.f2570b;
            k kVar3 = kVar.f2571c;
            int i10 = kVar2 != null ? kVar2.f2573i : 0;
            int i11 = kVar3 != null ? kVar3.f2573i : 0;
            int i12 = i10 - i11;
            if (i12 == -2) {
                k kVar4 = kVar3.f2570b;
                k kVar5 = kVar3.f2571c;
                int i13 = (kVar4 != null ? kVar4.f2573i : 0) - (kVar5 != null ? kVar5.f2573i : 0);
                if (i13 == -1 || (i13 == 0 && !z9)) {
                    f(kVar);
                } else {
                    g(kVar3);
                    f(kVar);
                }
                if (z9) {
                    return;
                }
            } else if (i12 == 2) {
                k kVar6 = kVar2.f2570b;
                k kVar7 = kVar2.f2571c;
                int i14 = (kVar6 != null ? kVar6.f2573i : 0) - (kVar7 != null ? kVar7.f2573i : 0);
                if (i14 == 1 || (i14 == 0 && !z9)) {
                    g(kVar);
                } else {
                    f(kVar2);
                    g(kVar);
                }
                if (z9) {
                    return;
                }
            } else if (i12 == 0) {
                kVar.f2573i = i10 + 1;
                if (z9) {
                    return;
                }
            } else {
                kVar.f2573i = Math.max(i10, i11) + 1;
                if (!z9) {
                    return;
                }
            }
            kVar = kVar.f2569a;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f2577c = null;
        this.f2578d = 0;
        this.e++;
        k kVar = this.f;
        kVar.e = kVar;
        kVar.f2572d = kVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        k kVarA = null;
        if (obj != null) {
            try {
                kVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return kVarA != null;
    }

    public final void d(k kVar, boolean z9) {
        k kVar2;
        k kVar3;
        int i10;
        if (z9) {
            k kVar4 = kVar.e;
            kVar4.f2572d = kVar.f2572d;
            kVar.f2572d.e = kVar4;
        }
        k kVar5 = kVar.f2570b;
        k kVar6 = kVar.f2571c;
        k kVar7 = kVar.f2569a;
        int i11 = 0;
        if (kVar5 == null || kVar6 == null) {
            if (kVar5 != null) {
                e(kVar, kVar5);
                kVar.f2570b = null;
            } else if (kVar6 != null) {
                e(kVar, kVar6);
                kVar.f2571c = null;
            } else {
                e(kVar, null);
            }
            c(kVar7, false);
            this.f2578d--;
            this.e++;
            return;
        }
        if (kVar5.f2573i > kVar6.f2573i) {
            k kVar8 = kVar5.f2571c;
            while (true) {
                k kVar9 = kVar8;
                kVar3 = kVar5;
                kVar5 = kVar9;
                if (kVar5 == null) {
                    break;
                } else {
                    kVar8 = kVar5.f2571c;
                }
            }
        } else {
            k kVar10 = kVar6.f2570b;
            while (true) {
                kVar2 = kVar6;
                kVar6 = kVar10;
                if (kVar6 == null) {
                    break;
                } else {
                    kVar10 = kVar6.f2570b;
                }
            }
            kVar3 = kVar2;
        }
        d(kVar3, false);
        k kVar11 = kVar.f2570b;
        if (kVar11 != null) {
            i10 = kVar11.f2573i;
            kVar3.f2570b = kVar11;
            kVar11.f2569a = kVar3;
            kVar.f2570b = null;
        } else {
            i10 = 0;
        }
        k kVar12 = kVar.f2571c;
        if (kVar12 != null) {
            i11 = kVar12.f2573i;
            kVar3.f2571c = kVar12;
            kVar12.f2569a = kVar3;
            kVar.f2571c = null;
        }
        kVar3.f2573i = Math.max(i10, i11) + 1;
        e(kVar, kVar3);
    }

    public final void e(k kVar, k kVar2) {
        k kVar3 = kVar.f2569a;
        kVar.f2569a = null;
        if (kVar2 != null) {
            kVar2.f2569a = kVar3;
        }
        if (kVar3 == null) {
            this.f2577c = kVar2;
        } else if (kVar3.f2570b == kVar) {
            kVar3.f2570b = kVar2;
        } else {
            kVar3.f2571c = kVar2;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        j jVar = this.g;
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = new j(this, 0);
        this.g = jVar2;
        return jVar2;
    }

    public final void f(k kVar) {
        k kVar2 = kVar.f2570b;
        k kVar3 = kVar.f2571c;
        k kVar4 = kVar3.f2570b;
        k kVar5 = kVar3.f2571c;
        kVar.f2571c = kVar4;
        if (kVar4 != null) {
            kVar4.f2569a = kVar;
        }
        e(kVar, kVar3);
        kVar3.f2570b = kVar;
        kVar.f2569a = kVar3;
        int iMax = Math.max(kVar2 != null ? kVar2.f2573i : 0, kVar4 != null ? kVar4.f2573i : 0) + 1;
        kVar.f2573i = iMax;
        kVar3.f2573i = Math.max(iMax, kVar5 != null ? kVar5.f2573i : 0) + 1;
    }

    public final void g(k kVar) {
        k kVar2 = kVar.f2570b;
        k kVar3 = kVar.f2571c;
        k kVar4 = kVar2.f2570b;
        k kVar5 = kVar2.f2571c;
        kVar.f2570b = kVar5;
        if (kVar5 != null) {
            kVar5.f2569a = kVar;
        }
        e(kVar, kVar2);
        kVar2.f2571c = kVar;
        kVar.f2569a = kVar2;
        int iMax = Math.max(kVar3 != null ? kVar3.f2573i : 0, kVar5 != null ? kVar5.f2573i : 0) + 1;
        kVar.f2573i = iMax;
        kVar2.f2573i = Math.max(iMax, kVar4 != null ? kVar4.f2573i : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        k kVarA;
        if (obj != null) {
            try {
                kVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        } else {
            kVarA = null;
        }
        if (kVarA != null) {
            return kVarA.h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        j jVar = this.h;
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = new j(this, 1);
        this.h = jVar2;
        return jVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            androidx.window.layout.c.k("key == null");
            return null;
        }
        if (obj2 == null && !this.f2576b) {
            androidx.window.layout.c.k("value == null");
            return null;
        }
        k kVarA = a(obj, true);
        Object obj3 = kVarA.h;
        kVarA.h = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        k kVarA;
        if (obj != null) {
            try {
                kVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        } else {
            kVarA = null;
        }
        if (kVarA != null) {
            d(kVarA, true);
        }
        if (kVarA != null) {
            return kVarA.h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f2578d;
    }
}

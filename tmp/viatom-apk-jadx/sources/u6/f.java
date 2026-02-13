package u6;

import com.google.android.gms.internal.measurement.a4;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.l;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f implements Map, Serializable, h7.a {

    /* renamed from: n, reason: collision with root package name */
    public static final f f12955n;

    /* renamed from: a, reason: collision with root package name */
    public Object[] f12956a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f12957b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f12958c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f12959d;
    public int e;
    public int f;
    public int g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f12960i;

    /* renamed from: j, reason: collision with root package name */
    public g f12961j;

    /* renamed from: k, reason: collision with root package name */
    public h f12962k;

    /* renamed from: l, reason: collision with root package name */
    public g f12963l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f12964m;

    static {
        f fVar = new f(0);
        fVar.f12964m = true;
        f12955n = fVar;
    }

    public f(int i10) {
        if (i10 < 0) {
            com.google.gson.internal.a.n("capacity must be non-negative.");
            throw null;
        }
        Object[] objArr = new Object[i10];
        int[] iArr = new int[i10];
        int iHighestOneBit = Integer.highestOneBit((i10 < 1 ? 1 : i10) * 3);
        this.f12956a = objArr;
        this.f12957b = null;
        this.f12958c = iArr;
        this.f12959d = new int[iHighestOneBit];
        this.e = 2;
        this.f = 0;
        this.g = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }

    public final int a(Object obj) {
        d();
        while (true) {
            int iJ = j(obj);
            int i10 = this.e * 2;
            int length = this.f12959d.length / 2;
            if (i10 > length) {
                i10 = length;
            }
            int i11 = 0;
            while (true) {
                int[] iArr = this.f12959d;
                int i12 = iArr[iJ];
                if (i12 <= 0) {
                    int i13 = this.f;
                    Object[] objArr = this.f12956a;
                    if (i13 < objArr.length) {
                        int i14 = i13 + 1;
                        this.f = i14;
                        objArr[i13] = obj;
                        this.f12958c[i13] = iJ;
                        iArr[iJ] = i14;
                        this.f12960i++;
                        this.h++;
                        if (i11 > this.e) {
                            this.e = i11;
                        }
                        return i13;
                    }
                    g(1);
                } else {
                    if (l.a(this.f12956a[i12 - 1], obj)) {
                        return -i12;
                    }
                    i11++;
                    if (i11 > i10) {
                        k(this.f12959d.length * 2);
                        break;
                    }
                    iJ = iJ == 0 ? this.f12959d.length - 1 : iJ - 1;
                }
            }
        }
    }

    public final f c() {
        d();
        this.f12964m = true;
        if (this.f12960i > 0) {
            return this;
        }
        f fVar = f12955n;
        fVar.getClass();
        return fVar;
    }

    @Override // java.util.Map
    public final void clear() {
        d();
        int i10 = this.f - 1;
        if (i10 >= 0) {
            int i11 = 0;
            while (true) {
                int[] iArr = this.f12958c;
                int i12 = iArr[i11];
                if (i12 >= 0) {
                    this.f12959d[i12] = 0;
                    iArr[i11] = -1;
                }
                if (i11 == i10) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        a4.A(this.f12956a, 0, this.f);
        Object[] objArr = this.f12957b;
        if (objArr != null) {
            a4.A(objArr, 0, this.f);
        }
        this.f12960i = 0;
        this.f = 0;
        this.h++;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return h(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return i(obj) >= 0;
    }

    public final void d() {
        if (this.f12964m) {
            u.p();
        }
    }

    public final void e(boolean z9) {
        int i10;
        Object[] objArr = this.f12957b;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i10 = this.f;
            if (i11 >= i10) {
                break;
            }
            int[] iArr = this.f12958c;
            int i13 = iArr[i11];
            if (i13 >= 0) {
                Object[] objArr2 = this.f12956a;
                objArr2[i12] = objArr2[i11];
                if (objArr != null) {
                    objArr[i12] = objArr[i11];
                }
                if (z9) {
                    iArr[i12] = i13;
                    this.f12959d[i13] = i12 + 1;
                }
                i12++;
            }
            i11++;
        }
        a4.A(this.f12956a, i12, i10);
        if (objArr != null) {
            a4.A(objArr, i12, this.f);
        }
        this.f = i12;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        g gVar = this.f12963l;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this, 0);
        this.f12963l = gVar2;
        return gVar2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        return this.f12960i == map.size() && f(map.entrySet());
    }

    public final boolean f(Collection collection) {
        boolean zA;
        collection.getClass();
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    Map.Entry entry = (Map.Entry) obj;
                    int iH = h(entry.getKey());
                    if (iH < 0) {
                        zA = false;
                    } else {
                        Object[] objArr = this.f12957b;
                        objArr.getClass();
                        zA = l.a(objArr[iH], entry.getValue());
                    }
                    if (!zA) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final void g(int i10) {
        Object[] objArr = this.f12956a;
        int length = objArr.length;
        int i11 = this.f;
        int i12 = length - i11;
        int i13 = i11 - this.f12960i;
        if (i12 < i10 && i12 + i13 >= i10 && i13 >= objArr.length / 4) {
            e(true);
            return;
        }
        int i14 = i11 + i10;
        if (i14 < 0) {
            throw new OutOfMemoryError();
        }
        if (i14 > objArr.length) {
            t6.b bVar = t6.e.Companion;
            int length2 = objArr.length;
            bVar.getClass();
            int iE = t6.b.e(length2, i14);
            Object[] objArr2 = this.f12956a;
            objArr2.getClass();
            this.f12956a = Arrays.copyOf(objArr2, iE);
            Object[] objArr3 = this.f12957b;
            this.f12957b = objArr3 != null ? Arrays.copyOf(objArr3, iE) : null;
            this.f12958c = Arrays.copyOf(this.f12958c, iE);
            int iHighestOneBit = Integer.highestOneBit((iE >= 1 ? iE : 1) * 3);
            if (iHighestOneBit > this.f12959d.length) {
                k(iHighestOneBit);
            }
        }
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int iH = h(obj);
        if (iH < 0) {
            return null;
        }
        Object[] objArr = this.f12957b;
        objArr.getClass();
        return objArr[iH];
    }

    public final int h(Object obj) {
        int iJ = j(obj);
        int i10 = this.e;
        while (true) {
            int i11 = this.f12959d[iJ];
            if (i11 == 0) {
                return -1;
            }
            if (i11 > 0) {
                int i12 = i11 - 1;
                if (l.a(this.f12956a[i12], obj)) {
                    return i12;
                }
            }
            i10--;
            if (i10 < 0) {
                return -1;
            }
            iJ = iJ == 0 ? this.f12959d.length - 1 : iJ - 1;
        }
    }

    @Override // java.util.Map
    public final int hashCode() {
        d dVar = new d(this, 0);
        int i10 = 0;
        while (dVar.hasNext()) {
            int i11 = dVar.f12949b;
            f fVar = dVar.f12948a;
            if (i11 >= fVar.f) {
                com.google.gson.internal.a.b();
                return 0;
            }
            dVar.f12949b = i11 + 1;
            dVar.f12950c = i11;
            Object obj = fVar.f12956a[i11];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = fVar.f12957b;
            objArr.getClass();
            Object obj2 = objArr[dVar.f12950c];
            int iHashCode2 = obj2 != null ? obj2.hashCode() : 0;
            dVar.c();
            i10 += iHashCode ^ iHashCode2;
        }
        return i10;
    }

    public final int i(Object obj) {
        int i10 = this.f;
        while (true) {
            i10--;
            if (i10 < 0) {
                return -1;
            }
            if (this.f12958c[i10] >= 0) {
                Object[] objArr = this.f12957b;
                objArr.getClass();
                if (l.a(objArr[i10], obj)) {
                    return i10;
                }
            }
        }
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f12960i == 0;
    }

    public final int j(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        r3[r0] = r6;
        r5.f12958c[r2] = r0;
        r2 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(int r6) {
        /*
            r5 = this;
            int r0 = r5.h
            int r0 = r0 + 1
            r5.h = r0
            int r0 = r5.f
            int r1 = r5.f12960i
            r2 = 0
            if (r0 <= r1) goto L10
            r5.e(r2)
        L10:
            int[] r0 = new int[r6]
            r5.f12959d = r0
            int r6 = java.lang.Integer.numberOfLeadingZeros(r6)
            int r6 = r6 + 1
            r5.g = r6
        L1c:
            int r6 = r5.f
            if (r2 >= r6) goto L4d
            int r6 = r2 + 1
            java.lang.Object[] r0 = r5.f12956a
            r0 = r0[r2]
            int r0 = r5.j(r0)
            int r1 = r5.e
        L2c:
            int[] r3 = r5.f12959d
            r4 = r3[r0]
            if (r4 != 0) goto L3a
            r3[r0] = r6
            int[] r1 = r5.f12958c
            r1[r2] = r0
            r2 = r6
            goto L1c
        L3a:
            int r1 = r1 + (-1)
            if (r1 < 0) goto L48
            int r4 = r0 + (-1)
            if (r0 != 0) goto L46
            int r0 = r3.length
            int r0 = r0 + (-1)
            goto L2c
        L46:
            r0 = r4
            goto L2c
        L48:
            java.lang.String r6 = "This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?"
            androidx.window.layout.c.g(r6)
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u6.f.k(int):void");
    }

    @Override // java.util.Map
    public final Set keySet() {
        g gVar = this.f12961j;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this, 1);
        this.f12961j = gVar2;
        return gVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0064 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[LOOP:0: B:9:0x0022->B:33:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(int r12) {
        /*
            r11 = this;
            java.lang.Object[] r0 = r11.f12956a
            r0.getClass()
            r1 = 0
            r0[r12] = r1
            java.lang.Object[] r0 = r11.f12957b
            if (r0 == 0) goto Le
            r0[r12] = r1
        Le:
            int[] r0 = r11.f12958c
            r0 = r0[r12]
            int r1 = r11.e
            int r1 = r1 * 2
            int[] r2 = r11.f12959d
            int r2 = r2.length
            int r2 = r2 / 2
            if (r1 <= r2) goto L1e
            r1 = r2
        L1e:
            r2 = 0
            r3 = r1
            r4 = r2
            r1 = r0
        L22:
            int r5 = r0 + (-1)
            if (r0 != 0) goto L2c
            int[] r0 = r11.f12959d
            int r0 = r0.length
            int r0 = r0 + (-1)
            goto L2d
        L2c:
            r0 = r5
        L2d:
            int r4 = r4 + 1
            int r5 = r11.e
            int[] r6 = r11.f12959d
            r7 = -1
            if (r4 <= r5) goto L39
            r6[r1] = r2
            goto L68
        L39:
            r5 = r6[r0]
            if (r5 != 0) goto L40
            r6[r1] = r2
            goto L68
        L40:
            if (r5 >= 0) goto L47
            r6[r1] = r7
        L44:
            r1 = r0
            r4 = r2
            goto L61
        L47:
            java.lang.Object[] r6 = r11.f12956a
            int r8 = r5 + (-1)
            r6 = r6[r8]
            int r6 = r11.j(r6)
            int r6 = r6 - r0
            int[] r9 = r11.f12959d
            int r10 = r9.length
            int r10 = r10 + (-1)
            r6 = r6 & r10
            if (r6 < r4) goto L61
            r9[r1] = r5
            int[] r4 = r11.f12958c
            r4[r8] = r1
            goto L44
        L61:
            int r3 = r3 + r7
            if (r3 >= 0) goto L22
            int[] r0 = r11.f12959d
            r0[r1] = r7
        L68:
            int[] r0 = r11.f12958c
            r0[r12] = r7
            int r12 = r11.f12960i
            int r12 = r12 + r7
            r11.f12960i = r12
            int r12 = r11.h
            int r12 = r12 + 1
            r11.h = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u6.f.l(int):void");
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        d();
        int iA = a(obj);
        Object[] objArr = this.f12957b;
        if (objArr == null) {
            int length = this.f12956a.length;
            if (length < 0) {
                com.google.gson.internal.a.n("capacity must be non-negative.");
                return null;
            }
            objArr = new Object[length];
            this.f12957b = objArr;
        }
        if (iA >= 0) {
            objArr[iA] = obj2;
            return null;
        }
        int i10 = (-iA) - 1;
        Object obj3 = objArr[i10];
        objArr[i10] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        map.getClass();
        d();
        Set<Map.Entry> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        g(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            int iA = a(entry.getKey());
            Object[] objArr = this.f12957b;
            if (objArr == null) {
                int length = this.f12956a.length;
                if (length < 0) {
                    com.google.gson.internal.a.n("capacity must be non-negative.");
                    return;
                } else {
                    objArr = new Object[length];
                    this.f12957b = objArr;
                }
            }
            if (iA >= 0) {
                objArr[iA] = entry.getValue();
            } else {
                int i10 = (-iA) - 1;
                if (!l.a(entry.getValue(), objArr[i10])) {
                    objArr[i10] = entry.getValue();
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        d();
        int iH = h(obj);
        if (iH < 0) {
            return null;
        }
        Object[] objArr = this.f12957b;
        objArr.getClass();
        Object obj2 = objArr[iH];
        l(iH);
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f12960i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.f12960i * 3) + 2);
        sb.append("{");
        int i10 = 0;
        d dVar = new d(this, 0);
        while (dVar.hasNext()) {
            if (i10 > 0) {
                sb.append(", ");
            }
            int i11 = dVar.f12949b;
            f fVar = dVar.f12948a;
            if (i11 >= fVar.f) {
                com.google.gson.internal.a.b();
                return null;
            }
            dVar.f12949b = i11 + 1;
            dVar.f12950c = i11;
            Object obj = fVar.f12956a[i11];
            if (obj == fVar) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = fVar.f12957b;
            objArr.getClass();
            Object obj2 = objArr[dVar.f12950c];
            if (obj2 == fVar) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            dVar.c();
            i10++;
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        h hVar = this.f12962k;
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h(this);
        this.f12962k = hVar2;
        return hVar2;
    }

    public f() {
        this(8);
    }
}

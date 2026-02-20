package j1;

import j$.util.Objects;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class g extends a implements Set {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f9893c = 0;

    /* renamed from: b, reason: collision with root package name */
    public transient d f9894b;

    public static int h(int i10) {
        int iMax = Math.max(i10, 2);
        if (iMax < 751619276) {
            int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
            while (iHighestOneBit * 0.7d < iMax) {
                iHighestOneBit <<= 1;
            }
            return iHighestOneBit;
        }
        if (iMax < 1073741824) {
            return 1073741824;
        }
        com.google.gson.internal.a.n("collection too large");
        return 0;
    }

    public static g i(int i10, Object... objArr) {
        if (i10 == 0) {
            return o.f9906j;
        }
        if (i10 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new p(obj);
        }
        int iH = h(i10);
        Object[] objArr2 = new Object[iH];
        int i11 = iH - 1;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < i10; i14++) {
            Object obj2 = objArr[i14];
            if (obj2 == null) {
                StringBuilder sb = new StringBuilder(20);
                sb.append("at index ");
                sb.append(i14);
                throw new NullPointerException(sb.toString());
            }
            int iHashCode = obj2.hashCode();
            int iN = l1.b.N(iHashCode);
            while (true) {
                int i15 = iN & i11;
                Object obj3 = objArr2[i15];
                if (obj3 == null) {
                    objArr[i13] = obj2;
                    objArr2[i15] = obj2;
                    i12 += iHashCode;
                    i13++;
                    break;
                }
                if (obj3.equals(obj2)) {
                    break;
                }
                iN++;
            }
        }
        Arrays.fill(objArr, i13, i10, (Object) null);
        if (i13 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new p(obj4);
        }
        if (h(i13) < iH / 2) {
            return i(i13, objArr);
        }
        int length = objArr.length;
        if (i13 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i13);
        }
        return new o(i12, i11, i13, objArr, objArr2);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof g) && (this instanceof o) && (((g) obj) instanceof o) && hashCode() != obj.hashCode()) {
            return false;
        }
        if (this != obj) {
            if (obj instanceof Set) {
                Set set = (Set) obj;
                try {
                    if (size() == set.size()) {
                        if (containsAll(set)) {
                        }
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public d g() {
        d dVar = this.f9894b;
        if (dVar != null) {
            return dVar;
        }
        d dVarL = l();
        this.f9894b = dVarL;
        return dVarL;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        Iterator it = iterator();
        int i10 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i10 = ~(~(i10 + (next != null ? next.hashCode() : 0)));
        }
        return i10;
    }

    public d l() {
        Object[] array = toArray(a.f9880a);
        b bVar = d.f9886b;
        return d.g(array.length, array);
    }
}

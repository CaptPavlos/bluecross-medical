package p8;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import l4.n5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final String[] f12152a;

    public r(n5 n5Var) {
        ArrayList arrayList = (ArrayList) n5Var.f10654b;
        this.f12152a = (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public final String a(String str) {
        String[] strArr = this.f12152a;
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public final String b(int i10) {
        return this.f12152a[i10 * 2];
    }

    public final n5 c() {
        n5 n5Var = new n5(18);
        Collections.addAll((ArrayList) n5Var.f10654b, this.f12152a);
        return n5Var;
    }

    public final int d() {
        return this.f12152a.length / 2;
    }

    public final String e(int i10) {
        return this.f12152a[(i10 * 2) + 1];
    }

    public final boolean equals(Object obj) {
        return (obj instanceof r) && Arrays.equals(((r) obj).f12152a, this.f12152a);
    }

    public final List f(String str) {
        int iD = d();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < iD; i10++) {
            if (str.equalsIgnoreCase(b(i10))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(e(i10));
            }
        }
        return arrayList != null ? DesugarCollections.unmodifiableList(arrayList) : Collections.EMPTY_LIST;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f12152a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int iD = d();
        for (int i10 = 0; i10 < iD; i10++) {
            sb.append(b(i10));
            sb.append(": ");
            sb.append(e(i10));
            sb.append("\n");
        }
        return sb.toString();
    }
}

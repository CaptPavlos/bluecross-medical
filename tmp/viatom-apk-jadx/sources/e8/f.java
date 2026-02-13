package e8;

import a3.i0;
import a3.s;
import com.google.android.gms.internal.measurement.a4;
import com.google.android.gms.internal.measurement.l5;
import g8.k;
import g8.o0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import l4.x2;
import s6.m;
import t6.a0;
import t6.l;
import t6.n;
import t6.t;
import t6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f implements e, k {

    /* renamed from: a, reason: collision with root package name */
    public final String f7964a;

    /* renamed from: b, reason: collision with root package name */
    public final a4 f7965b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7966c;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f7967d;
    public final String[] e;
    public final e[] f;
    public final List[] g;
    public final boolean[] h;

    /* renamed from: i, reason: collision with root package name */
    public final Map f7968i;

    /* renamed from: j, reason: collision with root package name */
    public final e[] f7969j;

    /* renamed from: k, reason: collision with root package name */
    public final m f7970k;

    public f(String str, a4 a4Var, int i10, List list, a aVar) {
        this.f7964a = str;
        this.f7965b = a4Var;
        this.f7966c = i10;
        ArrayList arrayList = aVar.f7951b;
        arrayList.getClass();
        HashSet hashSet = new HashSet(a0.h0(n.V(arrayList, 12)));
        l.p0(arrayList, hashSet);
        this.f7967d = hashSet;
        int i11 = 0;
        this.e = (String[]) arrayList.toArray(new String[0]);
        this.f = o0.c(aVar.f7953d);
        this.g = (List[]) aVar.e.toArray(new List[0]);
        ArrayList arrayList2 = aVar.f;
        arrayList2.getClass();
        boolean[] zArr = new boolean[arrayList2.size()];
        int size = arrayList2.size();
        int i12 = 0;
        while (i12 < size) {
            Object obj = arrayList2.get(i12);
            i12++;
            zArr[i11] = ((Boolean) obj).booleanValue();
            i11++;
        }
        this.h = zArr;
        String[] strArr = this.e;
        strArr.getClass();
        n7.k kVar = new n7.k(new x2(strArr, 28), 2);
        ArrayList arrayList3 = new ArrayList(n.V(kVar, 10));
        Iterator it = kVar.iterator();
        while (true) {
            kotlin.jvm.internal.b bVar = (kotlin.jvm.internal.b) it;
            if (!((Iterator) bVar.f10129c).hasNext()) {
                this.f7968i = a0.k0(arrayList3);
                this.f7969j = o0.c(list);
                this.f7970k = new m(new i0(this, 15));
                return;
            }
            w wVar = (w) bVar.next();
            arrayList3.add(new s6.i(wVar.f12812b, Integer.valueOf(wVar.f12811a)));
        }
    }

    @Override // e8.e
    public final String a() {
        return this.f7964a;
    }

    @Override // g8.k
    public final Set b() {
        return this.f7967d;
    }

    @Override // e8.e
    public final boolean c() {
        return false;
    }

    @Override // e8.e
    public final int d(String str) {
        str.getClass();
        Integer num = (Integer) this.f7968i.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // e8.e
    public final int e() {
        return this.f7966c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            e eVar = (e) obj;
            if (this.f7964a.equals(eVar.a()) && Arrays.equals(this.f7969j, ((f) obj).f7969j)) {
                int iE = eVar.e();
                int i10 = this.f7966c;
                if (i10 == iE) {
                    for (int i11 = 0; i11 < i10; i11++) {
                        e[] eVarArr = this.f;
                        if (kotlin.jvm.internal.l.a(eVarArr[i11].a(), eVar.h(i11).a()) && kotlin.jvm.internal.l.a(eVarArr[i11].getKind(), eVar.h(i11).getKind())) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // e8.e
    public final String f(int i10) {
        return this.e[i10];
    }

    @Override // e8.e
    public final List g(int i10) {
        return this.g[i10];
    }

    @Override // e8.e
    public final List getAnnotations() {
        return t.f12808a;
    }

    @Override // e8.e
    public final a4 getKind() {
        return this.f7965b;
    }

    @Override // e8.e
    public final e h(int i10) {
        return this.f[i10];
    }

    public final int hashCode() {
        return ((Number) this.f7970k.getValue()).intValue();
    }

    @Override // e8.e
    public final boolean i(int i10) {
        return this.h[i10];
    }

    @Override // e8.e
    public final boolean isInline() {
        return false;
    }

    public final String toString() {
        return l.h0(l5.N(0, this.f7966c), ", ", this.f7964a.concat("("), ")", new s(this, 11), 24);
    }
}

package g8;

import com.google.android.gms.internal.measurement.a4;
import com.google.android.gms.internal.measurement.l5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class q0 implements e8.e, k {

    /* renamed from: a, reason: collision with root package name */
    public final String f8314a;

    /* renamed from: b, reason: collision with root package name */
    public final x f8315b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8316c;

    /* renamed from: d, reason: collision with root package name */
    public int f8317d = -1;
    public final String[] e;
    public final List[] f;
    public final boolean[] g;
    public Object h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f8318i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f8319j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f8320k;

    public q0(String str, x xVar, int i10) {
        this.f8314a = str;
        this.f8315b = xVar;
        this.f8316c = i10;
        String[] strArr = new String[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            strArr[i11] = "[UNINITIALIZED]";
        }
        this.e = strArr;
        int i12 = this.f8316c;
        this.f = new List[i12];
        this.g = new boolean[i12];
        this.h = t6.u.f12809a;
        final int i13 = 0;
        g7.a aVar = new g7.a(this) { // from class: g8.p0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ q0 f8310b;

            {
                this.f8310b = this;
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, s6.f] */
            @Override // g7.a
            public final Object invoke() {
                c8.b[] bVarArrChildSerializers;
                ArrayList arrayList;
                c8.b[] bVarArrTypeParametersSerializers;
                switch (i13) {
                    case 0:
                        x xVar2 = this.f8310b.f8315b;
                        return (xVar2 == null || (bVarArrChildSerializers = xVar2.childSerializers()) == null) ? o0.f8304b : bVarArrChildSerializers;
                    case 1:
                        x xVar3 = this.f8310b.f8315b;
                        if (xVar3 == null || (bVarArrTypeParametersSerializers = xVar3.typeParametersSerializers()) == null) {
                            arrayList = null;
                        } else {
                            arrayList = new ArrayList(bVarArrTypeParametersSerializers.length);
                            for (c8.b bVar : bVarArrTypeParametersSerializers) {
                                arrayList.add(bVar.getDescriptor());
                            }
                        }
                        return o0.c(arrayList);
                    default:
                        q0 q0Var = this.f8310b;
                        return Integer.valueOf(o0.d(q0Var, (e8.e[]) q0Var.f8319j.getValue()));
                }
            }
        };
        s6.g gVar = s6.g.f12690a;
        this.f8318i = s6.a.c(gVar, aVar);
        final int i14 = 1;
        this.f8319j = s6.a.c(gVar, new g7.a(this) { // from class: g8.p0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ q0 f8310b;

            {
                this.f8310b = this;
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, s6.f] */
            @Override // g7.a
            public final Object invoke() {
                c8.b[] bVarArrChildSerializers;
                ArrayList arrayList;
                c8.b[] bVarArrTypeParametersSerializers;
                switch (i14) {
                    case 0:
                        x xVar2 = this.f8310b.f8315b;
                        return (xVar2 == null || (bVarArrChildSerializers = xVar2.childSerializers()) == null) ? o0.f8304b : bVarArrChildSerializers;
                    case 1:
                        x xVar3 = this.f8310b.f8315b;
                        if (xVar3 == null || (bVarArrTypeParametersSerializers = xVar3.typeParametersSerializers()) == null) {
                            arrayList = null;
                        } else {
                            arrayList = new ArrayList(bVarArrTypeParametersSerializers.length);
                            for (c8.b bVar : bVarArrTypeParametersSerializers) {
                                arrayList.add(bVar.getDescriptor());
                            }
                        }
                        return o0.c(arrayList);
                    default:
                        q0 q0Var = this.f8310b;
                        return Integer.valueOf(o0.d(q0Var, (e8.e[]) q0Var.f8319j.getValue()));
                }
            }
        });
        final int i15 = 2;
        this.f8320k = s6.a.c(gVar, new g7.a(this) { // from class: g8.p0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ q0 f8310b;

            {
                this.f8310b = this;
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, s6.f] */
            @Override // g7.a
            public final Object invoke() {
                c8.b[] bVarArrChildSerializers;
                ArrayList arrayList;
                c8.b[] bVarArrTypeParametersSerializers;
                switch (i15) {
                    case 0:
                        x xVar2 = this.f8310b.f8315b;
                        return (xVar2 == null || (bVarArrChildSerializers = xVar2.childSerializers()) == null) ? o0.f8304b : bVarArrChildSerializers;
                    case 1:
                        x xVar3 = this.f8310b.f8315b;
                        if (xVar3 == null || (bVarArrTypeParametersSerializers = xVar3.typeParametersSerializers()) == null) {
                            arrayList = null;
                        } else {
                            arrayList = new ArrayList(bVarArrTypeParametersSerializers.length);
                            for (c8.b bVar : bVarArrTypeParametersSerializers) {
                                arrayList.add(bVar.getDescriptor());
                            }
                        }
                        return o0.c(arrayList);
                    default:
                        q0 q0Var = this.f8310b;
                        return Integer.valueOf(o0.d(q0Var, (e8.e[]) q0Var.f8319j.getValue()));
                }
            }
        });
    }

    @Override // e8.e
    public final String a() {
        return this.f8314a;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Map] */
    @Override // g8.k
    public final Set b() {
        return this.h.keySet();
    }

    @Override // e8.e
    public final boolean c() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Map] */
    @Override // e8.e
    public final int d(String str) {
        str.getClass();
        Integer num = (Integer) this.h.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // e8.e
    public final int e() {
        return this.f8316c;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, s6.f] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, s6.f] */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q0) {
            e8.e eVar = (e8.e) obj;
            if (this.f8314a.equals(eVar.a()) && Arrays.equals((e8.e[]) this.f8319j.getValue(), (e8.e[]) ((q0) obj).f8319j.getValue())) {
                int iE = eVar.e();
                int i10 = this.f8316c;
                if (i10 == iE) {
                    for (int i11 = 0; i11 < i10; i11++) {
                        if (kotlin.jvm.internal.l.a(h(i11).a(), eVar.h(i11).a()) && kotlin.jvm.internal.l.a(h(i11).getKind(), eVar.h(i11).getKind())) {
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
        List list = this.f[i10];
        return list == null ? t6.t.f12808a : list;
    }

    @Override // e8.e
    public final List getAnnotations() {
        return t6.t.f12808a;
    }

    @Override // e8.e
    public a4 getKind() {
        return e8.i.f7973c;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, s6.f] */
    @Override // e8.e
    public e8.e h(int i10) {
        return ((c8.b[]) this.f8318i.getValue())[i10].getDescriptor();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, s6.f] */
    public int hashCode() {
        return ((Number) this.f8320k.getValue()).intValue();
    }

    @Override // e8.e
    public final boolean i(int i10) {
        return this.g[i10];
    }

    @Override // e8.e
    public boolean isInline() {
        return false;
    }

    public final void j(String str, boolean z9) {
        str.getClass();
        int i10 = this.f8317d + 1;
        this.f8317d = i10;
        String[] strArr = this.e;
        strArr[i10] = str;
        this.g[i10] = z9;
        this.f[i10] = null;
        if (i10 == this.f8316c - 1) {
            HashMap map = new HashMap();
            int length = strArr.length;
            for (int i11 = 0; i11 < length; i11++) {
                map.put(strArr[i11], Integer.valueOf(i11));
            }
            this.h = map;
        }
    }

    public String toString() {
        return t6.l.h0(l5.N(0, this.f8316c), ", ", this.f8314a.concat("("), ")", new a3.s(this, 12), 24);
    }
}

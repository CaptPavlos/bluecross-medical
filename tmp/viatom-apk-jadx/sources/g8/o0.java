package g8;

import com.google.android.gms.internal.measurement.a4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class o0 {

    /* renamed from: a, reason: collision with root package name */
    public static final e8.e[] f8303a = new e8.e[0];

    /* renamed from: b, reason: collision with root package name */
    public static final c8.b[] f8304b = new c8.b[0];

    public static final y a(String str, c8.b bVar) {
        return new y(str, new z(bVar));
    }

    public static final Set b(e8.e eVar) {
        eVar.getClass();
        if (eVar instanceof k) {
            return ((k) eVar).b();
        }
        HashSet hashSet = new HashSet(eVar.e());
        int iE = eVar.e();
        for (int i10 = 0; i10 < iE; i10++) {
            hashSet.add(eVar.f(i10));
        }
        return hashSet;
    }

    public static final e8.e[] c(List list) {
        e8.e[] eVarArr;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            list = null;
        }
        return (list == null || (eVarArr = (e8.e[]) list.toArray(new e8.e[0])) == null) ? f8303a : eVarArr;
    }

    public static final int d(e8.e eVar, e8.e[] eVarArr) {
        eVarArr.getClass();
        int iHashCode = (eVar.a().hashCode() * 31) + Arrays.hashCode(eVarArr);
        int iE = eVar.e();
        int i10 = 1;
        while (true) {
            int iHashCode2 = 0;
            if (!(iE > 0)) {
                break;
            }
            int i11 = iE - 1;
            int i12 = i10 * 31;
            String strA = eVar.h(eVar.e() - iE).a();
            if (strA != null) {
                iHashCode2 = strA.hashCode();
            }
            i10 = i12 + iHashCode2;
            iE = i11;
        }
        int iE2 = eVar.e();
        int iHashCode3 = 1;
        while (true) {
            if (!(iE2 > 0)) {
                return (((iHashCode * 31) + i10) * 31) + iHashCode3;
            }
            int i13 = iE2 - 1;
            int i14 = iHashCode3 * 31;
            a4 kind = eVar.h(eVar.e() - iE2).getKind();
            iHashCode3 = i14 + (kind != null ? kind.hashCode() : 0);
            iE2 = i13;
        }
    }

    public static final void e(e8.e eVar, int i10, int i11) {
        eVar.getClass();
        ArrayList arrayList = new ArrayList();
        int i12 = (~i10) & i11;
        for (int i13 = 0; i13 < 32; i13++) {
            if ((i12 & 1) != 0) {
                arrayList.add(eVar.f(i13));
            }
            i12 >>>= 1;
        }
        throw new c8.c(eVar.a(), arrayList);
    }

    public static final void f(String str, m7.c cVar) {
        String str2;
        cVar.getClass();
        StringBuilder sb = new StringBuilder("in the polymorphic scope of '");
        kotlin.jvm.internal.f fVar = (kotlin.jvm.internal.f) cVar;
        sb.append(fVar.c());
        sb.append('\'');
        String string = sb.toString();
        if (str == null) {
            str2 = "Class discriminator was missing and no default serializers were registered " + string + '.';
        } else {
            str2 = "Serializer for subclass '" + str + "' is not found " + string + ".\nCheck if class with serial name '" + str + "' exists and serializer is registered in a corresponding SerializersModule.\nTo be registered automatically, class '" + str + "' has to be '@Serializable', and the base class '" + fVar.c() + "' has to be sealed and '@Serializable'.";
        }
        throw new c8.f(str2);
    }
}

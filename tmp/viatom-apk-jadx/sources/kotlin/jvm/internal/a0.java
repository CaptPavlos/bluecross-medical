package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a0 {
    public static Collection a(ArrayList arrayList) {
        if (!(arrayList instanceof h7.a) || (arrayList instanceof h7.b)) {
            return arrayList;
        }
        e(arrayList, "kotlin.collections.MutableCollection");
        throw null;
    }

    public static void b(int i10, Object obj) {
        if (obj == null || c(i10, obj)) {
            return;
        }
        e(obj, "kotlin.jvm.functions.Function" + i10);
        throw null;
    }

    public static boolean c(int i10, Object obj) {
        if (obj instanceof s6.c) {
            if ((obj instanceof i ? ((i) obj).getArity() : obj instanceof g7.a ? 0 : obj instanceof g7.l ? 1 : obj instanceof g7.p ? 2 : obj instanceof g7.q ? 3 : obj instanceof g7.r ? 4 : obj instanceof g7.t ? 6 : -1) == i10) {
                return true;
            }
        }
        return false;
    }

    public static final b d(Object[] objArr) {
        objArr.getClass();
        return new b(objArr);
    }

    public static void e(Object obj, String str) {
        ClassCastException classCastException = new ClassCastException(a3.a.j(obj == null ? "null" : obj.getClass().getName(), " cannot be cast to ", str));
        l.e(classCastException, a0.class.getName());
        throw classCastException;
    }
}

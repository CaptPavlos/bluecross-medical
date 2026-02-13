package kotlin.jvm.internal;

import com.google.android.gms.internal.measurement.a4;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f implements m7.c, e {

    /* renamed from: b, reason: collision with root package name */
    public static final Map f10131b;

    /* renamed from: a, reason: collision with root package name */
    public final Class f10132a;

    static {
        int i10 = 0;
        List listQ = t6.m.Q(g7.a.class, g7.l.class, g7.p.class, g7.q.class, g7.r.class, g7.s.class, g7.t.class, g7.u.class, g7.v.class, g7.w.class, g7.b.class, g7.c.class, g7.d.class, g7.e.class, g7.f.class, g7.g.class, g7.h.class, g7.i.class, g7.j.class, g7.k.class, g7.m.class, g7.n.class, g7.o.class);
        ArrayList arrayList = new ArrayList(t6.n.V(listQ, 10));
        for (Object obj : listQ) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                t6.m.U();
                throw null;
            }
            arrayList.add(new s6.i((Class) obj, Integer.valueOf(i10)));
            i10 = i11;
        }
        f10131b = t6.a0.k0(arrayList);
    }

    public f(Class cls) {
        cls.getClass();
        this.f10132a = cls;
    }

    @Override // kotlin.jvm.internal.e
    public final Class a() {
        return this.f10132a;
    }

    public final String b() {
        String strB;
        Class cls = this.f10132a;
        cls.getClass();
        String strConcat = null;
        if (cls.isAnonymousClass() || cls.isLocalClass()) {
            return null;
        }
        if (!cls.isArray()) {
            String strB2 = l.b(cls.getName());
            return strB2 == null ? cls.getCanonicalName() : strB2;
        }
        Class<?> componentType = cls.getComponentType();
        if (componentType.isPrimitive() && (strB = l.b(componentType.getName())) != null) {
            strConcat = strB.concat("Array");
        }
        return strConcat == null ? "kotlin.Array" : strConcat;
    }

    public final String c() {
        String strF;
        Class cls = this.f10132a;
        cls.getClass();
        String strConcat = null;
        if (cls.isAnonymousClass()) {
            return null;
        }
        if (!cls.isLocalClass()) {
            if (!cls.isArray()) {
                String strF2 = l.f(cls.getName());
                return strF2 == null ? cls.getSimpleName() : strF2;
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (strF = l.f(componentType.getName())) != null) {
                strConcat = strF.concat("Array");
            }
            return strConcat == null ? "Array" : strConcat;
        }
        String simpleName = cls.getSimpleName();
        Method enclosingMethod = cls.getEnclosingMethod();
        if (enclosingMethod != null) {
            return o7.m.t0(simpleName, enclosingMethod.getName() + '$');
        }
        Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
        if (enclosingConstructor == null) {
            int iJ0 = o7.m.j0(simpleName, '$', 0, 6);
            return iJ0 == -1 ? simpleName : simpleName.substring(iJ0 + 1, simpleName.length());
        }
        return o7.m.t0(simpleName, enclosingConstructor.getName() + '$');
    }

    public final boolean d(Object obj) {
        Class clsR = this.f10132a;
        clsR.getClass();
        Map map = f10131b;
        map.getClass();
        Integer num = (Integer) map.get(clsR);
        if (num != null) {
            return a0.c(num.intValue(), obj);
        }
        if (clsR.isPrimitive()) {
            clsR = a4.r(y.a(clsR));
        }
        return clsR.isInstance(obj);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof f) && a4.r(this).equals(a4.r((m7.c) obj));
    }

    public final int hashCode() {
        return a4.r(this).hashCode();
    }

    public final String toString() {
        return this.f10132a + " (Kotlin reflection is not available)";
    }
}

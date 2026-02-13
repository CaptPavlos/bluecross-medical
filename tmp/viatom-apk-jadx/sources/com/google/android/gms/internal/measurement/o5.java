package com.google.android.gms.internal.measurement;

import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class o5 extends u4 {
    private static final Map zzd = new ConcurrentHashMap();
    private int zzb;
    protected v6 zzc;

    public o5() {
        this.zza = 0;
        this.zzb = -1;
        this.zzc = v6.f;
    }

    public static o5 l(Class cls) throws ClassNotFoundException {
        Map map = zzd;
        o5 o5Var = (o5) map.get(cls);
        if (o5Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                o5Var = (o5) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (o5Var != null) {
            return o5Var;
        }
        o5 o5Var2 = (o5) ((o5) a7.e(cls)).o(6);
        if (o5Var2 != null) {
            map.put(cls, o5Var2);
            return o5Var2;
        }
        p8.u.e();
        return null;
    }

    public static void m(Class cls, o5 o5Var) {
        o5Var.f();
        zzd.put(cls, o5Var);
    }

    public static Object n(Method method, o5 o5Var, Object... objArr) {
        try {
            return method.invoke(o5Var, objArr);
        } catch (IllegalAccessException e) {
            androidx.privacysandbox.ads.adservices.adid.a.l("Couldn't use Java reflection to implement protocol message reflection.", e);
            return null;
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            androidx.privacysandbox.ads.adservices.adid.a.l("Unexpected exception thrown by generated accessor method.", cause);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.u4
    public final int b(p6 p6Var) {
        if (e()) {
            int iC = p6Var.c(this);
            if (iC >= 0) {
                return iC;
            }
            androidx.window.layout.c.c(String.valueOf(iC).length() + 42, iC);
            return 0;
        }
        int i10 = this.zzb & Integer.MAX_VALUE;
        if (i10 != Integer.MAX_VALUE) {
            return i10;
        }
        int iC2 = p6Var.c(this);
        if (iC2 >= 0) {
            this.zzb = (this.zzb & Integer.MIN_VALUE) | iC2;
            return iC2;
        }
        androidx.window.layout.c.c(String.valueOf(iC2).length() + 42, iC2);
        return 0;
    }

    public final void d(d5 d5Var) {
        p6 p6VarA = m6.f2086c.a(getClass());
        c6 c6Var = d5Var.f1914a;
        if (c6Var == null) {
            c6Var = new c6(d5Var);
        }
        p6VarA.d(this, c6Var);
    }

    public final boolean e() {
        return (this.zzb & Integer.MIN_VALUE) != 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return m6.f2086c.a(getClass()).f(this, (o5) obj);
    }

    public final void f() {
        this.zzb &= Integer.MAX_VALUE;
    }

    public final void g() {
        m6.f2086c.a(getClass()).g(this);
        f();
    }

    public final n5 h() {
        return (n5) o(5);
    }

    public final int hashCode() {
        if (e()) {
            return m6.f2086c.a(getClass()).i(this);
        }
        int i10 = this.zza;
        if (i10 != 0) {
            return i10;
        }
        int i11 = m6.f2086c.a(getClass()).i(this);
        this.zza = i11;
        return i11;
    }

    public final n5 i() {
        n5 n5Var = (n5) o(5);
        n5Var.e(this);
        return n5Var;
    }

    public final void j() {
        this.zzb = (this.zzb & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final int k() {
        if (e()) {
            int iC = m6.f2086c.a(getClass()).c(this);
            if (iC >= 0) {
                return iC;
            }
            androidx.window.layout.c.c(String.valueOf(iC).length() + 42, iC);
            return 0;
        }
        int i10 = this.zzb & Integer.MAX_VALUE;
        if (i10 != Integer.MAX_VALUE) {
            return i10;
        }
        int iC2 = m6.f2086c.a(getClass()).c(this);
        if (iC2 >= 0) {
            this.zzb = (this.zzb & Integer.MIN_VALUE) | iC2;
            return iC2;
        }
        androidx.window.layout.c.c(String.valueOf(iC2).length() + 42, iC2);
        return 0;
    }

    public abstract Object o(int i10);

    public final String toString() {
        String string = super.toString();
        char[] cArr = h6.f1982a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        h6.b(this, sb, 0);
        return sb.toString();
    }
}

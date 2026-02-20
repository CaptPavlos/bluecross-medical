package s6;

import java.lang.reflect.Method;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final x6.a f12684a = x6.a.f13718a;

    public static void a(Throwable th, Throwable th2) {
        th.getClass();
        th2.getClass();
        if (th != th2) {
            Integer num = b7.a.f855a;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(th2);
                return;
            }
            Method method = a7.a.f300a;
            if (method != null) {
                method.invoke(th, th2);
            }
        }
    }

    public static final j b(Throwable th) {
        th.getClass();
        return new j(th);
    }

    public static f c(g gVar, g7.a aVar) {
        t tVar = t.f12708a;
        int iOrdinal = gVar.ordinal();
        if (iOrdinal == 0) {
            return new m(aVar);
        }
        if (iOrdinal == 1) {
            l lVar = new l();
            lVar.f12697a = aVar;
            lVar.f12698b = tVar;
            return lVar;
        }
        if (iOrdinal != 2) {
            androidx.window.layout.c.b();
            return null;
        }
        x xVar = new x();
        xVar.f12712a = aVar;
        xVar.f12713b = tVar;
        return xVar;
    }

    public static m d(g7.a aVar) {
        aVar.getClass();
        return new m(aVar);
    }

    public static final void e(Object obj) {
        if (obj instanceof j) {
            throw ((j) obj).f12695a;
        }
    }
}

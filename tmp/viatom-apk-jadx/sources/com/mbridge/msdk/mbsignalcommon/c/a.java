package com.mbridge.msdk.mbsignalcommon.c;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static InterfaceC0037a f4327a;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.mbsignalcommon.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0037a {
        boolean a(b.C0038a c0038a);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class c<C> {

        /* renamed from: a, reason: collision with root package name */
        protected Class<C> f4330a;

        public c(Class<C> cls) {
            this.f4330a = cls;
        }

        public final d a(String str, Class<?>... clsArr) throws b.C0038a {
            return new d(this.f4330a, str, clsArr, 0);
        }
    }

    public static <T> c<T> a(ClassLoader classLoader, String str) throws b.C0038a {
        try {
            return new c<>(classLoader.loadClass(str));
        } catch (Exception e) {
            b(new b.C0038a(e));
            return new c<>(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(b.C0038a c0038a) throws b.C0038a {
        InterfaceC0037a interfaceC0037a = f4327a;
        if (interfaceC0037a == null || !interfaceC0037a.a(c0038a)) {
            throw c0038a;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class b {

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        /* renamed from: com.mbridge.msdk.mbsignalcommon.c.a$b$a, reason: collision with other inner class name */
        public static class C0038a extends Throwable {

            /* renamed from: a, reason: collision with root package name */
            private Class<?> f4328a;

            /* renamed from: b, reason: collision with root package name */
            private String f4329b;

            public C0038a(String str) {
                super(str);
            }

            public final void a(Class<?> cls) {
                this.f4328a = cls;
            }

            @Override // java.lang.Throwable
            public final String toString() {
                if (getCause() == null) {
                    return super.toString();
                }
                return C0038a.class.getName() + ": " + getCause();
            }

            public final void a(String str) {
                this.f4329b = str;
            }

            public C0038a(Exception exc) {
                super(exc);
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        protected final Method f4331a;

        public d(Class<?> cls, String str, Class<?>[] clsArr, int i10) throws b.C0038a {
            Method declaredMethod = null;
            if (cls == null) {
                return;
            }
            while (cls != Object.class && cls != null) {
                try {
                    declaredMethod = cls.getDeclaredMethod(str, clsArr);
                    break;
                } catch (NoSuchMethodException e) {
                    if (MBridgeConstans.DEBUG && cls.getSuperclass() == Object.class) {
                        e.printStackTrace();
                    }
                    cls = cls.getSuperclass();
                } catch (SecurityException e3) {
                    try {
                        try {
                            if (MBridgeConstans.DEBUG && cls.getSuperclass() == Object.class) {
                                e3.printStackTrace();
                            }
                            cls = cls.getSuperclass();
                        } catch (Exception e7) {
                            b.C0038a c0038a = new b.C0038a(e7);
                            c0038a.a(cls);
                            c0038a.a(str);
                            a.b(c0038a);
                        }
                    } finally {
                        this.f4331a = declaredMethod;
                    }
                }
            }
            if (declaredMethod != null) {
                if (i10 > 0 && (declaredMethod.getModifiers() & i10) != i10) {
                    a.b(new b.C0038a(declaredMethod + " does not match modifiers: " + i10));
                }
                declaredMethod.setAccessible(true);
            }
        }

        public final Object a(Object obj, Object... objArr) throws IllegalArgumentException, InvocationTargetException {
            Method method = this.f4331a;
            if (method == null) {
                return null;
            }
            try {
                return method.invoke(obj, objArr);
            } catch (Exception e) {
                af.a("MappingedMethod", "invoke error:" + e.getMessage());
                return null;
            }
        }

        public final Method a() {
            return this.f4331a;
        }
    }
}

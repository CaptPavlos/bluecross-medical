package h3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends t1 {

    /* renamed from: b, reason: collision with root package name */
    public final Method f8439b = Class.class.getMethod("isRecord", null);

    /* renamed from: c, reason: collision with root package name */
    public final Method f8440c = Class.class.getMethod("getRecordComponents", null);

    /* renamed from: d, reason: collision with root package name */
    public final Method f8441d;
    public final Method e;

    public b() throws ClassNotFoundException {
        Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
        this.f8441d = cls.getMethod("getName", null);
        this.e = cls.getMethod("getType", null);
    }

    @Override // z1.t1
    public final boolean E(Class cls) {
        try {
            return ((Boolean) this.f8439b.invoke(cls, null)).booleanValue();
        } catch (ReflectiveOperationException e) {
            androidx.privacysandbox.ads.adservices.adid.a.l("Unexpected ReflectiveOperationException occurred (Gson 2.13.2). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e);
            return false;
        }
    }

    @Override // z1.t1
    public final Method q(Class cls, Field field) {
        try {
            return cls.getMethod(field.getName(), null);
        } catch (ReflectiveOperationException e) {
            androidx.privacysandbox.ads.adservices.adid.a.l("Unexpected ReflectiveOperationException occurred (Gson 2.13.2). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e);
            return null;
        }
    }

    @Override // z1.t1
    public final Constructor s(Class cls) {
        try {
            Object[] objArr = (Object[]) this.f8440c.invoke(cls, null);
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i10 = 0; i10 < objArr.length; i10++) {
                clsArr[i10] = (Class) this.e.invoke(objArr[i10], null);
            }
            return cls.getDeclaredConstructor(clsArr);
        } catch (ReflectiveOperationException e) {
            androidx.privacysandbox.ads.adservices.adid.a.l("Unexpected ReflectiveOperationException occurred (Gson 2.13.2). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e);
            return null;
        }
    }

    @Override // z1.t1
    public final String[] z(Class cls) {
        try {
            Object[] objArr = (Object[]) this.f8440c.invoke(cls, null);
            String[] strArr = new String[objArr.length];
            for (int i10 = 0; i10 < objArr.length; i10++) {
                strArr[i10] = (String) this.f8441d.invoke(objArr[i10], null);
            }
            return strArr;
        } catch (ReflectiveOperationException e) {
            androidx.privacysandbox.ads.adservices.adid.a.l("Unexpected ReflectiveOperationException occurred (Gson 2.13.2). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e);
            return null;
        }
    }
}

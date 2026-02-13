package com.google.gson.internal.bind;

import com.google.android.gms.internal.measurement.u6;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.f;
import com.google.gson.internal.m;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import d0.i;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ReflectiveTypeAdapterFactory implements j {

    /* renamed from: a, reason: collision with root package name */
    public final i f2504a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2505b;

    /* renamed from: c, reason: collision with root package name */
    public final Excluder f2506c;

    /* renamed from: d, reason: collision with root package name */
    public final JsonAdapterAnnotationTypeAdapterFactory f2507d;
    public final List e;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1, reason: invalid class name */
    class AnonymousClass1 extends com.google.gson.i {
        @Override // com.google.gson.i
        public final Object b(i3.a aVar) throws IOException {
            aVar.D();
            return null;
        }

        @Override // com.google.gson.i
        public final void c(i3.b bVar, Object obj) throws IOException {
            bVar.k();
        }

        public final String toString() {
            return "AnonymousOrNonStaticLocalClassAdapter";
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class Adapter<T, A> extends com.google.gson.i {

        /* renamed from: a, reason: collision with root package name */
        public final d f2508a;

        public Adapter(d dVar) {
            this.f2508a = dVar;
        }

        @Override // com.google.gson.i
        public final Object b(i3.a aVar) throws IOException {
            if (aVar.x() == 9) {
                aVar.t();
                return null;
            }
            Object objD = d();
            Map map = this.f2508a.f2532a;
            try {
                aVar.b();
                while (aVar.k()) {
                    c cVar = (c) map.get(aVar.r());
                    if (cVar == null) {
                        aVar.D();
                    } else {
                        f(objD, aVar, cVar);
                    }
                }
                aVar.h();
                return e(objD);
            } catch (IllegalAccessException e) {
                t1 t1Var = h3.c.f8442a;
                androidx.privacysandbox.ads.adservices.adid.a.l("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
                return null;
            } catch (IllegalStateException e3) {
                throw new com.google.gson.e(e3);
            }
        }

        @Override // com.google.gson.i
        public final void c(i3.b bVar, Object obj) throws IOException {
            if (obj == null) {
                bVar.k();
                return;
            }
            bVar.d();
            try {
                Iterator it = this.f2508a.f2533b.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).a(bVar, obj);
                }
                bVar.h();
            } catch (IllegalAccessException e) {
                t1 t1Var = h3.c.f8442a;
                androidx.privacysandbox.ads.adservices.adid.a.l("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
            }
        }

        public abstract Object d();

        public abstract Object e(Object obj);

        public abstract void f(Object obj, i3.a aVar, c cVar);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class RecordAdapter<T> extends Adapter<T, Object[]> {
        public static final HashMap e;

        /* renamed from: b, reason: collision with root package name */
        public final Constructor f2510b;

        /* renamed from: c, reason: collision with root package name */
        public final Object[] f2511c;

        /* renamed from: d, reason: collision with root package name */
        public final HashMap f2512d;

        static {
            HashMap map = new HashMap();
            map.put(Byte.TYPE, (byte) 0);
            map.put(Short.TYPE, (short) 0);
            map.put(Integer.TYPE, 0);
            map.put(Long.TYPE, 0L);
            map.put(Float.TYPE, Float.valueOf(0.0f));
            map.put(Double.TYPE, Double.valueOf(0.0d));
            map.put(Character.TYPE, (char) 0);
            map.put(Boolean.TYPE, Boolean.FALSE);
            e = map;
        }

        public RecordAdapter(Class cls, d dVar) {
            super(dVar);
            this.f2512d = new HashMap();
            t1 t1Var = h3.c.f8442a;
            Constructor constructorS = t1Var.s(cls);
            this.f2510b = constructorS;
            h3.c.f(constructorS);
            String[] strArrZ = t1Var.z(cls);
            for (int i10 = 0; i10 < strArrZ.length; i10++) {
                this.f2512d.put(strArrZ[i10], Integer.valueOf(i10));
            }
            Class<?>[] parameterTypes = this.f2510b.getParameterTypes();
            this.f2511c = new Object[parameterTypes.length];
            for (int i11 = 0; i11 < parameterTypes.length; i11++) {
                this.f2511c[i11] = e.get(parameterTypes[i11]);
            }
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final Object d() {
            return (Object[]) this.f2511c.clone();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final Object e(Object obj) {
            Object[] objArr = (Object[]) obj;
            Constructor constructor = this.f2510b;
            try {
                return constructor.newInstance(objArr);
            } catch (IllegalAccessException e3) {
                t1 t1Var = h3.c.f8442a;
                androidx.privacysandbox.ads.adservices.adid.a.l("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e3);
                return null;
            } catch (IllegalArgumentException e7) {
                e = e7;
                throw new RuntimeException("Failed to invoke constructor '" + h3.c.b(constructor) + "' with args " + Arrays.toString(objArr), e);
            } catch (InstantiationException e10) {
                e = e10;
                throw new RuntimeException("Failed to invoke constructor '" + h3.c.b(constructor) + "' with args " + Arrays.toString(objArr), e);
            } catch (InvocationTargetException e11) {
                androidx.privacysandbox.ads.adservices.adid.a.l("Failed to invoke constructor '" + h3.c.b(constructor) + "' with args " + Arrays.toString(objArr), e11.getCause());
                return null;
            }
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final void f(Object obj, i3.a aVar, c cVar) {
            Object[] objArr = (Object[]) obj;
            String str = cVar.f2529c;
            Integer num = (Integer) this.f2512d.get(str);
            if (num == null) {
                androidx.window.layout.c.i("Could not find the index in the constructor '", h3.c.b(this.f2510b), "' for field with name '", str, "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
                return;
            }
            int iIntValue = num.intValue();
            Object objB = cVar.f.b(aVar);
            if (objB != null || !cVar.g) {
                objArr[iIntValue] = objB;
            } else {
                StringBuilder sbY = a3.a.y("null is not allowed as value for record component '", str, "' of primitive type; at path ");
                sbY.append(aVar.j(false));
                throw new u6(sbY.toString());
            }
        }
    }

    public ReflectiveTypeAdapterFactory(i iVar, int i10, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        List list = Collections.EMPTY_LIST;
        this.f2504a = iVar;
        this.f2505b = i10;
        this.f2506c = excluder;
        this.f2507d = jsonAdapterAnnotationTypeAdapterFactory;
        this.e = list;
    }

    public static void b(Class cls, String str, Field field, Field field2) {
        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + str + "'; conflict is caused by fields " + h3.c.c(field) + " and " + h3.c.c(field2) + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("duplicate-fields"));
    }

    @Override // com.google.gson.j
    public final com.google.gson.i a(com.google.gson.b bVar, TypeToken typeToken) {
        Class cls = typeToken.f2599a;
        if (!Object.class.isAssignableFrom(cls)) {
            return null;
        }
        t1 t1Var = h3.c.f8442a;
        if (!Modifier.isStatic(cls.getModifiers()) && (cls.isAnonymousClass() || cls.isLocalClass())) {
            return new AnonymousClass1();
        }
        List list = Collections.EMPTY_LIST;
        f.e();
        return h3.c.f8442a.E(cls) ? new RecordAdapter(cls, c(bVar, typeToken, cls, true)) : new FieldReflectionAdapter(this.f2504a.z(typeToken, true), c(bVar, typeToken, cls, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01c7  */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.gson.internal.bind.d c(com.google.gson.b r30, com.google.gson.reflect.TypeToken r31, java.lang.Class r32, boolean r33) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.c(com.google.gson.b, com.google.gson.reflect.TypeToken, java.lang.Class, boolean):com.google.gson.internal.bind.d");
    }

    public final boolean d(Field field, boolean z9) {
        boolean z10;
        Excluder excluder = this.f2506c;
        excluder.getClass();
        if ((136 & field.getModifiers()) != 0 || field.isSynthetic() || excluder.b(field.getType(), z9)) {
            z10 = true;
        } else {
            List list = z9 ? excluder.f2467a : excluder.f2468b;
            if (!list.isEmpty()) {
                Iterator it = list.iterator();
                if (it.hasNext()) {
                    it.next().getClass();
                    com.google.gson.internal.a.k();
                    return false;
                }
            }
            z10 = false;
        }
        return !z10;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class FieldReflectionAdapter<T> extends Adapter<T, T> {

        /* renamed from: b, reason: collision with root package name */
        public final m f2509b;

        public FieldReflectionAdapter(m mVar, d dVar) {
            super(dVar);
            this.f2509b = mVar;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final Object d() {
            return this.f2509b.d();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final void f(Object obj, i3.a aVar, c cVar) throws IllegalAccessException, IllegalArgumentException {
            Field field = cVar.f2528b;
            Object objB = cVar.f.b(aVar);
            if (objB == null && cVar.g) {
                return;
            }
            if (cVar.h) {
                throw new com.google.gson.e("Cannot set value of 'static final' ".concat(h3.c.d(field, false)));
            }
            field.set(obj, objB);
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final Object e(Object obj) {
            return obj;
        }
    }
}

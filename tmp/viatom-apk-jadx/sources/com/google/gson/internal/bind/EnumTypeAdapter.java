package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.Enum;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
class EnumTypeAdapter<T extends Enum<T>> extends i {

    /* renamed from: d, reason: collision with root package name */
    public static final j f2485d = new j() { // from class: com.google.gson.internal.bind.EnumTypeAdapter.1
        @Override // com.google.gson.j
        public final i a(com.google.gson.b bVar, TypeToken typeToken) {
            Class superclass = typeToken.f2599a;
            if (!Enum.class.isAssignableFrom(superclass) || superclass == Enum.class) {
                return null;
            }
            if (!superclass.isEnum()) {
                superclass = superclass.getSuperclass();
            }
            return new EnumTypeAdapter(superclass);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f2486a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f2487b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f2488c = new HashMap();

    public EnumTypeAdapter(Class cls) throws SecurityException {
        try {
            Field[] declaredFields = cls.getDeclaredFields();
            int i10 = 0;
            for (Field field : declaredFields) {
                if (field.isEnumConstant()) {
                    declaredFields[i10] = field;
                    i10++;
                }
            }
            Field[] fieldArr = (Field[]) Arrays.copyOf(declaredFields, i10);
            AccessibleObject.setAccessible(fieldArr, true);
            for (Field field2 : fieldArr) {
                Enum r42 = (Enum) field2.get(null);
                String strName = r42.name();
                String string = r42.toString();
                f3.b bVar = (f3.b) field2.getAnnotation(f3.b.class);
                if (bVar != null) {
                    strName = bVar.value();
                    for (String str : bVar.alternate()) {
                        this.f2486a.put(str, r42);
                    }
                }
                this.f2486a.put(strName, r42);
                this.f2487b.put(string, r42);
                this.f2488c.put(r42, strName);
            }
        } catch (IllegalAccessException e) {
            u.h(e);
            throw null;
        }
    }

    @Override // com.google.gson.i
    public final Object b(i3.a aVar) throws IOException {
        if (aVar.x() == 9) {
            aVar.t();
            return null;
        }
        String strV = aVar.v();
        Enum r02 = (Enum) this.f2486a.get(strV);
        return r02 == null ? (Enum) this.f2487b.get(strV) : r02;
    }

    @Override // com.google.gson.i
    public final void c(i3.b bVar, Object obj) throws IOException {
        Enum r32 = (Enum) obj;
        bVar.s(r32 == null ? null : (String) this.f2488c.get(r32));
    }
}

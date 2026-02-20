package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import com.google.android.gms.internal.measurement.a4;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.a0;
import o7.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class Lifecycling {
    private static final int GENERATED_CALLBACK = 2;
    private static final int REFLECTIVE_CALLBACK = 1;
    public static final Lifecycling INSTANCE = new Lifecycling();
    private static final Map<Class<?>, Integer> callbackCache = new HashMap();
    private static final Map<Class<?>, List<Constructor<? extends GeneratedAdapter>>> classToAdapters = new HashMap();

    private Lifecycling() {
    }

    private final GeneratedAdapter createGeneratedAdapter(Constructor<? extends GeneratedAdapter> constructor, Object obj) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            GeneratedAdapter generatedAdapterNewInstance = constructor.newInstance(obj);
            generatedAdapterNewInstance.getClass();
            return generatedAdapterNewInstance;
        } catch (IllegalAccessException e) {
            com.google.gson.internal.a.j(e);
            return null;
        } catch (InstantiationException e3) {
            com.google.gson.internal.a.j(e3);
            return null;
        } catch (InvocationTargetException e7) {
            com.google.gson.internal.a.j(e7);
            return null;
        }
    }

    private final Constructor<? extends GeneratedAdapter> generatedConstructor(Class<?> cls) throws NoSuchMethodException, SecurityException {
        try {
            Package r12 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r12 != null ? r12.getName() : "";
            name.getClass();
            if (name.length() != 0) {
                canonicalName.getClass();
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            canonicalName.getClass();
            String adapterName = getAdapterName(canonicalName);
            if (name.length() != 0) {
                adapterName = name + '.' + adapterName;
            }
            Constructor declaredConstructor = Class.forName(adapterName).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            com.google.gson.internal.a.j(e);
            return null;
        }
    }

    public static final String getAdapterName(String str) {
        str.getClass();
        return u.b0(str, ".", "_", false).concat("_LifecycleAdapter");
    }

    private final int getObserverConstructorType(Class<?> cls) throws NoSuchMethodException, SecurityException {
        Map<Class<?>, Integer> map = callbackCache;
        Integer num = map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iResolveObserverCallbackType = resolveObserverCallbackType(cls);
        map.put(cls, Integer.valueOf(iResolveObserverCallbackType));
        return iResolveObserverCallbackType;
    }

    private final boolean isLifecycleParent(Class<?> cls) {
        return cls != null && LifecycleObserver.class.isAssignableFrom(cls);
    }

    public static final LifecycleEventObserver lifecycleEventObserver(Object obj) {
        obj.getClass();
        boolean z9 = obj instanceof LifecycleEventObserver;
        boolean z10 = obj instanceof DefaultLifecycleObserver;
        if (z9 && z10) {
            return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) obj, (LifecycleEventObserver) obj);
        }
        if (z10) {
            return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) obj, null);
        }
        if (z9) {
            return (LifecycleEventObserver) obj;
        }
        Class<?> cls = obj.getClass();
        Lifecycling lifecycling = INSTANCE;
        if (lifecycling.getObserverConstructorType(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List<Constructor<? extends GeneratedAdapter>> list = classToAdapters.get(cls);
        list.getClass();
        List<Constructor<? extends GeneratedAdapter>> list2 = list;
        if (list2.size() == 1) {
            return new SingleGeneratedAdapterObserver(lifecycling.createGeneratedAdapter(list2.get(0), obj));
        }
        int size = list2.size();
        GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[size];
        for (int i10 = 0; i10 < size; i10++) {
            generatedAdapterArr[i10] = INSTANCE.createGeneratedAdapter(list2.get(i10), obj);
        }
        return new CompositeGeneratedAdaptersObserver(generatedAdapterArr);
    }

    private final int resolveObserverCallbackType(Class<?> cls) throws NoSuchMethodException, SecurityException {
        ArrayList arrayList;
        if (cls.getCanonicalName() != null) {
            Constructor<? extends GeneratedAdapter> constructorGeneratedConstructor = generatedConstructor(cls);
            if (constructorGeneratedConstructor != null) {
                classToAdapters.put(cls, a4.u(constructorGeneratedConstructor));
                return 2;
            }
            if (!ClassesInfoCache.sInstance.hasLifecycleMethods(cls)) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (isLifecycleParent(superclass)) {
                    superclass.getClass();
                    if (getObserverConstructorType(superclass) != 1) {
                        List<Constructor<? extends GeneratedAdapter>> list = classToAdapters.get(superclass);
                        list.getClass();
                        arrayList = new ArrayList(list);
                    }
                } else {
                    arrayList = null;
                }
                kotlin.jvm.internal.b bVarD = a0.d(cls.getInterfaces());
                while (true) {
                    if (bVarD.hasNext()) {
                        Class<?> cls2 = (Class) bVarD.next();
                        if (isLifecycleParent(cls2)) {
                            cls2.getClass();
                            if (getObserverConstructorType(cls2) == 1) {
                                break;
                            }
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            List<Constructor<? extends GeneratedAdapter>> list2 = classToAdapters.get(cls2);
                            list2.getClass();
                            arrayList.addAll(list2);
                        }
                    } else if (arrayList != null) {
                        classToAdapters.put(cls, arrayList);
                        return 2;
                    }
                }
            }
        }
        return 1;
    }
}

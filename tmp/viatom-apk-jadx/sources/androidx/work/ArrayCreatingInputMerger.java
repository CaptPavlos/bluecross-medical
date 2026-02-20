package androidx.work;

import androidx.work.Data;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.l;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ArrayCreatingInputMerger extends InputMerger {
    private final Object concatenateArrayAndNonArray(Object obj, Object obj2, Class<?> cls) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        int length = Array.getLength(obj);
        Object objNewInstance = Array.newInstance(cls, length + 1);
        System.arraycopy(obj, 0, objNewInstance, 0, length);
        Array.set(objNewInstance, length, obj2);
        objNewInstance.getClass();
        return objNewInstance;
    }

    private final Object concatenateArrays(Object obj, Object obj2) throws NegativeArraySizeException {
        int length = Array.getLength(obj);
        int length2 = Array.getLength(obj2);
        Class<?> componentType = obj.getClass().getComponentType();
        componentType.getClass();
        Object objNewInstance = Array.newInstance(componentType, length + length2);
        System.arraycopy(obj, 0, objNewInstance, 0, length);
        System.arraycopy(obj2, 0, objNewInstance, length, length2);
        objNewInstance.getClass();
        return objNewInstance;
    }

    private final Object createArrayFor(Object obj, Class<?> cls) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        Object objNewInstance = Array.newInstance(cls, 1);
        Array.set(objNewInstance, 0, obj);
        objNewInstance.getClass();
        return objNewInstance;
    }

    @Override // androidx.work.InputMerger
    public Data merge(List<Data> list) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        list.getClass();
        Data.Builder builder = new Data.Builder();
        HashMap map = new HashMap();
        Iterator<Data> it = list.iterator();
        while (it.hasNext()) {
            for (Map.Entry<String, Object> entry : it.next().getKeyValueMap().entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                Class cls = value != null ? value.getClass() : String.class;
                Object obj = map.get(key);
                if (obj != null) {
                    Class<?> cls2 = obj.getClass();
                    if (cls2.equals(cls)) {
                        value.getClass();
                        value = concatenateArrays(obj, value);
                    } else {
                        if (!l.a(cls2.getComponentType(), cls)) {
                            f.a();
                            return null;
                        }
                        value = concatenateArrayAndNonArray(obj, value, cls);
                    }
                } else if (cls.isArray()) {
                    value.getClass();
                } else {
                    value = createArrayFor(value, cls);
                }
                map.put(key, value);
            }
        }
        builder.putAll(map);
        return builder.build();
    }
}

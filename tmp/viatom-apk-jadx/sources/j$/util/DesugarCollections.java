package j$.util;

import java.util.RandomAccess;
import java.util.Set;

/* loaded from: classes2.dex */
public class DesugarCollections {
    public static <T> java.util.Collection<T> unmodifiableCollection(java.util.Collection<? extends T> collection) {
        return new n(collection);
    }

    public static <T> Set<T> unmodifiableSet(Set<? extends T> set) {
        return new w(set);
    }

    public static <T> java.util.List<T> unmodifiableList(java.util.List<? extends T> list) {
        if (!(list instanceof RandomAccess)) {
            return new p(list);
        }
        return new v(list);
    }

    public static <K, V> java.util.Map<K, V> unmodifiableMap(java.util.Map<? extends K, ? extends V> map) {
        return new u(map);
    }

    public static <T> Set<T> synchronizedSet(Set<T> set) {
        return new l(set);
    }

    public static <T> java.util.List<T> synchronizedList(java.util.List<T> list) {
        if (!(list instanceof RandomAccess)) {
            return new i(list);
        }
        return new k(list);
    }

    public static <K, V> java.util.Map<K, V> synchronizedMap(java.util.Map<K, V> map) {
        return new j(map);
    }
}

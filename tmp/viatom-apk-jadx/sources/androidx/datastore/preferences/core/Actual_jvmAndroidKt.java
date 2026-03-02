package androidx.datastore.preferences.core;

import androidx.annotation.RestrictTo;
import j$.util.DesugarCollections;
import java.util.Map;
import java.util.Set;
import r7.i0;
import r7.s;
import t6.l;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class Actual_jvmAndroidKt {
    public static final <T> Set<T> immutableCopyOfSet(Set<? extends T> set) {
        set.getClass();
        Set<T> setUnmodifiableSet = DesugarCollections.unmodifiableSet(l.u0(set));
        setUnmodifiableSet.getClass();
        return setUnmodifiableSet;
    }

    public static final <K, V> Map<K, V> immutableMap(Map<K, ? extends V> map) {
        map.getClass();
        Map<K, V> mapUnmodifiableMap = DesugarCollections.unmodifiableMap(map);
        mapUnmodifiableMap.getClass();
        return mapUnmodifiableMap;
    }

    public static final s ioDispatcher() {
        e eVar = i0.f12407a;
        return d.f14116a;
    }
}

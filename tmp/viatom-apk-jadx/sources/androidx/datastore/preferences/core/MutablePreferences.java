package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.Preferences;
import androidx.window.layout.c;
import g7.l;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import s6.i;
import t6.a0;
import t6.j;
import t6.n;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class MutablePreferences extends Preferences {
    private final AtomicBoolean frozen;
    private final Map<Preferences.Key<?>, Object> preferencesMap;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.datastore.preferences.core.MutablePreferences$toString$1, reason: invalid class name */
    public static final class AnonymousClass1 extends m implements l {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // g7.l
        public final CharSequence invoke(Map.Entry<Preferences.Key<?>, Object> entry) {
            entry.getClass();
            Object value = entry.getValue();
            return "  " + entry.getKey().getName() + " = " + (value instanceof byte[] ? j.w0(", ", 56, (byte[]) value) : String.valueOf(entry.getValue()));
        }
    }

    public /* synthetic */ MutablePreferences(Map map, boolean z9, int i10, g gVar) {
        this((i10 & 1) != 0 ? new LinkedHashMap() : map, (i10 & 2) != 0 ? true : z9);
    }

    @Override // androidx.datastore.preferences.core.Preferences
    public Map<Preferences.Key<?>, Object> asMap() {
        i iVar;
        Set<Map.Entry<Preferences.Key<?>, Object>> setEntrySet = this.preferencesMap.entrySet();
        int iH0 = a0.h0(n.V(setEntrySet, 10));
        if (iH0 < 16) {
            iH0 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iH0);
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                iVar = new i(entry.getKey(), Arrays.copyOf(bArr, bArr.length));
            } else {
                iVar = new i(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(iVar.f12693a, iVar.f12694b);
        }
        return Actual_jvmAndroidKt.immutableMap(linkedHashMap);
    }

    public final void checkNotFrozen$datastore_preferences_core_release() {
        if (this.frozen.get()) {
            c.g("Do mutate preferences once returned to DataStore.");
        }
    }

    public final void clear() {
        checkNotFrozen$datastore_preferences_core_release();
        this.preferencesMap.clear();
    }

    @Override // androidx.datastore.preferences.core.Preferences
    public <T> boolean contains(Preferences.Key<T> key) {
        key.getClass();
        return this.preferencesMap.containsKey(key);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.preferences.core.MutablePreferences
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            androidx.datastore.preferences.core.MutablePreferences r6 = (androidx.datastore.preferences.core.MutablePreferences) r6
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r0 = r6.preferencesMap
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r2 = r5.preferencesMap
            r3 = 1
            if (r0 != r2) goto L10
            return r3
        L10:
            int r0 = r0.size()
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r2 = r5.preferencesMap
            int r2 = r2.size()
            if (r0 == r2) goto L1d
            return r1
        L1d:
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r6 = r6.preferencesMap
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L26
            return r3
        L26:
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L2e:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L67
            java.lang.Object r0 = r6.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r2 = r5.preferencesMap
            java.lang.Object r4 = r0.getKey()
            java.lang.Object r2 = r2.get(r4)
            if (r2 == 0) goto L63
            java.lang.Object r0 = r0.getValue()
            boolean r4 = r0 instanceof byte[]
            if (r4 == 0) goto L5e
            boolean r4 = r2 instanceof byte[]
            if (r4 == 0) goto L63
            byte[] r0 = (byte[]) r0
            byte[] r2 = (byte[]) r2
            boolean r0 = java.util.Arrays.equals(r0, r2)
            if (r0 == 0) goto L63
            r0 = r3
            goto L64
        L5e:
            boolean r0 = kotlin.jvm.internal.l.a(r0, r2)
            goto L64
        L63:
            r0 = r1
        L64:
            if (r0 != 0) goto L2e
            return r1
        L67:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.core.MutablePreferences.equals(java.lang.Object):boolean");
    }

    public final void freeze$datastore_preferences_core_release() {
        this.frozen.set(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.core.Preferences
    public <T> T get(Preferences.Key<T> key) {
        key.getClass();
        T t = (T) this.preferencesMap.get(key);
        if (!(t instanceof byte[])) {
            return t;
        }
        byte[] bArr = (byte[]) t;
        return (T) Arrays.copyOf(bArr, bArr.length);
    }

    public final Map<Preferences.Key<?>, Object> getPreferencesMap$datastore_preferences_core_release() {
        return this.preferencesMap;
    }

    public int hashCode() {
        Iterator<T> it = this.preferencesMap.entrySet().iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            iHashCode += value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value.hashCode();
        }
        return iHashCode;
    }

    public final void minusAssign(Preferences.Key<?> key) {
        key.getClass();
        checkNotFrozen$datastore_preferences_core_release();
        remove(key);
    }

    public final void plusAssign(Preferences preferences) {
        preferences.getClass();
        checkNotFrozen$datastore_preferences_core_release();
        this.preferencesMap.putAll(preferences.asMap());
    }

    public final void putAll(Preferences.Pair<?>... pairArr) {
        pairArr.getClass();
        checkNotFrozen$datastore_preferences_core_release();
        for (Preferences.Pair<?> pair : pairArr) {
            setUnchecked$datastore_preferences_core_release(pair.getKey$datastore_preferences_core_release(), pair.getValue$datastore_preferences_core_release());
        }
    }

    public final <T> T remove(Preferences.Key<T> key) {
        key.getClass();
        checkNotFrozen$datastore_preferences_core_release();
        return (T) this.preferencesMap.remove(key);
    }

    public final <T> void set(Preferences.Key<T> key, T t) {
        key.getClass();
        setUnchecked$datastore_preferences_core_release(key, t);
    }

    public final void setUnchecked$datastore_preferences_core_release(Preferences.Key<?> key, Object obj) {
        key.getClass();
        checkNotFrozen$datastore_preferences_core_release();
        if (obj == null) {
            remove(key);
            return;
        }
        if (obj instanceof Set) {
            this.preferencesMap.put(key, Actual_jvmAndroidKt.immutableCopyOfSet((Set) obj));
            return;
        }
        boolean z9 = obj instanceof byte[];
        Map<Preferences.Key<?>, Object> map = this.preferencesMap;
        if (!z9) {
            map.put(key, obj);
        } else {
            byte[] bArr = (byte[]) obj;
            map.put(key, Arrays.copyOf(bArr, bArr.length));
        }
    }

    public String toString() {
        return t6.l.h0(this.preferencesMap.entrySet(), ",\n", "{\n", "\n}", AnonymousClass1.INSTANCE, 24);
    }

    public final void plusAssign(Preferences.Pair<?> pair) {
        pair.getClass();
        checkNotFrozen$datastore_preferences_core_release();
        putAll(pair);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MutablePreferences() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public MutablePreferences(Map<Preferences.Key<?>, Object> map, boolean z9) {
        map.getClass();
        this.preferencesMap = map;
        this.frozen = new AtomicBoolean(z9);
    }
}

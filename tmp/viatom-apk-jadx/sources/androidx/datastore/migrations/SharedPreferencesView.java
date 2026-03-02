package androidx.datastore.migrations;

import a3.a;
import android.content.SharedPreferences;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import t6.a0;
import t6.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SharedPreferencesView {
    private final Set<String> keySet;
    private final SharedPreferences prefs;

    public SharedPreferencesView(SharedPreferences sharedPreferences, Set<String> set) {
        sharedPreferences.getClass();
        this.prefs = sharedPreferences;
        this.keySet = set;
    }

    private final String checkKey(String str) {
        Set<String> set = this.keySet;
        if (set == null || set.contains(str)) {
            return str;
        }
        throw new IllegalStateException(a.i("Can't access key outside migration: ", str).toString());
    }

    public static /* synthetic */ String getString$default(SharedPreferencesView sharedPreferencesView, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return sharedPreferencesView.getString(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Set getStringSet$default(SharedPreferencesView sharedPreferencesView, String str, Set set, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            set = null;
        }
        return sharedPreferencesView.getStringSet(str, set);
    }

    public final boolean contains(String str) {
        str.getClass();
        return this.prefs.contains(checkKey(str));
    }

    public final Map<String, Object> getAll() {
        Map<String, ?> all = this.prefs.getAll();
        all.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Set<String> set = this.keySet;
            if (set != null ? set.contains(key) : true) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(a0.h0(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key2 = entry2.getKey();
            Object value = entry2.getValue();
            if (value instanceof Set) {
                value = l.u0((Iterable) value);
            }
            linkedHashMap2.put(key2, value);
        }
        return linkedHashMap2;
    }

    public final boolean getBoolean(String str, boolean z9) {
        str.getClass();
        return this.prefs.getBoolean(checkKey(str), z9);
    }

    public final float getFloat(String str, float f) {
        str.getClass();
        return this.prefs.getFloat(checkKey(str), f);
    }

    public final int getInt(String str, int i10) {
        str.getClass();
        return this.prefs.getInt(checkKey(str), i10);
    }

    public final long getLong(String str, long j10) {
        str.getClass();
        return this.prefs.getLong(checkKey(str), j10);
    }

    public final String getString(String str, String str2) {
        str.getClass();
        return this.prefs.getString(checkKey(str), str2);
    }

    public final Set<String> getStringSet(String str, Set<String> set) {
        str.getClass();
        Set<String> stringSet = this.prefs.getStringSet(checkKey(str), set);
        if (stringSet != null) {
            return l.t0(stringSet);
        }
        return null;
    }
}

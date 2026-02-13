package y1;

import android.util.Log;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f13753a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final int f13754b = 64;

    /* renamed from: c, reason: collision with root package name */
    public final int f13755c;

    public e(int i10) {
        this.f13755c = i10;
    }

    public static String b(int i10, String str) {
        if (str != null) {
            str = str.trim();
            if (str.length() > i10) {
                return str.substring(0, i10);
            }
        }
        return str;
    }

    public final synchronized Map a() {
        return DesugarCollections.unmodifiableMap(new HashMap(this.f13753a));
    }

    public final synchronized boolean c(String str, String str2) {
        String strB = b(this.f13755c, str);
        if (this.f13753a.size() >= this.f13754b && !this.f13753a.containsKey(strB)) {
            Log.w("FirebaseCrashlytics", "Ignored entry \"" + str + "\" when adding custom keys. Maximum allowable: " + this.f13754b, null);
            return false;
        }
        String strB2 = b(this.f13755c, str2);
        String str3 = (String) this.f13753a.get(strB);
        if (str3 == null ? strB2 == null : str3.equals(strB2)) {
            return false;
        }
        this.f13753a.put(strB, strB2);
        return true;
    }

    public final synchronized void d(Map map) {
        try {
            int i10 = 0;
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw new IllegalArgumentException("Custom attribute key must not be null.");
                }
                String strB = b(this.f13755c, str);
                if (this.f13753a.size() < this.f13754b || this.f13753a.containsKey(strB)) {
                    String str2 = (String) entry.getValue();
                    this.f13753a.put(strB, str2 == null ? "" : b(this.f13755c, str2));
                } else {
                    i10++;
                }
            }
            if (i10 > 0) {
                Log.w("FirebaseCrashlytics", "Ignored " + i10 + " entries when adding custom keys. Maximum allowable: " + this.f13754b, null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}

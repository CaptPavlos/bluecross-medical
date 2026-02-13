package com.google.android.gms.internal.measurement;

import java.util.HashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    public static final j1.g f1882d = j1.g.i(3, "_syn", "_err", "_el");

    /* renamed from: a, reason: collision with root package name */
    public String f1883a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1884b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f1885c;

    public b(String str, long j10, HashMap map) {
        this.f1883a = str;
        this.f1884b = j10;
        HashMap map2 = new HashMap();
        this.f1885c = map2;
        if (map != null) {
            map2.putAll(map);
        }
    }

    public static Object b(Object obj, String str, Object obj2) {
        if (f1882d.contains(str) && (obj2 instanceof Double)) {
            return Long.valueOf(Math.round(((Double) obj2).doubleValue()));
        }
        if (str.startsWith("_")) {
            if (!(obj instanceof String) && obj != null) {
                return obj;
            }
        } else if (!(obj instanceof Double)) {
            if (obj instanceof Long) {
                return Long.valueOf(Math.round(((Double) obj2).doubleValue()));
            }
            if (obj instanceof String) {
                return obj2.toString();
            }
        }
        return obj2;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final b clone() {
        return new b(this.f1883a, this.f1884b, new HashMap(this.f1885c));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f1884b == bVar.f1884b && this.f1883a.equals(bVar.f1883a)) {
            return this.f1885c.equals(bVar.f1885c);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f1883a.hashCode() * 31;
        long j10 = this.f1884b;
        return this.f1885c.hashCode() + ((iHashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31);
    }

    public final String toString() {
        String str = this.f1883a;
        String string = this.f1885c.toString();
        int length = String.valueOf(str).length();
        long j10 = this.f1884b;
        StringBuilder sb = new StringBuilder(length + 25 + String.valueOf(j10).length() + 9 + string.length() + 1);
        sb.append("Event{name='");
        sb.append(str);
        sb.append("', timestamp=");
        sb.append(j10);
        sb.append(", params=");
        sb.append(string);
        sb.append("}");
        return sb.toString();
    }
}

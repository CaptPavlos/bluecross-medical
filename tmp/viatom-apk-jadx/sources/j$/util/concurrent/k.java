package j$.util.concurrent;

import java.util.Map;

/* loaded from: classes2.dex */
public final class k implements Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public final Object f9378a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9379b;

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f9380c;

    public k(Object obj, Object obj2, ConcurrentHashMap concurrentHashMap) {
        this.f9378a = obj;
        this.f9379b = obj2;
        this.f9380c = concurrentHashMap;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f9378a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f9379b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f9378a.hashCode() ^ this.f9379b.hashCode();
    }

    public final String toString() {
        return j$.com.android.tools.r8.a.D(this.f9378a, this.f9379b);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        Map.Entry entry;
        Object key;
        Object value;
        if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (value = entry.getValue()) == null) {
            return false;
        }
        Object obj2 = this.f9378a;
        if (key != obj2 && !key.equals(obj2)) {
            return false;
        }
        Object obj3 = this.f9379b;
        return value == obj3 || value.equals(obj3);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        obj.getClass();
        Object obj2 = this.f9379b;
        this.f9379b = obj;
        this.f9380c.put(this.f9378a, obj);
        return obj2;
    }
}

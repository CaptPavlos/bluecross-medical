package j$.util.concurrent;

import java.util.Map;

/* loaded from: classes2.dex */
public class l implements Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public final int f9381a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f9382b;

    /* renamed from: c, reason: collision with root package name */
    public volatile Object f9383c;

    /* renamed from: d, reason: collision with root package name */
    public volatile l f9384d;

    public l(int i10, Object obj, Object obj2) {
        this.f9381a = i10;
        this.f9382b = obj;
        this.f9383c = obj2;
    }

    public l(int i10, Object obj, Object obj2, l lVar) {
        this(i10, obj, obj2);
        this.f9384d = lVar;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f9382b;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f9383c;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f9382b.hashCode() ^ this.f9383c.hashCode();
    }

    public final String toString() {
        return j$.com.android.tools.r8.a.D(this.f9382b, this.f9383c);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        Map.Entry entry;
        Object key;
        Object value;
        if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (value = entry.getValue()) == null) {
            return false;
        }
        Object obj2 = this.f9382b;
        if (key != obj2 && !key.equals(obj2)) {
            return false;
        }
        Object obj3 = this.f9383c;
        return value == obj3 || value.equals(obj3);
    }

    public l a(int i10, Object obj) {
        Object obj2;
        l lVar = this;
        do {
            if (lVar.f9381a == i10 && ((obj2 = lVar.f9382b) == obj || (obj2 != null && obj.equals(obj2)))) {
                return lVar;
            }
            lVar = lVar.f9384d;
        } while (lVar != null);
        return null;
    }
}

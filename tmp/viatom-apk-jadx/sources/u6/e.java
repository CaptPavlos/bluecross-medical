package u6;

import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements Map.Entry, h7.c {

    /* renamed from: a, reason: collision with root package name */
    public final f f12952a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12953b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12954c;

    public e(f fVar, int i10) {
        fVar.getClass();
        this.f12952a = fVar;
        this.f12953b = i10;
        this.f12954c = fVar.h;
    }

    public final void a() {
        if (this.f12952a.h != this.f12954c) {
            throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
        }
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return l.a(entry.getKey(), getKey()) && l.a(entry.getValue(), getValue());
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        a();
        return this.f12952a.f12956a[this.f12953b];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        a();
        Object[] objArr = this.f12952a.f12957b;
        objArr.getClass();
        return objArr[this.f12953b];
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object key = getKey();
        int iHashCode = key != null ? key.hashCode() : 0;
        Object value = getValue();
        return iHashCode ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        a();
        f fVar = this.f12952a;
        fVar.d();
        Object[] objArr = fVar.f12957b;
        if (objArr == null) {
            int length = fVar.f12956a.length;
            if (length < 0) {
                com.google.gson.internal.a.n("capacity must be non-negative.");
                return null;
            }
            objArr = new Object[length];
            fVar.f12957b = objArr;
        }
        int i10 = this.f12953b;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        return obj2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append('=');
        sb.append(getValue());
        return sb.toString();
    }
}

package n7;

import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements Iterator, h7.a {

    /* renamed from: a, reason: collision with root package name */
    public Object f11577a;

    /* renamed from: b, reason: collision with root package name */
    public int f11578b = -2;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f11579c;

    public e(d dVar) {
        this.f11579c = dVar;
    }

    public final void a() {
        Object objInvoke;
        int i10 = this.f11578b;
        d dVar = this.f11579c;
        if (i10 == -2) {
            objInvoke = ((g7.a) dVar.f11575b).invoke();
        } else {
            g7.l lVar = (g7.l) dVar.f11576c;
            Object obj = this.f11577a;
            obj.getClass();
            objInvoke = lVar.invoke(obj);
        }
        this.f11577a = objInvoke;
        this.f11578b = objInvoke == null ? 0 : 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f11578b < 0) {
            a();
        }
        return this.f11578b == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f11578b < 0) {
            a();
        }
        if (this.f11578b == 0) {
            com.google.gson.internal.a.b();
            return null;
        }
        Object obj = this.f11577a;
        obj.getClass();
        this.f11578b = -1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

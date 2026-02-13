package n7;

import java.util.Iterator;
import r7.q;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c implements Iterator, h7.a {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f11570a;

    /* renamed from: b, reason: collision with root package name */
    public int f11571b = -1;

    /* renamed from: c, reason: collision with root package name */
    public Object f11572c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f11573d;

    public c(d dVar) {
        this.f11573d = dVar;
        this.f11570a = new l((d) dVar.f11575b);
    }

    public final void a() {
        Object next;
        do {
            Iterator it = this.f11570a;
            if (!it.hasNext()) {
                this.f11571b = 0;
                return;
            }
            next = it.next();
        } while (((Boolean) ((q) this.f11573d.f11576c).invoke(next)).booleanValue());
        this.f11572c = next;
        this.f11571b = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f11571b == -1) {
            a();
        }
        return this.f11571b == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f11571b == -1) {
            a();
        }
        if (this.f11571b == 0) {
            com.google.gson.internal.a.b();
            return null;
        }
        Object obj = this.f11572c;
        this.f11572c = null;
        this.f11571b = -1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

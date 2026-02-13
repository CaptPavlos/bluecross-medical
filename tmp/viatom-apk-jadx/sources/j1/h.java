package j1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends q {

    /* renamed from: a, reason: collision with root package name */
    public boolean f9895a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9896b;

    public h(Object obj) {
        this.f9896b = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f9895a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f9895a) {
            com.google.gson.internal.a.b();
            return null;
        }
        this.f9895a = true;
        return this.f9896b;
    }
}

package p3;

import java.util.HashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f11878a = new HashMap();

    @Override // p3.b
    public final boolean a(String str) {
        return this.f11878a.containsKey(str);
    }

    public final void b(String str, m3.a aVar) {
        this.f11878a.put(str, aVar);
    }

    public final void c(b bVar) {
        HashMap map = this.f11878a;
        map.clear();
        map.putAll(bVar.getAll());
    }

    @Override // p3.b
    public final m3.b get(String str) {
        return (m3.a) this.f11878a.get(str);
    }

    @Override // p3.b
    public final HashMap getAll() {
        return new HashMap(this.f11878a);
    }
}

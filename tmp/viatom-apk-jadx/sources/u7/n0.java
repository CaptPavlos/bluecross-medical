package u7;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n0 extends v7.d {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f13032a = new AtomicReference(null);

    @Override // v7.d
    public final boolean a(v7.b bVar) {
        AtomicReference atomicReference = this.f13032a;
        if (atomicReference.get() != null) {
            return false;
        }
        atomicReference.set(i0.f13006b);
        return true;
    }

    @Override // v7.d
    public final w6.c[] b(v7.b bVar) {
        this.f13032a.set(null);
        return v7.c.f13177a;
    }
}

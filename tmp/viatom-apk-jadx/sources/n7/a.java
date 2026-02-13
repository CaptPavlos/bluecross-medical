package n7;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements f {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f11568a;

    public a(f fVar) {
        this.f11568a = new AtomicReference(fVar);
    }

    @Override // n7.f
    public final Iterator iterator() {
        f fVar = (f) this.f11568a.getAndSet(null);
        if (fVar != null) {
            return fVar.iterator();
        }
        androidx.window.layout.c.g("This sequence can be consumed only once.");
        return null;
    }
}

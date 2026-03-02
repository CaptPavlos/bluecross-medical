package androidx.lifecycle.viewmodel.internal;

import r7.a1;
import r7.t;
import r7.w;
import w6.h;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class CloseableCoroutineScope implements AutoCloseable, w {
    private final h coroutineContext;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CloseableCoroutineScope(w wVar) {
        this(wVar.getCoroutineContext());
        wVar.getClass();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        a1 a1Var = (a1) getCoroutineContext().get(t.f12437b);
        if (a1Var != null) {
            a1Var.a(null);
        }
    }

    @Override // r7.w
    public h getCoroutineContext() {
        return this.coroutineContext;
    }

    public CloseableCoroutineScope(h hVar) {
        hVar.getClass();
        this.coroutineContext = hVar;
    }
}

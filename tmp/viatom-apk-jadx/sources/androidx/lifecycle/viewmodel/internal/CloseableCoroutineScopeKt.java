package androidx.lifecycle.viewmodel.internal;

import r7.i0;
import r7.w;
import r7.y;
import w6.h;
import w6.i;
import w7.n;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class CloseableCoroutineScopeKt {
    public static final String VIEW_MODEL_SCOPE_KEY = "androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY";

    public static final CloseableCoroutineScope asCloseable(w wVar) {
        wVar.getClass();
        return new CloseableCoroutineScope(wVar);
    }

    public static final CloseableCoroutineScope createViewModelScope() {
        h hVar = i.f13523a;
        try {
            e eVar = i0.f12407a;
            hVar = n.f13548a.f12716c;
        } catch (IllegalStateException | s6.h unused) {
        }
        return new CloseableCoroutineScope(hVar.plus(y.c()));
    }
}

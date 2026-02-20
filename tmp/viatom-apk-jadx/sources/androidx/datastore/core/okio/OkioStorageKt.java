package androidx.datastore.core.okio;

import androidx.datastore.core.InterProcessCoordinator;
import androidx.datastore.core.InterProcessCoordinatorKt;
import t3.h;
import z8.z;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class OkioStorageKt {
    public static final InterProcessCoordinator createSingleProcessCoordinator(z zVar) {
        zVar.getClass();
        return InterProcessCoordinatorKt.createSingleProcessCoordinator(h.i(zVar.f14518a.r(), true).f14518a.r());
    }
}

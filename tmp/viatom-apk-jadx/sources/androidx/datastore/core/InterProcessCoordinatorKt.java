package androidx.datastore.core;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class InterProcessCoordinatorKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final InterProcessCoordinator createSingleProcessCoordinator(String str) {
        str.getClass();
        return new SingleProcessCoordinator(str);
    }
}

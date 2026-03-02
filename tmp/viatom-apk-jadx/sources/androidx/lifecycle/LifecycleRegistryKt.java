package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class LifecycleRegistryKt {
    public static final void checkLifecycleStateTransition(LifecycleOwner lifecycleOwner, Lifecycle.State state, Lifecycle.State state2) {
        state.getClass();
        state2.getClass();
        if (state == Lifecycle.State.INITIALIZED && state2 == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException(("State must be at least '" + Lifecycle.State.CREATED + "' to be moved to '" + state2 + "' in component " + lifecycleOwner).toString());
        }
        Lifecycle.State state3 = Lifecycle.State.DESTROYED;
        if (state != state3 || state == state2) {
            return;
        }
        throw new IllegalStateException(("State is '" + state3 + "' and cannot be moved to `" + state2 + "` in component " + lifecycleOwner).toString());
    }
}

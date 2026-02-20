package androidx.customview.poolingcontainer;

import java.util.ArrayList;
import t6.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class PoolingContainerListenerHolder {
    private final ArrayList<PoolingContainerListener> listeners = new ArrayList<>();

    public final void addListener(PoolingContainerListener poolingContainerListener) {
        poolingContainerListener.getClass();
        this.listeners.add(poolingContainerListener);
    }

    public final void onRelease() {
        for (int iP = m.P(this.listeners); -1 < iP; iP--) {
            this.listeners.get(iP).onRelease();
        }
    }

    public final void removeListener(PoolingContainerListener poolingContainerListener) {
        poolingContainerListener.getClass();
        this.listeners.remove(poolingContainerListener);
    }
}

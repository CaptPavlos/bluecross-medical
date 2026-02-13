package androidx.datastore.preferences.core;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class AtomicBoolean {
    private final java.util.concurrent.atomic.AtomicBoolean delegate;

    public AtomicBoolean(boolean z9) {
        this.delegate = new java.util.concurrent.atomic.AtomicBoolean(z9);
    }

    public final boolean get() {
        return this.delegate.get();
    }

    public final void set(boolean z9) {
        this.delegate.set(z9);
    }
}

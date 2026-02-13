package androidx.lifecycle;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class AtomicReference<V> {
    private final java.util.concurrent.atomic.AtomicReference<V> base;

    public AtomicReference(V v6) {
        this.base = new java.util.concurrent.atomic.AtomicReference<>(v6);
    }

    public final boolean compareAndSet(V v6, V v9) {
        java.util.concurrent.atomic.AtomicReference<V> atomicReference = this.base;
        while (!atomicReference.compareAndSet(v6, v9)) {
            if (atomicReference.get() != v6) {
                return false;
            }
        }
        return true;
    }

    public final V get() {
        return this.base.get();
    }
}

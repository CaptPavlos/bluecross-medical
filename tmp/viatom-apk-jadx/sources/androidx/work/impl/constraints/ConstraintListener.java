package androidx.work.impl.constraints;

import androidx.annotation.MainThread;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface ConstraintListener<T> {
    @MainThread
    void onConstraintChanged(T t);
}

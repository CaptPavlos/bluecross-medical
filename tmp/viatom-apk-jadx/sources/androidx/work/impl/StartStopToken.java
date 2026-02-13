package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class StartStopToken {
    private final WorkGenerationalId id;

    public StartStopToken(WorkGenerationalId workGenerationalId) {
        workGenerationalId.getClass();
        this.id = workGenerationalId;
    }

    public final WorkGenerationalId getId() {
        return this.id;
    }
}

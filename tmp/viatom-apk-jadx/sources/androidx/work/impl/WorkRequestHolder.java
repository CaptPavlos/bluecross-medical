package androidx.work.impl;

import androidx.annotation.RestrictTo;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import java.util.Set;
import java.util.UUID;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class WorkRequestHolder extends WorkRequest {
    public WorkRequestHolder(UUID uuid, WorkSpec workSpec, Set<String> set) {
        super(uuid, workSpec, set);
    }
}

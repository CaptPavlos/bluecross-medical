package androidx.work.multiprocess;

import androidx.annotation.RestrictTo;
import androidx.work.OneTimeWorkRequest;
import java.util.Collections;
import java.util.List;
import k1.b;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class RemoteWorkContinuation {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteWorkContinuation() {
    }

    public static RemoteWorkContinuation combine(List<RemoteWorkContinuation> list) {
        return list.get(0).combineInternal(list);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract RemoteWorkContinuation combineInternal(List<RemoteWorkContinuation> list);

    public abstract b enqueue();

    public final RemoteWorkContinuation then(OneTimeWorkRequest oneTimeWorkRequest) {
        return then(Collections.singletonList(oneTimeWorkRequest));
    }

    public abstract RemoteWorkContinuation then(List<OneTimeWorkRequest> list);
}

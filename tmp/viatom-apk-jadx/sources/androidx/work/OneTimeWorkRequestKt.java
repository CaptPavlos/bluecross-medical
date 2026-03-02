package androidx.work;

import androidx.annotation.NonNull;
import androidx.work.OneTimeWorkRequest;
import com.google.android.gms.internal.measurement.a4;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class OneTimeWorkRequestKt {
    public static final <W extends ListenableWorker> OneTimeWorkRequest.Builder OneTimeWorkRequestBuilder() {
        l.h();
        throw null;
    }

    public static final OneTimeWorkRequest.Builder setInputMerger(OneTimeWorkRequest.Builder builder, @NonNull m7.c cVar) {
        builder.getClass();
        cVar.getClass();
        return builder.setInputMerger(a4.q(cVar));
    }
}

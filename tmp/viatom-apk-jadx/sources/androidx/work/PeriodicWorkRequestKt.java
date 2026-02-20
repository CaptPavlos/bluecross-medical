package androidx.work;

import androidx.annotation.RequiresApi;
import androidx.work.PeriodicWorkRequest;
import j$.time.Duration;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class PeriodicWorkRequestKt {
    public static final <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(long j10, TimeUnit timeUnit, long j11, TimeUnit timeUnit2) {
        timeUnit.getClass();
        timeUnit2.getClass();
        l.h();
        throw null;
    }

    public static final <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(long j10, TimeUnit timeUnit) {
        timeUnit.getClass();
        l.h();
        throw null;
    }

    @RequiresApi(26)
    public static final <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(Duration duration) {
        duration.getClass();
        l.h();
        throw null;
    }

    @RequiresApi(26)
    public static final <W extends ListenableWorker> PeriodicWorkRequest.Builder PeriodicWorkRequestBuilder(Duration duration, Duration duration2) {
        duration.getClass();
        duration2.getClass();
        l.h();
        throw null;
    }
}

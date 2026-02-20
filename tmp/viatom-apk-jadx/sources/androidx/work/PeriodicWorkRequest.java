package androidx.work;

import android.annotation.SuppressLint;
import androidx.annotation.RequiresApi;
import androidx.work.WorkRequest;
import androidx.work.impl.utils.DurationApi26Impl;
import com.google.android.gms.internal.measurement.a4;
import j$.time.Duration;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class PeriodicWorkRequest extends WorkRequest {
    public static final Companion Companion = new Companion(null);

    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_PERIODIC_FLEX_MILLIS = 300000;

    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_PERIODIC_INTERVAL_MILLIS = 900000;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PeriodicWorkRequest(Builder builder) {
        super(builder.getId$work_runtime_release(), builder.getWorkSpec$work_runtime_release(), builder.getTags$work_runtime_release());
        builder.getClass();
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Builder extends WorkRequest.Builder<Builder, PeriodicWorkRequest> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(m7.c cVar, long j10, TimeUnit timeUnit, long j11, TimeUnit timeUnit2) {
            super(a4.q(cVar));
            cVar.getClass();
            timeUnit.getClass();
            timeUnit2.getClass();
            getWorkSpec$work_runtime_release().setPeriodic(timeUnit.toMillis(j10), timeUnit2.toMillis(j11));
        }

        @Override // androidx.work.WorkRequest.Builder
        public PeriodicWorkRequest buildInternal$work_runtime_release() {
            if (getBackoffCriteriaSet$work_runtime_release() && getWorkSpec$work_runtime_release().constraints.requiresDeviceIdle()) {
                com.google.gson.internal.a.n("Cannot set backoff criteria on an idle mode job");
                return null;
            }
            if (!getWorkSpec$work_runtime_release().expedited) {
                return new PeriodicWorkRequest(this);
            }
            com.google.gson.internal.a.n("PeriodicWorkRequests cannot be expedited");
            return null;
        }

        public final Builder clearNextScheduleTimeOverride() {
            getWorkSpec$work_runtime_release().setNextScheduleTimeOverride(Long.MAX_VALUE);
            getWorkSpec$work_runtime_release().setNextScheduleTimeOverrideGeneration(1);
            return this;
        }

        public final Builder setNextScheduleTimeOverride(long j10) {
            if (j10 == Long.MAX_VALUE) {
                com.google.gson.internal.a.n("Cannot set Long.MAX_VALUE as the schedule override time");
                return null;
            }
            getWorkSpec$work_runtime_release().setNextScheduleTimeOverride(j10);
            getWorkSpec$work_runtime_release().setNextScheduleTimeOverrideGeneration(1);
            return this;
        }

        @Override // androidx.work.WorkRequest.Builder
        public Builder getThisObject$work_runtime_release() {
            return this;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(m7.c cVar, long j10, TimeUnit timeUnit) {
            super(a4.q(cVar));
            cVar.getClass();
            timeUnit.getClass();
            getWorkSpec$work_runtime_release().setPeriodic(timeUnit.toMillis(j10));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @RequiresApi(26)
        public Builder(Class<? extends ListenableWorker> cls, Duration duration) {
            super(cls);
            cls.getClass();
            duration.getClass();
            getWorkSpec$work_runtime_release().setPeriodic(DurationApi26Impl.toMillisCompat(duration));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @RequiresApi(26)
        public Builder(m7.c cVar, Duration duration) {
            super(a4.q(cVar));
            cVar.getClass();
            duration.getClass();
            getWorkSpec$work_runtime_release().setPeriodic(DurationApi26Impl.toMillisCompat(duration));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(Class<? extends ListenableWorker> cls, long j10, TimeUnit timeUnit, long j11, TimeUnit timeUnit2) {
            super(cls);
            cls.getClass();
            timeUnit.getClass();
            timeUnit2.getClass();
            getWorkSpec$work_runtime_release().setPeriodic(timeUnit.toMillis(j10), timeUnit2.toMillis(j11));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(Class<? extends ListenableWorker> cls, long j10, TimeUnit timeUnit) {
            super(cls);
            cls.getClass();
            timeUnit.getClass();
            getWorkSpec$work_runtime_release().setPeriodic(timeUnit.toMillis(j10));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @RequiresApi(26)
        public Builder(Class<? extends ListenableWorker> cls, Duration duration, Duration duration2) {
            super(cls);
            cls.getClass();
            duration.getClass();
            duration2.getClass();
            getWorkSpec$work_runtime_release().setPeriodic(DurationApi26Impl.toMillisCompat(duration), DurationApi26Impl.toMillisCompat(duration2));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @RequiresApi(26)
        public Builder(m7.c cVar, Duration duration, Duration duration2) {
            super(a4.q(cVar));
            cVar.getClass();
            duration.getClass();
            duration2.getClass();
            getWorkSpec$work_runtime_release().setPeriodic(DurationApi26Impl.toMillisCompat(duration), DurationApi26Impl.toMillisCompat(duration2));
        }
    }
}

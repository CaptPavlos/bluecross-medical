package androidx.work;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.DurationApi26Impl;
import j$.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g;
import o7.m;
import t6.a0;
import t6.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class WorkRequest {
    public static final Companion Companion = new Companion(null);
    public static final long DEFAULT_BACKOFF_DELAY_MILLIS = 30000;

    @SuppressLint({"MinMaxConstant"})
    public static final long MAX_BACKOFF_MILLIS = 18000000;
    private static final int MAX_TRACE_SPAN_LENGTH = 127;

    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_BACKOFF_MILLIS = 10000;
    private final UUID id;
    private final Set<String> tags;
    private final WorkSpec workSpec;

    public WorkRequest(UUID uuid, WorkSpec workSpec, Set<String> set) {
        uuid.getClass();
        workSpec.getClass();
        set.getClass();
        this.id = uuid;
        this.workSpec = workSpec;
        this.tags = set;
    }

    public UUID getId() {
        return this.id;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final String getStringId() {
        String string = getId().toString();
        string.getClass();
        return string;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Set<String> getTags() {
        return this.tags;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final WorkSpec getWorkSpec() {
        return this.workSpec;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String deriveTraceTagFromClassName(String str) {
            List listS0 = m.s0(str, new String[]{"."});
            String str2 = listS0.size() == 1 ? (String) listS0.get(0) : (String) l.i0(listS0);
            return str2.length() <= WorkRequest.MAX_TRACE_SPAN_LENGTH ? str2 : m.u0(str2);
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class Builder<B extends Builder<B, ?>, W extends WorkRequest> {
        private boolean backoffCriteriaSet;
        private UUID id;
        private final Set<String> tags;
        private WorkSpec workSpec;
        private final Class<? extends ListenableWorker> workerClass;

        public Builder(Class<? extends ListenableWorker> cls) {
            cls.getClass();
            this.workerClass = cls;
            UUID uuidRandomUUID = UUID.randomUUID();
            uuidRandomUUID.getClass();
            this.id = uuidRandomUUID;
            String string = this.id.toString();
            string.getClass();
            this.workSpec = new WorkSpec(string, cls.getName());
            String[] strArr = {cls.getName()};
            LinkedHashSet linkedHashSet = new LinkedHashSet(a0.h0(1));
            linkedHashSet.add(strArr[0]);
            this.tags = linkedHashSet;
        }

        public final B addTag(String str) {
            str.getClass();
            this.tags.add(str);
            return (B) getThisObject$work_runtime_release();
        }

        public final W build() {
            W w4 = (W) buildInternal$work_runtime_release();
            Constraints constraints = this.workSpec.constraints;
            boolean z9 = (Build.VERSION.SDK_INT >= 24 && constraints.hasContentUriTriggers()) || constraints.requiresBatteryNotLow() || constraints.requiresCharging() || constraints.requiresDeviceIdle();
            WorkSpec workSpec = this.workSpec;
            if (workSpec.expedited) {
                if (z9) {
                    com.google.gson.internal.a.n("Expedited jobs only support network and storage constraints");
                    return null;
                }
                if (workSpec.initialDelay > 0) {
                    com.google.gson.internal.a.n("Expedited jobs cannot be delayed");
                    return null;
                }
            }
            String traceTag = workSpec.getTraceTag();
            if (traceTag == null) {
                WorkSpec workSpec2 = this.workSpec;
                workSpec2.setTraceTag(WorkRequest.Companion.deriveTraceTagFromClassName(workSpec2.workerClassName));
            } else if (traceTag.length() > WorkRequest.MAX_TRACE_SPAN_LENGTH) {
                this.workSpec.setTraceTag(m.u0(traceTag));
            }
            UUID uuidRandomUUID = UUID.randomUUID();
            uuidRandomUUID.getClass();
            setId(uuidRandomUUID);
            return w4;
        }

        public abstract W buildInternal$work_runtime_release();

        public final boolean getBackoffCriteriaSet$work_runtime_release() {
            return this.backoffCriteriaSet;
        }

        public final UUID getId$work_runtime_release() {
            return this.id;
        }

        public final Set<String> getTags$work_runtime_release() {
            return this.tags;
        }

        public abstract B getThisObject$work_runtime_release();

        public final WorkSpec getWorkSpec$work_runtime_release() {
            return this.workSpec;
        }

        public final Class<? extends ListenableWorker> getWorkerClass$work_runtime_release() {
            return this.workerClass;
        }

        public final B keepResultsForAtLeast(long j10, TimeUnit timeUnit) {
            timeUnit.getClass();
            this.workSpec.minimumRetentionDuration = timeUnit.toMillis(j10);
            return (B) getThisObject$work_runtime_release();
        }

        public final B setBackoffCriteria(BackoffPolicy backoffPolicy, long j10, TimeUnit timeUnit) {
            backoffPolicy.getClass();
            timeUnit.getClass();
            this.backoffCriteriaSet = true;
            WorkSpec workSpec = this.workSpec;
            workSpec.backoffPolicy = backoffPolicy;
            workSpec.setBackoffDelayDuration(timeUnit.toMillis(j10));
            return (B) getThisObject$work_runtime_release();
        }

        public final void setBackoffCriteriaSet$work_runtime_release(boolean z9) {
            this.backoffCriteriaSet = z9;
        }

        @ExperimentalWorkRequestBuilderApi
        public final B setBackoffForSystemInterruptions() {
            this.workSpec.setBackOffOnSystemInterruptions(Boolean.TRUE);
            return (B) getThisObject$work_runtime_release();
        }

        public final B setConstraints(Constraints constraints) {
            constraints.getClass();
            this.workSpec.constraints = constraints;
            return (B) getThisObject$work_runtime_release();
        }

        @SuppressLint({"MissingGetterMatchingBuilder"})
        public B setExpedited(OutOfQuotaPolicy outOfQuotaPolicy) {
            outOfQuotaPolicy.getClass();
            WorkSpec workSpec = this.workSpec;
            workSpec.expedited = true;
            workSpec.outOfQuotaPolicy = outOfQuotaPolicy;
            return (B) getThisObject$work_runtime_release();
        }

        public final B setId(UUID uuid) {
            uuid.getClass();
            this.id = uuid;
            String string = uuid.toString();
            string.getClass();
            this.workSpec = new WorkSpec(string, this.workSpec);
            return (B) getThisObject$work_runtime_release();
        }

        public final void setId$work_runtime_release(UUID uuid) {
            uuid.getClass();
            this.id = uuid;
        }

        public B setInitialDelay(long j10, TimeUnit timeUnit) {
            timeUnit.getClass();
            this.workSpec.initialDelay = timeUnit.toMillis(j10);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.workSpec.initialDelay) {
                return (B) getThisObject$work_runtime_release();
            }
            com.google.gson.internal.a.n("The given initial delay is too large and will cause an overflow!");
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        public final B setInitialRunAttemptCount(int i10) {
            this.workSpec.runAttemptCount = i10;
            return (B) getThisObject$work_runtime_release();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        public final B setInitialState(WorkInfo.State state) {
            state.getClass();
            this.workSpec.state = state;
            return (B) getThisObject$work_runtime_release();
        }

        public final B setInputData(Data data) {
            data.getClass();
            this.workSpec.input = data;
            return (B) getThisObject$work_runtime_release();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        public final B setLastEnqueueTime(long j10, TimeUnit timeUnit) {
            timeUnit.getClass();
            this.workSpec.lastEnqueueTime = timeUnit.toMillis(j10);
            return (B) getThisObject$work_runtime_release();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        public final B setScheduleRequestedAt(long j10, TimeUnit timeUnit) {
            timeUnit.getClass();
            this.workSpec.scheduleRequestedAt = timeUnit.toMillis(j10);
            return (B) getThisObject$work_runtime_release();
        }

        public final B setTraceTag(String str) {
            str.getClass();
            this.workSpec.setTraceTag(str);
            return (B) getThisObject$work_runtime_release();
        }

        public final void setWorkSpec$work_runtime_release(WorkSpec workSpec) {
            workSpec.getClass();
            this.workSpec = workSpec;
        }

        @RequiresApi(26)
        public final B keepResultsForAtLeast(Duration duration) {
            duration.getClass();
            this.workSpec.minimumRetentionDuration = DurationApi26Impl.toMillisCompat(duration);
            return (B) getThisObject$work_runtime_release();
        }

        @RequiresApi(26)
        public final B setBackoffCriteria(BackoffPolicy backoffPolicy, Duration duration) {
            backoffPolicy.getClass();
            duration.getClass();
            this.backoffCriteriaSet = true;
            WorkSpec workSpec = this.workSpec;
            workSpec.backoffPolicy = backoffPolicy;
            workSpec.setBackoffDelayDuration(DurationApi26Impl.toMillisCompat(duration));
            return (B) getThisObject$work_runtime_release();
        }

        @RequiresApi(26)
        public B setInitialDelay(Duration duration) {
            duration.getClass();
            this.workSpec.initialDelay = DurationApi26Impl.toMillisCompat(duration);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.workSpec.initialDelay) {
                return (B) getThisObject$work_runtime_release();
            }
            com.google.gson.internal.a.n("The given initial delay is too large and will cause an overflow!");
            return null;
        }
    }
}

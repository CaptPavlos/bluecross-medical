package androidx.work;

import android.annotation.SuppressLint;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Ignore;
import androidx.work.impl.utils.DurationApi26Impl;
import androidx.work.impl.utils.NetworkRequest30;
import androidx.work.impl.utils.NetworkRequestCompat;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import j$.time.Duration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import t6.v;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class Constraints {
    public static final Companion Companion = new Companion(null);
    public static final Constraints NONE = new Constraints(null, false, false, false, 15, null);

    @ColumnInfo(name = "trigger_max_content_delay")
    private final long contentTriggerMaxDelayMillis;

    @ColumnInfo(name = "trigger_content_update_delay")
    private final long contentTriggerUpdateDelayMillis;

    @ColumnInfo(name = "content_uri_triggers")
    private final Set<ContentUriTrigger> contentUriTriggers;

    @ColumnInfo(defaultValue = "x''", name = "required_network_request")
    private final NetworkRequestCompat requiredNetworkRequestCompat;

    @ColumnInfo(name = "required_network_type")
    private final NetworkType requiredNetworkType;

    @ColumnInfo(name = "requires_battery_not_low")
    private final boolean requiresBatteryNotLow;

    @ColumnInfo(name = "requires_charging")
    private final boolean requiresCharging;

    @ColumnInfo(name = "requires_device_idle")
    private final boolean requiresDeviceIdle;

    @ColumnInfo(name = "requires_storage_not_low")
    private final boolean requiresStorageNotLow;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class ContentUriTrigger {
        private final boolean isTriggeredForDescendants;
        private final Uri uri;

        public ContentUriTrigger(Uri uri, boolean z9) {
            uri.getClass();
            this.uri = uri;
            this.isTriggeredForDescendants = z9;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!ContentUriTrigger.class.equals(obj != null ? obj.getClass() : null)) {
                return false;
            }
            obj.getClass();
            ContentUriTrigger contentUriTrigger = (ContentUriTrigger) obj;
            return l.a(this.uri, contentUriTrigger.uri) && this.isTriggeredForDescendants == contentUriTrigger.isTriggeredForDescendants;
        }

        public final Uri getUri() {
            return this.uri;
        }

        public int hashCode() {
            return (this.uri.hashCode() * 31) + (this.isTriggeredForDescendants ? 1231 : 1237);
        }

        public final boolean isTriggeredForDescendants() {
            return this.isTriggeredForDescendants;
        }
    }

    public /* synthetic */ Constraints(NetworkRequestCompat networkRequestCompat, NetworkType networkType, boolean z9, boolean z10, boolean z11, boolean z12, long j10, long j11, Set set, int i10, g gVar) {
        this(networkRequestCompat, (i10 & 2) != 0 ? NetworkType.NOT_REQUIRED : networkType, (i10 & 4) != 0 ? false : z9, (i10 & 8) != 0 ? false : z10, (i10 & 16) != 0 ? false : z11, (i10 & 32) == 0 ? z12 : false, (i10 & 64) != 0 ? -1L : j10, (i10 & 128) == 0 ? j11 : -1L, (i10 & 256) != 0 ? v.f12810a : set);
    }

    @SuppressLint({"NewApi"})
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Constraints.class.equals(obj.getClass())) {
            return false;
        }
        Constraints constraints = (Constraints) obj;
        if (this.requiresCharging == constraints.requiresCharging && this.requiresDeviceIdle == constraints.requiresDeviceIdle && this.requiresBatteryNotLow == constraints.requiresBatteryNotLow && this.requiresStorageNotLow == constraints.requiresStorageNotLow && this.contentTriggerUpdateDelayMillis == constraints.contentTriggerUpdateDelayMillis && this.contentTriggerMaxDelayMillis == constraints.contentTriggerMaxDelayMillis && l.a(getRequiredNetworkRequest(), constraints.getRequiredNetworkRequest()) && this.requiredNetworkType == constraints.requiredNetworkType) {
            return l.a(this.contentUriTriggers, constraints.contentUriTriggers);
        }
        return false;
    }

    @RequiresApi(24)
    public final long getContentTriggerMaxDelayMillis() {
        return this.contentTriggerMaxDelayMillis;
    }

    @RequiresApi(24)
    public final long getContentTriggerUpdateDelayMillis() {
        return this.contentTriggerUpdateDelayMillis;
    }

    @RequiresApi(24)
    public final Set<ContentUriTrigger> getContentUriTriggers() {
        return this.contentUriTriggers;
    }

    public final NetworkRequest getRequiredNetworkRequest() {
        return this.requiredNetworkRequestCompat.getNetworkRequest();
    }

    public final NetworkRequestCompat getRequiredNetworkRequestCompat$work_runtime_release() {
        return this.requiredNetworkRequestCompat;
    }

    public final NetworkType getRequiredNetworkType() {
        return this.requiredNetworkType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean hasContentUriTriggers() {
        return Build.VERSION.SDK_INT < 24 || !this.contentUriTriggers.isEmpty();
    }

    @SuppressLint({"NewApi"})
    public int hashCode() {
        int iHashCode = ((((((((this.requiredNetworkType.hashCode() * 31) + (this.requiresCharging ? 1 : 0)) * 31) + (this.requiresDeviceIdle ? 1 : 0)) * 31) + (this.requiresBatteryNotLow ? 1 : 0)) * 31) + (this.requiresStorageNotLow ? 1 : 0)) * 31;
        long j10 = this.contentTriggerUpdateDelayMillis;
        int i10 = (iHashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.contentTriggerMaxDelayMillis;
        int iHashCode2 = (this.contentUriTriggers.hashCode() + ((i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31)) * 31;
        NetworkRequest requiredNetworkRequest = getRequiredNetworkRequest();
        return iHashCode2 + (requiredNetworkRequest != null ? requiredNetworkRequest.hashCode() : 0);
    }

    public final boolean requiresBatteryNotLow() {
        return this.requiresBatteryNotLow;
    }

    public final boolean requiresCharging() {
        return this.requiresCharging;
    }

    public final boolean requiresDeviceIdle() {
        return this.requiresDeviceIdle;
    }

    public final boolean requiresStorageNotLow() {
        return this.requiresStorageNotLow;
    }

    @SuppressLint({"NewApi"})
    public String toString() {
        return "Constraints{requiredNetworkType=" + this.requiredNetworkType + ", requiresCharging=" + this.requiresCharging + ", requiresDeviceIdle=" + this.requiresDeviceIdle + ", requiresBatteryNotLow=" + this.requiresBatteryNotLow + ", requiresStorageNotLow=" + this.requiresStorageNotLow + ", contentTriggerUpdateDelayMillis=" + this.contentTriggerUpdateDelayMillis + ", contentTriggerMaxDelayMillis=" + this.contentTriggerMaxDelayMillis + ", contentUriTriggers=" + this.contentUriTriggers + ", }";
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
    public static final class Builder {
        private Set<ContentUriTrigger> contentUriTriggers;
        private NetworkRequestCompat requiredNetworkRequest;
        private NetworkType requiredNetworkType;
        private boolean requiresBatteryNotLow;
        private boolean requiresCharging;
        private boolean requiresDeviceIdle;
        private boolean requiresStorageNotLow;
        private long triggerContentMaxDelay;
        private long triggerContentUpdateDelay;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(Constraints constraints) {
            constraints.getClass();
            this.requiredNetworkRequest = new NetworkRequestCompat(null, 1, null);
            this.requiredNetworkType = NetworkType.NOT_REQUIRED;
            this.triggerContentUpdateDelay = -1L;
            this.triggerContentMaxDelay = -1L;
            this.contentUriTriggers = new LinkedHashSet();
            this.requiresCharging = constraints.requiresCharging();
            this.requiresDeviceIdle = constraints.requiresDeviceIdle();
            this.requiredNetworkType = constraints.getRequiredNetworkType();
            this.requiresBatteryNotLow = constraints.requiresBatteryNotLow();
            this.requiresStorageNotLow = constraints.requiresStorageNotLow();
            if (Build.VERSION.SDK_INT >= 24) {
                this.triggerContentUpdateDelay = constraints.getContentTriggerUpdateDelayMillis();
                this.triggerContentMaxDelay = constraints.getContentTriggerMaxDelayMillis();
                this.contentUriTriggers = t6.l.t0(constraints.getContentUriTriggers());
            }
        }

        @RequiresApi(24)
        public final Builder addContentUriTrigger(Uri uri, boolean z9) {
            uri.getClass();
            this.contentUriTriggers.add(new ContentUriTrigger(uri, z9));
            return this;
        }

        public final Constraints build() {
            Set setU0;
            long j10;
            long j11;
            if (Build.VERSION.SDK_INT >= 24) {
                setU0 = t6.l.u0(this.contentUriTriggers);
                j10 = this.triggerContentUpdateDelay;
                j11 = this.triggerContentMaxDelay;
            } else {
                setU0 = v.f12810a;
                j10 = -1;
                j11 = -1;
            }
            return new Constraints(this.requiredNetworkRequest, this.requiredNetworkType, this.requiresCharging, this.requiresDeviceIdle, this.requiresBatteryNotLow, this.requiresStorageNotLow, j10, j11, setU0);
        }

        public final Builder setRequiredNetworkRequest(NetworkRequest networkRequest, NetworkType networkType) {
            networkRequest.getClass();
            networkType.getClass();
            int i10 = Build.VERSION.SDK_INT;
            if (i10 < 28) {
                this.requiredNetworkType = networkType;
                return this;
            }
            if (i10 >= 31 && NetworkRequest30.INSTANCE.getNetworkSpecifier(networkRequest) != null) {
                com.google.gson.internal.a.n("NetworkRequests with NetworkSpecifiers set aren't supported.");
                return null;
            }
            this.requiredNetworkRequest = new NetworkRequestCompat(networkRequest);
            this.requiredNetworkType = NetworkType.NOT_REQUIRED;
            return this;
        }

        public final Builder setRequiredNetworkType(NetworkType networkType) {
            networkType.getClass();
            this.requiredNetworkType = networkType;
            this.requiredNetworkRequest = new NetworkRequestCompat(null, 1, null);
            return this;
        }

        public final Builder setRequiresBatteryNotLow(boolean z9) {
            this.requiresBatteryNotLow = z9;
            return this;
        }

        public final Builder setRequiresCharging(boolean z9) {
            this.requiresCharging = z9;
            return this;
        }

        public final Builder setRequiresDeviceIdle(boolean z9) {
            this.requiresDeviceIdle = z9;
            return this;
        }

        public final Builder setRequiresStorageNotLow(boolean z9) {
            this.requiresStorageNotLow = z9;
            return this;
        }

        @RequiresApi(24)
        public final Builder setTriggerContentMaxDelay(long j10, TimeUnit timeUnit) {
            timeUnit.getClass();
            this.triggerContentMaxDelay = timeUnit.toMillis(j10);
            return this;
        }

        @RequiresApi(24)
        public final Builder setTriggerContentUpdateDelay(long j10, TimeUnit timeUnit) {
            timeUnit.getClass();
            this.triggerContentUpdateDelay = timeUnit.toMillis(j10);
            return this;
        }

        @RequiresApi(26)
        public final Builder setTriggerContentMaxDelay(Duration duration) {
            duration.getClass();
            this.triggerContentMaxDelay = DurationApi26Impl.toMillisCompat(duration);
            return this;
        }

        @RequiresApi(26)
        public final Builder setTriggerContentUpdateDelay(Duration duration) {
            duration.getClass();
            this.triggerContentUpdateDelay = DurationApi26Impl.toMillisCompat(duration);
            return this;
        }

        public Builder() {
            this.requiredNetworkRequest = new NetworkRequestCompat(null, 1, null);
            this.requiredNetworkType = NetworkType.NOT_REQUIRED;
            this.triggerContentUpdateDelay = -1L;
            this.triggerContentMaxDelay = -1L;
            this.contentUriTriggers = new LinkedHashSet();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"NewApi"})
    @Ignore
    public Constraints(NetworkType networkType, boolean z9, boolean z10, boolean z11) {
        this(networkType, z9, false, z10, z11);
        networkType.getClass();
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ Constraints(androidx.work.NetworkType r2, boolean r3, boolean r4, boolean r5, boolean r6, int r7, kotlin.jvm.internal.g r8) {
        /*
            r1 = this;
            r8 = r7 & 1
            if (r8 == 0) goto L6
            androidx.work.NetworkType r2 = androidx.work.NetworkType.NOT_REQUIRED
        L6:
            r8 = r7 & 2
            r0 = 0
            if (r8 == 0) goto Lc
            r3 = r0
        Lc:
            r8 = r7 & 4
            if (r8 == 0) goto L11
            r4 = r0
        L11:
            r8 = r7 & 8
            if (r8 == 0) goto L16
            r5 = r0
        L16:
            r7 = r7 & 16
            if (r7 == 0) goto L21
            r8 = r0
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L27
        L21:
            r8 = r6
            r7 = r5
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L27:
            r3.<init>(r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Constraints.<init>(androidx.work.NetworkType, boolean, boolean, boolean, boolean, int, kotlin.jvm.internal.g):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Ignore
    public Constraints(NetworkType networkType, boolean z9, boolean z10, boolean z11, boolean z12) {
        this(networkType, z9, z10, z11, z12, -1L, 0L, null, PsExtractor.AUDIO_STREAM, null);
        networkType.getClass();
    }

    public /* synthetic */ Constraints(NetworkType networkType, boolean z9, boolean z10, boolean z11, boolean z12, long j10, long j11, Set set, int i10, g gVar) {
        this((i10 & 1) != 0 ? NetworkType.NOT_REQUIRED : networkType, (i10 & 2) != 0 ? false : z9, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? false : z11, (i10 & 16) != 0 ? false : z12, (i10 & 32) != 0 ? -1L : j10, (i10 & 64) != 0 ? -1L : j11, (i10 & 128) != 0 ? v.f12810a : set);
    }

    @RequiresApi(24)
    @Ignore
    public Constraints(NetworkType networkType, boolean z9, boolean z10, boolean z11, boolean z12, long j10, long j11, Set<ContentUriTrigger> set) {
        networkType.getClass();
        set.getClass();
        this.requiredNetworkRequestCompat = new NetworkRequestCompat(null, 1, null);
        this.requiredNetworkType = networkType;
        this.requiresCharging = z9;
        this.requiresDeviceIdle = z10;
        this.requiresBatteryNotLow = z11;
        this.requiresStorageNotLow = z12;
        this.contentTriggerUpdateDelayMillis = j10;
        this.contentTriggerMaxDelayMillis = j11;
        this.contentUriTriggers = set;
    }

    public /* synthetic */ Constraints(NetworkType networkType, boolean z9, boolean z10, boolean z11, int i10, g gVar) {
        this((i10 & 1) != 0 ? NetworkType.NOT_REQUIRED : networkType, (i10 & 2) != 0 ? false : z9, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? false : z11);
    }

    public Constraints(NetworkRequestCompat networkRequestCompat, NetworkType networkType, boolean z9, boolean z10, boolean z11, boolean z12, long j10, long j11, Set<ContentUriTrigger> set) {
        networkRequestCompat.getClass();
        networkType.getClass();
        set.getClass();
        this.requiredNetworkRequestCompat = networkRequestCompat;
        this.requiredNetworkType = networkType;
        this.requiresCharging = z9;
        this.requiresDeviceIdle = z10;
        this.requiresBatteryNotLow = z11;
        this.requiresStorageNotLow = z12;
        this.contentTriggerUpdateDelayMillis = j10;
        this.contentTriggerMaxDelayMillis = j11;
        this.contentUriTriggers = set;
    }

    @SuppressLint({"NewApi"})
    public Constraints(Constraints constraints) {
        constraints.getClass();
        this.requiresCharging = constraints.requiresCharging;
        this.requiresDeviceIdle = constraints.requiresDeviceIdle;
        this.requiredNetworkRequestCompat = constraints.requiredNetworkRequestCompat;
        this.requiredNetworkType = constraints.requiredNetworkType;
        this.requiresBatteryNotLow = constraints.requiresBatteryNotLow;
        this.requiresStorageNotLow = constraints.requiresStorageNotLow;
        this.contentUriTriggers = constraints.contentUriTriggers;
        this.contentTriggerUpdateDelayMillis = constraints.contentTriggerUpdateDelayMillis;
        this.contentTriggerMaxDelayMillis = constraints.contentTriggerMaxDelayMillis;
    }
}

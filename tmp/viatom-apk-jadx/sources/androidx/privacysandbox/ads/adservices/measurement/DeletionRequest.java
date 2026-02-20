package androidx.privacysandbox.ads.adservices.measurement;

import android.adservices.measurement.DeletionRequest;
import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import j$.time.Instant;
import j$.time.TimeConversions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import t6.t;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresApi(26)
/* loaded from: classes.dex */
public final class DeletionRequest {
    public static final Companion Companion = new Companion(null);
    public static final int DELETION_MODE_ALL = 0;
    public static final int DELETION_MODE_EXCLUDE_INTERNAL_DATA = 1;
    public static final int MATCH_BEHAVIOR_DELETE = 0;
    public static final int MATCH_BEHAVIOR_PRESERVE = 1;
    private final int deletionMode;
    private final List<Uri> domainUris;
    private final Instant end;
    private final int matchBehavior;
    private final List<Uri> originUris;
    private final Instant start;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresApi(26)
    public static final class Builder {
        private final int deletionMode;
        private List<? extends Uri> domainUris;
        private Instant end;
        private final int matchBehavior;
        private List<? extends Uri> originUris;
        private Instant start;

        public Builder(int i10, int i11) {
            this.deletionMode = i10;
            this.matchBehavior = i11;
            Instant instant = Instant.MIN;
            instant.getClass();
            this.start = instant;
            Instant instant2 = Instant.MAX;
            instant2.getClass();
            this.end = instant2;
            t tVar = t.f12808a;
            this.domainUris = tVar;
            this.originUris = tVar;
        }

        public final DeletionRequest build() {
            return new DeletionRequest(this.deletionMode, this.matchBehavior, this.start, this.end, this.domainUris, this.originUris);
        }

        public final Builder setDomainUris(List<? extends Uri> list) {
            list.getClass();
            this.domainUris = list;
            return this;
        }

        public final Builder setEnd(Instant instant) {
            instant.getClass();
            this.end = instant;
            return this;
        }

        public final Builder setOriginUris(List<? extends Uri> list) {
            list.getClass();
            this.originUris = list;
            return this;
        }

        public final Builder setStart(Instant instant) {
            instant.getClass();
            this.start = instant;
            return this;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DeletionRequest(int i10, int i11, Instant instant, Instant instant2, List list, List list2, int i12, g gVar) {
        if ((i12 & 4) != 0) {
            instant = Instant.MIN;
            instant.getClass();
        }
        Instant instant3 = instant;
        if ((i12 & 8) != 0) {
            instant2 = Instant.MAX;
            instant2.getClass();
        }
        Instant instant4 = instant2;
        int i13 = i12 & 16;
        t tVar = t.f12808a;
        this(i10, i11, instant3, instant4, i13 != 0 ? tVar : list, (i12 & 32) != 0 ? tVar : list2);
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final android.adservices.measurement.DeletionRequest convertToAdServices$ads_adservices_release() {
        android.adservices.measurement.DeletionRequest deletionRequestBuild = new DeletionRequest.Builder().setDeletionMode(this.deletionMode).setMatchBehavior(this.matchBehavior).setStart(TimeConversions.convert(this.start)).setEnd(TimeConversions.convert(this.end)).setDomainUris(this.domainUris).setOriginUris(this.originUris).build();
        deletionRequestBuild.getClass();
        return deletionRequestBuild;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeletionRequest)) {
            return false;
        }
        DeletionRequest deletionRequest = (DeletionRequest) obj;
        return this.deletionMode == deletionRequest.deletionMode && new HashSet(this.domainUris).equals(new HashSet(deletionRequest.domainUris)) && new HashSet(this.originUris).equals(new HashSet(deletionRequest.originUris)) && l.a(this.start, deletionRequest.start) && l.a(this.end, deletionRequest.end) && this.matchBehavior == deletionRequest.matchBehavior;
    }

    public final int getDeletionMode() {
        return this.deletionMode;
    }

    public final List<Uri> getDomainUris() {
        return this.domainUris;
    }

    public final Instant getEnd() {
        return this.end;
    }

    public final int getMatchBehavior() {
        return this.matchBehavior;
    }

    public final List<Uri> getOriginUris() {
        return this.originUris;
    }

    public final Instant getStart() {
        return this.start;
    }

    public int hashCode() {
        return ((this.end.hashCode() + ((this.start.hashCode() + ((this.originUris.hashCode() + ((this.domainUris.hashCode() + (this.deletionMode * 31)) * 31)) * 31)) * 31)) * 31) + this.matchBehavior;
    }

    public String toString() {
        return "DeletionRequest { DeletionMode=" + (this.deletionMode == 0 ? "DELETION_MODE_ALL" : "DELETION_MODE_EXCLUDE_INTERNAL_DATA") + ", MatchBehavior=" + (this.matchBehavior == 0 ? "MATCH_BEHAVIOR_DELETE" : "MATCH_BEHAVIOR_PRESERVE") + ", Start=" + this.start + ", End=" + this.end + ", DomainUris=" + this.domainUris + ", OriginUris=" + this.originUris + " }";
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public @interface DeletionMode {
        }

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public @interface MatchBehavior {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeletionRequest(int i10, int i11, Instant instant, Instant instant2, List<? extends Uri> list, List<? extends Uri> list2) {
        instant.getClass();
        instant2.getClass();
        list.getClass();
        list2.getClass();
        this.deletionMode = i10;
        this.matchBehavior = i11;
        this.start = instant;
        this.end = instant2;
        this.domainUris = list;
        this.originUris = list2;
    }
}

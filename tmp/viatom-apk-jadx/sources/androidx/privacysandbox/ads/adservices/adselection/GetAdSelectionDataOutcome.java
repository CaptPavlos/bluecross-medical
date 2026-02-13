package androidx.privacysandbox.ads.adservices.adselection;

import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.Arrays;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@ExperimentalFeatures.Ext10OptIn
/* loaded from: classes.dex */
public final class GetAdSelectionDataOutcome {
    private final byte[] adSelectionData;
    private final long adSelectionId;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public GetAdSelectionDataOutcome(android.adservices.adselection.GetAdSelectionDataOutcome getAdSelectionDataOutcome) {
        this(getAdSelectionDataOutcome.getAdSelectionId(), getAdSelectionDataOutcome.getAdSelectionData());
        getAdSelectionDataOutcome.getClass();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAdSelectionDataOutcome)) {
            return false;
        }
        GetAdSelectionDataOutcome getAdSelectionDataOutcome = (GetAdSelectionDataOutcome) obj;
        return this.adSelectionId == getAdSelectionDataOutcome.adSelectionId && Arrays.equals(this.adSelectionData, getAdSelectionDataOutcome.adSelectionData);
    }

    public final byte[] getAdSelectionData() {
        return this.adSelectionData;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public int hashCode() {
        long j10 = this.adSelectionId;
        int i10 = ((int) (j10 ^ (j10 >>> 32))) * 31;
        byte[] bArr = this.adSelectionData;
        return i10 + (bArr != null ? bArr.hashCode() : 0);
    }

    public String toString() {
        return "GetAdSelectionDataOutcome: adSelectionId=" + this.adSelectionId + ", adSelectionData=" + this.adSelectionData;
    }

    public GetAdSelectionDataOutcome(long j10, byte[] bArr) {
        this.adSelectionId = j10;
        this.adSelectionData = bArr;
    }

    public /* synthetic */ GetAdSelectionDataOutcome(long j10, byte[] bArr, int i10, g gVar) {
        this(j10, (i10 & 2) != 0 ? null : bArr);
    }

    public GetAdSelectionDataOutcome(long j10) {
        this(j10, null, 2, null);
    }
}

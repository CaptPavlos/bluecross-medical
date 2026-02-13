package androidx.privacysandbox.ads.adservices.topics;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresExtension(extension = 31, version = 9)
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class TopicsManagerApi31Ext9Impl extends TopicsManagerImplCommon {
    /* JADX WARN: Illegal instructions before constructor call */
    public TopicsManagerApi31Ext9Impl(Context context) {
        context.getClass();
        android.adservices.topics.TopicsManager topicsManager = android.adservices.topics.TopicsManager.get(context);
        topicsManager.getClass();
        super(topicsManager);
    }

    @Override // androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon
    public android.adservices.topics.GetTopicsRequest convertRequest$ads_adservices_release(GetTopicsRequest getTopicsRequest) {
        getTopicsRequest.getClass();
        return GetTopicsRequestHelper.INSTANCE.convertRequestWithRecordObservation$ads_adservices_release(getTopicsRequest);
    }
}

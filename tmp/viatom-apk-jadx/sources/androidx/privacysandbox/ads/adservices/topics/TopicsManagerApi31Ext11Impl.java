package androidx.privacysandbox.ads.adservices.topics;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresExtension(extension = 31, version = 11)
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class TopicsManagerApi31Ext11Impl extends TopicsManagerImplCommon {
    /* JADX WARN: Illegal instructions before constructor call */
    public TopicsManagerApi31Ext11Impl(Context context) {
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

    @Override // androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon
    @ExperimentalFeatures.Ext11OptIn
    public GetTopicsResponse convertResponse$ads_adservices_release(android.adservices.topics.GetTopicsResponse getTopicsResponse) {
        getTopicsResponse.getClass();
        return GetTopicsResponseHelper.INSTANCE.convertResponseWithEncryptedTopics$ads_adservices_release(getTopicsResponse);
    }
}

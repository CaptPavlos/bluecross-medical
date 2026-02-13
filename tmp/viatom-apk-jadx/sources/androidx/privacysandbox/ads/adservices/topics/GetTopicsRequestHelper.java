package androidx.privacysandbox.ads.adservices.topics;

import android.adservices.topics.GetTopicsRequest;
import android.annotation.SuppressLint;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@SuppressLint({"ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class GetTopicsRequestHelper {
    public static final GetTopicsRequestHelper INSTANCE = new GetTopicsRequestHelper();

    private GetTopicsRequestHelper() {
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 5), @RequiresExtension(extension = 31, version = 9)})
    public final android.adservices.topics.GetTopicsRequest convertRequestWithRecordObservation$ads_adservices_release(GetTopicsRequest getTopicsRequest) {
        getTopicsRequest.getClass();
        android.adservices.topics.GetTopicsRequest getTopicsRequestBuild = new GetTopicsRequest.Builder().setAdsSdkName(getTopicsRequest.getAdsSdkName()).setShouldRecordObservation(getTopicsRequest.shouldRecordObservation()).build();
        getTopicsRequestBuild.getClass();
        return getTopicsRequestBuild;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    public final android.adservices.topics.GetTopicsRequest convertRequestWithoutRecordObservation$ads_adservices_release(GetTopicsRequest getTopicsRequest) {
        getTopicsRequest.getClass();
        android.adservices.topics.GetTopicsRequest getTopicsRequestBuild = new GetTopicsRequest.Builder().setAdsSdkName(getTopicsRequest.getAdsSdkName()).build();
        getTopicsRequestBuild.getClass();
        return getTopicsRequestBuild;
    }
}

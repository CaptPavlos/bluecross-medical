package androidx.privacysandbox.ads.adservices.topics;

import android.annotation.SuppressLint;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.adid.a;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@SuppressLint({"ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class GetTopicsResponseHelper {
    public static final GetTopicsResponseHelper INSTANCE = new GetTopicsResponseHelper();

    private GetTopicsResponseHelper() {
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    public final GetTopicsResponse convertResponse$ads_adservices_release(android.adservices.topics.GetTopicsResponse getTopicsResponse) {
        getTopicsResponse.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator<android.adservices.topics.Topic> it = getTopicsResponse.getTopics().iterator();
        while (it.hasNext()) {
            android.adservices.topics.Topic topicF = a.f(it.next());
            arrayList.add(new Topic(topicF.getTaxonomyVersion(), topicF.getModelVersion(), topicF.getTopicId()));
        }
        return new GetTopicsResponse(arrayList);
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 11), @RequiresExtension(extension = 31, version = 11)})
    @ExperimentalFeatures.Ext11OptIn
    public final GetTopicsResponse convertResponseWithEncryptedTopics$ads_adservices_release(android.adservices.topics.GetTopicsResponse getTopicsResponse) {
        getTopicsResponse.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator<android.adservices.topics.Topic> it = getTopicsResponse.getTopics().iterator();
        while (it.hasNext()) {
            android.adservices.topics.Topic topicF = a.f(it.next());
            arrayList.add(new Topic(topicF.getTaxonomyVersion(), topicF.getModelVersion(), topicF.getTopicId()));
        }
        ArrayList arrayList2 = new ArrayList();
        for (android.adservices.topics.EncryptedTopic encryptedTopic : getTopicsResponse.getEncryptedTopics()) {
            byte[] encryptedTopic2 = encryptedTopic.getEncryptedTopic();
            encryptedTopic2.getClass();
            String keyIdentifier = encryptedTopic.getKeyIdentifier();
            keyIdentifier.getClass();
            byte[] encapsulatedKey = encryptedTopic.getEncapsulatedKey();
            encapsulatedKey.getClass();
            arrayList2.add(new EncryptedTopic(encryptedTopic2, keyIdentifier, encapsulatedKey));
        }
        return new GetTopicsResponse(arrayList, arrayList2);
    }
}

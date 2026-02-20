package androidx.privacysandbox.ads.adservices.topics;

import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import j$.util.Objects;
import java.util.HashSet;
import java.util.List;
import t6.t;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class GetTopicsResponse {
    private final List<EncryptedTopic> encryptedTopics;
    private final List<Topic> topics;

    @ExperimentalFeatures.Ext11OptIn
    public GetTopicsResponse(List<Topic> list, List<EncryptedTopic> list2) {
        list.getClass();
        list2.getClass();
        this.topics = list;
        this.encryptedTopics = list2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetTopicsResponse)) {
            return false;
        }
        GetTopicsResponse getTopicsResponse = (GetTopicsResponse) obj;
        return this.topics.size() == getTopicsResponse.topics.size() && this.encryptedTopics.size() == getTopicsResponse.encryptedTopics.size() && new HashSet(this.topics).equals(new HashSet(getTopicsResponse.topics)) && new HashSet(this.encryptedTopics).equals(new HashSet(getTopicsResponse.encryptedTopics));
    }

    public final List<EncryptedTopic> getEncryptedTopics() {
        return this.encryptedTopics;
    }

    public final List<Topic> getTopics() {
        return this.topics;
    }

    public int hashCode() {
        return Objects.hash(this.topics, this.encryptedTopics);
    }

    public String toString() {
        return "GetTopicsResponse: Topics=" + this.topics + ", EncryptedTopics=" + this.encryptedTopics;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetTopicsResponse(List<Topic> list) {
        this(list, t.f12808a);
        list.getClass();
    }
}

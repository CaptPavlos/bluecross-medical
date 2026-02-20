package androidx.privacysandbox.ads.adservices.topics;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class Topic {
    private final long modelVersion;
    private final long taxonomyVersion;
    private final int topicId;

    public Topic(long j10, long j11, int i10) {
        this.taxonomyVersion = j10;
        this.modelVersion = j11;
        this.topicId = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Topic)) {
            return false;
        }
        Topic topic = (Topic) obj;
        return this.taxonomyVersion == topic.taxonomyVersion && this.modelVersion == topic.modelVersion && this.topicId == topic.topicId;
    }

    public final long getModelVersion() {
        return this.modelVersion;
    }

    public final long getTaxonomyVersion() {
        return this.taxonomyVersion;
    }

    public final int getTopicId() {
        return this.topicId;
    }

    public int hashCode() {
        long j10 = this.taxonomyVersion;
        int i10 = ((int) (j10 ^ (j10 >>> 32))) * 31;
        long j11 = this.modelVersion;
        return ((i10 + ((int) ((j11 >>> 32) ^ j11))) * 31) + this.topicId;
    }

    public String toString() {
        return "Topic { ".concat("TaxonomyVersion=" + this.taxonomyVersion + ", ModelVersion=" + this.modelVersion + ", TopicCode=" + this.topicId + " }");
    }
}

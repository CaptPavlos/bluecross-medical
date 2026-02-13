package androidx.collection;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class LongLongPair {
    private final long first;
    private final long second;

    public LongLongPair(long j10, long j11) {
        this.first = j10;
        this.second = j11;
    }

    public final long component1() {
        return getFirst();
    }

    public final long component2() {
        return getSecond();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LongLongPair)) {
            return false;
        }
        LongLongPair longLongPair = (LongLongPair) obj;
        return longLongPair.first == this.first && longLongPair.second == this.second;
    }

    public final long getFirst() {
        return this.first;
    }

    public final long getSecond() {
        return this.second;
    }

    public int hashCode() {
        long j10 = this.first;
        int i10 = (int) (j10 ^ (j10 >>> 32));
        long j11 = this.second;
        return i10 ^ ((int) ((j11 >>> 32) ^ j11));
    }

    public String toString() {
        return "(" + this.first + ", " + this.second + ')';
    }
}

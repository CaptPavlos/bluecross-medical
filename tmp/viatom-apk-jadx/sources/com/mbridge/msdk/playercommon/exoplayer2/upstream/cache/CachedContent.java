package com.mbridge.msdk.playercommon.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class CachedContent {
    private static final int VERSION_MAX = Integer.MAX_VALUE;
    private static final int VERSION_METADATA_INTRODUCED = 2;
    public final int id;
    public final String key;
    private boolean locked;
    private DefaultContentMetadata metadata = DefaultContentMetadata.EMPTY;
    private final TreeSet<SimpleCacheSpan> cachedSpans = new TreeSet<>();

    public CachedContent(int i10, String str) {
        this.id = i10;
        this.key = str;
    }

    public static CachedContent readFromStream(int i10, DataInputStream dataInputStream) throws IOException {
        CachedContent cachedContent = new CachedContent(dataInputStream.readInt(), dataInputStream.readUTF());
        if (i10 >= 2) {
            cachedContent.metadata = DefaultContentMetadata.readFromStream(dataInputStream);
            return cachedContent;
        }
        long j10 = dataInputStream.readLong();
        ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
        ContentMetadataInternal.setContentLength(contentMetadataMutations, j10);
        cachedContent.applyMetadataMutations(contentMetadataMutations);
        return cachedContent;
    }

    public final void addSpan(SimpleCacheSpan simpleCacheSpan) {
        this.cachedSpans.add(simpleCacheSpan);
    }

    public final boolean applyMetadataMutations(ContentMetadataMutations contentMetadataMutations) {
        this.metadata = this.metadata.copyWithMutationsApplied(contentMetadataMutations);
        return !r2.equals(r0);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && CachedContent.class == obj.getClass()) {
            CachedContent cachedContent = (CachedContent) obj;
            if (this.id == cachedContent.id && this.key.equals(cachedContent.key) && this.cachedSpans.equals(cachedContent.cachedSpans) && this.metadata.equals(cachedContent.metadata)) {
                return true;
            }
        }
        return false;
    }

    public final long getCachedBytesLength(long j10, long j11) {
        SimpleCacheSpan span = getSpan(j10);
        if (span.isHoleSpan()) {
            return -Math.min(span.isOpenEnded() ? Long.MAX_VALUE : span.length, j11);
        }
        long j12 = j10 + j11;
        long jMax = span.position + span.length;
        if (jMax < j12) {
            for (SimpleCacheSpan simpleCacheSpan : this.cachedSpans.tailSet(span, false)) {
                long j13 = simpleCacheSpan.position;
                if (j13 > jMax) {
                    break;
                }
                jMax = Math.max(jMax, j13 + simpleCacheSpan.length);
                if (jMax >= j12) {
                    break;
                }
            }
        }
        return Math.min(jMax - j10, j11);
    }

    public final ContentMetadata getMetadata() {
        return this.metadata;
    }

    public final SimpleCacheSpan getSpan(long j10) {
        SimpleCacheSpan simpleCacheSpanCreateLookup = SimpleCacheSpan.createLookup(this.key, j10);
        SimpleCacheSpan simpleCacheSpanFloor = this.cachedSpans.floor(simpleCacheSpanCreateLookup);
        if (simpleCacheSpanFloor != null && simpleCacheSpanFloor.position + simpleCacheSpanFloor.length > j10) {
            return simpleCacheSpanFloor;
        }
        SimpleCacheSpan simpleCacheSpanCeiling = this.cachedSpans.ceiling(simpleCacheSpanCreateLookup);
        String str = this.key;
        return simpleCacheSpanCeiling == null ? SimpleCacheSpan.createOpenHole(str, j10) : SimpleCacheSpan.createClosedHole(str, j10, simpleCacheSpanCeiling.position - j10);
    }

    public final TreeSet<SimpleCacheSpan> getSpans() {
        return this.cachedSpans;
    }

    public final int hashCode() {
        return this.cachedSpans.hashCode() + (headerHashCode(Integer.MAX_VALUE) * 31);
    }

    public final int headerHashCode(int i10) {
        int iHashCode = this.key.hashCode() + (this.id * 31);
        DefaultContentMetadata defaultContentMetadata = this.metadata;
        if (i10 < 2) {
            long contentLength = ContentMetadataInternal.getContentLength(defaultContentMetadata);
            return (iHashCode * 31) + ((int) (contentLength ^ (contentLength >>> 32)));
        }
        return defaultContentMetadata.hashCode() + (iHashCode * 31);
    }

    public final boolean isEmpty() {
        return this.cachedSpans.isEmpty();
    }

    public final boolean isLocked() {
        return this.locked;
    }

    public final boolean removeSpan(CacheSpan cacheSpan) {
        if (!this.cachedSpans.remove(cacheSpan)) {
            return false;
        }
        cacheSpan.file.delete();
        return true;
    }

    public final void setLocked(boolean z9) {
        this.locked = z9;
    }

    public final SimpleCacheSpan touch(SimpleCacheSpan simpleCacheSpan) throws Cache.CacheException {
        Assertions.checkState(this.cachedSpans.remove(simpleCacheSpan));
        SimpleCacheSpan simpleCacheSpanCopyWithUpdatedLastAccessTime = simpleCacheSpan.copyWithUpdatedLastAccessTime(this.id);
        if (simpleCacheSpan.file.renameTo(simpleCacheSpanCopyWithUpdatedLastAccessTime.file)) {
            this.cachedSpans.add(simpleCacheSpanCopyWithUpdatedLastAccessTime);
            return simpleCacheSpanCopyWithUpdatedLastAccessTime;
        }
        StringBuilder sb = new StringBuilder("Renaming of ");
        sb.append(simpleCacheSpan.file);
        File file = simpleCacheSpanCopyWithUpdatedLastAccessTime.file;
        sb.append(" to ");
        sb.append(file);
        sb.append(" failed.");
        throw new Cache.CacheException(sb.toString());
    }

    public final void writeToStream(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.id);
        dataOutputStream.writeUTF(this.key);
        this.metadata.writeToStream(dataOutputStream);
    }
}

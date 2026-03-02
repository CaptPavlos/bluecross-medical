package com.mbridge.msdk.playercommon.exoplayer2.upstream.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.File;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class CacheSpan implements Comparable<CacheSpan> {

    @Nullable
    public final File file;
    public final boolean isCached;
    public final String key;
    public final long lastAccessTimestamp;
    public final long length;
    public final long position;

    public CacheSpan(String str, long j10, long j11, long j12, @Nullable File file) {
        this.key = str;
        this.position = j10;
        this.length = j11;
        this.isCached = file != null;
        this.file = file;
        this.lastAccessTimestamp = j12;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull CacheSpan cacheSpan) {
        if (!this.key.equals(cacheSpan.key)) {
            return this.key.compareTo(cacheSpan.key);
        }
        long j10 = this.position - cacheSpan.position;
        if (j10 == 0) {
            return 0;
        }
        return j10 < 0 ? -1 : 1;
    }

    public boolean isHoleSpan() {
        return !this.isCached;
    }

    public boolean isOpenEnded() {
        return this.length == -1;
    }

    public CacheSpan(String str, long j10, long j11) {
        this(str, j10, j11, C.TIME_UNSET, null);
    }
}

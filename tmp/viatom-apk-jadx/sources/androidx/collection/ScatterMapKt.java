package androidx.collection;

import s6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ScatterMapKt {
    public static final long AllEmpty = -9187201950435737472L;
    public static final long BitmaskLsb = 72340172838076673L;
    public static final long BitmaskMsb = -9187201950435737472L;
    public static final int ClonedMetadataCount = 7;
    public static final int DefaultScatterCapacity = 6;
    public static final long Deleted = 254;
    public static final long Empty = 128;
    public static final long[] EmptyGroup = {-9187201950435737345L, -1};
    private static final MutableScatterMap EmptyScatterMap = new MutableScatterMap(0);
    public static final int GroupWidth = 8;
    public static final int MurmurHashC1 = -862048943;
    public static final long Sentinel = 255;

    public static final <K, V> ScatterMap<K, V> emptyScatterMap() {
        MutableScatterMap mutableScatterMap = EmptyScatterMap;
        mutableScatterMap.getClass();
        return mutableScatterMap;
    }

    public static final int get(long j10) {
        return Long.numberOfTrailingZeros(j10) >> 3;
    }

    public static final long group(long[] jArr, int i10) {
        jArr.getClass();
        int i11 = i10 >> 3;
        int i12 = (i10 & 7) << 3;
        return (((-i12) >> 63) & (jArr[i11 + 1] << (64 - i12))) | (jArr[i11] >>> i12);
    }

    public static final int h1(int i10) {
        return i10 >>> 7;
    }

    public static final int h2(int i10) {
        return i10 & 127;
    }

    public static final boolean hasNext(long j10) {
        return j10 != 0;
    }

    public static final int hash(Object obj) {
        int iHashCode = (obj != null ? obj.hashCode() : 0) * MurmurHashC1;
        return iHashCode ^ (iHashCode << 16);
    }

    public static final boolean isDeleted(long[] jArr, int i10) {
        jArr.getClass();
        return ((jArr[i10 >> 3] >> ((i10 & 7) << 3)) & 255) == 254;
    }

    public static final boolean isEmpty(long[] jArr, int i10) {
        jArr.getClass();
        return ((jArr[i10 >> 3] >> ((i10 & 7) << 3)) & 255) == 128;
    }

    public static final boolean isFull(long[] jArr, int i10) {
        jArr.getClass();
        return ((jArr[i10 >> 3] >> ((i10 & 7) << 3)) & 255) < 128;
    }

    public static final int loadedCapacity(int i10) {
        if (i10 == 7) {
            return 6;
        }
        return i10 - (i10 / 8);
    }

    public static final int lowestBitSet(long j10) {
        return Long.numberOfTrailingZeros(j10) >> 3;
    }

    public static final long maskEmpty(long j10) {
        return j10 & ((~j10) << 6) & (-9187201950435737472L);
    }

    public static final long maskEmptyOrDeleted(long j10) {
        return j10 & ((~j10) << 7) & (-9187201950435737472L);
    }

    public static final long match(long j10, int i10) {
        long j11 = j10 ^ (i10 * BitmaskLsb);
        return (~j11) & (j11 - BitmaskLsb) & (-9187201950435737472L);
    }

    public static final <K, V> MutableScatterMap<K, V> mutableScatterMapOf(i... iVarArr) {
        iVarArr.getClass();
        MutableScatterMap<K, V> mutableScatterMap = new MutableScatterMap<>(iVarArr.length);
        mutableScatterMap.putAll(iVarArr);
        return mutableScatterMap;
    }

    public static final long next(long j10) {
        return j10 & (j10 - 1);
    }

    public static final int nextCapacity(int i10) {
        if (i10 == 0) {
            return 6;
        }
        return (i10 * 2) + 1;
    }

    public static final int normalizeCapacity(int i10) {
        if (i10 > 0) {
            return (-1) >>> Integer.numberOfLeadingZeros(i10);
        }
        return 0;
    }

    public static final long readRawMetadata(long[] jArr, int i10) {
        jArr.getClass();
        return (jArr[i10 >> 3] >> ((i10 & 7) << 3)) & 255;
    }

    public static final int unloadedCapacity(int i10) {
        if (i10 == 7) {
            return 8;
        }
        return ((i10 - 1) / 7) + i10;
    }

    public static final void writeRawMetadata(long[] jArr, int i10, long j10) {
        jArr.getClass();
        int i11 = i10 >> 3;
        int i12 = (i10 & 7) << 3;
        jArr[i11] = (j10 << i12) | (jArr[i11] & (~(255 << i12)));
    }

    public static final <K, V> MutableScatterMap<K, V> mutableScatterMapOf() {
        return new MutableScatterMap<>(0, 1, null);
    }

    public static /* synthetic */ void getBitmaskLsb$annotations() {
    }

    public static /* synthetic */ void getBitmaskMsb$annotations() {
    }

    public static /* synthetic */ void getSentinel$annotations() {
    }

    public static final boolean isFull(long j10) {
        return j10 < 128;
    }
}

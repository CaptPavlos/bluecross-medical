package androidx.datastore.core;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class NativeSharedCounter {
    public final native long nativeCreateSharedCounter(int i10);

    public final native int nativeGetCounterValue(long j10);

    public final native int nativeIncrementAndGetCounterValue(long j10);

    public final native int nativeTruncateFile(int i10);
}

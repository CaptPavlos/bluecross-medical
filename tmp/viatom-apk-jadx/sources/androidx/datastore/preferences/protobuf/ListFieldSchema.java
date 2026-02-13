package androidx.datastore.preferences.protobuf;

import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@CheckReturnValue
/* loaded from: classes.dex */
interface ListFieldSchema {
    void makeImmutableListAt(Object obj, long j10);

    <L> void mergeListsAt(Object obj, Object obj2, long j10);

    <L> List<L> mutableListAt(Object obj, long j10);
}

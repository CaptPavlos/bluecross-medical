package androidx.room;

import androidx.room.util.DBUtil;
import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class RoomLambdaTrackingLiveData<T> extends RoomTrackingLiveData<T> {
    private final l lambdaFunction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomLambdaTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z9, String[] strArr, l lVar) {
        super(roomDatabase, invalidationLiveDataContainer, z9, strArr, null);
        roomDatabase.getClass();
        invalidationLiveDataContainer.getClass();
        strArr.getClass();
        lVar.getClass();
        this.lambdaFunction = lVar;
    }

    @Override // androidx.room.RoomTrackingLiveData
    public Object compute(w6.c cVar) {
        return DBUtil.performSuspending(getDatabase(), true, getInTransaction(), this.lambdaFunction, cVar);
    }
}

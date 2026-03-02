package androidx.room;

import java.util.concurrent.Callable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class RoomCallableTrackingLiveData<T> extends RoomTrackingLiveData<T> {
    private final Callable<T> callableFunction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomCallableTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z9, String[] strArr, Callable<T> callable) {
        super(roomDatabase, invalidationLiveDataContainer, z9, strArr, null);
        roomDatabase.getClass();
        invalidationLiveDataContainer.getClass();
        strArr.getClass();
        callable.getClass();
        this.callableFunction = callable;
    }

    @Override // androidx.room.RoomTrackingLiveData
    public Object compute(w6.c cVar) {
        return this.callableFunction.call();
    }
}

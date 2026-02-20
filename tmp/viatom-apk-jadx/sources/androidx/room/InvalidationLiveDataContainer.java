package androidx.room;

import androidx.lifecycle.LiveData;
import g7.l;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class InvalidationLiveDataContainer {
    private final RoomDatabase database;
    private final Set<LiveData<?>> liveDataSet;

    public InvalidationLiveDataContainer(RoomDatabase roomDatabase) {
        roomDatabase.getClass();
        this.database = roomDatabase;
        Set<LiveData<?>> setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        setNewSetFromMap.getClass();
        this.liveDataSet = setNewSetFromMap;
    }

    public final <T> LiveData<T> create(String[] strArr, boolean z9, Callable<T> callable) {
        strArr.getClass();
        callable.getClass();
        return new RoomCallableTrackingLiveData(this.database, this, z9, strArr, callable);
    }

    public final Set<LiveData<?>> getLiveDataSet$room_runtime_release() {
        return this.liveDataSet;
    }

    public final void onActive(LiveData<?> liveData) {
        liveData.getClass();
        this.liveDataSet.add(liveData);
    }

    public final void onInactive(LiveData<?> liveData) {
        liveData.getClass();
        this.liveDataSet.remove(liveData);
    }

    public final <T> LiveData<T> create(String[] strArr, boolean z9, l lVar) {
        strArr.getClass();
        lVar.getClass();
        return new RoomLambdaTrackingLiveData(this.database, this, z9, strArr, lVar);
    }
}

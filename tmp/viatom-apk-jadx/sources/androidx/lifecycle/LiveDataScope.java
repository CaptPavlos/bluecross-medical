package androidx.lifecycle;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface LiveDataScope<T> {
    Object emit(T t, w6.c cVar);

    Object emitSource(LiveData<T> liveData, w6.c cVar);

    T getLatestValue();
}

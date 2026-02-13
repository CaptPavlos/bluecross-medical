package androidx.room;

import androidx.room.InvalidationTracker;
import java.lang.ref.WeakReference;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class WeakObserver extends InvalidationTracker.Observer {
    private final WeakReference<InvalidationTracker.Observer> delegateRef;
    private final InvalidationTracker tracker;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeakObserver(InvalidationTracker invalidationTracker, InvalidationTracker.Observer observer) {
        super(observer.getTables$room_runtime_release());
        invalidationTracker.getClass();
        observer.getClass();
        this.tracker = invalidationTracker;
        this.delegateRef = new WeakReference<>(observer);
    }

    @Override // androidx.room.InvalidationTracker.Observer
    public void onInvalidated(Set<String> set) {
        set.getClass();
        InvalidationTracker.Observer observer = this.delegateRef.get();
        if (observer == null) {
            this.tracker.removeObserver(this);
        } else {
            observer.onInvalidated(set);
        }
    }
}

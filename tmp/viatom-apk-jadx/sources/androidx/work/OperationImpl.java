package androidx.work;

import androidx.lifecycle.LiveData;
import androidx.work.Operation;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class OperationImpl implements Operation {
    private final k1.b future;
    private final LiveData<Operation.State> state;

    public OperationImpl(LiveData<Operation.State> liveData, k1.b bVar) {
        liveData.getClass();
        bVar.getClass();
        this.state = liveData;
        this.future = bVar;
    }

    @Override // androidx.work.Operation
    public k1.b getResult() {
        return this.future;
    }

    @Override // androidx.work.Operation
    public LiveData<Operation.State> getState() {
        return this.state;
    }
}

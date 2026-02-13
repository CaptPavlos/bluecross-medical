package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class SynchronizedStartStopTokensImpl implements StartStopTokens {
    private final StartStopTokens delegate;
    private final Object lock;

    public SynchronizedStartStopTokensImpl(StartStopTokens startStopTokens) {
        startStopTokens.getClass();
        this.delegate = startStopTokens;
        this.lock = new Object();
    }

    @Override // androidx.work.impl.StartStopTokens
    public boolean contains(WorkGenerationalId workGenerationalId) {
        boolean zContains;
        workGenerationalId.getClass();
        synchronized (this.lock) {
            zContains = this.delegate.contains(workGenerationalId);
        }
        return zContains;
    }

    @Override // androidx.work.impl.StartStopTokens
    public StartStopToken remove(WorkGenerationalId workGenerationalId) {
        StartStopToken startStopTokenRemove;
        workGenerationalId.getClass();
        synchronized (this.lock) {
            startStopTokenRemove = this.delegate.remove(workGenerationalId);
        }
        return startStopTokenRemove;
    }

    @Override // androidx.work.impl.StartStopTokens
    public StartStopToken tokenFor(WorkGenerationalId workGenerationalId) {
        StartStopToken startStopToken;
        workGenerationalId.getClass();
        synchronized (this.lock) {
            startStopToken = this.delegate.tokenFor(workGenerationalId);
        }
        return startStopToken;
    }

    @Override // androidx.work.impl.StartStopTokens
    public final StartStopToken remove(WorkSpec workSpec) {
        int i10 = f.f705a;
        workSpec.getClass();
        return remove(WorkSpecKt.generationalId(workSpec));
    }

    @Override // androidx.work.impl.StartStopTokens
    public final StartStopToken tokenFor(WorkSpec workSpec) {
        int i10 = f.f705a;
        workSpec.getClass();
        return tokenFor(WorkSpecKt.generationalId(workSpec));
    }

    @Override // androidx.work.impl.StartStopTokens
    public List<StartStopToken> remove(String str) {
        List<StartStopToken> listRemove;
        str.getClass();
        synchronized (this.lock) {
            listRemove = this.delegate.remove(str);
        }
        return listRemove;
    }
}

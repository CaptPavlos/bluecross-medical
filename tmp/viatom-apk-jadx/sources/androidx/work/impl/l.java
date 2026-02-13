package androidx.work.impl;

import java.util.concurrent.Callable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f717a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WorkerWrapper f718b;

    public /* synthetic */ l(WorkerWrapper workerWrapper, int i10) {
        this.f717a = i10;
        this.f718b = workerWrapper;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f717a) {
            case 0:
                return WorkerWrapper.runWorker$lambda$1(this.f718b);
            default:
                return WorkerWrapper.trySetRunning$lambda$13(this.f718b);
        }
    }
}

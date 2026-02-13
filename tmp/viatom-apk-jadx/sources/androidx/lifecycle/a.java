package androidx.lifecycle;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f569a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f570b;

    public /* synthetic */ a(Object obj, int i10) {
        this.f569a = i10;
        this.f570b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f569a) {
            case 0:
                ComputableLiveData.refreshRunnable$lambda$0((ComputableLiveData) this.f570b);
                break;
            case 1:
                ComputableLiveData.invalidationRunnable$lambda$1((ComputableLiveData) this.f570b);
                break;
            default:
                ProcessLifecycleOwner.delayedPauseRunnable$lambda$0((ProcessLifecycleOwner) this.f570b);
                break;
        }
    }
}

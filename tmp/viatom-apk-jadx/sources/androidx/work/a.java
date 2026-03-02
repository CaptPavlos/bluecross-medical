package androidx.work;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f660a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f661b;

    public /* synthetic */ a(AtomicBoolean atomicBoolean, int i10) {
        this.f660a = i10;
        this.f661b = atomicBoolean;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f660a) {
            case 0:
                this.f661b.set(true);
                break;
            default:
                this.f661b.set(true);
                break;
        }
    }
}

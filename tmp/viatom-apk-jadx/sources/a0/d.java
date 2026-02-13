package a0;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f13a;

    /* renamed from: b, reason: collision with root package name */
    public final long f14b;

    /* renamed from: c, reason: collision with root package name */
    public final CountDownLatch f15c = new CountDownLatch(1);

    /* renamed from: d, reason: collision with root package name */
    public boolean f16d = false;

    public d(b bVar, long j10) {
        this.f13a = new WeakReference(bVar);
        this.f14b = j10;
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        b bVar;
        WeakReference weakReference = this.f13a;
        try {
            if (this.f15c.await(this.f14b, TimeUnit.MILLISECONDS) || (bVar = (b) weakReference.get()) == null) {
                return;
            }
            bVar.b();
            this.f16d = true;
        } catch (InterruptedException unused) {
            b bVar2 = (b) weakReference.get();
            if (bVar2 != null) {
                bVar2.b();
                this.f16d = true;
            }
        }
    }
}

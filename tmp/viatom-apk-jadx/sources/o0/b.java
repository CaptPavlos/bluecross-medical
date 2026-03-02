package o0;

import android.os.Process;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11664a;

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f11665b;

    public /* synthetic */ b(int i10, Runnable runnable) {
        this.f11664a = i10;
        this.f11665b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        switch (this.f11664a) {
            case 0:
                Process.setThreadPriority(0);
                this.f11665b.run();
                break;
            case 1:
                try {
                    this.f11665b.run();
                    break;
                } catch (Exception e) {
                    t1.m("Executor", "Background execution failure.", e);
                    return;
                }
            default:
                this.f11665b.run();
                break;
        }
    }

    public String toString() {
        switch (this.f11664a) {
            case 2:
                return this.f11665b.toString();
            default:
                return super.toString();
        }
    }
}

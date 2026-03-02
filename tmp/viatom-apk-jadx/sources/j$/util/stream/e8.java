package j$.util.stream;

/* loaded from: classes2.dex */
public final class e8 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f9565a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f9566b;

    public e8(Runnable runnable, Runnable runnable2) {
        this.f9565a = runnable;
        this.f9566b = runnable2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f9565a.run();
            this.f9566b.run();
        } catch (Throwable th) {
            try {
                this.f9566b.run();
            } catch (Throwable th2) {
                try {
                    th.addSuppressed(th2);
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }
}

package e0;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class h implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h f7602b = new h(0);

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ h f7603c = new h(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7604a;

    public /* synthetic */ h(int i10) {
        this.f7604a = i10;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f7604a) {
            case 0:
                runnable.run();
                break;
            default:
                runnable.run();
                break;
        }
    }
}

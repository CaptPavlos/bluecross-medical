package h1;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ o f8433b = new o(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8434a;

    public /* synthetic */ o(int i10) {
        this.f8434a = i10;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f8434a) {
            case 0:
                runnable.run();
                break;
            default:
                runnable.run();
                break;
        }
    }
}

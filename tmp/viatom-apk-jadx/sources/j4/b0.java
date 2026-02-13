package j4;

import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b0 extends ThreadPoolExecutor {
    public final void a(int i10) {
        setCorePoolSize(i10);
        setMaximumPoolSize(i10);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final Future submit(Runnable runnable) {
        a0 a0Var = new a0((f) runnable);
        execute(a0Var);
        return a0Var;
    }
}

package androidx.work;

import androidx.tracing.Trace;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import r7.h0;
import r7.s;
import r7.t0;
import w6.h;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ConfigurationKt {
    public static final int DEFAULT_CONTENT_URI_TRIGGERS_WORKERS_LIMIT = 8;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [r7.s] */
    public static final Executor asExecutor(h hVar) {
        Executor executorL;
        w6.e eVar = hVar != null ? (w6.e) hVar.get(w6.d.f13522a) : null;
        t0 t0Var = eVar instanceof s ? (s) eVar : null;
        if (t0Var == null) {
            return null;
        }
        t0 t0Var2 = t0Var instanceof t0 ? t0Var : null;
        return (t0Var2 == null || (executorL = t0Var2.l()) == null) ? new h0(t0Var) : executorL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Executor createDefaultExecutor(final boolean z9) {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new ThreadFactory() { // from class: androidx.work.ConfigurationKt$createDefaultExecutor$factory$1
            private final AtomicInteger threadCount = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                runnable.getClass();
                StringBuilder sbV = a3.a.v(z9 ? "WM.task-" : "androidx.work-");
                sbV.append(this.threadCount.incrementAndGet());
                return new Thread(runnable, sbV.toString());
            }
        });
        executorServiceNewFixedThreadPool.getClass();
        return executorServiceNewFixedThreadPool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Tracer createDefaultTracer() {
        return new Tracer() { // from class: androidx.work.ConfigurationKt$createDefaultTracer$tracer$1
            @Override // androidx.work.Tracer
            public void beginAsyncSection(String str, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                str.getClass();
                Trace.beginAsyncSection(str, i10);
            }

            @Override // androidx.work.Tracer
            public void beginSection(String str) {
                str.getClass();
                Trace.beginSection(str);
            }

            @Override // androidx.work.Tracer
            public void endAsyncSection(String str, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                str.getClass();
                Trace.endAsyncSection(str, i10);
            }

            @Override // androidx.work.Tracer
            public void endSection() {
                Trace.endSection();
            }

            @Override // androidx.work.Tracer
            public boolean isEnabled() {
                return Trace.isEnabled();
            }
        };
    }
}

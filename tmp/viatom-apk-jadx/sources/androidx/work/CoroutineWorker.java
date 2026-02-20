package androidx.work;

import android.content.Context;
import g7.p;
import kotlin.jvm.internal.l;
import r7.i0;
import r7.s;
import r7.w;
import r7.y;
import w6.h;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class CoroutineWorker extends ListenableWorker {
    private final s coroutineContext;
    private final WorkerParameters params;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class DeprecatedDispatcher extends s {
        public static final DeprecatedDispatcher INSTANCE = new DeprecatedDispatcher();
        private static final s dispatcher = i0.f12407a;

        private DeprecatedDispatcher() {
        }

        @Override // r7.s
        public void dispatch(h hVar, Runnable runnable) {
            hVar.getClass();
            runnable.getClass();
            dispatcher.dispatch(hVar, runnable);
        }

        public final s getDispatcher() {
            return dispatcher;
        }

        @Override // r7.s
        public boolean isDispatchNeeded(h hVar) {
            hVar.getClass();
            return dispatcher.isDispatchNeeded(hVar);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.work.CoroutineWorker$getForegroundInfoAsync$1", f = "CoroutineWorker.kt", l = {androidx.constraintlayout.widget.R.styleable.ConstraintSet_transitionEasing}, m = "invokeSuspend")
    /* renamed from: androidx.work.CoroutineWorker$getForegroundInfoAsync$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        int label;

        public AnonymousClass1(w6.c cVar) {
            super(2, cVar);
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return CoroutineWorker.this.new AnonymousClass1(cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((AnonymousClass1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    s6.a.e(obj);
                    return obj;
                }
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            CoroutineWorker coroutineWorker = CoroutineWorker.this;
            this.label = 1;
            Object foregroundInfo = coroutineWorker.getForegroundInfo(this);
            x6.a aVar = x6.a.f13718a;
            return foregroundInfo == aVar ? aVar : foregroundInfo;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.work.CoroutineWorker$startWork$1", f = "CoroutineWorker.kt", l = {67}, m = "invokeSuspend")
    /* renamed from: androidx.work.CoroutineWorker$startWork$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01381 extends i implements p {
        int label;

        public C01381(w6.c cVar) {
            super(2, cVar);
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return CoroutineWorker.this.new C01381(cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((C01381) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    s6.a.e(obj);
                    return obj;
                }
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            CoroutineWorker coroutineWorker = CoroutineWorker.this;
            this.label = 1;
            Object objDoWork = coroutineWorker.doWork(this);
            x6.a aVar = x6.a.f13718a;
            return objDoWork == aVar ? aVar : objDoWork;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.params = workerParameters;
        this.coroutineContext = DeprecatedDispatcher.INSTANCE;
    }

    public static /* synthetic */ Object getForegroundInfo$suspendImpl(CoroutineWorker coroutineWorker, w6.c cVar) {
        throw new IllegalStateException("Not implemented");
    }

    public abstract Object doWork(w6.c cVar);

    public s getCoroutineContext() {
        return this.coroutineContext;
    }

    public Object getForegroundInfo(w6.c cVar) {
        return getForegroundInfo$suspendImpl(this, cVar);
    }

    @Override // androidx.work.ListenableWorker
    public final k1.b getForegroundInfoAsync() {
        return ListenableFutureKt.launchFuture$default(getCoroutineContext().plus(y.b()), null, new AnonymousClass1(null), 2, null);
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
    }

    public final Object setForeground(ForegroundInfo foregroundInfo, w6.c cVar) {
        k1.b foregroundAsync = setForegroundAsync(foregroundInfo);
        foregroundAsync.getClass();
        Object objAwait = androidx.concurrent.futures.ListenableFutureKt.await(foregroundAsync, cVar);
        return objAwait == x6.a.f13718a ? objAwait : s6.w.f12711a;
    }

    public final Object setProgress(Data data, w6.c cVar) {
        k1.b progressAsync = setProgressAsync(data);
        progressAsync.getClass();
        Object objAwait = androidx.concurrent.futures.ListenableFutureKt.await(progressAsync, cVar);
        return objAwait == x6.a.f13718a ? objAwait : s6.w.f12711a;
    }

    @Override // androidx.work.ListenableWorker
    public final k1.b startWork() {
        h coroutineContext = !l.a(getCoroutineContext(), DeprecatedDispatcher.INSTANCE) ? getCoroutineContext() : this.params.getWorkerContext();
        coroutineContext.getClass();
        return ListenableFutureKt.launchFuture$default(coroutineContext.plus(y.b()), null, new C01381(null), 2, null);
    }

    public static /* synthetic */ void getCoroutineContext$annotations() {
    }
}

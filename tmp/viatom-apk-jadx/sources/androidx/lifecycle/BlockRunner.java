package androidx.lifecycle;

import androidx.annotation.MainThread;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import g7.p;
import r7.a1;
import r7.i0;
import r7.w;
import r7.y;
import w7.n;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class BlockRunner<T> {
    private final p block;
    private a1 cancellationJob;
    private final CoroutineLiveData<T> liveData;
    private final g7.a onDone;
    private a1 runningJob;
    private final w scope;
    private final long timeoutInMs;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.lifecycle.BlockRunner$cancel$1", f = "CoroutineLiveData.kt", l = {SubsamplingScaleImageView.ORIENTATION_180}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.BlockRunner$cancel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends y6.i implements p {
        int label;
        final /* synthetic */ BlockRunner<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(BlockRunner<T> blockRunner, w6.c cVar) {
            super(2, cVar);
            this.this$0 = blockRunner;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return new AnonymousClass1(this.this$0, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((AnonymousClass1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            if (i10 == 0) {
                s6.a.e(obj);
                long j10 = ((BlockRunner) this.this$0).timeoutInMs;
                this.label = 1;
                Object objH = y.h(j10, this);
                x6.a aVar = x6.a.f13718a;
                if (objH == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
            }
            if (!((BlockRunner) this.this$0).liveData.hasActiveObservers()) {
                a1 a1Var = ((BlockRunner) this.this$0).runningJob;
                if (a1Var != null) {
                    a1Var.a(null);
                }
                ((BlockRunner) this.this$0).runningJob = null;
            }
            return s6.w.f12711a;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.lifecycle.BlockRunner$maybeRun$1", f = "CoroutineLiveData.kt", l = {168}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.BlockRunner$maybeRun$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01051 extends y6.i implements p {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BlockRunner<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01051(BlockRunner<T> blockRunner, w6.c cVar) {
            super(2, cVar);
            this.this$0 = blockRunner;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            C01051 c01051 = new C01051(this.this$0, cVar);
            c01051.L$0 = obj;
            return c01051;
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((C01051) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            if (i10 == 0) {
                s6.a.e(obj);
                LiveDataScopeImpl liveDataScopeImpl = new LiveDataScopeImpl(((BlockRunner) this.this$0).liveData, ((w) this.L$0).getCoroutineContext());
                p pVar = ((BlockRunner) this.this$0).block;
                this.label = 1;
                Object objInvoke = pVar.invoke(liveDataScopeImpl, this);
                x6.a aVar = x6.a.f13718a;
                if (objInvoke == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
            }
            ((BlockRunner) this.this$0).onDone.invoke();
            return s6.w.f12711a;
        }
    }

    public BlockRunner(CoroutineLiveData<T> coroutineLiveData, p pVar, long j10, w wVar, g7.a aVar) {
        coroutineLiveData.getClass();
        pVar.getClass();
        wVar.getClass();
        aVar.getClass();
        this.liveData = coroutineLiveData;
        this.block = pVar;
        this.timeoutInMs = j10;
        this.scope = wVar;
        this.onDone = aVar;
    }

    @MainThread
    public final void cancel() {
        if (this.cancellationJob != null) {
            androidx.window.layout.c.g("Cancel call cannot happen without a maybeRun");
            return;
        }
        w wVar = this.scope;
        y7.e eVar = i0.f12407a;
        this.cancellationJob = y.q(wVar, n.f13548a.f12716c, null, new AnonymousClass1(this, null), 2);
    }

    @MainThread
    public final void maybeRun() {
        a1 a1Var = this.cancellationJob;
        if (a1Var != null) {
            a1Var.a(null);
        }
        this.cancellationJob = null;
        if (this.runningJob != null) {
            return;
        }
        this.runningJob = y.q(this.scope, null, null, new C01051(this, null), 3);
    }
}

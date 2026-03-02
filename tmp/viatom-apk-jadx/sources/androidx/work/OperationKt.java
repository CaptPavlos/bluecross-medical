package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.work.Operation;
import java.util.concurrent.Executor;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class OperationKt {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.work.OperationKt", f = "Operation.kt", l = {36}, m = "await")
    /* renamed from: androidx.work.OperationKt$await$1, reason: invalid class name */
    public static final class AnonymousClass1 extends y6.c {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(w6.c cVar) {
            super(cVar);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OperationKt.await(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object await(androidx.work.Operation r4, w6.c r5) {
        /*
            boolean r0 = r5 instanceof androidx.work.OperationKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.work.OperationKt$await$1 r0 = (androidx.work.OperationKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.work.OperationKt$await$1 r0 = new androidx.work.OperationKt$await$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L2c
            if (r1 != r2) goto L25
            s6.a.e(r5)
            goto L41
        L25:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r4)
            r4 = 0
            return r4
        L2c:
            s6.a.e(r5)
            k1.b r4 = r4.getResult()
            r4.getClass()
            r0.label = r2
            java.lang.Object r5 = androidx.concurrent.futures.ListenableFutureKt.await(r4, r0)
            x6.a r4 = x6.a.f13718a
            if (r5 != r4) goto L41
            return r4
        L41:
            r5.getClass()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.OperationKt.await(androidx.work.Operation, w6.c):java.lang.Object");
    }

    private static final Object await$$forInline(Operation operation, w6.c cVar) {
        k1.b result = operation.getResult();
        result.getClass();
        Object objAwait = androidx.concurrent.futures.ListenableFutureKt.await(result, cVar);
        objAwait.getClass();
        return objAwait;
    }

    public static final Operation launchOperation(final Tracer tracer, final String str, final Executor executor, final g7.a aVar) {
        tracer.getClass();
        str.getClass();
        executor.getClass();
        aVar.getClass();
        final MutableLiveData mutableLiveData = new MutableLiveData(Operation.IN_PROGRESS);
        k1.b future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.work.c
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return OperationKt.launchOperation$lambda$2(executor, tracer, str, aVar, mutableLiveData, completer);
            }
        });
        future.getClass();
        return new OperationImpl(mutableLiveData, future);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w launchOperation$lambda$2(Executor executor, final Tracer tracer, final String str, final g7.a aVar, final MutableLiveData mutableLiveData, final CallbackToFutureAdapter.Completer completer) {
        completer.getClass();
        executor.execute(new Runnable() { // from class: androidx.work.d
            @Override // java.lang.Runnable
            public final void run() {
                OperationKt.launchOperation$lambda$2$lambda$1(tracer, str, aVar, mutableLiveData, completer);
            }
        });
        return w.f12711a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchOperation$lambda$2$lambda$1(Tracer tracer, String str, g7.a aVar, MutableLiveData mutableLiveData, CallbackToFutureAdapter.Completer completer) {
        boolean zIsEnabled = tracer.isEnabled();
        if (zIsEnabled) {
            try {
                tracer.beginSection(str);
            } finally {
                if (zIsEnabled) {
                    tracer.endSection();
                }
            }
        }
        try {
            aVar.invoke();
            Operation.State.SUCCESS success = Operation.SUCCESS;
            mutableLiveData.postValue(success);
            completer.set(success);
        } catch (Throwable th) {
            mutableLiveData.postValue(new Operation.State.FAILURE(th));
            completer.setException(th);
        }
    }
}

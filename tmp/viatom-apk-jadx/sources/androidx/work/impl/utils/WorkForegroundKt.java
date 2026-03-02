package androidx.work.impl.utils;

import android.content.Context;
import android.os.Build;
import androidx.concurrent.futures.ListenableFutureKt;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.WorkerWrapperKt;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import g7.p;
import java.util.concurrent.Executor;
import r7.w;
import r7.y;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class WorkForegroundKt {
    private static final String TAG;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.work.impl.utils.WorkForegroundKt$workForeground$2", f = "WorkForeground.kt", l = {42, 50}, m = "invokeSuspend")
    /* renamed from: androidx.work.impl.utils.WorkForegroundKt$workForeground$2, reason: invalid class name */
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ Context $context;
        final /* synthetic */ ForegroundUpdater $foregroundUpdater;
        final /* synthetic */ WorkSpec $spec;
        final /* synthetic */ ListenableWorker $worker;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ListenableWorker listenableWorker, WorkSpec workSpec, ForegroundUpdater foregroundUpdater, Context context, w6.c cVar) {
            super(2, cVar);
            this.$worker = listenableWorker;
            this.$spec = workSpec;
            this.$foregroundUpdater = foregroundUpdater;
            this.$context = context;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return new AnonymousClass2(this.$worker, this.$spec, this.$foregroundUpdater, this.$context, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((AnonymousClass2) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            int i10 = this.label;
            x6.a aVar = x6.a.f13718a;
            if (i10 == 0) {
                s6.a.e(obj);
                k1.b foregroundInfoAsync = this.$worker.getForegroundInfoAsync();
                foregroundInfoAsync.getClass();
                ListenableWorker listenableWorker = this.$worker;
                this.label = 1;
                obj = WorkerWrapperKt.awaitWithin(foregroundInfoAsync, listenableWorker, this);
                if (obj != aVar) {
                }
            }
            if (i10 != 1) {
                if (i10 == 2) {
                    s6.a.e(obj);
                    return obj;
                }
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            ForegroundInfo foregroundInfo = (ForegroundInfo) obj;
            if (foregroundInfo == null) {
                androidx.window.layout.c.g(a3.a.o(new StringBuilder("Worker was marked important ("), this.$spec.workerClassName, ") but did not provide ForegroundInfo"));
                return null;
            }
            String str = WorkForegroundKt.TAG;
            WorkSpec workSpec = this.$spec;
            Logger.get().debug(str, "Updating notification for " + workSpec.workerClassName);
            k1.b foregroundAsync = this.$foregroundUpdater.setForegroundAsync(this.$context, this.$worker.getId(), foregroundInfo);
            foregroundAsync.getClass();
            this.label = 2;
            Object objAwait = ListenableFutureKt.await(foregroundAsync, this);
            return objAwait == aVar ? aVar : objAwait;
        }
    }

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("WorkForegroundRunnable");
        strTagWithPrefix.getClass();
        TAG = strTagWithPrefix;
    }

    public static final Object workForeground(Context context, WorkSpec workSpec, ListenableWorker listenableWorker, ForegroundUpdater foregroundUpdater, TaskExecutor taskExecutor, w6.c cVar) throws Throwable {
        boolean z9 = workSpec.expedited;
        s6.w wVar = s6.w.f12711a;
        if (z9 && Build.VERSION.SDK_INT < 31) {
            Executor mainThreadExecutor = taskExecutor.getMainThreadExecutor();
            mainThreadExecutor.getClass();
            Object objZ = y.z(new AnonymousClass2(listenableWorker, workSpec, foregroundUpdater, context, null), y.k(mainThreadExecutor), cVar);
            if (objZ == x6.a.f13718a) {
                return objZ;
            }
        }
        return wVar;
    }
}

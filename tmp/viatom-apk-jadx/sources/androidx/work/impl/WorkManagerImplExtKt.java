package androidx.work.impl;

import android.content.Context;
import androidx.constraintlayout.widget.R;
import androidx.work.Configuration;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import g7.p;
import java.util.List;
import r7.a1;
import r7.s;
import r7.t;
import r7.w;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class WorkManagerImplExtKt {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @y6.e(c = "androidx.work.impl.WorkManagerImplExtKt$close$1", f = "WorkManagerImplExt.kt", l = {R.styleable.ConstraintSet_transitionEasing}, m = "invokeSuspend")
    /* renamed from: androidx.work.impl.WorkManagerImplExtKt$close$1, reason: invalid class name */
    public static final class AnonymousClass1 extends y6.i implements p {
        final /* synthetic */ WorkManagerImpl $this_close;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WorkManagerImpl workManagerImpl, w6.c cVar) {
            super(2, cVar);
            this.$this_close = workManagerImpl;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return new AnonymousClass1(this.$this_close, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, w6.c cVar) {
            return ((AnonymousClass1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            s6.w wVar = s6.w.f12711a;
            if (i10 != 0) {
                if (i10 == 1) {
                    s6.a.e(obj);
                    return wVar;
                }
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            w6.f fVar = this.$this_close.getWorkManagerScope().getCoroutineContext().get(t.f12437b);
            fVar.getClass();
            a1 a1Var = (a1) fVar;
            this.label = 1;
            a1Var.a(null);
            Object objD = a1Var.d(this);
            x6.a aVar = x6.a.f13718a;
            if (objD != aVar) {
                objD = wVar;
            }
            return objD == aVar ? aVar : wVar;
        }
    }

    public static final void close(WorkManagerImpl workManagerImpl) {
        workManagerImpl.getClass();
        y.u(w6.i.f13523a, new AnonymousClass1(workManagerImpl, null));
        workManagerImpl.getWorkDatabase().close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Scheduler> createSchedulers(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
        Scheduler schedulerCreateBestAvailableBackgroundScheduler = Schedulers.createBestAvailableBackgroundScheduler(context, workDatabase, configuration);
        schedulerCreateBestAvailableBackgroundScheduler.getClass();
        return t6.m.Q(schedulerCreateBestAvailableBackgroundScheduler, new GreedyScheduler(context, configuration, trackers, processor, new WorkLauncherImpl(processor, taskExecutor), taskExecutor));
    }

    public static final WorkManagerImpl createTestWorkManager(Context context, Configuration configuration, TaskExecutor taskExecutor) {
        context.getClass();
        configuration.getClass();
        taskExecutor.getClass();
        WorkDatabase.Companion companion = WorkDatabase.Companion;
        SerialExecutor serialTaskExecutor = taskExecutor.getSerialTaskExecutor();
        serialTaskExecutor.getClass();
        return createWorkManager$default(context, configuration, taskExecutor, companion.create(context, serialTaskExecutor, configuration.getClock(), true), null, null, null, 112, null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor, g7.t tVar) {
        context.getClass();
        configuration.getClass();
        taskExecutor.getClass();
        workDatabase.getClass();
        trackers.getClass();
        processor.getClass();
        tVar.getClass();
        return new WorkManagerImpl(context.getApplicationContext(), configuration, taskExecutor, workDatabase, (List) tVar.invoke(context, configuration, taskExecutor, workDatabase, trackers, processor), processor, trackers);
    }

    public static /* synthetic */ WorkManagerImpl createWorkManager$default(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor, g7.t tVar, int i10, Object obj) {
        Trackers trackers2;
        if ((i10 & 4) != 0) {
            taskExecutor = new WorkManagerTaskExecutor(configuration.getTaskExecutor());
        }
        TaskExecutor taskExecutor2 = taskExecutor;
        if ((i10 & 8) != 0) {
            WorkDatabase.Companion companion = WorkDatabase.Companion;
            Context applicationContext = context.getApplicationContext();
            applicationContext.getClass();
            SerialExecutor serialTaskExecutor = taskExecutor2.getSerialTaskExecutor();
            serialTaskExecutor.getClass();
            workDatabase = companion.create(applicationContext, serialTaskExecutor, configuration.getClock(), context.getResources().getBoolean(androidx.work.R.bool.workmanager_test_configuration));
        }
        if ((i10 & 16) != 0) {
            Context applicationContext2 = context.getApplicationContext();
            applicationContext2.getClass();
            trackers2 = new Trackers(applicationContext2, taskExecutor2, null, null, null, null, 60, null);
        } else {
            trackers2 = trackers;
        }
        return createWorkManager(context, configuration, taskExecutor2, workDatabase, trackers2, (i10 & 32) != 0 ? new Processor(context.getApplicationContext(), configuration, taskExecutor2, workDatabase) : processor, (i10 & 64) != 0 ? WorkManagerImplExtKt$WorkManagerImpl$1.INSTANCE : tVar);
    }

    public static final w createWorkManagerScope(TaskExecutor taskExecutor) {
        taskExecutor.getClass();
        s taskCoroutineDispatcher = taskExecutor.getTaskCoroutineDispatcher();
        taskCoroutineDispatcher.getClass();
        return y.a(taskCoroutineDispatcher);
    }

    public static final g7.t schedulers(final Scheduler... schedulerArr) {
        schedulerArr.getClass();
        return new g7.t() { // from class: androidx.work.impl.i
            @Override // g7.t
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return WorkManagerImplExtKt.schedulers$lambda$0(schedulerArr, (Context) obj, (Configuration) obj2, (TaskExecutor) obj3, (WorkDatabase) obj4, (Trackers) obj5, (Processor) obj6);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List schedulers$lambda$0(Scheduler[] schedulerArr, Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
        context.getClass();
        configuration.getClass();
        taskExecutor.getClass();
        workDatabase.getClass();
        trackers.getClass();
        processor.getClass();
        return t6.j.y0(schedulerArr);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration, TaskExecutor taskExecutor) {
        context.getClass();
        configuration.getClass();
        taskExecutor.getClass();
        return createWorkManager$default(context, configuration, taskExecutor, null, null, null, null, R.styleable.ConstraintSet_stateLabels, null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase) {
        context.getClass();
        configuration.getClass();
        taskExecutor.getClass();
        workDatabase.getClass();
        return createWorkManager$default(context, configuration, taskExecutor, workDatabase, null, null, null, 112, null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers) {
        context.getClass();
        configuration.getClass();
        taskExecutor.getClass();
        workDatabase.getClass();
        trackers.getClass();
        return createWorkManager$default(context, configuration, taskExecutor, workDatabase, trackers, null, null, 96, null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
        context.getClass();
        configuration.getClass();
        taskExecutor.getClass();
        workDatabase.getClass();
        trackers.getClass();
        processor.getClass();
        return createWorkManager$default(context, configuration, taskExecutor, workDatabase, trackers, processor, null, 64, null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration) {
        context.getClass();
        configuration.getClass();
        return createWorkManager$default(context, configuration, null, null, null, null, null, 124, null);
    }
}

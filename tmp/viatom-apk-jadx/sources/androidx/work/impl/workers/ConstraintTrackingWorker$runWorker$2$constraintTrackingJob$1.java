package androidx.work.impl.workers;

import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import g7.p;
import java.util.concurrent.atomic.AtomicInteger;
import k1.b;
import r7.w;
import s6.a;
import w6.c;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$2$constraintTrackingJob$1", f = "ConstraintTrackingWorker.kt", l = {TsExtractor.TS_STREAM_TYPE_AC3}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ConstraintTrackingWorker$runWorker$2$constraintTrackingJob$1 extends i implements p {
    final /* synthetic */ AtomicInteger $atomicReason;
    final /* synthetic */ b $future;
    final /* synthetic */ WorkConstraintsTracker $workConstraintsTracker;
    final /* synthetic */ WorkSpec $workSpec;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker$runWorker$2$constraintTrackingJob$1(WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, AtomicInteger atomicInteger, b bVar, c cVar) {
        super(2, cVar);
        this.$workConstraintsTracker = workConstraintsTracker;
        this.$workSpec = workSpec;
        this.$atomicReason = atomicInteger;
        this.$future = bVar;
    }

    @Override // y6.a
    public final c create(Object obj, c cVar) {
        return new ConstraintTrackingWorker$runWorker$2$constraintTrackingJob$1(this.$workConstraintsTracker, this.$workSpec, this.$atomicReason, this.$future, cVar);
    }

    @Override // g7.p
    public final Object invoke(w wVar, c cVar) {
        return ((ConstraintTrackingWorker$runWorker$2$constraintTrackingJob$1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.label;
        if (i10 == 0) {
            a.e(obj);
            WorkConstraintsTracker workConstraintsTracker = this.$workConstraintsTracker;
            WorkSpec workSpec = this.$workSpec;
            this.label = 1;
            obj = ConstraintTrackingWorkerKt.awaitConstraintsNotMet(workConstraintsTracker, workSpec, this);
            x6.a aVar = x6.a.f13718a;
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i10 != 1) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            a.e(obj);
        }
        this.$atomicReason.set(((Number) obj).intValue());
        this.$future.cancel(true);
        return s6.w.f12711a;
    }
}

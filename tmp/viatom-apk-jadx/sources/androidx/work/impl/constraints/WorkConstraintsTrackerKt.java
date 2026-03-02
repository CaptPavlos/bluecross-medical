package androidx.work.impl.constraints;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import g7.p;
import r7.a1;
import r7.s;
import r7.w;
import r7.y;
import u7.h;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class WorkConstraintsTrackerKt {
    private static final long DefaultNetworkRequestTimeoutMs = 1000;
    private static final String TAG;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.work.impl.constraints.WorkConstraintsTrackerKt$listen$1", f = "WorkConstraintsTracker.kt", l = {67}, m = "invokeSuspend")
    /* renamed from: androidx.work.impl.constraints.WorkConstraintsTrackerKt$listen$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ OnConstraintsStateChangedListener $listener;
        final /* synthetic */ WorkSpec $spec;
        final /* synthetic */ WorkConstraintsTracker $this_listen;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, OnConstraintsStateChangedListener onConstraintsStateChangedListener, w6.c cVar) {
            super(2, cVar);
            this.$this_listen = workConstraintsTracker;
            this.$spec = workSpec;
            this.$listener = onConstraintsStateChangedListener;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            return new AnonymousClass1(this.$this_listen, this.$spec, this.$listener, cVar);
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
                h hVarTrack = this.$this_listen.track(this.$spec);
                final OnConstraintsStateChangedListener onConstraintsStateChangedListener = this.$listener;
                final WorkSpec workSpec = this.$spec;
                u7.i iVar = new u7.i() { // from class: androidx.work.impl.constraints.WorkConstraintsTrackerKt.listen.1.1
                    @Override // u7.i
                    public final Object emit(ConstraintsState constraintsState, w6.c cVar) {
                        onConstraintsStateChangedListener.onConstraintsStateChanged(workSpec, constraintsState);
                        return s6.w.f12711a;
                    }
                };
                this.label = 1;
                Object objCollect = hVarTrack.collect(iVar, this);
                x6.a aVar = x6.a.f13718a;
                if (objCollect == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
            }
            return s6.w.f12711a;
        }
    }

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("WorkConstraintsTracker");
        strTagWithPrefix.getClass();
        TAG = strTagWithPrefix;
    }

    @RequiresApi(28)
    public static final NetworkRequestConstraintController NetworkRequestConstraintController(Context context) {
        context.getClass();
        Object systemService = context.getSystemService("connectivity");
        systemService.getClass();
        return new NetworkRequestConstraintController((ConnectivityManager) systemService, 0L, 2, null);
    }

    public static final a1 listen(WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, s sVar, OnConstraintsStateChangedListener onConstraintsStateChangedListener) {
        workConstraintsTracker.getClass();
        workSpec.getClass();
        sVar.getClass();
        onConstraintsStateChangedListener.getClass();
        return y.q(y.a(sVar), null, null, new AnonymousClass1(workConstraintsTracker, workSpec, onConstraintsStateChangedListener, null), 3);
    }
}

package androidx.work.impl.constraints;

import a3.q;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredController;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;
import r7.p1;
import s6.w;
import t6.j;
import t6.l;
import t6.n;
import u7.h;
import u7.i0;
import v7.g;
import y6.e;
import y6.i;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class WorkConstraintsTracker {
    private final List<ConstraintController> controllers;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkConstraintsTracker(Trackers trackers) {
        this(j.t0(new ConstraintController[]{new BatteryChargingController(trackers.getBatteryChargingTracker()), new BatteryNotLowController(trackers.getBatteryNotLowTracker()), new StorageNotLowController(trackers.getStorageNotLowTracker()), new NetworkConnectedController(trackers.getNetworkStateTracker()), new NetworkUnmeteredController(trackers.getNetworkStateTracker()), new NetworkNotRoamingController(trackers.getNetworkStateTracker()), new NetworkMeteredController(trackers.getNetworkStateTracker()), Build.VERSION.SDK_INT >= 28 ? WorkConstraintsTrackerKt.NetworkRequestConstraintController(trackers.getContext()) : null}));
        trackers.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence areAllConstraintsMet$lambda$5(ConstraintController constraintController) {
        constraintController.getClass();
        return constraintController.getClass().getSimpleName();
    }

    public final boolean areAllConstraintsMet(WorkSpec workSpec) {
        workSpec.getClass();
        List<ConstraintController> list = this.controllers;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ConstraintController) obj).isCurrentlyConstrained(workSpec)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            Logger.get().debug(WorkConstraintsTrackerKt.TAG, "Work " + workSpec.id + " constrained by " + l.h0(arrayList, null, null, null, new q(6), 31));
        }
        return arrayList.isEmpty();
    }

    public final h track(WorkSpec workSpec) {
        workSpec.getClass();
        List<ConstraintController> list = this.controllers;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ConstraintController) obj).hasConstraint(workSpec)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(n.V(arrayList, 10));
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj2 = arrayList.get(i10);
            i10++;
            arrayList2.add(((ConstraintController) obj2).track(workSpec.constraints));
        }
        final h[] hVarArr = (h[]) l.r0(arrayList2).toArray(new h[0]);
        return i0.g(new h() { // from class: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1

            /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
            @e(c = "androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3", f = "WorkConstraintsTracker.kt", l = {288}, m = "invokeSuspend")
            /* renamed from: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3, reason: invalid class name */
            public static final class AnonymousClass3 extends i implements g7.q {
                private /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                int label;

                public AnonymousClass3(w6.c cVar) {
                    super(3, cVar);
                }

                @Override // g7.q
                public final Object invoke(u7.i iVar, ConstraintsState[] constraintsStateArr, w6.c cVar) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(cVar);
                    anonymousClass3.L$0 = iVar;
                    anonymousClass3.L$1 = constraintsStateArr;
                    return anonymousClass3.invokeSuspend(w.f12711a);
                }

                @Override // y6.a
                public final Object invokeSuspend(Object obj) {
                    ConstraintsState constraintsState;
                    int i10 = this.label;
                    if (i10 == 0) {
                        s6.a.e(obj);
                        u7.i iVar = (u7.i) this.L$0;
                        ConstraintsState[] constraintsStateArr = (ConstraintsState[]) ((Object[]) this.L$1);
                        int length = constraintsStateArr.length;
                        int i11 = 0;
                        while (true) {
                            if (i11 >= length) {
                                constraintsState = null;
                                break;
                            }
                            constraintsState = constraintsStateArr[i11];
                            if (!kotlin.jvm.internal.l.a(constraintsState, ConstraintsState.ConstraintsMet.INSTANCE)) {
                                break;
                            }
                            i11++;
                        }
                        if (constraintsState == null) {
                            constraintsState = ConstraintsState.ConstraintsMet.INSTANCE;
                        }
                        this.label = 1;
                        Object objEmit = iVar.emit(constraintsState, this);
                        x6.a aVar = x6.a.f13718a;
                        if (objEmit == aVar) {
                            return aVar;
                        }
                    } else {
                        if (i10 != 1) {
                            androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        s6.a.e(obj);
                    }
                    return w.f12711a;
                }
            }

            /* JADX WARN: Type inference failed for: r2v0, types: [androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$2] */
            @Override // u7.h
            public Object collect(u7.i iVar, w6.c cVar) throws Throwable {
                final h[] hVarArr2 = hVarArr;
                g gVar = new g(hVarArr2, new g7.a() { // from class: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1.2
                    @Override // g7.a
                    public final ConstraintsState[] invoke() {
                        return new ConstraintsState[hVarArr2.length];
                    }
                }, new AnonymousClass3(null), iVar, null);
                p1 p1Var = new p1(cVar.getContext(), cVar, 1);
                Object objU = t1.U(p1Var, p1Var, gVar);
                w wVar = w.f12711a;
                x6.a aVar = x6.a.f13718a;
                if (objU != aVar) {
                    objU = wVar;
                }
                return objU == aVar ? objU : wVar;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WorkConstraintsTracker(List<? extends ConstraintController> list) {
        list.getClass();
        this.controllers = list;
    }
}

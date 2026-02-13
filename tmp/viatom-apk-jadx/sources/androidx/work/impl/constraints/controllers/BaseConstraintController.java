package androidx.work.impl.constraints.controllers;

import androidx.work.Constraints;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.controllers.BaseConstraintController;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import g7.p;
import s6.w;
import t7.r;
import t7.s;
import u7.h;
import u7.i0;
import w6.c;
import y6.e;
import y6.i;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class BaseConstraintController<T> implements ConstraintController {
    private final ConstraintTracker<T> tracker;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.work.impl.constraints.controllers.BaseConstraintController$track$1", f = "ContraintControllers.kt", l = {63}, m = "invokeSuspend")
    /* renamed from: androidx.work.impl.constraints.controllers.BaseConstraintController$track$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BaseConstraintController<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(BaseConstraintController<T> baseConstraintController, c cVar) {
            super(2, cVar);
            this.this$0 = baseConstraintController;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final w invokeSuspend$lambda$0(BaseConstraintController baseConstraintController, BaseConstraintController$track$1$listener$1 baseConstraintController$track$1$listener$1) {
            baseConstraintController.tracker.removeListener(baseConstraintController$track$1$listener$1);
            return w.f12711a;
        }

        @Override // y6.a
        public final c create(Object obj, c cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // g7.p
        public final Object invoke(s sVar, c cVar) {
            return ((AnonymousClass1) create(sVar, cVar)).invokeSuspend(w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            if (i10 == 0) {
                s6.a.e(obj);
                final s sVar = (s) this.L$0;
                final BaseConstraintController<T> baseConstraintController = this.this$0;
                final ConstraintListener<T> constraintListener = new ConstraintListener<T>() { // from class: androidx.work.impl.constraints.controllers.BaseConstraintController$track$1$listener$1
                    @Override // androidx.work.impl.constraints.ConstraintListener
                    public void onConstraintChanged(T t) {
                        Object constraintsNotMet = baseConstraintController.isConstrained(t) ? new ConstraintsState.ConstraintsNotMet(baseConstraintController.getReason()) : ConstraintsState.ConstraintsMet.INSTANCE;
                        r rVar = (r) sVar;
                        rVar.getClass();
                        rVar.q(constraintsNotMet);
                    }
                };
                ((BaseConstraintController) this.this$0).tracker.addListener(constraintListener);
                final BaseConstraintController<T> baseConstraintController2 = this.this$0;
                g7.a aVar = new g7.a() { // from class: androidx.work.impl.constraints.controllers.a
                    @Override // g7.a
                    public final Object invoke() {
                        return BaseConstraintController.AnonymousClass1.invokeSuspend$lambda$0(baseConstraintController2, constraintListener);
                    }
                };
                this.label = 1;
                Object objH = t1.h(sVar, aVar, this);
                x6.a aVar2 = x6.a.f13718a;
                if (objH == aVar2) {
                    return aVar2;
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

    public BaseConstraintController(ConstraintTracker<T> constraintTracker) {
        constraintTracker.getClass();
        this.tracker = constraintTracker;
    }

    public abstract int getReason();

    public boolean isConstrained(T t) {
        return false;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean isCurrentlyConstrained(WorkSpec workSpec) {
        workSpec.getClass();
        return hasConstraint(workSpec) && isConstrained(this.tracker.readSystemState());
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public h track(Constraints constraints) {
        constraints.getClass();
        return i0.d(new AnonymousClass1(this, null));
    }

    public static /* synthetic */ void getReason$annotations() {
    }
}

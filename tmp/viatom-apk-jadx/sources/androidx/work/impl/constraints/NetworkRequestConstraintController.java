package androidx.work.impl.constraints;

import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.work.Constraints;
import androidx.work.impl.constraints.NetworkRequestConstraintController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.model.WorkSpec;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import g7.l;
import g7.p;
import kotlin.jvm.internal.g;
import r7.a1;
import r7.o1;
import r7.y;
import s6.w;
import t7.r;
import t7.s;
import u7.h;
import u7.i0;
import y6.e;
import y6.i;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresApi(28)
/* loaded from: classes.dex */
public final class NetworkRequestConstraintController implements ConstraintController {
    private final ConnectivityManager connManager;
    private final long timeoutMs;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.work.impl.constraints.NetworkRequestConstraintController$track$1", f = "WorkConstraintsTracker.kt", l = {SubsamplingScaleImageView.ORIENTATION_180}, m = "invokeSuspend")
    /* renamed from: androidx.work.impl.constraints.NetworkRequestConstraintController$track$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ Constraints $constraints;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ NetworkRequestConstraintController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Constraints constraints, NetworkRequestConstraintController networkRequestConstraintController, w6.c cVar) {
            super(2, cVar);
            this.$constraints = constraints;
            this.this$0 = networkRequestConstraintController;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final w invokeSuspend$lambda$0(a1 a1Var, s sVar, ConstraintsState constraintsState) {
            a1Var.a(null);
            ((r) sVar).q(constraintsState);
            return w.f12711a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final w invokeSuspend$lambda$1(g7.a aVar) {
            aVar.invoke();
            return w.f12711a;
        }

        @Override // y6.a
        public final w6.c create(Object obj, w6.c cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$constraints, this.this$0, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // g7.p
        public final Object invoke(s sVar, w6.c cVar) {
            return ((AnonymousClass1) create(sVar, cVar)).invokeSuspend(w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            w wVar = w.f12711a;
            if (i10 != 0) {
                if (i10 == 1) {
                    s6.a.e(obj);
                    return wVar;
                }
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
            final s sVar = (s) this.L$0;
            NetworkRequest requiredNetworkRequest = this.$constraints.getRequiredNetworkRequest();
            if (requiredNetworkRequest == null) {
                r rVar = (r) sVar;
                rVar.getClass();
                rVar.k(null);
                return wVar;
            }
            final o1 o1VarQ = y.q(sVar, null, null, new NetworkRequestConstraintController$track$1$timeoutJob$1(this.this$0, sVar, null), 3);
            l lVar = new l() { // from class: androidx.work.impl.constraints.b
                @Override // g7.l
                public final Object invoke(Object obj2) {
                    return NetworkRequestConstraintController.AnonymousClass1.invokeSuspend$lambda$0(o1VarQ, sVar, (ConstraintsState) obj2);
                }
            };
            final g7.a aVarAddCallback = Build.VERSION.SDK_INT >= 30 ? SharedNetworkCallback.INSTANCE.addCallback(this.this$0.connManager, requiredNetworkRequest, lVar) : IndividualNetworkCallback.Companion.addCallback(this.this$0.connManager, requiredNetworkRequest, lVar);
            g7.a aVar = new g7.a() { // from class: androidx.work.impl.constraints.c
                @Override // g7.a
                public final Object invoke() {
                    return NetworkRequestConstraintController.AnonymousClass1.invokeSuspend$lambda$1(aVarAddCallback);
                }
            };
            this.label = 1;
            Object objH = t1.h(sVar, aVar, this);
            x6.a aVar2 = x6.a.f13718a;
            return objH == aVar2 ? aVar2 : wVar;
        }
    }

    public NetworkRequestConstraintController(ConnectivityManager connectivityManager, long j10) {
        connectivityManager.getClass();
        this.connManager = connectivityManager;
        this.timeoutMs = j10;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean hasConstraint(WorkSpec workSpec) {
        workSpec.getClass();
        return workSpec.constraints.getRequiredNetworkRequest() != null;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean isCurrentlyConstrained(WorkSpec workSpec) {
        workSpec.getClass();
        if (!hasConstraint(workSpec)) {
            return false;
        }
        androidx.window.layout.c.g("isCurrentlyConstrained() must never be called onNetworkRequestConstraintController. isCurrentlyConstrained() is called only on older platforms where NetworkRequest isn't supported");
        return false;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public h track(Constraints constraints) {
        constraints.getClass();
        return i0.d(new AnonymousClass1(constraints, this, null));
    }

    public /* synthetic */ NetworkRequestConstraintController(ConnectivityManager connectivityManager, long j10, int i10, g gVar) {
        this(connectivityManager, (i10 & 2) != 0 ? 1000L : j10);
    }
}

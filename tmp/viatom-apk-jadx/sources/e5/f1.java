package e5;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f1 implements g5.m {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h1 f7746a;

    public /* synthetic */ f1(h1 h1Var) {
        this.f7746a = h1Var;
    }

    @Override // g5.m
    public void f(h5.h hVar) {
        h1 h1Var = this.f7746a;
        if (h1Var.getActivity() instanceof MainActivity) {
            long j10 = hVar.f8566a;
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(h1Var);
            y7.e eVar = r7.i0.f12407a;
            r7.y.q(lifecycleScope, y7.d.f14116a, null, new g1(h1Var, j10, "impress", (w6.c) null, 0), 2);
        }
    }
}

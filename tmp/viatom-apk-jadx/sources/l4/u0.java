package l4;

import androidx.lifecycle.ViewModel;
import com.uptodown.activities.FreeUpSpaceActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.RollbackActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10864a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f10865b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewModel f10866c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w f10867d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u0(boolean z9, ViewModel viewModel, w wVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10864a = i10;
        this.f10865b = z9;
        this.f10866c = viewModel;
        this.f10867d = wVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10864a) {
            case 0:
                return new u0(this.f10865b, (v0) this.f10866c, (FreeUpSpaceActivity) this.f10867d, cVar, 0);
            case 1:
                return new u0(this.f10865b, (c4) this.f10866c, (MyApps) this.f10867d, cVar, 1);
            default:
                return new u0(this.f10865b, (p8) this.f10866c, (RollbackActivity) this.f10867d, cVar, 2);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10864a) {
            case 0:
                u0 u0Var = (u0) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                u0Var.invokeSuspend(wVar2);
                return wVar2;
            case 1:
                u0 u0Var2 = (u0) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                u0Var2.invokeSuspend(wVar3);
                return wVar3;
            default:
                u0 u0Var3 = (u0) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                u0Var3.invokeSuspend(wVar4);
                return wVar4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0282 A[LOOP:4: B:101:0x0248->B:114:0x0282, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x028a A[SYNTHETIC] */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 846
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.u0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

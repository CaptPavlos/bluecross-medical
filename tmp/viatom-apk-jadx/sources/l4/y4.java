package l4;

import androidx.lifecycle.ViewModelKt;
import com.uptodown.R;
import com.uptodown.activities.NotificationsRegistryActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y4 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11022a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NotificationsRegistryActivity f11023b;

    /* renamed from: c, reason: collision with root package name */
    public int f11024c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y4(NotificationsRegistryActivity notificationsRegistryActivity, int i10, w6.c cVar, int i11) {
        super(2, cVar);
        this.f11022a = i11;
        this.f11023b = notificationsRegistryActivity;
        this.f11024c = i10;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f11022a) {
            case 0:
                return new y4(this.f11023b, cVar);
            case 1:
                return new y4(this.f11023b, this.f11024c, cVar, 1);
            default:
                return new y4(this.f11023b, this.f11024c, cVar, 2);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f11022a) {
            case 0:
                ((y4) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
                return x6.a.f13718a;
            case 1:
                y4 y4Var = (y4) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                y4Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                y4 y4Var2 = (y4) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                y4Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f11022a;
        s6.w wVar = s6.w.f12711a;
        NotificationsRegistryActivity notificationsRegistryActivity = this.f11023b;
        switch (i10) {
            case 0:
                int i11 = this.f11024c;
                if (i11 != 0) {
                    if (i11 == 1) {
                        throw androidx.constraintlayout.core.widgets.analyzer.a.q(obj);
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                int i12 = NotificationsRegistryActivity.M;
                u7.m0 m0Var = notificationsRegistryActivity.q0().f10360b;
                a3.f1 f1Var = new a3.f1(notificationsRegistryActivity, 8);
                this.f11024c = 1;
                m0Var.collect(f1Var, this);
                return x6.a.f13718a;
            case 1:
                s6.a.e(obj);
                String str = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault()).format(new Long(System.currentTimeMillis()));
                str.getClass();
                int i13 = NotificationsRegistryActivity.M;
                NotificationsRegistryActivity notificationsRegistryActivity2 = this.f11023b;
                e5 e5VarQ0 = notificationsRegistryActivity2.q0();
                n4.q qVar = notificationsRegistryActivity2.K;
                qVar.getClass();
                ArrayList arrayList = qVar.f11460a;
                int i14 = this.f11024c;
                Object obj2 = arrayList.get(i14);
                obj2.getClass();
                h5.b0 b0Var = (h5.b0) obj2;
                e5VarQ0.getClass();
                r7.w viewModelScope = ViewModelKt.getViewModelScope(e5VarQ0);
                y7.e eVar = r7.i0.f12407a;
                r7.y.q(viewModelScope, y7.d.f14116a, null, new c5.m(notificationsRegistryActivity2, b0Var, str, null, 11), 2);
                n4.q qVar2 = notificationsRegistryActivity2.K;
                qVar2.getClass();
                ((h5.b0) qVar2.f11460a.get(i14)).f8475d = notificationsRegistryActivity2.getString(R.string.file_deleted_notification, str);
                n4.q qVar3 = notificationsRegistryActivity2.K;
                qVar3.getClass();
                ((h5.b0) qVar3.f11460a.get(i14)).e = "no_action";
                return wVar;
            default:
                s6.a.e(obj);
                n4.q qVar4 = notificationsRegistryActivity.K;
                qVar4.getClass();
                qVar4.notifyItemChanged(this.f11024c);
                return wVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y4(NotificationsRegistryActivity notificationsRegistryActivity, w6.c cVar) {
        super(2, cVar);
        this.f11022a = 0;
        this.f11023b = notificationsRegistryActivity;
    }
}

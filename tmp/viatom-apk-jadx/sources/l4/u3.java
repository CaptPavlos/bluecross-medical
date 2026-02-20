package l4;

import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u3 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10872a = 1;

    /* renamed from: b, reason: collision with root package name */
    public int f10873b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a4 f10874c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u3(int i10, a4 a4Var, w6.c cVar) {
        super(2, cVar);
        this.f10873b = i10;
        this.f10874c = a4Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10872a) {
            case 0:
                return new u3(this.f10874c, cVar);
            default:
                return new u3(this.f10873b, this.f10874c, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10872a) {
            case 0:
                return ((u3) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            default:
                u3 u3Var = (u3) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                u3Var.invokeSuspend(wVar2);
                return wVar2;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f10872a) {
            case 0:
                int i10 = this.f10873b;
                if (i10 == 0) {
                    s6.a.e(obj);
                    a4 a4Var = this.f10874c;
                    a3.x xVar = new a3.x(a4Var, new t3(a4Var));
                    this.f10873b = 1;
                    Object objB = xVar.B(this);
                    x6.a aVar = x6.a.f13718a;
                    if (objB == aVar) {
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
            default:
                s6.a.e(obj);
                int i11 = this.f10873b;
                a4 a4Var2 = this.f10874c;
                switch (i11) {
                    case 106:
                        d5.d0 d0Var = a4Var2.P;
                        if (d0Var == null) {
                            kotlin.jvm.internal.l.i("dialogBinding");
                            throw null;
                        }
                        d0Var.f6978u.setText(a4Var2.getString(R.string.action_update));
                        break;
                    case 107:
                        d5.d0 d0Var2 = a4Var2.P;
                        if (d0Var2 == null) {
                            kotlin.jvm.internal.l.i("dialogBinding");
                            throw null;
                        }
                        d0Var2.f6978u.setText(a4Var2.getString(R.string.action_cancel_download));
                        break;
                    case 108:
                        d5.d0 d0Var3 = a4Var2.P;
                        if (d0Var3 == null) {
                            kotlin.jvm.internal.l.i("dialogBinding");
                            throw null;
                        }
                        d0Var3.f6978u.setText(a4Var2.getString(R.string.notification_msg_update_uptodown));
                        break;
                }
                return s6.w.f12711a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u3(a4 a4Var, w6.c cVar) {
        super(2, cVar);
        this.f10874c = a4Var;
    }
}

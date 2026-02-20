package l4;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a2 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10208a;

    /* renamed from: b, reason: collision with root package name */
    public com.google.android.gms.internal.measurement.j4 f10209b;

    /* renamed from: c, reason: collision with root package name */
    public int f10210c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ GoogleSignInAccount f10211d;
    public final /* synthetic */ b2 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a2(GoogleSignInAccount googleSignInAccount, b2 b2Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10208a = i10;
        this.f10211d = googleSignInAccount;
        this.e = b2Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10208a) {
            case 0:
                return new a2(this.f10211d, this.e, cVar, 0);
            default:
                return new a2(this.f10211d, this.e, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10208a) {
        }
        return ((a2) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        com.google.android.gms.internal.measurement.j4 j4Var;
        com.google.android.gms.internal.measurement.j4 j4Var2;
        s7.c cVar;
        z1 z1Var;
        com.google.android.gms.internal.measurement.j4 j4Var3;
        com.google.android.gms.internal.measurement.j4 j4Var4;
        s7.c cVar2;
        z1 z1Var2;
        int i10 = this.f10208a;
        s6.w wVar = s6.w.f12711a;
        x6.a aVar = x6.a.f13718a;
        GoogleSignInAccount googleSignInAccount = this.f10211d;
        b2 b2Var = this.e;
        switch (i10) {
            case 0:
                String str = googleSignInAccount.f1825c;
                int i11 = this.f10210c;
                if (i11 == 0) {
                    s6.a.e(obj);
                    j4Var = new com.google.android.gms.internal.measurement.j4();
                    y7.e eVar = r7.i0.f12407a;
                    s7.c cVar3 = w7.n.f13548a;
                    a6.n nVar = new a6.n(b2Var, null, 19);
                    this.f10209b = j4Var;
                    this.f10210c = 1;
                    if (r7.y.z(nVar, cVar3, this) != aVar) {
                    }
                } else if (i11 == 1) {
                    com.google.android.gms.internal.measurement.j4 j4Var5 = this.f10209b;
                    s6.a.e(obj);
                    j4Var = j4Var5;
                } else if (i11 == 2) {
                    j4Var2 = this.f10209b;
                    s6.a.e(obj);
                    j4Var = j4Var2;
                    y7.e eVar2 = r7.i0.f12407a;
                    cVar = w7.n.f13548a;
                    z1Var = new z1(j4Var, b2Var, null, 0);
                    this.f10209b = null;
                    this.f10210c = 3;
                    if (r7.y.z(z1Var, cVar, this) != aVar) {
                    }
                    break;
                } else if (i11 != 3) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                    break;
                }
                if (str == null || str.length() == 0) {
                    y7.e eVar22 = r7.i0.f12407a;
                    cVar = w7.n.f13548a;
                    z1Var = new z1(j4Var, b2Var, null, 0);
                    this.f10209b = null;
                    this.f10210c = 3;
                    if (r7.y.z(z1Var, cVar, this) != aVar) {
                    }
                } else {
                    str.getClass();
                    this.f10209b = j4Var;
                    this.f10210c = 2;
                    if (j4Var.l(str, b2Var, this) != aVar) {
                        j4Var2 = j4Var;
                        j4Var = j4Var2;
                        y7.e eVar222 = r7.i0.f12407a;
                        cVar = w7.n.f13548a;
                        z1Var = new z1(j4Var, b2Var, null, 0);
                        this.f10209b = null;
                        this.f10210c = 3;
                        if (r7.y.z(z1Var, cVar, this) != aVar) {
                        }
                    }
                }
                break;
            default:
                String str2 = googleSignInAccount.f1825c;
                int i12 = this.f10210c;
                if (i12 == 0) {
                    s6.a.e(obj);
                    j4Var3 = new com.google.android.gms.internal.measurement.j4();
                    if (str2 == null || str2.length() == 0) {
                        y7.e eVar3 = r7.i0.f12407a;
                        cVar2 = w7.n.f13548a;
                        z1Var2 = new z1(j4Var3, b2Var, null, 1);
                        this.f10209b = null;
                        this.f10210c = 2;
                        if (r7.y.z(z1Var2, cVar2, this) != aVar) {
                        }
                    } else {
                        str2.getClass();
                        this.f10209b = j4Var3;
                        this.f10210c = 1;
                        if (j4Var3.l(str2, b2Var, this) != aVar) {
                            j4Var4 = j4Var3;
                        }
                    }
                    break;
                } else if (i12 == 1) {
                    j4Var4 = this.f10209b;
                    s6.a.e(obj);
                } else if (i12 != 2) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                    break;
                }
                j4Var3 = j4Var4;
                y7.e eVar32 = r7.i0.f12407a;
                cVar2 = w7.n.f13548a;
                z1Var2 = new z1(j4Var3, b2Var, null, 1);
                this.f10209b = null;
                this.f10210c = 2;
                if (r7.y.z(z1Var2, cVar2, this) != aVar) {
                }
                break;
        }
        return aVar;
    }
}

package l4;

import android.content.Context;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x7 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10993a;

    /* renamed from: b, reason: collision with root package name */
    public int f10994b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f10995c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f10996d;
    public final /* synthetic */ y7 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x7(Context context, String str, y7 y7Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10993a = i10;
        this.f10995c = context;
        this.f10996d = str;
        this.e = y7Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10993a) {
            case 0:
                return new x7(this.f10995c, this.f10996d, this.e, cVar, 0);
            default:
                return new x7(this.f10995c, this.f10996d, this.e, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10993a) {
        }
        return ((x7) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f10993a) {
            case 0:
                int i10 = this.f10994b;
                if (i10 == 0) {
                    s6.a.e(obj);
                    this.f10994b = 1;
                    obj = h5.e1.f8511q.d(this.f10995c, this.f10996d, this);
                    x6.a aVar = x6.a.f13718a;
                    if (obj == aVar) {
                        break;
                    }
                } else if (i10 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                u7.m0 m0Var = this.e.f11035i;
                v5.l lVar = new v5.l((h5.d1) obj);
                m0Var.getClass();
                m0Var.g(null, lVar);
                break;
            default:
                int i11 = this.f10994b;
                if (i11 == 0) {
                    s6.a.e(obj);
                    this.f10994b = 1;
                    obj = h5.e1.f8511q.i(this.f10995c, this.f10996d, this);
                    x6.a aVar2 = x6.a.f13718a;
                    if (obj == aVar2) {
                        break;
                    }
                } else if (i11 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                u7.m0 m0Var2 = this.e.f11035i;
                v5.l lVar2 = new v5.l((h5.d1) obj);
                m0Var2.getClass();
                m0Var2.g(null, lVar2);
                break;
        }
        return s6.w.f12711a;
    }
}

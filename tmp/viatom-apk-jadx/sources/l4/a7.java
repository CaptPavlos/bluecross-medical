package l4;

import android.content.Context;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a7 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10219a;

    /* renamed from: b, reason: collision with root package name */
    public int f10220b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f10221c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f10222d;
    public final /* synthetic */ c7 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a7(Context context, String str, c7 c7Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10219a = i10;
        this.f10221c = context;
        this.f10222d = str;
        this.e = c7Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10219a) {
            case 0:
                return new a7(this.f10221c, this.f10222d, this.e, cVar, 0);
            default:
                return new a7(this.f10221c, this.f10222d, this.e, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10219a) {
        }
        return ((a7) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f10219a) {
            case 0:
                int i10 = this.f10220b;
                if (i10 == 0) {
                    s6.a.e(obj);
                    this.f10220b = 1;
                    obj = h5.e1.f8511q.d(this.f10221c, this.f10222d, this);
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
                h5.d1 d1Var = (h5.d1) obj;
                int i11 = d1Var.f8505d;
                c7 c7Var = this.e;
                if (i11 == 1) {
                    c7Var.f10298i++;
                }
                u7.m0 m0Var = c7Var.g;
                v5.l lVar = new v5.l(d1Var);
                m0Var.getClass();
                m0Var.g(null, lVar);
                break;
            default:
                int i12 = this.f10220b;
                if (i12 == 0) {
                    s6.a.e(obj);
                    this.f10220b = 1;
                    obj = h5.e1.f8511q.i(this.f10221c, this.f10222d, this);
                    x6.a aVar2 = x6.a.f13718a;
                    if (obj == aVar2) {
                        break;
                    }
                } else if (i12 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                h5.d1 d1Var2 = (h5.d1) obj;
                int i13 = d1Var2.f8505d;
                c7 c7Var2 = this.e;
                if (i13 == 0) {
                    c7Var2.f10298i--;
                }
                u7.m0 m0Var2 = c7Var2.g;
                v5.l lVar2 = new v5.l(d1Var2);
                m0Var2.getClass();
                m0Var2.g(null, lVar2);
                break;
        }
        return s6.w.f12711a;
    }
}

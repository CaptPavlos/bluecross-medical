package l4;

import android.content.Context;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w7 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public int f10956a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y7 f10957b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f10958c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f10959d;
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w7(y7 y7Var, Context context, long j10, int i10, w6.c cVar) {
        super(2, cVar);
        this.f10957b = y7Var;
        this.f10958c = context;
        this.f10959d = j10;
        this.e = i10;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new w7(this.f10957b, this.f10958c, this.f10959d, this.e, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((w7) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i10 = this.f10956a;
        y7 y7Var = this.f10957b;
        if (i10 == 0) {
            s6.a.e(obj);
            this.f10956a = 1;
            y7.e eVar = r7.i0.f12407a;
            obj = r7.y.z(new c5.e0(y7Var, this.f10958c, this.f10959d, this.e, (w6.c) null), y7.d.f14116a, this);
            x6.a aVar = x6.a.f13718a;
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i10 != 1) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
        }
        ArrayList arrayList = (ArrayList) obj;
        boolean zIsEmpty = arrayList.isEmpty();
        u7.m0 m0Var = y7Var.f11031a;
        if (zIsEmpty) {
            m0Var.getClass();
            m0Var.g(null, v5.k.f13167a);
        } else {
            v5.l lVar = new v5.l(new u7(arrayList, true));
            m0Var.getClass();
            m0Var.g(null, lVar);
        }
        return s6.w.f12711a;
    }
}

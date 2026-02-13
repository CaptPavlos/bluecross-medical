package k9;

import b9.h;
import b9.k;
import g7.p;
import j.e;
import j.g;
import java.util.ArrayList;
import s6.w;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public int f10117a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f10118b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f10119c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, boolean z9, w6.c cVar) {
        super(2, cVar);
        this.f10118b = dVar;
        this.f10119c = z9;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new c(this.f10118b, this.f10119c, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        return new c(this.f10118b, this.f10119c, (w6.c) obj2).invokeSuspend(w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        ArrayList arrayList;
        int i10 = this.f10117a;
        if (i10 == 0) {
            s6.a.e(obj);
            d dVar = this.f10118b;
            h hVar = dVar.e;
            Boolean boolValueOf = Boolean.valueOf(!this.f10119c);
            String strT = dVar.f10120a.t(37);
            Boolean bool = Boolean.TRUE;
            this.f10117a = 1;
            hVar.getClass();
            d0.i iVar = (d0.i) hVar.f;
            ArrayList arrayList2 = (ArrayList) hVar.h;
            String str = boolValueOf.equals(bool) ? "All" : "Reject";
            String str2 = boolValueOf.equals(bool) ? "none" : "all";
            String strE = g.e();
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            if (g.f9878a) {
                arrayList = new ArrayList();
                g.f9879b.forEach(new e(arrayList, 0));
            } else {
                arrayList = null;
            }
            k kVar = new k(arrayList3, str, str2, null, null, null, null, null, strT, strE, arrayList, null, 2296);
            if (bool.equals(bool)) {
                iVar.q(78, true);
            }
            if (strE == null) {
                strE = "";
            }
            iVar.p(93, strE);
            arrayList2.clear();
            Object objB = hVar.b(3, kVar, b9.d.CCPA, this);
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
        return w.f12711a;
    }
}

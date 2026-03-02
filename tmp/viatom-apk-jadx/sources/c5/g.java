package c5;

import android.content.Context;
import c1.w4;
import java.util.ArrayList;
import l4.p2;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1683a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1684b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1685c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1686d;
    public int e;
    public Object f;
    public Object g;
    public final /* synthetic */ Object h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, ArrayList arrayList, v5.a aVar, w6.c cVar) {
        super(2, cVar);
        this.f1683a = 3;
        this.f = context;
        this.h = arrayList;
        this.g = aVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1683a) {
            case 0:
                g gVar = new g((w2.r) this.h, (w4) this.g, cVar, 0);
                gVar.f = obj;
                return gVar;
            case 1:
                g gVar2 = new g((t) this.h, (w4) this.g, cVar, 1);
                gVar2.f = obj;
                return gVar2;
            case 2:
                return new g((p2) this.h, cVar);
            default:
                return new g((Context) this.f, (ArrayList) this.h, (v5.a) this.g, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1683a) {
        }
        return ((g) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0153, code lost:
    
        if (r6 == r5) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x022b A[PHI: r1
      0x022b: PHI (r1v19 r7.b0) = (r1v18 r7.b0), (r1v26 r7.b0) binds: [B:63:0x0228, B:52:0x01aa] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02df A[PHI: r1
      0x02df: PHI (r1v6 r7.b0) = (r1v5 r7.b0), (r1v13 r7.b0) binds: [B:88:0x02dc, B:77:0x025e] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 764
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c5.g.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(Object obj, w4 w4Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1683a = i10;
        this.h = obj;
        this.g = w4Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(p2 p2Var, w6.c cVar) {
        super(2, cVar);
        this.f1683a = 2;
        this.h = p2Var;
    }
}

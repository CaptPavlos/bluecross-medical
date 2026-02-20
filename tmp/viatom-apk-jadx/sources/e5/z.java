package e5;

import android.content.Context;
import java.io.Serializable;
import java.util.ArrayList;
import l4.p2;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7912a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f7913b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7914c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f7915d;
    public final /* synthetic */ Serializable e;
    public final /* synthetic */ Serializable f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(j0 j0Var, Context context, kotlin.jvm.internal.x xVar, kotlin.jvm.internal.u uVar, kotlin.jvm.internal.u uVar2, w6.c cVar) {
        super(2, cVar);
        this.f7914c = j0Var;
        this.f7915d = context;
        this.f7913b = xVar;
        this.e = uVar;
        this.f = uVar2;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f7912a) {
            case 0:
                return new z((j0) this.f7914c, (Context) this.f7915d, this.f7913b, (kotlin.jvm.internal.u) this.e, (kotlin.jvm.internal.u) this.f, cVar);
            default:
                return new z((p2) this.f7914c, this.f7913b, (kotlin.jvm.internal.x) this.f7915d, (ArrayList) this.e, (kotlin.jvm.internal.v) this.f, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f7912a) {
            case 0:
                z zVar = (z) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                zVar.invokeSuspend(wVar2);
                return wVar2;
            default:
                z zVar2 = (z) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                zVar2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:159:0x047f  */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 1398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e5.z.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(p2 p2Var, kotlin.jvm.internal.x xVar, kotlin.jvm.internal.x xVar2, ArrayList arrayList, kotlin.jvm.internal.v vVar, w6.c cVar) {
        super(2, cVar);
        this.f7914c = p2Var;
        this.f7913b = xVar;
        this.f7915d = xVar2;
        this.e = arrayList;
        this.f = vVar;
    }
}

package l4;

import android.content.res.Resources;
import com.uptodown.activities.MoreInfo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e3 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10354a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f10355b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MoreInfo f10356c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e3(MoreInfo moreInfo, kotlin.jvm.internal.x xVar, w6.c cVar) {
        super(2, cVar);
        this.f10356c = moreInfo;
        this.f10355b = xVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10354a) {
            case 0:
                return new e3(this.f10356c, this.f10355b, cVar);
            default:
                return new e3(this.f10355b, this.f10356c, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10354a) {
            case 0:
                e3 e3Var = (e3) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                e3Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                e3 e3Var2 = (e3) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                e3Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c6  */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 454
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.e3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e3(kotlin.jvm.internal.x xVar, MoreInfo moreInfo, w6.c cVar) {
        super(2, cVar);
        this.f10355b = xVar;
        this.f10356c = moreInfo;
    }
}

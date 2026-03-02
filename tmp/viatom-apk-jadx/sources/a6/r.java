package a6;

import c1.g1;
import com.uptodown.workers.PreRegisterWorker;
import h5.g0;
import java.util.ArrayList;
import r7.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f286a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f287b;

    /* renamed from: c, reason: collision with root package name */
    public int f288c;

    /* renamed from: d, reason: collision with root package name */
    public Object f289d;
    public Object e;
    public Object f;
    public final /* synthetic */ Object g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(int i10, PreRegisterWorker preRegisterWorker, h5.h hVar, g0 g0Var, String str, w6.c cVar) {
        super(2, cVar);
        this.f289d = preRegisterWorker;
        this.e = str;
        this.f = g0Var;
        this.g = hVar;
        this.f288c = i10;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f286a) {
            case 0:
                PreRegisterWorker preRegisterWorker = (PreRegisterWorker) this.f289d;
                String str = (String) this.e;
                g0 g0Var = (g0) this.f;
                return new r(this.f288c, preRegisterWorker, (h5.h) this.g, g0Var, str, cVar);
            case 1:
                return new r((ArrayList) this.f, (g1) this.g, cVar);
            default:
                return new r((s4.n) this.g, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w wVar = (w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f286a) {
        }
        return ((r) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:96|203|97|205|98|(11:106|(3:108|(5:111|199|112|113|109)|208)|116|(2:119|117)|209|120|(1:137)(8:122|(5:124|(1:126)|138|(1:171)(3:140|(2:142|(9:144|201|145|(1:147)(1:149)|(1:153)|(1:155)(1:156)|157|(1:160)|159)(3:161|(2:163|(2:165|(1:168)))|169))(1:170)|167)|(4:177|178|88|(1:179)(0)))|127|(5:129|(2:131|(1:133)(1:135))|138|(0)(0)|(0))|136|138|(0)(0)|(0))|134|138|(0)(0)|(0))(1:172)) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0294, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0298, code lost:
    
        r0.printStackTrace();
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x04bb, code lost:
    
        if (r7.y.z(r1, r0, r7) == r12) goto L181;
     */
    /* JADX WARN: Path cross not found for [B:124:0x0382, B:127:0x0397], limit reached: 205 */
    /* JADX WARN: Path cross not found for [B:129:0x039b, B:136:0x03c7], limit reached: 205 */
    /* JADX WARN: Removed duplicated region for block: B:106:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0289  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:177:0x0499 -> B:178:0x049c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0123 -> B:16:0x00ab). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0127 -> B:16:0x00ab). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x016a -> B:51:0x0171). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x016c -> B:51:0x0171). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x01c0 -> B:66:0x01c5). Please report as a decompilation issue!!! */
    @Override // y6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r32) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.r.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(ArrayList arrayList, g1 g1Var, w6.c cVar) {
        super(2, cVar);
        this.f = arrayList;
        this.g = g1Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(s4.n nVar, w6.c cVar) {
        super(2, cVar);
        this.g = nVar;
    }
}

package v7;

import kotlin.jvm.internal.a0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final w6.c[] f13177a = new w6.c[0];

    /* renamed from: b, reason: collision with root package name */
    public static final e2.a f13178b = new e2.a("NULL");

    /* renamed from: c, reason: collision with root package name */
    public static final e2.a f13179c = new e2.a("UNINITIALIZED");

    public static /* synthetic */ u7.h a(i iVar, w6.h hVar, int i10, t7.a aVar, int i11) {
        if ((i11 & 1) != 0) {
            hVar = w6.i.f13523a;
        }
        if ((i11 & 2) != 0) {
            i10 = -3;
        }
        if ((i11 & 4) != 0) {
            aVar = t7.a.f12813a;
        }
        return iVar.a(hVar, i10, aVar);
    }

    public static final Object b(w6.h hVar, Object obj, Object obj2, g7.p pVar, w6.c cVar) {
        Object objInvoke;
        Object objL = w7.a.l(hVar, obj2);
        try {
            p pVar2 = new p(cVar, hVar);
            if (com.mbridge.msdk.dycreator.baseview.a.w(pVar)) {
                a0.b(2, pVar);
                objInvoke = pVar.invoke(obj, pVar2);
            } else {
                objInvoke = r0.f.N(pVar, obj, pVar2);
            }
            w7.a.g(hVar, objL);
            if (objInvoke == x6.a.f13718a) {
                cVar.getClass();
            }
            return objInvoke;
        } catch (Throwable th) {
            w7.a.g(hVar, objL);
            throw th;
        }
    }
}

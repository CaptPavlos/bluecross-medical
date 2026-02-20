package c5;

import a3.q0;
import a3.z0;
import android.content.Context;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import l4.p2;
import l4.x4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public Context f1657a;

    public /* synthetic */ b0(Context context, boolean z9) {
        this.f1657a = context;
    }

    public p.j a() {
        Context context = this.f1657a;
        if (context == null) {
            throw new IllegalStateException(Context.class.getCanonicalName() + " must be set");
        }
        p.j jVar = new p.j();
        jVar.f11858a = r.a.a(p.l.f11864a);
        x4 x4Var = new x4(context, 18);
        jVar.f11859b = x4Var;
        jVar.f11860c = r.a.a(new i0.k(22, x4Var, new x4(x4Var, 17)));
        x4 x4Var2 = jVar.f11859b;
        jVar.f11861d = new q0(x4Var2, 1);
        p6.a aVarA = r.a.a(new t1.c(jVar.f11861d, r.a.a(new x4(x4Var2, 22)), 6, false));
        jVar.e = aVarA;
        t3.h hVar = new t3.h(1);
        x4 x4Var3 = jVar.f11859b;
        p2 p2Var = new p2(x4Var3, aVarA, hVar, 9);
        p6.a aVar = jVar.f11858a;
        p6.a aVar2 = jVar.f11860c;
        jVar.f = r.a.a(new p2(new z0(aVar, aVar2, p2Var, aVarA, aVarA), new c2.d(x4Var3, aVar2, aVarA, p2Var, aVar, aVarA, aVarA, 7), new w2.r(aVar, aVarA, p2Var, aVarA, 26), 7));
        return jVar;
    }

    public Object b(long j10, g5.u uVar, y6.i iVar) throws Throwable {
        y7.e eVar = r7.i0.f12407a;
        Object objZ = r7.y.z(new e0(this, j10, uVar, (w6.c) null, 3), y7.d.f14116a, iVar);
        return objZ == x6.a.f13718a ? objZ : s6.w.f12711a;
    }

    public void c() {
        new t1.c(this.f1657a, 4).e(com.mbridge.msdk.dycreator.baseview.a.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "failed"), "uptodown_services_init");
    }
}

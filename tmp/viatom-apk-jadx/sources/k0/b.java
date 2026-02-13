package k0;

import a4.f;
import c1.d0;
import com.google.android.gms.internal.measurement.h0;
import com.google.android.gms.internal.measurement.j4;
import d0.i;
import g0.d;
import h0.e;
import h0.u;
import h0.x;
import h1.p;
import i0.n;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends d {

    /* renamed from: k, reason: collision with root package name */
    public static final f f10037k = new f("ClientTelemetry.API", new b0.b(4), new d0(10));

    public final p b(n nVar) {
        y2.c cVar = new y2.c(13);
        f0.d[] dVarArr = {v0.b.f13117a};
        cVar.f13781b = new i(nVar, 19);
        j4 j4Var = new j4();
        j4Var.f2009c = cVar;
        j4Var.f2008b = dVarArr;
        j4Var.f2007a = false;
        h1.i iVar = new h1.i();
        e eVar = this.f8192j;
        eVar.getClass();
        u uVar = new u(new x(j4Var, iVar, this.f8191i), eVar.f8367i.get(), this);
        h0 h0Var = eVar.f8371m;
        h0Var.sendMessage(h0Var.obtainMessage(4, uVar));
        return iVar.f8418a;
    }
}

package h0;

import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.internal.measurement.h0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q extends g0.g {

    /* renamed from: b, reason: collision with root package name */
    public final g0.d f8397b;

    public q(g0.d dVar) {
        this.f8397b = dVar;
    }

    public final d0.g b(d0.g gVar) {
        boolean z9 = true;
        if (!gVar.f1867i && !((Boolean) BasePendingResult.f1862j.get()).booleanValue()) {
            z9 = false;
        }
        gVar.f1867i = z9;
        g0.d dVar = this.f8397b;
        e eVar = dVar.f8192j;
        eVar.getClass();
        u uVar = new u(new w(gVar), eVar.f8367i.get(), dVar);
        h0 h0Var = eVar.f8371m;
        h0Var.sendMessage(h0Var.obtainMessage(4, uVar));
        return gVar;
    }
}

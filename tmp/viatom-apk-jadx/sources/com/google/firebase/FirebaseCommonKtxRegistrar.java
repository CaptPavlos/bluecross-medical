package com.google.firebase;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import f9.p;
import java.util.List;
import java.util.concurrent.Executor;
import l1.h;
import p1.b;
import p1.c;
import p1.d;
import q1.a;
import q1.i;
import q1.q;
import r7.s;
import t6.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Keep
/* loaded from: classes3.dex */
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<a> getComponents() {
        p pVarB = a.b(new q(p1.a.class, s.class));
        pVarB.c(new i(new q(p1.a.class, Executor.class), 1, 0));
        pVarB.f = h.f10183b;
        a aVarD = pVarB.d();
        p pVarB2 = a.b(new q(c.class, s.class));
        pVarB2.c(new i(new q(c.class, Executor.class), 1, 0));
        pVarB2.f = h.f10184c;
        a aVarD2 = pVarB2.d();
        p pVarB3 = a.b(new q(b.class, s.class));
        pVarB3.c(new i(new q(b.class, Executor.class), 1, 0));
        pVarB3.f = h.f10185d;
        a aVarD3 = pVarB3.d();
        p pVarB4 = a.b(new q(d.class, s.class));
        pVarB4.c(new i(new q(d.class, Executor.class), 1, 0));
        pVarB4.f = h.e;
        return m.Q(aVarD, aVarD2, aVarD3, pVarB4.d());
    }
}

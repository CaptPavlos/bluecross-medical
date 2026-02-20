package com.google.firebase.installations;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import f9.p;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import l1.g;
import o2.e;
import o2.f;
import p1.a;
import p8.u;
import q1.b;
import q1.i;
import q1.q;
import r1.j;
import r2.c;
import r2.d;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Keep
/* loaded from: classes3.dex */
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-installations";

    /* JADX INFO: Access modifiers changed from: private */
    public static d lambda$getComponents$0(b bVar) {
        return new c((g) bVar.a(g.class), bVar.c(f.class), (ExecutorService) bVar.f(new q(a.class, ExecutorService.class)), new j((Executor) bVar.f(new q(p1.b.class, Executor.class))));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<q1.a> getComponents() {
        p pVarA = q1.a.a(d.class);
        pVarA.f8178c = LIBRARY_NAME;
        pVarA.c(i.a(g.class));
        pVarA.c(new i(0, 1, f.class));
        pVarA.c(new i(new q(a.class, ExecutorService.class), 1, 0));
        pVarA.c(new i(new q(p1.b.class, Executor.class), 1, 0));
        pVarA.f = new u(9);
        q1.a aVarD = pVarA.d();
        e eVar = new e(0);
        p pVarA2 = q1.a.a(e.class);
        pVarA2.f8177b = 1;
        pVarA2.f = new androidx.core.view.inputmethod.a(eVar, 23);
        return Arrays.asList(aVarD, pVarA2.d(), a.a.o(LIBRARY_NAME, "19.0.1"));
    }
}

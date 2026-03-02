package com.google.firebase.messaging;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import f9.p;
import java.util.Arrays;
import java.util.List;
import l1.g;
import m.f;
import n2.c;
import p2.a;
import q1.b;
import q1.i;
import q1.q;
import r2.d;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Keep
/* loaded from: classes3.dex */
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fcm";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ FirebaseMessaging lambda$getComponents$0(q qVar, b bVar) {
        g gVar = (g) bVar.a(g.class);
        if (bVar.a(a.class) == null) {
            return new FirebaseMessaging(gVar, bVar.c(y2.b.class), bVar.c(o2.g.class), (d) bVar.a(d.class), bVar.d(qVar), (c) bVar.a(c.class));
        }
        com.google.gson.internal.a.k();
        return null;
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<q1.a> getComponents() {
        q qVar = new q(h2.b.class, f.class);
        p pVarA = q1.a.a(FirebaseMessaging.class);
        pVarA.f8178c = LIBRARY_NAME;
        pVarA.c(i.a(g.class));
        pVarA.c(new i(0, 0, a.class));
        pVarA.c(new i(0, 1, y2.b.class));
        pVarA.c(new i(0, 1, o2.g.class));
        pVarA.c(i.a(d.class));
        pVarA.c(new i(qVar, 0, 1));
        pVarA.c(i.a(c.class));
        pVarA.f = new o2.b(qVar, 1);
        pVarA.e(1);
        return Arrays.asList(pVarA.d(), a.a.o(LIBRARY_NAME, "25.0.1"));
    }
}

package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import m.f;
import n.a;
import p.p;
import q1.b;
import q1.i;
import q1.q;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Keep
/* loaded from: classes3.dex */
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f lambda$getComponents$0(b bVar) {
        p.b((Context) bVar.a(Context.class));
        return p.a().c(a.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f lambda$getComponents$1(b bVar) {
        p.b((Context) bVar.a(Context.class));
        return p.a().c(a.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f lambda$getComponents$2(b bVar) {
        p.b((Context) bVar.a(Context.class));
        return p.a().c(a.e);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @NonNull
    public List<q1.a> getComponents() {
        f9.p pVarA = q1.a.a(f.class);
        pVarA.f8178c = LIBRARY_NAME;
        pVarA.c(i.a(Context.class));
        pVarA.f = new com.google.gson.internal.a(9);
        q1.a aVarD = pVarA.d();
        f9.p pVarB = q1.a.b(new q(h2.a.class, f.class));
        pVarB.c(i.a(Context.class));
        pVarB.f = new com.google.gson.internal.a(10);
        q1.a aVarD2 = pVarB.d();
        f9.p pVarB2 = q1.a.b(new q(h2.b.class, f.class));
        pVarB2.c(i.a(Context.class));
        pVarB2.f = new com.google.gson.internal.a(11);
        return Arrays.asList(aVarD, aVarD2, pVarB2.d(), a.a.o(LIBRARY_NAME, "19.0.0"));
    }
}

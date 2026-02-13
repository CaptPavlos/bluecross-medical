package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import c1.d0;
import com.google.android.gms.internal.measurement.l1;
import com.google.firebase.components.ComponentRegistrar;
import f9.p;
import h1.o;
import i0.y;
import java.util.Arrays;
import java.util.List;
import l1.g;
import n1.a;
import n2.c;
import q1.b;
import q1.i;
import q1.k;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Keep
/* loaded from: classes3.dex */
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    /* JADX INFO: Access modifiers changed from: private */
    public static a lambda$getComponents$0(b bVar) {
        g gVar = (g) bVar.a(g.class);
        Context context = (Context) bVar.a(Context.class);
        c cVar = (c) bVar.a(c.class);
        y.g(gVar);
        y.g(context);
        y.g(cVar);
        y.g(context.getApplicationContext());
        if (n1.b.f11278c == null) {
            synchronized (n1.b.class) {
                try {
                    if (n1.b.f11278c == null) {
                        Bundle bundle = new Bundle(1);
                        gVar.a();
                        if ("[DEFAULT]".equals(gVar.f10178b)) {
                            ((k) cVar).a(o.f8433b, d0.f);
                            bundle.putBoolean("dataCollectionDefaultEnabled", gVar.h());
                        }
                        n1.b.f11278c = new n1.b(l1.c(context, bundle).f2071b);
                    }
                } finally {
                }
            }
        }
        return n1.b.f11278c;
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @NonNull
    @Keep
    @SuppressLint({"MissingPermission"})
    public List<q1.a> getComponents() {
        p pVarA = q1.a.a(a.class);
        pVarA.c(i.a(g.class));
        pVarA.c(i.a(Context.class));
        pVarA.c(i.a(c.class));
        pVarA.f = d0.g;
        pVarA.e(2);
        return Arrays.asList(pVarA.d(), a.a.o("fire-analytics", "23.0.0"));
    }
}

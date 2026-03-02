package com.google.firebase.sessions;

import a3.a0;
import a3.b1;
import a3.j;
import a3.p;
import a3.q0;
import a3.u;
import a3.v;
import a3.w;
import a3.x;
import a3.y;
import a3.z0;
import android.content.Context;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.datastore.core.MultiProcessDataStoreFactory;
import c3.c;
import com.google.firebase.components.ComponentRegistrar;
import d0.i;
import java.util.List;
import l1.g;
import m.f;
import p1.a;
import p1.b;
import q1.q;
import r2.d;
import r7.s;
import t6.m;
import w2.r;
import w6.h;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Keep
/* loaded from: classes3.dex */
public final class FirebaseSessionsRegistrar implements ComponentRegistrar {

    @Deprecated
    public static final String LIBRARY_NAME = "fire-sessions";
    private static final a0 Companion = new a0();
    private static final q appContext = q.a(Context.class);
    private static final q firebaseApp = q.a(g.class);
    private static final q firebaseInstallationsApi = q.a(d.class);
    private static final q backgroundDispatcher = new q(a.class, s.class);
    private static final q blockingDispatcher = new q(b.class, s.class);
    private static final q transportFactory = q.a(f.class);
    private static final q firebaseSessionsComponent = q.a(u.class);

    static {
        try {
            MultiProcessDataStoreFactory.INSTANCE.getClass();
        } catch (NoClassDefFoundError unused) {
            Log.w("FirebaseSessions", "Your app is experiencing a known issue in the Android Gradle plugin, see https://issuetracker.google.com/328687152\n\nIt affects Java-only apps using AGP version 8.3.2 and under. To avoid the issue, either:\n\n1. Upgrade Android Gradle plugin to 8.4.0+\n   Follow the guide at https://developer.android.com/build/agp-upgrade-assistant\n\n2. Or, add the Kotlin plugin to your app\n   Follow the guide at https://developer.android.com/kotlin/add-kotlin\n\n3. Or, do the technical workaround described in https://issuetracker.google.com/issues/328687152#comment3");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final p getComponents$lambda$0(q1.b bVar) {
        return (p) ((j) ((u) bVar.f(firebaseSessionsComponent))).f105p.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final u getComponents$lambda$1(q1.b bVar) {
        Object objF = bVar.f(appContext);
        objF.getClass();
        Object objF2 = bVar.f(backgroundDispatcher);
        objF2.getClass();
        Object objF3 = bVar.f(blockingDispatcher);
        objF3.getClass();
        Object objF4 = bVar.f(firebaseApp);
        objF4.getClass();
        Object objF5 = bVar.f(firebaseInstallationsApi);
        objF5.getClass();
        q2.b bVarD = bVar.d(transportFactory);
        bVarD.getClass();
        j jVar = new j();
        jVar.f94a = i.y((g) objF4);
        i iVarY = i.y((Context) objF);
        jVar.f95b = iVarY;
        jVar.f96c = c3.a.a(new v(iVarY, 1));
        jVar.f97d = c3.a.a(y.f188a);
        jVar.e = i.y((d) objF5);
        jVar.f = c3.a.a(new v(jVar.f94a, 0));
        i iVarY2 = i.y((h) objF3);
        jVar.g = iVarY2;
        jVar.h = c3.a.a(new w(jVar.f, iVarY2));
        jVar.f98i = i.y((h) objF2);
        jVar.f99j = c3.a.a(new b1(jVar.f96c, c3.a.a(new z0(jVar.f97d, jVar.e, jVar.f, jVar.h, c3.a.a(new x(jVar.f98i, jVar.f97d, c3.a.a(new w(jVar.f95b, jVar.g, 0)))))), 1));
        c cVarA = c3.a.a(y.f189b);
        jVar.f100k = cVarA;
        int i10 = 0;
        jVar.f101l = c3.a.a(new b1(jVar.f97d, cVarA, i10));
        jVar.f102m = c3.a.a(new z0(jVar.f94a, jVar.e, jVar.f99j, c3.a.a(new i(i.y(bVarD), 1)), jVar.f98i));
        jVar.f103n = c3.a.a(new x(jVar.f95b, jVar.g, c3.a.a(new q0(jVar.f101l, 0)), i10));
        c cVarA2 = c3.a.a(new c2.d(jVar.f99j, jVar.f101l, jVar.f102m, jVar.f97d, jVar.f103n, c3.a.a(new w(jVar.f95b, jVar.f100k, 1)), jVar.f98i, 1));
        jVar.f104o = cVarA2;
        jVar.f105p = c3.a.a(new r(jVar.f94a, jVar.f99j, jVar.f98i, c3.a.a(new y2.c(cVarA2, 1)), 1));
        return jVar;
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<q1.a> getComponents() {
        f9.p pVarA = q1.a.a(p.class);
        pVarA.f8178c = LIBRARY_NAME;
        pVarA.c(q1.i.b(firebaseSessionsComponent));
        pVarA.f = new a2.a(8);
        pVarA.e(2);
        q1.a aVarD = pVarA.d();
        f9.p pVarA2 = q1.a.a(u.class);
        pVarA2.f8178c = "fire-sessions-component";
        pVarA2.c(q1.i.b(appContext));
        pVarA2.c(q1.i.b(backgroundDispatcher));
        pVarA2.c(q1.i.b(blockingDispatcher));
        pVarA2.c(q1.i.b(firebaseApp));
        pVarA2.c(q1.i.b(firebaseInstallationsApi));
        pVarA2.c(new q1.i(transportFactory, 1, 1));
        pVarA2.f = new a2.a(9);
        return m.Q(aVarD, pVarA2.d(), a.a.o(LIBRARY_NAME, "3.0.3"));
    }
}

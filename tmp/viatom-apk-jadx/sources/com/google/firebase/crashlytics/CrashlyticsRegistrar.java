package com.google.firebase.crashlytics;

import a8.i;
import android.util.Log;
import b3.d;
import com.google.firebase.components.ComponentRegistrar;
import f9.p;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import l1.g;
import p1.a;
import p1.b;
import p1.c;
import q1.q;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class CrashlyticsRegistrar implements ComponentRegistrar {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f2424d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final q f2425a = new q(a.class, ExecutorService.class);

    /* renamed from: b, reason: collision with root package name */
    public final q f2426b = new q(b.class, ExecutorService.class);

    /* renamed from: c, reason: collision with root package name */
    public final q f2427c = new q(c.class, ExecutorService.class);

    static {
        Map map = b3.c.f833b;
        d dVar = d.f834a;
        if (map.containsKey(dVar)) {
            Log.d("FirebaseSessions", "Dependency " + dVar + " already added.");
            return;
        }
        map.put(dVar, new b3.a(new i(true)));
        Log.d("FirebaseSessions", "Dependency to " + dVar + " added.");
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        p pVarA = q1.a.a(s1.c.class);
        pVarA.f8178c = "fire-cls";
        pVarA.c(q1.i.a(g.class));
        pVarA.c(q1.i.a(r2.d.class));
        pVarA.c(new q1.i(this.f2425a, 1, 0));
        pVarA.c(new q1.i(this.f2426b, 1, 0));
        pVarA.c(new q1.i(this.f2427c, 1, 0));
        pVarA.c(new q1.i(0, 2, t1.b.class));
        pVarA.c(new q1.i(0, 2, n1.a.class));
        pVarA.c(new q1.i(0, 2, z2.a.class));
        pVarA.f = new androidx.core.view.inputmethod.a(this, 24);
        pVarA.e(2);
        return Arrays.asList(pVarA.d(), a.a.o("fire-cls", "20.0.3"));
    }
}

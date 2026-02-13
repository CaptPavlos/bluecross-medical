package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e9 extends h {

    /* renamed from: c, reason: collision with root package name */
    public final c6 f1944c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f1945d;

    public e9(c6 c6Var) {
        super("require");
        this.f1945d = new HashMap();
        this.f1944c = c6Var;
    }

    @Override // com.google.android.gms.internal.measurement.h
    public final n a(w2.r rVar, List list) {
        n nVar;
        a.a.T(list, "require", 1);
        String strF = ((t) rVar.f13463c).c(rVar, (n) list.get(0)).f();
        HashMap map = this.f1945d;
        if (map.containsKey(strF)) {
            return (n) map.get(strF);
        }
        HashMap map2 = (HashMap) this.f1944c.f1904a;
        if (map2.containsKey(strF)) {
            try {
                nVar = (n) ((Callable) map2.get(strF)).call();
            } catch (Exception unused) {
                androidx.window.layout.c.g("Failed to create API implementation: ".concat(String.valueOf(strF)));
                return null;
            }
        } else {
            nVar = n.f2091a0;
        }
        if (nVar instanceof h) {
            map.put(strF, (h) nVar);
        }
        return nVar;
    }
}

package com.google.android.gms.internal.measurement;

import j$.util.concurrent.ConcurrentHashMap;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m6 {

    /* renamed from: c, reason: collision with root package name */
    public static final m6 f2086c = new m6();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f2088b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final c6 f2087a = new c6(0);

    public final p6 a(Class cls) {
        p6 p6VarU;
        Charset charset = u5.f2192a;
        if (cls == null) {
            androidx.window.layout.c.k("messageType");
            return null;
        }
        ConcurrentHashMap concurrentHashMap = this.f2088b;
        p6 p6Var = (p6) concurrentHashMap.get(cls);
        if (p6Var != null) {
            return p6Var;
        }
        c6 c6Var = this.f2087a;
        c6Var.getClass();
        m5 m5Var = q6.f2139a;
        o5.class.isAssignableFrom(cls);
        o6 o6VarB = ((c6) c6Var.f1904a).b(cls);
        if ((o6VarB.f2121d & 2) == 2) {
            m5 m5Var2 = q6.f2139a;
            m5 m5Var3 = h5.f1981a;
            p6VarU = new j6(m5Var2, o6VarB.f2118a);
        } else {
            int i10 = k6.f2023a;
            int i11 = z5.f2281a;
            m5 m5Var4 = q6.f2139a;
            m5 m5Var5 = o6VarB.a() + (-1) != 1 ? h5.f1981a : null;
            int i12 = f6.f1954a;
            p6VarU = i6.u(o6VarB, m5Var4, m5Var5);
        }
        p6 p6Var2 = (p6) concurrentHashMap.putIfAbsent(cls, p6VarU);
        return p6Var2 != null ? p6Var2 : p6VarU;
    }
}

package com.google.gson.internal;

import java.lang.reflect.Method;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r extends t {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f2587b;

    public r(Method method) {
        this.f2587b = method;
    }

    @Override // com.google.gson.internal.t
    public final Object a(Class cls) {
        String strX = d0.i.x(cls);
        if (strX == null) {
            return this.f2587b.invoke(null, cls, Object.class);
        }
        u.h("UnsafeAllocator is used for non-instantiable type: ".concat(strX));
        return null;
    }
}

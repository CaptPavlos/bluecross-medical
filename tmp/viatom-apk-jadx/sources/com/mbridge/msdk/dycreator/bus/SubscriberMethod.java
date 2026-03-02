package com.mbridge.msdk.dycreator.bus;

import java.lang.reflect.Method;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class SubscriberMethod {

    /* renamed from: a, reason: collision with root package name */
    final Method f3233a;

    /* renamed from: b, reason: collision with root package name */
    final ThreadMode f3234b;

    /* renamed from: c, reason: collision with root package name */
    final Class<?> f3235c;

    /* renamed from: d, reason: collision with root package name */
    String f3236d;

    public SubscriberMethod(Method method, ThreadMode threadMode, Class<?> cls) {
        this.f3233a = method;
        this.f3234b = threadMode;
        this.f3235c = cls;
    }

    private synchronized void a() {
        if (this.f3236d == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f3233a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f3233a.getName());
            sb.append('(');
            sb.append(this.f3235c.getName());
            this.f3236d = sb.toString();
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SubscriberMethod)) {
            return false;
        }
        a();
        return this.f3236d.equals(((SubscriberMethod) obj).f3236d);
    }

    public final int hashCode() {
        return this.f3233a.hashCode();
    }
}

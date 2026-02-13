package com.google.gson.internal.bind;

import com.google.gson.i;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f2527a;

    /* renamed from: b, reason: collision with root package name */
    public final Field f2528b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2529c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Method f2530d;
    public final /* synthetic */ i e;
    public final /* synthetic */ i f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ boolean h;

    public c(String str, Field field, Method method, i iVar, i iVar2, boolean z9, boolean z10) {
        this.f2530d = method;
        this.e = iVar;
        this.f = iVar2;
        this.g = z9;
        this.h = z10;
        this.f2527a = str;
        this.f2528b = field;
        this.f2529c = field.getName();
    }

    public final void a(i3.b bVar, Object obj) {
        Object objInvoke;
        Method method = this.f2530d;
        if (method != null) {
            try {
                objInvoke = method.invoke(obj, null);
            } catch (InvocationTargetException e) {
                throw new com.google.gson.e(androidx.constraintlayout.core.widgets.analyzer.a.x("Accessor ", h3.c.d(method, false), " threw exception"), e.getCause());
            }
        } else {
            objInvoke = this.f2528b.get(obj);
        }
        if (objInvoke == obj) {
            return;
        }
        bVar.i(this.f2527a);
        this.e.c(bVar, objInvoke);
    }
}

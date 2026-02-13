package com.google.gson.internal;

import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p8.u;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class Excluder implements com.google.gson.j, Cloneable {

    /* renamed from: c, reason: collision with root package name */
    public static final Excluder f2466c = new Excluder();

    /* renamed from: a, reason: collision with root package name */
    public final List f2467a;

    /* renamed from: b, reason: collision with root package name */
    public final List f2468b;

    public Excluder() {
        List list = Collections.EMPTY_LIST;
        this.f2467a = list;
        this.f2468b = list;
    }

    @Override // com.google.gson.j
    public final com.google.gson.i a(final com.google.gson.b bVar, final TypeToken typeToken) {
        Class cls = typeToken.f2599a;
        final boolean zB = b(cls, true);
        final boolean zB2 = b(cls, false);
        if (zB || zB2) {
            return new com.google.gson.i() { // from class: com.google.gson.internal.Excluder.1

                /* renamed from: a, reason: collision with root package name */
                public volatile com.google.gson.i f2469a;

                @Override // com.google.gson.i
                public final Object b(i3.a aVar) throws IOException {
                    if (zB2) {
                        aVar.D();
                        return null;
                    }
                    com.google.gson.i iVarD = this.f2469a;
                    if (iVarD == null) {
                        iVarD = bVar.d(Excluder.this, typeToken);
                        this.f2469a = iVarD;
                    }
                    return iVarD.b(aVar);
                }

                @Override // com.google.gson.i
                public final void c(i3.b bVar2, Object obj) throws IOException {
                    if (zB) {
                        bVar2.k();
                        return;
                    }
                    com.google.gson.i iVarD = this.f2469a;
                    if (iVarD == null) {
                        iVarD = bVar.d(Excluder.this, typeToken);
                        this.f2469a = iVarD;
                    }
                    iVarD.c(bVar2, obj);
                }
            };
        }
        return null;
    }

    public final boolean b(Class cls, boolean z9) {
        if (!z9 && !Enum.class.isAssignableFrom(cls)) {
            t1 t1Var = h3.c.f8442a;
            if (!Modifier.isStatic(cls.getModifiers()) && (cls.isAnonymousClass() || cls.isLocalClass())) {
                return true;
            }
        }
        Iterator it = (z9 ? this.f2467a : this.f2468b).iterator();
        if (!it.hasNext()) {
            return false;
        }
        it.next().getClass();
        a.k();
        return false;
    }

    public final Object clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            u.h(e);
            return null;
        }
    }
}

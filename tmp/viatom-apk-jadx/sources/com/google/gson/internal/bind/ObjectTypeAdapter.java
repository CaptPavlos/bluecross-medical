package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.internal.l;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ObjectTypeAdapter extends i {

    /* renamed from: c, reason: collision with root package name */
    public static final j f2500c = new AnonymousClass1(1);

    /* renamed from: a, reason: collision with root package name */
    public final com.google.gson.b f2501a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2502b;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.google.gson.internal.bind.ObjectTypeAdapter$1, reason: invalid class name */
    class AnonymousClass1 implements j {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f2503a;

        public AnonymousClass1(int i10) {
            this.f2503a = i10;
        }

        @Override // com.google.gson.j
        public final i a(com.google.gson.b bVar, TypeToken typeToken) {
            if (typeToken.f2599a == Object.class) {
                return new ObjectTypeAdapter(bVar, this.f2503a);
            }
            return null;
        }
    }

    public ObjectTypeAdapter(com.google.gson.b bVar, int i10) {
        this.f2501a = bVar;
        this.f2502b = i10;
    }

    public static j d(int i10) {
        return i10 == 1 ? f2500c : new AnonymousClass1(i10);
    }

    @Override // com.google.gson.i
    public final Object b(i3.a aVar) throws IOException {
        Object arrayList;
        Serializable arrayList2;
        int iX = aVar.x();
        int iC = c.i.c(iX);
        if (iC == 0) {
            aVar.a();
            arrayList = new ArrayList();
        } else if (iC != 2) {
            arrayList = null;
        } else {
            aVar.b();
            arrayList = new l(true);
        }
        if (arrayList == null) {
            return e(iX, aVar);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.k()) {
                String strR = arrayList instanceof Map ? aVar.r() : null;
                int iX2 = aVar.x();
                int iC2 = c.i.c(iX2);
                if (iC2 == 0) {
                    aVar.a();
                    arrayList2 = new ArrayList();
                } else if (iC2 != 2) {
                    arrayList2 = null;
                } else {
                    aVar.b();
                    arrayList2 = new l(true);
                }
                boolean z9 = arrayList2 != null;
                if (arrayList2 == null) {
                    arrayList2 = e(iX2, aVar);
                }
                if (arrayList instanceof List) {
                    ((List) arrayList).add(arrayList2);
                } else {
                    ((Map) arrayList).put(strR, arrayList2);
                }
                if (z9) {
                    arrayDeque.addLast(arrayList);
                    arrayList = arrayList2;
                }
            } else {
                if (arrayList instanceof List) {
                    aVar.f();
                } else {
                    aVar.h();
                }
                if (arrayDeque.isEmpty()) {
                    return arrayList;
                }
                arrayList = arrayDeque.removeLast();
            }
        }
    }

    @Override // com.google.gson.i
    public final void c(i3.b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.k();
            return;
        }
        Class<?> cls = obj.getClass();
        com.google.gson.b bVar2 = this.f2501a;
        bVar2.getClass();
        i iVarC = bVar2.c(new TypeToken(cls));
        if (!(iVarC instanceof ObjectTypeAdapter)) {
            iVarC.c(bVar, obj);
        } else {
            bVar.d();
            bVar.h();
        }
    }

    public final Serializable e(int i10, i3.a aVar) throws IOException {
        int iC = c.i.c(i10);
        if (iC == 5) {
            return aVar.v();
        }
        if (iC == 6) {
            return androidx.constraintlayout.core.widgets.analyzer.a.f(this.f2502b, aVar);
        }
        if (iC == 7) {
            return Boolean.valueOf(aVar.n());
        }
        if (iC == 8) {
            aVar.t();
            return null;
        }
        androidx.window.layout.c.g("Unexpected token: ".concat(com.mbridge.msdk.dycreator.baseview.a.y(i10)));
        return null;
    }
}

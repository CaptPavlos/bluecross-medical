package com.google.gson.internal.bind;

import com.google.gson.f;
import com.google.gson.g;
import com.google.gson.h;
import com.google.gson.i;
import com.google.gson.internal.j;
import com.google.gson.internal.k;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
class JsonElementTypeAdapter extends i {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonElementTypeAdapter f2492a = new JsonElementTypeAdapter();

    private JsonElementTypeAdapter() {
    }

    public static com.google.gson.d d(int i10, i3.a aVar) throws IOException {
        int iC = c.i.c(i10);
        if (iC == 5) {
            return new h(aVar.v());
        }
        if (iC == 6) {
            return new h(new com.google.gson.internal.h(aVar.v()));
        }
        if (iC == 7) {
            return new h(Boolean.valueOf(aVar.n()));
        }
        if (iC == 8) {
            aVar.t();
            return f.f2463a;
        }
        androidx.window.layout.c.g("Unexpected token: ".concat(com.mbridge.msdk.dycreator.baseview.a.y(i10)));
        return null;
    }

    public static void e(i3.b bVar, com.google.gson.d dVar) throws IOException {
        if (dVar == null || (dVar instanceof f)) {
            bVar.k();
            return;
        }
        boolean z9 = dVar instanceof h;
        if (z9) {
            if (!z9) {
                com.google.gson.internal.a.h(dVar, "Not a JSON Primitive: ");
                return;
            }
            h hVar = (h) dVar;
            Serializable serializable = hVar.f2465a;
            if (serializable instanceof Number) {
                bVar.r(hVar.c());
                return;
            } else if (serializable instanceof Boolean) {
                bVar.t(serializable instanceof Boolean ? ((Boolean) serializable).booleanValue() : Boolean.parseBoolean(hVar.d()));
                return;
            } else {
                bVar.s(hVar.d());
                return;
            }
        }
        boolean z10 = dVar instanceof com.google.gson.c;
        if (z10) {
            bVar.b();
            if (!z10) {
                com.google.gson.internal.a.h(dVar, "Not a JSON Array: ");
                return;
            }
            ArrayList arrayList = ((com.google.gson.c) dVar).f2462a;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                e(bVar, (com.google.gson.d) obj);
            }
            bVar.f();
            return;
        }
        boolean z11 = dVar instanceof g;
        if (!z11) {
            androidx.window.layout.c.f(dVar.getClass(), "Couldn't write ");
            return;
        }
        bVar.d();
        if (!z11) {
            com.google.gson.internal.a.h(dVar, "Not a JSON Object: ");
            return;
        }
        Iterator it = ((j) ((g) dVar).f2464a.entrySet()).iterator();
        while (((com.google.gson.internal.i) it).hasNext()) {
            k kVarB = ((com.google.gson.internal.i) it).b();
            bVar.i((String) kVarB.getKey());
            e(bVar, (com.google.gson.d) kVarB.getValue());
        }
        bVar.h();
    }

    @Override // com.google.gson.i
    public final Object b(i3.a aVar) throws IOException {
        com.google.gson.d cVar;
        com.google.gson.d cVar2;
        int iX = aVar.x();
        int iC = c.i.c(iX);
        if (iC == 0) {
            aVar.a();
            cVar = new com.google.gson.c();
        } else if (iC != 2) {
            cVar = null;
        } else {
            aVar.b();
            cVar = new g();
        }
        if (cVar == null) {
            return d(iX, aVar);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.k()) {
                String strR = cVar instanceof g ? aVar.r() : null;
                int iX2 = aVar.x();
                int iC2 = c.i.c(iX2);
                if (iC2 == 0) {
                    aVar.a();
                    cVar2 = new com.google.gson.c();
                } else if (iC2 != 2) {
                    cVar2 = null;
                } else {
                    aVar.b();
                    cVar2 = new g();
                }
                boolean z9 = cVar2 != null;
                if (cVar2 == null) {
                    cVar2 = d(iX2, aVar);
                }
                if (cVar instanceof com.google.gson.c) {
                    ((com.google.gson.c) cVar).f2462a.add(cVar2);
                } else {
                    ((g) cVar).f2464a.put(strR, cVar2);
                }
                if (z9) {
                    arrayDeque.addLast(cVar);
                    cVar = cVar2;
                }
            } else {
                if (cVar instanceof com.google.gson.c) {
                    aVar.f();
                } else {
                    aVar.h();
                }
                if (arrayDeque.isEmpty()) {
                    return cVar;
                }
                cVar = (com.google.gson.d) arrayDeque.removeLast();
            }
        }
    }

    @Override // com.google.gson.i
    public final /* bridge */ /* synthetic */ void c(i3.b bVar, Object obj) throws IOException {
        e(bVar, (com.google.gson.d) obj);
    }
}

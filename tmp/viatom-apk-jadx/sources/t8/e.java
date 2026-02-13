package t8;

import java.util.ArrayList;
import p8.b0;
import p8.t;
import p8.u;
import p8.y;
import p8.z;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f12866a;

    /* renamed from: b, reason: collision with root package name */
    public final s8.f f12867b;

    /* renamed from: c, reason: collision with root package name */
    public final b f12868c;

    /* renamed from: d, reason: collision with root package name */
    public final s8.a f12869d;
    public final int e;
    public final z f;
    public final y g;
    public final p8.b h;

    /* renamed from: i, reason: collision with root package name */
    public final int f12870i;

    /* renamed from: j, reason: collision with root package name */
    public final int f12871j;

    /* renamed from: k, reason: collision with root package name */
    public final int f12872k;

    /* renamed from: l, reason: collision with root package name */
    public int f12873l;

    public e(ArrayList arrayList, s8.f fVar, b bVar, s8.a aVar, int i10, z zVar, y yVar, p8.b bVar2, int i11, int i12, int i13) {
        this.f12866a = arrayList;
        this.f12869d = aVar;
        this.f12867b = fVar;
        this.f12868c = bVar;
        this.e = i10;
        this.f = zVar;
        this.g = yVar;
        this.h = bVar2;
        this.f12870i = i11;
        this.f12871j = i12;
        this.f12872k = i13;
    }

    public final b0 a(z zVar) {
        return b(zVar, this.f12867b, this.f12868c, this.f12869d);
    }

    public final b0 b(z zVar, s8.f fVar, b bVar, s8.a aVar) {
        z zVar2;
        ArrayList arrayList = this.f12866a;
        int size = arrayList.size();
        int i10 = this.e;
        if (i10 >= size) {
            u.m();
            return null;
        }
        this.f12873l++;
        b bVar2 = this.f12868c;
        if (bVar2 != null) {
            zVar2 = zVar;
            if (!this.f12869d.j(zVar2.f12205a)) {
                androidx.core.view.accessibility.a.q(arrayList.get(i10 - 1), "network interceptor ", " must retain the same host and port");
                return null;
            }
        } else {
            zVar2 = zVar;
        }
        if (bVar2 != null && this.f12873l > 1) {
            androidx.core.view.accessibility.a.q(arrayList.get(i10 - 1), "network interceptor ", " must call proceed() exactly once");
            return null;
        }
        int i11 = i10 + 1;
        e eVar = new e(arrayList, fVar, bVar, aVar, i11, zVar2, this.g, this.h, this.f12870i, this.f12871j, this.f12872k);
        t tVar = (t) arrayList.get(i10);
        b0 b0VarA = tVar.a(eVar);
        if (bVar != null && i11 < arrayList.size() && eVar.f12873l != 1) {
            androidx.core.view.accessibility.a.s(tVar, "network interceptor ", " must call proceed() exactly once");
            return null;
        }
        if (b0VarA != null) {
            if (b0VarA.g != null) {
                return b0VarA;
            }
            androidx.core.view.accessibility.a.s(tVar, "interceptor ", " returned a response with no body");
            return null;
        }
        throw new NullPointerException("interceptor " + tVar + " returned null");
    }
}

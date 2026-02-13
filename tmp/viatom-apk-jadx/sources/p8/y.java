package p8;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public final w f12201a;

    /* renamed from: b, reason: collision with root package name */
    public final t8.f f12202b;

    /* renamed from: c, reason: collision with root package name */
    public b f12203c;

    /* renamed from: d, reason: collision with root package name */
    public final z f12204d;
    public boolean e;

    public y(w wVar, z zVar) {
        this.f12201a = wVar;
        this.f12204d = zVar;
        this.f12202b = new t8.f(wVar);
    }

    public final b0 a() {
        ArrayList arrayList = new ArrayList();
        w wVar = this.f12201a;
        arrayList.addAll(wVar.f12181d);
        arrayList.add(this.f12202b);
        arrayList.add(new r8.b(wVar.h, 2));
        g gVar = wVar.f12182i;
        arrayList.add(new r8.b(gVar != null ? gVar.f12096a : null, 0));
        arrayList.add(new r8.b(wVar, 1));
        arrayList.addAll(wVar.e);
        arrayList.add(new t8.a());
        b bVar = this.f12203c;
        int i10 = wVar.f12194v;
        int i11 = wVar.f12195w;
        int i12 = wVar.f12196x;
        z zVar = this.f12204d;
        return new t8.e(arrayList, null, null, null, 0, zVar, this, bVar, i10, i11, i12).a(zVar);
    }

    public final Object clone() {
        w wVar = this.f12201a;
        y yVar = new y(wVar, this.f12204d);
        wVar.f.getClass();
        yVar.f12203c = b.f12062d;
        return yVar;
    }
}

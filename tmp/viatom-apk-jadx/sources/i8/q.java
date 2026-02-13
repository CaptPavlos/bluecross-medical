package i8;

import g8.y;
import java.util.List;
import t6.a0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q extends o {

    /* renamed from: j, reason: collision with root package name */
    public final h8.t f9078j;

    /* renamed from: k, reason: collision with root package name */
    public final List f9079k;

    /* renamed from: l, reason: collision with root package name */
    public final int f9080l;

    /* renamed from: m, reason: collision with root package name */
    public int f9081m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(h8.b bVar, h8.t tVar) {
        super(bVar, tVar, (String) null, 12);
        bVar.getClass();
        this.f9078j = tVar;
        List listR0 = t6.l.r0(tVar.f8848a.keySet());
        this.f9079k = listR0;
        this.f9080l = listR0.size() * 2;
        this.f9081m = -1;
    }

    @Override // i8.o, i8.a
    public final h8.k b(String str) {
        str.getClass();
        if (this.f9081m % 2 != 0) {
            return (h8.k) a0.f0(this.f9078j, str);
        }
        y yVar = h8.l.f8839a;
        return new h8.n(str, true);
    }

    @Override // i8.o, f8.c
    public final int decodeElementIndex(e8.e eVar) {
        eVar.getClass();
        int i10 = this.f9081m;
        if (i10 >= this.f9080l - 1) {
            return -1;
        }
        int i11 = i10 + 1;
        this.f9081m = i11;
        return i11;
    }

    @Override // i8.o, i8.a, f8.c
    public final void endStructure(e8.e eVar) {
        eVar.getClass();
    }

    @Override // i8.o, i8.a
    public final String n(e8.e eVar, int i10) {
        eVar.getClass();
        return (String) this.f9079k.get(i10 / 2);
    }

    @Override // i8.o, i8.a
    public final h8.k p() {
        return this.f9078j;
    }

    @Override // i8.o
    /* renamed from: u */
    public final h8.t p() {
        return this.f9078j;
    }
}

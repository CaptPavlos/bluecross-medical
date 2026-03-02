package t6;

import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends e implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public final e f12798a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12799b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12800c;

    public d(e eVar, int i10, int i11) {
        this.f12798a = eVar;
        this.f12799b = i10;
        b bVar = e.Companion;
        int size = eVar.size();
        bVar.getClass();
        b.d(i10, i11, size);
        this.f12800c = i11 - i10;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        e.Companion.getClass();
        b.b(i10, this.f12800c);
        return this.f12798a.get(this.f12799b + i10);
    }

    @Override // t6.a
    public final int getSize() {
        return this.f12800c;
    }

    @Override // t6.e, java.util.List
    public final List subList(int i10, int i11) {
        e.Companion.getClass();
        b.d(i10, i11, this.f12800c);
        int i12 = this.f12799b;
        return new d(this.f12798a, i10 + i12, i12 + i11);
    }
}

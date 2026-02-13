package u6;

import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d implements Iterator, h7.a {

    /* renamed from: a, reason: collision with root package name */
    public final f f12948a;

    /* renamed from: b, reason: collision with root package name */
    public int f12949b;

    /* renamed from: c, reason: collision with root package name */
    public int f12950c;

    /* renamed from: d, reason: collision with root package name */
    public int f12951d;
    public final /* synthetic */ int e;

    public d(f fVar, int i10) {
        this.e = i10;
        fVar.getClass();
        this.f12948a = fVar;
        this.f12950c = -1;
        this.f12951d = fVar.h;
        c();
    }

    public final void a() {
        if (this.f12948a.h == this.f12951d) {
            return;
        }
        a2.a.e();
    }

    public final void c() {
        while (true) {
            int i10 = this.f12949b;
            f fVar = this.f12948a;
            if (i10 >= fVar.f || fVar.f12958c[i10] >= 0) {
                return;
            } else {
                this.f12949b = i10 + 1;
            }
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12949b < this.f12948a.f;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.e) {
            case 0:
                a();
                int i10 = this.f12949b;
                f fVar = this.f12948a;
                if (i10 >= fVar.f) {
                    com.google.gson.internal.a.b();
                    break;
                } else {
                    this.f12949b = i10 + 1;
                    this.f12950c = i10;
                    e eVar = new e(fVar, i10);
                    c();
                    break;
                }
            case 1:
                a();
                int i11 = this.f12949b;
                f fVar2 = this.f12948a;
                if (i11 >= fVar2.f) {
                    com.google.gson.internal.a.b();
                    break;
                } else {
                    this.f12949b = i11 + 1;
                    this.f12950c = i11;
                    Object obj = fVar2.f12956a[i11];
                    c();
                    break;
                }
            default:
                a();
                int i12 = this.f12949b;
                f fVar3 = this.f12948a;
                if (i12 >= fVar3.f) {
                    com.google.gson.internal.a.b();
                    break;
                } else {
                    this.f12949b = i12 + 1;
                    this.f12950c = i12;
                    Object[] objArr = fVar3.f12957b;
                    objArr.getClass();
                    Object obj2 = objArr[this.f12950c];
                    c();
                    break;
                }
        }
        return null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        a();
        if (this.f12950c == -1) {
            androidx.window.layout.c.g("Call next() before removing element from the iterator.");
            return;
        }
        f fVar = this.f12948a;
        fVar.d();
        fVar.l(this.f12950c);
        this.f12950c = -1;
        this.f12951d = fVar.h;
    }
}

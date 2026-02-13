package l7;

import t6.x;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends x {

    /* renamed from: a, reason: collision with root package name */
    public final int f11087a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11088b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11089c;

    /* renamed from: d, reason: collision with root package name */
    public int f11090d;

    public c(int i10, int i11, int i12) {
        this.f11087a = i12;
        this.f11088b = i11;
        boolean z9 = false;
        if (i12 <= 0 ? i10 >= i11 : i10 <= i11) {
            z9 = true;
        }
        this.f11089c = z9;
        this.f11090d = z9 ? i10 : i11;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f11089c;
    }

    @Override // t6.x
    public final int nextInt() {
        int i10 = this.f11090d;
        if (i10 != this.f11088b) {
            this.f11090d = this.f11087a + i10;
            return i10;
        }
        if (this.f11089c) {
            this.f11089c = false;
            return i10;
        }
        com.google.gson.internal.a.b();
        return 0;
    }
}

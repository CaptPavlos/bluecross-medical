package g8;

import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c1 extends r0 {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f8246a;

    /* renamed from: b, reason: collision with root package name */
    public int f8247b;

    @Override // g8.r0
    public final Object a() {
        return new s6.o(Arrays.copyOf(this.f8246a, this.f8247b));
    }

    @Override // g8.r0
    public final void b(int i10) {
        byte[] bArr = this.f8246a;
        if (bArr.length < i10) {
            int length = bArr.length * 2;
            if (i10 < length) {
                i10 = length;
            }
            this.f8246a = Arrays.copyOf(bArr, i10);
        }
    }

    @Override // g8.r0
    public final int d() {
        return this.f8247b;
    }
}

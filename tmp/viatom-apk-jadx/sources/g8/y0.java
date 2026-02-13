package g8;

import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y0 extends r0 {

    /* renamed from: a, reason: collision with root package name */
    public short[] f8343a;

    /* renamed from: b, reason: collision with root package name */
    public int f8344b;

    @Override // g8.r0
    public final Object a() {
        return Arrays.copyOf(this.f8343a, this.f8344b);
    }

    @Override // g8.r0
    public final void b(int i10) {
        short[] sArr = this.f8343a;
        if (sArr.length < i10) {
            int length = sArr.length * 2;
            if (i10 < length) {
                i10 = length;
            }
            this.f8343a = Arrays.copyOf(sArr, i10);
        }
    }

    @Override // g8.r0
    public final int d() {
        return this.f8344b;
    }
}

package g8;

import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i1 extends r0 {

    /* renamed from: a, reason: collision with root package name */
    public long[] f8277a;

    /* renamed from: b, reason: collision with root package name */
    public int f8278b;

    @Override // g8.r0
    public final Object a() {
        return new s6.s(Arrays.copyOf(this.f8277a, this.f8278b));
    }

    @Override // g8.r0
    public final void b(int i10) {
        long[] jArr = this.f8277a;
        if (jArr.length < i10) {
            int length = jArr.length * 2;
            if (i10 < length) {
                i10 = length;
            }
            this.f8277a = Arrays.copyOf(jArr, i10);
        }
    }

    @Override // g8.r0
    public final int d() {
        return this.f8278b;
    }
}

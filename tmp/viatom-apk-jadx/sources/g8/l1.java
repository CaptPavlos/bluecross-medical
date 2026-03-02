package g8;

import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l1 extends r0 {

    /* renamed from: a, reason: collision with root package name */
    public short[] f8291a;

    /* renamed from: b, reason: collision with root package name */
    public int f8292b;

    @Override // g8.r0
    public final Object a() {
        return new s6.v(Arrays.copyOf(this.f8291a, this.f8292b));
    }

    @Override // g8.r0
    public final void b(int i10) {
        short[] sArr = this.f8291a;
        if (sArr.length < i10) {
            int length = sArr.length * 2;
            if (i10 < length) {
                i10 = length;
            }
            this.f8291a = Arrays.copyOf(sArr, i10);
        }
    }

    @Override // g8.r0
    public final int d() {
        return this.f8292b;
    }
}

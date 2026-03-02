package g8;

import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g0 extends r0 {

    /* renamed from: a, reason: collision with root package name */
    public long[] f8266a;

    /* renamed from: b, reason: collision with root package name */
    public int f8267b;

    @Override // g8.r0
    public final Object a() {
        return Arrays.copyOf(this.f8266a, this.f8267b);
    }

    @Override // g8.r0
    public final void b(int i10) {
        long[] jArr = this.f8266a;
        if (jArr.length < i10) {
            int length = jArr.length * 2;
            if (i10 < length) {
                i10 = length;
            }
            this.f8266a = Arrays.copyOf(jArr, i10);
        }
    }

    @Override // g8.r0
    public final int d() {
        return this.f8267b;
    }
}

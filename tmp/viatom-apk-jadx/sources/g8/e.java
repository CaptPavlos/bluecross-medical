package g8;

import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends r0 {

    /* renamed from: a, reason: collision with root package name */
    public boolean[] f8253a;

    /* renamed from: b, reason: collision with root package name */
    public int f8254b;

    @Override // g8.r0
    public final Object a() {
        return Arrays.copyOf(this.f8253a, this.f8254b);
    }

    @Override // g8.r0
    public final void b(int i10) {
        boolean[] zArr = this.f8253a;
        if (zArr.length < i10) {
            int length = zArr.length * 2;
            if (i10 < length) {
                i10 = length;
            }
            this.f8253a = Arrays.copyOf(zArr, i10);
        }
    }

    @Override // g8.r0
    public final int d() {
        return this.f8254b;
    }
}

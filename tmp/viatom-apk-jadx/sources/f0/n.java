package f0;

import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n extends m {

    /* renamed from: k, reason: collision with root package name */
    public final byte[] f8023k;

    public n(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f8023k = bArr;
    }

    @Override // f0.m
    public final byte[] K() {
        return this.f8023k;
    }
}

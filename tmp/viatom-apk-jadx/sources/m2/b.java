package m2;

import java.io.OutputStream;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    public long f11163a;

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i10, int i11) {
        int i12;
        if (i10 < 0 || i10 > bArr.length || i11 < 0 || (i12 = i10 + i11) > bArr.length || i12 < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.f11163a += i11;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f11163a += bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(int i10) {
        this.f11163a++;
    }
}

package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b5 extends c5 {

    /* renamed from: d, reason: collision with root package name */
    public final int f1889d;

    public b5(byte[] bArr, int i10) {
        super(bArr);
        c5.g(0, i10, bArr.length);
        this.f1889d = i10;
    }

    @Override // com.google.android.gms.internal.measurement.c5
    public final byte b(int i10) {
        int i11 = this.f1889d;
        if (((i11 - (i10 + 1)) | i10) >= 0) {
            return this.f1902b[i10];
        }
        if (i10 < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + 11);
            sb.append("Index < 0: ");
            sb.append(i10);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(i10).length() + 18 + String.valueOf(i11).length());
        sb2.append("Index > length: ");
        sb2.append(i10);
        sb2.append(", ");
        sb2.append(i11);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.measurement.c5
    public final byte c(int i10) {
        return this.f1902b[i10];
    }

    @Override // com.google.android.gms.internal.measurement.c5
    public final int d() {
        return this.f1889d;
    }
}

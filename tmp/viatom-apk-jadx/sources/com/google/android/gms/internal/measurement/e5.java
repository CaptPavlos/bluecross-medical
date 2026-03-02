package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e5 extends IOException {
    /* JADX WARN: Illegal instructions before constructor call */
    public e5(long j10, long j11, int i10, IndexOutOfBoundsException indexOutOfBoundsException) {
        Locale locale = Locale.US;
        StringBuilder sbX = a3.a.x("Pos: ", ", limit: ", j10);
        sbX.append(j11);
        sbX.append(", len: ");
        sbX.append(i10);
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(sbX.toString()), indexOutOfBoundsException);
    }

    public e5(IndexOutOfBoundsException indexOutOfBoundsException) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", indexOutOfBoundsException);
    }
}

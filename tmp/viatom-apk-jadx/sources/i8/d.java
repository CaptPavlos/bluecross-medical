package i8;

import androidx.constraintlayout.widget.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f9067a = new char[R.styleable.ConstraintSet_pivotAnchor];

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f9068b = new byte[126];

    static {
        for (int i10 = 0; i10 < 32; i10++) {
        }
        a('b', 8);
        a('t', 9);
        a('n', 10);
        a('f', 12);
        a('r', 13);
        a('/', 47);
        a('\"', 34);
        a('\\', 92);
        byte[] bArr = f9068b;
        for (int i11 = 0; i11 < 33; i11++) {
            bArr[i11] = 127;
        }
        bArr[9] = 3;
        bArr[10] = 3;
        bArr[13] = 3;
        bArr[32] = 3;
        bArr[44] = 4;
        bArr[58] = 5;
        bArr[123] = 6;
        bArr[125] = 7;
        bArr[91] = 8;
        bArr[93] = 9;
        bArr[34] = 1;
        bArr[92] = 2;
    }

    public static void a(char c10, int i10) {
        if (c10 != 'u') {
            f9067a[c10] = (char) i10;
        }
    }
}

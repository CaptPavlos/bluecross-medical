package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o6 {

    /* renamed from: a, reason: collision with root package name */
    public final u4 f2118a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2119b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f2120c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2121d;

    public o6(u4 u4Var, String str, Object[] objArr) {
        this.f2118a = u4Var;
        this.f2119b = str;
        this.f2120c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f2121d = cCharAt;
            return;
        }
        int i10 = cCharAt & 8191;
        int i11 = 1;
        int i12 = 13;
        while (true) {
            int i13 = i11 + 1;
            char cCharAt2 = str.charAt(i11);
            if (cCharAt2 < 55296) {
                this.f2121d = i10 | (cCharAt2 << i12);
                return;
            } else {
                i10 |= (cCharAt2 & 8191) << i12;
                i12 += 13;
                i11 = i13;
            }
        }
    }

    public final int a() {
        int i10 = this.f2121d;
        if ((i10 & 1) != 0) {
            return 1;
        }
        return (i10 & 4) == 4 ? 3 : 2;
    }
}

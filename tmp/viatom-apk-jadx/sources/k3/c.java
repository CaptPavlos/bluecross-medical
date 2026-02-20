package k3;

import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends b {

    /* renamed from: d, reason: collision with root package name */
    public static final c f10046d = new c();

    @Override // k3.b
    public final String c(String str) {
        char[] cArr = str.length() % 8 > 0 ? new char[8 - (str.length() % 8)] : new char[0];
        Arrays.fill(cArr, '0');
        char[] cArr2 = (str.length() + cArr.length) % 6 > 0 ? new char[6 - ((str.length() + cArr.length) % 6)] : new char[0];
        Arrays.fill(cArr2, '0');
        return str + new String(cArr) + new String(cArr2);
    }
}

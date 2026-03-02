package k3;

import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends b {

    /* renamed from: d, reason: collision with root package name */
    public static final d f10047d = new d();

    @Override // k3.b
    public final String c(String str) {
        if (str.length() % 24 <= 0) {
            return str;
        }
        char[] cArr = new char[24 - (str.length() % 24)];
        Arrays.fill(cArr, '0');
        return str.concat(new String(cArr));
    }
}

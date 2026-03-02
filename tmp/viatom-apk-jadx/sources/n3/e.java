package n3;

import com.google.android.gms.internal.measurement.u6;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f11286a = Pattern.compile("^[0-1]*$", 2);

    public static int a(String str) {
        if (!f11286a.matcher(str).matches()) {
            throw new o3.a(androidx.constraintlayout.core.widgets.analyzer.a.x("Undecodable FixedInteger '", str, "'"));
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < str.length()) {
            int i12 = i10 + 1;
            if (str.charAt(str.length() - i12) == '1') {
                i11 += 1 << i10;
            }
            i10 = i12;
        }
        return i11;
    }

    public static String b(int i10, int i11) {
        String strConcat = "";
        while (i10 > 0) {
            strConcat = (i10 & 1) == 1 ? "1".concat(strConcat) : "0".concat(strConcat);
            i10 >>= 1;
        }
        if (strConcat.length() <= i11) {
            while (strConcat.length() < i11) {
                strConcat = "0".concat(strConcat);
            }
            return strConcat;
        }
        throw new u6("Numeric value '" + i10 + "' is too large for a bit string length of '" + i11 + "'");
    }
}

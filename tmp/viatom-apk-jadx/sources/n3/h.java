package n3;

import com.google.android.gms.internal.measurement.u6;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f11290a = Pattern.compile("^[0-1]*$", 2);

    public static String a(long j10) {
        String strConcat = "";
        while (j10 > 0) {
            strConcat = (j10 & 1) == 1 ? "1".concat(strConcat) : "0".concat(strConcat);
            j10 >>= 1;
        }
        if (strConcat.length() > 36) {
            throw new u6(r1.i.d("Numeric value '", "' is too large for a bit string length of '36'", j10));
        }
        while (strConcat.length() < 36) {
            strConcat = "0".concat(strConcat);
        }
        return strConcat;
    }
}

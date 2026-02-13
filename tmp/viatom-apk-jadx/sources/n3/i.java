package n3;

import com.google.android.gms.internal.measurement.u6;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f11291a = Pattern.compile("^[0-1]*$", 2);

    public static String a(String str) {
        if (!f11291a.matcher(str).matches() || str.length() % 6 != 0) {
            throw new o3.a(androidx.constraintlayout.core.widgets.analyzer.a.x("Undecodable FixedString '", str, "'"));
        }
        String string = "";
        int i10 = 0;
        while (i10 < str.length()) {
            int i11 = i10 + 6;
            int iA = e.a(str.substring(i10, i11));
            if (iA == 63) {
                string = string.concat(" ");
            } else {
                StringBuilder sbV = a3.a.v(string);
                sbV.append((char) (iA + 65));
                string = sbV.toString();
            }
            i10 = i11;
        }
        return string.trim();
    }

    public static String b(String str) {
        while (str.length() < 2) {
            str = str.concat(" ");
        }
        String strConcat = "";
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == ' ') {
                strConcat = strConcat.concat(e.b(63, 6));
            } else {
                if (cCharAt < 'A') {
                    throw new u6(androidx.constraintlayout.core.widgets.analyzer.a.x("Unencodable FixedString '", str, "'"));
                }
                strConcat = strConcat.concat(e.b(str.charAt(i10) - 'A', 6));
            }
        }
        return strConcat;
    }
}

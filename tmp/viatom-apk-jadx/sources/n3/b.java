package n3;

import java.util.ArrayList;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f11282a = Pattern.compile("^[0-1]*$", 2);

    public static int a(String str) {
        if (str.length() > 24) {
            throw new o3.a("FibonacciInteger too long");
        }
        if (!f11282a.matcher(str).matches() || str.length() < 2 || str.indexOf("11") != str.length() - 2) {
            throw new o3.a(androidx.constraintlayout.core.widgets.analyzer.a.x("Undecodable FibonacciInteger '", str, "'"));
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < str.length() - 1; i10++) {
            if (i10 == 0) {
                arrayList.add(1);
            } else if (i10 == 1) {
                arrayList.add(2);
            } else {
                arrayList.add(Integer.valueOf(((Integer) arrayList.get(i10 - 2)).intValue() + ((Integer) arrayList.get(i10 - 1)).intValue()));
            }
        }
        int iIntValue = 0;
        for (int i11 = 0; i11 < str.length() - 1; i11++) {
            if (str.charAt(i11) == '1') {
                iIntValue = ((Integer) arrayList.get(i11)).intValue() + iIntValue;
            }
        }
        return iIntValue;
    }

    public static String b(int i10) {
        ArrayList arrayList = new ArrayList();
        if (i10 >= 1) {
            arrayList.add(1);
            int i11 = 2;
            if (i10 >= 2) {
                arrayList.add(2);
                while (true) {
                    int i12 = i11 - 1;
                    int i13 = i11 - 2;
                    if (i10 < ((Integer) arrayList.get(i13)).intValue() + ((Integer) arrayList.get(i12)).intValue()) {
                        break;
                    }
                    arrayList.add(Integer.valueOf(((Integer) arrayList.get(i13)).intValue() + ((Integer) arrayList.get(i12)).intValue()));
                    i11++;
                }
            }
        }
        String strConcat = "1";
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            int iIntValue = ((Integer) arrayList.get(size)).intValue();
            if (i10 >= iIntValue) {
                strConcat = "1".concat(strConcat);
                i10 -= iIntValue;
            } else {
                strConcat = "0".concat(strConcat);
            }
        }
        return strConcat;
    }
}

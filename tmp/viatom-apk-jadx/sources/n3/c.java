package n3;

import com.google.android.gms.internal.measurement.l5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f11283a = Logger.getLogger(c.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f11284b = Pattern.compile("^[0-1]*$", 2);

    public static ArrayList a(String str) {
        if (f11284b.matcher(str).matches()) {
            int iIndexOf = 12;
            if (str.length() >= 12) {
                ArrayList arrayList = new ArrayList();
                int iA = e.a(str.substring(0, 12));
                int i10 = 0;
                for (int i11 = 0; i11 < iA; i11++) {
                    int i12 = iIndexOf + 1;
                    boolean zQ = l5.q(str.substring(iIndexOf, i12));
                    Logger logger = f11283a;
                    if (zQ) {
                        int iIndexOf2 = str.indexOf("11", i12) + 2;
                        int iA2 = b.a(str.substring(i12, iIndexOf2)) + i10;
                        int iIndexOf3 = str.indexOf("11", iIndexOf2) + 2;
                        int iA3 = b.a(str.substring(iIndexOf2, iIndexOf3)) + iA2;
                        if ((iA3 - iA2) + arrayList.size() > 8192) {
                            logger.warning("FibonacciIntegerRange has too many values");
                            return arrayList;
                        }
                        while (iA2 <= iA3) {
                            arrayList.add(Integer.valueOf(iA2));
                            iA2++;
                        }
                        i10 = iA3;
                        iIndexOf = iIndexOf3;
                    } else {
                        iIndexOf = str.indexOf("11", i12) + 2;
                        int iA4 = b.a(str.substring(i12, iIndexOf)) + i10;
                        if (arrayList.size() == 8192) {
                            logger.warning("FibonacciIntegerRange has too many values");
                            return arrayList;
                        }
                        arrayList.add(Integer.valueOf(iA4));
                        i10 = iA4;
                    }
                }
                return arrayList;
            }
        }
        throw new o3.a(androidx.constraintlayout.core.widgets.analyzer.a.x("Undecodable FibonacciIntegerRange '", str, "'"));
    }

    public static String b(List list) {
        Collections.sort(list);
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (i10 < list.size()) {
            int i11 = i10;
            while (i11 < list.size() - 1) {
                int i12 = i11 + 1;
                if (((Integer) list.get(i11)).intValue() + 1 == ((Integer) list.get(i12)).intValue()) {
                    i11 = i12;
                }
            }
            int i13 = i11 + 1;
            arrayList.add(list.subList(i10, i13));
            i10 = i13;
        }
        String strB = e.b(arrayList.size(), 12);
        int iIntValue = 0;
        for (int i14 = 0; i14 < arrayList.size(); i14++) {
            if (((List) arrayList.get(i14)).size() == 1) {
                int iIntValue2 = ((Integer) ((List) arrayList.get(i14)).get(0)).intValue() - iIntValue;
                iIntValue = ((Integer) ((List) arrayList.get(i14)).get(0)).intValue();
                StringBuilder sbW = a3.a.w(strB, "0");
                sbW.append(b.b(iIntValue2));
                strB = sbW.toString();
            } else {
                int iIntValue3 = ((Integer) ((List) arrayList.get(i14)).get(0)).intValue() - iIntValue;
                int iIntValue4 = ((Integer) ((List) arrayList.get(i14)).get(((List) arrayList.get(i14)).size() - 1)).intValue() - ((Integer) ((List) arrayList.get(i14)).get(0)).intValue();
                iIntValue = ((Integer) ((List) arrayList.get(i14)).get(((List) arrayList.get(i14)).size() - 1)).intValue();
                StringBuilder sbW2 = a3.a.w(strB, "1");
                sbW2.append(b.b(iIntValue3));
                sbW2.append(b.b(iIntValue4));
                strB = sbW2.toString();
            }
        }
        return strB;
    }
}

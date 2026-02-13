package n3;

import com.google.android.gms.internal.measurement.l5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f11288a = Logger.getLogger(g.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f11289b = Pattern.compile("^[0-1]*$", 2);

    public static ArrayList a(String str) {
        if (f11289b.matcher(str).matches()) {
            int i10 = 12;
            if (str.length() >= 12) {
                ArrayList arrayList = new ArrayList();
                int iA = e.a(str.substring(0, 12));
                for (int i11 = 0; i11 < iA; i11++) {
                    int i12 = i10 + 1;
                    boolean zQ = l5.q(str.substring(i10, i12));
                    Logger logger = f11288a;
                    if (zQ) {
                        int i13 = i10 + 17;
                        int iA2 = e.a(str.substring(i12, i13));
                        i10 += 33;
                        int iA3 = e.a(str.substring(i13, i10));
                        if (iA3 < iA2) {
                            throw new o3.a("FixedIntegerRange has invalid range");
                        }
                        if ((iA3 - iA2) + arrayList.size() > 8192) {
                            logger.warning("FixedIntegerRange has too many values");
                            return arrayList;
                        }
                        while (iA2 <= iA3) {
                            arrayList.add(Integer.valueOf(iA2));
                            iA2++;
                        }
                    } else {
                        i10 += 17;
                        int iA4 = e.a(str.substring(i12, i10));
                        if (arrayList.size() == 8192) {
                            logger.warning("FixedIntegerRange has too many values");
                            return arrayList;
                        }
                        arrayList.add(Integer.valueOf(iA4));
                    }
                }
                return arrayList;
            }
        }
        throw new o3.a(androidx.constraintlayout.core.widgets.analyzer.a.x("Undecodable FixedIntegerRange '", str, "'"));
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
        for (int i14 = 0; i14 < arrayList.size(); i14++) {
            if (((List) arrayList.get(i14)).size() == 1) {
                StringBuilder sbW = a3.a.w(strB, "0");
                sbW.append(e.b(((Integer) ((List) arrayList.get(i14)).get(0)).intValue(), 16));
                strB = sbW.toString();
            } else {
                StringBuilder sbW2 = a3.a.w(strB, "1");
                sbW2.append(e.b(((Integer) ((List) arrayList.get(i14)).get(0)).intValue(), 16));
                sbW2.append(e.b(((Integer) ((List) arrayList.get(i14)).get(((List) arrayList.get(i14)).size() - 1)).intValue(), 16));
                strB = sbW2.toString();
            }
        }
        return strB;
    }
}

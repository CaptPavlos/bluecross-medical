package n3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f11292a = Pattern.compile("^[0-1]*$", 2);

    public static ArrayList a(String str) {
        if (!f11292a.matcher(str).matches() || str.length() < 12) {
            throw new o3.a(androidx.constraintlayout.core.widgets.analyzer.a.x("Undecodable FixedIntegerRange '", str, "'"));
        }
        if (str.charAt(16) == '1') {
            return g.a(str.substring(17));
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayListA = d.a(str.substring(17));
        for (int i10 = 0; i10 < arrayListA.size(); i10++) {
            if (((Boolean) arrayListA.get(i10)).booleanValue()) {
                arrayList.add(Integer.valueOf(i10 + 1));
            }
        }
        return arrayList;
    }

    public static String b(List list) {
        int iIntValue = list.size() > 0 ? ((Integer) a3.a.e(1, list)).intValue() : 0;
        String strB = g.b(list);
        if (strB.length() <= iIntValue) {
            return e.b(iIntValue, 16) + "1" + strB;
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (int i11 = 0; i11 < iIntValue; i11++) {
            if (i11 == ((Integer) list.get(i10)).intValue() - 1) {
                arrayList.add(Boolean.TRUE);
                i10++;
            } else {
                arrayList.add(Boolean.FALSE);
            }
        }
        return e.b(iIntValue, 16) + "0" + d.b(iIntValue, arrayList);
    }
}

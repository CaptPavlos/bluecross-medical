package n3;

import com.google.android.gms.internal.measurement.u6;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f11287a = Pattern.compile("^[0-1]*$", 2);

    public static ArrayList a(int i10, String str) {
        if (!f11287a.matcher(str).matches()) {
            throw new o3.a(androidx.constraintlayout.core.widgets.analyzer.a.x("Undecodable FixedIntegerList '", str, "'"));
        }
        int i11 = 2 * i10;
        if (str.length() > i11) {
            throw new o3.a(androidx.constraintlayout.core.widgets.analyzer.a.x("Undecodable FixedIntegerList '", str, "'"));
        }
        if (str.length() % 2 != 0) {
            throw new o3.a(androidx.constraintlayout.core.widgets.analyzer.a.x("Undecodable FixedIntegerList '", str, "'"));
        }
        while (str.length() < i11) {
            str = str.concat("0");
        }
        if (str.length() > i11) {
            str = str.substring(0, i11);
        }
        ArrayList arrayList = new ArrayList();
        int i12 = 0;
        while (i12 < str.length()) {
            int i13 = i12 + 2;
            arrayList.add(Integer.valueOf(e.a(str.substring(i12, i13))));
            i12 = i13;
        }
        while (arrayList.size() < i10) {
            arrayList.add(0);
        }
        return arrayList;
    }

    public static String b(int i10, List list) {
        if (list.size() > i10) {
            throw new u6("Too many values '" + list.size() + "'");
        }
        String strConcat = "";
        for (int i11 = 0; i11 < list.size(); i11++) {
            strConcat = strConcat.concat(e.b(((Integer) list.get(i11)).intValue(), 2));
        }
        while (strConcat.length() < 2 * i10) {
            strConcat = strConcat.concat("0");
        }
        return strConcat;
    }
}

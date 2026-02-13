package n3;

import com.google.android.gms.internal.measurement.l5;
import com.google.android.gms.internal.measurement.u6;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f11285a = Pattern.compile("^[0-1]*$", 2);

    public static ArrayList a(String str) {
        if (!f11285a.matcher(str).matches()) {
            throw new o3.a(androidx.constraintlayout.core.widgets.analyzer.a.x("Undecodable FixedBitfield '", str, "'"));
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (i10 < str.length()) {
            int i11 = i10 + 1;
            arrayList.add(Boolean.valueOf(l5.q(str.substring(i10, i11))));
            i10 = i11;
        }
        return arrayList;
    }

    public static String b(int i10, List list) {
        if (list.size() > i10) {
            throw new u6("Too many values '" + list.size() + "'");
        }
        String strConcat = "";
        for (int i11 = 0; i11 < list.size(); i11++) {
            strConcat = strConcat.concat(l5.r((Boolean) list.get(i11)));
        }
        while (strConcat.length() < i10) {
            strConcat = strConcat.concat("0");
        }
        return strConcat;
    }
}

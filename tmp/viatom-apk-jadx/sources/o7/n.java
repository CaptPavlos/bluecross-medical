package o7;

import com.google.android.gms.internal.measurement.a4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class n extends a4 {
    public static String P(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        g gVar = new g(str);
        int i10 = 0;
        while (gVar.hasNext()) {
            String strConcat = (String) gVar.next();
            strConcat.getClass();
            if (!m.l0(strConcat)) {
                strConcat = "    ".concat(strConcat);
            } else if (strConcat.length() < 4) {
                strConcat = "    ";
            }
            i10++;
            if (i10 > 1) {
                sb.append((CharSequence) "\n");
            }
            a4.g(sb, strConcat, null);
        }
        sb.append((CharSequence) "");
        return sb.toString();
    }

    public static String Q(String str) {
        Comparable comparable;
        List listN0 = m.n0(str);
        List list = listN0;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!m.l0((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(t6.n.V(arrayList, 10));
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            Object obj2 = arrayList.get(i11);
            i11++;
            String str2 = (String) obj2;
            int length = str2.length();
            int length2 = 0;
            while (true) {
                if (length2 >= length) {
                    length2 = -1;
                    break;
                }
                if (!t1.F(str2.charAt(length2))) {
                    break;
                }
                length2++;
            }
            if (length2 == -1) {
                length2 = str2.length();
            }
            arrayList2.add(Integer.valueOf(length2));
        }
        Iterator it = arrayList2.iterator();
        if (it.hasNext()) {
            comparable = (Comparable) it.next();
            while (it.hasNext()) {
                Comparable comparable2 = (Comparable) it.next();
                if (comparable.compareTo(comparable2) > 0) {
                    comparable = comparable2;
                }
            }
        } else {
            comparable = null;
        }
        Integer num = (Integer) comparable;
        int iIntValue = num != null ? num.intValue() : 0;
        int length3 = str.length();
        listN0.size();
        int size2 = listN0.size() - 1;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : list) {
            int i12 = i10 + 1;
            if (i10 < 0) {
                t6.m.U();
                throw null;
            }
            String str3 = (String) obj3;
            String strF0 = ((i10 == 0 || i10 == size2) && m.l0(str3)) ? null : m.f0(iIntValue, str3);
            if (strF0 != null) {
                arrayList3.add(strF0);
            }
            i10 = i12;
        }
        StringBuilder sb = new StringBuilder(length3);
        t6.l.f0(arrayList3, sb, "\n", "", "", "...", null);
        return sb.toString();
    }

    public static String R(String str) {
        if (m.l0("|")) {
            com.google.gson.internal.a.n("marginPrefix must be non-blank string.");
            return null;
        }
        List listN0 = m.n0(str);
        int length = str.length();
        listN0.size();
        int size = listN0.size() - 1;
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (Object obj : listN0) {
            int i11 = i10 + 1;
            String strSubstring = null;
            if (i10 < 0) {
                t6.m.U();
                throw null;
            }
            String str2 = (String) obj;
            if ((i10 != 0 && i10 != size) || !m.l0(str2)) {
                int length2 = str2.length();
                int i12 = 0;
                while (true) {
                    if (i12 >= length2) {
                        i12 = -1;
                        break;
                    }
                    if (!t1.F(str2.charAt(i12))) {
                        break;
                    }
                    i12++;
                }
                if (i12 != -1 && str2.startsWith("|", i12)) {
                    strSubstring = str2.substring("|".length() + i12);
                }
                if (strSubstring == null) {
                    strSubstring = str2;
                }
            }
            if (strSubstring != null) {
                arrayList.add(strSubstring);
            }
            i10 = i11;
        }
        StringBuilder sb = new StringBuilder(length);
        t6.l.f0(arrayList, sb, "\n", "", "", "...", null);
        return sb.toString();
    }
}

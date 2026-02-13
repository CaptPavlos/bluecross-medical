package androidx.room.util;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o7.m;
import t6.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class StringUtil {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    public static final void appendPlaceholders(StringBuilder sb, int i10) {
        sb.getClass();
        for (int i11 = 0; i11 < i10; i11++) {
            sb.append("?");
            if (i11 < i10 - 1) {
                sb.append(",");
            }
        }
    }

    public static final String joinIntoString(List<Integer> list) {
        if (list != null) {
            return l.h0(list, ",", null, null, null, 62);
        }
        return null;
    }

    public static final StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    public static final List<Integer> splitToIntList(String str) {
        Integer numValueOf;
        if (str == null) {
            return null;
        }
        List listR0 = m.r0(String.valueOf(new char[]{','}[0]), str);
        ArrayList arrayList = new ArrayList();
        Iterator it = listR0.iterator();
        while (it.hasNext()) {
            try {
                numValueOf = Integer.valueOf(Integer.parseInt((String) it.next()));
            } catch (NumberFormatException unused) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                arrayList.add(numValueOf);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void getEMPTY_STRING_ARRAY$annotations() {
    }
}

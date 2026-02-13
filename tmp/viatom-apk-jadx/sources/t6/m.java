package t6;

import com.google.android.gms.internal.measurement.a4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class m extends a4 {
    public static int P(List list) {
        list.getClass();
        return list.size() - 1;
    }

    public static List Q(Object... objArr) {
        if (objArr.length <= 0) {
            return t.f12808a;
        }
        List listAsList = Arrays.asList(objArr);
        listAsList.getClass();
        return listAsList;
    }

    public static ArrayList R(Object... objArr) {
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new h(objArr, true));
    }

    public static final List S(List list) {
        int size = list.size();
        return size != 0 ? size != 1 ? list : a4.u(list.get(0)) : t.f12808a;
    }

    public static void T() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void U() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}

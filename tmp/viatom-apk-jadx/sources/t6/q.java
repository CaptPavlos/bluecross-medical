package t6;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class q extends p {
    public static void W(List list, Comparator comparator) {
        list.getClass();
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}

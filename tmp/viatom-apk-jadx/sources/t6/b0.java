package t6;

import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class b0 extends l1.b {
    public static LinkedHashSet T(Set set, Set set2) {
        set.getClass();
        set2.getClass();
        LinkedHashSet linkedHashSet = new LinkedHashSet(a0.h0(set.size() + Integer.valueOf(set2.size()).intValue()));
        linkedHashSet.addAll(set);
        r.X(set2, linkedHashSet);
        return linkedHashSet;
    }
}

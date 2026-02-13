package t6;

import java.util.Collection;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class n extends m {
    public static int V(Iterable iterable, int i10) {
        iterable.getClass();
        return iterable instanceof Collection ? ((Collection) iterable).size() : i10;
    }
}

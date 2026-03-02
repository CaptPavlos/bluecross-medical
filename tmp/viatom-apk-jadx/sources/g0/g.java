package g0;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f8193a = Collections.newSetFromMap(new WeakHashMap());

    public static Set a() {
        Set set = f8193a;
        synchronized (set) {
        }
        return set;
    }
}

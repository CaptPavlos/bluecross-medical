package z;

import android.util.SparseArray;
import java.util.HashMap;
import m.d;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseArray f14136a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f14137b;

    static {
        HashMap map = new HashMap();
        f14137b = map;
        map.put(d.f11154a, 0);
        map.put(d.f11155b, 1);
        map.put(d.f11156c, 2);
        for (d dVar : map.keySet()) {
            f14136a.append(((Integer) f14137b.get(dVar)).intValue(), dVar);
        }
    }

    public static int a(d dVar) {
        Integer num = (Integer) f14137b.get(dVar);
        if (num != null) {
            return num.intValue();
        }
        com.google.gson.internal.a.h(dVar, "PriorityMapping is missing known Priority value ");
        return 0;
    }

    public static d b(int i10) {
        d dVar = (d) f14136a.get(i10);
        if (dVar != null) {
            return dVar;
        }
        com.google.gson.internal.a.n(a3.a.f(i10, "Unknown Priority for value "));
        return null;
    }
}

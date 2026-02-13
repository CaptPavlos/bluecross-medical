package n1;

import android.os.Bundle;
import c1.d0;
import com.google.android.gms.internal.measurement.f1;
import com.google.android.gms.internal.measurement.l1;
import d0.i;
import i0.k;
import i0.y;
import j$.util.concurrent.ConcurrentHashMap;
import l4.x4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements a {

    /* renamed from: c, reason: collision with root package name */
    public static volatile b f11278c;

    /* renamed from: a, reason: collision with root package name */
    public final i f11279a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f11280b;

    public b(i iVar) {
        y.g(iVar);
        this.f11279a = iVar;
        this.f11280b = new ConcurrentHashMap();
    }

    public final void a(String str, String str2, Bundle bundle) {
        if (o1.a.f11668c.contains(str) || o1.a.f11667b.contains(str2)) {
            return;
        }
        j1.i iVar = o1.a.f11669d;
        int i10 = iVar.f9898d;
        int i11 = 0;
        int i12 = 0;
        while (i12 < i10) {
            boolean zContainsKey = bundle.containsKey((String) iVar.get(i12));
            i12++;
            if (zContainsKey) {
                return;
            }
        }
        if ("_cmp".equals(str2)) {
            if (o1.a.f11668c.contains(str)) {
                return;
            }
            j1.i iVar2 = o1.a.f11669d;
            int i13 = iVar2.f9898d;
            while (i11 < i13) {
                boolean zContainsKey2 = bundle.containsKey((String) iVar2.get(i11));
                i11++;
                if (zContainsKey2) {
                    return;
                }
            }
            int iHashCode = str.hashCode();
            if (iHashCode != 101200) {
                if (iHashCode != 101230) {
                    if (iHashCode != 3142703 || !str.equals("fiam")) {
                        return;
                    } else {
                        bundle.putString("_cis", "fiam_integration");
                    }
                } else if (!str.equals("fdl")) {
                    return;
                } else {
                    bundle.putString("_cis", "fdl_integration");
                }
            } else if (!str.equals("fcm")) {
                return;
            } else {
                bundle.putString("_cis", "fcm_integration");
            }
        }
        if ("clx".equals(str) && "_ae".equals(str2)) {
            bundle.putLong("_r", 1L);
        }
        l1 l1Var = (l1) this.f11279a.f6781b;
        l1Var.a(new f1(l1Var, str, str2, bundle, true));
    }

    public final d0 b(String str, k kVar) {
        if (!o1.a.f11668c.contains(str)) {
            boolean zIsEmpty = str.isEmpty();
            ConcurrentHashMap concurrentHashMap = this.f11280b;
            if (zIsEmpty || !concurrentHashMap.containsKey(str) || concurrentHashMap.get(str) == null) {
                boolean zEquals = "fiam".equals(str);
                i iVar = this.f11279a;
                g5.i kVar2 = zEquals ? new k(iVar, kVar) : "clx".equals(str) ? new x4(iVar, kVar) : null;
                if (kVar2 != null) {
                    concurrentHashMap.put(str, kVar2);
                    return new d0(21);
                }
            }
        }
        return null;
    }
}

package m1;

import android.os.Bundle;
import androidx.work.WorkRequest;
import c1.d3;
import com.google.android.gms.internal.measurement.a1;
import com.google.android.gms.internal.measurement.b1;
import com.google.android.gms.internal.measurement.d1;
import com.google.android.gms.internal.measurement.f1;
import com.google.android.gms.internal.measurement.i0;
import com.google.android.gms.internal.measurement.l1;
import com.google.android.gms.internal.measurement.y0;
import com.google.android.gms.internal.measurement.z0;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements d3 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l1 f11161a;

    public a(l1 l1Var) {
        this.f11161a = l1Var;
    }

    @Override // c1.d3
    public final void b(String str, String str2, Bundle bundle) {
        l1 l1Var = this.f11161a;
        l1Var.a(new f1(l1Var, str, str2, bundle, true));
    }

    @Override // c1.d3
    public final String c() {
        i0 i0Var = new i0();
        l1 l1Var = this.f11161a;
        l1Var.a(new d1(l1Var, i0Var, 3));
        return (String) i0.d(String.class, i0Var.c(500L));
    }

    @Override // c1.d3
    public final String d() {
        i0 i0Var = new i0();
        l1 l1Var = this.f11161a;
        l1Var.a(new d1(l1Var, i0Var, 4));
        return (String) i0.d(String.class, i0Var.c(500L));
    }

    @Override // c1.d3
    public final void e(Bundle bundle) {
        l1 l1Var = this.f11161a;
        l1Var.a(new y0(l1Var, bundle, 1));
    }

    @Override // c1.d3
    public final void f(String str) {
        l1 l1Var = this.f11161a;
        l1Var.a(new b1(l1Var, str, 1));
    }

    @Override // c1.d3
    public final void g(String str) {
        l1 l1Var = this.f11161a;
        l1Var.a(new b1(l1Var, str, 0));
    }

    @Override // c1.d3
    public final long h() {
        i0 i0Var = new i0();
        l1 l1Var = this.f11161a;
        l1Var.a(new d1(l1Var, i0Var, 2));
        Long l10 = (Long) i0.d(Long.class, i0Var.c(500L));
        if (l10 != null) {
            return l10.longValue();
        }
        long jNextLong = new Random(System.nanoTime() ^ System.currentTimeMillis()).nextLong();
        int i10 = l1Var.f2073d + 1;
        l1Var.f2073d = i10;
        return jNextLong + i10;
    }

    @Override // c1.d3
    public final void i(String str, String str2, Bundle bundle) {
        l1 l1Var = this.f11161a;
        l1Var.a(new z0(l1Var, str, str2, bundle, 0));
    }

    @Override // c1.d3
    public final List j(String str, String str2) {
        i0 i0Var = new i0();
        l1 l1Var = this.f11161a;
        l1Var.a(new z0(l1Var, str, str2, i0Var, 1));
        List list = (List) i0.d(List.class, i0Var.c(5000L));
        return list == null ? Collections.EMPTY_LIST : list;
    }

    @Override // c1.d3
    public final int k(String str) {
        i0 i0Var = new i0();
        l1 l1Var = this.f11161a;
        l1Var.a(new a1(l1Var, str, i0Var, 1));
        Integer num = (Integer) i0.d(Integer.class, i0Var.c(WorkRequest.MIN_BACKOFF_MILLIS));
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    @Override // c1.d3
    public final String l() {
        i0 i0Var = new i0();
        l1 l1Var = this.f11161a;
        l1Var.a(new d1(l1Var, i0Var, 1));
        return (String) i0.d(String.class, i0Var.c(50L));
    }

    @Override // c1.d3
    public final String m() {
        i0 i0Var = new i0();
        l1 l1Var = this.f11161a;
        l1Var.a(new d1(l1Var, i0Var, 0));
        return (String) i0.d(String.class, i0Var.c(500L));
    }

    @Override // c1.d3
    public final Map n(String str, String str2, boolean z9) {
        i0 i0Var = new i0();
        l1 l1Var = this.f11161a;
        l1Var.a(new f1(l1Var, str, str2, z9, i0Var));
        Bundle bundleC = i0Var.c(5000L);
        if (bundleC == null || bundleC.size() == 0) {
            return Collections.EMPTY_MAP;
        }
        HashMap map = new HashMap(bundleC.size());
        for (String str3 : bundleC.keySet()) {
            Object obj = bundleC.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                map.put(str3, obj);
            }
        }
        return map;
    }
}

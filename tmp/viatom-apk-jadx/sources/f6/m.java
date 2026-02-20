package f6;

import android.util.Log;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.model.ChoiceError;
import j$.time.ZonedDateTime;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m {
    public final Vector A;
    public final Vector B;
    public Vector C;
    public final Vector D;
    public Vector E;
    public Vector F;
    public h G;

    /* renamed from: b, reason: collision with root package name */
    public long f8098b;

    /* renamed from: c, reason: collision with root package name */
    public long f8099c;

    /* renamed from: d, reason: collision with root package name */
    public ZonedDateTime f8100d;
    public boolean f;
    public boolean g;

    /* renamed from: j, reason: collision with root package name */
    public int f8102j;

    /* renamed from: o, reason: collision with root package name */
    public int f8107o;

    /* renamed from: p, reason: collision with root package name */
    public int f8108p;

    /* renamed from: z, reason: collision with root package name */
    public Vector f8116z;

    /* renamed from: a, reason: collision with root package name */
    public k8.c f8097a = null;
    public boolean e = true;
    public String h = "AA";

    /* renamed from: i, reason: collision with root package name */
    public int f8101i = 2;

    /* renamed from: k, reason: collision with root package name */
    public int f8103k = 2;

    /* renamed from: l, reason: collision with root package name */
    public String f8104l = "EN";

    /* renamed from: m, reason: collision with root package name */
    public int f8105m = 10;

    /* renamed from: n, reason: collision with root package name */
    public int f8106n = 2021;

    /* renamed from: q, reason: collision with root package name */
    public Vector f8109q = new Vector(null, 1, null);

    /* renamed from: r, reason: collision with root package name */
    public Vector f8110r = new Vector(null, 1, null);

    /* renamed from: s, reason: collision with root package name */
    public Vector f8111s = new Vector(null, 1, null);
    public final Vector t = new Vector(null, 1, null);

    /* renamed from: u, reason: collision with root package name */
    public final Vector f8112u = new Vector(null, 1, null);

    /* renamed from: v, reason: collision with root package name */
    public Vector f8113v = new Vector(null, 1, null);

    /* renamed from: w, reason: collision with root package name */
    public Vector f8114w = new Vector(null, 1, null);

    /* renamed from: x, reason: collision with root package name */
    public Vector f8115x = new Vector(null, 1, null);
    public Vector y = new Vector(null, 1, null);

    public m() {
        new LinkedHashSet();
        this.f8116z = new Vector(null, 1, null);
        this.A = new Vector(null, 1, null);
        this.B = new Vector(null, 1, null);
        this.C = new Vector(null, 1, null);
        this.D = new Vector(null, 1, null);
        this.E = new Vector(null, 1, null);
        this.F = new Vector(null, 1, null);
        this.G = new h(this.f8097a);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, java.util.List] */
    public static final boolean b(m mVar, k8.h hVar) {
        ?? r12 = i9.a.h().f11814b.f11783j;
        Set set = hVar.e;
        if (set != null && set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (r12.contains(Integer.valueOf(((Number) it.next()).intValue()))) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.List] */
    public static boolean c(k8.h hVar) {
        ?? r02 = i9.a.h().f11814b.h;
        Set set = hVar.f10095d;
        if (set != null && set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (r02.contains(Integer.valueOf(((Number) it.next()).intValue()))) {
                return true;
            }
        }
        return false;
    }

    public final void a(String str) {
        String[] iSOCountries = Locale.getISOCountries();
        iSOCountries.getClass();
        Locale locale = Locale.getDefault();
        locale.getClass();
        String upperCase = str.toUpperCase(locale);
        upperCase.getClass();
        if (t6.j.v0(iSOCountries, upperCase) >= 0) {
            Locale locale2 = Locale.getDefault();
            locale2.getClass();
            String upperCase2 = str.toUpperCase(locale2);
            upperCase2.getClass();
            this.h = upperCase2;
            return;
        }
        n nVar = new n("publisherCountryCode", str);
        ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
        if (callback != null) {
            callback.onCmpError(ChoiceError.TC_MODEL_PROPERTY_ERROR);
        }
        String message = nVar.getMessage();
        if (message == null) {
            message = "";
        }
        Object obj = Boolean.TRUE;
        if (obj.equals(obj)) {
            Log.e("f.u", message, nVar);
        }
    }

    public final int d() {
        k8.c cVar = this.f8097a;
        Integer num = cVar == null ? null : cVar.f10083c;
        return num == null ? this.f8103k : num.intValue();
    }

    public final void e() {
        this.B.setAllOwnedItems();
        this.f8116z.forEach(new l(this, 1));
        this.f8110r.setAllOwnedItems();
        this.f8111s.setAllOwnedItems();
        this.f8109q.setAllOwnedItems();
        this.C.forEach(new l(this, 2));
        this.A.forEach(new l(this, 0));
        this.D.setAllOwnedItems();
        this.f8113v.setAllOwnedItems();
        this.f8114w.setAllOwnedItems();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m) && kotlin.jvm.internal.l.a(this.f8097a, ((m) obj).f8097a);
    }

    public final void f() {
        this.f8116z.forEach(new l(this, 4));
        this.C.forEach(new l(this, 2));
        Vector vector = this.B;
        vector.unset(vector.getKeys());
        this.A.unsetAllOwnedItems();
        this.f8109q.unsetAllOwnedItems();
        this.f8110r.unsetAllOwnedItems();
        this.f8111s.setAllOwnedItems();
        this.C.forEach(new l(this, 3));
        this.f8113v.unsetAllOwnedItems();
        this.f8114w.unsetAllOwnedItems();
    }

    public final int hashCode() {
        k8.c cVar = this.f8097a;
        if (cVar == null) {
            return 0;
        }
        return cVar.hashCode();
    }

    public final String toString() {
        return "TCModel(gvl=" + this.f8097a + ')';
    }
}

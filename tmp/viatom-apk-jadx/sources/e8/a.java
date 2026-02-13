package e8;

import java.util.ArrayList;
import java.util.HashSet;
import t6.t;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f7950a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f7951b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final HashSet f7952c = new HashSet();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f7953d = new ArrayList();
    public final ArrayList e = new ArrayList();
    public final ArrayList f = new ArrayList();

    public a(String str) {
        this.f7950a = str;
    }

    public static void a(a aVar, String str, e eVar) {
        aVar.getClass();
        eVar.getClass();
        if (!aVar.f7952c.add(str)) {
            StringBuilder sbY = a3.a.y("Element with name '", str, "' is already registered in ");
            sbY.append(aVar.f7950a);
            throw new IllegalArgumentException(sbY.toString().toString());
        }
        aVar.f7951b.add(str);
        aVar.f7953d.add(eVar);
        aVar.e.add(t.f12808a);
        aVar.f.add(false);
    }
}

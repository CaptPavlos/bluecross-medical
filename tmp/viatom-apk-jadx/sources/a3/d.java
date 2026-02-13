package a3;

import android.os.Build;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d implements j2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f44a = new d();

    /* renamed from: b, reason: collision with root package name */
    public static final j2.c f45b = j2.c.a("packageName");

    /* renamed from: c, reason: collision with root package name */
    public static final j2.c f46c = j2.c.a("versionName");

    /* renamed from: d, reason: collision with root package name */
    public static final j2.c f47d = j2.c.a("appBuildVersion");
    public static final j2.c e = j2.c.a("deviceManufacturer");
    public static final j2.c f = j2.c.a("currentProcessDetails");
    public static final j2.c g = j2.c.a("appProcessDetails");

    @Override // j2.a
    public final void a(Object obj, Object obj2) {
        b bVar = (b) obj;
        j2.e eVar = (j2.e) obj2;
        eVar.a(f45b, bVar.f24a);
        eVar.a(f46c, bVar.f25b);
        eVar.a(f47d, bVar.f26c);
        eVar.a(e, Build.MANUFACTURER);
        eVar.a(f, bVar.f27d);
        eVar.a(g, bVar.e);
    }
}

package a3;

import android.os.Build;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements j2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final e f52a = new e();

    /* renamed from: b, reason: collision with root package name */
    public static final j2.c f53b = j2.c.a("appId");

    /* renamed from: c, reason: collision with root package name */
    public static final j2.c f54c = j2.c.a("deviceModel");

    /* renamed from: d, reason: collision with root package name */
    public static final j2.c f55d = j2.c.a("sessionSdkVersion");
    public static final j2.c e = j2.c.a("osVersion");
    public static final j2.c f = j2.c.a("logEnvironment");
    public static final j2.c g = j2.c.a("androidAppInfo");

    @Override // j2.a
    public final void a(Object obj, Object obj2) {
        c cVar = (c) obj;
        j2.e eVar = (j2.e) obj2;
        eVar.a(f53b, cVar.f35a);
        eVar.a(f54c, Build.MODEL);
        eVar.a(f55d, "3.0.3");
        eVar.a(e, Build.VERSION.RELEASE);
        eVar.a(f, d0.LOG_ENVIRONMENT_PROD);
        eVar.a(g, cVar.f36b);
    }
}

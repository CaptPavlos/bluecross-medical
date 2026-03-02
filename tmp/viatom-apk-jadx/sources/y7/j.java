package y7;

import java.util.concurrent.TimeUnit;
import w7.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final String f14124a;

    /* renamed from: b, reason: collision with root package name */
    public static final long f14125b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f14126c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f14127d;
    public static final long e;
    public static final g f;

    static {
        String property;
        int i10 = u.f13557a;
        try {
            property = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            property = "DefaultDispatcher";
        }
        f14124a = property;
        f14125b = w7.a.i(100000L, 1L, Long.MAX_VALUE, "kotlinx.coroutines.scheduler.resolution.ns");
        int i11 = u.f13557a;
        if (i11 < 2) {
            i11 = 2;
        }
        f14126c = w7.a.j(i11, 8, "kotlinx.coroutines.scheduler.core.pool.size");
        f14127d = w7.a.j(2097150, 4, "kotlinx.coroutines.scheduler.max.pool.size");
        e = TimeUnit.SECONDS.toNanos(w7.a.i(60L, 1L, Long.MAX_VALUE, "kotlinx.coroutines.scheduler.keep.alive.sec"));
        f = g.f14120a;
    }
}

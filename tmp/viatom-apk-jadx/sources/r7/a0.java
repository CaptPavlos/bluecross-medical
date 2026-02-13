package r7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static final d0 f12388a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [s7.c] */
    /* JADX WARN: Type inference failed for: r0v7, types: [r7.z] */
    /* JADX WARN: Type inference failed for: r0v8, types: [r7.d0] */
    /* JADX WARN: Type inference failed for: r0v9, types: [r7.z] */
    static {
        String property;
        ?? r02;
        int i10 = w7.u.f13557a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null ? Boolean.parseBoolean(property) : false) {
            y7.e eVar = i0.f12407a;
            r02 = w7.n.f13548a;
            s7.c cVar = r02.f12716c;
            if (!(r02 != 0)) {
                r02 = z.h;
            }
        } else {
            r02 = z.h;
        }
        f12388a = r02;
    }
}

package p0;

import android.content.Context;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public static final c f11876b;

    /* renamed from: a, reason: collision with root package name */
    public b f11877a;

    static {
        c cVar = new c();
        cVar.f11877a = null;
        f11876b = cVar;
    }

    public static b a(Context context) {
        b bVar;
        c cVar = f11876b;
        synchronized (cVar) {
            try {
                if (cVar.f11877a == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    cVar.f11877a = new b(context);
                }
                bVar = cVar.f11877a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }
}

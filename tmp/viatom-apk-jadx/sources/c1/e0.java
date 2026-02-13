package c1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e0 {
    public static final Object f = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final String f1141a;

    /* renamed from: b, reason: collision with root package name */
    public final w f1142b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f1143c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f1144d = new Object();
    public volatile Object e = null;

    public /* synthetic */ e0(String str, Object obj, w wVar) {
        this.f1141a = str;
        this.f1143c = obj;
        this.f1142b = wVar;
    }

    public final Object a(Object obj) {
        synchronized (this.f1144d) {
        }
        if (obj != null) {
            return obj;
        }
        if (l2.f1323k == null) {
            return this.f1143c;
        }
        synchronized (f) {
            try {
                if (o2.e.c()) {
                    return this.e == null ? this.f1143c : this.e;
                }
                try {
                    for (e0 e0Var : f0.f1154a) {
                        if (o2.e.c()) {
                            throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                        }
                        Object objA = null;
                        try {
                            w wVar = e0Var.f1142b;
                            if (wVar != null) {
                                objA = wVar.a();
                            }
                        } catch (IllegalStateException unused) {
                        }
                        synchronized (f) {
                            e0Var.e = objA;
                        }
                    }
                } catch (SecurityException unused2) {
                }
                w wVar2 = this.f1142b;
                if (wVar2 != null) {
                    try {
                        return wVar2.a();
                    } catch (IllegalStateException | SecurityException unused3) {
                    }
                }
                return this.f1143c;
            } finally {
            }
        }
    }
}

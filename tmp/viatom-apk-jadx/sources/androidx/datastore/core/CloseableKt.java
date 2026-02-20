package androidx.datastore.core;

import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class CloseableKt {
    public static final <T extends Closeable, R> R use(T t, l lVar) throws Throwable {
        t.getClass();
        lVar.getClass();
        try {
            R r6 = (R) lVar.invoke(t);
            try {
                t.close();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            if (th == null) {
                return r6;
            }
            throw th;
        } catch (Throwable th2) {
            try {
                t.close();
            } catch (Throwable th3) {
                s6.a.a(th2, th3);
            }
            throw th2;
        }
    }
}

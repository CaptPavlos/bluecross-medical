package androidx.datastore.core;

import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class MutexUtilsKt {
    public static final <R> R withTryLock(a8.a aVar, Object obj, l lVar) {
        aVar.getClass();
        lVar.getClass();
        boolean zTryLock = aVar.tryLock(obj);
        try {
            return (R) lVar.invoke(Boolean.valueOf(zTryLock));
        } finally {
            if (zTryLock) {
                aVar.unlock(obj);
            }
        }
    }

    public static /* synthetic */ Object withTryLock$default(a8.a aVar, Object obj, l lVar, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = null;
        }
        aVar.getClass();
        lVar.getClass();
        boolean zTryLock = aVar.tryLock(obj);
        try {
            return lVar.invoke(Boolean.valueOf(zTryLock));
        } finally {
            if (zTryLock) {
                aVar.unlock(obj);
            }
        }
    }
}

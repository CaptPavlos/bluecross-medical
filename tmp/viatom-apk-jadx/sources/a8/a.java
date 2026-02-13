package a8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface a {
    z7.a getOnLock();

    boolean holdsLock(Object obj);

    boolean isLocked();

    Object lock(Object obj, w6.c cVar);

    boolean tryLock(Object obj);

    void unlock(Object obj);
}

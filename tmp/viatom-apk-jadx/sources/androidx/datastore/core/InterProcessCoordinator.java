package androidx.datastore.core;

import g7.l;
import g7.p;
import u7.h;
import w6.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface InterProcessCoordinator {
    h getUpdateNotifications();

    Object getVersion(c cVar);

    Object incrementAndGetVersion(c cVar);

    <T> Object lock(l lVar, c cVar);

    <T> Object tryLock(p pVar, c cVar);
}

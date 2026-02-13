package androidx.datastore.core;

import g7.p;
import g7.q;
import w6.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface StorageConnection<T> extends Closeable {
    InterProcessCoordinator getCoordinator();

    <R> Object readScope(q qVar, c cVar);

    Object writeScope(p pVar, c cVar);
}

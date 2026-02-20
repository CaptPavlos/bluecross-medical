package androidx.datastore.core.okio;

import w6.c;
import z8.j;
import z8.k;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface OkioSerializer<T> {
    T getDefaultValue();

    Object readFrom(k kVar, c cVar);

    Object writeTo(T t, j jVar, c cVar);
}

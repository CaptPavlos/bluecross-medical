package androidx.datastore.core;

import java.io.InputStream;
import java.io.OutputStream;
import w6.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public interface Serializer<T> {
    T getDefaultValue();

    Object readFrom(InputStream inputStream, c cVar);

    Object writeTo(T t, OutputStream outputStream, c cVar);
}

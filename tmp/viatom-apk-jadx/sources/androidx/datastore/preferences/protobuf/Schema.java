package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ArrayDecoders;
import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@CheckReturnValue
/* loaded from: classes.dex */
interface Schema<T> {
    boolean equals(T t, T t9);

    int getSerializedSize(T t);

    int hashCode(T t);

    boolean isInitialized(T t);

    void makeImmutable(T t);

    void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    void mergeFrom(T t, T t9);

    void mergeFrom(T t, byte[] bArr, int i10, int i11, ArrayDecoders.Registers registers) throws IOException;

    T newInstance();

    void writeTo(T t, Writer writer) throws IOException;
}

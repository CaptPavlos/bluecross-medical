package androidx.datastore;

import androidx.datastore.core.Serializer;
import androidx.datastore.core.okio.OkioSerializer;
import s6.w;
import w6.c;
import x6.a;
import z8.j;
import z8.k;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class OkioSerializerWrapper<T> implements OkioSerializer<T> {
    private final Serializer<T> delegate;

    public OkioSerializerWrapper(Serializer<T> serializer) {
        serializer.getClass();
        this.delegate = serializer;
    }

    @Override // androidx.datastore.core.okio.OkioSerializer
    public T getDefaultValue() {
        return this.delegate.getDefaultValue();
    }

    @Override // androidx.datastore.core.okio.OkioSerializer
    public Object readFrom(k kVar, c cVar) {
        return this.delegate.readFrom(kVar.inputStream(), cVar);
    }

    @Override // androidx.datastore.core.okio.OkioSerializer
    public Object writeTo(T t, j jVar, c cVar) {
        Object objWriteTo = this.delegate.writeTo(t, jVar.outputStream(), cVar);
        return objWriteTo == a.f13718a ? objWriteTo : w.f12711a;
    }
}

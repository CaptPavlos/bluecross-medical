package a3;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.Serializer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p0 implements Serializer {

    /* renamed from: a, reason: collision with root package name */
    public final a1 f151a;

    public p0(a1 a1Var) {
        a1Var.getClass();
        this.f151a = a1Var;
    }

    @Override // androidx.datastore.core.Serializer
    public final Object getDefaultValue() {
        return new o0(this.f151a.a(null), null, null);
    }

    @Override // androidx.datastore.core.Serializer
    public final Object readFrom(InputStream inputStream, w6.c cVar) throws CorruptionException {
        try {
            h8.b bVar = h8.b.f8825d;
            String strW = o7.u.W(a.a.J(inputStream));
            bVar.getClass();
            return (o0) bVar.a(o0.Companion.serializer(), strW);
        } catch (Exception e) {
            throw new CorruptionException("Cannot parse session data", e);
        }
    }

    @Override // androidx.datastore.core.Serializer
    public final Object writeTo(Object obj, OutputStream outputStream, w6.c cVar) throws IOException {
        byte[] bytes = h8.b.f8825d.b(o0.Companion.serializer(), (o0) obj).getBytes(o7.a.f11749a);
        bytes.getClass();
        outputStream.write(bytes);
        return s6.w.f12711a;
    }
}

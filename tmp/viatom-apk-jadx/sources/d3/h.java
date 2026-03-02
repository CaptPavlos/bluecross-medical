package d3;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.Serializer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import o7.u;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h implements Serializer {

    /* renamed from: a, reason: collision with root package name */
    public static final h f6819a = new h();

    /* renamed from: b, reason: collision with root package name */
    public static final g f6820b = new g(null, null, null, null, null);

    @Override // androidx.datastore.core.Serializer
    public final /* bridge */ /* synthetic */ Object getDefaultValue() {
        return f6820b;
    }

    @Override // androidx.datastore.core.Serializer
    public final Object readFrom(InputStream inputStream, w6.c cVar) throws CorruptionException {
        try {
            h8.b bVar = h8.b.f8825d;
            String strW = u.W(a.a.J(inputStream));
            bVar.getClass();
            return (g) bVar.a(g.Companion.serializer(), strW);
        } catch (Exception e) {
            throw new CorruptionException("Cannot parse session configs", e);
        }
    }

    @Override // androidx.datastore.core.Serializer
    public final Object writeTo(Object obj, OutputStream outputStream, w6.c cVar) throws IOException {
        byte[] bytes = h8.b.f8825d.b(g.Companion.serializer(), (g) obj).getBytes(o7.a.f11749a);
        bytes.getClass();
        outputStream.write(bytes);
        return w.f12711a;
    }
}

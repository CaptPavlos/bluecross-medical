package z8;

import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class f {
    public static /* synthetic */ void a() {
        throw new IllegalArgumentException();
    }

    public static /* synthetic */ void b(Object obj) {
        throw new IllegalArgumentException(obj.toString());
    }

    public static /* synthetic */ void c(Object obj, String str) throws IOException {
        throw new IOException(str + obj);
    }

    public static /* synthetic */ void d(Object obj, String str, Object obj2) throws IOException {
        throw new IOException(str + obj + ((Object) " to ") + obj2);
    }

    public static /* synthetic */ void e(Object obj, String str) throws FileNotFoundException {
        throw new FileNotFoundException(str + obj);
    }
}

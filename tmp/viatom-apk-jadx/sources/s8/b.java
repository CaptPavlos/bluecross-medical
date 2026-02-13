package s8;

import java.io.IOException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends RuntimeException {

    /* renamed from: b, reason: collision with root package name */
    public static final Method f12727b;

    /* renamed from: a, reason: collision with root package name */
    public IOException f12728a;

    static {
        Method declaredMethod;
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            declaredMethod = null;
        }
        f12727b = declaredMethod;
    }

    public b(IOException iOException) {
        super(iOException);
        this.f12728a = iOException;
    }
}

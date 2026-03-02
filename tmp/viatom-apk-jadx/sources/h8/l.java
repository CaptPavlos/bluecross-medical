package h8;

import g8.b1;
import g8.o0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final g8.y f8839a = o0.a("kotlinx.serialization.json.JsonUnquotedLiteral", b1.f8241a);

    public static final int a(x xVar) {
        try {
            long jK = new a6.f(xVar.c()).k();
            if (-2147483648L <= jK && jK <= 2147483647L) {
                return (int) jK;
            }
            throw new NumberFormatException(xVar.c() + " is not an Int");
        } catch (i8.h e) {
            throw new NumberFormatException(e.getMessage());
        }
    }

    public static final x b(k kVar) {
        x xVar = kVar instanceof x ? (x) kVar : null;
        if (xVar != null) {
            return xVar;
        }
        androidx.constraintlayout.core.state.b.j(kotlin.jvm.internal.y.a(kVar.getClass()), "Element ", " is not a JsonPrimitive");
        return null;
    }
}

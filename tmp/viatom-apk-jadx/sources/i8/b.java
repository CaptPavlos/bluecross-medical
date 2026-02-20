package i8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int f9063a;

    static {
        Object jVar;
        try {
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            property.getClass();
            jVar = o7.t.U(property);
        } catch (Throwable th) {
            jVar = new s6.j(th);
        }
        if (jVar instanceof s6.j) {
            jVar = null;
        }
        Integer num = (Integer) jVar;
        f9063a = num != null ? num.intValue() : 2097152;
    }
}

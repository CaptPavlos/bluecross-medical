package z8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final w f14501a;

    static {
        w wVar;
        try {
            Class.forName("java.nio.file.Files");
            wVar = new x();
        } catch (ClassNotFoundException unused) {
            wVar = new w();
        }
        f14501a = wVar;
        String str = z.f14517b;
        String property = System.getProperty("java.io.tmpdir");
        property.getClass();
        t3.h.i(property, false);
        ClassLoader classLoader = a9.g.class.getClassLoader();
        classLoader.getClass();
        new a9.g(classLoader);
    }

    public abstract void a(z zVar, z zVar2);

    public abstract void b(z zVar);

    public abstract void c(z zVar);

    public final boolean d(z zVar) {
        zVar.getClass();
        return e(zVar) != null;
    }

    public abstract o e(z zVar);

    public abstract v f(z zVar);

    public abstract v g(z zVar);

    public abstract h0 h(z zVar);
}

package kotlin.jvm.internal;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    public static final z f10139a;

    static {
        z zVar = null;
        try {
            zVar = (z) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (zVar == null) {
            zVar = new z();
        }
        f10139a = zVar;
    }

    public static f a(Class cls) {
        f10139a.getClass();
        return new f(cls);
    }
}

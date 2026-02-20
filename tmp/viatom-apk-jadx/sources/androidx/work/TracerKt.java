package androidx.work;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class TracerKt {
    public static final <T> T traced(Tracer tracer, String str, g7.a aVar) {
        tracer.getClass();
        str.getClass();
        aVar.getClass();
        boolean zIsEnabled = tracer.isEnabled();
        if (zIsEnabled) {
            try {
                tracer.beginSection(str);
            } catch (Throwable th) {
                if (zIsEnabled) {
                    tracer.endSection();
                }
                throw th;
            }
        }
        T t = (T) aVar.invoke();
        if (zIsEnabled) {
            tracer.endSection();
        }
        return t;
    }
}

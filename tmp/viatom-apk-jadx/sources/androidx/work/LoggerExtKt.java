package androidx.work;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class LoggerExtKt {
    public static final void logd(String str, Throwable th, g7.a aVar) {
        str.getClass();
        th.getClass();
        aVar.getClass();
        Logger.get().debug(str, (String) aVar.invoke(), th);
    }

    public static final void loge(String str, Throwable th, g7.a aVar) {
        str.getClass();
        th.getClass();
        aVar.getClass();
        Logger.get().error(str, (String) aVar.invoke(), th);
    }

    public static final void logi(String str, Throwable th, g7.a aVar) {
        str.getClass();
        th.getClass();
        aVar.getClass();
        Logger.get().info(str, (String) aVar.invoke(), th);
    }

    public static final void logd(String str, g7.a aVar) {
        str.getClass();
        aVar.getClass();
        Logger.get().debug(str, (String) aVar.invoke());
    }

    public static final void loge(String str, g7.a aVar) {
        str.getClass();
        aVar.getClass();
        Logger.get().error(str, (String) aVar.invoke());
    }

    public static final void logi(String str, g7.a aVar) {
        str.getClass();
        aVar.getClass();
        Logger.get().info(str, (String) aVar.invoke());
    }
}

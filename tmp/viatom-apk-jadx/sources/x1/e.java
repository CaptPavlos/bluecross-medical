package x1;

import android.util.Log;
import java.util.concurrent.ExecutorService;
import r0.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: d, reason: collision with root package name */
    public static final d f13575d = new d();

    /* renamed from: a, reason: collision with root package name */
    public final b f13576a;

    /* renamed from: b, reason: collision with root package name */
    public final b f13577b;

    /* renamed from: c, reason: collision with root package name */
    public final b f13578c;

    public e(ExecutorService executorService, ExecutorService executorService2) {
        executorService.getClass();
        executorService2.getClass();
        this.f13576a = new b(executorService);
        this.f13577b = new b(executorService);
        f.x(null);
        this.f13578c = new b(executorService2);
    }

    public static final void a() {
        if (((Boolean) new c(0, f13575d, d.class, "isBackgroundThread", "isBackgroundThread()Z", 0, 0).invoke()).booleanValue()) {
            return;
        }
        String str = "Must be called on a background thread, was called on " + Thread.currentThread().getName() + '.';
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
    }

    public static final void b() {
        if (((Boolean) new c(0, f13575d, d.class, "isBlockingThread", "isBlockingThread()Z", 0, 1).invoke()).booleanValue()) {
            return;
        }
        String str = "Must be called on a blocking thread, was called on " + Thread.currentThread().getName() + '.';
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
    }
}

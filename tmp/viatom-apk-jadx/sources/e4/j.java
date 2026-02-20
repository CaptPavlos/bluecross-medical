package e4;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f7667a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f7668b = new ConcurrentHashMap();

    public j() {
        new AtomicLong(0L);
    }

    @JavascriptInterface
    public final void sendBooleanValue(final long j10, final boolean z9) {
        this.f7667a.post(new Runnable(j10, z9) { // from class: e4.i

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f7666b;

            @Override // java.lang.Runnable
            public final void run() {
                if (this.f7665a.f7668b.remove(Long.valueOf(this.f7666b)) == null) {
                    return;
                }
                com.google.gson.internal.a.k();
            }
        });
    }
}

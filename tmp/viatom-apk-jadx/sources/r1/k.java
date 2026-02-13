package r1;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public static final k f12340a;

    /* renamed from: b, reason: collision with root package name */
    public static final Handler f12341b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ k[] f12342c;

    static {
        k kVar = new k("INSTANCE", 0);
        f12340a = kVar;
        f12342c = new k[]{kVar};
        f12341b = new Handler(Looper.getMainLooper());
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) f12342c.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        f12341b.post(runnable);
    }
}

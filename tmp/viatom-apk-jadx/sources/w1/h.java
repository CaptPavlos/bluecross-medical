package w1;

import android.util.Log;
import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: d, reason: collision with root package name */
    public static final c2.a f13337d = new c2.a(2);
    public static final a6.h e = new a6.h(7);

    /* renamed from: a, reason: collision with root package name */
    public final c2.d f13338a;

    /* renamed from: b, reason: collision with root package name */
    public String f13339b = null;

    /* renamed from: c, reason: collision with root package name */
    public String f13340c = null;

    public h(c2.d dVar) {
        this.f13338a = dVar;
    }

    public static void a(c2.d dVar, String str, String str2) throws IOException {
        if (str == null || str2 == null) {
            return;
        }
        try {
            dVar.h(str, "aqs.".concat(str2)).createNewFile();
        } catch (IOException e3) {
            Log.w("FirebaseCrashlytics", "Failed to persist App Quality Sessions session id.", e3);
        }
    }
}

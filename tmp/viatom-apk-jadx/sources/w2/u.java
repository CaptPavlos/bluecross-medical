package w2;

import a3.z0;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u {

    /* renamed from: d, reason: collision with root package name */
    public static WeakReference f13473d;

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f13474a;

    /* renamed from: b, reason: collision with root package name */
    public z0 f13475b;

    /* renamed from: c, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f13476c;

    public u(SharedPreferences sharedPreferences, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.f13476c = scheduledThreadPoolExecutor;
        this.f13474a = sharedPreferences;
    }

    public final synchronized t a() {
        t tVar;
        String strL = this.f13475b.l();
        Pattern pattern = t.f13469d;
        tVar = null;
        if (!TextUtils.isEmpty(strL)) {
            String[] strArrSplit = strL.split("!", -1);
            if (strArrSplit.length == 2) {
                tVar = new t(strArrSplit[0], strArrSplit[1]);
            }
        }
        return tVar;
    }

    public final synchronized void b() {
        this.f13475b = z0.i(this.f13474a, this.f13476c);
    }

    public final synchronized void c(t tVar) {
        this.f13475b.m(tVar.f13472c);
    }
}

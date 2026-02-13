package t1;

import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;
import q1.o;
import z1.k1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final d f12747c = new d();

    /* renamed from: a, reason: collision with root package name */
    public final o f12748a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f12749b = new AtomicReference(null);

    public b(o oVar) {
        this.f12748a = oVar;
        oVar.a(new androidx.core.view.inputmethod.a(this, 29));
    }

    public final d a() {
        b bVar = (b) this.f12749b.get();
        return bVar == null ? f12747c : bVar.a();
    }

    public final boolean b() {
        b bVar = (b) this.f12749b.get();
        return bVar != null && bVar.b();
    }

    public final boolean c() {
        b bVar = (b) this.f12749b.get();
        return bVar != null && bVar.c();
    }

    public final void d(String str, long j10, k1 k1Var) {
        String strI = a3.a.i("Deferring native open session: ", str);
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", strI, null);
        }
        this.f12748a.a(new a(str, j10, k1Var));
    }
}

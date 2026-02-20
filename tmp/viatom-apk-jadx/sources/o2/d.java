package o2;

import android.content.Context;
import androidx.core.os.UserManagerCompat;
import h1.p;
import java.util.Set;
import java.util.concurrent.Executor;
import q1.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d implements f, g {

    /* renamed from: a, reason: collision with root package name */
    public final m f11678a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f11679b;

    /* renamed from: c, reason: collision with root package name */
    public final q2.b f11680c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f11681d;
    public final Executor e;

    public d(Context context, String str, Set set, q2.b bVar, Executor executor) {
        this.f11678a = new m(new l1.c(context, str));
        this.f11681d = set;
        this.e = executor;
        this.f11680c = bVar;
        this.f11679b = context;
    }

    public final synchronized int a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        i iVar = (i) this.f11678a.get();
        if (!iVar.i(jCurrentTimeMillis)) {
            return 1;
        }
        iVar.g();
        return 3;
    }

    public final p b() {
        if (!UserManagerCompat.isUserUnlocked(this.f11679b)) {
            return r0.f.x("");
        }
        return r0.f.m(this.e, new c(this, 0));
    }

    public final void c() {
        if (this.f11681d.size() <= 0) {
            r0.f.x(null);
        } else if (!UserManagerCompat.isUserUnlocked(this.f11679b)) {
            r0.f.x(null);
        } else {
            r0.f.m(this.e, new c(this, 1));
        }
    }
}

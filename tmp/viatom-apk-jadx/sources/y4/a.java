package y4;

import android.os.Looper;
import com.google.android.gms.internal.measurement.a4;
import java.util.Arrays;
import java.util.HashSet;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {
    public final String[] f;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ HashSet f13793i;

    /* renamed from: a, reason: collision with root package name */
    public int f13789a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f13790b = 0;

    /* renamed from: c, reason: collision with root package name */
    public a5.a f13791c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13792d = false;
    public boolean e = false;
    public boolean g = false;
    public boolean h = false;

    public a(String[] strArr, HashSet hashSet) {
        this.f13793i = hashSet;
        this.f = strArr;
        Looper.myLooper();
        a4.x("CommandHandler not created");
    }

    public final void a() {
        if (this.h) {
            return;
        }
        synchronized (this) {
            a4.x("Command 158 finished.");
            this.e = false;
            this.g = true;
            notifyAll();
        }
    }

    public final String b() {
        return this.f[0];
    }

    public final void c(String str) {
        this.f13789a++;
        this.f13793i.addAll(Arrays.asList(str.split(" ")));
        a4.w("ID: 158, " + str);
        this.f13790b = this.f13790b + 1;
    }

    public final void d(int i10) {
        synchronized (this) {
        }
    }

    public final void e() {
        this.f13792d = true;
        a5.a aVar = new a5.a(this, this);
        this.f13791c = aVar;
        aVar.setPriority(1);
        this.f13791c.start();
        this.e = true;
    }

    public final void f(String str) {
        synchronized (this) {
            a4.x("Command 158 did not finish because it was terminated. Termination reason: ".concat(str));
            d(-1);
            this.h = true;
            this.e = false;
            this.g = true;
            notifyAll();
        }
    }
}

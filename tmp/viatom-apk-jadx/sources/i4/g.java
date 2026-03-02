package i4;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g implements e4.e {

    /* renamed from: a, reason: collision with root package name */
    public final f f9002a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f9003b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    public final Object f9004c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet f9005d = new LinkedHashSet();

    public g(f fVar, e4.j jVar) {
        this.f9002a = fVar;
    }

    public final boolean a(f4.a aVar) {
        boolean zAdd;
        aVar.getClass();
        synchronized (this.f9004c) {
            zAdd = this.f9005d.add(aVar);
        }
        return zAdd;
    }

    public final void b(String str, float f) {
        str.getClass();
        c(this.f9002a, "cueVideo", str, Float.valueOf(f));
    }

    public final void c(f fVar, String str, Object... objArr) {
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(obj instanceof String ? a3.a.m(new StringBuilder("'"), (String) obj, '\'') : obj.toString());
        }
        this.f9003b.post(new androidx.work.impl.c(fVar, str, arrayList, 2));
    }

    public final void d(String str, float f) {
        str.getClass();
        c(this.f9002a, "loadVideo", str, Float.valueOf(f));
    }

    public final void e() {
        c(this.f9002a, "pauseVideo", new Object[0]);
    }

    public final void f() {
        c(this.f9002a, "playVideo", new Object[0]);
    }
}

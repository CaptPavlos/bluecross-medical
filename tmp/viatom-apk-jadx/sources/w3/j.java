package w3;

import android.os.Handler;

/* loaded from: classes3.dex */
public final class j implements d {
    public static j e;

    /* renamed from: a, reason: collision with root package name */
    public float f13512a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    public final t3.h f13513b;

    /* renamed from: c, reason: collision with root package name */
    public v3.a f13514c;

    /* renamed from: d, reason: collision with root package name */
    public c f13515d;

    public j(t3.h hVar, t3.h hVar2) {
        this.f13513b = hVar2;
    }

    public static j b() {
        if (e == null) {
            e = new j(new t3.h(9), new t3.h(8));
        }
        return e;
    }

    @Override // w3.d
    public final void a(boolean z9) {
        if (z9) {
            a4.c.f.getClass();
            a4.c.b();
            return;
        }
        a4.c.f.getClass();
        Handler handler = a4.c.h;
        if (handler != null) {
            handler.removeCallbacks(a4.c.f204j);
            a4.c.h = null;
        }
    }
}

package i0;

import android.os.Bundle;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public Boolean f8950a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f8951b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f8952c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8953d;
    public final Bundle e;
    public final /* synthetic */ e f;

    public t(e eVar, int i10, Bundle bundle) {
        this.f = eVar;
        Boolean bool = Boolean.TRUE;
        this.f8952c = eVar;
        this.f8950a = bool;
        this.f8951b = false;
        this.f8953d = i10;
        this.e = bundle;
    }

    public abstract void a(f0.b bVar);

    public abstract boolean b();

    public final void c() {
        synchronized (this) {
            this.f8950a = null;
        }
    }

    public final void d() {
        c();
        synchronized (this.f8952c.f8872l) {
            this.f8952c.f8872l.remove(this);
        }
    }
}

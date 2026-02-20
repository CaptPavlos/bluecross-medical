package j4;

import android.os.HandlerThread;
import android.os.Looper;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    public final y2.c f9956a;

    /* renamed from: b, reason: collision with root package name */
    public final l f9957b;

    /* renamed from: c, reason: collision with root package name */
    public long f9958c;

    /* renamed from: d, reason: collision with root package name */
    public long f9959d;
    public long e;
    public long f;
    public long g;
    public long h;

    /* renamed from: i, reason: collision with root package name */
    public long f9960i;

    /* renamed from: j, reason: collision with root package name */
    public long f9961j;

    /* renamed from: k, reason: collision with root package name */
    public int f9962k;

    /* renamed from: l, reason: collision with root package name */
    public int f9963l;

    /* renamed from: m, reason: collision with root package name */
    public int f9964m;

    public g0(y2.c cVar) {
        this.f9956a = cVar;
        HandlerThread handlerThread = new HandlerThread("Picasso-Stats", 10);
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        StringBuilder sb = l0.f9987a;
        com.google.android.gms.internal.measurement.h0 h0Var = new com.google.android.gms.internal.measurement.h0(looper, 2, false);
        h0Var.sendMessageDelayed(h0Var.obtainMessage(), 1000L);
        this.f9957b = new l(handlerThread.getLooper(), this, 1);
    }

    public final h0 a() {
        r rVar = (r) this.f9956a.f13781b;
        return new h0(rVar.maxSize(), rVar.size(), this.f9958c, this.f9959d, this.e, this.f, this.g, this.h, this.f9960i, this.f9961j, this.f9962k, this.f9963l, this.f9964m, System.currentTimeMillis());
    }
}

package v;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import j$.util.Objects;
import p.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f13099a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f13100b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13101c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Runnable f13102d;

    public /* synthetic */ d(h hVar, i iVar, int i10, Runnable runnable) {
        this.f13099a = hVar;
        this.f13100b = iVar;
        this.f13101c = i10;
        this.f13102d = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final i iVar = this.f13100b;
        final int i10 = this.f13101c;
        Runnable runnable = this.f13102d;
        final h hVar = this.f13099a;
        x.c cVar = hVar.f;
        try {
            try {
                w.d dVar = hVar.f13113c;
                Objects.requireNonNull(dVar);
                ((w.h) cVar).h(new e(dVar, 1));
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) hVar.f13111a.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    ((w.h) cVar).h(new x.b() { // from class: v.f
                        @Override // x.b
                        public final Object execute() {
                            hVar.f13114d.g(iVar, i10 + 1, false);
                            return null;
                        }
                    });
                } else {
                    hVar.a(iVar, i10);
                }
                runnable.run();
            } catch (x.a unused) {
                hVar.f13114d.g(iVar, i10 + 1, false);
                runnable.run();
            }
        } catch (Throwable th) {
            runnable.run();
            throw th;
        }
    }
}

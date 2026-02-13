package v4;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.l;
import l4.n5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final n5 f13134a;

    /* renamed from: b, reason: collision with root package name */
    public final NsdManager f13135b;

    /* renamed from: c, reason: collision with root package name */
    public e f13136c;

    /* renamed from: d, reason: collision with root package name */
    public d f13137d;
    public c e;
    public NsdServiceInfo f;
    public final ArrayList g;

    public f(Context context, n5 n5Var) {
        context.getClass();
        n5Var.getClass();
        this.f13134a = n5Var;
        Object systemService = context.getSystemService("servicediscovery");
        systemService.getClass();
        this.f13135b = (NsdManager) systemService;
        this.g = new ArrayList();
    }

    public static final void a(f fVar, NsdServiceInfo nsdServiceInfo) {
        String serviceName = nsdServiceInfo.getServiceName();
        String str = o4.b.f11715n;
        if (str == null) {
            l.i("myNsdServiceName");
            throw null;
        }
        if (l.a(serviceName, str)) {
            return;
        }
        fVar.f = nsdServiceInfo;
        fVar.f13134a.getClass();
        a aVar = o4.b.f11721u;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void b() {
        if (this.e == null) {
            c cVar = new c(this);
            this.e = cVar;
            try {
                this.f13135b.discoverServices("_nsduptodown._tcp.", 1, cVar);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                Object obj = this.f13134a.f10654b;
            }
        }
    }

    public final void c() {
        d dVar;
        c cVar = this.e;
        NsdManager nsdManager = this.f13135b;
        if (cVar != null) {
            try {
                nsdManager.stopServiceDiscovery(cVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.e = null;
        }
        if (Build.VERSION.SDK_INT >= 34 && (dVar = this.f13137d) != null) {
            try {
                nsdManager.unregisterServiceInfoCallback(dVar);
            } catch (IllegalArgumentException unused) {
            }
        }
        this.g.clear();
        this.f = null;
    }

    public final void d(NsdServiceInfo nsdServiceInfo) {
        d dVar;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 34) {
            if (this.f13137d == null) {
                this.f13137d = new d(this);
            }
        } else if (this.f13136c == null) {
            this.f13136c = new e(this);
        }
        NsdManager nsdManager = this.f13135b;
        if (i10 < 34) {
            nsdManager.resolveService(nsdServiceInfo, this.f13136c);
            return;
        }
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        if (scheduledExecutorServiceNewSingleThreadScheduledExecutor == null || (dVar = this.f13137d) == null) {
            return;
        }
        nsdManager.registerServiceInfoCallback(nsdServiceInfo, scheduledExecutorServiceNewSingleThreadScheduledExecutor, dVar);
    }
}

package j4;

import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import c1.e5;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import java.util.concurrent.Future;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final Context f9990a;

    /* renamed from: b, reason: collision with root package name */
    public final b0 f9991b;

    /* renamed from: c, reason: collision with root package name */
    public final d0.i f9992c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f9993d;
    public final WeakHashMap e;
    public final WeakHashMap f;
    public final LinkedHashSet g;
    public final l h;

    /* renamed from: i, reason: collision with root package name */
    public final Handler f9994i;

    /* renamed from: j, reason: collision with root package name */
    public final y2.c f9995j;

    /* renamed from: k, reason: collision with root package name */
    public final g0 f9996k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f9997l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f9998m;

    /* JADX WARN: Multi-variable type inference failed */
    public n(Context context, b0 b0Var, Handler handler, d0.i iVar, y2.c cVar, g0 g0Var) {
        m mVar = new m("Picasso-Dispatcher", 10);
        mVar.start();
        Looper looper = mVar.getLooper();
        StringBuilder sb = l0.f9987a;
        int i10 = 2;
        com.google.android.gms.internal.measurement.h0 h0Var = new com.google.android.gms.internal.measurement.h0(looper, 2, false);
        h0Var.sendMessageDelayed(h0Var.obtainMessage(), 1000L);
        this.f9990a = context;
        this.f9991b = b0Var;
        this.f9993d = new LinkedHashMap();
        this.e = new WeakHashMap();
        this.f = new WeakHashMap();
        this.g = new LinkedHashSet();
        this.h = new l(mVar.getLooper(), this, 0 == true ? 1 : 0);
        this.f9992c = iVar;
        this.f9994i = handler;
        this.f9995j = cVar;
        this.f9996k = g0Var;
        this.f9997l = new ArrayList(4);
        try {
            Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (NullPointerException | SecurityException unused) {
        }
        this.f9998m = context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0;
        e5 e5Var = new e5(this, i10);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        n nVar = (n) e5Var.f1153b;
        if (nVar.f9998m) {
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        nVar.f9990a.registerReceiver(e5Var, intentFilter);
    }

    public final void a(f fVar) {
        Future future = fVar.f9950m;
        if (future == null || !future.isCancelled()) {
            Bitmap bitmap = fVar.f9949l;
            if (bitmap != null) {
                bitmap.prepareToDraw();
            }
            this.f9997l.add(fVar);
            l lVar = this.h;
            if (lVar.hasMessages(7)) {
                return;
            }
            lVar.sendEmptyMessageDelayed(7, 200L);
        }
    }

    public final void b(f fVar) {
        l lVar = this.h;
        lVar.sendMessage(lVar.obtainMessage(4, fVar));
    }

    public final void c(f fVar, boolean z9) {
        fVar.f9943b.getClass();
        this.f9993d.remove(fVar.f);
        a(fVar);
    }

    public final void d(b bVar, boolean z9) {
        b bVar2 = bVar.e;
        String str = bVar.f9920d;
        if (this.g.contains(bVar2)) {
            this.f.put(bVar.d(), bVar);
            return;
        }
        LinkedHashMap linkedHashMap = this.f9993d;
        f fVar = (f) linkedHashMap.get(str);
        if (fVar != null) {
            fVar.f9943b.getClass();
            if (fVar.f9947j == null) {
                fVar.f9947j = bVar;
                return;
            }
            if (fVar.f9948k == null) {
                fVar.f9948k = new ArrayList(3);
            }
            fVar.f9948k.add(bVar);
            int i10 = bVar.f9918b.h;
            if (c.i.c(i10) > c.i.c(fVar.f9955r)) {
                fVar.f9955r = i10;
                return;
            }
            return;
        }
        b0 b0Var = this.f9991b;
        boolean zIsShutdown = b0Var.isShutdown();
        y yVar = bVar.f9917a;
        if (zIsShutdown) {
            return;
        }
        f fVarE = f.e(yVar, this, this.f9995j, this.f9996k, bVar);
        fVarE.f9950m = b0Var.submit(fVarE);
        linkedHashMap.put(str, fVarE);
        if (z9) {
            this.e.remove(bVar.d());
        }
    }
}

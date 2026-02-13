package h0;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import androidx.collection.ArraySet;
import androidx.core.app.PendingIntentCompat;
import androidx.work.WorkRequest;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.measurement.h0;
import i0.j0;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements Handler.Callback {

    /* renamed from: o, reason: collision with root package name */
    public static final Status f8359o = new Status(4, "Sign-out occurred while this API call was in progress.", null, null);

    /* renamed from: p, reason: collision with root package name */
    public static final Status f8360p = new Status(4, "The user must be signed in to make this API call.", null, null);

    /* renamed from: q, reason: collision with root package name */
    public static final Object f8361q = new Object();

    /* renamed from: r, reason: collision with root package name */
    public static e f8362r;

    /* renamed from: a, reason: collision with root package name */
    public long f8363a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f8364b;

    /* renamed from: c, reason: collision with root package name */
    public i0.n f8365c;

    /* renamed from: d, reason: collision with root package name */
    public k0.b f8366d;
    public final Context e;
    public final f0.e f;
    public final i0.k g;
    public final AtomicInteger h;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicInteger f8367i;

    /* renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap f8368j;

    /* renamed from: k, reason: collision with root package name */
    public final ArraySet f8369k;

    /* renamed from: l, reason: collision with root package name */
    public final ArraySet f8370l;

    /* renamed from: m, reason: collision with root package name */
    public final h0 f8371m;

    /* renamed from: n, reason: collision with root package name */
    public volatile boolean f8372n;

    public e(Context context, Looper looper) {
        f0.e eVar = f0.e.f8001d;
        this.f8363a = WorkRequest.MIN_BACKOFF_MILLIS;
        this.f8364b = false;
        this.h = new AtomicInteger(1);
        this.f8367i = new AtomicInteger(0);
        this.f8368j = new ConcurrentHashMap(5, 0.75f, 1);
        this.f8369k = new ArraySet();
        this.f8370l = new ArraySet();
        this.f8372n = true;
        this.e = context;
        h0 h0Var = new h0(looper, this, 3);
        Looper.getMainLooper();
        this.f8371m = h0Var;
        this.f = eVar;
        this.g = new i0.k(2);
        PackageManager packageManager = context.getPackageManager();
        if (n0.b.f == null) {
            n0.b.f = Boolean.valueOf(n0.b.a() && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (n0.b.f.booleanValue()) {
            this.f8372n = false;
        }
        h0Var.sendMessage(h0Var.obtainMessage(6));
    }

    public static Status b(a aVar, f0.b bVar) {
        return new Status(17, "API: " + ((String) aVar.f8348b.f219c) + " is not available on this device. Connection failed with: " + String.valueOf(bVar), bVar.f7992c, bVar);
    }

    public static e d(Context context) {
        e eVar;
        synchronized (f8361q) {
            try {
                if (f8362r == null) {
                    Looper looper = j0.b().getLooper();
                    Context applicationContext = context.getApplicationContext();
                    Object obj = f0.e.f8000c;
                    f8362r = new e(applicationContext, looper);
                }
                eVar = f8362r;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    public final boolean a(f0.b bVar, int i10) throws Resources.NotFoundException {
        f0.e eVar = this.f;
        eVar.getClass();
        Context context = this.e;
        if (!p0.a.a(context)) {
            int i11 = bVar.f7991b;
            PendingIntent activity = bVar.f7992c;
            if (!((i11 == 0 || activity == null) ? false : true)) {
                activity = null;
                Intent intentA = eVar.a(context, i11, null);
                if (intentA != null) {
                    activity = PendingIntentCompat.getActivity(context, 0, intentA, 134217728, false);
                }
            }
            if (activity != null) {
                int i12 = GoogleApiActivity.f1853b;
                Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
                intent.putExtra("pending_intent", activity);
                intent.putExtra("failing_client_id", i10);
                intent.putExtra("notify_manager", true);
                eVar.g(context, i11, PendingIntent.getActivity(context, 0, intent, v0.d.f13119a | 134217728));
                return true;
            }
        }
        return false;
    }

    public final n c(g0.d dVar) {
        a aVar = dVar.e;
        ConcurrentHashMap concurrentHashMap = this.f8368j;
        n nVar = (n) concurrentHashMap.get(aVar);
        if (nVar == null) {
            nVar = new n(this, dVar);
            concurrentHashMap.put(aVar, nVar);
        }
        if (nVar.f8381b.l()) {
            this.f8370l.add(aVar);
        }
        nVar.m();
        return nVar;
    }

    public final void e(f0.b bVar, int i10) {
        if (a(bVar, i10)) {
            return;
        }
        h0 h0Var = this.f8371m;
        h0Var.sendMessage(h0Var.obtainMessage(5, i10, 0, bVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:164:0x0306  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean handleMessage(android.os.Message r17) {
        /*
            Method dump skipped, instructions count: 1086
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.e.handleMessage(android.os.Message):boolean");
    }
}

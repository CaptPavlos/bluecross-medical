package g1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.measurement.u6;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import i0.y;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import n0.d;
import n0.e;
import p0.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: n, reason: collision with root package name */
    public static volatile ScheduledExecutorService f8197n;

    /* renamed from: o, reason: collision with root package name */
    public static final Object f8198o = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Object f8199a;

    /* renamed from: b, reason: collision with root package name */
    public final PowerManager.WakeLock f8200b;

    /* renamed from: c, reason: collision with root package name */
    public int f8201c;

    /* renamed from: d, reason: collision with root package name */
    public ScheduledFuture f8202d;
    public long e;
    public final HashSet f;
    public boolean g;
    public y0.a h;

    /* renamed from: i, reason: collision with root package name */
    public final n0.a f8203i;

    /* renamed from: j, reason: collision with root package name */
    public final String f8204j;

    /* renamed from: k, reason: collision with root package name */
    public final HashMap f8205k;

    /* renamed from: l, reason: collision with root package name */
    public final AtomicInteger f8206l;

    /* renamed from: m, reason: collision with root package name */
    public final ScheduledExecutorService f8207m;

    public a(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String packageName = context.getPackageName();
        this.f8199a = new Object();
        this.f8201c = 0;
        this.f = new HashSet();
        this.g = true;
        this.f8203i = n0.a.f11266a;
        this.f8205k = new HashMap();
        this.f8206l = new AtomicInteger(0);
        y.e("wake:com.google.firebase.iid.WakeLockHolder", "WakeLock: wakeLockName must not be empty");
        context.getApplicationContext();
        WorkSource workSource = null;
        this.h = null;
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.f8204j = "wake:com.google.firebase.iid.WakeLockHolder";
        } else {
            this.f8204j = "wake:com.google.firebase.iid.WakeLockHolder".length() != 0 ? "*gcore*:".concat("wake:com.google.firebase.iid.WakeLockHolder") : new String("*gcore*:");
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            StringBuilder sb = new StringBuilder(29);
            sb.append((CharSequence) "expected a non-null reference", 0, 29);
            throw new u6(sb.toString());
        }
        this.f8200b = powerManager.newWakeLock(1, "wake:com.google.firebase.iid.WakeLockHolder");
        if (e.a(context)) {
            int i10 = d.f11274a;
            packageName = (packageName == null || packageName.trim().isEmpty()) ? context.getPackageName() : packageName;
            if (context.getPackageManager() != null && packageName != null) {
                try {
                    ApplicationInfo applicationInfoA = c.a(context).a(0, packageName);
                    if (applicationInfoA == null) {
                        Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(packageName));
                    } else {
                        int i11 = applicationInfoA.uid;
                        workSource = new WorkSource();
                        Method method = e.f11276b;
                        if (method != null) {
                            try {
                                method.invoke(workSource, Integer.valueOf(i11), packageName);
                            } catch (Exception e) {
                                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
                            }
                        } else {
                            Method method2 = e.f11275a;
                            if (method2 != null) {
                                try {
                                    method2.invoke(workSource, Integer.valueOf(i11));
                                } catch (Exception e3) {
                                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
                                }
                            }
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    Log.e("WorkSourceUtil", "Could not find package: ".concat(packageName));
                }
            }
            if (workSource != null) {
                try {
                    this.f8200b.setWorkSource(workSource);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e7) {
                    Log.wtf("WakeLock", e7.toString());
                }
            }
        }
        ScheduledExecutorService scheduledExecutorServiceUnconfigurableScheduledExecutorService = f8197n;
        if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
            synchronized (f8198o) {
                try {
                    scheduledExecutorServiceUnconfigurableScheduledExecutorService = f8197n;
                    if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
                        scheduledExecutorServiceUnconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                        f8197n = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
                    }
                } finally {
                }
            }
        }
        this.f8207m = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
    }

    public final void a() {
        this.f8206l.incrementAndGet();
        long jMin = Math.min(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS, Math.max(Math.min(Long.MAX_VALUE, 31622400000L), 1L));
        synchronized (this.f8199a) {
            try {
                if (!b()) {
                    this.h = y0.a.f13742a;
                    this.f8200b.acquire();
                    this.f8203i.getClass();
                    SystemClock.elapsedRealtime();
                }
                this.f8201c++;
                if (this.g) {
                    TextUtils.isEmpty(null);
                }
                b bVar = (b) this.f8205k.get(null);
                if (bVar == null) {
                    bVar = new b();
                    this.f8205k.put(null, bVar);
                }
                bVar.f8208a++;
                this.f8203i.getClass();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j10 = Long.MAX_VALUE - jElapsedRealtime > jMin ? jElapsedRealtime + jMin : Long.MAX_VALUE;
                if (j10 > this.e) {
                    this.e = j10;
                    ScheduledFuture scheduledFuture = this.f8202d;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    this.f8202d = this.f8207m.schedule(new a4.a(this, 9), jMin, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b() {
        boolean z9;
        synchronized (this.f8199a) {
            z9 = this.f8201c > 0;
        }
        return z9;
    }

    public final void c() {
        if (this.f8206l.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.f8204j).concat(" release without a matched acquire!"));
        }
        synchronized (this.f8199a) {
            try {
                if (this.g) {
                    TextUtils.isEmpty(null);
                }
                if (this.f8205k.containsKey(null)) {
                    b bVar = (b) this.f8205k.get(null);
                    if (bVar != null) {
                        int i10 = bVar.f8208a - 1;
                        bVar.f8208a = i10;
                        if (i10 == 0) {
                            this.f8205k.remove(null);
                        }
                    }
                } else {
                    Log.w("WakeLock", String.valueOf(this.f8204j).concat(" counter does not exist"));
                }
                e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        HashSet hashSet = this.f;
        if (hashSet.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        hashSet.clear();
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        com.google.gson.internal.a.k();
    }

    public final void e() {
        synchronized (this.f8199a) {
            try {
                if (b()) {
                    if (this.g) {
                        int i10 = this.f8201c - 1;
                        this.f8201c = i10;
                        if (i10 > 0) {
                            return;
                        }
                    } else {
                        this.f8201c = 0;
                    }
                    d();
                    Iterator it = this.f8205k.values().iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).f8208a = 0;
                    }
                    this.f8205k.clear();
                    ScheduledFuture scheduledFuture = this.f8202d;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                        this.f8202d = null;
                        this.e = 0L;
                    }
                    if (this.f8200b.isHeld()) {
                        try {
                            try {
                                this.f8200b.release();
                                if (this.h != null) {
                                    this.h = null;
                                }
                            } catch (RuntimeException e) {
                                if (!e.getClass().equals(RuntimeException.class)) {
                                    throw e;
                                }
                                Log.e("WakeLock", String.valueOf(this.f8204j).concat(" failed to release!"), e);
                                if (this.h != null) {
                                    this.h = null;
                                }
                            }
                        } catch (Throwable th) {
                            if (this.h != null) {
                                this.h = null;
                            }
                            throw th;
                        }
                    } else {
                        Log.e("WakeLock", String.valueOf(this.f8204j).concat(" should be held!"));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}

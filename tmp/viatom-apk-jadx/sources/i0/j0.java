package i0;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.work.PeriodicWorkRequest;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j0 {
    public static final Object g = new Object();
    public static j0 h;

    /* renamed from: i, reason: collision with root package name */
    public static HandlerThread f8917i;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f8918a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Context f8919b;

    /* renamed from: c, reason: collision with root package name */
    public volatile com.google.android.gms.internal.measurement.h0 f8920c;

    /* renamed from: d, reason: collision with root package name */
    public final m0.a f8921d;
    public final long e;
    public final long f;

    public j0(Context context, Looper looper) {
        i0 i0Var = new i0(this);
        this.f8919b = context.getApplicationContext();
        com.google.android.gms.internal.measurement.h0 h0Var = new com.google.android.gms.internal.measurement.h0(looper, i0Var, 5);
        Looper.getMainLooper();
        this.f8920c = h0Var;
        this.f8921d = m0.a.b();
        this.e = 5000L;
        this.f = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
    }

    public static j0 a(Context context) {
        synchronized (g) {
            try {
                if (h == null) {
                    h = new j0(context.getApplicationContext(), context.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return h;
    }

    public static HandlerThread b() {
        synchronized (g) {
            try {
                HandlerThread handlerThread = f8917i;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                f8917i = handlerThread2;
                handlerThread2.start();
                return f8917i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final f0.b c(g0 g0Var, c0 c0Var, String str, Executor executor) {
        synchronized (this.f8918a) {
            try {
                h0 h0Var = (h0) this.f8918a.get(g0Var);
                f0.b bVarA = null;
                if (executor == null) {
                    executor = null;
                }
                if (h0Var == null) {
                    h0Var = new h0(this, g0Var);
                    h0Var.f8907a.put(c0Var, c0Var);
                    bVarA = h0.a(h0Var, str, executor);
                    this.f8918a.put(g0Var, h0Var);
                } else {
                    this.f8920c.removeMessages(0, g0Var);
                    if (h0Var.f8907a.containsKey(c0Var)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=".concat(g0Var.toString()));
                    }
                    h0Var.f8907a.put(c0Var, c0Var);
                    int i10 = h0Var.f8908b;
                    if (i10 == 1) {
                        c0Var.onServiceConnected(h0Var.f, h0Var.f8910d);
                    } else if (i10 == 2) {
                        bVarA = h0.a(h0Var, str, executor);
                    }
                }
                if (h0Var.f8909c) {
                    return f0.b.e;
                }
                if (bVarA == null) {
                    bVarA = new f0.b(-1);
                }
                return bVarA;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(String str, ServiceConnection serviceConnection, boolean z9) {
        g0 g0Var = new g0(str, z9);
        y.h(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f8918a) {
            try {
                h0 h0Var = (h0) this.f8918a.get(g0Var);
                if (h0Var == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: ".concat(g0Var.toString()));
                }
                if (!h0Var.f8907a.containsKey(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=".concat(g0Var.toString()));
                }
                h0Var.f8907a.remove(serviceConnection);
                if (h0Var.f8907a.isEmpty()) {
                    this.f8920c.sendMessageDelayed(this.f8920c.obtainMessage(0, g0Var), this.e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

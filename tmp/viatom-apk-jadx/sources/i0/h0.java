package i0;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h0 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f8907a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public int f8908b = 2;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8909c;

    /* renamed from: d, reason: collision with root package name */
    public IBinder f8910d;
    public final g0 e;
    public ComponentName f;
    public final /* synthetic */ j0 g;

    public h0(j0 j0Var, g0 g0Var) {
        this.g = j0Var;
        this.e = g0Var;
    }

    public static f0.b a(h0 h0Var, String str, Executor executor) throws RemoteException {
        try {
            Intent intentA = h0Var.e.a(h0Var.g.f8919b);
            h0Var.f8908b = 3;
            StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
            if (Build.VERSION.SDK_INT >= 31) {
                StrictMode.setVmPolicy(n0.f.a(new StrictMode.VmPolicy.Builder(vmPolicy)).build());
            }
            try {
                j0 j0Var = h0Var.g;
                boolean zD = j0Var.f8921d.d(j0Var.f8919b, str, intentA, h0Var, 4225, executor);
                h0Var.f8909c = zD;
                if (zD) {
                    h0Var.g.f8920c.sendMessageDelayed(h0Var.g.f8920c.obtainMessage(1, h0Var.e), h0Var.g.f);
                    f0.b bVar = f0.b.e;
                    StrictMode.setVmPolicy(vmPolicy);
                    return bVar;
                }
                h0Var.f8908b = 2;
                try {
                    j0 j0Var2 = h0Var.g;
                    j0Var2.f8921d.c(j0Var2.f8919b, h0Var);
                } catch (IllegalArgumentException unused) {
                }
                f0.b bVar2 = new f0.b(16);
                StrictMode.setVmPolicy(vmPolicy);
                return bVar2;
            } catch (Throwable th) {
                StrictMode.setVmPolicy(vmPolicy);
                throw th;
            }
        } catch (z e) {
            return e.f8959a;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.g.f8918a) {
            try {
                this.g.f8920c.removeMessages(1, this.e);
                this.f8910d = iBinder;
                this.f = componentName;
                Iterator it = this.f8907a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f8908b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.g.f8918a) {
            try {
                this.g.f8920c.removeMessages(1, this.e);
                this.f8910d = null;
                this.f = componentName;
                Iterator it = this.f8907a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f8908b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

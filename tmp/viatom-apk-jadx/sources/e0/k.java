package e0;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.internal.measurement.h0;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public int f7608a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Messenger f7609b;

    /* renamed from: c, reason: collision with root package name */
    public a4.f f7610c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayDeque f7611d;
    public final SparseArray e;
    public final /* synthetic */ n f;

    public k(n nVar) {
        this.f = nVar;
        h0 h0Var = new h0(Looper.getMainLooper(), new Handler.Callback() { // from class: e0.j
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                int i10 = message.arg1;
                if (Log.isLoggable("MessengerIpcClient", 3)) {
                    Log.d("MessengerIpcClient", "Received response to request: " + i10);
                }
                k kVar = this.f7607a;
                synchronized (kVar) {
                    try {
                        l lVar = (l) kVar.e.get(i10);
                        if (lVar == null) {
                            Log.w("MessengerIpcClient", "Received response for unknown request: " + i10);
                            return true;
                        }
                        kVar.e.remove(i10);
                        kVar.c();
                        Bundle data = message.getData();
                        if (data.getBoolean("unsupported", false)) {
                            lVar.b(new m("Not supported by GmsCore", null));
                            return true;
                        }
                        switch (lVar.e) {
                            case 0:
                                if (data.getBoolean("ack", false)) {
                                    lVar.c(null);
                                    return true;
                                }
                                lVar.b(new m("Invalid response to one way request", null));
                                return true;
                            default:
                                Bundle bundle = data.getBundle(DataSchemeDataSource.SCHEME_DATA);
                                if (bundle == null) {
                                    bundle = Bundle.EMPTY;
                                }
                                lVar.c(bundle);
                                return true;
                        }
                    } finally {
                    }
                }
            }
        }, 4);
        Looper.getMainLooper();
        this.f7609b = new Messenger(h0Var);
        this.f7611d = new ArrayDeque();
        this.e = new SparseArray();
    }

    public final synchronized void a(String str) {
        b(str, null);
    }

    public final synchronized void b(String str, SecurityException securityException) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Disconnected: ".concat(String.valueOf(str)));
            }
            int i10 = this.f7608a;
            if (i10 == 0) {
                throw new IllegalStateException();
            }
            if (i10 != 1 && i10 != 2) {
                if (i10 != 3) {
                    return;
                }
                this.f7608a = 4;
                return;
            }
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.f7608a = 4;
            m0.a.b().c(this.f.f7616a, this);
            m mVar = new m(str, securityException);
            Iterator it = this.f7611d.iterator();
            while (it.hasNext()) {
                ((l) it.next()).b(mVar);
            }
            this.f7611d.clear();
            int i11 = 0;
            while (true) {
                int size = this.e.size();
                SparseArray sparseArray = this.e;
                if (i11 >= size) {
                    sparseArray.clear();
                    return;
                } else {
                    ((l) sparseArray.valueAt(i11)).b(mVar);
                    i11++;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c() {
        try {
            if (this.f7608a == 2 && this.f7611d.isEmpty() && this.e.size() == 0) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
                }
                this.f7608a = 3;
                m0.a.b().c(this.f.f7616a, this);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean d(l lVar) {
        int i10 = this.f7608a;
        if (i10 != 0) {
            if (i10 == 1) {
                this.f7611d.add(lVar);
                return true;
            }
            if (i10 != 2) {
                return false;
            }
            this.f7611d.add(lVar);
            ((ScheduledExecutorService) this.f.f7618c).execute(new i(this, 0));
            return true;
        }
        this.f7611d.add(lVar);
        if (this.f7608a != 0) {
            throw new IllegalStateException();
        }
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Starting bind to GmsCore");
        }
        this.f7608a = 1;
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gms");
        try {
            if (m0.a.b().a(this.f.f7616a, intent, this, 1)) {
                ((ScheduledExecutorService) this.f.f7618c).schedule(new i(this, 1), 30L, TimeUnit.SECONDS);
            } else {
                a("Unable to bind to service");
            }
        } catch (SecurityException e) {
            b("Unable to bind to service", e);
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        ((ScheduledExecutorService) this.f.f7618c).execute(new k1.a(15, this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        ((ScheduledExecutorService) this.f.f7618c).execute(new i(this, 2));
    }
}

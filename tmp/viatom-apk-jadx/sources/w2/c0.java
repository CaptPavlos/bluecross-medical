package w2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c0 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13427a;

    /* renamed from: b, reason: collision with root package name */
    public final Intent f13428b;

    /* renamed from: c, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f13429c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayDeque f13430d;
    public a0 e;
    public boolean f;

    public c0(Context context) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new o0.a("Firebase-FirebaseInstanceIdServiceConnection"));
        scheduledThreadPoolExecutor.setKeepAliveTime(40L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f13430d = new ArrayDeque();
        this.f = false;
        Context applicationContext = context.getApplicationContext();
        this.f13427a = applicationContext;
        this.f13428b = new Intent("com.google.firebase.MESSAGING_EVENT").setPackage(applicationContext.getPackageName());
        this.f13429c = scheduledThreadPoolExecutor;
    }

    public final synchronized void a() {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "flush queue called");
            }
            while (!this.f13430d.isEmpty()) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "found intent to be delivered");
                }
                a0 a0Var = this.e;
                if (a0Var == null || !a0Var.isBinderAlive()) {
                    c();
                    return;
                }
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "binder is alive, sending the intent.");
                }
                this.e.a((b0) this.f13430d.poll());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized h1.p b(Intent intent) {
        b0 b0Var;
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "new intent queued in the bind-strategy delivery");
            }
            b0Var = new b0(intent);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f13429c;
            b0Var.f13425b.f8418a.a(scheduledThreadPoolExecutor, new v.e(scheduledThreadPoolExecutor.schedule(new androidx.constraintlayout.helper.widget.a(b0Var, 14), 20L, TimeUnit.SECONDS), 7));
            this.f13430d.add(b0Var);
            a();
        } catch (Throwable th) {
            throw th;
        }
        return b0Var.f13425b.f8418a;
    }

    public final void c() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb = new StringBuilder("binder is dead. start connection? ");
            sb.append(!this.f);
            Log.d("FirebaseMessaging", sb.toString());
        }
        if (this.f) {
            return;
        }
        this.f = true;
        try {
        } catch (SecurityException e) {
            Log.e("FirebaseMessaging", "Exception while binding the service", e);
        }
        if (m0.a.b().a(this.f13427a, this.f13428b, this, 65)) {
            return;
        }
        Log.e("FirebaseMessaging", "binding to the service failed");
        this.f = false;
        while (true) {
            ArrayDeque arrayDeque = this.f13430d;
            if (arrayDeque.isEmpty()) {
                return;
            } else {
                ((b0) arrayDeque.poll()).f13425b.c(null);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "onServiceConnected: " + componentName);
            }
            this.f = false;
            if (iBinder instanceof a0) {
                this.e = (a0) iBinder;
                a();
                return;
            }
            Log.e("FirebaseMessaging", "Invalid service connection: " + iBinder);
            ArrayDeque arrayDeque = this.f13430d;
            while (!arrayDeque.isEmpty()) {
                ((b0) arrayDeque.poll()).f13425b.c(null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "onServiceDisconnected: " + componentName);
        }
        a();
    }
}

package w2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public y f13485a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y f13486b;

    public x(y yVar, y yVar2) {
        this.f13486b = yVar;
        this.f13485a = yVar2;
    }

    public final void a() {
        if (Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3))) {
            Log.d("FirebaseMessaging", "Connectivity change received registered");
        }
        this.f13486b.f13487a.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // android.content.BroadcastReceiver
    public final synchronized void onReceive(Context context, Intent intent) {
        try {
            y yVar = this.f13485a;
            if (yVar == null) {
                return;
            }
            if (yVar.d()) {
                if (Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3))) {
                    Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                }
                y yVar2 = this.f13485a;
                yVar2.f13490d.f.schedule(yVar2, 0L, TimeUnit.SECONDS);
                context.unregisterReceiver(this);
                this.f13485a = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}

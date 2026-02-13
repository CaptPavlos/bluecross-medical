package h0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessaging;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8398a = 2;

    /* renamed from: b, reason: collision with root package name */
    public Object f8399b;

    /* renamed from: c, reason: collision with root package name */
    public Object f8400c;

    public r(h4.a aVar, h4.a aVar2) {
        this.f8399b = aVar;
        this.f8400c = aVar2;
    }

    public void a() {
        if (Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3))) {
            Log.d("FirebaseMessaging", "Connectivity change received registered");
        }
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        w2.s sVar = (w2.s) this.f8400c;
        if (sVar != null) {
            Context context = sVar.f13467c.f2434b;
            this.f8399b = context;
            context.registerReceiver(this, intentFilter);
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        NetworkInfo activeNetworkInfo;
        NetworkCapabilities networkCapabilities;
        switch (this.f8398a) {
            case 0:
                Uri data = intent.getData();
                if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
                    Object obj = ((a4.f) this.f8400c).f219c;
                    throw null;
                }
                return;
            case 1:
                context.getClass();
                intent.getClass();
                Object systemService = context.getSystemService("connectivity");
                systemService.getClass();
                ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
                if (Build.VERSION.SDK_INT < 24 ? (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected() : (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) == null || !(networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3))) {
                    ((h4.a) this.f8400c).invoke();
                    return;
                } else {
                    ((h4.a) this.f8399b).invoke();
                    return;
                }
            default:
                w2.s sVar = (w2.s) this.f8400c;
                if (sVar != null && sVar.a()) {
                    if (Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3))) {
                        Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                    }
                    w2.s sVar2 = (w2.s) this.f8400c;
                    sVar2.f13467c.getClass();
                    FirebaseMessaging.b(sVar2, 0L);
                    Context context2 = (Context) this.f8399b;
                    if (context2 != null) {
                        context2.unregisterReceiver(this);
                    }
                    this.f8400c = null;
                    return;
                }
                return;
        }
    }

    public r(a4.f fVar) {
        this.f8400c = fVar;
    }

    public /* synthetic */ r() {
    }
}

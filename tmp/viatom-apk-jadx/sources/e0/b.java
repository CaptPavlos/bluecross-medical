package e0;

import a3.x;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.mbridge.msdk.MBridgeConstans;
import h1.p;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {
    public static int h;

    /* renamed from: i, reason: collision with root package name */
    public static PendingIntent f7589i;

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f7590j = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");

    /* renamed from: b, reason: collision with root package name */
    public final Context f7592b;

    /* renamed from: c, reason: collision with root package name */
    public final o f7593c;

    /* renamed from: d, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f7594d;
    public Messenger f;
    public g g;

    /* renamed from: a, reason: collision with root package name */
    public final SimpleArrayMap f7591a = new SimpleArrayMap();
    public final Messenger e = new Messenger(new e(this, Looper.getMainLooper()));

    public b(Context context) {
        this.f7592b = context;
        this.f7593c = new o(context);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f7594d = scheduledThreadPoolExecutor;
    }

    public static synchronized String b() {
        int i10;
        i10 = h;
        h = i10 + 1;
        return Integer.toString(i10);
    }

    public static synchronized void c(Context context, Intent intent) {
        try {
            if (f7589i == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                f7589i = PendingIntent.getBroadcast(context, 0, intent2, w0.a.f13316a);
            }
            intent.putExtra(MBridgeConstans.DYNAMIC_VIEW_WX_APP, f7589i);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final p a(Bundle bundle) throws RemoteException {
        String strB = b();
        h1.i iVar = new h1.i();
        synchronized (this.f7591a) {
            this.f7591a.put(strB, iVar);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.f7593c.b() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        c(this.f7592b, intent);
        intent.putExtra("kid", "|ID|" + strB + "|");
        if (Log.isLoggable("Rpc", 3)) {
            Log.d("Rpc", "Sending ".concat(String.valueOf(intent.getExtras())));
        }
        intent.putExtra("google.messenger", this.e);
        if (this.f == null && this.g == null) {
            int iB = this.f7593c.b();
            Context context = this.f7592b;
            if (iB == 2) {
                context.sendBroadcast(intent);
            } else {
                context.startService(intent);
            }
        } else {
            Message messageObtain = Message.obtain();
            messageObtain.obj = intent;
            try {
                Messenger messenger = this.f;
                if (messenger != null) {
                    messenger.send(messageObtain);
                } else {
                    Messenger messenger2 = this.g.f7601a;
                    messenger2.getClass();
                    messenger2.send(messageObtain);
                }
            } catch (RemoteException unused) {
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        iVar.f8418a.a(h.f7603c, new x(this, strB, this.f7594d.schedule(new a4.a(iVar, 8), 30L, TimeUnit.SECONDS), 20));
        return iVar.f8418a;
    }

    public final void d(Bundle bundle, String str) {
        synchronized (this.f7591a) {
            try {
                h1.i iVar = (h1.i) this.f7591a.remove(str);
                if (iVar != null) {
                    iVar.a(bundle);
                    return;
                }
                Log.w("Rpc", "Missing callback for " + str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

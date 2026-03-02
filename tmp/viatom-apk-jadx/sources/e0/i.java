package e0;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7605a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f7606b;

    public /* synthetic */ i(k kVar, int i10) {
        this.f7605a = i10;
        this.f7606b = kVar;
    }

    private final void a() {
        k kVar = this.f7606b;
        synchronized (kVar) {
            if (kVar.f7608a == 1) {
                kVar.a("Timed out while binding");
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() throws RemoteException {
        switch (this.f7605a) {
            case 0:
                break;
            case 1:
                a();
                return;
            default:
                this.f7606b.a("Service disconnected");
                return;
        }
        while (true) {
            k kVar = this.f7606b;
            synchronized (kVar) {
                try {
                    if (kVar.f7608a != 2) {
                        return;
                    }
                    if (kVar.f7611d.isEmpty()) {
                        kVar.c();
                        return;
                    }
                    l lVar = (l) kVar.f7611d.poll();
                    kVar.e.put(lVar.f7612a, lVar);
                    ((ScheduledExecutorService) kVar.f.f7618c).schedule(new k1.a(16, kVar, lVar), 30L, TimeUnit.SECONDS);
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        Log.d("MessengerIpcClient", "Sending ".concat(String.valueOf(lVar)));
                    }
                    n nVar = kVar.f;
                    Messenger messenger = kVar.f7609b;
                    int i10 = lVar.f7614c;
                    Context context = nVar.f7616a;
                    Message messageObtain = Message.obtain();
                    messageObtain.what = i10;
                    messageObtain.arg1 = lVar.f7612a;
                    messageObtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", lVar.a());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle(DataSchemeDataSource.SCHEME_DATA, lVar.f7615d);
                    messageObtain.setData(bundle);
                    try {
                        a4.f fVar = kVar.f7610c;
                        Messenger messenger2 = (Messenger) fVar.f218b;
                        if (messenger2 != null) {
                            messenger2.send(messageObtain);
                        } else {
                            g gVar = (g) fVar.f219c;
                            if (gVar == null) {
                                throw new IllegalStateException("Both messengers are null");
                            }
                            Messenger messenger3 = gVar.f7601a;
                            messenger3.getClass();
                            messenger3.send(messageObtain);
                        }
                    } catch (RemoteException e) {
                        kVar.a(e.getMessage());
                    }
                } finally {
                }
            }
        }
    }
}

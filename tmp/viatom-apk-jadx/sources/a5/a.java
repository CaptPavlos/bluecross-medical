package a5;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.google.android.gms.internal.measurement.a4;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f220a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Object f221b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f222c;

    public a(ReferenceQueue referenceQueue, Handler handler) {
        this.f221b = referenceQueue;
        this.f222c = handler;
        setDaemon(true);
        setName("Picasso-refQueue");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        switch (this.f220a) {
            case 0:
                y4.a aVar = (y4.a) this.f221b;
                aVar.getClass();
                synchronized (aVar) {
                    try {
                        ((y4.a) this.f221b).getClass();
                        ((y4.a) this.f221b).getClass();
                        a4.x("Command 158 is waiting for: 20000");
                        y4.a aVar2 = (y4.a) this.f221b;
                        aVar2.getClass();
                        aVar2.wait(20000);
                    } catch (InterruptedException e) {
                        a4.x("Exception: " + e);
                    }
                    y4.a aVar3 = (y4.a) this.f221b;
                    if (!aVar3.g) {
                        aVar3.getClass();
                        a4.x("Timeout Exception has occurred for command: 158.");
                        y4.a aVar4 = (y4.a) this.f222c;
                        try {
                            a4.x("Request to close all shells!");
                            a4.x("Request to close normal shell!");
                            d.d();
                            a4.x("Request to close custom shell!");
                            a4.x("Terminating all shells.");
                            aVar4.f("Timeout Exception");
                        } catch (IOException unused) {
                        }
                    }
                }
                return;
            default:
                Handler handler = (Handler) this.f222c;
                Process.setThreadPriority(10);
                while (true) {
                    try {
                        j4.a aVar5 = (j4.a) ((ReferenceQueue) this.f221b).remove(1000L);
                        Message messageObtainMessage = handler.obtainMessage();
                        if (aVar5 != null) {
                            messageObtainMessage.what = 3;
                            messageObtainMessage.obj = aVar5.f9915a;
                            handler.sendMessage(messageObtainMessage);
                        } else {
                            messageObtainMessage.recycle();
                        }
                    } catch (InterruptedException unused2) {
                        return;
                    } catch (Exception e3) {
                        handler.post(new a4.a(e3, 16));
                        return;
                    }
                }
        }
    }

    public a(y4.a aVar, y4.a aVar2) {
        this.f222c = aVar;
        this.f221b = aVar2;
    }
}

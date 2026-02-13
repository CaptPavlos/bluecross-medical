package com.uptodown.receivers;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.uptodown.UptodownApp;
import com.uptodown.workers.DownloadWorker;
import h5.q;
import h5.y0;
import java.util.ArrayList;
import java.util.Iterator;
import k4.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class DownloadUpdateNotificationReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int intExtra;
        ArrayList arrayList;
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode == -1881097171) {
                if (action.equals("RESUME")) {
                    DownloadWorker.f = false;
                    DownloadWorker.e = false;
                    return;
                }
                return;
            }
            if (iHashCode == 75902422) {
                if (action.equals("PAUSE")) {
                    DownloadWorker.f = true;
                    return;
                }
                return;
            }
            if (iHashCode == 1980572282 && action.equals("CANCEL") && (intExtra = intent.getIntExtra("notificationID", -1)) == 262 && context != null) {
                float f = UptodownApp.E;
                c.f();
                synchronized (UptodownApp.f6638p0) {
                    arrayList = UptodownApp.f6639q0;
                }
                Iterator it = arrayList.iterator();
                it.getClass();
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    y0 y0Var = (y0) next;
                    float f10 = UptodownApp.E;
                    c.w(y0Var.f8795b);
                    q qVarA = y0Var.a(context);
                    if (qVarA != null) {
                        qVarA.d();
                    }
                }
                Object systemService = context.getSystemService("notification");
                systemService.getClass();
                ((NotificationManager) systemService).cancel(intExtra);
            }
        }
    }
}

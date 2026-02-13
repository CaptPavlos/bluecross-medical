package com.uptodown.receivers;

import a.a;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.uptodown.workers.DownloadWorker;
import h5.q;
import java.util.ArrayList;
import java.util.Iterator;
import v5.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class DownloadNotificationReceiver extends BroadcastReceiver {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int intExtra;
        int intExtra2;
        q qVar;
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            int i10 = 0;
            switch (action.hashCode()) {
                case -1919974852:
                    if (action.equals("CANCEL_ALL") && (intExtra = intent.getIntExtra("notificationID", -1)) == 261 && context != null) {
                        q qVar2 = DownloadWorker.f6738d;
                        ArrayList arrayList = new ArrayList();
                        g gVarL = g.f13148u.l(context);
                        gVarL.a();
                        Iterator it = gVarL.F().iterator();
                        it.getClass();
                        while (it.hasNext()) {
                            Object next = it.next();
                            next.getClass();
                            q qVar3 = (q) next;
                            if (qVar3.m()) {
                                arrayList.add(qVar3);
                            }
                        }
                        gVarL.b();
                        if (qVar2 != null) {
                            long j10 = qVar2.h;
                            if (j10 <= 0) {
                                String str = qVar2.f8701b;
                                if (str != null) {
                                    a.l(str);
                                }
                            } else if (a.D(j10)) {
                                DownloadWorker.f = false;
                                DownloadWorker.e = true;
                            }
                            qVar2.r(context);
                        }
                        if (!arrayList.isEmpty()) {
                            int size = arrayList.size();
                            while (i10 < size) {
                                Object obj = arrayList.get(i10);
                                i10++;
                                ((q) obj).r(context);
                            }
                        }
                        Object systemService = context.getSystemService("notification");
                        systemService.getClass();
                        ((NotificationManager) systemService).cancel(intExtra);
                        break;
                    }
                    break;
                case -1881097171:
                    if (action.equals("RESUME")) {
                        DownloadWorker.f = false;
                        DownloadWorker.e = false;
                        break;
                    }
                    break;
                case 75902422:
                    if (action.equals("PAUSE")) {
                        DownloadWorker.f = true;
                        break;
                    }
                    break;
                case 1980572282:
                    if (action.equals("CANCEL") && (intExtra2 = intent.getIntExtra("notificationID", -1)) == 261 && (qVar = DownloadWorker.f6738d) != null) {
                        long j11 = qVar.h;
                        if (j11 <= 0) {
                            String str2 = qVar.f8701b;
                            if (str2 != null) {
                                a.l(str2);
                            }
                        } else if (a.D(j11)) {
                            DownloadWorker.f = false;
                            DownloadWorker.e = true;
                        }
                        if (context != null) {
                            qVar.r(context);
                            ArrayList arrayList2 = new ArrayList();
                            g gVarL2 = g.f13148u.l(context);
                            gVarL2.a();
                            Iterator it2 = gVarL2.F().iterator();
                            it2.getClass();
                            while (it2.hasNext()) {
                                Object next2 = it2.next();
                                next2.getClass();
                                q qVar4 = (q) next2;
                                if (qVar4.m()) {
                                    arrayList2.add(qVar4);
                                }
                            }
                            gVarL2.b();
                            if (arrayList2.isEmpty()) {
                                Object systemService2 = context.getSystemService("notification");
                                systemService2.getClass();
                                ((NotificationManager) systemService2).cancel(intExtra2);
                                break;
                            }
                        }
                    }
                    break;
            }
        }
    }
}

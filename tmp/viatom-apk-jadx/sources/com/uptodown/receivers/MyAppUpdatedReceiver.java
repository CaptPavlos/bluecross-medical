package com.uptodown.receivers;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.mbridge.msdk.dycreator.baseview.a;
import com.uptodown.workers.MyAppUpdatedWorker;
import kotlin.jvm.internal.l;
import o4.b;
import r0.f;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class MyAppUpdatedReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        context.getClass();
        intent.getClass();
        Activity activity = b.g;
        Context contextH = f.h(context);
        if (l.a(intent.getAction(), "android.intent.action.MY_PACKAGE_REPLACED")) {
            t1.R(context, "device_status", null);
            t1.R(contextH, "last_notification_timestamp", "0");
            t1.N(contextH, "settings_utd_sended", false);
            t1.N(contextH, "is_status_code_526", false);
            t1.R(contextH, "url_526", null);
            Object systemService = contextH.getSystemService("notification");
            systemService.getClass();
            ((NotificationManager) systemService).cancel(259);
            String strB = t1.B(contextH, "download_updates_options", "2");
            if (!strB.equalsIgnoreCase("0") && !strB.equalsIgnoreCase("1") && !strB.equalsIgnoreCase("2")) {
                t1.R(contextH, "download_updates_options", "2");
            }
            WorkManager.Companion.getInstance(contextH).enqueue(((OneTimeWorkRequest.Builder) a.h(MyAppUpdatedWorker.class, "MyAppUpdatedWorker")).build());
        }
    }
}

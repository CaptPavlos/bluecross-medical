package com.uptodown.receivers;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.uptodown.UptodownApp;
import k4.c;
import o4.b;
import o7.u;
import r0.f;
import v5.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class BootDeviceReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                if (intent.getAction() == null || !u.Z(intent.getAction(), "android.intent.action.BOOT_COMPLETED", true) || context == null) {
                    return;
                }
                float f = UptodownApp.E;
                c.C(context);
                Activity activity = b.g;
                i.l(f.h(context));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

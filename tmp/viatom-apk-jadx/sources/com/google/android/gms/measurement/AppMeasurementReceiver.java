package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import c1.u0;
import c1.u1;
import c1.w0;
import y2.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public c f2290a;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f2290a == null) {
            this.f2290a = new c(this, 5);
        }
        c cVar = this.f2290a;
        cVar.getClass();
        w0 w0Var = u1.s(context, null, null).f;
        u1.m(w0Var);
        u0 u0Var = w0Var.f1545n;
        u0 u0Var2 = w0Var.f1540i;
        if (intent == null) {
            u0Var2.b("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        u0Var.c(action, "Local receiver got");
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                u0Var2.b("Install Referrer Broadcasts are deprecated");
            }
        } else {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            u0Var.b("Starting wakeful intent.");
            ((AppMeasurementReceiver) cVar.f13781b).getClass();
            WakefulBroadcastReceiver.startWakefulService(context, className);
        }
    }
}

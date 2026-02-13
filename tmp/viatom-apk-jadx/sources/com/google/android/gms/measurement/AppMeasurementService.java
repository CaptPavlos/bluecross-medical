package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.legacy.content.WakefulBroadcastReceiver;
import c1.a4;
import c1.d2;
import c1.u1;
import c1.v4;
import c1.w0;
import d0.i;
import k1.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class AppMeasurementService extends Service implements a4 {

    /* renamed from: a, reason: collision with root package name */
    public i f2291a;

    @Override // c1.a4
    public final boolean a(int i10) {
        return stopSelfResult(i10);
    }

    @Override // c1.a4
    public final void b(Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }

    @Override // c1.a4
    public final void c(JobParameters jobParameters) {
        throw new UnsupportedOperationException();
    }

    public final i d() {
        if (this.f2291a == null) {
            this.f2291a = new i((Object) this, 6);
        }
        return this.f2291a;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        i iVarD = d();
        iVarD.getClass();
        if (intent == null) {
            Log.e("FA", "onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new d2(v4.C((Service) iVarD.f6781b));
        }
        Log.w("FA", "onBind received unknown action: ".concat(String.valueOf(action)));
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        Log.v("FA", ((Service) d().f6781b).getClass().getSimpleName().concat(" is starting up."));
    }

    @Override // android.app.Service
    public final void onDestroy() {
        Log.v("FA", ((Service) d().f6781b).getClass().getSimpleName().concat(" is shutting down."));
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        d();
        if (intent == null) {
            Log.e("FA", "onRebind called with null intent");
        } else {
            Log.v("FA", "onRebind called. action: ".concat(String.valueOf(intent.getAction())));
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent intent, int i10, final int i11) {
        final i iVarD = d();
        if (intent == null) {
            iVarD.getClass();
            Log.w("FA", "AppMeasurementService started with null intent");
            return 2;
        }
        Service service = (Service) iVarD.f6781b;
        final w0 w0Var = u1.s(service, null, null).f;
        u1.m(w0Var);
        String action = intent.getAction();
        w0Var.f1545n.d(Integer.valueOf(i11), "Local AppMeasurementService called. startId, action", action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            return 2;
        }
        Runnable runnable = new Runnable() { // from class: c1.b4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                Service service2 = (Service) iVarD.f6781b;
                a4 a4Var = (a4) service2;
                int i12 = i11;
                if (a4Var.a(i12)) {
                    w0Var.f1545n.c(Integer.valueOf(i12), "Local AppMeasurementService processed last upload request. StartId");
                    w0 w0Var2 = u1.s(service2, null, null).f;
                    u1.m(w0Var2);
                    w0Var2.f1545n.b("Completed wakeful intent.");
                    a4Var.b(intent);
                }
            }
        };
        v4 v4VarC = v4.C(service);
        v4VarC.b().p(new a(iVarD, v4VarC, runnable));
        return 2;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        d();
        if (intent == null) {
            Log.e("FA", "onUnbind called with null intent");
            return true;
        }
        Log.v("FA", "onUnbind called for intent. action: ".concat(String.valueOf(intent.getAction())));
        return true;
    }
}

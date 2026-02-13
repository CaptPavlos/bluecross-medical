package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.util.Log;
import c1.a4;
import c1.v4;
import c1.w0;
import c1.y1;
import com.google.android.gms.internal.measurement.l1;
import com.google.android.gms.internal.measurement.y0;
import d0.i;
import i0.y;
import j$.util.Objects;
import k1.a;
import o2.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@TargetApi(24)
/* loaded from: classes3.dex */
public final class AppMeasurementJobService extends JobService implements a4 {

    /* renamed from: a, reason: collision with root package name */
    public i f2289a;

    @Override // c1.a4
    public final boolean a(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // c1.a4
    public final void c(JobParameters jobParameters) {
        jobFinished(jobParameters, false);
    }

    public final i d() {
        if (this.f2289a == null) {
            this.f2289a = new i((Object) this, 6);
        }
        return this.f2289a;
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

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        JobParameters jobParameters2;
        i iVarD = d();
        Service service = (Service) iVarD.f6781b;
        String string = jobParameters.getExtras().getString("action");
        Log.v("FA", "onStartJob received action: ".concat(String.valueOf(string)));
        if (Objects.equals(string, "com.google.android.gms.measurement.UPLOAD")) {
            y.g(string);
            v4 v4VarC = v4.C(service);
            w0 w0VarA = v4VarC.a();
            e eVar = v4VarC.f1525l.f1477c;
            w0VarA.f1545n.c(string, "Local AppMeasurementJobService called. action");
            jobParameters2 = jobParameters;
            v4VarC.b().p(new a(iVarD, v4VarC, new y1(iVarD, w0VarA, jobParameters2, 8, false)));
        } else {
            jobParameters2 = jobParameters;
        }
        if (!Objects.equals(string, "com.google.android.gms.measurement.SCION_UPLOAD")) {
            return true;
        }
        y.g(string);
        l1 l1VarC = l1.c(service, null);
        a aVar = new a(14, iVarD, jobParameters2);
        l1VarC.getClass();
        l1VarC.a(new y0(l1VarC, aVar, 3));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
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

    @Override // c1.a4
    public final void b(Intent intent) {
    }
}

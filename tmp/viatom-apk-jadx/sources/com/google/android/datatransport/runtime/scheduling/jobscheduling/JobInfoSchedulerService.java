package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import androidx.window.layout.c;
import m.d;
import p.i;
import p.p;
import v.h;
import z.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresApi(api = 21)
/* loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1822a = 0;

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i10 = jobParameters.getExtras().getInt("priority");
        int i11 = jobParameters.getExtras().getInt("attemptNumber");
        p.b(getApplicationContext());
        if (string == null) {
            c.k("Null backendName");
            return false;
        }
        d dVarB = a.b(i10);
        byte[] bArrDecode = string2 != null ? Base64.decode(string2, 0) : null;
        h hVar = p.a().f11872d;
        hVar.e.execute(new v.d(hVar, new i(string, bArrDecode, dVarB), i11, new androidx.browser.trusted.c(23, this, jobParameters)));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}

package c1;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Build;
import android.os.PersistableBundle;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h3 extends h0 {

    /* renamed from: c, reason: collision with root package name */
    public JobScheduler f1265c;

    @Override // c1.h0
    public final boolean j() {
        return true;
    }

    public final void k(long j10) {
        h();
        g();
        JobScheduler jobScheduler = this.f1265c;
        u1 u1Var = this.f1149a;
        if (jobScheduler != null && jobScheduler.getPendingJob("measurement-client".concat(String.valueOf(u1Var.f1475a.getPackageName())).hashCode()) != null) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f1545n.b("[sgtm] There's an existing pending job, skip this schedule.");
            return;
        }
        int iL = l();
        if (iL != 2) {
            w0 w0Var2 = u1Var.f;
            u1.m(w0Var2);
            w0Var2.f1545n.c(androidx.constraintlayout.core.widgets.analyzer.a.F(iL), "[sgtm] Not eligible for Scion upload");
            return;
        }
        w0 w0Var3 = u1Var.f;
        u1.m(w0Var3);
        w0Var3.f1545n.c(Long.valueOf(j10), "[sgtm] Scheduling Scion upload, millis");
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.SCION_UPLOAD");
        JobInfo jobInfoBuild = new JobInfo.Builder("measurement-client".concat(String.valueOf(u1Var.f1475a.getPackageName())).hashCode(), new ComponentName(u1Var.f1475a, "com.google.android.gms.measurement.AppMeasurementJobService")).setRequiredNetworkType(1).setMinimumLatency(j10).setOverrideDeadline(j10 + j10).setExtras(persistableBundle).build();
        JobScheduler jobScheduler2 = this.f1265c;
        i0.y.g(jobScheduler2);
        int iSchedule = jobScheduler2.schedule(jobInfoBuild);
        w0 w0Var4 = u1Var.f;
        u1.m(w0Var4);
        w0Var4.f1545n.c(iSchedule == 1 ? "SUCCESS" : "FAILURE", "[sgtm] Scion upload job scheduled with result");
    }

    public final int l() {
        h();
        g();
        if (this.f1265c == null) {
            return 7;
        }
        u1 u1Var = this.f1149a;
        Boolean boolS = u1Var.f1478d.s("google_analytics_sgtm_upload_enabled");
        if (!(boolS == null ? false : boolS.booleanValue())) {
            return 8;
        }
        if (u1Var.r().f1348j < 119000) {
            return 6;
        }
        if (!b5.A(u1Var.f1475a, "com.google.android.gms.measurement.AppMeasurementJobService")) {
            return 3;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return !u1Var.p().n() ? 5 : 2;
        }
        return 4;
    }
}

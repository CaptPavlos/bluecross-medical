package c1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l4 extends q4 {

    /* renamed from: d, reason: collision with root package name */
    public final AlarmManager f1328d;
    public e4 e;
    public Integer f;

    public l4(v4 v4Var) {
        super(v4Var);
        this.f1328d = (AlarmManager) this.f1149a.f1475a.getSystemService(NotificationCompat.CATEGORY_ALARM);
    }

    @Override // c1.q4
    public final void j() {
        AlarmManager alarmManager = this.f1328d;
        if (alarmManager != null) {
            alarmManager.cancel(o());
        }
        if (Build.VERSION.SDK_INT >= 24) {
            m();
        }
    }

    public final void k() {
        h();
        w0 w0Var = this.f1149a.f;
        u1.m(w0Var);
        w0Var.f1545n.b("Unscheduling upload");
        AlarmManager alarmManager = this.f1328d;
        if (alarmManager != null) {
            alarmManager.cancel(o());
        }
        l().c();
        if (Build.VERSION.SDK_INT >= 24) {
            m();
        }
    }

    public final o l() {
        if (this.e == null) {
            this.e = new e4(this, this.f1335b.f1525l, 1);
        }
        return this.e;
    }

    public final void m() {
        JobScheduler jobScheduler = (JobScheduler) this.f1149a.f1475a.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(n());
        }
    }

    public final int n() {
        if (this.f == null) {
            this.f = Integer.valueOf("measurement".concat(String.valueOf(this.f1149a.f1475a.getPackageName())).hashCode());
        }
        return this.f.intValue();
    }

    public final PendingIntent o() {
        Context context = this.f1149a.f1475a;
        return PendingIntent.getBroadcast(context, 0, new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), com.google.android.gms.internal.measurement.f0.f1948a);
    }
}

package k4;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.UiModeManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import c5.b0;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.workers.DownloadApkWorker;
import com.uptodown.workers.GetUserDataWorker;
import com.uptodown.workers.PreRegisterWorker;
import com.uptodown.workers.TrackingWorker;
import h5.a0;
import h5.f;
import h5.h;
import h5.l;
import h5.q;
import h5.y0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import l4.w;
import o7.u;
import v5.g;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {
    public static void A(Context context) {
        if (o(context, "GetUserDataWorker")) {
            return;
        }
        WorkManager.Companion.getInstance(context).enqueue(new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) GetUserDataWorker.class, 24L, TimeUnit.HOURS).addTag("GetUserDataWorker").setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build());
    }

    public static void B(Context context) {
        if (o(context, "PreRegisterWorker")) {
            return;
        }
        WorkManager.Companion.getInstance(context).enqueue(new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) PreRegisterWorker.class, 4L, TimeUnit.HOURS).addTag("PreRegisterWorker").setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build());
    }

    public static void C(Context context) {
        if (o(context, "TrackingWorkerPeriodic")) {
            return;
        }
        Constraints constraintsBuild = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        TimeUnit timeUnit = TimeUnit.MINUTES;
        WorkManager.Companion.getInstance(context).enqueue(new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) TrackingWorker.class, 30L, timeUnit).addTag("TrackingWorkerPeriodic").setBackoffCriteria(BackoffPolicy.LINEAR, 1L, timeUnit).setConstraints(constraintsBuild).build());
    }

    public static void D(FragmentTransaction fragmentTransaction, w wVar) {
        float f = UptodownApp.E;
        boolean z9 = true;
        try {
            SharedPreferences sharedPreferences = wVar.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("animations")) {
                z9 = sharedPreferences.getBoolean("animations", true);
            }
        } catch (Exception unused) {
        }
        if (z9) {
            fragmentTransaction.setCustomAnimations(R.anim.left_to_right_in, R.anim.fade_out, R.anim.left_to_right_in, R.anim.fade_out);
        }
    }

    public static boolean E(Context context) {
        float f = UptodownApp.E;
        context.getClass();
        if (o(context, "TrackingWorkerSingle") || n(context, "TrackingWorkerPeriodic") || n(context, "GenerateQueueWorker") || n(context, "DownloadUpdatesWorker")) {
            return false;
        }
        Data dataBuild = new Data.Builder().putBoolean("isCompressed", true).build();
        WorkManager.Companion.getInstance(context).enqueue(((OneTimeWorkRequest.Builder) com.mbridge.msdk.dycreator.baseview.a.h(TrackingWorker.class, "TrackingWorkerSingle")).setBackoffCriteria(BackoffPolicy.LINEAR, 1L, TimeUnit.MINUTES).setInputData(dataBuild).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build());
        return true;
    }

    public static Bundle a(Activity activity) {
        activity.getClass();
        float f = UptodownApp.E;
        boolean z9 = true;
        try {
            SharedPreferences sharedPreferences = activity.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("animations")) {
                z9 = sharedPreferences.getBoolean("animations", true);
            }
        } catch (Exception unused) {
        }
        if (z9) {
            return ActivityOptions.makeCustomAnimation(activity, R.anim.left_to_right_in, R.anim.fade_out).toBundle();
        }
        return null;
    }

    public static ActivityOptionsCompat b(Activity activity) {
        activity.getClass();
        float f = UptodownApp.E;
        boolean z9 = true;
        try {
            SharedPreferences sharedPreferences = activity.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("animations")) {
                z9 = sharedPreferences.getBoolean("animations", true);
            }
        } catch (Exception unused) {
        }
        if (z9) {
            return ActivityOptionsCompat.makeCustomAnimation(activity, R.anim.left_to_right_in, R.anim.fade_out);
        }
        return null;
    }

    public static ArrayList c(f fVar) {
        ArrayList arrayList;
        fVar.getClass();
        synchronized (UptodownApp.f6633j0) {
            try {
                if (fVar.f8541w > 0) {
                    ArrayList arrayList2 = UptodownApp.f6634k0;
                    if (arrayList2 != null) {
                        arrayList2.add(fVar);
                    } else {
                        ArrayList arrayList3 = new ArrayList();
                        UptodownApp.f6634k0 = arrayList3;
                        arrayList3.add(fVar);
                    }
                }
                arrayList = UptodownApp.f6634k0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0124 A[PHI: r10
      0x0124: PHI (r10v9 float) = (r10v8 float), (r10v13 float) binds: [B:56:0x012c, B:51:0x011f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d(android.content.Context r18) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.c.d(android.content.Context):void");
    }

    public static boolean e(Context context) {
        context.getClass();
        return (Integer.parseInt(t1.B(context, "autoplay_video", "0")) == 0 && a.a.f3d) || Integer.parseInt(t1.B(context, "autoplay_video", "0")) == 1;
    }

    public static void f() {
        synchronized (UptodownApp.f6633j0) {
            UptodownApp.f6634k0 = null;
        }
    }

    public static f g() {
        f fVar;
        synchronized (UptodownApp.f6633j0) {
            ArrayList arrayList = UptodownApp.f6634k0;
            if (arrayList == null || arrayList.isEmpty()) {
                fVar = null;
            } else {
                ArrayList arrayList2 = UptodownApp.f6634k0;
                arrayList2.getClass();
                fVar = (f) arrayList2.remove(0);
            }
        }
        return fVar;
    }

    public static ArrayList h() {
        ArrayList arrayList;
        synchronized (UptodownApp.f6633j0) {
            arrayList = UptodownApp.f6634k0;
        }
        return arrayList;
    }

    public static WorkInfo.State i(Context context) {
        WorkInfo.State state = WorkInfo.State.SUCCEEDED;
        Iterator it = ((List) WorkManager.Companion.getInstance(context).getWorkInfosByTag("downloadApkWorker").get()).iterator();
        while (it.hasNext() && (state = ((WorkInfo) it.next()).getState()) != WorkInfo.State.RUNNING && state != WorkInfo.State.ENQUEUED) {
        }
        return state;
    }

    public static void j(ContextWrapper contextWrapper) {
        contextWrapper.getClass();
        boolean z9 = false;
        try {
            SharedPreferences sharedPreferences = contextWrapper.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("gdpr_tracking_allowed")) {
                z9 = sharedPreferences.getBoolean("gdpr_tracking_allowed", false);
            }
        } catch (Exception unused) {
        }
        if (z9) {
            new j5.a(contextWrapper).b(new b0(contextWrapper, false));
        }
    }

    public static boolean k(y0 y0Var) {
        boolean z9;
        y0Var.getClass();
        synchronized (UptodownApp.f6638p0) {
            Iterator it = UptodownApp.f6639q0.iterator();
            it.getClass();
            while (true) {
                if (!it.hasNext()) {
                    z9 = false;
                    break;
                }
                Object next = it.next();
                next.getClass();
                z9 = true;
                if (u.Z(((y0) next).f8795b, y0Var.f8795b, true)) {
                    break;
                }
            }
        }
        return z9;
    }

    public static boolean l(String str) {
        str.getClass();
        synchronized (UptodownApp.f6633j0) {
            ArrayList arrayList = UptodownApp.f6634k0;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ArrayList arrayList2 = UptodownApp.f6634k0;
                    arrayList2.getClass();
                    if (str.equalsIgnoreCase(((f) arrayList2.get(i10)).f8526c)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static boolean m(Context context) {
        context.getClass();
        Object systemService = context.getSystemService("uimode");
        systemService.getClass();
        if (((UiModeManager) systemService).getCurrentModeType() == 4) {
            return true;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getClass();
            ApplicationInfo applicationInfo = l5.a.f(packageManager, "com.npg.smarttvnpg", 4096).applicationInfo;
            if (applicationInfo != null) {
                return (applicationInfo.flags & TsExtractor.TS_STREAM_TYPE_AC3) != 0;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean n(Context context, String str) {
        context.getClass();
        Iterator it = ((List) WorkManager.Companion.getInstance(context).getWorkInfosByTag(str).get()).iterator();
        while (it.hasNext()) {
            if (((WorkInfo) it.next()).getState() == WorkInfo.State.RUNNING) {
                return true;
            }
        }
        return false;
    }

    public static boolean o(Context context, String str) {
        if (context == null) {
            return false;
        }
        Iterator it = ((List) WorkManager.Companion.getInstance(context).getWorkInfosByTag(str).get()).iterator();
        while (it.hasNext()) {
            WorkInfo.State state = ((WorkInfo) it.next()).getState();
            if (state == WorkInfo.State.RUNNING || state == WorkInfo.State.ENQUEUED) {
                return true;
            }
        }
        return false;
    }

    public static void p(Context context, File file, String str) {
        file.getClass();
        context.getClass();
        Activity activity = o4.b.g;
        if (r0.f.A() != null || o4.b.f11718q != null) {
            w wVar = (w) context;
            String string = context.getString(R.string.core_installation_in_progress_msg);
            string.getClass();
            wVar.C(string);
            return;
        }
        boolean zF = v5.a.f(context);
        String absolutePath = file.getAbsolutePath();
        absolutePath.getClass();
        Intent intent = new Intent(context, (Class<?>) InstallerActivity.class);
        intent.putExtra("realPath", absolutePath);
        intent.putExtra("requireUserAction", zF);
        intent.putExtra("backgroundInstallation", true);
        intent.addFlags(268435456);
        if (str != null && str.length() != 0) {
            intent.putExtra("newFeatures", str);
        }
        context.startActivity(intent);
        r(context, file);
    }

    public static void q(Context context, File file, String str) {
        file.getClass();
        context.getClass();
        boolean zF = v5.a.f(context);
        String absolutePath = file.getAbsolutePath();
        absolutePath.getClass();
        Intent intent = new Intent(context, (Class<?>) InstallerActivity.class);
        intent.putExtra("realPath", absolutePath);
        intent.putExtra("requireUserAction", zF);
        intent.putExtra("backgroundInstallation", false);
        intent.addFlags(268435456);
        if (str != null && str.length() != 0) {
            intent.putExtra("newFeatures", str);
        }
        context.startActivity(intent);
        r(context, file);
    }

    public static void r(Context context, File file) {
        q qVarX;
        String str;
        g gVarL = g.f13148u.l(context);
        gVarL.a();
        if (file.isFile()) {
            String name = file.getName();
            name.getClass();
            qVarX = gVarL.w(name);
        } else {
            String absolutePath = file.getAbsolutePath();
            absolutePath.getClass();
            qVarX = gVarL.x(absolutePath);
        }
        gVarL.b();
        Bundle bundle = new Bundle();
        if (qVarX != null && (str = qVarX.f8701b) != null) {
            l lVar = UptodownApp.Z;
            if (lVar != null) {
                String strC = r0.f.C(lVar.a());
                if (strC != null && strC.equalsIgnoreCase(str)) {
                    bundle.putString("source", "deeplink");
                }
            } else {
                a0 a0VarJ = t1.J(context);
                if (a0VarJ != null && u.Z(a0VarJ.f8461b, str, true)) {
                    bundle.putString("source", "notification_fcm");
                }
            }
            bundle.putString("packagename", qVarX.f8701b);
        }
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "start");
        new t1.c(context, 4).e(bundle, "install");
    }

    public static boolean s() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - UptodownApp.f6635m0 <= 600) {
            return false;
        }
        UptodownApp.f6635m0 = jCurrentTimeMillis;
        return true;
    }

    public static int t(h hVar, w wVar) {
        q qVar = new q();
        qVar.a(hVar);
        int iQ = qVar.q(wVar);
        if (iQ >= 0) {
            String str = hVar.f8567b;
            str.getClass();
            wVar.e0(iQ, str);
            return iQ;
        }
        wVar.C(wVar.getString(R.string.error_cant_enqueue_download) + " (108)");
        return iQ;
    }

    public static q u(h hVar, Context context) {
        hVar.getClass();
        context.getClass();
        q qVar = new q();
        qVar.a(hVar);
        int iQ = qVar.q(context);
        if (iQ >= 0 && a.a.f0a) {
            float f = UptodownApp.E;
            if (!o(context, "downloadApkWorker")) {
                WorkManager.Companion.getInstance(context).enqueue(((OneTimeWorkRequest.Builder) com.mbridge.msdk.dycreator.baseview.a.h(DownloadApkWorker.class, "downloadApkWorker")).setInputData(new Data.Builder().putInt("downloadId", iQ).build()).build());
            }
        }
        return qVar;
    }

    public static void v(y0 y0Var) {
        y0Var.getClass();
        synchronized (UptodownApp.f6638p0) {
            try {
                Iterator it = UptodownApp.f6639q0.iterator();
                int i10 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i10 = -1;
                        break;
                    }
                    int i11 = i10 + 1;
                    if (u.Z(((y0) it.next()).f8795b, y0Var.f8795b, true)) {
                        break;
                    } else {
                        i10 = i11;
                    }
                }
                if (i10 >= 0) {
                    ArrayList arrayList = UptodownApp.f6639q0;
                    if (i10 < arrayList.size()) {
                        arrayList.remove(i10);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
    
        r1 = com.uptodown.UptodownApp.f6634k0;
        r1.getClass();
        r1.remove(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        r2 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void w(java.lang.String r5) {
        /*
            r5.getClass()
            java.lang.Object r0 = com.uptodown.UptodownApp.f6633j0
            monitor-enter(r0)
            java.util.ArrayList r1 = com.uptodown.UptodownApp.f6634k0     // Catch: java.lang.Throwable -> L2f
            r2 = 0
            if (r1 == 0) goto L34
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L2f
            r3 = r2
        L10:
            if (r3 >= r1) goto L34
            java.util.ArrayList r4 = com.uptodown.UptodownApp.f6634k0     // Catch: java.lang.Throwable -> L2f
            r4.getClass()     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r4 = r4.get(r3)     // Catch: java.lang.Throwable -> L2f
            h5.f r4 = (h5.f) r4     // Catch: java.lang.Throwable -> L2f
            java.lang.String r4 = r4.f8526c     // Catch: java.lang.Throwable -> L2f
            boolean r4 = r5.equalsIgnoreCase(r4)     // Catch: java.lang.Throwable -> L2f
            if (r4 == 0) goto L31
            java.util.ArrayList r1 = com.uptodown.UptodownApp.f6634k0     // Catch: java.lang.Throwable -> L2f
            r1.getClass()     // Catch: java.lang.Throwable -> L2f
            r1.remove(r3)     // Catch: java.lang.Throwable -> L2f
            r2 = 1
            goto L34
        L2f:
            r5 = move-exception
            goto L45
        L31:
            int r3 = r3 + 1
            goto L10
        L34:
            monitor-exit(r0)
            if (r2 == 0) goto L44
            java.lang.String r0 = "packagename"
            android.os.Bundle r5 = com.mbridge.msdk.dycreator.baseview.a.f(r0, r5)
            i5.f r0 = v5.n.f13170b
            r1 = 106(0x6a, float:1.49E-43)
            r0.send(r1, r5)
        L44:
            return
        L45:
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.c.w(java.lang.String):void");
    }

    public static z5.f x(Context context) {
        context.getClass();
        return new z5.f((int) context.getResources().getDimension(R.dimen.border_radius_m));
    }

    public static z5.f y(Context context) {
        int i10;
        context.getClass();
        String str = "1";
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("data_saver_options")) {
                String string = sharedPreferences.getString("data_saver_options", "1");
                string.getClass();
                str = string;
            }
        } catch (Exception unused) {
        }
        return (Integer.parseInt(str) <= 0 || ((i10 = a.a.f1b) != 0 && (!a.a.f0a || (!a.a.f3d && i10 < 4300)))) ? new z5.f((int) context.getResources().getDimension(R.dimen.border_radius_xs)) : new z5.f((int) context.getResources().getDimension(R.dimen.border_radius_m));
    }

    public static z5.f z(Context context) {
        context.getClass();
        return new z5.f((int) context.getResources().getDimension(R.dimen.border_radius_s));
    }
}

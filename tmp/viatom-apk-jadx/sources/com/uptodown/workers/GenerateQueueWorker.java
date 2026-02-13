package com.uptodown.workers;

import a6.h;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.mbridge.msdk.dycreator.baseview.a;
import com.uptodown.UptodownApp;
import h5.e;
import h5.q;
import h5.y0;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import k4.c;
import o4.b;
import o7.u;
import r0.f;
import v5.g;
import v5.i;
import v5.n;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class GenerateQueueWorker extends Worker {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6742a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f6743b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f6744c;

    /* renamed from: d, reason: collision with root package name */
    public final String f6745d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenerateQueueWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.f6742a = context;
        this.f6743b = workerParameters.getInputData().getBoolean("downloadAnyway", false);
        this.f6744c = workerParameters.getInputData().getBoolean("downloadUptodown", false);
        this.f6745d = workerParameters.getInputData().getString("packagename");
        Activity activity = b.g;
        this.f6742a = f.h(context);
    }

    public final void d() throws IOException {
        float f = UptodownApp.E;
        Context context = this.f6742a;
        context.getClass();
        if (c.o(context, "DownloadUpdatesWorker")) {
            return;
        }
        WorkManager.Companion.getInstance(context).enqueue(((OneTimeWorkRequest.Builder) a.h(DownloadUpdatesWorker.class, "DownloadUpdatesWorker")).setInputData(new Data.Builder().putBoolean("downloadAnyway", this.f6743b).build()).build());
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result doWork() throws Resources.NotFoundException, NumberFormatException, IOException {
        ArrayList arrayListO;
        boolean z9;
        File fileG;
        int applicationEnabledSetting;
        float f = UptodownApp.E;
        Context context = this.f6742a;
        context.getClass();
        if (!c.o(context, "DownloadUpdatesWorker")) {
            String str = this.f6745d;
            boolean z10 = this.f6744c;
            Context context2 = this.f6742a;
            ArrayList arrayList = new ArrayList();
            g gVarL = g.f13148u.l(context2);
            gVarL.a();
            if (str != null) {
                arrayListO = new ArrayList();
                y0 y0VarM = gVarL.M(str);
                if (y0VarM != null) {
                    arrayListO.add(y0VarM);
                }
            } else {
                arrayListO = gVarL.O();
            }
            String packageName = context2.getPackageName();
            if (z10) {
                packageName.getClass();
                y0 y0VarM2 = gVarL.M(packageName);
                if (y0VarM2 != null) {
                    arrayListO = new ArrayList();
                    arrayListO.add(y0VarM2);
                }
            }
            String str2 = "2";
            try {
                SharedPreferences sharedPreferences = context2.getSharedPreferences("SettingsPreferences", 0);
                if (sharedPreferences.contains("download_updates_options")) {
                    String string = sharedPreferences.getString("download_updates_options", "2");
                    string.getClass();
                    str2 = string;
                }
            } catch (Exception unused) {
            }
            Iterator it = arrayListO.iterator();
            it.getClass();
            while (true) {
                z9 = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                next.getClass();
                y0 y0Var = (y0) next;
                h5.f fVarH = v5.a.h(context2, y0Var.f8795b);
                if (fVarH != null) {
                    if (!u.Z(packageName, fVarH.f8526c, true) && str == null) {
                        if (fVarH.f8541w > 0 && fVarH.f8532m == 0 && fVarH.b(context2)) {
                            Context context3 = this.f6742a;
                            if (str2.equalsIgnoreCase("2") && !v5.a.f(context3)) {
                                String str3 = fVarH.f8526c;
                                String strB = str3 != null ? v5.a.b(context3, str3) : null;
                                if (strB == null || !strB.equalsIgnoreCase(context3.getPackageName())) {
                                }
                            }
                        }
                    }
                    if (!y0Var.b()) {
                        String str4 = y0Var.f8795b;
                        str4.getClass();
                        try {
                            applicationEnabledSetting = context2.getPackageManager().getApplicationEnabledSetting(str4);
                        } catch (Error e) {
                            e.printStackTrace();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        if (applicationEnabledSetting != 2 && applicationEnabledSetting != 3 && applicationEnabledSetting != 4) {
                            q qVarA = y0Var.a(context2);
                            if (qVarA == null || !qVarA.c() || (fileG = qVarA.g()) == null || !fileG.exists()) {
                                arrayList.add(fVarH);
                            }
                        }
                    }
                }
            }
            gVarL.b();
            t6.q.W(arrayList, new h(0));
            int size = arrayList.size();
            int i10 = 0;
            while (true) {
                if (i10 < size) {
                    if (u.Z(packageName, ((h5.f) arrayList.get(i10)).f8526c, true) && ((h5.f) arrayList.get(i10)).g == e.f8506a) {
                        Object obj = arrayList.get(i10);
                        obj.getClass();
                        arrayList.remove(i10);
                        arrayList.add(0, (h5.f) obj);
                        break;
                    }
                    i10++;
                } else {
                    break;
                }
            }
            synchronized (UptodownApp.f6633j0) {
                UptodownApp.f6634k0 = arrayList;
            }
            float f10 = UptodownApp.E;
            ArrayList<? extends Parcelable> arrayListH = c.h();
            if (arrayListH == null || arrayListH.size() <= 0) {
                Context context4 = this.f6742a;
                context4.getClass();
                if (!c.o(context4, "InstallUpdatesWorker")) {
                    WorkManager.Companion.getInstance(context4).enqueue(((OneTimeWorkRequest.Builder) a.h(InstallUpdatesWorker.class, "InstallUpdatesWorker")).build());
                }
            } else {
                Context context5 = this.f6742a;
                context5.getClass();
                try {
                    SharedPreferences sharedPreferences2 = context5.getSharedPreferences("SettingsPreferences", 0);
                    if (sharedPreferences2.contains("only_wifi")) {
                        z9 = sharedPreferences2.getBoolean("only_wifi", true);
                    }
                } catch (Exception unused2) {
                }
                if (!z9 || a.a.f3d || this.f6743b) {
                    d();
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("apps_parcelable", arrayListH);
                    n.f13170b.send(105, bundle);
                    i.l(this.f6742a);
                    c.f();
                }
            }
        }
        ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
        resultSuccess.getClass();
        return resultSuccess;
    }
}

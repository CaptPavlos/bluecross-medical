package com.uptodown.workers;

import a.a;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import com.uptodown.UptodownApp;
import h5.q;
import h5.r;
import h5.y0;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.ArrayList;
import o4.b;
import r0.f;
import t1.c;
import v5.i;
import v5.n;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class DownloadUpdatesWorker extends DownloadWorker {
    public static y0 h;
    public final boolean g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadUpdatesWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.g = workerParameters.getInputData().getBoolean("downloadAnyway", false);
        DownloadWorker.e = false;
        DownloadWorker.f = false;
        Activity activity = b.g;
        Context contextH = f.h(this.f6739a);
        this.f6739a = contextH;
        this.f6740b = new c(contextH, 4);
    }

    @Override // com.uptodown.workers.DownloadWorker, androidx.work.Worker
    public final ListenableWorker.Result doWork() throws InterruptedException, Resources.NotFoundException, IOException, NumberFormatException {
        if (getRunAttemptCount() > 0) {
            ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
            resultSuccess.getClass();
            return resultSuccess;
        }
        i5.f fVar = n.f13170b;
        fVar.send(107, null);
        if (a.f0a) {
            Context applicationContext = getApplicationContext();
            applicationContext.getClass();
            f.o(applicationContext);
            float f = UptodownApp.E;
            ArrayList<? extends Parcelable> arrayListH = k4.c.h();
            if (arrayListH != null && arrayListH.size() > 0) {
                Context context = this.f6739a;
                context.getClass();
                boolean z9 = true;
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
                    if (sharedPreferences.contains("only_wifi")) {
                        z9 = sharedPreferences.getBoolean("only_wifi", true);
                    }
                } catch (Exception unused) {
                }
                if (!z9 || a.f3d || this.g) {
                    y();
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("apps_parcelable", arrayListH);
                    fVar.send(105, bundle);
                }
            }
        } else {
            fVar.send(110, null);
        }
        Context context2 = this.f6739a;
        context2.getClass();
        float f10 = UptodownApp.E;
        if (!k4.c.o(context2, "InstallUpdatesWorker")) {
            WorkManager.Companion.getInstance(context2).enqueue(((OneTimeWorkRequest.Builder) com.mbridge.msdk.dycreator.baseview.a.h(InstallUpdatesWorker.class, "InstallUpdatesWorker")).build());
        }
        fVar.send(103, null);
        i.l(this.f6739a);
        ListenableWorker.Result resultSuccess2 = ListenableWorker.Result.success();
        resultSuccess2.getClass();
        return resultSuccess2;
    }

    @Override // com.uptodown.workers.DownloadWorker
    public final y0 m() {
        return h;
    }

    @Override // com.uptodown.workers.DownloadWorker
    public final void p(y0 y0Var, q qVar, r rVar, Bundle bundle, String str, long j10) {
        y0Var.getClass();
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail");
        if (j10 > 0) {
            bundle.putLong(TypedValues.TransitionType.S_DURATION, (System.currentTimeMillis() - j10) / 1000);
        }
        n(bundle, str, rVar);
    }

    @Override // com.uptodown.workers.DownloadWorker
    public final void w(q qVar) {
        qVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("update", h);
        bundle.putParcelable("download", qVar);
        ConcurrentHashMap concurrentHashMap = n.f13169a;
        n.f13170b.send(102, bundle);
    }

    @Override // com.uptodown.workers.DownloadWorker
    public final void x(q qVar, int i10) {
        qVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("update", h);
        bundle.putParcelable("download", qVar);
        bundle.putString("packagename", qVar.f8701b);
        n.f13170b.send(i10, bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:69:0x018a  */
    /* JADX WARN: Type inference failed for: r0v41, types: [android.os.ResultReceiver, i5.f] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3, types: [android.os.Bundle, java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y() throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1792
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.DownloadUpdatesWorker.y():void");
    }
}

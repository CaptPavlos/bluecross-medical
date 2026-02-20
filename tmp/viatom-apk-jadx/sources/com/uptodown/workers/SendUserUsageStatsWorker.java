package com.uptodown.workers;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.work.ListenableWorker;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import c1.w4;
import com.uptodown.UptodownApp;
import h5.p0;
import java.util.HashMap;
import k4.c;
import o4.b;
import org.json.JSONObject;
import r0.f;
import v5.o;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class SendUserUsageStatsWorker extends Worker {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6750a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendUserUsageStatsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.f6750a = context;
        Activity activity = b.g;
        this.f6750a = f.h(context);
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result doWork() {
        String str;
        Context context = this.f6750a;
        if (o.b(context)) {
            int iV = t1.v(context, 0, "stats_downloads");
            int iV2 = t1.v(context, 0, "stats_installs");
            int iV3 = t1.v(context, 0, "stats_updates");
            t1.w(0L, context, "stats_time");
            long jA = o.a(context);
            w4 w4Var = new w4(context, 4, false);
            HashMap map = new HashMap();
            map.put("usageTime", String.valueOf(jA));
            map.put("downloads", String.valueOf(iV));
            map.put("installations", String.valueOf(iV2));
            map.put("updates", String.valueOf(iV3));
            map.put("lastUpdate", String.valueOf(System.currentTimeMillis() / 1000));
            p0 p0VarM = w4Var.m("https://www.uptodown.app:443".concat("/eapi/user-data/native-app-usage"), ShareTarget.METHOD_POST, map);
            p0VarM.f8699d = w4Var.k(p0VarM, "/eapi/user-data/native-app-usage");
            if (!p0VarM.b() && (str = p0VarM.f8696a) != null && str.length() != 0) {
                String str2 = p0VarM.f8696a;
                str2.getClass();
                if (new JSONObject(str2).optInt("success") == 1) {
                    t1.O(context, 0, "stats_downloads");
                    t1.O(context, 0, "stats_installs");
                    t1.O(context, 0, "stats_updates");
                    t1.Q(0L, context, "stats_time");
                }
            }
        } else {
            try {
                SharedPreferences.Editor editorEdit = context.getSharedPreferences("SettingsPreferences", 0).edit();
                editorEdit.putBoolean("stats_enabled", false);
                editorEdit.apply();
            } catch (Exception e) {
                e.printStackTrace();
            }
            float f = UptodownApp.E;
            if (c.o(context, "SendUserUsageStatsWorker")) {
                WorkManager.Companion.getInstance(context).cancelAllWorkByTag("SendUserUsageStatsWorker");
            }
        }
        ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
        resultSuccess.getClass();
        return resultSuccess;
    }
}

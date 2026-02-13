package com.uptodown.workers;

import a.a;
import a3.x;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import c1.w4;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.UptodownApp;
import h5.q;
import h5.r;
import h5.s;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.internal.w;
import o4.b;
import o7.m;
import r0.f;
import r1.i;
import t1.c;
import v5.g;
import v5.n;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class DownloadApkWorker extends DownloadWorker {
    public final String g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadApkWorker(Context context, WorkerParameters workerParameters) {
        Cursor cursorQuery;
        int i10;
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        DownloadWorker.e = false;
        DownloadWorker.f = false;
        Activity activity = b.g;
        Context contextH = f.h(this.f6739a);
        this.f6739a = contextH;
        this.f6740b = new c(contextH, 4);
        int i11 = workerParameters.getInputData().getInt("downloadId", -1);
        if (i11 >= 0) {
            g gVarL = g.f13148u.l(this.f6739a);
            gVarL.a();
            q qVar = null;
            try {
                String[] strArr = {String.valueOf(i11)};
                SQLiteDatabase sQLiteDatabase = gVarL.f13150a;
                sQLiteDatabase.getClass();
                cursorQuery = sQLiteDatabase.query("downloads", gVarL.e, "id=?", strArr, null, null, null);
                try {
                    q qVarV = cursorQuery.moveToFirst() ? g.V(cursorQuery) : null;
                    cursorQuery.close();
                    if (qVarV != null && (i10 = qVarV.f8700a) >= 0) {
                        qVarV.f8716v = gVarL.D(i10);
                    }
                    qVar = qVarV;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    DownloadWorker.f6738d = qVar;
                    gVarL.b();
                    this.g = workerParameters.getInputData().getString("url");
                }
            } catch (Exception e3) {
                e = e3;
                cursorQuery = null;
            }
            DownloadWorker.f6738d = qVar;
            gVarL.b();
        }
        this.g = workerParameters.getInputData().getString("url");
    }

    @Override // com.uptodown.workers.DownloadWorker, androidx.work.Worker
    public final ListenableWorker.Result doWork() throws InterruptedException, IOException {
        long j10;
        File externalFilesDir;
        q qVar;
        File externalFilesDir2;
        File externalFilesDir3;
        boolean z9 = false;
        String str = this.g;
        if (str != null) {
            this.f6741c = null;
            DownloadWorker.f = false;
            DownloadWorker.e = false;
            if (a.f0a) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                n(com.mbridge.msdk.dycreator.baseview.a.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "start"), new URL(str).getHost(), null);
                HttpsURLConnection httpsURLConnectionV = v(str, jCurrentTimeMillis, null);
                if (httpsURLConnectionV != null) {
                    this.f6741c = httpsURLConnectionV.getURL().getHost();
                    String string = httpsURLConnectionV.getURL().toString();
                    string.getClass();
                    int i10 = 1;
                    String strSubstring = string.substring(m.m0("/", string, 6) + 1);
                    if (m.k0(strSubstring, ".", 0, false, 6) < 0) {
                        String string2 = httpsURLConnectionV.getURL().toString();
                        string2.getClass();
                        strSubstring = strSubstring.concat(DownloadWorker.l(string2));
                    }
                    if (strSubstring.length() <= 0 || (qVar = DownloadWorker.f6738d) == null) {
                        j10 = 0;
                    } else if (qVar.f8716v.isEmpty()) {
                        Context context = this.f6739a;
                        context.getClass();
                        j10 = 0;
                        w4 w4Var = new w4(context, 3, false);
                        if (w4Var.D()) {
                            File[] externalFilesDirs = context.getExternalFilesDirs(null);
                            if (externalFilesDirs.length > 1) {
                                externalFilesDir3 = externalFilesDirs[1];
                            } else {
                                externalFilesDir3 = context.getExternalFilesDir(null);
                                w4Var.P();
                                w4Var.O();
                            }
                        } else {
                            externalFilesDir3 = context.getExternalFilesDir(null);
                        }
                        File file = new File(externalFilesDir3, "Apps");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        File file2 = new File(file, strSubstring);
                        r rVar = new r();
                        rVar.h = file2.getAbsolutePath();
                        rVar.e = DownloadWorker.k(httpsURLConnectionV);
                        g gVarL = g.f13148u.l(this.f6739a);
                        gVarL.a();
                        DownloadWorker.f6738d.getClass();
                        gVarL.Q(r7.f8700a, rVar);
                        gVarL.b();
                        q qVar2 = DownloadWorker.f6738d;
                        qVar2.getClass();
                        qVar2.f8716v.add(rVar);
                    } else {
                        j10 = 0;
                        q qVar3 = DownloadWorker.f6738d;
                        qVar3.getClass();
                        if (((r) qVar3.f8716v.get(0)).h == null) {
                            Context context2 = this.f6739a;
                            context2.getClass();
                            w4 w4Var2 = new w4(context2, 3, false);
                            if (w4Var2.D()) {
                                File[] externalFilesDirs2 = context2.getExternalFilesDirs(null);
                                if (externalFilesDirs2.length > 1) {
                                    externalFilesDir2 = externalFilesDirs2[1];
                                } else {
                                    externalFilesDir2 = context2.getExternalFilesDir(null);
                                    w4Var2.P();
                                    w4Var2.O();
                                }
                            } else {
                                externalFilesDir2 = context2.getExternalFilesDir(null);
                            }
                            File file3 = new File(externalFilesDir2, "Apps");
                            if (!file3.exists()) {
                                file3.mkdirs();
                            }
                            File file4 = new File(file3, strSubstring);
                            q qVar4 = DownloadWorker.f6738d;
                            qVar4.getClass();
                            ((r) qVar4.f8716v.get(0)).h = file4.getAbsolutePath();
                            g gVarL2 = g.f13148u.l(this.f6739a);
                            gVarL2.a();
                            q qVar5 = DownloadWorker.f6738d;
                            qVar5.getClass();
                            Object obj = qVar5.f8716v.get(0);
                            obj.getClass();
                            gVarL2.e0((r) obj);
                            gVarL2.b();
                        }
                    }
                    Context context3 = this.f6739a;
                    context3.getClass();
                    w4 w4Var3 = new w4(context3, 3, false);
                    if (w4Var3.D()) {
                        File[] externalFilesDirs3 = context3.getExternalFilesDirs(null);
                        if (externalFilesDirs3.length > 1) {
                            externalFilesDir = externalFilesDirs3[1];
                        } else {
                            externalFilesDir = context3.getExternalFilesDir(null);
                            w4Var3.P();
                            w4Var3.O();
                        }
                    } else {
                        externalFilesDir = context3.getExternalFilesDir(null);
                    }
                    File file5 = new File(externalFilesDir, "Apps");
                    if (!file5.exists()) {
                        file5.mkdirs();
                    }
                    if (file5.exists() || file5.mkdirs()) {
                        q qVar6 = DownloadWorker.f6738d;
                        qVar6.getClass();
                        String str2 = ((r) qVar6.f8716v.get(0)).h;
                        str2.getClass();
                        File file6 = new File(str2);
                        if (DownloadWorker.e) {
                            q qVar7 = DownloadWorker.f6738d;
                            qVar7.getClass();
                            g(jCurrentTimeMillis, (r) qVar7.f8716v.get(0));
                        } else if (r(httpsURLConnectionV, jCurrentTimeMillis)) {
                            q qVar8 = DownloadWorker.f6738d;
                            qVar8.getClass();
                            long length = ((r) qVar8.f8716v.get(0)).e - file6.length();
                            if (length >= j10) {
                                if (f.E(this.f6739a, file5) < length * 2.25d) {
                                    httpsURLConnectionV.disconnect();
                                    q qVar9 = DownloadWorker.f6738d;
                                    if (qVar9 != null) {
                                        qVar9.s(this.f6739a);
                                    }
                                    h(i.c(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail", CampaignEx.JSON_NATIVE_VIDEO_ERROR, "no_enough_space"), " (112)", jCurrentTimeMillis);
                                } else {
                                    q qVar10 = DownloadWorker.f6738d;
                                    qVar10.getClass();
                                    x(qVar10, 200);
                                    q qVar11 = DownloadWorker.f6738d;
                                    qVar11.getClass();
                                    if (qVar11.h > j10) {
                                        g gVarL3 = g.f13148u.l(this.f6739a);
                                        gVarL3.a();
                                        q qVar12 = DownloadWorker.f6738d;
                                        qVar12.getClass();
                                        s sVarE = gVarL3.E(qVar12.h);
                                        if (sVarE != null) {
                                            sVarE.a(this.f6739a, "downloadStarted");
                                        }
                                        gVarL3.b();
                                    }
                                    w wVar = new w();
                                    w wVar2 = new w();
                                    x xVar = new x(wVar, wVar2, this, i10);
                                    q qVar13 = DownloadWorker.f6738d;
                                    qVar13.getClass();
                                    q qVar14 = DownloadWorker.f6738d;
                                    qVar14.getClass();
                                    Object obj2 = qVar14.f8716v.get(0);
                                    obj2.getClass();
                                    String str3 = this.f6741c;
                                    str3.getClass();
                                    long jI = i(httpsURLConnectionV, file6, qVar13, (r) obj2, str3, jCurrentTimeMillis, xVar);
                                    if (jI >= j10) {
                                        if (DownloadWorker.e) {
                                            q qVar15 = DownloadWorker.f6738d;
                                            qVar15.getClass();
                                            g(jCurrentTimeMillis, (r) qVar15.f8716v.get(0));
                                        } else {
                                            q qVar16 = DownloadWorker.f6738d;
                                            if (qVar16 != null) {
                                                qVar16.f8703d = 0;
                                                g gVarL4 = g.f13148u.l(this.f6739a);
                                                gVarL4.a();
                                                q qVar17 = DownloadWorker.f6738d;
                                                qVar17.getClass();
                                                gVarL4.d0(qVar17);
                                                gVarL4.b();
                                            }
                                            q qVar18 = DownloadWorker.f6738d;
                                            if (qVar18 != null && qVar18.h > j10) {
                                                g gVarL5 = g.f13148u.l(this.f6739a);
                                                gVarL5.a();
                                                q qVar19 = DownloadWorker.f6738d;
                                                qVar19.getClass();
                                                s sVarE2 = gVarL5.E(qVar19.h);
                                                if (sVarE2 != null) {
                                                    sVarE2.a(this.f6739a, "downloadFinished");
                                                }
                                                gVarL5.b();
                                            }
                                            o(wVar.f10137a, jCurrentTimeMillis, wVar2.f10137a, jI, null);
                                            Context context4 = this.f6739a;
                                            context4.getClass();
                                            try {
                                                SharedPreferences sharedPreferences = context4.getSharedPreferences("CoreSettings", 0);
                                                if (sharedPreferences.contains("install_apk_as_root_system")) {
                                                    z9 = sharedPreferences.getBoolean("install_apk_as_root_system", false);
                                                }
                                            } catch (Exception unused) {
                                            }
                                            if (z9) {
                                                float f = UptodownApp.E;
                                                k4.c.q(this.f6739a, file6, null);
                                            }
                                            q qVar20 = DownloadWorker.f6738d;
                                            qVar20.getClass();
                                            x(qVar20, 202);
                                            Context context5 = this.f6739a;
                                            context5.getClass();
                                            Object systemService = context5.getSystemService("notification");
                                            systemService.getClass();
                                            ((NotificationManager) systemService).cancel(261);
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        h(i.c(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail", CampaignEx.JSON_NATIVE_VIDEO_ERROR, "cant_mkdir"), " (106)", jCurrentTimeMillis);
                    }
                }
            } else {
                n.f13171c.send(209, null);
            }
        } else {
            q qVar21 = DownloadWorker.f6738d;
            if (qVar21 == null) {
                z(null, " (100)");
            } else if (qVar21.f8716v.isEmpty()) {
                z(DownloadWorker.f6738d, " (114)");
            } else {
                q qVar22 = DownloadWorker.f6738d;
                qVar22.getClass();
                if (((r) qVar22.f8716v.get(0)).f8722c < 0) {
                    z(DownloadWorker.f6738d, " (103)");
                } else {
                    q qVar23 = DownloadWorker.f6738d;
                    qVar23.getClass();
                    if (qVar23.h == -1) {
                        z(DownloadWorker.f6738d, " (113)");
                    } else {
                        q qVar24 = DownloadWorker.f6738d;
                        qVar24.getClass();
                        y(qVar24);
                    }
                }
            }
        }
        n.f13171c.send(210, null);
        ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
        resultSuccess.getClass();
        return resultSuccess;
    }

    @Override // com.uptodown.workers.DownloadWorker
    public final void h(Bundle bundle, String str, long j10) {
        z(DownloadWorker.f6738d, str);
        if (j10 > 0) {
            bundle.putLong(TypedValues.TransitionType.S_DURATION, (System.currentTimeMillis() - j10) / 1000);
        }
        d(bundle, null);
        c cVar = this.f6740b;
        if (cVar != null) {
            cVar.e(bundle, "download");
        }
    }

    @Override // com.uptodown.workers.DownloadWorker
    public final void w(q qVar) {
        qVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("download", qVar);
        ConcurrentHashMap concurrentHashMap = n.f13169a;
        n.f13171c.send(203, bundle);
    }

    @Override // com.uptodown.workers.DownloadWorker
    public final void x(q qVar, int i10) {
        qVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("download", qVar);
        bundle.putString("packagename", qVar.f8701b);
        n.f13171c.send(i10, bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x05e1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f3  */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(h5.q r33) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1879
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.DownloadApkWorker.y(h5.q):void");
    }

    public final void z(q qVar, String str) {
        if (qVar != null) {
            qVar.l(this.f6739a);
            w(qVar);
        }
        v5.i.i(this.f6739a, qVar, str);
    }
}

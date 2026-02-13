package com.uptodown.workers;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.internal.measurement.l5;
import com.mbridge.msdk.dycreator.baseview.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import h5.q;
import h5.r;
import h5.y0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import javax.net.ssl.HttpsURLConnection;
import o7.m;
import r1.i;
import t1.c;
import v5.g;
import v5.n;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class DownloadWorker extends Worker {

    /* renamed from: d, reason: collision with root package name */
    public static q f6738d;
    public static boolean e;
    public static boolean f;

    /* renamed from: a, reason: collision with root package name */
    public Context f6739a;

    /* renamed from: b, reason: collision with root package name */
    public c f6740b;

    /* renamed from: c, reason: collision with root package name */
    public String f6741c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.f6739a = context;
    }

    public static void f(InputStream inputStream, FileOutputStream fileOutputStream, HttpsURLConnection httpsURLConnection) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException e7) {
                e7.printStackTrace();
            }
        }
        if (a.w(fileOutputStream)) {
            fileOutputStream.getFD().sync();
        }
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        httpsURLConnection.disconnect();
    }

    public static long k(HttpsURLConnection httpsURLConnection) {
        return Build.VERSION.SDK_INT >= 24 ? httpsURLConnection.getContentLengthLong() : httpsURLConnection.getContentLength();
    }

    public static String l(String str) {
        if (m.m0(".", str, 6) != -1) {
            String strSubstring = str.substring(m.m0(".", str, 6) + 1);
            if (strSubstring.length() != 0) {
                return strSubstring;
            }
        }
        return "apk";
    }

    public static HttpsURLConnection s(URL url) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        uRLConnectionOpenConnection.getClass();
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
        httpsURLConnection.setRequestProperty("Identificador", "Uptodown_Android");
        httpsURLConnection.setRequestProperty("Identificador-Version", "704");
        httpsURLConnection.setRequestProperty("APIKEY", n.b());
        httpsURLConnection.setConnectTimeout(MBridgeCommon.DEFAULT_LOAD_TIMEOUT);
        httpsURLConnection.setReadTimeout(90000);
        return httpsURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(android.os.Bundle r8, h5.r r9) {
        /*
            r7 = this;
            h5.l r0 = com.uptodown.UptodownApp.Z
            java.lang.String r1 = "deeplink"
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L19
            h5.q r4 = com.uptodown.workers.DownloadWorker.f6738d
            if (r4 == 0) goto L19
            int r0 = r0.f8646c
            r4.getClass()
            int r4 = r4.f8700a
            if (r0 != r4) goto L19
            r8.putInt(r1, r3)
            goto L1c
        L19:
            r8.putInt(r1, r2)
        L1c:
            android.content.Context r0 = r7.f6739a
            h5.a0 r0 = z1.t1.J(r0)
            if (r0 == 0) goto L37
            h5.q r1 = com.uptodown.workers.DownloadWorker.f6738d
            java.lang.String r4 = "notification_fcm"
            if (r1 == 0) goto L34
            int r0 = r0.f8462c
            int r1 = r1.f8700a
            if (r0 != r1) goto L34
            r8.putInt(r4, r3)
            goto L37
        L34:
            r8.putInt(r4, r2)
        L37:
            java.lang.String r0 = r7.f6741c
            if (r0 == 0) goto L40
            java.lang.String r1 = "host"
            r8.putString(r1, r0)
        L40:
            if (r9 == 0) goto L91
            long r0 = r9.f8722c
            r4 = 0
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 <= 0) goto L53
            java.lang.String r6 = "fileId"
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r8.putString(r6, r0)
        L53:
            long r0 = r9.e
            int r9 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r9 <= 0) goto L91
            r4 = 10485760(0xa00000, double:5.180654E-317)
            int r9 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            java.lang.String r4 = "<10MB"
            if (r9 >= 0) goto L63
            goto L8c
        L63:
            r5 = 104857600(0x6400000, double:5.1806538E-316)
            int r9 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r9 >= 0) goto L6d
            java.lang.String r4 = "<100MB"
            goto L8c
        L6d:
            r5 = 524288000(0x1f400000, double:2.590326893E-315)
            int r9 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r9 >= 0) goto L77
            java.lang.String r4 = "<500MB"
            goto L8c
        L77:
            r5 = 1073741824(0x40000000, double:5.304989477E-315)
            int r9 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r9 >= 0) goto L81
            java.lang.String r4 = "<1GB"
            goto L8c
        L81:
            r5 = 10737418240(0x280000000, double:5.3049894774E-314)
            int r9 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r9 >= 0) goto L8c
            java.lang.String r4 = "<10GB"
        L8c:
            java.lang.String r9 = "size"
            r8.putString(r9, r4)
        L91:
            h5.y0 r9 = r7.m()
            java.lang.String r0 = "update"
            if (r9 == 0) goto L9d
            r8.putInt(r0, r3)
            goto La0
        L9d:
            r8.putInt(r0, r2)
        La0:
            boolean r9 = a.a.f3d
            if (r9 == 0) goto La7
            java.lang.String r9 = "wifi"
            goto La9
        La7:
            java.lang.String r9 = "mobile"
        La9:
            java.lang.String r0 = "connectionType"
            r8.putString(r0, r9)
            int r9 = a.a.f1b
            long r0 = (long) r9
            java.lang.String r9 = "downBandwidthKbps"
            r8.putLong(r9, r0)
            int r9 = a.a.f2c
            long r0 = (long) r9
            java.lang.String r9 = "upBandwidthKbps"
            r8.putLong(r9, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.DownloadWorker.d(android.os.Bundle, h5.r):void");
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        ListenableWorker.Result resultFailure = ListenableWorker.Result.failure();
        resultFailure.getClass();
        return resultFailure;
    }

    public final Bundle e(long j10, long j11, File file, r rVar) {
        Bundle bundleC;
        long j12 = rVar.e;
        String str = rVar.g;
        q qVar = f6738d;
        qVar.getClass();
        x(qVar, 205);
        if (file.length() > 0) {
            long j13 = j10 + j11;
            if (j12 == 0 || (j13 == j12 && file.length() == j13)) {
                bundleC = null;
                boolean z9 = false;
                String strY = null;
                int i10 = 0;
                while (!z9 && i10 < 3) {
                    i10++;
                    if (file.length() == j13 && (strY = l5.y(file.getAbsolutePath())) != null && strY.equalsIgnoreCase(str)) {
                        z9 = true;
                    }
                }
                if (strY == null) {
                    bundleC = i.c(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail", "filehash", str);
                    bundleC.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "filehash_calculated_null");
                } else if (!z9) {
                    bundleC = i.c(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail", "filehash", str);
                    bundleC.putString("filehashCalculated", strY);
                    bundleC.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "filehash_not_match");
                }
            } else {
                bundleC = i.c(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail", CampaignEx.JSON_NATIVE_VIDEO_ERROR, "size_not_match");
            }
        } else {
            bundleC = i.c(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail", CampaignEx.JSON_NATIVE_VIDEO_ERROR, "size_zero");
        }
        q qVar2 = f6738d;
        qVar2.getClass();
        x(qVar2, 206);
        long j14 = rVar.f8722c;
        if (j14 > 0 && bundleC != null) {
            bundleC.putString("fileId", String.valueOf(j14));
        }
        long j15 = rVar.e;
        if (j15 > 0 && bundleC != null) {
            String str2 = "<10MB";
            if (j15 >= 10485760) {
                if (j15 < 104857600) {
                    str2 = "<100MB";
                } else if (j15 < 524288000) {
                    str2 = "<500MB";
                } else if (j15 < 1073741824) {
                    str2 = "<1GB";
                } else if (j15 < 10737418240L) {
                    str2 = "<10GB";
                }
            }
            bundleC.putString("size", str2);
        }
        return bundleC;
    }

    public final void g(long j10, r rVar) {
        q qVar = f6738d;
        if (qVar != null) {
            qVar.s(this.f6739a);
            g gVarL = g.f13148u.l(this.f6739a);
            gVarL.a();
            q qVar2 = f6738d;
            qVar2.getClass();
            if (qVar2.o()) {
                gVarL.j(f6738d);
            } else {
                q qVar3 = f6738d;
                qVar3.getClass();
                Iterator it = qVar3.f8716v.iterator();
                it.getClass();
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    r rVar2 = (r) next;
                    rVar2.f = 0L;
                    rVar2.f8724i = 0;
                    gVarL.e0(rVar2);
                }
            }
            gVarL.b();
            if (f) {
                f = false;
                e = false;
            }
            Context context = this.f6739a;
            context.getClass();
            Object systemService = context.getSystemService("notification");
            systemService.getClass();
            ((NotificationManager) systemService).cancel(261);
            Bundle bundle = new Bundle();
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "cancelled");
            if (j10 > 0) {
                bundle.putLong(TypedValues.TransitionType.S_DURATION, (System.currentTimeMillis() - j10) / 1000);
            }
            n(bundle, null, rVar);
            q qVar4 = f6738d;
            qVar4.getClass();
            x(qVar4, 207);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:145:0x020e
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:131)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:57)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:49)
        */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    /* JADX WARN: Unreachable blocks removed: 3, instructions: 3 */
    public final long i(javax.net.ssl.HttpsURLConnection r40, java.io.File r41, h5.q r42, h5.r r43, java.lang.String r44, long r45, a6.g r47) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1955
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.DownloadWorker.i(javax.net.ssl.HttpsURLConnection, java.io.File, h5.q, h5.r, java.lang.String, long, a6.g):long");
    }

    public final void j(r rVar) {
        n(a.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "first_data"), this.f6741c, rVar);
    }

    public y0 m() {
        return null;
    }

    public final void n(Bundle bundle, String str, r rVar) {
        this.f6741c = str;
        d(bundle, rVar);
        c cVar = this.f6740b;
        if (cVar != null) {
            cVar.e(bundle, "download");
        }
    }

    public final void o(long j10, long j11, long j12, long j13, r rVar) {
        Bundle bundleF = a.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "completed");
        if (j10 == 0) {
            long jCurrentTimeMillis = (System.currentTimeMillis() - j12) / 1000;
            if (jCurrentTimeMillis > 0) {
                j10 = j13 / jCurrentTimeMillis;
            }
        }
        bundleF.putLong("speed", j10);
        bundleF.putLong(TypedValues.TransitionType.S_DURATION, (System.currentTimeMillis() - j11) / 1000);
        n(bundleF, this.f6741c, rVar);
    }

    public final void q(int i10) {
        if (f6738d != null) {
            Data.Builder builder = new Data.Builder();
            builder.putInt("downloadProgress", i10);
            setProgressAsync(builder.build());
            if (m() == null) {
                v5.i.c(this.f6739a);
            }
            q qVar = f6738d;
            qVar.getClass();
            x(qVar, 201);
        }
    }

    public final boolean r(HttpsURLConnection httpsURLConnection, long j10) throws IOException {
        httpsURLConnection.connect();
        int responseCode = httpsURLConnection.getResponseCode();
        if (responseCode >= 200 && responseCode < 300) {
            return true;
        }
        Bundle bundleC = i.c(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail", CampaignEx.JSON_NATIVE_VIDEO_ERROR, NotificationCompat.CATEGORY_STATUS);
        bundleC.putString("responseCode", String.valueOf(responseCode));
        bundleC.putString("url", httpsURLConnection.getURL().toString());
        if (m() != null) {
            bundleC.putInt("update", 1);
        } else {
            bundleC.putInt("update", 0);
        }
        h(bundleC, " (105)", j10);
        return false;
    }

    public final void t(q qVar, r rVar, String str, String str2, long j10, String str3) {
        y0 y0VarM = m();
        if (y0VarM == null) {
            Bundle bundleC = i.c("exception", str, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail");
            bundleC.putString("url", str3);
            h(bundleC, " (109)", j10);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packagename", y0VarM.f8795b);
        n.f13170b.send(102, bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putString("exception", str);
        bundle2.putString("url", str3);
        p(y0VarM, qVar, rVar, bundle2, str2, j10);
    }

    public final void u(String str, Bundle bundle, long j10, q qVar) {
        if (qVar != null) {
            qVar.l(this.f6739a);
            w(qVar);
            if (qVar.o()) {
                v5.i.i(this.f6739a, qVar, str);
            }
        }
        if (j10 > 0) {
            bundle.putLong(TypedValues.TransitionType.S_DURATION, (System.currentTimeMillis() - j10) / 1000);
        }
        d(bundle, null);
        c cVar = this.f6740b;
        if (cVar != null) {
            cVar.e(bundle, "download");
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public final javax.net.ssl.HttpsURLConnection v(java.lang.String r19, long r20, h5.r r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 571
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.DownloadWorker.v(java.lang.String, long, h5.r):javax.net.ssl.HttpsURLConnection");
    }

    public void w(q qVar) {
        qVar.getClass();
    }

    public void x(q qVar, int i10) {
        qVar.getClass();
    }

    public void h(Bundle bundle, String str, long j10) {
    }

    public void p(y0 y0Var, q qVar, r rVar, Bundle bundle, String str, long j10) {
    }
}

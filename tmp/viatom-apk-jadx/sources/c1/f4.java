package c1;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import com.uptodown.workers.DownloadApkWorker;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f4 implements g5.i {

    /* renamed from: a, reason: collision with root package name */
    public long f1218a;

    /* renamed from: b, reason: collision with root package name */
    public long f1219b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f1220c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1221d;

    public f4(g4 g4Var) {
        this.f1221d = g4Var;
        u1 u1Var = g4Var.f1149a;
        this.f1220c = new e4(this, u1Var, 0);
        u1Var.f1481k.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f1218a = jElapsedRealtime;
        this.f1219b = jElapsedRealtime;
    }

    public boolean a(long j10, boolean z9, boolean z10) {
        g4 g4Var = (g4) this.f1221d;
        g4Var.g();
        g4Var.h();
        u1 u1Var = g4Var.f1149a;
        boolean zD = u1Var.d();
        w0 w0Var = u1Var.f;
        if (zD) {
            h1 h1Var = u1Var.e;
            u1.k(h1Var);
            e1 e1Var = h1Var.f1253p;
            u1Var.f1481k.getClass();
            e1Var.b(System.currentTimeMillis());
        }
        long j11 = j10 - this.f1218a;
        if (!z9 && j11 < 1000) {
            u1.m(w0Var);
            w0Var.f1545n.c(Long.valueOf(j11), "Screen exposed for less than 1000 ms. Event not sent. time");
            return false;
        }
        if (!z10) {
            j11 = j10 - this.f1219b;
            this.f1219b = j10;
        }
        u1.m(w0Var);
        w0Var.f1545n.c(Long.valueOf(j11), "Recording user engagement, ms");
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j11);
        boolean z11 = !u1Var.f1478d.u();
        n3 n3Var = u1Var.f1482l;
        u1.l(n3Var);
        b5.Y(n3Var.m(z11), bundle, true);
        if (!z10) {
            c3 c3Var = u1Var.f1483m;
            u1.l(c3Var);
            c3Var.n("auto", "_e", bundle);
        }
        this.f1218a = j10;
        e4 e4Var = (e4) this.f1220c;
        e4Var.c();
        e4Var.b(((Long) f0.f1195r0.a(null)).longValue());
        return true;
    }

    @Override // g5.i
    public void f(int i10) {
        MainActivity mainActivity = (MainActivity) this.f1221d;
        mainActivity.f6644o0 = -1L;
        String string = mainActivity.getString(R.string.app_detail_not_available);
        string.getClass();
        mainActivity.C(string);
    }

    @Override // g5.i
    public void l(h5.h hVar) {
        MainActivity mainActivity = (MainActivity) this.f1221d;
        if (hVar.k() && hVar.j()) {
            h5.q qVar = new h5.q();
            qVar.h = hVar.f8566a;
            qVar.f8709n = hVar.f8567b;
            long j10 = this.f1218a;
            hVar.A = j10;
            qVar.e = this.f1219b;
            String str = (String) this.f1220c;
            hVar.G = str;
            qVar.f8701b = hVar.f8595w;
            qVar.f8708m = hVar.f8575l;
            h5.r rVar = new h5.r();
            rVar.f8722c = j10;
            rVar.g = str;
            rVar.e = 0L;
            qVar.f8716v.add(rVar);
            int iQ = qVar.q(mainActivity);
            float f = UptodownApp.E;
            if (!k4.c.o(mainActivity, "downloadApkWorker")) {
                WorkManager.Companion.getInstance(mainActivity).enqueue(((OneTimeWorkRequest.Builder) com.mbridge.msdk.dycreator.baseview.a.h(DownloadApkWorker.class, "downloadApkWorker")).setInputData(new Data.Builder().putInt("downloadId", iQ).build()).build());
            }
            mainActivity.m0(hVar);
        }
        mainActivity.f6644o0 = -1L;
    }

    public f4(long j10, long j11, String str, MainActivity mainActivity) {
        this.f1218a = j10;
        this.f1219b = j11;
        this.f1220c = str;
        this.f1221d = mainActivity;
    }
}

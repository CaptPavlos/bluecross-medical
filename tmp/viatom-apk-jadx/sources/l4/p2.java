package l4;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Base64;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModelKt;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.PublicProfileActivity;
import com.uptodown.activities.RepliesActivity;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.zip.Adler32;
import javax.net.ssl.SSLSocket;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p2 implements j4.g, g5.i, g5.n, r.b, u1.b, u1.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10714a;

    /* renamed from: b, reason: collision with root package name */
    public Object f10715b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f10716c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f10717d;

    public p2(Context context, s5.k kVar) {
        this.f10714a = 6;
        this.f10716c = context;
        this.f10717d = kVar;
        this.f10715b = new h5.k(523, "Games", 4);
    }

    @Override // g5.n
    public void B(int i10) {
        PublicProfileActivity publicProfileActivity = (PublicProfileActivity) this.f10715b;
        if (h5.c1.h(publicProfileActivity) == null) {
            String string = publicProfileActivity.getString(R.string.login_required_like_title);
            string.getClass();
            String string2 = publicProfileActivity.getString(R.string.login_required_like_msg);
            string2.getClass();
            a.a.q(publicProfileActivity, string, string2);
            return;
        }
        Object obj = ((y6) ((v5.l) ((v5.m) this.f10716c)).f13168a).f11030b.get(i10);
        obj.getClass();
        h5.t0 t0Var = (h5.t0) obj;
        int i11 = PublicProfileActivity.K;
        c7 c7VarO0 = publicProfileActivity.o0();
        c7VarO0.getClass();
        r7.w viewModelScope = ViewModelKt.getViewModelScope(c7VarO0);
        y7.e eVar = r7.i0.f12407a;
        r7.y.q(viewModelScope, y7.d.f14116a, null, new b9.p(t0Var, publicProfileActivity, c7VarO0, (w6.c) null, 12), 2);
    }

    @Override // u1.b
    public void H(Bundle bundle, String str) {
        CountDownLatch countDownLatch = (CountDownLatch) this.f10715b;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }

    @Override // g5.n
    public void K(int i10) {
        PublicProfileActivity publicProfileActivity = (PublicProfileActivity) this.f10715b;
        Object obj = ((y6) ((v5.l) ((v5.m) this.f10716c)).f13168a).f11030b.get(i10);
        obj.getClass();
        h5.t0 t0Var = (h5.t0) obj;
        String str = t0Var.f8742d;
        kotlin.jvm.internal.x xVar = (kotlin.jvm.internal.x) this.f10717d;
        h5.e1 e1Var = (h5.e1) xVar.f10138a;
        t0Var.f8740b = e1Var != null ? e1Var.f8512a : null;
        Intent intent = new Intent(publicProfileActivity, (Class<?>) RepliesActivity.class);
        intent.putExtra("review", t0Var);
        intent.putExtra("appName", t0Var.f8746l);
        intent.putExtra("appIconUrl", str);
        intent.putExtra("username", t0Var.f8741c);
        h5.e1 e1Var2 = (h5.e1) xVar.f10138a;
        intent.putExtra("userAvatarUrl", e1Var2 != null ? e1Var2.f8514c : null);
        float f = UptodownApp.E;
        publicProfileActivity.startActivity(intent, k4.c.a(publicProfileActivity));
    }

    @Override // g5.n
    public void O() {
        ((PublicProfileActivity) this.f10715b).l0();
    }

    public void a(Object obj, ByteArrayOutputStream byteArrayOutputStream) {
        HashMap map = (HashMap) this.f10716c;
        m2.f fVar = new m2.f(byteArrayOutputStream, map, (HashMap) this.f10717d, (j2.d) this.f10715b);
        j2.d dVar = (j2.d) map.get(obj.getClass());
        if (dVar != null) {
            dVar.a(obj, fVar);
            return;
        }
        throw new j2.b("No encoder for " + obj.getClass());
    }

    public Method b(Class cls) throws NoSuchMethodException, SecurityException {
        Method method;
        Class cls2;
        try {
            method = cls.getMethod((String) this.f10717d, (Class[]) this.f10715b);
        } catch (NoSuchMethodException unused) {
        }
        try {
            if ((method.getModifiers() & 1) == 0) {
                method = null;
            }
        } catch (NoSuchMethodException unused2) {
        }
        if (method == null || (cls2 = (Class) this.f10716c) == null || cls2.isAssignableFrom(method.getReturnType())) {
            return method;
        }
        return null;
    }

    public Object c(SSLSocket sSLSocket, Object... objArr) throws NoSuchMethodException, SecurityException {
        Method methodB = b(sSLSocket.getClass());
        if (methodB == null) {
            throw new AssertionError("Method " + ((String) this.f10717d) + " not supported for object " + sSLSocket);
        }
        try {
            return methodB.invoke(sSLSocket, objArr);
        } catch (IllegalAccessException e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + methodB);
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    public void d(SSLSocket sSLSocket, Object... objArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Method methodB = b(sSLSocket.getClass());
            if (methodB == null) {
                return;
            }
            try {
                methodB.invoke(sSLSocket, objArr);
            } catch (IllegalAccessException unused) {
            }
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    @Override // g5.i
    public void f(int i10) {
        StringBuilder sb = new StringBuilder();
        MainActivity mainActivity = (MainActivity) this.f10715b;
        sb.append(mainActivity.getResources().getString(R.string.app_name));
        sb.append(" v.");
        sb.append(((h5.y0) this.f10717d).f8797d);
        ((TextView) this.f10716c).setText(mainActivity.getResources().getString(R.string.msg_no_version_details, sb.toString()));
    }

    public void g(p.n nVar, int i10, boolean z9) {
        char c10;
        v.a aVar = (v.a) this.f10715b;
        Context context = (Context) this.f10716c;
        ComponentName componentName = new ComponentName(context, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName(C.UTF8_NAME)));
        p.i iVar = (p.i) nVar;
        adler32.update(iVar.f11855a.getBytes(Charset.forName(C.UTF8_NAME)));
        adler32.update(ByteBuffer.allocate(4).putInt(z.a.a(iVar.f11857c)).array());
        byte[] bArr = iVar.f11856b;
        if (bArr != null) {
            adler32.update(bArr);
        }
        int value = (int) adler32.getValue();
        if (!z9) {
            Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JobInfo next = it.next();
                int i11 = next.getExtras().getInt("attemptNumber");
                if (next.getId() == value) {
                    if (i11 >= i10) {
                        z1.t1.l(nVar, "JobInfoScheduler", "Upload for context %s is already scheduled. Returning...");
                        return;
                    }
                }
            }
        }
        SQLiteDatabase sQLiteDatabaseA = ((w.h) ((w.d) this.f10717d)).a();
        String str = iVar.f11855a;
        m.d dVar = iVar.f11857c;
        Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{str, String.valueOf(z.a.a(dVar))});
        try {
            Long lValueOf = cursorRawQuery.moveToNext() ? Long.valueOf(cursorRawQuery.getLong(0)) : 0L;
            cursorRawQuery.close();
            long jLongValue = lValueOf.longValue();
            JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
            builder.setMinimumLatency(aVar.a(dVar, jLongValue, i10));
            Set set = ((v.b) aVar.f13091b.get(dVar)).f13094c;
            if (set.contains(v.c.f13095a)) {
                builder.setRequiredNetworkType(2);
            } else {
                builder.setRequiredNetworkType(1);
            }
            if (set.contains(v.c.f13097c)) {
                builder.setRequiresCharging(true);
            }
            if (set.contains(v.c.f13096b)) {
                builder.setRequiresDeviceIdle(true);
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i10);
            persistableBundle.putString("backendName", str);
            persistableBundle.putInt("priority", z.a.a(dVar));
            byte[] bArr2 = iVar.f11856b;
            if (bArr2 != null) {
                c10 = 0;
                persistableBundle.putString("extras", Base64.encodeToString(bArr2, 0));
            } else {
                c10 = 0;
            }
            builder.setExtras(persistableBundle);
            Integer numValueOf = Integer.valueOf(value);
            Long lValueOf2 = Long.valueOf(aVar.a(dVar, jLongValue, i10));
            Integer numValueOf2 = Integer.valueOf(i10);
            Object[] objArr = new Object[5];
            objArr[c10] = nVar;
            objArr[1] = numValueOf;
            objArr[2] = lValueOf2;
            objArr[3] = lValueOf;
            objArr[4] = numValueOf2;
            String strC = z1.t1.C("JobInfoScheduler");
            if (Log.isLoggable(strC, 3)) {
                Log.d(strC, String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr));
            }
            jobScheduler.schedule(builder.build());
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }

    @Override // p6.a
    public Object get() {
        switch (this.f10714a) {
            case 7:
                return new p.p(new t3.h(17), new t3.h(16), (u.a) ((a3.z0) this.f10716c).get(), (v.h) ((c2.d) this.f10717d).get(), (w2.r) ((w2.r) this.f10715b).get());
            default:
                return new p2((Context) ((p6.a) this.f10716c).get(), (w.d) ((p6.a) this.f10717d).get(), (v.a) ((t3.h) this.f10715b).get(), 11);
        }
    }

    @Override // u1.a
    public void k(Bundle bundle) {
        synchronized (this.f10717d) {
            try {
                t1.d dVar = t1.d.f12753a;
                dVar.c("Logging event _ae to Firebase Analytics with params " + bundle);
                this.f10715b = new CountDownLatch(1);
                ((x4) this.f10716c).k(bundle);
                dVar.c("Awaiting app exception callback from Analytics...");
                try {
                    if (((CountDownLatch) this.f10715b).await(500, TimeUnit.MILLISECONDS)) {
                        dVar.c("App exception callback received from Analytics listener.");
                    } else {
                        dVar.d("Timeout exceeded while awaiting app exception callback from Analytics listener.", null);
                    }
                } catch (InterruptedException unused) {
                    Log.e("FirebaseCrashlytics", "Interrupted while awaiting app exception callback from Analytics listener.", null);
                }
                this.f10715b = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // g5.i
    public void l(h5.h hVar) {
        MainActivity mainActivity = (MainActivity) this.f10715b;
        TextView textView = (TextView) this.f10716c;
        String str = hVar.T;
        if (str != null && str.length() != 0) {
            textView.setText(hVar.T);
            return;
        }
        textView.setText(mainActivity.getResources().getString(R.string.msg_no_version_details, mainActivity.getResources().getString(R.string.app_name) + " v." + ((h5.y0) this.f10717d).f8797d));
    }

    @Override // g5.n
    public void o(int i10) {
        Object obj = ((y6) ((v5.l) ((v5.m) this.f10716c)).f13168a).f11030b.get(i10);
        obj.getClass();
        ((PublicProfileActivity) this.f10715b).Y(((h5.t0) obj).e);
    }

    @Override // j4.g
    public void onSuccess() {
        ((RelativeLayout) this.f10716c).setVisibility(0);
        ((LinearLayout) this.f10717d).setVisibility(0);
    }

    @Override // j4.g
    public void p(Exception exc) {
        MainActivity mainActivity = (MainActivity) this.f10715b;
        int dimension = (int) mainActivity.getResources().getDimension(R.dimen.margin_l);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(dimension, (int) mainActivity.getResources().getDimension(R.dimen.margin_xl), dimension, 0);
        RelativeLayout relativeLayout = (RelativeLayout) this.f10716c;
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setVisibility(0);
        ((LinearLayout) this.f10717d).setVisibility(0);
    }

    public /* synthetic */ p2(Object obj, Object obj2, Object obj3, int i10) {
        this.f10714a = i10;
        this.f10716c = obj;
        this.f10717d = obj2;
        this.f10715b = obj3;
    }

    public p2(x4 x4Var) {
        this.f10714a = 10;
        this.f10717d = new Object();
        this.f10716c = x4Var;
    }

    @Override // g5.n
    public void e(int i10) {
    }

    public p2(TextView textView, MainActivity mainActivity, h5.y0 y0Var) {
        this.f10714a = 1;
        this.f10716c = textView;
        this.f10715b = mainActivity;
        this.f10717d = y0Var;
    }
}

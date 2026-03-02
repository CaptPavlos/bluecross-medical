package androidx.browser.trusted;

import android.app.AlertDialog;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.net.nsd.NsdServiceInfo;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;
import androidx.room.TransactionExecutor;
import androidx.window.embedding.ExtensionEmbeddingBackend;
import androidx.window.layout.SidecarWindowBackend;
import androidx.window.layout.WindowLayoutInfo;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.greedy.TimeLimiter;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.utils.CancelWorkRunnable;
import c1.g1;
import c1.y2;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.firebase.messaging.FirebaseMessaging;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.R;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import e4.h;
import e5.v;
import h5.q;
import i4.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import l4.f5;
import l4.n5;
import m.d;
import o7.m;
import p.i;
import p4.k0;
import p4.m0;
import q1.n;
import q1.o;
import w1.l;
import w1.p;
import w1.r;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f455a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f456b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f457c;

    public /* synthetic */ c(p pVar, Exception exc) {
        this.f455a = 26;
        Map map = Collections.EMPTY_MAP;
        this.f456b = pVar;
        this.f457c = exc;
    }

    private final void a() {
        n nVar = (n) this.f456b;
        q2.b bVar = (q2.b) this.f457c;
        synchronized (nVar) {
            try {
                if (nVar.f12245b == null) {
                    nVar.f12244a.add(bVar);
                } else {
                    nVar.f12245b.add(bVar.get());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        q2.a aVar;
        String str;
        int i10 = 1;
        switch (this.f455a) {
            case 0:
                ((TrustedWebActivityServiceConnectionPool) this.f456b).lambda$connect$0((Uri) this.f457c);
                return;
            case 1:
                ((ViewTransition) this.f456b).lambda$applyTransition$0((View[]) this.f457c);
                return;
            case 2:
                ((ResourcesCompat.FontCallback) this.f456b).lambda$callbackSuccessAsync$0((Typeface) this.f457c);
                return;
            case 3:
                TransactionExecutor.execute$lambda$1$lambda$0((Runnable) this.f456b, (TransactionExecutor) this.f457c);
                return;
            case 4:
                ExtensionEmbeddingBackend.SplitListenerWrapper.m230accept$lambda1((ExtensionEmbeddingBackend.SplitListenerWrapper) this.f456b, (ArrayList) this.f457c);
                return;
            case 5:
                SidecarWindowBackend.WindowLayoutChangeCallbackWrapper.m231accept$lambda0((SidecarWindowBackend.WindowLayoutChangeCallbackWrapper) this.f456b, (WindowLayoutInfo) this.f457c);
                return;
            case 6:
                TimeLimiter.track$lambda$0((TimeLimiter) this.f456b, (StartStopToken) this.f457c);
                return;
            case 7:
                ConstraintTracker._set_state_$lambda$4$lambda$3((List) this.f456b, (ConstraintTracker) this.f457c);
                return;
            case 8:
                CancelWorkRunnable.forId$lambda$1$lambda$0((WorkManagerImpl) this.f456b, (UUID) this.f457c);
                return;
            case 9:
                CancelWorkRunnable.forAll$lambda$7$lambda$6((WorkDatabase) this.f456b, (WorkManagerImpl) this.f457c);
                return;
            case 10:
                d2.c cVar = (d2.c) this.f456b;
                CountDownLatch countDownLatch = (CountDownLatch) this.f457c;
                try {
                    p.p.a().f11872d.a(((i) cVar.h.f).a(d.f11156c), 1);
                } catch (Exception unused) {
                }
                countDownLatch.countDown();
                return;
            case 11:
                h hVar = (h) this.f456b;
                String str2 = (String) this.f457c;
                f fVar = hVar.f7663a;
                Iterator<T> it = fVar.getListeners().iterator();
                while (it.hasNext()) {
                    ((f4.a) it.next()).f(fVar.getInstance(), str2);
                }
                return;
            case 12:
                h hVar2 = (h) this.f456b;
                e4.c cVar2 = (e4.c) this.f457c;
                f fVar2 = hVar2.f7663a;
                Iterator<T> it2 = fVar2.getListeners().iterator();
                while (it2.hasNext()) {
                    ((f4.a) it2.next()).b(fVar2.getInstance(), cVar2);
                }
                return;
            case 13:
                h hVar3 = (h) this.f456b;
                e4.d dVar = (e4.d) this.f457c;
                f fVar3 = hVar3.f7663a;
                Iterator<T> it3 = fVar3.getListeners().iterator();
                while (it3.hasNext()) {
                    ((f4.a) it3.next()).d(fVar3.getInstance(), dVar);
                }
                return;
            case 14:
                FragmentStrictMode.m45handlePolicyViolation$lambda0((FragmentStrictMode.Policy) this.f456b, (Violation) this.f457c);
                return;
            case 15:
                FragmentStrictMode.m46handlePolicyViolation$lambda1((String) this.f456b, (Violation) this.f457c);
                return;
            case 16:
                m0 m0Var = (m0) this.f456b;
                NsdServiceInfo nsdServiceInfo = (NsdServiceInfo) this.f457c;
                StringBuilder sb = new StringBuilder();
                sb.append(m0Var.getString(R.string.msg_connected_to_service));
                String serviceName = nsdServiceInfo.getServiceName();
                serviceName.getClass();
                sb.append(serviceName.substring(0, m.k0(serviceName, "_d:_", 0, false, 6)));
                m0Var.C(sb.toString());
                return;
            case 17:
                m0 m0Var2 = (m0) this.f456b;
                u4.c cVar3 = (u4.c) this.f457c;
                m0Var2.G();
                View viewInflate = View.inflate(m0Var2, R.layout.dialog_confirm_receive, null);
                View viewFindViewById = viewInflate.findViewById(R.id.tv_msg_confirm);
                viewFindViewById.getClass();
                TextView textView = (TextView) viewFindViewById;
                textView.setTypeface(o4.b.f11720s);
                String string = m0Var2.getString(R.string.msg_confirm_receive_file);
                string.getClass();
                textView.setText(String.format(string, Arrays.copyOf(new Object[]{cVar3.f, cVar3.f12899b}, 2)));
                View viewFindViewById2 = viewInflate.findViewById(R.id.tv_confirm_receive);
                viewFindViewById2.getClass();
                TextView textView2 = (TextView) viewFindViewById2;
                textView2.setTypeface(o4.b.f11720s);
                textView2.setOnClickListener(new f5(19, m0Var2, cVar3));
                View viewFindViewById3 = viewInflate.findViewById(R.id.tv_cancel);
                viewFindViewById3.getClass();
                TextView textView3 = (TextView) viewFindViewById3;
                textView3.setTypeface(o4.b.f11719r);
                textView3.setOnClickListener(new k0(m0Var2, i10));
                m0Var2.I(viewInflate);
                return;
            case 18:
                o oVar = (o) this.f456b;
                q2.b bVar = (q2.b) this.f457c;
                if (oVar.f12249b != o.f12247d) {
                    androidx.window.layout.c.g("provide() can be called only once.");
                    return;
                }
                synchronized (oVar) {
                    aVar = oVar.f12248a;
                    oVar.f12248a = null;
                    oVar.f12249b = bVar;
                }
                aVar.b(bVar);
                return;
            case 19:
                a();
                return;
            case 20:
                r1.a aVar2 = (r1.a) this.f456b;
                Runnable runnable = (Runnable) this.f457c;
                Process.setThreadPriority(aVar2.f12316c);
                StrictMode.ThreadPolicy threadPolicy = aVar2.f12317d;
                if (threadPolicy != null) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
                runnable.run();
                return;
            case 21:
                Callable callable = (Callable) this.f456b;
                r1.h hVar4 = (r1.h) ((n5) this.f457c).f10654b;
                try {
                    hVar4.set(callable.call());
                    return;
                } catch (Exception e) {
                    hVar4.setException(e);
                    return;
                }
            case 22:
                TvAppDetailFragment tvAppDetailFragment = (TvAppDetailFragment) this.f456b;
                v vVar = (v) this.f457c;
                int i11 = vVar.f7882b;
                q qVar = (q) vVar.f7884d;
                h5.h hVar5 = tvAppDetailFragment.f6693a;
                if (hVar5 == null || qVar == null || (str = qVar.f8701b) == null || !str.equalsIgnoreCase(hVar5.f8595w)) {
                    return;
                }
                if (i11 == 200) {
                    tvAppDetailFragment.p(qVar);
                    return;
                }
                if (i11 == 201) {
                    tvAppDetailFragment.p(qVar);
                    return;
                }
                if (i11 == 205) {
                    tvAppDetailFragment.p(qVar);
                    return;
                }
                if (i11 == 206) {
                    tvAppDetailFragment.p(qVar);
                    return;
                }
                if (i11 == 202) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(tvAppDetailFragment.getContext());
                    builder.setMessage(tvAppDetailFragment.getString(R.string.descarga_completada));
                    builder.setTitle(qVar.f8709n);
                    builder.setPositiveButton(R.string.option_button_install, new s5.c(qVar, tvAppDetailFragment));
                    builder.setNegativeButton(android.R.string.cancel, new r5.c(3));
                    builder.setCancelable(true);
                    AlertDialog alertDialogCreate = builder.create();
                    if (tvAppDetailFragment.getActivity() != null && !tvAppDetailFragment.requireActivity().isFinishing()) {
                        alertDialogCreate.show();
                    }
                }
                tvAppDetailFragment.u();
                return;
            case 23:
                JobInfoSchedulerService jobInfoSchedulerService = (JobInfoSchedulerService) this.f456b;
                JobParameters jobParameters = (JobParameters) this.f457c;
                int i12 = JobInfoSchedulerService.f1822a;
                jobInfoSchedulerService.jobFinished(jobParameters, false);
                return;
            case 24:
                ((l) this.f456b).c((String) this.f457c, Boolean.FALSE);
                return;
            case 25:
                p pVar = (p) this.f456b;
                String str3 = (String) this.f457c;
                l lVar = pVar.g;
                lVar.getClass();
                try {
                    ((g1) lVar.f13354d.e).l("operation", str3);
                    return;
                } catch (IllegalArgumentException e3) {
                    Context context = lVar.f13351a;
                    if (context != null && (context.getApplicationInfo().flags & 2) != 0) {
                        throw e3;
                    }
                    Log.e("FirebaseCrashlytics", "Attempting to set custom attribute with null key, ignoring.", null);
                    return;
                }
            case 26:
                p pVar2 = (p) this.f456b;
                Exception exc = (Exception) this.f457c;
                Map map = Collections.EMPTY_MAP;
                l lVar2 = pVar2.g;
                Thread threadCurrentThread = Thread.currentThread();
                lVar2.getClass();
                long jCurrentTimeMillis = System.currentTimeMillis();
                r rVar = lVar2.f13360n;
                if (rVar == null || !rVar.e.get()) {
                    long j10 = jCurrentTimeMillis / 1000;
                    String strE = lVar2.e();
                    if (strE == null) {
                        Log.w("FirebaseCrashlytics", "Tried to write a non-fatal exception while no session was open.", null);
                        return;
                    }
                    y1.c cVar4 = new y1.c(strE, j10, map);
                    c2.d dVar2 = lVar2.f13359m;
                    dVar2.getClass();
                    String strConcat = "Persisting non-fatal event for session ".concat(strE);
                    if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                        Log.v("FirebaseCrashlytics", strConcat, null);
                    }
                    dVar2.j(exc, threadCurrentThread, CampaignEx.JSON_NATIVE_VIDEO_ERROR, cVar4, false);
                    return;
                }
                return;
            case 27:
                ((y2) this.f456b).a((Intent) this.f457c);
                return;
            case 28:
                FirebaseMessaging firebaseMessaging = (FirebaseMessaging) this.f456b;
                h1.i iVar = (h1.i) this.f457c;
                try {
                    iVar.a(firebaseMessaging.a());
                    return;
                } catch (Exception e7) {
                    iVar.f8418a.k(e7);
                    return;
                }
            default:
                w2.m mVar = (w2.m) this.f456b;
                h1.i iVar2 = (h1.i) this.f457c;
                try {
                    iVar2.a(mVar.a());
                    return;
                } catch (Exception e10) {
                    iVar2.f8418a.k(e10);
                    return;
                }
        }
    }

    public /* synthetic */ c(int i10, Object obj, Object obj2) {
        this.f455a = i10;
        this.f456b = obj;
        this.f457c = obj2;
    }
}

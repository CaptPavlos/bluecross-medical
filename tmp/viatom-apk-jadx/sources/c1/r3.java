package c1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;
import j$.util.Objects;
import java.lang.ref.SoftReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r3 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1432a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Parcelable f1433b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f1434c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1435d;
    public final /* synthetic */ Object e;

    public r3(x3 x3Var, d5 d5Var, boolean z9, e eVar) {
        this.f1432a = 2;
        this.f1433b = d5Var;
        this.f1434c = z9;
        this.e = eVar;
        Objects.requireNonNull(x3Var);
        this.f1435d = x3Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Executor executor;
        int iA;
        switch (this.f1432a) {
            case 0:
                x3 x3Var = (x3) this.f1435d;
                i0 i0Var = x3Var.f1572d;
                if (i0Var == null) {
                    w0 w0Var = x3Var.f1149a.f;
                    u1.m(w0Var);
                    w0Var.f.b("Discarding data. Failed to set user property");
                    return;
                } else {
                    x3Var.y(i0Var, this.f1434c ? null : (y4) this.e, (d5) this.f1433b);
                    x3Var.t();
                    return;
                }
            case 1:
                x3 x3Var2 = (x3) this.f1435d;
                i0 i0Var2 = x3Var2.f1572d;
                if (i0Var2 == null) {
                    w0 w0Var2 = x3Var2.f1149a.f;
                    u1.m(w0Var2);
                    w0Var2.f.b("Discarding data. Failed to send event to service");
                    return;
                } else {
                    x3Var2.y(i0Var2, this.f1434c ? null : (v) this.e, (d5) this.f1433b);
                    x3Var2.t();
                    return;
                }
            case 2:
                x3 x3Var3 = (x3) this.f1435d;
                i0 i0Var3 = x3Var3.f1572d;
                if (i0Var3 == null) {
                    w0 w0Var3 = x3Var3.f1149a.f;
                    u1.m(w0Var3);
                    w0Var3.f.b("Discarding data. Failed to send conditional user property to service");
                    return;
                } else {
                    x3Var3.y(i0Var3, this.f1434c ? null : (e) this.e, (d5) this.f1433b);
                    x3Var3.t();
                    return;
                }
            default:
                Intent intent = (Intent) this.f1433b;
                Context context = (Context) this.e;
                boolean z9 = this.f1434c;
                BroadcastReceiver.PendingResult pendingResult = (BroadcastReceiver.PendingResult) this.f1435d;
                try {
                    Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
                    Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
                    if (intent2 != null) {
                        iA = FirebaseInstanceIdReceiver.a(intent2);
                    } else {
                        int iIntValue = 500;
                        if (intent.getExtras() != null) {
                            e0.a aVar = new e0.a(intent);
                            Executor executorUnconfigurableExecutorService = null;
                            CountDownLatch countDownLatch = new CountDownLatch(1);
                            synchronized (FirebaseInstanceIdReceiver.class) {
                                try {
                                    SoftReference softReference = FirebaseInstanceIdReceiver.f2429b;
                                    if (softReference != null) {
                                        executorUnconfigurableExecutorService = (Executor) softReference.get();
                                    }
                                    if (executorUnconfigurableExecutorService == null) {
                                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new o0.a("pscm-ack-executor"));
                                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                                        executorUnconfigurableExecutorService = Executors.unconfigurableExecutorService(threadPoolExecutor);
                                        FirebaseInstanceIdReceiver.f2429b = new SoftReference(executorUnconfigurableExecutorService);
                                    }
                                    executor = executorUnconfigurableExecutorService;
                                } finally {
                                }
                            }
                            executor.execute(new y1(context, aVar, countDownLatch, 10, false));
                            try {
                                iIntValue = ((Integer) r0.f.i(new w2.j(context).b(intent))).intValue();
                            } catch (InterruptedException | ExecutionException e) {
                                Log.e("FirebaseMessaging", "Failed to send message to service.", e);
                            }
                            try {
                                if (!countDownLatch.await(1000L, TimeUnit.MILLISECONDS)) {
                                    Log.w("CloudMessagingReceiver", "Message ack timed out");
                                }
                            } catch (InterruptedException e3) {
                                Log.w("CloudMessagingReceiver", "Message ack failed: ".concat(e3.toString()));
                            }
                        }
                        iA = iIntValue;
                    }
                    if (z9 && pendingResult != null) {
                        pendingResult.setResultCode(iA);
                    }
                    if (pendingResult != null) {
                        pendingResult.finish();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    if (pendingResult != null) {
                        pendingResult.finish();
                    }
                    throw th;
                }
        }
    }

    public /* synthetic */ r3(FirebaseInstanceIdReceiver firebaseInstanceIdReceiver, Intent intent, Context context, boolean z9, BroadcastReceiver.PendingResult pendingResult) {
        this.f1432a = 3;
        this.f1433b = intent;
        this.e = context;
        this.f1434c = z9;
        this.f1435d = pendingResult;
    }

    public /* synthetic */ r3(x3 x3Var, d5 d5Var, boolean z9, j0.a aVar, int i10) {
        this.f1432a = i10;
        this.f1433b = d5Var;
        this.f1434c = z9;
        this.e = aVar;
        this.f1435d = x3Var;
    }
}

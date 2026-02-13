package com.uptodown.workers;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class GetRemoteInstallWorker extends CoroutineWorker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetRemoteInstallWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object doWork(w6.c r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof a6.i
            if (r0 == 0) goto L13
            r0 = r6
            a6.i r0 = (a6.i) r0
            int r1 = r0.f262c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f262c = r1
            goto L18
        L13:
            a6.i r0 = new a6.i
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f260a
            int r1 = r0.f262c
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2e
            if (r1 != r3) goto L28
            s6.a.e(r6)     // Catch: java.lang.Exception -> L26
            goto L52
        L26:
            r6 = move-exception
            goto L5a
        L28:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r6)
            return r2
        L2e:
            s6.a.e(r6)
            android.content.Context r6 = r5.getApplicationContext()     // Catch: java.lang.Exception -> L26
            r6.getClass()     // Catch: java.lang.Exception -> L26
            r0.f262c = r3     // Catch: java.lang.Exception -> L26
            y7.e r1 = r7.i0.f12407a     // Catch: java.lang.Exception -> L26
            y7.d r1 = y7.d.f14116a     // Catch: java.lang.Exception -> L26
            c5.b r3 = new c5.b     // Catch: java.lang.Exception -> L26
            r4 = 0
            r3.<init>(r4, r6, r2)     // Catch: java.lang.Exception -> L26
            java.lang.Object r6 = r7.y.z(r3, r1, r0)     // Catch: java.lang.Exception -> L26
            x6.a r0 = x6.a.f13718a
            if (r6 != r0) goto L4d
            goto L4f
        L4d:
            s6.w r6 = s6.w.f12711a     // Catch: java.lang.Exception -> L26
        L4f:
            if (r6 != r0) goto L52
            return r0
        L52:
            androidx.work.ListenableWorker$Result r6 = androidx.work.ListenableWorker.Result.success()     // Catch: java.lang.Exception -> L26
            r6.getClass()     // Catch: java.lang.Exception -> L26
            return r6
        L5a:
            r6.printStackTrace()
            t1.c r0 = new t1.c
            android.content.Context r1 = r5.getApplicationContext()
            r2 = 4
            r0.<init>(r1, r2)
            java.lang.String r1 = "GetRemoteInstallWorker"
            r0.f(r1, r6)
            androidx.work.ListenableWorker$Result r6 = androidx.work.ListenableWorker.Result.success()
            r6.getClass()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.GetRemoteInstallWorker.doWork(w6.c):java.lang.Object");
    }
}

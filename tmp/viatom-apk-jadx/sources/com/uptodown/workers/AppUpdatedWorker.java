package com.uptodown.workers;

import android.app.Activity;
import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import o4.b;
import r0.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class AppUpdatedWorker extends CoroutineWorker {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6736a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6737b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppUpdatedWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.f6736a = context;
        String string = workerParameters.getInputData().getString("packagename");
        string.getClass();
        this.f6737b = string;
        Activity activity = b.g;
        this.f6736a = f.h(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object doWork(w6.c r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof a6.d
            if (r0 == 0) goto L13
            r0 = r5
            a6.d r0 = (a6.d) r0
            int r1 = r0.f252c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f252c = r1
            goto L18
        L13:
            a6.d r0 = new a6.d
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f250a
            int r1 = r0.f252c
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2c
            if (r1 != r3) goto L26
            s6.a.e(r5)
            goto L43
        L26:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r5)
            return r2
        L2c:
            s6.a.e(r5)
            y7.e r5 = r7.i0.f12407a
            y7.d r5 = y7.d.f14116a
            a6.e r1 = new a6.e
            r1.<init>(r4, r2)
            r0.f252c = r3
            java.lang.Object r5 = r7.y.z(r1, r5, r0)
            x6.a r0 = x6.a.f13718a
            if (r5 != r0) goto L43
            return r0
        L43:
            r5.getClass()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.AppUpdatedWorker.doWork(w6.c):java.lang.Object");
    }
}

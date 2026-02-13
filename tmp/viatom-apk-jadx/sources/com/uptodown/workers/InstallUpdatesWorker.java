package com.uptodown.workers;

import android.app.Activity;
import android.content.Context;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import o4.b;
import r0.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class InstallUpdatesWorker extends Worker {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6746a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstallUpdatesWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.f6746a = context;
        Activity activity = b.g;
        this.f6746a = f.h(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x024b  */
    @Override // androidx.work.Worker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.work.ListenableWorker.Result doWork() throws android.content.res.Resources.NotFoundException, java.io.IOException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.InstallUpdatesWorker.doWork():androidx.work.ListenableWorker$Result");
    }
}

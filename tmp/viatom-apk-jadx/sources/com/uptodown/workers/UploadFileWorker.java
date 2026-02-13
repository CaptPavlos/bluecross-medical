package com.uptodown.workers;

import android.app.Activity;
import android.content.Context;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import o4.b;
import r0.f;
import t1.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class UploadFileWorker extends Worker {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6755a;

    /* renamed from: b, reason: collision with root package name */
    public final c f6756b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadFileWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.f6755a = context;
        this.f6756b = new c(context, 4);
        Activity activity = b.g;
        this.f6755a = f.h(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x016e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c4  */
    @Override // androidx.work.Worker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.work.ListenableWorker.Result doWork() throws java.security.NoSuchAlgorithmException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1002
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.UploadFileWorker.doWork():androidx.work.ListenableWorker$Result");
    }
}

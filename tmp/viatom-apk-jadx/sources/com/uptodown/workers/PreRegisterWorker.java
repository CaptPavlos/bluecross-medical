package com.uptodown.workers;

import a6.p;
import android.app.Activity;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import o4.b;
import r0.f;
import r7.i0;
import r7.y;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class PreRegisterWorker extends Worker {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6748a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreRegisterWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.f6748a = context;
        Activity activity = b.g;
        this.f6748a = f.h(context);
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result doWork() {
        ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
        resultSuccess.getClass();
        try {
            e eVar = i0.f12407a;
            y.q(y.a(d.f14116a), null, null, new p(this, null), 3);
            return resultSuccess;
        } catch (Exception e) {
            e.printStackTrace();
            ListenableWorker.Result resultFailure = ListenableWorker.Result.failure();
            resultFailure.getClass();
            return resultFailure;
        }
    }
}

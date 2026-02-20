package com.google.firebase.messaging;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.work.impl.c;
import e0.b;
import h1.i;
import h1.p;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import l4.x4;
import o0.a;
import w2.a0;
import w2.q;
import w2.r;
import w2.z;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class FirebaseMessagingService extends Service {
    public static final ArrayDeque g = new ArrayDeque(10);

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f2438a;

    /* renamed from: b, reason: collision with root package name */
    public a0 f2439b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f2440c;

    /* renamed from: d, reason: collision with root package name */
    public int f2441d;
    public int e;
    public b f;

    public FirebaseMessagingService() {
        a aVar = new a("Firebase-Messaging-Intent-Handle");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), aVar);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f2438a = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.f2440c = new Object();
        this.e = 0;
    }

    public final void a(Intent intent) {
        if (intent != null) {
            z.c(intent);
        }
        synchronized (this.f2440c) {
            try {
                int i10 = this.e - 1;
                this.e = i10;
                if (i10 == 0) {
                    stopSelfResult(this.f2441d);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(android.content.Intent r11) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingService.b(android.content.Intent):void");
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        try {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "Service received bind request");
            }
            if (this.f2439b == null) {
                this.f2439b = new a0(new x4(this, 25));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f2439b;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f2438a.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i10, int i11) {
        synchronized (this.f2440c) {
            this.f2441d = i11;
            this.e++;
        }
        Intent intent2 = (Intent) ((ArrayDeque) r.y().e).poll();
        if (intent2 == null) {
            a(intent);
            return 2;
        }
        i iVar = new i();
        this.f2438a.execute(new c(this, intent2, iVar, 5));
        p pVar = iVar.f8418a;
        if (pVar.h()) {
            a(intent);
            return 2;
        }
        pVar.a(new androidx.arch.core.executor.a(2), new androidx.privacysandbox.ads.adservices.java.internal.a(8, this, intent));
        return 3;
    }

    public void c(q qVar) {
    }

    public void d(String str) {
    }
}

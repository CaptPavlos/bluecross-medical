package com.mbridge.msdk.foundation.same.report.b;

import android.annotation.TargetApi;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class b extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f3779a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f3780b;

    /* renamed from: c, reason: collision with root package name */
    private volatile a f3781c;

    /* renamed from: d, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.report.b.a f3782d;
    private int e;

    private b() {
        super("AnrMonitor-Thread");
        this.f3780b = new Handler(Looper.getMainLooper());
        this.e = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS;
    }

    public static b a() {
        if (f3779a == null) {
            synchronized (b.class) {
                try {
                    if (f3779a == null) {
                        f3779a = new b();
                    }
                } finally {
                }
            }
        }
        return f3779a;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    @TargetApi(16)
    public void run() throws InterruptedException, SecurityException, IllegalArgumentException {
        Process.setThreadPriority(10);
        while (true) {
            if (isInterrupted() || !(this.f3781c == null || this.f3781c.f3785c)) {
                try {
                    Thread.sleep(this.e);
                } catch (Exception unused) {
                }
            } else {
                synchronized (this) {
                    try {
                        if (this.f3781c == null) {
                            this.f3781c = new a();
                        }
                        this.f3781c.b();
                        long jUptimeMillis = this.e;
                        long jUptimeMillis2 = SystemClock.uptimeMillis();
                        while (jUptimeMillis > 0) {
                            try {
                                wait(jUptimeMillis);
                            } catch (InterruptedException e) {
                                Log.w("AnrMonitor", e.toString());
                            }
                            jUptimeMillis = this.e - (SystemClock.uptimeMillis() - jUptimeMillis2);
                        }
                        if (!this.f3781c.a()) {
                            com.mbridge.msdk.foundation.same.report.b.a aVar = this.f3782d;
                            if (aVar != null) {
                                aVar.a();
                            }
                        } else if (!Debug.isDebuggerConnected() && !Debug.waitingForDebugger() && this.f3782d != null) {
                            StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
                            this.f3782d.a(c.a(stackTrace), stackTrace);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private long f3784b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f3785c;

        /* renamed from: d, reason: collision with root package name */
        private long f3786d;

        private a() {
            this.f3784b = SystemClock.uptimeMillis();
        }

        public final boolean a() {
            return !this.f3785c || this.f3784b - this.f3786d >= ((long) b.this.e);
        }

        public final void b() {
            this.f3785c = false;
            this.f3786d = SystemClock.uptimeMillis();
            b.this.f3780b.postAtFrontOfQueue(this);
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (b.this) {
                this.f3785c = true;
                this.f3784b = SystemClock.uptimeMillis();
            }
        }
    }

    public final b a(int i10, com.mbridge.msdk.foundation.same.report.b.a aVar) {
        this.e = i10;
        this.f3782d = aVar;
        return this;
    }
}

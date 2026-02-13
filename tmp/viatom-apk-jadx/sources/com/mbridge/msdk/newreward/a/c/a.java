package com.mbridge.msdk.newreward.a.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f4585a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, c> f4586b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f4587c;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.a.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0041a {
        void a(String str, long j10);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final b f4591a;

        /* renamed from: b, reason: collision with root package name */
        private final InterfaceC0041a f4592b;

        public c(b bVar, InterfaceC0041a interfaceC0041a) {
            this.f4591a = bVar;
            this.f4592b = interfaceC0041a;
        }

        @Override // java.lang.Runnable
        public final void run() {
            InterfaceC0041a interfaceC0041a;
            if (MBridgeConstans.DEBUG) {
                af.a("MBridgeTimer", "TimerTask run taskID: " + this.f4591a.f4588a + " isStop: " + this.f4591a.f4590c);
            }
            if (this.f4591a.f4590c || (interfaceC0041a = this.f4592b) == null) {
                return;
            }
            try {
                interfaceC0041a.a(this.f4591a.f4588a, this.f4591a.f4589b);
            } catch (Exception unused) {
            }
        }
    }

    public a() {
        HandlerThread handlerThread = new HandlerThread("MBridgeTimerThread");
        handlerThread.start();
        this.f4587c = new Handler(handlerThread.getLooper());
        this.f4586b = new HashMap();
    }

    public final void a(String str, long j10, InterfaceC0041a interfaceC0041a) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (MBridgeConstans.DEBUG) {
            af.a("MBridgeTimer", "startTimer taskID: " + str + " timeout: " + j10);
        }
        if (this.f4586b.containsKey(str)) {
            return;
        }
        c cVar = new c(new b(str, j10), interfaceC0041a);
        this.f4586b.put(str, cVar);
        this.f4587c.postDelayed(cVar, j10);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f4588a;

        /* renamed from: b, reason: collision with root package name */
        private final long f4589b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f4590c;

        public b(String str, long j10) {
            this.f4588a = str;
            this.f4589b = j10;
        }
    }

    public static a a() {
        if (f4585a == null) {
            synchronized (a.class) {
                try {
                    if (f4585a == null) {
                        f4585a = new a();
                    }
                } finally {
                }
            }
        }
        return f4585a;
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c cVarRemove = this.f4586b.remove(str);
        if (MBridgeConstans.DEBUG) {
            androidx.constraintlayout.core.widgets.analyzer.a.E("stopTimer taskID: ", str, "MBridgeTimer");
        }
        if (cVarRemove != null) {
            cVarRemove.f4591a.f4590c = true;
            this.f4587c.removeCallbacks(cVarRemove);
        }
    }
}

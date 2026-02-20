package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.MBridgeConstans;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private Runnable f4031a;

    /* renamed from: b, reason: collision with root package name */
    private Runnable f4032b;

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        Runnable runnable = this.f4032b;
        this.f4031a = runnable;
        this.f4032b = null;
        if (runnable != null) {
            r.a().execute(this.f4031a);
        }
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        try {
            if (this.f4031a == null) {
                this.f4031a = a(runnable);
                r.a().execute(this.f4031a);
            } else if (this.f4032b == null) {
                this.f4032b = a(runnable);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private Runnable a(final Runnable runnable) {
        return new Runnable() { // from class: com.mbridge.msdk.foundation.tools.t.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    try {
                        runnable.run();
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("LimitExecutor", e.getMessage());
                        }
                    }
                } finally {
                    t.this.a();
                }
            }
        };
    }
}

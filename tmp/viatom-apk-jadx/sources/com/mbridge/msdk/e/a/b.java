package com.mbridge.msdk.e.a;

import android.os.CountDownTimer;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.e.a.a f3301a;

    /* renamed from: b, reason: collision with root package name */
    private long f3302b;

    /* renamed from: c, reason: collision with root package name */
    private a f3303c;

    /* renamed from: d, reason: collision with root package name */
    private long f3304d = 0;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.e.a.a f3305a;

        public a(long j10, long j11) {
            super(j10, j11);
        }

        public final void a(com.mbridge.msdk.e.a.a aVar) {
            this.f3305a = aVar;
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            com.mbridge.msdk.e.a.a aVar = this.f3305a;
            if (aVar != null) {
                aVar.onFinish();
            }
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j10) {
            com.mbridge.msdk.e.a.a aVar = this.f3305a;
            if (aVar != null) {
                aVar.onTick(j10);
            }
        }
    }

    public final void a() {
        a aVar = this.f3303c;
        if (aVar != null) {
            aVar.cancel();
            this.f3303c = null;
        }
    }

    public final void b() {
        a aVar = this.f3303c;
        if (aVar == null) {
            if (aVar != null) {
                aVar.cancel();
                this.f3303c = null;
            }
            if (this.f3302b <= 0) {
                this.f3302b = this.f3304d + 1000;
            }
            a aVar2 = new a(this.f3304d, this.f3302b);
            this.f3303c = aVar2;
            aVar2.a(this.f3301a);
        }
        this.f3303c.start();
    }

    public final b a(long j10) {
        if (j10 < 0) {
            j10 = 1000;
        }
        this.f3302b = j10;
        return this;
    }

    public final b a(com.mbridge.msdk.e.a.a aVar) {
        this.f3301a = aVar;
        return this;
    }

    public final b b(long j10) {
        this.f3304d = j10;
        return this;
    }
}

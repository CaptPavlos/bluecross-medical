package com.mbridge.msdk.video.dynview.i.c;

import android.os.CountDownTimer;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private long f5762a = 0;

    /* renamed from: b, reason: collision with root package name */
    private long f5763b;

    /* renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.video.dynview.i.c.a f5764c;

    /* renamed from: d, reason: collision with root package name */
    private a f5765d;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.video.dynview.i.c.a f5766a;

        public a(long j10, long j11) {
            super(j10, j11);
        }

        public final void a(com.mbridge.msdk.video.dynview.i.c.a aVar) {
            this.f5766a = aVar;
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            com.mbridge.msdk.video.dynview.i.c.a aVar = this.f5766a;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j10) {
            com.mbridge.msdk.video.dynview.i.c.a aVar = this.f5766a;
            if (aVar != null) {
                aVar.a(j10);
            }
        }
    }

    private void c() {
        a aVar = this.f5765d;
        if (aVar != null) {
            aVar.cancel();
            this.f5765d = null;
        }
        if (this.f5763b <= 0) {
            this.f5763b = this.f5762a + 1000;
        }
        a aVar2 = new a(this.f5762a, this.f5763b);
        this.f5765d = aVar2;
        aVar2.a(this.f5764c);
    }

    public final void a(long j10, com.mbridge.msdk.video.dynview.i.c.a aVar) {
        this.f5762a = j10;
        this.f5764c = aVar;
        c();
        a aVar2 = this.f5765d;
        if (aVar2 != null) {
            aVar2.start();
        }
    }

    public final void b() {
        a aVar = this.f5765d;
        if (aVar != null) {
            aVar.cancel();
            this.f5765d = null;
        }
    }

    public final b b(long j10) {
        this.f5762a = j10;
        return this;
    }

    public final b a(com.mbridge.msdk.video.dynview.i.c.a aVar) {
        this.f5764c = aVar;
        return this;
    }

    public final void a() {
        if (this.f5765d == null) {
            c();
        }
        this.f5765d.start();
    }

    public final b a(long j10) {
        if (j10 < 0) {
            j10 = 1000;
        }
        this.f5763b = j10;
        return this;
    }
}

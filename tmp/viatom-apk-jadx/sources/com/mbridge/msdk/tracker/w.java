package com.mbridge.msdk.tracker;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final int f5524a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5525b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5526c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5527d;
    public final int e;
    public final int f;
    public final o g;
    public final d h;

    /* renamed from: i, reason: collision with root package name */
    public final v f5528i;

    /* renamed from: j, reason: collision with root package name */
    public final f f5529j;

    private w(a aVar) {
        this.f5524a = aVar.f5530a;
        this.f5525b = aVar.f5531b;
        this.f5526c = aVar.f5532c;
        this.f5527d = aVar.e;
        this.e = aVar.f;
        this.f = aVar.g;
        this.g = aVar.f5533d;
        this.h = aVar.h;
        this.f5528i = aVar.f5534i;
        this.f5529j = aVar.f5535j;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class a {

        /* renamed from: d, reason: collision with root package name */
        private o f5533d;
        private d h;

        /* renamed from: i, reason: collision with root package name */
        private v f5534i;

        /* renamed from: j, reason: collision with root package name */
        private f f5535j;

        /* renamed from: a, reason: collision with root package name */
        private int f5530a = 50;

        /* renamed from: b, reason: collision with root package name */
        private int f5531b = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;

        /* renamed from: c, reason: collision with root package name */
        private int f5532c = 1;
        private int e = 2;
        private int f = 50;
        private int g = 604800000;

        public final w a() {
            if (y.a(this.h) && com.mbridge.msdk.tracker.a.f5328a) {
                Log.e("TrackManager", "decorate can not be null");
            }
            if (y.a(this.f5534i) && com.mbridge.msdk.tracker.a.f5328a) {
                Log.e("TrackManager", "responseHandler can not be null");
            }
            if ((y.a(this.f5533d) || y.a(this.f5533d.c())) && com.mbridge.msdk.tracker.a.f5328a) {
                Log.e("TrackManager", "networkStackConfig or stack can not be null");
            }
            return new w(this);
        }

        public final a b(int i10) {
            if (i10 < 0) {
                this.f5531b = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;
                return this;
            }
            this.f5531b = i10;
            return this;
        }

        public final a c(int i10) {
            if (i10 <= 0) {
                this.e = 2;
                return this;
            }
            this.e = i10;
            return this;
        }

        public final a d(int i10) {
            if (i10 < 0) {
                this.f = 50;
                return this;
            }
            this.f = i10;
            return this;
        }

        public final a e(int i10) {
            if (i10 < 0) {
                this.g = 604800000;
                return this;
            }
            this.g = i10;
            return this;
        }

        public final a a(int i10) {
            if (i10 <= 0) {
                this.f5530a = 50;
                return this;
            }
            this.f5530a = i10;
            return this;
        }

        public final a a(int i10, o oVar) {
            this.f5532c = i10;
            this.f5533d = oVar;
            return this;
        }

        public final a a(d dVar) {
            this.h = dVar;
            return this;
        }

        public final a a(v vVar) {
            this.f5534i = vVar;
            return this;
        }

        public final a a(f fVar) {
            this.f5535j = fVar;
            return this;
        }
    }
}

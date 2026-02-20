package com.mbridge.msdk.foundation.tools;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class g {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a extends j {
        public a(int i10, int i11, Object obj, int i12, boolean z9) {
            super(i10, i11, obj, i12, z9);
        }

        @Override // com.mbridge.msdk.foundation.tools.g.b
        public final byte a() {
            return (byte) 7;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        int f4005a;

        public abstract byte a();
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class c extends b {

        /* renamed from: b, reason: collision with root package name */
        boolean f4006b;

        public c(int i10, boolean z9) {
            this.f4005a = i10;
            this.f4006b = z9;
        }

        @Override // com.mbridge.msdk.foundation.tools.g.b
        public final byte a() {
            return (byte) 1;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class d extends b {

        /* renamed from: b, reason: collision with root package name */
        double f4007b;

        public d(int i10, double d8) {
            this.f4005a = i10;
            this.f4007b = d8;
        }

        @Override // com.mbridge.msdk.foundation.tools.g.b
        public final byte a() {
            return (byte) 5;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class e extends b {

        /* renamed from: b, reason: collision with root package name */
        float f4008b;

        public e(int i10, float f) {
            this.f4005a = i10;
            this.f4008b = f;
        }

        @Override // com.mbridge.msdk.foundation.tools.g.b
        public final byte a() {
            return (byte) 3;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class f extends b {

        /* renamed from: b, reason: collision with root package name */
        int f4009b;

        public f(int i10, int i11) {
            this.f4005a = i10;
            this.f4009b = i11;
        }

        @Override // com.mbridge.msdk.foundation.tools.g.b
        public final byte a() {
            return (byte) 2;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.foundation.tools.g$g, reason: collision with other inner class name */
    public static class C0034g extends b {

        /* renamed from: b, reason: collision with root package name */
        long f4010b;

        public C0034g(int i10, long j10) {
            this.f4005a = i10;
            this.f4010b = j10;
        }

        @Override // com.mbridge.msdk.foundation.tools.g.b
        public final byte a() {
            return (byte) 4;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class h extends j {
        public h(int i10, int i11, Object obj, int i12, boolean z9) {
            super(i10, i11, obj, i12, z9);
        }

        @Override // com.mbridge.msdk.foundation.tools.g.b
        public final byte a() {
            return (byte) 8;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class i extends j {
        public i(int i10, int i11, String str, int i12, boolean z9) {
            super(i10, i11, str, i12, z9);
        }

        @Override // com.mbridge.msdk.foundation.tools.g.b
        public final byte a() {
            return (byte) 6;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class j extends b {

        /* renamed from: b, reason: collision with root package name */
        boolean f4011b;

        /* renamed from: c, reason: collision with root package name */
        int f4012c;

        /* renamed from: d, reason: collision with root package name */
        Object f4013d;
        int e;

        public j(int i10, int i11, Object obj, int i12, boolean z9) {
            this.f4012c = i10;
            this.f4005a = i11;
            this.f4013d = obj;
            this.e = i12;
            this.f4011b = z9;
        }
    }
}

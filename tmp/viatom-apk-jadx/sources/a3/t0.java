package a3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t0 {
    public static final s0 Companion = new s0();

    /* renamed from: a, reason: collision with root package name */
    public final String f161a;

    /* renamed from: b, reason: collision with root package name */
    public final String f162b;

    /* renamed from: c, reason: collision with root package name */
    public final int f163c;

    /* renamed from: d, reason: collision with root package name */
    public final long f164d;

    public /* synthetic */ t0(int i10, String str, int i11, String str2, long j10) {
        if (15 != (i10 & 15)) {
            g8.o0.e(r0.f158a.getDescriptor(), i10, 15);
            throw null;
        }
        this.f161a = str;
        this.f162b = str2;
        this.f163c = i11;
        this.f164d = j10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t0)) {
            return false;
        }
        t0 t0Var = (t0) obj;
        return kotlin.jvm.internal.l.a(this.f161a, t0Var.f161a) && kotlin.jvm.internal.l.a(this.f162b, t0Var.f162b) && this.f163c == t0Var.f163c && this.f164d == t0Var.f164d;
    }

    public final int hashCode() {
        int iO = (androidx.constraintlayout.core.widgets.analyzer.a.o(this.f161a.hashCode() * 31, 31, this.f162b) + this.f163c) * 31;
        long j10 = this.f164d;
        return iO + ((int) (j10 ^ (j10 >>> 32)));
    }

    public final String toString() {
        return "SessionDetails(sessionId=" + this.f161a + ", firstSessionId=" + this.f162b + ", sessionIndex=" + this.f163c + ", sessionStartTimestampUs=" + this.f164d + ')';
    }

    public t0(long j10, String str, String str2, int i10) {
        this.f161a = str;
        this.f162b = str2;
        this.f163c = i10;
        this.f164d = j10;
    }
}

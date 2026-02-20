package q;

import c.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f12209a;

    /* renamed from: b, reason: collision with root package name */
    public final long f12210b;

    public a(int i10, long j10) {
        if (i10 == 0) {
            androidx.window.layout.c.k("Null status");
            throw null;
        }
        this.f12209a = i10;
        this.f12210b = j10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return i.a(this.f12209a, aVar.f12209a) && this.f12210b == aVar.f12210b;
    }

    public final int hashCode() {
        int iC = (i.c(this.f12209a) ^ 1000003) * 1000003;
        long j10 = this.f12210b;
        return iC ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BackendResponse{status=");
        int i10 = this.f12209a;
        sb.append(i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "null" : "INVALID_PAYLOAD" : "FATAL_ERROR" : "TRANSIENT_ERROR" : "OK");
        sb.append(", nextRequestWaitMillis=");
        return a3.a.l(sb, this.f12210b, "}");
    }
}

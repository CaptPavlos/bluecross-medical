package a3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f40a;

    /* renamed from: b, reason: collision with root package name */
    public final String f41b;

    /* renamed from: c, reason: collision with root package name */
    public final int f42c;

    /* renamed from: d, reason: collision with root package name */
    public final long f43d;
    public final l e;
    public final String f;
    public final String g;

    public c1(String str, String str2, int i10, long j10, l lVar, String str3, String str4) {
        str.getClass();
        str2.getClass();
        str4.getClass();
        this.f40a = str;
        this.f41b = str2;
        this.f42c = i10;
        this.f43d = j10;
        this.e = lVar;
        this.f = str3;
        this.g = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c1)) {
            return false;
        }
        c1 c1Var = (c1) obj;
        return kotlin.jvm.internal.l.a(this.f40a, c1Var.f40a) && kotlin.jvm.internal.l.a(this.f41b, c1Var.f41b) && this.f42c == c1Var.f42c && this.f43d == c1Var.f43d && this.e.equals(c1Var.e) && this.f.equals(c1Var.f) && kotlin.jvm.internal.l.a(this.g, c1Var.g);
    }

    public final int hashCode() {
        int iO = (androidx.constraintlayout.core.widgets.analyzer.a.o(this.f40a.hashCode() * 31, 31, this.f41b) + this.f42c) * 31;
        long j10 = this.f43d;
        return this.g.hashCode() + androidx.constraintlayout.core.widgets.analyzer.a.o((this.e.hashCode() + ((iO + ((int) (j10 ^ (j10 >>> 32)))) * 31)) * 31, 31, this.f);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SessionInfo(sessionId=");
        sb.append(this.f40a);
        sb.append(", firstSessionId=");
        sb.append(this.f41b);
        sb.append(", sessionIndex=");
        sb.append(this.f42c);
        sb.append(", eventTimestampUs=");
        sb.append(this.f43d);
        sb.append(", dataCollectionStatus=");
        sb.append(this.e);
        sb.append(", firebaseInstallationId=");
        sb.append(this.f);
        sb.append(", firebaseAuthenticationToken=");
        return a.m(sb, this.g, ')');
    }
}

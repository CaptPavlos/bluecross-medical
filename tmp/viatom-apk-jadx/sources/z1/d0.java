package z1;

import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d0 extends p1 {

    /* renamed from: a, reason: collision with root package name */
    public final int f14192a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14193b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14194c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14195d;
    public final long e;
    public final long f;
    public final long g;
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public final List f14196i;

    public d0(int i10, String str, int i11, int i12, long j10, long j11, long j12, String str2, List list) {
        this.f14192a = i10;
        this.f14193b = str;
        this.f14194c = i11;
        this.f14195d = i12;
        this.e = j10;
        this.f = j11;
        this.g = j12;
        this.h = str2;
        this.f14196i = list;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p1) {
            d0 d0Var = (d0) ((p1) obj);
            if (this.f14192a == d0Var.f14192a && this.f14193b.equals(d0Var.f14193b) && this.f14194c == d0Var.f14194c && this.f14195d == d0Var.f14195d && this.e == d0Var.e && this.f == d0Var.f && this.g == d0Var.g) {
                String str = d0Var.h;
                String str2 = this.h;
                if (str2 != null ? str2.equals(str) : str == null) {
                    List list = d0Var.f14196i;
                    List list2 = this.f14196i;
                    if (list2 != null ? list2.equals(list) : list == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((((this.f14192a ^ 1000003) * 1000003) ^ this.f14193b.hashCode()) * 1000003) ^ this.f14194c) * 1000003) ^ this.f14195d) * 1000003;
        long j10 = this.e;
        int i10 = (iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f;
        int i11 = (i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        long j12 = this.g;
        int i12 = (i11 ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003;
        String str = this.h;
        int iHashCode2 = (i12 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.f14196i;
        return iHashCode2 ^ (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "ApplicationExitInfo{pid=" + this.f14192a + ", processName=" + this.f14193b + ", reasonCode=" + this.f14194c + ", importance=" + this.f14195d + ", pss=" + this.e + ", rss=" + this.f + ", timestamp=" + this.g + ", traceFile=" + this.h + ", buildIdMappingForArch=" + this.f14196i + "}";
    }
}

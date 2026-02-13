package z1;

import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j0 extends m2 {

    /* renamed from: a, reason: collision with root package name */
    public final String f14260a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14261b;

    /* renamed from: c, reason: collision with root package name */
    public final String f14262c;

    /* renamed from: d, reason: collision with root package name */
    public final long f14263d;
    public final Long e;
    public final boolean f;
    public final u1 g;
    public final l2 h;

    /* renamed from: i, reason: collision with root package name */
    public final k2 f14264i;

    /* renamed from: j, reason: collision with root package name */
    public final v1 f14265j;

    /* renamed from: k, reason: collision with root package name */
    public final List f14266k;

    /* renamed from: l, reason: collision with root package name */
    public final int f14267l;

    public j0(String str, String str2, String str3, long j10, Long l10, boolean z9, u1 u1Var, l2 l2Var, k2 k2Var, v1 v1Var, List list, int i10) {
        this.f14260a = str;
        this.f14261b = str2;
        this.f14262c = str3;
        this.f14263d = j10;
        this.e = l10;
        this.f = z9;
        this.g = u1Var;
        this.h = l2Var;
        this.f14264i = k2Var;
        this.f14265j = v1Var;
        this.f14266k = list;
        this.f14267l = i10;
    }

    @Override // z1.m2
    public final i0 a() {
        i0 i0Var = new i0();
        i0Var.f14238a = this.f14260a;
        i0Var.f14239b = this.f14261b;
        i0Var.f14240c = this.f14262c;
        i0Var.f14241d = this.f14263d;
        i0Var.e = this.e;
        i0Var.f = this.f;
        i0Var.g = this.g;
        i0Var.h = this.h;
        i0Var.f14242i = this.f14264i;
        i0Var.f14243j = this.f14265j;
        i0Var.f14244k = this.f14266k;
        i0Var.f14245l = this.f14267l;
        i0Var.f14246m = (byte) 7;
        return i0Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m2) {
            j0 j0Var = (j0) ((m2) obj);
            if (this.f14260a.equals(j0Var.f14260a) && this.f14261b.equals(j0Var.f14261b)) {
                String str = j0Var.f14262c;
                String str2 = this.f14262c;
                if (str2 != null ? str2.equals(str) : str == null) {
                    if (this.f14263d == j0Var.f14263d) {
                        Long l10 = j0Var.e;
                        Long l11 = this.e;
                        if (l11 != null ? l11.equals(l10) : l10 == null) {
                            if (this.f == j0Var.f && this.g.equals(j0Var.g)) {
                                l2 l2Var = j0Var.h;
                                l2 l2Var2 = this.h;
                                if (l2Var2 != null ? l2Var2.equals(l2Var) : l2Var == null) {
                                    k2 k2Var = j0Var.f14264i;
                                    k2 k2Var2 = this.f14264i;
                                    if (k2Var2 != null ? k2Var2.equals(k2Var) : k2Var == null) {
                                        v1 v1Var = j0Var.f14265j;
                                        v1 v1Var2 = this.f14265j;
                                        if (v1Var2 != null ? v1Var2.equals(v1Var) : v1Var == null) {
                                            List list = j0Var.f14266k;
                                            List list2 = this.f14266k;
                                            if (list2 != null ? list2.equals(list) : list == null) {
                                                if (this.f14267l == j0Var.f14267l) {
                                                    return true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((this.f14260a.hashCode() ^ 1000003) * 1000003) ^ this.f14261b.hashCode()) * 1000003;
        String str = this.f14262c;
        int iHashCode2 = str == null ? 0 : str.hashCode();
        long j10 = this.f14263d;
        int i10 = (((iHashCode ^ iHashCode2) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        Long l10 = this.e;
        int iHashCode3 = (((((i10 ^ (l10 == null ? 0 : l10.hashCode())) * 1000003) ^ (this.f ? 1231 : 1237)) * 1000003) ^ this.g.hashCode()) * 1000003;
        l2 l2Var = this.h;
        int iHashCode4 = (iHashCode3 ^ (l2Var == null ? 0 : l2Var.hashCode())) * 1000003;
        k2 k2Var = this.f14264i;
        int iHashCode5 = (iHashCode4 ^ (k2Var == null ? 0 : k2Var.hashCode())) * 1000003;
        v1 v1Var = this.f14265j;
        int iHashCode6 = (iHashCode5 ^ (v1Var == null ? 0 : v1Var.hashCode())) * 1000003;
        List list = this.f14266k;
        return ((iHashCode6 ^ (list != null ? list.hashCode() : 0)) * 1000003) ^ this.f14267l;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Session{generator=");
        sb.append(this.f14260a);
        sb.append(", identifier=");
        sb.append(this.f14261b);
        sb.append(", appQualitySessionId=");
        sb.append(this.f14262c);
        sb.append(", startedAt=");
        sb.append(this.f14263d);
        sb.append(", endedAt=");
        sb.append(this.e);
        sb.append(", crashed=");
        sb.append(this.f);
        sb.append(", app=");
        sb.append(this.g);
        sb.append(", user=");
        sb.append(this.h);
        sb.append(", os=");
        sb.append(this.f14264i);
        sb.append(", device=");
        sb.append(this.f14265j);
        sb.append(", events=");
        sb.append(this.f14266k);
        sb.append(", generatorType=");
        return a3.a.n(sb, "}", this.f14267l);
    }
}

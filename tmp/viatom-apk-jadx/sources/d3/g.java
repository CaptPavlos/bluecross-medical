package d3;

import g8.o0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g {
    public static final f Companion = new f();

    /* renamed from: a, reason: collision with root package name */
    public final Boolean f6815a;

    /* renamed from: b, reason: collision with root package name */
    public final Double f6816b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f6817c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f6818d;
    public final Long e;

    public /* synthetic */ g(int i10, Boolean bool, Double d8, Integer num, Integer num2, Long l10) {
        if (31 != (i10 & 31)) {
            o0.e(e.f6814a.getDescriptor(), i10, 31);
            throw null;
        }
        this.f6815a = bool;
        this.f6816b = d8;
        this.f6817c = num;
        this.f6818d = num2;
        this.e = l10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return kotlin.jvm.internal.l.a(this.f6815a, gVar.f6815a) && kotlin.jvm.internal.l.a(this.f6816b, gVar.f6816b) && kotlin.jvm.internal.l.a(this.f6817c, gVar.f6817c) && kotlin.jvm.internal.l.a(this.f6818d, gVar.f6818d) && kotlin.jvm.internal.l.a(this.e, gVar.e);
    }

    public final int hashCode() {
        Boolean bool = this.f6815a;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Double d8 = this.f6816b;
        int iHashCode2 = (iHashCode + (d8 == null ? 0 : d8.hashCode())) * 31;
        Integer num = this.f6817c;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f6818d;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l10 = this.e;
        return iHashCode4 + (l10 != null ? l10.hashCode() : 0);
    }

    public final String toString() {
        return "SessionConfigs(sessionsEnabled=" + this.f6815a + ", sessionSamplingRate=" + this.f6816b + ", sessionTimeoutSeconds=" + this.f6817c + ", cacheDurationSeconds=" + this.f6818d + ", cacheUpdatedTimeSeconds=" + this.e + ')';
    }

    public g(Boolean bool, Double d8, Integer num, Integer num2, Long l10) {
        this.f6815a = bool;
        this.f6816b = d8;
        this.f6817c = num;
        this.f6818d = num2;
        this.e = l10;
    }
}

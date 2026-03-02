package d9;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f7471a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f7472b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f7473c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f7474d;
    public final Integer e;
    public final Integer f;
    public final Integer g;
    public final Integer h;

    /* renamed from: i, reason: collision with root package name */
    public final Integer f7475i;

    /* renamed from: j, reason: collision with root package name */
    public final Integer f7476j;

    /* renamed from: k, reason: collision with root package name */
    public final Integer f7477k;

    /* renamed from: l, reason: collision with root package name */
    public final Integer f7478l;

    /* renamed from: m, reason: collision with root package name */
    public final Integer f7479m;

    /* renamed from: n, reason: collision with root package name */
    public final Integer f7480n;

    /* renamed from: o, reason: collision with root package name */
    public final Integer f7481o;

    /* renamed from: p, reason: collision with root package name */
    public final Integer f7482p;

    public d(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16) {
        this.f7471a = num;
        this.f7472b = num2;
        this.f7473c = num3;
        this.f7474d = num4;
        this.e = num5;
        this.f = num6;
        this.g = num7;
        this.h = num8;
        this.f7475i = num9;
        this.f7476j = num10;
        this.f7477k = num11;
        this.f7478l = num12;
        this.f7479m = num13;
        this.f7480n = num14;
        this.f7481o = num15;
        this.f7482p = num16;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return kotlin.jvm.internal.l.a(this.f7471a, dVar.f7471a) && kotlin.jvm.internal.l.a(this.f7472b, dVar.f7472b) && kotlin.jvm.internal.l.a(this.f7473c, dVar.f7473c) && kotlin.jvm.internal.l.a(this.f7474d, dVar.f7474d) && kotlin.jvm.internal.l.a(this.e, dVar.e) && kotlin.jvm.internal.l.a(this.f, dVar.f) && kotlin.jvm.internal.l.a(this.g, dVar.g) && kotlin.jvm.internal.l.a(this.h, dVar.h) && kotlin.jvm.internal.l.a(this.f7475i, dVar.f7475i) && kotlin.jvm.internal.l.a(this.f7476j, dVar.f7476j) && kotlin.jvm.internal.l.a(this.f7477k, dVar.f7477k) && kotlin.jvm.internal.l.a(this.f7478l, dVar.f7478l) && kotlin.jvm.internal.l.a(this.f7479m, dVar.f7479m) && kotlin.jvm.internal.l.a(this.f7480n, dVar.f7480n) && kotlin.jvm.internal.l.a(this.f7481o, dVar.f7481o) && kotlin.jvm.internal.l.a(this.f7482p, dVar.f7482p);
    }

    public final int hashCode() {
        Integer num = this.f7471a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.f7472b;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.f7473c;
        int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.f7474d;
        int iHashCode4 = (iHashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.e;
        int iHashCode5 = (iHashCode4 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.f;
        int iHashCode6 = (iHashCode5 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.g;
        int iHashCode7 = (iHashCode6 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.h;
        int iHashCode8 = (iHashCode7 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Integer num9 = this.f7475i;
        int iHashCode9 = (iHashCode8 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Integer num10 = this.f7476j;
        int iHashCode10 = (iHashCode9 + (num10 == null ? 0 : num10.hashCode())) * 31;
        Integer num11 = this.f7477k;
        int iHashCode11 = (iHashCode10 + (num11 == null ? 0 : num11.hashCode())) * 31;
        Integer num12 = this.f7478l;
        int iHashCode12 = (iHashCode11 + (num12 == null ? 0 : num12.hashCode())) * 31;
        Integer num13 = this.f7479m;
        int iHashCode13 = (iHashCode12 + (num13 == null ? 0 : num13.hashCode())) * 31;
        Integer num14 = this.f7480n;
        int iHashCode14 = (iHashCode13 + (num14 == null ? 0 : num14.hashCode())) * 31;
        Integer num15 = this.f7481o;
        int iHashCode15 = (iHashCode14 + (num15 == null ? 0 : num15.hashCode())) * 31;
        Integer num16 = this.f7482p;
        return iHashCode15 + (num16 != null ? num16.hashCode() : 0);
    }

    public final String toString() {
        return "ChoiceStyleSheet(dividerColor=" + this.f7471a + ", tabBackgroundColor=" + this.f7472b + ", searchBarBackgroundColor=" + this.f7473c + ", searchBarForegroundColor=" + this.f7474d + ", toggleActiveColor=" + this.e + ", toggleInactiveColor=" + this.f + ", globalBackgroundColor=" + this.g + ", titleTextColor=" + this.h + ", bodyTextColor=" + this.f7475i + ", tabTextColor=" + this.f7476j + ", menuTextColor=" + this.f7477k + ", linkTextColor=" + this.f7478l + ", buttonTextColor=" + this.f7479m + ", buttonDisabledTextColor=" + this.f7480n + ", buttonBackgroundColor=" + this.f7481o + ", buttonDisabledBackgroundColor=" + this.f7482p + ')';
    }
}

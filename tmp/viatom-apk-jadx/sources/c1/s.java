package c1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final String f1440a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1441b;

    /* renamed from: c, reason: collision with root package name */
    public final long f1442c;

    /* renamed from: d, reason: collision with root package name */
    public final long f1443d;
    public final long e;
    public final long f;
    public final long g;
    public final Long h;

    /* renamed from: i, reason: collision with root package name */
    public final Long f1444i;

    /* renamed from: j, reason: collision with root package name */
    public final Long f1445j;

    /* renamed from: k, reason: collision with root package name */
    public final Boolean f1446k;

    public s(String str, String str2, long j10, long j11, long j12, long j13, long j14, Long l10, Long l11, Long l12, Boolean bool) {
        i0.y.d(str);
        i0.y.d(str2);
        i0.y.b(j10 >= 0);
        i0.y.b(j11 >= 0);
        i0.y.b(j12 >= 0);
        i0.y.b(j14 >= 0);
        this.f1440a = str;
        this.f1441b = str2;
        this.f1442c = j10;
        this.f1443d = j11;
        this.e = j12;
        this.f = j13;
        this.g = j14;
        this.h = l10;
        this.f1444i = l11;
        this.f1445j = l12;
        this.f1446k = bool;
    }

    public final s a(long j10) {
        return new s(this.f1440a, this.f1441b, this.f1442c, this.f1443d, this.e, j10, this.g, this.h, this.f1444i, this.f1445j, this.f1446k);
    }

    public final s b(Long l10, Long l11, Boolean bool) {
        return new s(this.f1440a, this.f1441b, this.f1442c, this.f1443d, this.e, this.f, this.g, this.h, l10, l11, bool);
    }
}

package g8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t {
    public static final long[] e = new long[0];

    /* renamed from: a, reason: collision with root package name */
    public final e8.e f8326a;

    /* renamed from: b, reason: collision with root package name */
    public final i8.i f8327b;

    /* renamed from: c, reason: collision with root package name */
    public long f8328c;

    /* renamed from: d, reason: collision with root package name */
    public final long[] f8329d;

    public t(e8.e eVar, i8.i iVar) {
        eVar.getClass();
        this.f8326a = eVar;
        this.f8327b = iVar;
        int iE = eVar.e();
        if (iE <= 64) {
            this.f8328c = iE != 64 ? (-1) << iE : 0L;
            this.f8329d = e;
            return;
        }
        this.f8328c = 0L;
        int i10 = (iE - 1) >>> 6;
        long[] jArr = new long[i10];
        if ((iE & 63) != 0) {
            jArr[i10 - 1] = (-1) << iE;
        }
        this.f8329d = jArr;
    }
}

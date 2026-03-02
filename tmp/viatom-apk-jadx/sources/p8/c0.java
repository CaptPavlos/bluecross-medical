package p8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c0 extends d0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12074a;

    /* renamed from: b, reason: collision with root package name */
    public final long f12075b;

    /* renamed from: c, reason: collision with root package name */
    public final z8.k f12076c;

    public /* synthetic */ c0(long j10, z8.k kVar, int i10) {
        this.f12074a = i10;
        this.f12075b = j10;
        this.f12076c = kVar;
    }

    @Override // p8.d0
    public final long a() {
        switch (this.f12074a) {
        }
        return this.f12075b;
    }

    @Override // p8.d0
    public final z8.k b() {
        switch (this.f12074a) {
            case 0:
                return (z8.i) this.f12076c;
            default:
                return (z8.b0) this.f12076c;
        }
    }
}

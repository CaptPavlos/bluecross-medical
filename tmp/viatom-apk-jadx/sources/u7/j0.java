package u7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j0 extends v7.d {

    /* renamed from: a, reason: collision with root package name */
    public long f13012a;

    /* renamed from: b, reason: collision with root package name */
    public r7.g f13013b;

    @Override // v7.d
    public final boolean a(v7.b bVar) {
        h0 h0Var = (h0) bVar;
        if (this.f13012a >= 0) {
            return false;
        }
        long j10 = h0Var.f;
        if (j10 < h0Var.g) {
            h0Var.g = j10;
        }
        this.f13012a = j10;
        return true;
    }

    @Override // v7.d
    public final w6.c[] b(v7.b bVar) {
        long j10 = this.f13012a;
        this.f13012a = -1L;
        this.f13013b = null;
        return ((h0) bVar).r(j10);
    }
}

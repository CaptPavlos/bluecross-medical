package r7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p1 extends w7.r {
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p1(w6.h hVar, w6.c cVar, int i10) {
        super(cVar, hVar);
        this.e = i10;
    }

    @Override // r7.i1
    public final boolean A(Throwable th) {
        switch (this.e) {
            case 0:
                return false;
            default:
                return w(th);
        }
    }
}

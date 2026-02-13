package r7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t1 extends w7.r implements Runnable {
    public final long e;

    public t1(long j10, w6.c cVar) {
        super(cVar, cVar.getContext());
        this.e = j10;
    }

    @Override // r7.i1
    public final String R() {
        return super.R() + "(timeMillis=" + this.e + ')';
    }

    @Override // java.lang.Runnable
    public final void run() {
        y.l(this.f12387c);
        w(new s1("Timed out waiting for " + this.e + " ms", this));
    }
}

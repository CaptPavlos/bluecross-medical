package r7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o0 extends q0 {

    /* renamed from: c, reason: collision with root package name */
    public final g f12423c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ s0 f12424d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(s0 s0Var, long j10, g gVar) {
        super(j10);
        this.f12424d = s0Var;
        this.f12423c = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12423c.B(this.f12424d);
    }

    @Override // r7.q0
    public final String toString() {
        return super.toString() + this.f12423c;
    }
}

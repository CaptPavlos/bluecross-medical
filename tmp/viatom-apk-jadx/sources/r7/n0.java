package r7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class n0 extends s {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f12415d = 0;

    /* renamed from: a, reason: collision with root package name */
    public long f12416a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12417b;

    /* renamed from: c, reason: collision with root package name */
    public t6.i f12418c;

    public final void l(boolean z9) {
        long j10 = this.f12416a - (z9 ? 4294967296L : 1L);
        this.f12416a = j10;
        if (j10 <= 0 && this.f12417b) {
            shutdown();
        }
    }

    @Override // r7.s
    public final s limitedParallelism(int i10, String str) {
        w7.a.a(i10);
        return str != null ? new w7.o(this, str) : this;
    }

    public final void n(g0 g0Var) {
        t6.i iVar = this.f12418c;
        if (iVar == null) {
            iVar = new t6.i();
            this.f12418c = iVar;
        }
        iVar.addLast(g0Var);
    }

    public final void o(boolean z9) {
        this.f12416a = (z9 ? 4294967296L : 1L) + this.f12416a;
        if (z9) {
            return;
        }
        this.f12417b = true;
    }

    public abstract long p();

    public final boolean q() {
        t6.i iVar = this.f12418c;
        if (iVar == null) {
            return false;
        }
        g0 g0Var = (g0) (iVar.isEmpty() ? null : iVar.removeFirst());
        if (g0Var == null) {
            return false;
        }
        g0Var.run();
        return true;
    }

    public abstract void shutdown();
}

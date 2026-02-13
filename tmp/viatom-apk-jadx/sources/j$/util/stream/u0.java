package j$.util.stream;

import java.util.function.IntConsumer;
import java.util.function.IntFunction;

/* loaded from: classes2.dex */
public final class u0 extends g5 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9758b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f9759c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u0(a aVar, m5 m5Var, int i10) {
        super(m5Var);
        this.f9758b = i10;
        this.f9759c = aVar;
    }

    @Override // j$.util.stream.k5, j$.util.stream.m5
    public final void accept(int i10) {
        switch (this.f9758b) {
            case 0:
                this.f9586a.accept((m5) ((IntFunction) ((r) this.f9759c).f9718m).apply(i10));
                break;
            default:
                ((IntConsumer) ((v0) this.f9759c).f9775m).accept(i10);
                this.f9586a.accept(i10);
                break;
        }
    }
}

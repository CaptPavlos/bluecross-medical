package j$.util.stream;

import java.util.function.LongConsumer;
import java.util.function.LongFunction;

/* loaded from: classes2.dex */
public final class c1 extends h5 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9537b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f9538c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c1(a aVar, m5 m5Var, int i10) {
        super(m5Var);
        this.f9537b = i10;
        this.f9538c = aVar;
    }

    @Override // j$.util.stream.l5, j$.util.stream.m5
    public final void accept(long j10) {
        switch (this.f9537b) {
            case 0:
                this.f9595a.accept((m5) ((LongFunction) ((r) this.f9538c).f9718m).apply(j10));
                break;
            default:
                ((LongConsumer) ((g1) this.f9538c).f9582m).accept(j10);
                this.f9595a.accept(j10);
                break;
        }
    }
}

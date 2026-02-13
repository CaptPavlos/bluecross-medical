package j$.util.stream;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;

/* loaded from: classes2.dex */
public final class o extends f5 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9688b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f9689c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(a aVar, m5 m5Var, int i10) {
        super(m5Var);
        this.f9688b = i10;
        this.f9689c = aVar;
    }

    @Override // j$.util.stream.j5, java.util.function.DoubleConsumer
    public final void accept(double d8) {
        switch (this.f9688b) {
            case 0:
                this.f9576a.accept((m5) ((DoubleFunction) ((r) this.f9689c).f9718m).apply(d8));
                break;
            default:
                ((DoubleConsumer) ((x) this.f9689c).f9797m).accept(d8);
                this.f9576a.accept(d8);
                break;
        }
    }
}

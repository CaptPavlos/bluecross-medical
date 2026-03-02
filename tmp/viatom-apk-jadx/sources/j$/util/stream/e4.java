package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public final class e4 extends s4 implements r4, j5 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Supplier f9560b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ObjDoubleConsumer f9561c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ p f9562d;

    @Override // j$.util.stream.m5
    public final /* synthetic */ void accept(int i10) {
        w3.k();
        throw null;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void accept(long j10) {
        w3.l();
        throw null;
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final /* bridge */ /* synthetic */ void n(Object obj) {
        n((Double) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.com.android.tools.r8.a.d(this, doubleConsumer);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void end() {
    }

    @Override // j$.util.stream.j5
    public final /* synthetic */ void n(Double d8) {
        w3.d(this, d8);
    }

    @Override // j$.util.stream.r4
    public final void i(r4 r4Var) {
        this.f9732a = this.f9562d.apply(this.f9732a, ((e4) r4Var).f9732a);
    }

    @Override // j$.util.stream.m5
    public final void c(long j10) {
        this.f9732a = this.f9560b.get();
    }

    @Override // j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public final void accept(double d8) {
        this.f9561c.accept(this.f9732a, d8);
    }

    public e4(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, p pVar) {
        this.f9560b = supplier;
        this.f9561c = objDoubleConsumer;
        this.f9562d = pVar;
    }
}

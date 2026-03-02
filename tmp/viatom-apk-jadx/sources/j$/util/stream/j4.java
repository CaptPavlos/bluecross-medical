package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public final class j4 extends s4 implements r4 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Supplier f9621b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BiConsumer f9622c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BinaryOperator f9623d;

    @Override // j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d8) {
        w3.c();
        throw null;
    }

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

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void end() {
    }

    @Override // j$.util.stream.r4
    public final void i(r4 r4Var) {
        this.f9732a = this.f9623d.apply(this.f9732a, ((j4) r4Var).f9732a);
    }

    @Override // j$.util.stream.m5
    public final void c(long j10) {
        this.f9732a = this.f9621b.get();
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final void n(Object obj) {
        this.f9622c.accept(this.f9732a, obj);
    }

    public j4(Supplier supplier, BiConsumer biConsumer, BinaryOperator binaryOperator) {
        this.f9621b = supplier;
        this.f9622c = biConsumer;
        this.f9623d = binaryOperator;
    }
}

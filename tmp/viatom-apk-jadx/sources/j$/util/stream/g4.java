package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final class g4 extends s4 implements r4 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9583b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BiFunction f9584c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BinaryOperator f9585d;

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
        this.f9732a = this.f9585d.apply(this.f9732a, ((g4) r4Var).f9732a);
    }

    @Override // j$.util.stream.m5
    public final void c(long j10) {
        this.f9732a = this.f9583b;
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final void n(Object obj) {
        this.f9732a = this.f9584c.apply(this.f9732a, obj);
    }

    public g4(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        this.f9583b = obj;
        this.f9584c = biFunction;
        this.f9585d = binaryOperator;
    }
}

package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;

/* loaded from: classes2.dex */
public final class c4 implements r4, j5 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f9542a;

    /* renamed from: b, reason: collision with root package name */
    public double f9543b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DoubleBinaryOperator f9544c;

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

    public c4(DoubleBinaryOperator doubleBinaryOperator) {
        this.f9544c = doubleBinaryOperator;
    }

    @Override // j$.util.stream.r4
    public final void i(r4 r4Var) {
        c4 c4Var = (c4) r4Var;
        if (c4Var.f9542a) {
            return;
        }
        accept(c4Var.f9543b);
    }

    @Override // j$.util.stream.m5
    public final void c(long j10) {
        this.f9542a = true;
        this.f9543b = 0.0d;
    }

    @Override // j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public final void accept(double d8) {
        if (this.f9542a) {
            this.f9542a = false;
            this.f9543b = d8;
        } else {
            this.f9543b = this.f9544c.applyAsDouble(this.f9543b, d8);
        }
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return this.f9542a ? j$.util.c0.f9351c : new j$.util.c0(this.f9543b);
    }
}

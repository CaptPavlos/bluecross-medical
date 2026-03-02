package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public final class k4 extends s4 implements r4 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Supplier f9643b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BiConsumer f9644c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BiConsumer f9645d;

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
        this.f9645d.accept(this.f9732a, ((k4) r4Var).f9732a);
    }

    @Override // j$.util.stream.m5
    public final void c(long j10) {
        this.f9732a = this.f9643b.get();
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final void n(Object obj) {
        this.f9644c.accept(this.f9732a, obj);
    }

    public k4(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        this.f9643b = supplier;
        this.f9644c = biConsumer;
        this.f9645d = biConsumer2;
    }
}

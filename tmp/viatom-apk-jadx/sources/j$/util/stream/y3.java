package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public final class y3 extends s4 implements r4, l5 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Supplier f9805b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ObjLongConsumer f9806c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ p f9807d;

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

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final /* bridge */ /* synthetic */ void n(Object obj) {
        l((Long) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.com.android.tools.r8.a.f(this, longConsumer);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void end() {
    }

    @Override // j$.util.stream.l5
    public final /* synthetic */ void l(Long l10) {
        w3.i(this, l10);
    }

    @Override // j$.util.stream.r4
    public final void i(r4 r4Var) {
        this.f9732a = this.f9807d.apply(this.f9732a, ((y3) r4Var).f9732a);
    }

    @Override // j$.util.stream.m5
    public final void c(long j10) {
        this.f9732a = this.f9805b.get();
    }

    @Override // j$.util.stream.m5
    public final void accept(long j10) {
        this.f9806c.accept(this.f9732a, j10);
    }

    public y3(Supplier supplier, ObjLongConsumer objLongConsumer, p pVar) {
        this.f9805b = supplier;
        this.f9806c = objLongConsumer;
        this.f9807d = pVar;
    }
}

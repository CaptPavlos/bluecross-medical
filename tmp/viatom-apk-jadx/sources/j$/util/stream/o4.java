package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public final class o4 extends s4 implements r4, k5 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Supplier f9693b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ObjIntConsumer f9694c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ p f9695d;

    @Override // j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d8) {
        w3.c();
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
        d((Integer) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return j$.com.android.tools.r8.a.e(this, intConsumer);
    }

    @Override // j$.util.stream.k5
    public final /* synthetic */ void d(Integer num) {
        w3.g(this, num);
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
        this.f9732a = this.f9695d.apply(this.f9732a, ((o4) r4Var).f9732a);
    }

    @Override // j$.util.stream.m5
    public final void c(long j10) {
        this.f9732a = this.f9693b.get();
    }

    @Override // j$.util.stream.m5
    public final void accept(int i10) {
        this.f9694c.accept(this.f9732a, i10);
    }

    public o4(Supplier supplier, ObjIntConsumer objIntConsumer, p pVar) {
        this.f9693b = supplier;
        this.f9694c = objIntConsumer;
        this.f9695d = pVar;
    }
}

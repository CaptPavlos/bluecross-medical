package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.DoubleConsumer;

/* loaded from: classes2.dex */
public final class n0 extends r0 implements j5 {

    /* renamed from: b, reason: collision with root package name */
    public final DoubleConsumer f9673b;

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final /* bridge */ /* synthetic */ void n(Object obj) {
        n((Double) obj);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.com.android.tools.r8.a.d(this, doubleConsumer);
    }

    @Override // java.util.function.Supplier
    public final /* bridge */ /* synthetic */ Object get() {
        return null;
    }

    @Override // j$.util.stream.j5
    public final /* synthetic */ void n(Double d8) {
        w3.d(this, d8);
    }

    @Override // j$.util.stream.f8
    public final Object a(a aVar, Spliterator spliterator) {
        aVar.Q(spliterator, this);
        return null;
    }

    @Override // j$.util.stream.f8
    public final /* bridge */ /* synthetic */ Object b(a aVar, Spliterator spliterator) {
        g(aVar, spliterator);
        return null;
    }

    public n0(DoubleConsumer doubleConsumer, boolean z9) {
        super(z9);
        this.f9673b = doubleConsumer;
    }

    @Override // j$.util.stream.r0, j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public final void accept(double d8) {
        this.f9673b.accept(d8);
    }
}

package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final class h4 implements r4 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f9592a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9593b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BinaryOperator f9594c;

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

    public h4(BinaryOperator binaryOperator) {
        this.f9594c = binaryOperator;
    }

    @Override // j$.util.stream.r4
    public final void i(r4 r4Var) {
        h4 h4Var = (h4) r4Var;
        if (h4Var.f9592a) {
            return;
        }
        n(h4Var.f9593b);
    }

    @Override // j$.util.stream.m5
    public final void c(long j10) {
        this.f9592a = true;
        this.f9593b = null;
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final void n(Object obj) {
        if (this.f9592a) {
            this.f9592a = false;
            this.f9593b = obj;
        } else {
            this.f9593b = this.f9594c.apply(this.f9593b, obj);
        }
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return this.f9592a ? j$.util.b0.f9349b : new j$.util.b0(this.f9593b);
    }
}

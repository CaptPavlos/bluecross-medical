package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;

/* loaded from: classes2.dex */
public final class q4 implements r4, l5 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f9712a;

    /* renamed from: b, reason: collision with root package name */
    public long f9713b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LongBinaryOperator f9714c;

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

    public q4(LongBinaryOperator longBinaryOperator) {
        this.f9714c = longBinaryOperator;
    }

    @Override // j$.util.stream.r4
    public final void i(r4 r4Var) {
        q4 q4Var = (q4) r4Var;
        if (q4Var.f9712a) {
            return;
        }
        accept(q4Var.f9713b);
    }

    @Override // j$.util.stream.m5
    public final void c(long j10) {
        this.f9712a = true;
        this.f9713b = 0L;
    }

    @Override // j$.util.stream.m5
    public final void accept(long j10) {
        if (this.f9712a) {
            this.f9712a = false;
            this.f9713b = j10;
        } else {
            this.f9713b = this.f9714c.applyAsLong(this.f9713b, j10);
        }
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return this.f9712a ? j$.util.e0.f9419c : new j$.util.e0(this.f9713b);
    }
}

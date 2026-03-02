package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public abstract class t1 implements m5 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f9744a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9745b;

    @Override // j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public /* synthetic */ void accept(double d8) {
        w3.c();
        throw null;
    }

    @Override // j$.util.stream.m5
    public /* synthetic */ void accept(int i10) {
        w3.k();
        throw null;
    }

    @Override // j$.util.stream.m5
    public /* synthetic */ void accept(long j10) {
        w3.l();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void c(long j10) {
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void end() {
    }

    public t1(u1 u1Var) {
        this.f9745b = !u1Var.f9762b;
    }

    @Override // j$.util.stream.m5
    public final boolean e() {
        return this.f9744a;
    }
}

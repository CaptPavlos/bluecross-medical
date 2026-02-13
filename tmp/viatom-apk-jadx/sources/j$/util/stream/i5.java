package j$.util.stream;

import j$.util.Objects;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public abstract class i5 implements m5 {

    /* renamed from: a, reason: collision with root package name */
    public final m5 f9607a;

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

    public i5(m5 m5Var) {
        this.f9607a = (m5) Objects.requireNonNull(m5Var);
    }

    @Override // j$.util.stream.m5
    public void c(long j10) {
        this.f9607a.c(j10);
    }

    @Override // j$.util.stream.m5
    public void end() {
        this.f9607a.end();
    }

    @Override // j$.util.stream.m5
    public boolean e() {
        return this.f9607a.e();
    }
}

package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public abstract class x4 extends s4 implements r4 {

    /* renamed from: b, reason: collision with root package name */
    public long f9802b;

    public /* synthetic */ void accept(double d8) {
        w3.c();
        throw null;
    }

    public /* synthetic */ void accept(int i10) {
        w3.k();
        throw null;
    }

    public /* synthetic */ void accept(long j10) {
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

    @Override // j$.util.stream.m5
    public final void c(long j10) {
        this.f9802b = 0L;
    }
}

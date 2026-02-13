package j$.util.stream;

import java.util.function.LongConsumer;

/* loaded from: classes2.dex */
public final class v4 extends x4 implements l5 {
    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final /* bridge */ /* synthetic */ void n(Object obj) {
        l((Long) obj);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.com.android.tools.r8.a.f(this, longConsumer);
    }

    @Override // j$.util.stream.l5
    public final /* synthetic */ void l(Long l10) {
        w3.i(this, l10);
    }

    @Override // j$.util.stream.s4, java.util.function.Supplier
    public final Object get() {
        return Long.valueOf(this.f9802b);
    }

    @Override // j$.util.stream.r4
    public final void i(r4 r4Var) {
        this.f9802b += ((x4) r4Var).f9802b;
    }

    @Override // j$.util.stream.x4, j$.util.stream.m5
    public final void accept(long j10) {
        this.f9802b++;
    }
}

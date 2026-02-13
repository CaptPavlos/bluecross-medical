package j$.util.stream;

import java.util.function.DoubleConsumer;

/* loaded from: classes2.dex */
public final class g0 extends k0 implements j5 {

    /* renamed from: c, reason: collision with root package name */
    public static final f0 f9579c;

    /* renamed from: d, reason: collision with root package name */
    public static final f0 f9580d;

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.com.android.tools.r8.a.d(this, doubleConsumer);
    }

    @Override // j$.util.stream.k0, j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public final void accept(double d8) {
        n(Double.valueOf(d8));
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        if (this.f9635a) {
            return new j$.util.c0(((Double) this.f9636b).doubleValue());
        }
        return null;
    }

    static {
        a7 a7Var = a7.DOUBLE_VALUE;
        q qVar = new q(7);
        q qVar2 = new q(8);
        j$.util.c0 c0Var = j$.util.c0.f9351c;
        f9579c = new f0(true, a7Var, c0Var, qVar, qVar2);
        f9580d = new f0(false, a7Var, c0Var, new q(7), new q(8));
    }
}

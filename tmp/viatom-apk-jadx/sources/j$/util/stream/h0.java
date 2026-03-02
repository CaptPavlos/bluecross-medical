package j$.util.stream;

import java.util.function.IntConsumer;

/* loaded from: classes2.dex */
public final class h0 extends k0 implements k5 {

    /* renamed from: c, reason: collision with root package name */
    public static final f0 f9590c;

    /* renamed from: d, reason: collision with root package name */
    public static final f0 f9591d;

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return j$.com.android.tools.r8.a.e(this, intConsumer);
    }

    @Override // j$.util.stream.k0, j$.util.stream.m5
    public final void accept(int i10) {
        n(Integer.valueOf(i10));
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        if (this.f9635a) {
            return new j$.util.d0(((Integer) this.f9636b).intValue());
        }
        return null;
    }

    static {
        a7 a7Var = a7.INT_VALUE;
        q qVar = new q(9);
        q qVar2 = new q(10);
        j$.util.d0 d0Var = j$.util.d0.f9412c;
        f9590c = new f0(true, a7Var, d0Var, qVar, qVar2);
        f9591d = new f0(false, a7Var, d0Var, new q(9), new q(10));
    }
}

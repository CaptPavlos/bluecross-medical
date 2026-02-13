package j$.util.stream;

import java.util.function.LongConsumer;

/* loaded from: classes2.dex */
public final class i0 extends k0 implements l5 {

    /* renamed from: c, reason: collision with root package name */
    public static final f0 f9601c;

    /* renamed from: d, reason: collision with root package name */
    public static final f0 f9602d;

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.com.android.tools.r8.a.f(this, longConsumer);
    }

    @Override // j$.util.stream.k0, j$.util.stream.m5
    public final void accept(long j10) {
        n(Long.valueOf(j10));
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        if (this.f9635a) {
            return new j$.util.e0(((Long) this.f9636b).longValue());
        }
        return null;
    }

    static {
        a7 a7Var = a7.LONG_VALUE;
        q qVar = new q(11);
        q qVar2 = new q(12);
        j$.util.e0 e0Var = j$.util.e0.f9419c;
        f9601c = new f0(true, a7Var, e0Var, qVar, qVar2);
        f9602d = new f0(false, a7Var, e0Var, new q(11), new q(12));
    }
}

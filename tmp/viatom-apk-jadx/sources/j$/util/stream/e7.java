package j$.util.stream;

import java.util.function.LongConsumer;

/* loaded from: classes2.dex */
public final class e7 extends f7 implements LongConsumer {

    /* renamed from: c, reason: collision with root package name */
    public final long[] f9564c;

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.com.android.tools.r8.a.f(this, longConsumer);
    }

    public e7(int i10) {
        this.f9564c = new long[i10];
    }

    @Override // j$.util.stream.f7
    public final void a(Object obj, long j10) {
        LongConsumer longConsumer = (LongConsumer) obj;
        for (int i10 = 0; i10 < j10; i10++) {
            longConsumer.accept(this.f9564c[i10]);
        }
    }

    @Override // java.util.function.LongConsumer
    public final void accept(long j10) {
        int i10 = this.f9578b;
        this.f9578b = i10 + 1;
        this.f9564c[i10] = j10;
    }
}

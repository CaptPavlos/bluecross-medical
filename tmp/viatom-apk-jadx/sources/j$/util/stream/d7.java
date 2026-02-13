package j$.util.stream;

import java.util.function.IntConsumer;

/* loaded from: classes2.dex */
public final class d7 extends f7 implements IntConsumer {

    /* renamed from: c, reason: collision with root package name */
    public final int[] f9556c;

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return j$.com.android.tools.r8.a.e(this, intConsumer);
    }

    public d7(int i10) {
        this.f9556c = new int[i10];
    }

    @Override // j$.util.stream.f7
    public final void a(Object obj, long j10) {
        IntConsumer intConsumer = (IntConsumer) obj;
        for (int i10 = 0; i10 < j10; i10++) {
            intConsumer.accept(this.f9556c[i10]);
        }
    }

    @Override // java.util.function.IntConsumer
    public final void accept(int i10) {
        int i11 = this.f9578b;
        this.f9578b = i11 + 1;
        this.f9556c[i11] = i10;
    }
}

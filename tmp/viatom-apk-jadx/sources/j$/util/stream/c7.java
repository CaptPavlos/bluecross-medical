package j$.util.stream;

import java.util.function.DoubleConsumer;

/* loaded from: classes2.dex */
public final class c7 extends f7 implements DoubleConsumer {

    /* renamed from: c, reason: collision with root package name */
    public final double[] f9546c;

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.com.android.tools.r8.a.d(this, doubleConsumer);
    }

    public c7(int i10) {
        this.f9546c = new double[i10];
    }

    @Override // j$.util.stream.f7
    public final void a(Object obj, long j10) {
        DoubleConsumer doubleConsumer = (DoubleConsumer) obj;
        for (int i10 = 0; i10 < j10; i10++) {
            doubleConsumer.accept(this.f9546c[i10]);
        }
    }

    @Override // java.util.function.DoubleConsumer
    public final void accept(double d8) {
        int i10 = this.f9578b;
        this.f9578b = i10 + 1;
        this.f9546c[i10] = d8;
    }
}

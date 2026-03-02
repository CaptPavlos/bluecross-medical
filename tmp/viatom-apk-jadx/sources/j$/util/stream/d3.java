package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: classes2.dex */
public final class d3 extends c3 implements x1 {
    @Override // j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d8) {
        w3.c();
        throw null;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void accept(long j10) {
        w3.l();
        throw null;
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final /* bridge */ /* synthetic */ void n(Object obj) {
        d((Integer) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return j$.com.android.tools.r8.a.e(this, intConsumer);
    }

    @Override // j$.util.stream.k5
    public final /* synthetic */ void d(Integer num) {
        w3.g(this, num);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // j$.util.stream.z1
    public final /* bridge */ /* synthetic */ h2 build() {
        build();
        return this;
    }

    @Override // j$.util.stream.x1, j$.util.stream.z1
    public final d2 build() {
        int i10 = this.f9541b;
        int[] iArr = this.f9540a;
        if (i10 >= iArr.length) {
            return this;
        }
        j$.time.g.g("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(i10), Integer.valueOf(iArr.length)});
        return null;
    }

    @Override // j$.util.stream.m5
    public final void c(long j10) {
        int[] iArr = this.f9540a;
        if (j10 != iArr.length) {
            j$.time.g.g("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j10), Integer.valueOf(iArr.length)});
        } else {
            this.f9541b = 0;
        }
    }

    @Override // j$.util.stream.m5
    public final void accept(int i10) {
        int i11 = this.f9541b;
        int[] iArr = this.f9540a;
        if (i11 < iArr.length) {
            this.f9541b = i11 + 1;
            iArr[i11] = i10;
        } else {
            j$.time.g.g("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(iArr.length)});
        }
    }

    @Override // j$.util.stream.m5
    public final void end() {
        int i10 = this.f9541b;
        int[] iArr = this.f9540a;
        if (i10 >= iArr.length) {
            return;
        }
        j$.time.g.g("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(i10), Integer.valueOf(iArr.length)});
    }

    @Override // j$.util.stream.c3
    public final String toString() {
        int[] iArr = this.f9540a;
        return String.format("IntFixedNodeBuilder[%d][%s]", Integer.valueOf(iArr.length - this.f9541b), Arrays.toString(iArr));
    }
}

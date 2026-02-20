package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* loaded from: classes2.dex */
public final class u2 extends t2 implements w1 {
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

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final /* bridge */ /* synthetic */ void n(Object obj) {
        n((Double) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.com.android.tools.r8.a.d(this, doubleConsumer);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // j$.util.stream.j5
    public final /* synthetic */ void n(Double d8) {
        w3.d(this, d8);
    }

    @Override // j$.util.stream.z1
    public final /* bridge */ /* synthetic */ h2 build() {
        build();
        return this;
    }

    @Override // j$.util.stream.w1, j$.util.stream.z1
    public final b2 build() {
        int i10 = this.f9747b;
        double[] dArr = this.f9746a;
        if (i10 >= dArr.length) {
            return this;
        }
        j$.time.g.g("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(i10), Integer.valueOf(dArr.length)});
        return null;
    }

    @Override // j$.util.stream.m5
    public final void c(long j10) {
        double[] dArr = this.f9746a;
        if (j10 != dArr.length) {
            j$.time.g.g("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j10), Integer.valueOf(dArr.length)});
        } else {
            this.f9747b = 0;
        }
    }

    @Override // j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public final void accept(double d8) {
        int i10 = this.f9747b;
        double[] dArr = this.f9746a;
        if (i10 < dArr.length) {
            this.f9747b = i10 + 1;
            dArr[i10] = d8;
        } else {
            j$.time.g.g("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(dArr.length)});
        }
    }

    @Override // j$.util.stream.m5
    public final void end() {
        int i10 = this.f9747b;
        double[] dArr = this.f9746a;
        if (i10 >= dArr.length) {
            return;
        }
        j$.time.g.g("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(i10), Integer.valueOf(dArr.length)});
    }

    @Override // j$.util.stream.t2
    public final String toString() {
        double[] dArr = this.f9746a;
        return String.format("DoubleFixedNodeBuilder[%d][%s]", Integer.valueOf(dArr.length - this.f9747b), Arrays.toString(dArr));
    }
}

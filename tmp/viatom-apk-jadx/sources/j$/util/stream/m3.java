package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: classes2.dex */
public final class m3 extends l3 implements y1 {
    @Override // j$.util.stream.m5, j$.util.stream.j5, java.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d8) {
        w3.c();
        throw null;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void accept(int i10) {
        w3.k();
        throw null;
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final /* bridge */ /* synthetic */ void n(Object obj) {
        l((Long) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.com.android.tools.r8.a.f(this, longConsumer);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // j$.util.stream.l5
    public final /* synthetic */ void l(Long l10) {
        w3.i(this, l10);
    }

    @Override // j$.util.stream.z1
    public final /* bridge */ /* synthetic */ h2 build() {
        build();
        return this;
    }

    @Override // j$.util.stream.y1, j$.util.stream.z1
    public final f2 build() {
        int i10 = this.f9657b;
        long[] jArr = this.f9656a;
        if (i10 >= jArr.length) {
            return this;
        }
        j$.time.g.g("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(i10), Integer.valueOf(jArr.length)});
        return null;
    }

    @Override // j$.util.stream.m5
    public final void c(long j10) {
        long[] jArr = this.f9656a;
        if (j10 != jArr.length) {
            j$.time.g.g("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j10), Integer.valueOf(jArr.length)});
        } else {
            this.f9657b = 0;
        }
    }

    @Override // j$.util.stream.m5
    public final void accept(long j10) {
        int i10 = this.f9657b;
        long[] jArr = this.f9656a;
        if (i10 < jArr.length) {
            this.f9657b = i10 + 1;
            jArr[i10] = j10;
        } else {
            j$.time.g.g("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(jArr.length)});
        }
    }

    @Override // j$.util.stream.m5
    public final void end() {
        int i10 = this.f9657b;
        long[] jArr = this.f9656a;
        if (i10 >= jArr.length) {
            return;
        }
        j$.time.g.g("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(i10), Integer.valueOf(jArr.length)});
    }

    @Override // j$.util.stream.l3
    public final String toString() {
        long[] jArr = this.f9656a;
        return String.format("LongFixedNodeBuilder[%d][%s]", Integer.valueOf(jArr.length - this.f9657b), Arrays.toString(jArr));
    }
}

package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.Arrays;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final class b3 extends k2 implements z1 {
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

    @Override // j$.util.stream.m5
    public final /* synthetic */ void accept(long j10) {
        w3.l();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // j$.util.stream.z1
    public final h2 build() {
        int i10 = this.f9638b;
        Object[] objArr = this.f9637a;
        if (i10 >= objArr.length) {
            return this;
        }
        j$.time.g.g("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(i10), Integer.valueOf(objArr.length)});
        return null;
    }

    @Override // j$.util.stream.m5
    public final void c(long j10) {
        Object[] objArr = this.f9637a;
        if (j10 != objArr.length) {
            j$.time.g.g("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j10), Integer.valueOf(objArr.length)});
        } else {
            this.f9638b = 0;
        }
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final void n(Object obj) {
        int i10 = this.f9638b;
        Object[] objArr = this.f9637a;
        if (i10 < objArr.length) {
            this.f9638b = i10 + 1;
            objArr[i10] = obj;
        } else {
            j$.time.g.g("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(objArr.length)});
        }
    }

    @Override // j$.util.stream.m5
    public final void end() {
        int i10 = this.f9638b;
        Object[] objArr = this.f9637a;
        if (i10 >= objArr.length) {
            return;
        }
        j$.time.g.g("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(i10), Integer.valueOf(objArr.length)});
    }

    @Override // j$.util.stream.k2
    public final String toString() {
        Object[] objArr = this.f9637a;
        return String.format("FixedNodeBuilder[%d][%s]", Integer.valueOf(objArr.length - this.f9638b), Arrays.toString(objArr));
    }
}

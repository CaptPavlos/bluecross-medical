package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.LongFunction;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.function.ToLongFunction;

/* loaded from: classes2.dex */
public final /* synthetic */ class d1 implements LongFunction, Supplier, ObjLongConsumer, BiConsumer, LongBinaryOperator, ToLongFunction, Consumer, IntFunction, BinaryOperator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9554a;

    public /* synthetic */ d1(int i10) {
        this.f9554a = i10;
    }

    private final void accept$j$$util$stream$Node$0(Object obj) {
    }

    private final void accept$j$$util$stream$StreamSpliterators$SliceSpliterator$OfRef$0(Object obj) {
    }

    private final void accept$j$$util$stream$StreamSpliterators$SliceSpliterator$OfRef$1(Object obj) {
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public void n(Object obj) {
        int i10 = this.f9554a;
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        return j$.com.android.tools.r8.a.b(this, biConsumer);
    }

    public /* synthetic */ BiFunction andThen(Function function) {
        switch (this.f9554a) {
        }
        return j$.com.android.tools.r8.a.c(this, function);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f9554a) {
            case 8:
                break;
            case 21:
                break;
        }
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // java.util.function.LongFunction
    public Object apply(long j10) {
        switch (this.f9554a) {
            case 0:
                return Long.valueOf(j10);
            case 10:
                return w3.G(j10);
            case 12:
                return w3.P(j10);
            default:
                return w3.Q(j10);
        }
    }

    @Override // java.util.function.LongBinaryOperator
    public long applyAsLong(long j10, long j11) {
        switch (this.f9554a) {
            case 4:
                return Math.max(j10, j11);
            case 5:
                return j10 + j11;
            default:
                return Math.min(j10, j11);
        }
    }

    @Override // java.util.function.ToLongFunction
    public long applyAsLong(Object obj) {
        return ((Long) obj).longValue();
    }

    @Override // java.util.function.Supplier
    public Object get() {
        return new long[2];
    }

    @Override // java.util.function.ObjLongConsumer
    public void accept(Object obj, long j10) {
        long[] jArr = (long[]) obj;
        jArr[0] = jArr[0] + 1;
        jArr[1] = jArr[1] + j10;
    }

    @Override // java.util.function.BiConsumer
    public void accept(Object obj, Object obj2) {
        long[] jArr = (long[]) obj;
        long[] jArr2 = (long[]) obj2;
        jArr[0] = jArr[0] + jArr2[0];
        jArr[1] = jArr[1] + jArr2[1];
    }

    @Override // java.util.function.IntFunction
    public Object apply(int i10) {
        switch (this.f9554a) {
            case 9:
                return new Object[i10];
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 21:
            case 22:
            default:
                return new Double[i10];
            case 17:
                return new Object[i10];
            case 18:
                return new Integer[i10];
            case 19:
                return new Long[i10];
            case 20:
                return new Double[i10];
            case 23:
                return new Integer[i10];
            case 24:
                return new Integer[i10];
            case 25:
                return new Long[i10];
            case 26:
                return new Long[i10];
            case 27:
                return new Double[i10];
        }
    }

    @Override // java.util.function.BiFunction
    public Object apply(Object obj, Object obj2) {
        switch (this.f9554a) {
            case 11:
                return new o2((b2) obj, (b2) obj2);
            case 12:
            case 14:
            default:
                return new s2((h2) obj, (h2) obj2);
            case 13:
                return new p2((d2) obj, (d2) obj2);
            case 15:
                return new q2((f2) obj, (f2) obj2);
        }
    }
}

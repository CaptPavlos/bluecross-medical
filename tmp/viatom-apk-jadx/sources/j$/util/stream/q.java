package j$.util.stream;

import j$.util.function.Predicate$CC;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

/* loaded from: classes2.dex */
public final /* synthetic */ class q implements ObjDoubleConsumer, BiConsumer, DoubleBinaryOperator, Supplier, Predicate, IntFunction, IntBinaryOperator, ObjIntConsumer, ToIntFunction, ObjLongConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9710a;

    public /* synthetic */ q(int i10) {
        this.f9710a = i10;
    }

    @Override // java.util.function.ObjLongConsumer
    public void accept(Object obj, long j10) {
        ((j$.util.a0) obj).accept(j10);
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        switch (this.f9710a) {
        }
        return Predicate$CC.$default$and(this, predicate);
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.f9710a) {
            case 1:
                break;
            case 5:
                break;
            case 19:
                break;
            case 24:
                break;
        }
        return j$.com.android.tools.r8.a.b(this, biConsumer);
    }

    @Override // java.util.function.DoubleBinaryOperator
    public double applyAsDouble(double d8, double d10) {
        return Math.min(d8, d10);
    }

    @Override // java.util.function.IntBinaryOperator
    public int applyAsInt(int i10, int i11) {
        switch (this.f9710a) {
            case 17:
                return Math.min(i10, i11);
            case 20:
                return i10 + i11;
            default:
                return Math.max(i10, i11);
        }
    }

    public /* synthetic */ Predicate negate() {
        switch (this.f9710a) {
        }
        return Predicate$CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        switch (this.f9710a) {
        }
        return Predicate$CC.$default$or(this, predicate);
    }

    @Override // java.util.function.Predicate
    public boolean test(Object obj) {
        switch (this.f9710a) {
            case 7:
                return ((j$.util.c0) obj).f9352a;
            case 8:
            case 10:
            default:
                return ((j$.util.b0) obj).f9350a != null;
            case 9:
                return ((j$.util.d0) obj).f9413a;
            case 11:
                return ((j$.util.e0) obj).f9420a;
        }
    }

    @Override // java.util.function.ToIntFunction
    public int applyAsInt(Object obj) {
        return ((Integer) obj).intValue();
    }

    @Override // java.util.function.ObjDoubleConsumer
    public void accept(Object obj, double d8) {
        switch (this.f9710a) {
            case 0:
                double[] dArr = (double[]) obj;
                Collectors.a(dArr, d8);
                dArr[2] = dArr[2] + d8;
                break;
            case 4:
                double[] dArr2 = (double[]) obj;
                dArr2[2] = dArr2[2] + 1.0d;
                Collectors.a(dArr2, d8);
                dArr2[3] = dArr2[3] + d8;
                break;
            default:
                ((j$.util.x) obj).accept(d8);
                break;
        }
    }

    @Override // java.util.function.Supplier
    public Object get() {
        switch (this.f9710a) {
            case 3:
                return new double[4];
            case 8:
                return new g0();
            case 10:
                return new h0();
            case 12:
                return new i0();
            case 14:
                return new j0();
            default:
                return new long[2];
        }
    }

    @Override // java.util.function.ObjIntConsumer
    public void accept(Object obj, int i10) {
        switch (this.f9710a) {
            case 18:
                ((j$.util.y) obj).accept(i10);
                break;
            default:
                long[] jArr = (long[]) obj;
                jArr[0] = jArr[0] + 1;
                jArr[1] = jArr[1] + i10;
                break;
        }
    }

    @Override // java.util.function.BiConsumer
    public void accept(Object obj, Object obj2) {
        switch (this.f9710a) {
            case 1:
                double[] dArr = (double[]) obj;
                double[] dArr2 = (double[]) obj2;
                Collectors.a(dArr, dArr2[0]);
                Collectors.a(dArr, dArr2[1]);
                dArr[2] = dArr[2] + dArr2[2];
                break;
            case 5:
                double[] dArr3 = (double[]) obj;
                double[] dArr4 = (double[]) obj2;
                Collectors.a(dArr3, dArr4[0]);
                Collectors.a(dArr3, dArr4[1]);
                dArr3[2] = dArr3[2] + dArr4[2];
                dArr3[3] = dArr3[3] + dArr4[3];
                break;
            case 19:
                ((j$.util.y) obj).a((j$.util.y) obj2);
                break;
            case 24:
                long[] jArr = (long[]) obj;
                long[] jArr2 = (long[]) obj2;
                jArr[0] = jArr[0] + jArr2[0];
                jArr[1] = jArr[1] + jArr2[1];
                break;
            default:
                ((j$.util.a0) obj).a((j$.util.a0) obj2);
                break;
        }
    }

    @Override // java.util.function.IntFunction
    public Object apply(int i10) {
        switch (this.f9710a) {
            case 15:
                return new Object[i10];
            case 16:
                return new Integer[i10];
            case 26:
                return Integer.valueOf(i10);
            default:
                return new Long[i10];
        }
    }
}

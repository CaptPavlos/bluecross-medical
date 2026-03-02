package j$.util.stream;

import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;

/* loaded from: classes2.dex */
public final class w0 extends g5 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9785b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w0(int i10, m5 m5Var) {
        super(m5Var);
        this.f9785b = i10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w0(a aVar, m5 m5Var, int i10) {
        super(m5Var);
        this.f9785b = i10;
    }

    @Override // j$.util.stream.g5, j$.util.stream.m5
    public void c(long j10) {
        switch (this.f9785b) {
            case 5:
                this.f9586a.c(-1L);
                break;
            default:
                super.c(j10);
                break;
        }
    }

    @Override // j$.util.stream.k5, j$.util.stream.m5
    public final void accept(int i10) {
        switch (this.f9785b) {
            case 0:
                this.f9586a.accept(i10);
                return;
            case 1:
                this.f9586a.accept(i10);
                return;
            case 2:
                IntUnaryOperator intUnaryOperator = null;
                intUnaryOperator.applyAsInt(i10);
                throw null;
            case 3:
                IntToLongFunction intToLongFunction = null;
                intToLongFunction.applyAsLong(i10);
                throw null;
            case 4:
                IntToDoubleFunction intToDoubleFunction = null;
                intToDoubleFunction.applyAsDouble(i10);
                throw null;
            default:
                IntPredicate intPredicate = null;
                intPredicate.test(i10);
                throw null;
        }
    }
}

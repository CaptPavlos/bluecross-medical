package j$.util.stream;

import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;

/* loaded from: classes2.dex */
public final class s extends f5 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9723b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(a aVar, m5 m5Var, int i10) {
        super(m5Var);
        this.f9723b = i10;
    }

    @Override // j$.util.stream.f5, j$.util.stream.m5
    public void c(long j10) {
        switch (this.f9723b) {
            case 3:
                this.f9576a.c(-1L);
                break;
            default:
                super.c(j10);
                break;
        }
    }

    @Override // j$.util.stream.j5, java.util.function.DoubleConsumer
    public final void accept(double d8) {
        switch (this.f9723b) {
            case 0:
                DoubleUnaryOperator doubleUnaryOperator = null;
                doubleUnaryOperator.applyAsDouble(d8);
                throw null;
            case 1:
                DoubleToIntFunction doubleToIntFunction = null;
                doubleToIntFunction.applyAsInt(d8);
                throw null;
            case 2:
                DoubleToLongFunction doubleToLongFunction = null;
                doubleToLongFunction.applyAsLong(d8);
                throw null;
            default:
                DoublePredicate doublePredicate = null;
                doublePredicate.test(d8);
                throw null;
        }
    }
}

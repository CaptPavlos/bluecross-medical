package j$.util.stream;

import java.util.function.LongPredicate;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;

/* loaded from: classes2.dex */
public final class e1 extends h5 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9558b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e1(a aVar, m5 m5Var, int i10) {
        super(m5Var);
        this.f9558b = i10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e1(m5 m5Var) {
        super(m5Var);
        this.f9558b = 0;
    }

    @Override // j$.util.stream.h5, j$.util.stream.m5
    public void c(long j10) {
        switch (this.f9558b) {
            case 4:
                this.f9595a.c(-1L);
                break;
            default:
                super.c(j10);
                break;
        }
    }

    @Override // j$.util.stream.l5, j$.util.stream.m5
    public final void accept(long j10) {
        switch (this.f9558b) {
            case 0:
                this.f9595a.accept(j10);
                return;
            case 1:
                LongUnaryOperator longUnaryOperator = null;
                longUnaryOperator.applyAsLong(j10);
                throw null;
            case 2:
                LongToIntFunction longToIntFunction = null;
                longToIntFunction.applyAsInt(j10);
                throw null;
            case 3:
                LongToDoubleFunction longToDoubleFunction = null;
                longToDoubleFunction.applyAsDouble(j10);
                throw null;
            default:
                LongPredicate longPredicate = null;
                longPredicate.test(j10);
                throw null;
        }
    }
}

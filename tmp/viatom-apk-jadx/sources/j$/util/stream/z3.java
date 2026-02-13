package j$.util.stream;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;

/* loaded from: classes2.dex */
public final class z3 extends w3 {
    public final /* synthetic */ int h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f9814i;

    public /* synthetic */ z3(a7 a7Var, Object obj, int i10) {
        this.h = i10;
        this.f9814i = obj;
    }

    @Override // j$.util.stream.w3
    public final r4 Z() {
        switch (this.h) {
            case 0:
                return new q4((LongBinaryOperator) this.f9814i);
            case 1:
                return new c4((DoubleBinaryOperator) this.f9814i);
            case 2:
                return new h4((BinaryOperator) this.f9814i);
            default:
                return new n4((IntBinaryOperator) this.f9814i);
        }
    }
}

package j$.util.stream;

import java.util.function.DoubleBinaryOperator;

/* loaded from: classes2.dex */
public final class f4 extends w3 {
    public final /* synthetic */ DoubleBinaryOperator h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ double f9575i;

    @Override // j$.util.stream.w3
    public final r4 Z() {
        return new a4(this.f9575i, this.h);
    }

    public f4(a7 a7Var, DoubleBinaryOperator doubleBinaryOperator, double d8) {
        this.h = doubleBinaryOperator;
        this.f9575i = d8;
    }
}

package j$.util.stream;

import java.util.function.IntBinaryOperator;

/* loaded from: classes2.dex */
public final class m4 extends w3 {
    public final /* synthetic */ IntBinaryOperator h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f9670i;

    @Override // j$.util.stream.w3
    public final r4 Z() {
        return new l4(this.f9670i, this.h);
    }

    public m4(a7 a7Var, IntBinaryOperator intBinaryOperator, int i10) {
        this.h = intBinaryOperator;
        this.f9670i = i10;
    }
}

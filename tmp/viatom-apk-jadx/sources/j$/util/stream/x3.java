package j$.util.stream;

import java.util.function.LongBinaryOperator;

/* loaded from: classes2.dex */
public final class x3 extends w3 {
    public final /* synthetic */ LongBinaryOperator h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ long f9801i;

    @Override // j$.util.stream.w3
    public final r4 Z() {
        return new p4(this.f9801i, this.h);
    }

    public x3(a7 a7Var, LongBinaryOperator longBinaryOperator, long j10) {
        this.h = longBinaryOperator;
        this.f9801i = j10;
    }
}

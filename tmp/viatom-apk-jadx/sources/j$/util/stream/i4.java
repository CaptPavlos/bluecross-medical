package j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public final class i4 extends w3 {
    public final /* synthetic */ BinaryOperator h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ BiConsumer f9604i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Supplier f9605j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Collector f9606k;

    @Override // j$.util.stream.w3
    public final r4 Z() {
        return new j4(this.f9605j, this.f9604i, this.h);
    }

    @Override // j$.util.stream.w3, j$.util.stream.f8
    public final int f() {
        if (this.f9606k.characteristics().contains(h.UNORDERED)) {
            return z6.f9828r;
        }
        return 0;
    }

    public i4(a7 a7Var, BinaryOperator binaryOperator, BiConsumer biConsumer, Supplier supplier, Collector collector) {
        this.h = binaryOperator;
        this.f9604i = biConsumer;
        this.f9605j = supplier;
        this.f9606k = collector;
    }
}

package j$.util.stream;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public final class k implements Collector {

    /* renamed from: a, reason: collision with root package name */
    public final Supplier f9631a;

    /* renamed from: b, reason: collision with root package name */
    public final BiConsumer f9632b;

    /* renamed from: c, reason: collision with root package name */
    public final BinaryOperator f9633c;

    /* renamed from: d, reason: collision with root package name */
    public final Function f9634d;
    public final Set e;

    public k(Supplier supplier, BiConsumer biConsumer, BinaryOperator binaryOperator, Function function, Set set) {
        this.f9631a = supplier;
        this.f9632b = biConsumer;
        this.f9633c = binaryOperator;
        this.f9634d = function;
        this.e = set;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(Supplier supplier, BiConsumer biConsumer, BinaryOperator binaryOperator, Set set) {
        this(supplier, biConsumer, binaryOperator, new j$.time.format.a(16), set);
        Set set2 = Collectors.f9498a;
    }

    @Override // j$.util.stream.Collector
    public final BiConsumer accumulator() {
        return this.f9632b;
    }

    @Override // j$.util.stream.Collector
    public final Supplier supplier() {
        return this.f9631a;
    }

    @Override // j$.util.stream.Collector
    public final BinaryOperator combiner() {
        return this.f9633c;
    }

    @Override // j$.util.stream.Collector
    public final Function finisher() {
        return this.f9634d;
    }

    @Override // j$.util.stream.Collector
    public final Set characteristics() {
        return this.e;
    }
}

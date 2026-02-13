package j$.util.stream;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public final /* synthetic */ class i implements Collector {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ java.util.stream.Collector f9600a;

    public /* synthetic */ i(java.util.stream.Collector collector) {
        this.f9600a = collector;
    }

    @Override // j$.util.stream.Collector
    public final /* synthetic */ BiConsumer accumulator() {
        return this.f9600a.accumulator();
    }

    @Override // j$.util.stream.Collector
    public final /* synthetic */ Set characteristics() {
        return w3.N(this.f9600a.characteristics());
    }

    @Override // j$.util.stream.Collector
    public final /* synthetic */ BinaryOperator combiner() {
        return this.f9600a.combiner();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        java.util.stream.Collector collector = this.f9600a;
        if (obj instanceof i) {
            obj = ((i) obj).f9600a;
        }
        return collector.equals(obj);
    }

    @Override // j$.util.stream.Collector
    public final /* synthetic */ Function finisher() {
        return this.f9600a.finisher();
    }

    public final /* synthetic */ int hashCode() {
        return this.f9600a.hashCode();
    }

    @Override // j$.util.stream.Collector
    public final /* synthetic */ Supplier supplier() {
        return this.f9600a.supplier();
    }
}

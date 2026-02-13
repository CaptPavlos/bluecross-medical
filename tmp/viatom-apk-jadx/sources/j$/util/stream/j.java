package j$.util.stream;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public final /* synthetic */ class j implements java.util.stream.Collector {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Collector f9615a;

    public /* synthetic */ j(Collector collector) {
        this.f9615a = collector;
    }

    @Override // java.util.stream.Collector
    public final /* synthetic */ BiConsumer accumulator() {
        return this.f9615a.accumulator();
    }

    @Override // java.util.stream.Collector
    public final /* synthetic */ Set characteristics() {
        return w3.N(this.f9615a.characteristics());
    }

    @Override // java.util.stream.Collector
    public final /* synthetic */ BinaryOperator combiner() {
        return this.f9615a.combiner();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Collector collector = this.f9615a;
        if (obj instanceof j) {
            obj = ((j) obj).f9615a;
        }
        return collector.equals(obj);
    }

    @Override // java.util.stream.Collector
    public final /* synthetic */ Function finisher() {
        return this.f9615a.finisher();
    }

    public final /* synthetic */ int hashCode() {
        return this.f9615a.hashCode();
    }

    @Override // java.util.stream.Collector
    public final /* synthetic */ Supplier supplier() {
        return this.f9615a.supplier();
    }
}

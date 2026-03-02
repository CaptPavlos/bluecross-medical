package j$.util;

import j$.util.function.Consumer$CC;
import j$.util.function.Function$CC;
import j$.util.function.Predicate$CC;
import j$.util.stream.Collectors;
import j$.util.stream.IntStream;
import j$.util.stream.Stream;
import j$.util.stream.d8;
import j$.util.stream.k7;
import j$.util.stream.m5;
import j$.util.stream.m7;
import j$.util.stream.o7;
import j$.util.stream.x6;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.LongFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

/* loaded from: classes2.dex */
public final /* synthetic */ class q implements Consumer, Predicate, Supplier, DoubleFunction, Function, LongFunction, BooleanSupplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9482a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9483b;

    public /* synthetic */ q(int i10) {
        this.f9482a = i10;
    }

    public /* synthetic */ q(int i10, Object obj) {
        this.f9482a = i10;
        this.f9483b = obj;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate$CC.$default$and(this, predicate);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f9482a) {
            case 0:
                break;
            case 8:
                break;
        }
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    public /* synthetic */ Predicate negate() {
        return Predicate$CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate$CC.$default$or(this, predicate);
    }

    @Override // java.util.function.Predicate
    public boolean test(Object obj) {
        return !((Predicate) this.f9483b).test(obj);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        Object objApply = ((Function) this.f9483b).apply(obj);
        if (objApply == null) {
            return null;
        }
        if (objApply instanceof Stream) {
            return Stream.Wrapper.convert((Stream) objApply);
        }
        if (objApply instanceof java.util.stream.Stream) {
            return x6.g((java.util.stream.Stream) objApply);
        }
        if (objApply instanceof IntStream) {
            return IntStream.Wrapper.convert((IntStream) objApply);
        }
        if (objApply instanceof java.util.stream.IntStream) {
            return IntStream.VivifiedWrapper.convert((java.util.stream.IntStream) objApply);
        }
        if (objApply instanceof j$.util.stream.e0) {
            return j$.util.stream.d0.g((j$.util.stream.e0) objApply);
        }
        if (objApply instanceof DoubleStream) {
            return j$.util.stream.c0.g((DoubleStream) objApply);
        }
        if (objApply instanceof j$.util.stream.n1) {
            return j$.util.stream.m1.g((j$.util.stream.n1) objApply);
        }
        if (objApply instanceof LongStream) {
            return j$.util.stream.l1.g((LongStream) objApply);
        }
        g.a(objApply.getClass(), "java.util.stream.*Stream");
        throw null;
    }

    @Override // java.util.function.DoubleFunction
    public Object apply(double d8) {
        Object objApply = ((DoubleFunction) this.f9483b).apply(d8);
        if (objApply == null) {
            return null;
        }
        if (objApply instanceof j$.util.stream.e0) {
            return j$.util.stream.d0.g((j$.util.stream.e0) objApply);
        }
        if (objApply instanceof DoubleStream) {
            return j$.util.stream.c0.g((DoubleStream) objApply);
        }
        g.a(objApply.getClass(), "java.util.stream.DoubleStream");
        throw null;
    }

    @Override // java.util.function.LongFunction
    public Object apply(long j10) {
        Object objApply = ((LongFunction) this.f9483b).apply(j10);
        if (objApply == null) {
            return null;
        }
        if (objApply instanceof j$.util.stream.n1) {
            return j$.util.stream.m1.g((j$.util.stream.n1) objApply);
        }
        if (objApply instanceof LongStream) {
            return j$.util.stream.l1.g((LongStream) objApply);
        }
        g.a(objApply.getClass(), "java.util.stream.LongStream");
        throw null;
    }

    @Override // java.util.function.BooleanSupplier
    public boolean getAsBoolean() {
        switch (this.f9482a) {
            case 10:
                k7 k7Var = (k7) this.f9483b;
                return k7Var.f9526d.tryAdvance(k7Var.e);
            case 11:
                m7 m7Var = (m7) this.f9483b;
                return m7Var.f9526d.tryAdvance(m7Var.e);
            case 12:
                o7 o7Var = (o7) this.f9483b;
                return o7Var.f9526d.tryAdvance(o7Var.e);
            default:
                d8 d8Var = (d8) this.f9483b;
                return d8Var.f9526d.tryAdvance(d8Var.e);
        }
    }

    @Override // java.util.function.Supplier
    public Object get() {
        switch (this.f9482a) {
            case 2:
                return ((j$.util.stream.a) this.f9483b).N(0);
            case 3:
                return (Spliterator) this.f9483b;
            default:
                CharSequence charSequence = (CharSequence) this.f9483b;
                Set set = Collectors.f9498a;
                return new u1(charSequence);
        }
    }

    @Override // java.util.function.Consumer
    public void accept(Object obj) {
        switch (this.f9482a) {
            case 0:
                ((Consumer) this.f9483b).accept(new r((Map.Entry) obj));
                break;
            case 8:
                ((m5) this.f9483b).accept((m5) obj);
                break;
            default:
                ((ArrayList) ((java.util.List) this.f9483b)).add(obj);
                break;
        }
    }
}

package j$.util.concurrent;

import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import j$.util.stream.a7;
import j$.util.stream.f8;
import j$.util.stream.i7;
import j$.util.stream.p1;
import j$.util.stream.t1;
import j$.util.stream.u1;
import j$.util.stream.v1;
import j$.util.stream.z6;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public final /* synthetic */ class t implements BiConsumer, BiFunction, Consumer, Supplier, f8 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9395a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f9396b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f9397c;

    public /* synthetic */ t(int i10, Object obj, Object obj2) {
        this.f9395a = i10;
        this.f9396b = obj;
        this.f9397c = obj2;
    }

    public /* synthetic */ t(BiFunction biFunction, Function function) {
        this.f9395a = 2;
        this.f9397c = biFunction;
        this.f9396b = function;
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.f9395a) {
        }
        return j$.com.android.tools.r8.a.b(this, biConsumer);
    }

    public /* synthetic */ BiFunction andThen(Function function) {
        return j$.com.android.tools.r8.a.c(this, function);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f9395a) {
        }
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // java.util.function.BiFunction
    public Object apply(Object obj, Object obj2) {
        return ((Function) this.f9396b).apply(((BiFunction) this.f9397c).apply(obj, obj2));
    }

    @Override // java.util.function.BiConsumer
    public void accept(Object obj, Object obj2) {
        switch (this.f9395a) {
            case 0:
                ConcurrentMap concurrentMap = (ConcurrentMap) this.f9396b;
                BiFunction biFunction = (BiFunction) this.f9397c;
                while (!concurrentMap.replace(obj, obj2, biFunction.apply(obj, obj2)) && (obj2 = concurrentMap.get(obj)) != null) {
                }
            default:
                BiConsumer biConsumer = (BiConsumer) this.f9396b;
                BiConsumer biConsumer2 = (BiConsumer) this.f9397c;
                biConsumer.accept(obj, obj2);
                biConsumer2.accept(obj, obj2);
                break;
        }
    }

    @Override // java.util.function.Supplier
    public Object get() {
        return new p1((u1) this.f9396b, (Predicate) this.f9397c);
    }

    public t(a7 a7Var, u1 u1Var, Supplier supplier) {
        this.f9395a = 6;
        this.f9396b = u1Var;
        this.f9397c = supplier;
    }

    @Override // j$.util.stream.f8
    public int f() {
        return z6.f9830u | z6.f9828r;
    }

    @Override // j$.util.stream.f8
    public Object a(j$.util.stream.a aVar, Spliterator spliterator) {
        t1 t1Var = (t1) ((Supplier) this.f9397c).get();
        aVar.Q(spliterator, t1Var);
        return Boolean.valueOf(t1Var.f9745b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // j$.util.stream.f8
    public Object b(j$.util.stream.a aVar, Spliterator spliterator) {
        return (Boolean) new v1(this, aVar, spliterator).invoke();
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public void n(Object obj) {
        switch (this.f9395a) {
            case 3:
                Consumer consumer = (Consumer) this.f9396b;
                Consumer consumer2 = (Consumer) this.f9397c;
                consumer.n(obj);
                consumer2.n(obj);
                break;
            case 4:
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.f9396b;
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f9397c;
                if (obj != null) {
                    concurrentHashMap.putIfAbsent(obj, Boolean.TRUE);
                    break;
                } else {
                    atomicBoolean.set(true);
                    break;
                }
            case 5:
            case 6:
            default:
                i7 i7Var = (i7) this.f9396b;
                Consumer consumer3 = (Consumer) this.f9397c;
                if (i7Var.f9611b.putIfAbsent(obj != null ? obj : i7.f9609d, Boolean.TRUE) == null) {
                    consumer3.n(obj);
                    break;
                }
                break;
            case 7:
                ((BiConsumer) this.f9396b).accept(this.f9397c, obj);
                break;
        }
    }
}

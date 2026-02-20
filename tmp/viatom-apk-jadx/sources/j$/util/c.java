package j$.util;

import j$.util.Map;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class c {
    public static /* synthetic */ void q(java.util.Map map, BiConsumer biConsumer) {
        if (map instanceof Map) {
            ((Map) map).forEach(biConsumer);
        } else if (map instanceof ConcurrentMap) {
            j$.com.android.tools.r8.a.j((ConcurrentMap) map, biConsumer);
        } else {
            Map.CC.$default$forEach(map, biConsumer);
        }
    }

    public static /* synthetic */ Object t(java.util.Map map, Object obj, Object obj2) {
        return map instanceof Map ? ((Map) map).putIfAbsent(obj, obj2) : Map.CC.$default$putIfAbsent(map, obj, obj2);
    }

    public static b0 i(Optional optional) {
        if (optional == null) {
            return null;
        }
        if (!optional.isPresent()) {
            return b0.f9349b;
        }
        return new b0(optional.get());
    }

    public static c0 j(OptionalDouble optionalDouble) {
        if (optionalDouble == null) {
            return null;
        }
        if (!optionalDouble.isPresent()) {
            return c0.f9351c;
        }
        return new c0(optionalDouble.getAsDouble());
    }

    public static e0 l(OptionalLong optionalLong) {
        if (optionalLong == null) {
            return null;
        }
        if (!optionalLong.isPresent()) {
            return e0.f9419c;
        }
        return new e0(optionalLong.getAsLong());
    }

    public static d0 k(OptionalInt optionalInt) {
        if (optionalInt == null) {
            return null;
        }
        if (!optionalInt.isPresent()) {
            return d0.f9412c;
        }
        return new d0(optionalInt.getAsInt());
    }

    public static Object s(java.util.Map map, Object obj, Object obj2) {
        if (map instanceof Map) {
            return ((Map) map).getOrDefault(obj, obj2);
        }
        if (!(map instanceof ConcurrentMap)) {
            return Map.CC.$default$getOrDefault(map, obj, obj2);
        }
        Object obj3 = ((ConcurrentMap) map).get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    public static void r(Iterator it, Consumer consumer) {
        if (it instanceof z) {
            ((z) it).forEachRemaining(consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    public static OptionalDouble n(c0 c0Var) {
        if (c0Var == null) {
            return null;
        }
        boolean z9 = c0Var.f9352a;
        if (!z9) {
            return OptionalDouble.empty();
        }
        if (z9) {
            return OptionalDouble.of(c0Var.f9353b);
        }
        throw new NoSuchElementException("No value present");
    }

    public static OptionalInt o(d0 d0Var) {
        if (d0Var == null) {
            return null;
        }
        boolean z9 = d0Var.f9413a;
        if (!z9) {
            return OptionalInt.empty();
        }
        if (z9) {
            return OptionalInt.of(d0Var.f9414b);
        }
        throw new NoSuchElementException("No value present");
    }

    public static OptionalLong p(e0 e0Var) {
        if (e0Var == null) {
            return null;
        }
        boolean z9 = e0Var.f9420a;
        if (!z9) {
            return OptionalLong.empty();
        }
        if (z9) {
            return OptionalLong.of(e0Var.f9421b);
        }
        throw new NoSuchElementException("No value present");
    }

    public static Optional m(b0 b0Var) {
        if (b0Var == null) {
            return null;
        }
        Object obj = b0Var.f9350a;
        if (obj == null) {
            return Optional.empty();
        }
        if (obj != null) {
            return Optional.of(obj);
        }
        throw new NoSuchElementException("No value present");
    }

    public static k1 v(Object[] objArr, int i10, int i11) {
        t1.a(((Object[]) Objects.requireNonNull(objArr)).length, i10, i11);
        return new k1(objArr, i10, i11, 1040);
    }

    public static e w(f fVar, Comparator comparator) {
        Objects.requireNonNull(comparator);
        return new e(fVar, comparator);
    }

    public static long d(Spliterator spliterator) {
        if ((spliterator.characteristics() & 64) == 0) {
            return -1L;
        }
        return spliterator.estimateSize();
    }

    public static boolean e(Spliterator spliterator, int i10) {
        return (spliterator.characteristics() & i10) == i10;
    }

    public static void u(java.util.List list, Comparator comparator) {
        if (list instanceof List) {
            ((List) list).sort(comparator);
            return;
        }
        Object[] array = list.toArray();
        Arrays.sort(array, comparator);
        ListIterator listIterator = list.listIterator();
        for (Object obj : array) {
            listIterator.next();
            listIterator.set(obj);
        }
    }

    public static boolean g(y0 y0Var, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            return y0Var.tryAdvance((IntConsumer) consumer);
        }
        if (w1.f9854a) {
            w1.a(y0Var.getClass(), "{0} calling Spliterator.OfInt.tryAdvance((IntConsumer) action::accept)");
            throw null;
        }
        Objects.requireNonNull(consumer);
        return y0Var.tryAdvance((IntConsumer) new j0(consumer, 0));
    }

    public static void b(y0 y0Var, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            y0Var.forEachRemaining((IntConsumer) consumer);
        } else {
            if (w1.f9854a) {
                w1.a(y0Var.getClass(), "{0} calling Spliterator.OfInt.forEachRemaining((IntConsumer) action::accept)");
                throw null;
            }
            Objects.requireNonNull(consumer);
            y0Var.forEachRemaining((IntConsumer) new j0(consumer, 0));
        }
    }

    public static boolean h(b1 b1Var, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            return b1Var.tryAdvance((LongConsumer) consumer);
        }
        if (w1.f9854a) {
            w1.a(b1Var.getClass(), "{0} calling Spliterator.OfLong.tryAdvance((LongConsumer) action::accept)");
            throw null;
        }
        Objects.requireNonNull(consumer);
        return b1Var.tryAdvance((LongConsumer) new n0(consumer, 0));
    }

    public static void c(b1 b1Var, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            b1Var.forEachRemaining((LongConsumer) consumer);
        } else {
            if (w1.f9854a) {
                w1.a(b1Var.getClass(), "{0} calling Spliterator.OfLong.forEachRemaining((LongConsumer) action::accept)");
                throw null;
            }
            Objects.requireNonNull(consumer);
            b1Var.forEachRemaining((LongConsumer) new n0(consumer, 0));
        }
    }

    public static boolean f(v0 v0Var, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            return v0Var.tryAdvance((DoubleConsumer) consumer);
        }
        if (w1.f9854a) {
            w1.a(v0Var.getClass(), "{0} calling Spliterator.OfDouble.tryAdvance((DoubleConsumer) action::accept)");
            throw null;
        }
        Objects.requireNonNull(consumer);
        return v0Var.tryAdvance((DoubleConsumer) new f0(consumer, 0));
    }

    public static void a(v0 v0Var, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            v0Var.forEachRemaining((DoubleConsumer) consumer);
        } else {
            if (w1.f9854a) {
                w1.a(v0Var.getClass(), "{0} calling Spliterator.OfDouble.forEachRemaining((DoubleConsumer) action::accept)");
                throw null;
            }
            Objects.requireNonNull(consumer);
            v0Var.forEachRemaining((DoubleConsumer) new f0(consumer, 0));
        }
    }

    public Spliterator trySplit() {
        return null;
    }

    public boolean tryAdvance(Object obj) {
        Objects.requireNonNull(obj);
        return false;
    }

    public void forEachRemaining(Object obj) {
        Objects.requireNonNull(obj);
    }

    public long estimateSize() {
        return 0L;
    }

    public int characteristics() {
        return 16448;
    }
}

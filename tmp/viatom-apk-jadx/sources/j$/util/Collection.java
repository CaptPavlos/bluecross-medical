package j$.util;

import j$.util.List;
import j$.util.stream.Stream;
import j$.util.stream.w3;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/* loaded from: classes2.dex */
public interface Collection<E> {
    void forEach(Consumer<? super E> consumer);

    Stream<E> parallelStream();

    boolean removeIf(Predicate<? super E> predicate);

    Spliterator<E> spliterator();

    Stream<E> stream();

    <T> T[] toArray(IntFunction<T[]> intFunction);

    /* renamed from: j$.util.Collection$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Spliterator $default$spliterator(java.util.Collection collection) {
            return new r1(0, (java.util.Collection) Objects.requireNonNull(collection));
        }

        public static boolean $default$removeIf(java.util.Collection collection, Predicate predicate) {
            Objects.requireNonNull(predicate);
            Iterator<E> it = collection.iterator();
            boolean z9 = false;
            while (it.hasNext()) {
                if (predicate.test(it.next())) {
                    it.remove();
                    z9 = true;
                }
            }
            return z9;
        }

        public static Stream $default$stream(java.util.Collection collection) {
            return w3.a0(EL.c(collection), false);
        }

        public static Stream $default$parallelStream(java.util.Collection collection) {
            return w3.a0(EL.c(collection), true);
        }
    }

    /* renamed from: j$.util.Collection$-EL, reason: invalid class name */
    public final /* synthetic */ class EL {
        public static /* synthetic */ Stream b(java.util.Collection collection) {
            return collection instanceof Collection ? ((Collection) collection).parallelStream() : CC.$default$parallelStream(collection);
        }

        public static /* synthetic */ Stream stream(java.util.Collection collection) {
            return collection instanceof Collection ? ((Collection) collection).stream() : CC.$default$stream(collection);
        }

        public static Spliterator c(java.util.Collection collection) {
            if (collection instanceof Collection) {
                return ((Collection) collection).spliterator();
            }
            if (collection instanceof LinkedHashSet) {
                return new r1(17, (java.util.Collection) Objects.requireNonNull((LinkedHashSet) collection));
            }
            if (!(collection instanceof SortedSet)) {
                return collection instanceof Set ? new r1(1, (java.util.Collection) Objects.requireNonNull((Set) collection)) : collection instanceof java.util.List ? List.CC.$default$spliterator((java.util.List) collection) : CC.$default$spliterator(collection);
            }
            SortedSet sortedSet = (SortedSet) collection;
            return new s0(sortedSet, sortedSet);
        }

        public static void a(java.util.Collection collection, Consumer consumer) {
            if (collection instanceof Collection) {
                ((Collection) collection).forEach(consumer);
                return;
            }
            Objects.requireNonNull(consumer);
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                consumer.n(it.next());
            }
        }
    }
}

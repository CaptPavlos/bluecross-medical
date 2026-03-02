package j$.util;

import java.util.Comparator;
import java.util.RandomAccess;
import java.util.function.UnaryOperator;

/* loaded from: classes2.dex */
public interface List<E> extends Collection<E> {
    void replaceAll(UnaryOperator<E> unaryOperator);

    void sort(Comparator<? super E> comparator);

    @Override // java.util.Collection, java.lang.Iterable, j$.util.List, j$.util.Collection
    Spliterator<E> spliterator();

    /* renamed from: j$.util.List$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Spliterator $default$spliterator(java.util.List list) {
            if (!(list instanceof RandomAccess)) {
                return new r1(16, (java.util.Collection) Objects.requireNonNull(list));
            }
            return new a(list);
        }
    }
}

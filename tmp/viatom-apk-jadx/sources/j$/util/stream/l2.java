package j$.util.stream;

import j$.util.Collection;
import j$.util.Spliterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* loaded from: classes2.dex */
public final class l2 implements h2 {

    /* renamed from: a, reason: collision with root package name */
    public final Collection f9655a;

    @Override // j$.util.stream.h2
    public final /* synthetic */ h2 j(long j10, long j11, IntFunction intFunction) {
        return w3.w(this, j10, j11, intFunction);
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ int o() {
        return 0;
    }

    @Override // j$.util.stream.h2
    public final h2 a(int i10) {
        throw new IndexOutOfBoundsException();
    }

    public l2(Collection collection) {
        this.f9655a = collection;
    }

    @Override // j$.util.stream.h2
    public final Spliterator spliterator() {
        return Collection.EL.stream(this.f9655a).spliterator();
    }

    @Override // j$.util.stream.h2
    public final void k(Object[] objArr, int i10) {
        Iterator it = this.f9655a.iterator();
        while (it.hasNext()) {
            objArr[i10] = it.next();
            i10++;
        }
    }

    @Override // j$.util.stream.h2
    public final Object[] m(IntFunction intFunction) {
        java.util.Collection collection = this.f9655a;
        return collection.toArray((Object[]) intFunction.apply(collection.size()));
    }

    @Override // j$.util.stream.h2
    public final long count() {
        return this.f9655a.size();
    }

    @Override // j$.util.stream.h2
    public final void forEach(Consumer consumer) {
        Collection.EL.a(this.f9655a, consumer);
    }

    public final String toString() {
        return String.format("CollectionNode[%d][%s]", Integer.valueOf(this.f9655a.size()), this.f9655a);
    }
}

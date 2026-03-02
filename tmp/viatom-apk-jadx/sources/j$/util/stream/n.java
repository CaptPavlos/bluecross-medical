package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.IntFunction;

/* loaded from: classes2.dex */
public final class n extends c5 {
    public static l2 T(a aVar, Spliterator spliterator) {
        j$.time.format.a aVar2 = new j$.time.format.a(21);
        j$.time.format.a aVar3 = new j$.time.format.a(22);
        j$.time.format.a aVar4 = new j$.time.format.a(23);
        Objects.requireNonNull(aVar2);
        Objects.requireNonNull(aVar3);
        Objects.requireNonNull(aVar4);
        return new l2((Collection) new b4(a7.REFERENCE, aVar4, aVar3, aVar2, 3).b(aVar, spliterator));
    }

    @Override // j$.util.stream.a
    public final h2 J(a aVar, Spliterator spliterator, IntFunction intFunction) {
        if (z6.DISTINCT.j(aVar.f)) {
            return aVar.B(spliterator, false, intFunction);
        }
        if (z6.ORDERED.j(aVar.f)) {
            return T(aVar, spliterator);
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        j$.util.concurrent.t tVar = new j$.util.concurrent.t(4, atomicBoolean, concurrentHashMap);
        Objects.requireNonNull(tVar);
        new q0(tVar, false).g(aVar, spliterator);
        Collection collectionKeySet = concurrentHashMap.keySet();
        if (atomicBoolean.get()) {
            HashSet hashSet = new HashSet(collectionKeySet);
            hashSet.add(null);
            collectionKeySet = hashSet;
        }
        return new l2(collectionKeySet);
    }

    @Override // j$.util.stream.a
    public final Spliterator K(a aVar, Spliterator spliterator) {
        if (z6.DISTINCT.j(aVar.f)) {
            return aVar.S(spliterator);
        }
        if (z6.ORDERED.j(aVar.f)) {
            return T(aVar, spliterator).spliterator();
        }
        return new i7(aVar.S(spliterator), new ConcurrentHashMap());
    }

    @Override // j$.util.stream.a
    public final m5 M(int i10, m5 m5Var) {
        Objects.requireNonNull(m5Var);
        if (z6.DISTINCT.j(i10)) {
            return m5Var;
        }
        if (z6.SORTED.j(i10)) {
            return new l(m5Var);
        }
        return new m(m5Var);
    }
}

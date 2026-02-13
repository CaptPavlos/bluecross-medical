package j$.util.stream;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/* loaded from: classes2.dex */
public final class Collectors {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f9498a;

    /* renamed from: b, reason: collision with root package name */
    public static final Set f9499b;

    static {
        h hVar = h.CONCURRENT;
        h hVar2 = h.UNORDERED;
        h hVar3 = h.IDENTITY_FINISH;
        Collections.unmodifiableSet(EnumSet.of(hVar, hVar2, hVar3));
        Collections.unmodifiableSet(EnumSet.of(hVar, hVar2));
        f9498a = Collections.unmodifiableSet(EnumSet.of(hVar3));
        Collections.unmodifiableSet(EnumSet.of(hVar2, hVar3));
        f9499b = Collections.EMPTY_SET;
        Collections.unmodifiableSet(EnumSet.of(hVar2));
    }

    public static <T> Collector<T, ?, List<T>> toList() {
        return new k(new j$.time.format.a(11), new j$.time.format.a(12), new j$.time.format.a(15), f9498a);
    }

    public static Collector<CharSequence, ?, String> joining(CharSequence charSequence) {
        return new k(new j$.util.q(4, charSequence), new j$.time.format.a(17), new j$.time.format.a(18), new j$.time.format.a(19), f9499b);
    }

    public static void a(double[] dArr, double d8) {
        double d10 = d8 - dArr[1];
        double d11 = dArr[0];
        double d12 = d11 + d10;
        dArr[1] = (d12 - d11) - d10;
        dArr[0] = d12;
    }

    public static <T, K, U> Collector<T, ?, Map<K, U>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends U> function2) {
        return new k(new j$.time.format.a(20), new j$.util.function.c(function, function2, 2), new j$.time.format.a(9), f9498a);
    }
}

package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;
import java.util.function.Predicate;
import java.util.stream.Collector;

/* loaded from: classes2.dex */
public abstract class w3 implements f8 {

    /* renamed from: a, reason: collision with root package name */
    public static final z2 f9786a = new z2();

    /* renamed from: b, reason: collision with root package name */
    public static final x2 f9787b = new x2();

    /* renamed from: c, reason: collision with root package name */
    public static final y2 f9788c = new y2();

    /* renamed from: d, reason: collision with root package name */
    public static final w2 f9789d = new w2();
    public static final int[] e = new int[0];
    public static final long[] f = new long[0];
    public static final double[] g = new double[0];

    public abstract r4 Z();

    @Override // j$.util.stream.f8
    public /* synthetic */ int f() {
        return 0;
    }

    public static j$.util.q O(Function function) {
        j$.util.q qVar = new j$.util.q(6);
        qVar.f9483b = function;
        return qVar;
    }

    public static Set N(Set set) {
        if (set == null || set.isEmpty()) {
            return set;
        }
        HashSet hashSet = new HashSet();
        Object next = set.iterator().next();
        if (next instanceof h) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                try {
                    h hVar = (h) it.next();
                    hashSet.add(hVar == null ? null : hVar == h.CONCURRENT ? Collector.Characteristics.CONCURRENT : hVar == h.UNORDERED ? Collector.Characteristics.UNORDERED : Collector.Characteristics.IDENTITY_FINISH);
                } catch (ClassCastException e3) {
                    j$.util.g.a(e3, "java.util.stream.Collector.Characteristics");
                    throw null;
                }
            }
        } else {
            if (!(next instanceof Collector.Characteristics)) {
                j$.util.g.a(next.getClass(), "java.util.stream.Collector.Characteristics");
                throw null;
            }
            Iterator it2 = set.iterator();
            while (it2.hasNext()) {
                try {
                    Collector.Characteristics characteristics = (Collector.Characteristics) it2.next();
                    hashSet.add(characteristics == null ? null : characteristics == Collector.Characteristics.CONCURRENT ? h.CONCURRENT : characteristics == Collector.Characteristics.UNORDERED ? h.UNORDERED : h.IDENTITY_FINISH);
                } catch (ClassCastException e7) {
                    j$.util.g.a(e7, "java.util.stream.Collector.Characteristics");
                    throw null;
                }
            }
        }
        return hashSet;
    }

    public static long x(long j10, long j11, long j12) {
        if (j10 >= 0) {
            return Math.max(-1L, Math.min(j10 - j11, j12));
        }
        return -1L;
    }

    public static long A(long j10, long j11) {
        long j12 = j11 >= 0 ? j10 + j11 : Long.MAX_VALUE;
        if (j12 >= 0) {
            return j12;
        }
        return Long.MAX_VALUE;
    }

    public static b5 a0(Spliterator spliterator, boolean z9) {
        Objects.requireNonNull(spliterator);
        return new b5(spliterator, z6.g(spliterator), z9);
    }

    public static Spliterator y(a7 a7Var, Spliterator spliterator, long j10, long j11) {
        long jA = A(j10, j11);
        int i10 = v5.f9781a[a7Var.ordinal()];
        if (i10 == 1) {
            return new t7(spliterator, j10, jA);
        }
        if (i10 == 2) {
            return new q7((j$.util.y0) spliterator, j10, jA);
        }
        if (i10 == 3) {
            return new r7((j$.util.b1) spliterator, j10, jA);
        }
        if (i10 != 4) {
            throw new IllegalStateException("Unknown shape " + a7Var);
        }
        return new p7((j$.util.v0) spliterator, j10, jA);
    }

    public static j$.util.concurrent.t X(u1 u1Var, Predicate predicate) {
        Objects.requireNonNull(predicate);
        Objects.requireNonNull(u1Var);
        return new j$.util.concurrent.t(a7.REFERENCE, u1Var, new j$.util.concurrent.t(5, u1Var, predicate));
    }

    public static a3 H(a7 a7Var) {
        int i10 = i2.f9603a[a7Var.ordinal()];
        if (i10 == 1) {
            return f9786a;
        }
        if (i10 == 2) {
            return f9787b;
        }
        if (i10 == 3) {
            return f9788c;
        }
        if (i10 == 4) {
            return f9789d;
        }
        throw new IllegalStateException("Unknown shape " + a7Var);
    }

    public static j$.util.concurrent.t T(u1 u1Var) {
        Objects.requireNonNull(null);
        Objects.requireNonNull(u1Var);
        return new j$.util.concurrent.t(a7.INT_VALUE, u1Var, new o1(u1Var, 1));
    }

    public static o5 Y(e5 e5Var, long j10, long j11) {
        if (j10 < 0) {
            j$.time.g.a(j10);
            return null;
        }
        return new o5(e5Var, I(j11), j10, j11);
    }

    public static h2 w(h2 h2Var, long j10, long j11, IntFunction intFunction) {
        if (j10 == 0 && j11 == h2Var.count()) {
            return h2Var;
        }
        Spliterator spliterator = h2Var.spliterator();
        long j12 = j11 - j10;
        z1 z1VarZ = z(j12, intFunction);
        z1VarZ.c(j12);
        for (int i10 = 0; i10 < j10 && spliterator.tryAdvance(new d1(8)); i10++) {
        }
        if (j11 == h2Var.count()) {
            spliterator.forEachRemaining(z1VarZ);
        } else {
            for (int i11 = 0; i11 < j12 && spliterator.tryAdvance(z1VarZ); i11++) {
            }
        }
        z1VarZ.end();
        return z1VarZ.build();
    }

    public static j2 F(a7 a7Var, h2 h2Var, h2 h2Var2) {
        int i10 = i2.f9603a[a7Var.ordinal()];
        if (i10 == 1) {
            return new s2(h2Var, h2Var2);
        }
        if (i10 == 2) {
            return new p2((d2) h2Var, (d2) h2Var2);
        }
        if (i10 == 3) {
            return new q2((f2) h2Var, (f2) h2Var2);
        }
        if (i10 != 4) {
            throw new IllegalStateException("Unknown shape " + a7Var);
        }
        return new o2((b2) h2Var, (b2) h2Var2);
    }

    public static j$.util.concurrent.t V(u1 u1Var) {
        Objects.requireNonNull(null);
        Objects.requireNonNull(u1Var);
        return new j$.util.concurrent.t(a7.LONG_VALUE, u1Var, new o1(u1Var, 0));
    }

    public static void k() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static j$.util.concurrent.t R(u1 u1Var) {
        Objects.requireNonNull(null);
        Objects.requireNonNull(u1Var);
        return new j$.util.concurrent.t(a7.DOUBLE_VALUE, u1Var, new o1(u1Var, 2));
    }

    public static void l() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static z1 z(long j10, IntFunction intFunction) {
        if (j10 >= 0 && j10 < 2147483639) {
            return new b3(j10, intFunction);
        }
        return new t3();
    }

    public static void c() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static void g(k5 k5Var, Integer num) {
        if (h8.f9599a) {
            h8.a(k5Var.getClass(), "{0} calling Sink.OfInt.accept(Integer)");
            throw null;
        }
        k5Var.accept(num.intValue());
    }

    public static void i(l5 l5Var, Long l10) {
        if (h8.f9599a) {
            h8.a(l5Var.getClass(), "{0} calling Sink.OfLong.accept(Long)");
            throw null;
        }
        l5Var.accept(l10.longValue());
    }

    public static x1 P(long j10) {
        if (j10 < 0 || j10 >= 2147483639) {
            return new e3();
        }
        return new d3(j10);
    }

    public static void d(j5 j5Var, Double d8) {
        if (h8.f9599a) {
            h8.a(j5Var.getClass(), "{0} calling Sink.OfDouble.accept(Double)");
            throw null;
        }
        j5Var.accept(d8.doubleValue());
    }

    public static q5 U(b1 b1Var, long j10, long j11) {
        if (j10 < 0) {
            j$.time.g.a(j10);
            return null;
        }
        return new q5(b1Var, I(j11), j10, j11);
    }

    public static y1 Q(long j10) {
        if (j10 < 0 || j10 >= 2147483639) {
            return new n3();
        }
        return new m3(j10);
    }

    public static Object[] m(g2 g2Var, IntFunction intFunction) {
        if (h8.f9599a) {
            h8.a(g2Var.getClass(), "{0} calling Node.OfPrimitive.asArray");
            throw null;
        }
        if (g2Var.count() >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return null;
        }
        Object[] objArr = (Object[]) intFunction.apply((int) g2Var.count());
        g2Var.k(objArr, 0);
        return objArr;
    }

    public static w1 G(long j10) {
        if (j10 < 0 || j10 >= 2147483639) {
            return new v2();
        }
        return new u2(j10);
    }

    public static h2 B(a aVar, Spliterator spliterator, boolean z9, IntFunction intFunction) {
        long jF = aVar.F(spliterator);
        if (jF < 0 || !spliterator.hasCharacteristics(16384)) {
            m0 m0Var = new m0();
            m0Var.f9667a = intFunction;
            h2 h2Var = (h2) new m2(aVar, spliterator, m0Var, new d1(16), 3).invoke();
            return z9 ? J(h2Var, intFunction) : h2Var;
        }
        if (jF >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return null;
        }
        Object[] objArr = (Object[]) intFunction.apply((int) jF);
        new r3(spliterator, aVar, objArr).invoke();
        return new k2(objArr);
    }

    public static void r(d2 d2Var, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            d2Var.g((IntConsumer) consumer);
        } else {
            if (h8.f9599a) {
                h8.a(d2Var.getClass(), "{0} calling Node.OfInt.forEachRemaining(Consumer)");
                throw null;
            }
            ((j$.util.y0) d2Var.spliterator()).forEachRemaining(consumer);
        }
    }

    public static s5 W(k1 k1Var, long j10, long j11) {
        if (j10 < 0) {
            j$.time.g.a(j10);
            return null;
        }
        return new s5(k1Var, I(j11), j10, j11);
    }

    public static void o(d2 d2Var, Integer[] numArr, int i10) {
        if (h8.f9599a) {
            h8.a(d2Var.getClass(), "{0} calling Node.OfInt.copyInto(Integer[], int)");
            throw null;
        }
        int[] iArr = (int[]) d2Var.b();
        for (int i11 = 0; i11 < iArr.length; i11++) {
            numArr[i10 + i11] = Integer.valueOf(iArr[i11]);
        }
    }

    public static d2 u(d2 d2Var, long j10, long j11) {
        if (j10 == 0 && j11 == d2Var.count()) {
            return d2Var;
        }
        long j12 = j11 - j10;
        j$.util.y0 y0Var = (j$.util.y0) d2Var.spliterator();
        x1 x1VarP = P(j12);
        x1VarP.c(j12);
        for (int i10 = 0; i10 < j10 && y0Var.tryAdvance((IntConsumer) new c2(0)); i10++) {
        }
        if (j11 == d2Var.count()) {
            y0Var.forEachRemaining((IntConsumer) x1VarP);
        } else {
            for (int i11 = 0; i11 < j12 && y0Var.tryAdvance((IntConsumer) x1VarP); i11++) {
            }
        }
        x1VarP.end();
        return x1VarP.build();
    }

    public static d2 D(a aVar, Spliterator spliterator, boolean z9) {
        long jF = aVar.F(spliterator);
        if (jF < 0 || !spliterator.hasCharacteristics(16384)) {
            d2 d2Var = (d2) new m2(aVar, spliterator, new d1(12), new d1(13), 1).invoke();
            return z9 ? L(d2Var) : d2Var;
        }
        if (jF >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return null;
        }
        int[] iArr = new int[(int) jF];
        new p3(spliterator, aVar, iArr).invoke();
        return new c3(iArr);
    }

    public static f2 E(a aVar, Spliterator spliterator, boolean z9) {
        long jF = aVar.F(spliterator);
        if (jF < 0 || !spliterator.hasCharacteristics(16384)) {
            f2 f2Var = (f2) new m2(aVar, spliterator, new d1(14), new d1(15), 2).invoke();
            return z9 ? M(f2Var) : f2Var;
        }
        if (jF >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return null;
        }
        long[] jArr = new long[(int) jF];
        new q3(spliterator, aVar, jArr).invoke();
        return new l3(jArr);
    }

    public static void s(f2 f2Var, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            f2Var.g((LongConsumer) consumer);
        } else {
            if (h8.f9599a) {
                h8.a(f2Var.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
                throw null;
            }
            ((j$.util.b1) f2Var.spliterator()).forEachRemaining(consumer);
        }
    }

    public static void p(f2 f2Var, Long[] lArr, int i10) {
        if (h8.f9599a) {
            h8.a(f2Var.getClass(), "{0} calling Node.OfInt.copyInto(Long[], int)");
            throw null;
        }
        long[] jArr = (long[]) f2Var.b();
        for (int i11 = 0; i11 < jArr.length; i11++) {
            lArr[i10 + i11] = Long.valueOf(jArr[i11]);
        }
    }

    public static f2 v(f2 f2Var, long j10, long j11) {
        if (j10 == 0 && j11 == f2Var.count()) {
            return f2Var;
        }
        long j12 = j11 - j10;
        j$.util.b1 b1Var = (j$.util.b1) f2Var.spliterator();
        y1 y1VarQ = Q(j12);
        y1VarQ.c(j12);
        for (int i10 = 0; i10 < j10 && b1Var.tryAdvance((LongConsumer) new e2(0)); i10++) {
        }
        if (j11 == f2Var.count()) {
            b1Var.forEachRemaining((LongConsumer) y1VarQ);
        } else {
            for (int i11 = 0; i11 < j12 && b1Var.tryAdvance((LongConsumer) y1VarQ); i11++) {
            }
        }
        y1VarQ.end();
        return y1VarQ.build();
    }

    public static b2 C(a aVar, Spliterator spliterator, boolean z9) {
        long jF = aVar.F(spliterator);
        if (jF < 0 || !spliterator.hasCharacteristics(16384)) {
            b2 b2Var = (b2) new m2(aVar, spliterator, new d1(10), new d1(11), 0).invoke();
            return z9 ? K(b2Var) : b2Var;
        }
        if (jF >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return null;
        }
        double[] dArr = new double[(int) jF];
        new o3(spliterator, aVar, dArr).invoke();
        return new t2(dArr);
    }

    public static u5 S(b0 b0Var, long j10, long j11) {
        if (j10 < 0) {
            j$.time.g.a(j10);
            return null;
        }
        return new u5(b0Var, I(j11), j10, j11);
    }

    public static h2 J(h2 h2Var, IntFunction intFunction) {
        if (h2Var.o() <= 0) {
            return h2Var;
        }
        long jCount = h2Var.count();
        if (jCount >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return null;
        }
        Object[] objArr = (Object[]) intFunction.apply((int) jCount);
        new v3(h2Var, objArr, 1).invoke();
        return new k2(objArr);
    }

    public static void q(b2 b2Var, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            b2Var.g((DoubleConsumer) consumer);
        } else {
            if (h8.f9599a) {
                h8.a(b2Var.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
                throw null;
            }
            ((j$.util.v0) b2Var.spliterator()).forEachRemaining(consumer);
        }
    }

    public static d2 L(d2 d2Var) {
        if (d2Var.o() <= 0) {
            return d2Var;
        }
        long jCount = d2Var.count();
        if (jCount >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return null;
        }
        int[] iArr = new int[(int) jCount];
        new u3(d2Var, iArr, 0).invoke();
        return new c3(iArr);
    }

    public static void n(b2 b2Var, Double[] dArr, int i10) {
        if (h8.f9599a) {
            h8.a(b2Var.getClass(), "{0} calling Node.OfDouble.copyInto(Double[], int)");
            throw null;
        }
        double[] dArr2 = (double[]) b2Var.b();
        for (int i11 = 0; i11 < dArr2.length; i11++) {
            dArr[i10 + i11] = Double.valueOf(dArr2[i11]);
        }
    }

    public static b2 t(b2 b2Var, long j10, long j11) {
        if (j10 == 0 && j11 == b2Var.count()) {
            return b2Var;
        }
        long j12 = j11 - j10;
        j$.util.v0 v0Var = (j$.util.v0) b2Var.spliterator();
        w1 w1VarG = G(j12);
        w1VarG.c(j12);
        for (int i10 = 0; i10 < j10 && v0Var.tryAdvance((DoubleConsumer) new a2(0)); i10++) {
        }
        if (j11 == b2Var.count()) {
            v0Var.forEachRemaining((DoubleConsumer) w1VarG);
        } else {
            for (int i11 = 0; i11 < j12 && v0Var.tryAdvance((DoubleConsumer) w1VarG); i11++) {
            }
        }
        w1VarG.end();
        return w1VarG.build();
    }

    public static f2 M(f2 f2Var) {
        if (f2Var.o() <= 0) {
            return f2Var;
        }
        long jCount = f2Var.count();
        if (jCount >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return null;
        }
        long[] jArr = new long[(int) jCount];
        new u3(f2Var, jArr, 0).invoke();
        return new l3(jArr);
    }

    public static int I(long j10) {
        return (j10 != -1 ? z6.f9830u : 0) | z6.t;
    }

    public static b2 K(b2 b2Var) {
        if (b2Var.o() <= 0) {
            return b2Var;
        }
        long jCount = b2Var.count();
        if (jCount >= 2147483639) {
            j$.time.g.c("Stream size exceeds max array size");
            return null;
        }
        double[] dArr = new double[(int) jCount];
        new u3(b2Var, dArr, 0).invoke();
        return new t2(dArr);
    }

    @Override // j$.util.stream.f8
    public Object a(a aVar, Spliterator spliterator) {
        r4 r4VarZ = Z();
        aVar.Q(spliterator, r4VarZ);
        return r4VarZ.get();
    }

    @Override // j$.util.stream.f8
    public Object b(a aVar, Spliterator spliterator) {
        return ((r4) new y4(this, aVar, spliterator).invoke()).get();
    }
}

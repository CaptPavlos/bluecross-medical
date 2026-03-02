package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.IntFunction;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public abstract class a implements g {

    /* renamed from: a, reason: collision with root package name */
    public final a f9503a;

    /* renamed from: b, reason: collision with root package name */
    public final a f9504b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9505c;

    /* renamed from: d, reason: collision with root package name */
    public final a f9506d;
    public int e;
    public int f;
    public Spliterator g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f9507i;

    /* renamed from: j, reason: collision with root package name */
    public Runnable f9508j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f9509k;

    public abstract h2 E(a aVar, Spliterator spliterator, boolean z9, IntFunction intFunction);

    public abstract boolean G(Spliterator spliterator, m5 m5Var);

    public abstract a7 H();

    public abstract z1 I(long j10, IntFunction intFunction);

    public abstract boolean L();

    public abstract m5 M(int i10, m5 m5Var);

    public abstract Spliterator P(a aVar, Supplier supplier, boolean z9);

    public a(Spliterator spliterator, int i10, boolean z9) {
        this.f9504b = null;
        this.g = spliterator;
        this.f9503a = this;
        int i11 = z6.g & i10;
        this.f9505c = i11;
        this.f = (~(i11 << 1)) & z6.f9822l;
        this.e = 0;
        this.f9509k = z9;
    }

    public a(a aVar, int i10) {
        if (aVar.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        aVar.h = true;
        aVar.f9506d = this;
        this.f9504b = aVar;
        this.f9505c = z6.h & i10;
        this.f = z6.e(i10, aVar.f);
        a aVar2 = aVar.f9503a;
        this.f9503a = aVar2;
        if (L()) {
            aVar2.f9507i = true;
        }
        this.e = aVar.e + 1;
    }

    public final Object C(f8 f8Var) {
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.h = true;
        if (this.f9503a.f9509k) {
            return f8Var.b(this, N(f8Var.f()));
        }
        return f8Var.a(this, N(f8Var.f()));
    }

    public final h2 D(IntFunction intFunction) {
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.h = true;
        if (this.f9503a.f9509k && this.f9504b != null && L()) {
            this.e = 0;
            a aVar = this.f9504b;
            return J(aVar, aVar.N(0), intFunction);
        }
        return B(N(0), true, intFunction);
    }

    public final Spliterator O() {
        a aVar = this.f9503a;
        if (this != aVar) {
            throw new IllegalStateException();
        }
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.h = true;
        Spliterator spliterator = aVar.g;
        if (spliterator != null) {
            aVar.g = null;
            return spliterator;
        }
        throw new IllegalStateException("source already consumed or closed");
    }

    @Override // j$.util.stream.g
    public final g sequential() {
        this.f9503a.f9509k = false;
        return this;
    }

    @Override // j$.util.stream.g
    public final g parallel() {
        this.f9503a.f9509k = true;
        return this;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.h = true;
        this.g = null;
        a aVar = this.f9503a;
        Runnable runnable = aVar.f9508j;
        if (runnable != null) {
            aVar.f9508j = null;
            runnable.run();
        }
    }

    @Override // j$.util.stream.g
    public final g onClose(Runnable runnable) {
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        Objects.requireNonNull(runnable);
        a aVar = this.f9503a;
        Runnable runnable2 = aVar.f9508j;
        if (runnable2 != null) {
            runnable = new e8(runnable2, runnable);
        }
        aVar.f9508j = runnable;
        return this;
    }

    @Override // j$.util.stream.g
    public Spliterator spliterator() {
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.h = true;
        a aVar = this.f9503a;
        if (this == aVar) {
            Spliterator spliterator = aVar.g;
            if (spliterator != null) {
                aVar.g = null;
                return spliterator;
            }
            throw new IllegalStateException("source already consumed or closed");
        }
        return P(this, new j$.util.q(2, this), aVar.f9509k);
    }

    public final h2 B(Spliterator spliterator, boolean z9, IntFunction intFunction) {
        if (this.f9503a.f9509k) {
            return E(this, spliterator, z9, intFunction);
        }
        z1 z1VarI = I(F(spliterator), intFunction);
        Q(spliterator, z1VarI);
        return z1VarI.build();
    }

    @Override // j$.util.stream.g
    public final boolean isParallel() {
        return this.f9503a.f9509k;
    }

    public final Spliterator N(int i10) {
        int i11;
        int i12;
        a aVar = this.f9503a;
        Spliterator spliteratorK = aVar.g;
        if (spliteratorK != null) {
            aVar.g = null;
            if (aVar.f9509k && aVar.f9507i) {
                a aVar2 = aVar.f9506d;
                int i13 = 1;
                while (aVar != this) {
                    int i14 = aVar2.f9505c;
                    if (aVar2.L()) {
                        if (z6.SHORT_CIRCUIT.j(i14)) {
                            i14 &= ~z6.f9830u;
                        }
                        spliteratorK = aVar2.K(aVar, spliteratorK);
                        if (spliteratorK.hasCharacteristics(64)) {
                            i11 = (~z6.t) & i14;
                            i12 = z6.f9829s;
                        } else {
                            i11 = (~z6.f9829s) & i14;
                            i12 = z6.t;
                        }
                        i14 = i11 | i12;
                        i13 = 0;
                    }
                    int i15 = i13 + 1;
                    aVar2.e = i13;
                    aVar2.f = z6.e(i14, aVar.f);
                    a aVar3 = aVar2;
                    aVar2 = aVar2.f9506d;
                    aVar = aVar3;
                    i13 = i15;
                }
            }
            if (i10 != 0) {
                this.f = z6.e(i10, this.f);
            }
            return spliteratorK;
        }
        throw new IllegalStateException("source already consumed or closed");
    }

    public final long F(Spliterator spliterator) {
        if (z6.SIZED.j(this.f)) {
            return spliterator.getExactSizeIfKnown();
        }
        return -1L;
    }

    public final m5 Q(Spliterator spliterator, m5 m5Var) {
        z(spliterator, R((m5) Objects.requireNonNull(m5Var)));
        return m5Var;
    }

    public final void z(Spliterator spliterator, m5 m5Var) {
        Objects.requireNonNull(m5Var);
        if (!z6.SHORT_CIRCUIT.j(this.f)) {
            m5Var.c(spliterator.getExactSizeIfKnown());
            spliterator.forEachRemaining(m5Var);
            m5Var.end();
            return;
        }
        A(spliterator, m5Var);
    }

    public final boolean A(Spliterator spliterator, m5 m5Var) {
        a aVar = this;
        while (aVar.e > 0) {
            aVar = aVar.f9504b;
        }
        m5Var.c(spliterator.getExactSizeIfKnown());
        boolean zG = aVar.G(spliterator, m5Var);
        m5Var.end();
        return zG;
    }

    public final m5 R(m5 m5Var) {
        Objects.requireNonNull(m5Var);
        for (a aVar = this; aVar.e > 0; aVar = aVar.f9504b) {
            m5Var = aVar.M(aVar.f9504b.f, m5Var);
        }
        return m5Var;
    }

    public final Spliterator S(Spliterator spliterator) {
        return this.e == 0 ? spliterator : P(this, new j$.util.q(3, spliterator), this.f9503a.f9509k);
    }

    public h2 J(a aVar, Spliterator spliterator, IntFunction intFunction) {
        throw new UnsupportedOperationException("Parallel evaluation is not supported");
    }

    public Spliterator K(a aVar, Spliterator spliterator) {
        return J(aVar, spliterator, new j$.time.format.a(8)).spliterator();
    }
}

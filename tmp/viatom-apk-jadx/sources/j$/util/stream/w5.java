package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.function.IntFunction;

/* loaded from: classes2.dex */
public final class w5 extends b {

    /* renamed from: j, reason: collision with root package name */
    public final a f9790j;

    /* renamed from: k, reason: collision with root package name */
    public final IntFunction f9791k;

    /* renamed from: l, reason: collision with root package name */
    public final long f9792l;

    /* renamed from: m, reason: collision with root package name */
    public final long f9793m;

    /* renamed from: n, reason: collision with root package name */
    public long f9794n;

    /* renamed from: o, reason: collision with root package name */
    public volatile boolean f9795o;

    @Override // j$.util.stream.b
    public final void f() {
        this.f9518i = true;
        if (this.f9795o) {
            d(w3.H(this.f9790j.H()));
        }
    }

    @Override // j$.util.stream.d, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        w5 w5Var;
        h2 h2VarH;
        d dVar = this.f9552d;
        if (dVar != null) {
            this.f9794n = ((w5) dVar).f9794n + ((w5) this.e).f9794n;
            if (this.f9518i) {
                this.f9794n = 0L;
                h2VarH = w3.H(this.f9790j.H());
            } else {
                h2VarH = this.f9794n == 0 ? w3.H(this.f9790j.H()) : ((w5) this.f9552d).f9794n == 0 ? (h2) ((w5) this.e).i() : w3.F(this.f9790j.H(), (h2) ((w5) this.f9552d).i(), (h2) ((w5) this.e).i());
            }
            h2 h2VarJ = h2VarH;
            if (b()) {
                h2VarJ = h2VarJ.j(this.f9792l, this.f9793m >= 0 ? Math.min(h2VarJ.count(), this.f9792l + this.f9793m) : this.f9794n, this.f9791k);
            }
            d(h2VarJ);
            this.f9795o = true;
        }
        if (this.f9793m >= 0 && !b()) {
            long j10 = this.f9792l + this.f9793m;
            long j11 = this.f9795o ? this.f9794n : j(j10);
            if (j11 >= j10) {
                g();
            } else {
                w5 w5Var2 = (w5) ((d) getCompleter());
                w5 w5Var3 = this;
                while (true) {
                    if (w5Var2 == null) {
                        if (j11 >= j10) {
                            break;
                        }
                    } else {
                        if (w5Var3 == w5Var2.e && (w5Var = (w5) w5Var2.f9552d) != null) {
                            long j12 = w5Var.j(j10) + j11;
                            if (j12 >= j10) {
                                break;
                            } else {
                                j11 = j12;
                            }
                        }
                        w5Var3 = w5Var2;
                        w5Var2 = (w5) ((d) w5Var2.getCompleter());
                    }
                }
                g();
            }
        }
        super.onCompletion(countedCompleter);
    }

    public w5(a aVar, a aVar2, Spliterator spliterator, IntFunction intFunction, long j10, long j11) {
        super(aVar2, spliterator);
        this.f9790j = aVar;
        this.f9791k = intFunction;
        this.f9792l = j10;
        this.f9793m = j11;
    }

    public w5(w5 w5Var, Spliterator spliterator) {
        super(w5Var, spliterator);
        this.f9790j = w5Var.f9790j;
        this.f9791k = w5Var.f9791k;
        this.f9792l = w5Var.f9792l;
        this.f9793m = w5Var.f9793m;
    }

    @Override // j$.util.stream.d
    public final d c(Spliterator spliterator) {
        return new w5(this, spliterator);
    }

    @Override // j$.util.stream.b
    public final Object h() {
        return w3.H(this.f9790j.H());
    }

    @Override // j$.util.stream.d
    public final Object a() {
        if (b()) {
            z6 z6Var = z6.SIZED;
            a aVar = this.f9790j;
            int i10 = aVar.f9505c;
            int i11 = z6Var.e;
            z1 z1VarI = this.f9790j.I((i10 & i11) == i11 ? aVar.F(this.f9550b) : -1L, this.f9791k);
            m5 m5VarM = this.f9790j.M(this.f9549a.f, z1VarI);
            a aVar2 = this.f9549a;
            aVar2.A(this.f9550b, aVar2.R(m5VarM));
            return z1VarI.build();
        }
        z1 z1VarI2 = this.f9790j.I(-1L, this.f9791k);
        if (this.f9792l == 0) {
            m5 m5VarM2 = this.f9790j.M(this.f9549a.f, z1VarI2);
            a aVar3 = this.f9549a;
            aVar3.A(this.f9550b, aVar3.R(m5VarM2));
        } else {
            this.f9549a.Q(this.f9550b, z1VarI2);
        }
        h2 h2VarBuild = z1VarI2.build();
        this.f9794n = h2VarBuild.count();
        this.f9795o = true;
        this.f9550b = null;
        return h2VarBuild;
    }

    public final long j(long j10) {
        if (this.f9795o) {
            return this.f9794n;
        }
        w5 w5Var = (w5) this.f9552d;
        w5 w5Var2 = (w5) this.e;
        if (w5Var == null || w5Var2 == null) {
            return this.f9794n;
        }
        long j11 = w5Var.j(j10);
        return j11 >= j10 ? j11 : w5Var2.j(j10) + j11;
    }
}

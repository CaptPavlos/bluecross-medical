package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.function.IntFunction;

/* loaded from: classes2.dex */
public final class s8 extends d {
    public final a h;

    /* renamed from: i, reason: collision with root package name */
    public final IntFunction f9735i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f9736j;

    /* renamed from: k, reason: collision with root package name */
    public long f9737k;

    /* renamed from: l, reason: collision with root package name */
    public long f9738l;

    @Override // j$.util.stream.d, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        d dVar = this.f9552d;
        if (dVar != null) {
            if (this.f9736j) {
                s8 s8Var = (s8) dVar;
                long j10 = s8Var.f9738l;
                this.f9738l = j10;
                if (j10 == s8Var.f9737k) {
                    this.f9738l = j10 + ((s8) this.e).f9738l;
                }
            }
            s8 s8Var2 = (s8) dVar;
            long j11 = s8Var2.f9737k;
            s8 s8Var3 = (s8) this.e;
            this.f9737k = j11 + s8Var3.f9737k;
            h2 h2VarF = s8Var2.f9737k == 0 ? (h2) s8Var3.f : s8Var3.f9737k == 0 ? (h2) s8Var2.f : w3.F(this.h.H(), (h2) ((s8) this.f9552d).f, (h2) ((s8) this.e).f);
            if (b() && this.f9736j) {
                h2VarF = h2VarF.j(this.f9738l, h2VarF.count(), this.f9735i);
            }
            this.f = h2VarF;
        }
        super.onCompletion(countedCompleter);
    }

    public s8(a aVar, a aVar2, Spliterator spliterator, IntFunction intFunction) {
        super(aVar2, spliterator);
        this.h = aVar;
        this.f9735i = intFunction;
        this.f9736j = z6.ORDERED.j(aVar2.f);
    }

    public s8(s8 s8Var, Spliterator spliterator) {
        super(s8Var, spliterator);
        this.h = s8Var.h;
        this.f9735i = s8Var.f9735i;
        this.f9736j = s8Var.f9736j;
    }

    @Override // j$.util.stream.d
    public final d c(Spliterator spliterator) {
        return new s8(this, spliterator);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    @Override // j$.util.stream.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a() {
        /*
            r5 = this;
            boolean r0 = r5.b()
            if (r0 != 0) goto L1c
            boolean r1 = r5.f9736j
            if (r1 == 0) goto L1c
            j$.util.stream.z6 r1 = j$.util.stream.z6.SIZED
            j$.util.stream.a r2 = r5.h
            int r3 = r2.f9505c
            int r1 = r1.e
            r3 = r3 & r1
            if (r3 != r1) goto L1c
            j$.util.Spliterator r1 = r5.f9550b
            long r1 = r2.F(r1)
            goto L1e
        L1c:
            r1 = -1
        L1e:
            j$.util.stream.a r3 = r5.f9549a
            java.util.function.IntFunction r4 = r5.f9735i
            j$.util.stream.z1 r1 = r3.I(r1, r4)
            j$.util.stream.a r2 = r5.h
            j$.util.stream.q8 r2 = (j$.util.stream.q8) r2
            boolean r3 = r5.f9736j
            if (r3 == 0) goto L32
            if (r0 != 0) goto L32
            r0 = 1
            goto L33
        L32:
            r0 = 0
        L33:
            j$.util.stream.r8 r0 = r2.g(r1, r0)
            j$.util.stream.a r2 = r5.f9549a
            j$.util.Spliterator r3 = r5.f9550b
            r2.Q(r3, r0)
            j$.util.stream.h2 r1 = r1.build()
            long r2 = r1.count()
            r5.f9737k = r2
            long r2 = r0.h()
            r5.f9738l = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.s8.a():java.lang.Object");
    }
}

package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.IntFunction;

/* loaded from: classes2.dex */
public final class t8 extends b {

    /* renamed from: j, reason: collision with root package name */
    public final a f9751j;

    /* renamed from: k, reason: collision with root package name */
    public final IntFunction f9752k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f9753l;

    /* renamed from: m, reason: collision with root package name */
    public long f9754m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f9755n;

    /* renamed from: o, reason: collision with root package name */
    public volatile boolean f9756o;

    @Override // j$.util.stream.b
    public final void f() {
        this.f9518i = true;
        if (this.f9753l && this.f9756o) {
            d(w3.H(this.f9751j.H()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    @Override // j$.util.stream.d, java.util.concurrent.CountedCompleter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCompletion(java.util.concurrent.CountedCompleter r9) {
        /*
            r8 = this;
            j$.util.stream.d r0 = r8.f9552d
            if (r0 != 0) goto L6
            goto L8b
        L6:
            j$.util.stream.t8 r0 = (j$.util.stream.t8) r0
            boolean r0 = r0.f9755n
            j$.util.stream.d r1 = r8.e
            j$.util.stream.t8 r1 = (j$.util.stream.t8) r1
            boolean r1 = r1.f9755n
            r0 = r0 | r1
            r8.f9755n = r0
            boolean r0 = r8.f9753l
            r1 = 0
            if (r0 == 0) goto L2a
            boolean r0 = r8.f9518i
            if (r0 == 0) goto L2a
            r8.f9754m = r1
            j$.util.stream.a r0 = r8.f9751j
            j$.util.stream.a7 r0 = r0.H()
            j$.util.stream.a3 r0 = j$.util.stream.w3.H(r0)
            goto L88
        L2a:
            boolean r0 = r8.f9753l
            if (r0 == 0) goto L41
            j$.util.stream.d r0 = r8.f9552d
            j$.util.stream.t8 r0 = (j$.util.stream.t8) r0
            boolean r3 = r0.f9755n
            if (r3 == 0) goto L41
            long r1 = r0.f9754m
            r8.f9754m = r1
            java.lang.Object r0 = r0.i()
            j$.util.stream.h2 r0 = (j$.util.stream.h2) r0
            goto L88
        L41:
            j$.util.stream.d r0 = r8.f9552d
            j$.util.stream.t8 r0 = (j$.util.stream.t8) r0
            long r3 = r0.f9754m
            j$.util.stream.d r5 = r8.e
            j$.util.stream.t8 r5 = (j$.util.stream.t8) r5
            long r6 = r5.f9754m
            long r3 = r3 + r6
            r8.f9754m = r3
            long r3 = r0.f9754m
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 != 0) goto L5d
            java.lang.Object r0 = r5.i()
            j$.util.stream.h2 r0 = (j$.util.stream.h2) r0
            goto L88
        L5d:
            long r3 = r5.f9754m
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 != 0) goto L6a
            java.lang.Object r0 = r0.i()
            j$.util.stream.h2 r0 = (j$.util.stream.h2) r0
            goto L88
        L6a:
            j$.util.stream.a r0 = r8.f9751j
            j$.util.stream.a7 r0 = r0.H()
            j$.util.stream.d r1 = r8.f9552d
            j$.util.stream.t8 r1 = (j$.util.stream.t8) r1
            java.lang.Object r1 = r1.i()
            j$.util.stream.h2 r1 = (j$.util.stream.h2) r1
            j$.util.stream.d r2 = r8.e
            j$.util.stream.t8 r2 = (j$.util.stream.t8) r2
            java.lang.Object r2 = r2.i()
            j$.util.stream.h2 r2 = (j$.util.stream.h2) r2
            j$.util.stream.j2 r0 = j$.util.stream.w3.F(r0, r1, r2)
        L88:
            r8.d(r0)
        L8b:
            r0 = 1
            r8.f9756o = r0
            super.onCompletion(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.t8.onCompletion(java.util.concurrent.CountedCompleter):void");
    }

    public t8(a aVar, a aVar2, Spliterator spliterator, IntFunction intFunction) {
        super(aVar2, spliterator);
        this.f9751j = aVar;
        this.f9752k = intFunction;
        this.f9753l = z6.ORDERED.j(aVar2.f);
    }

    public t8(t8 t8Var, Spliterator spliterator) {
        super(t8Var, spliterator);
        this.f9751j = t8Var.f9751j;
        this.f9752k = t8Var.f9752k;
        this.f9753l = t8Var.f9753l;
    }

    @Override // j$.util.stream.d
    public final d c(Spliterator spliterator) {
        return new t8(this, spliterator);
    }

    @Override // j$.util.stream.b
    public final Object h() {
        return w3.H(this.f9751j.H());
    }

    @Override // j$.util.stream.d
    public final Object a() {
        z1 z1VarI = this.f9549a.I(-1L, this.f9752k);
        m5 m5VarM = this.f9751j.M(this.f9549a.f, z1VarI);
        a aVar = this.f9549a;
        boolean zA = aVar.A(this.f9550b, aVar.R(m5VarM));
        this.f9755n = zA;
        if (zA) {
            g();
        }
        h2 h2VarBuild = z1VarI.build();
        this.f9754m = h2VarBuild.count();
        return h2VarBuild;
    }
}

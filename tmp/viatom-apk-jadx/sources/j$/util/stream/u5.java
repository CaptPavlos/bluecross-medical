package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.IntFunction;

/* loaded from: classes2.dex */
public final class u5 extends z {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f9763l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f9764m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u5(b0 b0Var, int i10, long j10, long j11) {
        super(b0Var, i10);
        this.f9763l = j10;
        this.f9764m = j11;
    }

    @Override // j$.util.stream.a
    public final Spliterator K(a aVar, Spliterator spliterator) {
        long jF = aVar.F(spliterator);
        if (jF > 0 && spliterator.hasCharacteristics(16384)) {
            j$.util.v0 v0Var = (j$.util.v0) aVar.S(spliterator);
            long j10 = this.f9763l;
            return new p7(v0Var, j10, w3.A(j10, this.f9764m));
        }
        if (z6.ORDERED.j(aVar.f)) {
            return ((h2) new w5(this, aVar, spliterator, new d1(20), this.f9763l, this.f9764m).invoke()).spliterator();
        }
        j$.util.v0 v0Var2 = (j$.util.v0) aVar.S(spliterator);
        long j11 = this.f9763l;
        long j12 = this.f9764m;
        if (j11 <= jF) {
            long jMin = jF - j11;
            if (j12 >= 0) {
                jMin = Math.min(j12, jMin);
            }
            j12 = jMin;
            j11 = 0;
        }
        return new v7(v0Var2, j11, j12);
    }

    @Override // j$.util.stream.a
    public final h2 J(a aVar, Spliterator spliterator, IntFunction intFunction) {
        long jMin;
        long j10;
        long jF = aVar.F(spliterator);
        if (jF > 0 && spliterator.hasCharacteristics(16384)) {
            a aVar2 = aVar;
            while (aVar2.e > 0) {
                aVar2 = aVar2.f9504b;
            }
            return w3.C(aVar, w3.y(aVar2.H(), spliterator, this.f9763l, this.f9764m), true);
        }
        if (!z6.ORDERED.j(aVar.f)) {
            j$.util.v0 v0Var = (j$.util.v0) aVar.S(spliterator);
            long j11 = this.f9763l;
            long j12 = this.f9764m;
            if (j11 <= jF) {
                long j13 = jF - j11;
                jMin = j12 >= 0 ? Math.min(j12, j13) : j13;
                j10 = 0;
            } else {
                jMin = j12;
                j10 = j11;
            }
            return w3.C(this, new v7(v0Var, j10, jMin), true);
        }
        return (h2) new w5(this, aVar, spliterator, intFunction, this.f9763l, this.f9764m).invoke();
    }

    @Override // j$.util.stream.a
    public final m5 M(int i10, m5 m5Var) {
        return new t5(this, m5Var);
    }
}

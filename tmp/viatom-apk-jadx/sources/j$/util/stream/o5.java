package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.IntFunction;

/* loaded from: classes2.dex */
public final class o5 extends c5 {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f9696l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f9697m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o5(e5 e5Var, int i10, long j10, long j11) {
        super(e5Var, i10);
        this.f9696l = j10;
        this.f9697m = j11;
    }

    @Override // j$.util.stream.a
    public final Spliterator K(a aVar, Spliterator spliterator) {
        long jF = aVar.F(spliterator);
        if (jF > 0 && spliterator.hasCharacteristics(16384)) {
            Spliterator spliteratorS = aVar.S(spliterator);
            long j10 = this.f9696l;
            return new t7(spliteratorS, j10, w3.A(j10, this.f9697m));
        }
        if (z6.ORDERED.j(aVar.f)) {
            return ((h2) new w5(this, aVar, spliterator, new d1(9), this.f9696l, this.f9697m).invoke()).spliterator();
        }
        Spliterator spliteratorS2 = aVar.S(spliterator);
        long j11 = this.f9696l;
        long j12 = this.f9697m;
        if (j11 <= jF) {
            long jMin = jF - j11;
            if (j12 >= 0) {
                jMin = Math.min(j12, jMin);
            }
            j12 = jMin;
            j11 = 0;
        }
        return new z7(spliteratorS2, j11, j12);
    }

    @Override // j$.util.stream.a
    public final h2 J(a aVar, Spliterator spliterator, IntFunction intFunction) {
        long jMin;
        long j10;
        long jF = aVar.F(spliterator);
        if (jF <= 0 || !spliterator.hasCharacteristics(16384)) {
            if (!z6.ORDERED.j(aVar.f)) {
                Spliterator spliteratorS = aVar.S(spliterator);
                long j11 = this.f9696l;
                long j12 = this.f9697m;
                if (j11 <= jF) {
                    long j13 = jF - j11;
                    jMin = j12 >= 0 ? Math.min(j12, j13) : j13;
                    j10 = 0;
                } else {
                    jMin = j12;
                    j10 = j11;
                }
                return w3.B(this, new z7(spliteratorS, j10, jMin), true, intFunction);
            }
            return (h2) new w5(this, aVar, spliterator, intFunction, this.f9696l, this.f9697m).invoke();
        }
        a aVar2 = aVar;
        while (aVar2.e > 0) {
            aVar2 = aVar2.f9504b;
        }
        return w3.B(aVar, w3.y(aVar2.H(), spliterator, this.f9696l, this.f9697m), true, intFunction);
    }

    @Override // j$.util.stream.a
    public final m5 M(int i10, m5 m5Var) {
        return new n5(this, m5Var);
    }
}

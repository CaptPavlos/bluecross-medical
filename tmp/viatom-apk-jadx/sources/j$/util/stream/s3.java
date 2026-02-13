package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import java.util.concurrent.CountedCompleter;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public abstract class s3 extends CountedCompleter implements m5 {

    /* renamed from: a, reason: collision with root package name */
    public final Spliterator f9728a;

    /* renamed from: b, reason: collision with root package name */
    public final a f9729b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9730c;

    /* renamed from: d, reason: collision with root package name */
    public final long f9731d;
    public final long e;
    public int f;
    public int g;

    public abstract s3 a(Spliterator spliterator, long j10, long j11);

    public /* synthetic */ void accept(double d8) {
        w3.c();
        throw null;
    }

    public /* synthetic */ void accept(int i10) {
        w3.k();
        throw null;
    }

    public /* synthetic */ void accept(long j10) {
        w3.l();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ boolean e() {
        return false;
    }

    @Override // j$.util.stream.m5
    public final /* synthetic */ void end() {
    }

    public s3(Spliterator spliterator, a aVar, int i10) {
        this.f9728a = spliterator;
        this.f9729b = aVar;
        this.f9730c = d.e(spliterator.estimateSize());
        this.f9731d = 0L;
        this.e = i10;
    }

    public s3(s3 s3Var, Spliterator spliterator, long j10, long j11, int i10) {
        super(s3Var);
        this.f9728a = spliterator;
        this.f9729b = s3Var.f9729b;
        this.f9730c = s3Var.f9730c;
        this.f9731d = j10;
        this.e = j11;
        if (j10 < 0 || j11 < 0 || (j10 + j11) - 1 >= i10) {
            throw new IllegalArgumentException(String.format("offset and length interval [%d, %d + %d) is not within array size interval [0, %d)", Long.valueOf(j10), Long.valueOf(j10), Long.valueOf(j11), Integer.valueOf(i10)));
        }
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        Spliterator spliteratorTrySplit;
        Spliterator spliterator = this.f9728a;
        s3 s3VarA = this;
        while (spliterator.estimateSize() > s3VarA.f9730c && (spliteratorTrySplit = spliterator.trySplit()) != null) {
            s3VarA.setPendingCount(1);
            long jEstimateSize = spliteratorTrySplit.estimateSize();
            s3 s3Var = s3VarA;
            s3Var.a(spliteratorTrySplit, s3VarA.f9731d, jEstimateSize).fork();
            s3VarA = s3Var.a(spliterator, s3Var.f9731d + jEstimateSize, s3Var.e - jEstimateSize);
        }
        s3 s3Var2 = s3VarA;
        s3Var2.f9729b.Q(spliterator, s3Var2);
        s3Var2.propagateCompletion();
    }

    @Override // j$.util.stream.m5
    public final void c(long j10) {
        long j11 = this.e;
        if (j10 > j11) {
            throw new IllegalStateException("size passed to Sink.begin exceeds array length");
        }
        int i10 = (int) this.f9731d;
        this.f = i10;
        this.g = i10 + ((int) j11);
    }
}

package j$.time.chrono;

/* loaded from: classes2.dex */
public interface b extends j$.time.temporal.m, j$.time.temporal.o, Comparable {
    @Override // j$.time.temporal.m
    b a(long j10, j$.time.temporal.q qVar);

    @Override // j$.time.temporal.m
    b b(long j10, j$.time.temporal.s sVar);

    @Override // j$.time.temporal.n
    boolean c(j$.time.temporal.q qVar);

    l getChronology();

    int hashCode();

    long r();

    e s(j$.time.k kVar);

    String toString();

    /* renamed from: u */
    int compareTo(b bVar);
}

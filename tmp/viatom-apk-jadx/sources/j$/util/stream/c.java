package j$.util.stream;

/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f9532a;

    /* renamed from: b, reason: collision with root package name */
    public int f9533b;

    /* renamed from: c, reason: collision with root package name */
    public int f9534c;

    /* renamed from: d, reason: collision with root package name */
    public long[] f9535d;

    public abstract void clear();

    public c() {
        this.f9532a = 4;
    }

    public c(int i10) {
        if (i10 < 0) {
            j$.time.g.i("Illegal Capacity: ", i10);
            throw null;
        }
        this.f9532a = Math.max(4, 32 - Integer.numberOfLeadingZeros(i10 - 1));
    }

    public final long count() {
        int i10 = this.f9534c;
        if (i10 == 0) {
            return this.f9533b;
        }
        return this.f9535d[i10] + this.f9533b;
    }
}

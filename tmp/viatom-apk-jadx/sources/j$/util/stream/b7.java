package j$.util.stream;

import j$.util.Spliterator;
import java.util.Comparator;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public abstract class b7 implements Spliterator {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f9523a;

    /* renamed from: b, reason: collision with root package name */
    public final a f9524b;

    /* renamed from: c, reason: collision with root package name */
    public Supplier f9525c;

    /* renamed from: d, reason: collision with root package name */
    public Spliterator f9526d;
    public m5 e;
    public BooleanSupplier f;
    public long g;
    public c h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f9527i;

    public abstract void d();

    public abstract b7 e(Spliterator spliterator);

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i10) {
        return j$.util.c.e(this, i10);
    }

    public b7(a aVar, Supplier supplier, boolean z9) {
        this.f9524b = aVar;
        this.f9525c = supplier;
        this.f9526d = null;
        this.f9523a = z9;
    }

    public b7(a aVar, Spliterator spliterator, boolean z9) {
        this.f9524b = aVar;
        this.f9525c = null;
        this.f9526d = spliterator;
        this.f9523a = z9;
    }

    public final void c() {
        if (this.f9526d == null) {
            this.f9526d = (Spliterator) this.f9525c.get();
            this.f9525c = null;
        }
    }

    public final boolean a() {
        c cVar = this.h;
        if (cVar == null) {
            if (this.f9527i) {
                return false;
            }
            c();
            d();
            this.g = 0L;
            this.e.c(this.f9526d.getExactSizeIfKnown());
            return b();
        }
        long j10 = this.g + 1;
        this.g = j10;
        boolean z9 = j10 < cVar.count();
        if (z9) {
            return z9;
        }
        this.g = 0L;
        this.h.clear();
        return b();
    }

    @Override // j$.util.Spliterator
    public Spliterator trySplit() {
        if (!this.f9523a || this.h != null || this.f9527i) {
            return null;
        }
        c();
        Spliterator spliteratorTrySplit = this.f9526d.trySplit();
        if (spliteratorTrySplit == null) {
            return null;
        }
        return e(spliteratorTrySplit);
    }

    public final boolean b() {
        while (this.h.count() == 0) {
            if (this.e.e() || !this.f.getAsBoolean()) {
                if (this.f9527i) {
                    return false;
                }
                this.e.end();
                this.f9527i = true;
            }
        }
        return true;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        c();
        return this.f9526d.estimateSize();
    }

    @Override // j$.util.Spliterator
    public final long getExactSizeIfKnown() {
        c();
        if (z6.SIZED.j(this.f9524b.f)) {
            return this.f9526d.getExactSizeIfKnown();
        }
        return -1L;
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        c();
        int i10 = this.f9524b.f;
        int i11 = i10 & ((~i10) >> 1) & z6.f9820j & z6.f;
        return (i11 & 64) != 0 ? (i11 & (-16449)) | (this.f9526d.characteristics() & 16448) : i11;
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        if (j$.util.c.e(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }

    public final String toString() {
        return String.format("%s[%s]", getClass().getName(), this.f9526d);
    }
}

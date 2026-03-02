package j$.util.stream;

import j$.util.Spliterator;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;

/* loaded from: classes2.dex */
public abstract class k3 implements Spliterator {

    /* renamed from: a, reason: collision with root package name */
    public h2 f9639a;

    /* renamed from: b, reason: collision with root package name */
    public int f9640b;

    /* renamed from: c, reason: collision with root package name */
    public Spliterator f9641c;

    /* renamed from: d, reason: collision with root package name */
    public Spliterator f9642d;
    public Deque e;

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return 64;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return j$.util.c.d(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i10) {
        return j$.util.c.e(this, i10);
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public k3(h2 h2Var) {
        this.f9639a = h2Var;
    }

    public final Deque b() {
        ArrayDeque arrayDeque = new ArrayDeque(8);
        int iO = this.f9639a.o();
        while (true) {
            iO--;
            if (iO < this.f9640b) {
                return arrayDeque;
            }
            arrayDeque.addFirst(this.f9639a.a(iO));
        }
    }

    public static h2 a(Deque deque) {
        while (true) {
            ArrayDeque arrayDeque = (ArrayDeque) deque;
            h2 h2Var = (h2) arrayDeque.pollFirst();
            if (h2Var == null) {
                return null;
            }
            if (h2Var.o() != 0) {
                for (int iO = h2Var.o() - 1; iO >= 0; iO--) {
                    arrayDeque.addFirst(h2Var.a(iO));
                }
            } else if (h2Var.count() > 0) {
                return h2Var;
            }
        }
    }

    public final boolean c() {
        if (this.f9639a == null) {
            return false;
        }
        if (this.f9642d != null) {
            return true;
        }
        Spliterator spliterator = this.f9641c;
        if (spliterator == null) {
            Deque dequeB = b();
            this.e = dequeB;
            h2 h2VarA = a(dequeB);
            if (h2VarA != null) {
                this.f9642d = h2VarA.spliterator();
                return true;
            }
            this.f9639a = null;
            return false;
        }
        this.f9642d = spliterator;
        return true;
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        h2 h2Var = this.f9639a;
        if (h2Var == null || this.f9642d != null) {
            return null;
        }
        Spliterator spliterator = this.f9641c;
        if (spliterator != null) {
            return spliterator.trySplit();
        }
        int i10 = this.f9640b;
        int iO = h2Var.o() - 1;
        h2 h2Var2 = this.f9639a;
        int i11 = this.f9640b;
        if (i10 < iO) {
            this.f9640b = i11 + 1;
            return h2Var2.a(i11).spliterator();
        }
        h2 h2VarA = h2Var2.a(i11);
        this.f9639a = h2VarA;
        int iO2 = h2VarA.o();
        h2 h2Var3 = this.f9639a;
        if (iO2 == 0) {
            Spliterator spliterator2 = h2Var3.spliterator();
            this.f9641c = spliterator2;
            return spliterator2.trySplit();
        }
        this.f9640b = 1;
        return h2Var3.a(0).spliterator();
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        long jCount = 0;
        if (this.f9639a == null) {
            return 0L;
        }
        Spliterator spliterator = this.f9641c;
        if (spliterator != null) {
            return spliterator.estimateSize();
        }
        for (int i10 = this.f9640b; i10 < this.f9639a.o(); i10++) {
            jCount += this.f9639a.a(i10).count();
        }
        return jCount;
    }

    @Override // j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.e1 trySplit() {
        return (j$.util.e1) trySplit();
    }

    @Override // j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.y0 trySplit() {
        return (j$.util.y0) trySplit();
    }

    @Override // j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.b1 trySplit() {
        return (j$.util.b1) trySplit();
    }

    @Override // j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.v0 trySplit() {
        return (j$.util.v0) trySplit();
    }
}

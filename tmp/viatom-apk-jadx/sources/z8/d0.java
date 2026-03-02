package z8;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class d0 {

    /* renamed from: a, reason: collision with root package name */
    public static final c0 f14470a = new c0(new byte[0], 0, 0, false);

    /* renamed from: b, reason: collision with root package name */
    public static final int f14471b;

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference[] f14472c;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f14471b = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i10 = 0; i10 < iHighestOneBit; i10++) {
            atomicReferenceArr[i10] = new AtomicReference();
        }
        f14472c = atomicReferenceArr;
    }

    public static final void a(c0 c0Var) {
        c0Var.getClass();
        if (c0Var.f != null || c0Var.g != null) {
            com.google.gson.internal.a.n("Failed requirement.");
            return;
        }
        if (c0Var.f14465d) {
            return;
        }
        AtomicReference atomicReference = f14472c[(int) (Thread.currentThread().getId() & (f14471b - 1))];
        c0 c0Var2 = f14470a;
        c0 c0Var3 = (c0) atomicReference.getAndSet(c0Var2);
        if (c0Var3 == c0Var2) {
            return;
        }
        int i10 = c0Var3 != null ? c0Var3.f14464c : 0;
        if (i10 >= 65536) {
            atomicReference.set(c0Var3);
            return;
        }
        c0Var.f = c0Var3;
        c0Var.f14463b = 0;
        c0Var.f14464c = i10 + 8192;
        atomicReference.set(c0Var);
    }

    public static final c0 b() {
        AtomicReference atomicReference = f14472c[(int) (Thread.currentThread().getId() & (f14471b - 1))];
        c0 c0Var = f14470a;
        c0 c0Var2 = (c0) atomicReference.getAndSet(c0Var);
        if (c0Var2 == c0Var) {
            return new c0();
        }
        if (c0Var2 == null) {
            atomicReference.set(null);
            return new c0();
        }
        atomicReference.set(c0Var2.f);
        c0Var2.f = null;
        c0Var2.f14464c = 0;
        return c0Var2;
    }
}

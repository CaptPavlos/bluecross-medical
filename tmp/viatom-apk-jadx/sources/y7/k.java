package y7;

import r7.s;
import w7.o;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k extends s {

    /* renamed from: a, reason: collision with root package name */
    public static final k f14128a = new k();

    @Override // r7.s
    public final void dispatch(w6.h hVar, Runnable runnable) {
        e.f14118b.f14119a.b(runnable, true, false);
    }

    @Override // r7.s
    public final void dispatchYield(w6.h hVar, Runnable runnable) {
        e.f14118b.f14119a.b(runnable, true, true);
    }

    @Override // r7.s
    public final s limitedParallelism(int i10, String str) {
        w7.a.a(i10);
        return i10 >= j.f14127d ? str != null ? new o(this, str) : this : super.limitedParallelism(i10, str);
    }

    @Override // r7.s
    public final String toString() {
        return "Dispatchers.IO";
    }
}

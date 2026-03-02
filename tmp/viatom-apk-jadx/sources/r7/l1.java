package r7;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l1 extends w6.a implements a1 {

    /* renamed from: a, reason: collision with root package name */
    public static final l1 f12412a = new l1(t.f12437b);

    @Override // r7.a1
    public final Object d(w6.c cVar) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // r7.a1
    public final CancellationException e() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // r7.a1
    public final boolean isActive() {
        return true;
    }

    @Override // r7.a1
    public final boolean isCancelled() {
        return false;
    }

    @Override // r7.a1
    public final j j(i1 i1Var) {
        return m1.f12414a;
    }

    @Override // r7.a1
    public final k0 m(boolean z9, boolean z10, d1 d1Var) {
        return m1.f12414a;
    }

    @Override // r7.a1
    public final k0 s(g7.l lVar) {
        return m1.f12414a;
    }

    @Override // r7.a1
    public final boolean start() {
        return false;
    }

    public final String toString() {
        return "NonCancellable";
    }

    @Override // r7.a1
    public final void a(CancellationException cancellationException) {
    }
}

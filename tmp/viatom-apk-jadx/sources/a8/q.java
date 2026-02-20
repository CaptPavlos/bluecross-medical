package a8;

import java.util.concurrent.atomic.AtomicReferenceArray;
import w7.s;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q extends s {
    public final /* synthetic */ AtomicReferenceArray e;

    public q(long j10, q qVar, int i10) {
        super(j10, qVar, i10);
        this.e = new AtomicReferenceArray(p.f);
    }

    @Override // w7.s
    public final int f() {
        return p.f;
    }

    @Override // w7.s
    public final void g(int i10, w6.h hVar) {
        this.e.set(i10, p.e);
        h();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.f13555c + ", hashCode=" + hashCode() + ']';
    }
}

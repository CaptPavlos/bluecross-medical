package j4;

import java.util.concurrent.FutureTask;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a0 extends FutureTask implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final f f9916a;

    public a0(f fVar) {
        super(fVar, null);
        this.f9916a = fVar;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        f fVar = this.f9916a;
        int i10 = fVar.f9955r;
        f fVar2 = ((a0) obj).f9916a;
        int i11 = fVar2.f9955r;
        return i10 == i11 ? fVar.f9942a - fVar2.f9942a : c.i.c(i11) - c.i.c(i10);
    }
}

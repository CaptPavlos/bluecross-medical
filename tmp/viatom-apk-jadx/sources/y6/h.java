package y6;

import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class h extends g implements kotlin.jvm.internal.i {
    private final int arity;

    public h(int i10, w6.c cVar) {
        super(cVar);
        this.arity = i10;
    }

    @Override // kotlin.jvm.internal.i
    public int getArity() {
        return this.arity;
    }

    @Override // y6.a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        y.f10139a.getClass();
        return z.a(this);
    }
}

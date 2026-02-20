package d7;

import g7.p;
import java.util.Iterator;
import n7.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7459a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f7460b;

    public /* synthetic */ b(Object obj, int i10) {
        this.f7459a = i10;
        this.f7460b = obj;
    }

    @Override // n7.f
    public final Iterator iterator() {
        switch (this.f7459a) {
            case 0:
                return new a(this);
            case 1:
                return l1.b.F((p) this.f7460b);
            default:
                return (Iterator) this.f7460b;
        }
    }
}

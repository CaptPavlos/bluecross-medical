package n7;

import g7.p;
import java.util.Iterator;
import r7.q;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d implements f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11574a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Object f11575b;

    /* renamed from: c, reason: collision with root package name */
    public final s6.c f11576c;

    public d(f fVar, g7.l lVar) {
        lVar.getClass();
        this.f11575b = fVar;
        this.f11576c = lVar;
    }

    @Override // n7.f
    public final Iterator iterator() {
        switch (this.f11574a) {
            case 0:
                return new c(this);
            case 1:
                return new e(this);
            case 2:
                return new l(this);
            default:
                return new o7.b(this);
        }
    }

    public d(d dVar, q qVar) {
        this.f11575b = dVar;
        this.f11576c = qVar;
    }

    public d(g7.a aVar, g7.l lVar) {
        lVar.getClass();
        this.f11575b = aVar;
        this.f11576c = lVar;
    }

    public d(CharSequence charSequence, p pVar) {
        charSequence.getClass();
        this.f11575b = charSequence;
        this.f11576c = pVar;
    }
}

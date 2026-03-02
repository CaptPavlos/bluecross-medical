package p;

import a3.z0;
import java.util.Set;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class o implements m.f {

    /* renamed from: a, reason: collision with root package name */
    public final Set f11866a;

    /* renamed from: b, reason: collision with root package name */
    public final i f11867b;

    /* renamed from: c, reason: collision with root package name */
    public final p f11868c;

    public o(Set set, i iVar, p pVar) {
        this.f11866a = set;
        this.f11867b = iVar;
        this.f11868c = pVar;
    }

    public final z0 a(String str, m.c cVar, m.e eVar) {
        Set set = this.f11866a;
        if (set.contains(cVar)) {
            return new z0(this.f11867b, str, cVar, eVar, this.f11868c, 9);
        }
        androidx.core.view.accessibility.a.r("%s is not supported byt this factory. Supported encodings are: %s.", new Object[]{cVar, set});
        return null;
    }
}

package h8;

import com.google.android.gms.internal.measurement.l5;
import g8.b1;
import g8.e0;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v implements c8.b {

    /* renamed from: a, reason: collision with root package name */
    public static final v f8852a = new v();

    /* renamed from: b, reason: collision with root package name */
    public static final u f8853b = u.f8849b;

    @Override // c8.a
    public final Object deserialize(f8.e eVar) {
        eVar.getClass();
        l5.g(eVar);
        b1 b1Var = b1.f8241a;
        m mVar = m.f8840a;
        return new t((Map) new e0(b1.f8241a, m.f8840a).deserialize(eVar));
    }

    @Override // c8.g, c8.a
    public final e8.e getDescriptor() {
        return f8853b;
    }

    @Override // c8.g
    public final void serialize(f8.f fVar, Object obj) {
        t tVar = (t) obj;
        tVar.getClass();
        l5.e(fVar);
        b1 b1Var = b1.f8241a;
        m mVar = m.f8840a;
        new e0(b1.f8241a, m.f8840a).serialize(fVar, tVar);
    }
}

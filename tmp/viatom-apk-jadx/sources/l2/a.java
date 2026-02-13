package l2;

import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements j2.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10191a;

    @Override // j2.a
    public final void a(Object obj, Object obj2) {
        switch (this.f10191a) {
            case 0:
                throw new j2.b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
            case 1:
                Map.Entry entry = (Map.Entry) obj;
                j2.e eVar = (j2.e) obj2;
                eVar.a(m2.f.g, entry.getKey());
                eVar.a(m2.f.h, entry.getValue());
                return;
            default:
                throw new j2.b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }
    }
}

package i4;

import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends f4.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8990a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f8991b;

    public /* synthetic */ a(c cVar, int i10) {
        this.f8990a = i10;
        this.f8991b = cVar;
    }

    @Override // f4.a
    public void c(e4.e eVar) {
        switch (this.f8990a) {
            case 1:
                eVar.getClass();
                c cVar = this.f8991b;
                cVar.setYouTubePlayerReady$core_release(true);
                Iterator it = cVar.f.iterator();
                if (it.hasNext()) {
                    it.next().getClass();
                    com.google.gson.internal.a.k();
                    return;
                }
                cVar.f.clear();
                g gVar = (g) eVar;
                synchronized (gVar.f9004c) {
                    gVar.f9005d.remove(this);
                }
                return;
            default:
                super.c(eVar);
                return;
        }
    }

    @Override // f4.a
    public void d(e4.e eVar, e4.d dVar) {
        switch (this.f8990a) {
            case 0:
                eVar.getClass();
                if (dVar == e4.d.f7658d) {
                    c cVar = this.f8991b;
                    if (!cVar.g && !cVar.f8993a.e) {
                        ((g) eVar).e();
                        break;
                    }
                }
                break;
            default:
                super.d(eVar, dVar);
                break;
        }
    }
}
